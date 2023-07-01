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
    public class DocenteMySQL : DocenteDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;

        public BindingList<Docente> listarPorIdCurso(int idCurso)
        {
            BindingList<Docente> docentes = new BindingList<Docente>();
            try
            {
                char tipoDoc;
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_DOCENTES_POR_ID_CURSO";
                comando.Parameters.AddWithValue("_id_curso", idCurso);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    //Docente docente;
                    tipoDoc = lector.GetChar("fid_tipo_docente");
                    if (tipoDoc == 'E')
                    {
                        //extranjero
                        DocenteExtranjero docente = new DocenteExtranjero();
                        docente.DominaEspanhol = lector.GetBoolean("domina_espanhol");
                        docente.IdDocente = lector.GetInt32("id_docente");
                        docente.CodigoPUCP = lector.GetString("codigo_PUCP");
                        docente.Nombre = lector.GetString("nombre");
                        docente.ApellidoPaterno = lector.GetString("apellido_paterno");
                        docente.NumeroDocumento = lector.GetString("numero_documento");
                        docente.MaximoGradoAlcanzado = lector.GetString("maximo_grado_alcanzado");
                        docente.TipoDocumento = (TipoDocumento)Enum.Parse(typeof(TipoDocumento), lector.GetString("tipo_documento"));
                        docente.GradoRevalidadoSUNEDU = lector.GetBoolean("grado_revalidado_SUNEDU");
                        docente.Filiacion = new Filiacion();
                        docente.Filiacion.IdFiliacion = lector.GetInt32("id_filiacion");
                        docente.Filiacion.Nombre = lector.GetString("nombre_filiacion");
                        docentes.Add(docente);
                    }
                    else
                    {
                        //docente PUCP}
                        DocentePUCP docente = new DocentePUCP();
                        docente.Categoria = lector.GetString("categoria");
                        docente.IdDocente = lector.GetInt32("id_docente");
                        docente.CodigoPUCP = lector.GetString("codigo_PUCP");
                        docente.Nombre = lector.GetString("nombre");
                        docente.ApellidoPaterno = lector.GetString("apellido_paterno");
                        docente.NumeroDocumento = lector.GetString("numero_documento");
                        docente.MaximoGradoAlcanzado = lector.GetString("maximo_grado_alcanzado");
                        docentes.Add(docente);
                    }
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
            return docentes;
        }

        public BindingList<Docente> listarPorNombreCodigo(string cadena)
        {
            char tipoDoc;
            BindingList<Docente> docentes = new BindingList<Docente>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_DOCENTES_POR_NOMBRE_O_CODIGO";
                comando.Parameters.AddWithValue("_nombreCodigo", cadena);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    //Docente docente;
                    tipoDoc = lector.GetChar("fid_tipo_docente");
                    if (tipoDoc == 'E')
                    {
                        //docente extranjero
                        DocenteExtranjero docente = new DocenteExtranjero();
                        docente.DominaEspanhol = lector.GetBoolean("domina_espanhol");
                        docente.IdDocente = lector.GetInt32("id_docente");
                        docente.CodigoPUCP = lector.GetString("codigo_PUCP");
                        docente.Nombre = lector.GetString("nombre");
                        docente.ApellidoPaterno = lector.GetString("apellido_paterno");
                        docente.NumeroDocumento = lector.GetString("numero_documento");
                        docente.MaximoGradoAlcanzado = lector.GetString("maximo_grado_alcanzado");
                        docente.GradoRevalidadoSUNEDU = lector.GetBoolean("grado_revalidado_SUNEDU");
                        docente.TipoDocumento = (TipoDocumento)Enum.Parse(typeof(TipoDocumento), lector.GetString("tipo_documento"));
                        docente.Filiacion = new Filiacion();
                        docente.Filiacion.IdFiliacion = lector.GetInt32("id_filiacion");
                        docente.Filiacion.Nombre = lector.GetString("nombre_filiacion");
                        docente.Filiacion.Siglas = lector.GetString("siglas");
                        docentes.Add(docente);
                    }
                    else
                    {
                        //docente PUCP
                        DocentePUCP docente = new DocentePUCP();
                        docente.Categoria = lector.GetString("categoria");
                        docente.IdDocente = lector.GetInt32("id_docente");
                        docente.CodigoPUCP = lector.GetString("codigo_PUCP");
                        docente.Nombre = lector.GetString("nombre");
                        docente.ApellidoPaterno = lector.GetString("apellido_paterno");
                        docente.NumeroDocumento = lector.GetString("numero_documento");
                        docente.MaximoGradoAlcanzado = lector.GetString("maximo_grado_alcanzado");
                        docentes.Add(docente);
                    }
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
            return docentes;
        }
    }
}
