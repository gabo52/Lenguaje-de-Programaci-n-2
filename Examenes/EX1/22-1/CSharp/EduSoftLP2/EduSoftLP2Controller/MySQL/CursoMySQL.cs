using EduSoftDBManager;
using EduSoftLP2Controller.DAO;
using EduSoftLP2Model;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Controller.MySQL
{
    public class CursoMySQL : CursoDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public int insertar(Curso curso)
        {
            int resultado = 0;
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "INSERTAR_CURSO";
                comando.Parameters.Add("_id_curso", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_fid_especialidad", curso.Especialidad.IdEspecialidad);
                comando.Parameters.AddWithValue("_nombre", curso.Nombre);
                comando.Parameters.AddWithValue("_clave", curso.Clave);
                comando.Parameters.AddWithValue("_semestre", curso.Semestre);
                comando.Parameters.AddWithValue("_modalidad", curso.Modalidad);
                comando.Parameters.AddWithValue("_req_computadora", curso.ReqComputadora);
                comando.Parameters.AddWithValue("_req_disp_movil", curso.ReqDispMovil);
                comando.Parameters.AddWithValue("_req_disp_especial", curso.ReqDispEspecial);
                comando.Parameters.AddWithValue("_sumilla", curso.Sumilla);
                comando.Parameters.AddWithValue("_foto", curso.Foto);
                comando.Parameters.AddWithValue("_silabo", curso.Silabo);
                comando.ExecuteNonQuery();
                curso.IdCurso = Int32.Parse(
                    comando.Parameters["_id_curso"].Value.ToString());
                foreach (Docente doc in curso.Docentes)
                {
                    comando.Parameters.Clear();
                    comando.CommandText = "INSERTAR_CURSO_DOCENTE";
                    comando.Parameters.Add("_id_curso_docente", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;
                    comando.Parameters.AddWithValue("_fid_curso",
                        curso.IdCurso);
                    comando.Parameters.AddWithValue("_fid_docente",
                        doc.IdDocente);
                    comando.ExecuteNonQuery();
                    doc.IdDocente = Int32.Parse(
                    comando.Parameters["_id_curso_docente"].Value.ToString());
                }
                resultado = curso.IdCurso;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                con.Close();
            }
            return resultado;
        }

        public BindingList<Curso> listarPorNombreClave(string cadena)
        {
            char tipoDoc;
            BindingList<Curso> cursos = new BindingList<Curso>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_CURSOS_POR_NOMBRE_O_CLAVE";
                comando.Parameters.AddWithValue("_nombreClave", cadena);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    
                    Curso curso = new Curso();
                    curso.Especialidad = new Especialidad();
                    curso.IdCurso = lector.GetInt32("id_curso");
                    curso.Especialidad.IdEspecialidad = lector.GetInt32("fid_especialidad");
                    curso.Especialidad.Nombre = lector.GetString("nombre_especialidad");
                    curso.Nombre = lector.GetString("nombre");
                    curso.Clave = lector.GetString("clave");
                    curso.Semestre = lector.GetString("semestre");
                    curso.Modalidad = (Modalidad)Enum.Parse(typeof(Modalidad),lector.GetString("modalidad"));
                    curso.ReqComputadora = lector.GetBoolean("req_computadora");
                    curso.ReqDispMovil = lector.GetBoolean("req_disp_movil");
                    curso.ReqDispEspecial = lector.GetBoolean("req_disp_especial");
                    if(!lector.IsDBNull(lector.GetOrdinal("foto"))) curso.Foto = (byte[])lector["foto"];
                    if (!lector.IsDBNull(lector.GetOrdinal("silabo"))) curso.Silabo = (byte[])lector["silabo"];
                    curso.Sumilla = lector.GetString("Sumilla");
                    cursos.Add(curso);
                }
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                lector.Close();
                con.Close();
            }
            return cursos;
        }
    }
}
