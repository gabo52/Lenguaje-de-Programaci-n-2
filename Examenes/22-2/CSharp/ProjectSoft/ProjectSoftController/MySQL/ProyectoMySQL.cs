using MySqlConnector;
using ProjectSoftController.DAO;
using ProjectSoftDBManager;
using ProjectSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftController.MySQL
{
    public class ProyectoMySQL : ProyectoDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public int insertar(Proyecto proyecto)
        {
            int resultado = 0;
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "INSERTAR_PROYECTO";
                comando.Parameters.Add("_id_proyecto", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_fid_area", proyecto.Area.IdArea);
                comando.Parameters.AddWithValue("_fid_estudiante", proyecto.Estudiante.IdPersona);
                comando.Parameters.AddWithValue("_titulo", proyecto.Titulo);
                comando.Parameters.AddWithValue("_descripcion", proyecto.Descripcion);
                comando.Parameters.AddWithValue("_foto", proyecto.Foto);
                comando.Parameters.AddWithValue("_archivo_tema_tesis", proyecto.ArchivoTemaTesis);
                comando.ExecuteNonQuery();
                proyecto.IdProyecto = Int32.Parse(
                    comando.Parameters["_id_proyecto"].Value.ToString());
                foreach(Docente jurado in proyecto.Jurados)
                {
                    comando.Parameters.Clear();
                    comando.CommandText = "INSERTAR_JURADO_PROYECTO";
                    comando.Parameters.Add("_id_jurado", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;
                    comando.Parameters.AddWithValue("_fid_docente", jurado.IdPersona);
                    comando.Parameters.AddWithValue("_fid_proyecto", proyecto.IdProyecto);
                    comando.ExecuteNonQuery();
                    jurado.IdPersona = Int32.Parse(
                    comando.Parameters["_id_jurado"].Value.ToString());
                }
                resultado = proyecto.IdProyecto;
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

        public BindingList<Proyecto> listarXTituloCodigoPUCPNombre(string cadena)
        {
            BindingList<Proyecto> proyectos = new BindingList<Proyecto>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_PROYECTOS_X_TITULO_CODIGOPUCP_NOMBRE_TESISTA";
                comando.Parameters.AddWithValue("_titulo_codigoPUCP_nombre", cadena);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Proyecto proyecto = new Proyecto();
                    proyecto.IdProyecto = lector.GetInt32("id_proyecto");
                    proyecto.Area = new Area();
                    proyecto.Area.IdArea = lector.GetInt32("id_area");
                    proyecto.Area.Nombre = lector.GetString("nombre_area");
                    proyecto.Titulo = lector.GetString("titulo");
                    proyecto.Descripcion = lector.GetString("descripcion");
                    if (!lector.IsDBNull(lector.GetOrdinal("foto"))) proyecto.Foto = (byte[])lector["foto"];
                    if (!lector.IsDBNull(lector.GetOrdinal("archivo_tema_tesis"))) proyecto.ArchivoTemaTesis = (byte[])lector["archivo_tema_tesis"];
                    proyecto.Estudiante=new Estudiante();
                    proyecto.Estudiante.IdPersona = lector.GetInt32("id_estudiante");
                    proyecto.Estudiante.CodigoPUCP = lector.GetString("codigo_PUCP");
                    proyecto.Estudiante.Nombre = lector.GetString("nombre_estudiante");
                    proyecto.Estudiante.ApellidoPaterno = lector.GetString("apellido_paterno");
                    proyecto.Estudiante.CRAEST = lector.GetDouble("CRAEST");
                    proyectos.Add(proyecto);
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
            return proyectos;
        }
    }
}
