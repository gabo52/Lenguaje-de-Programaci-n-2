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
    public class DocenteMySQL : DocenteDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public BindingList<Docente> listarPorCodigoNombre(string cadena)
        {
            BindingList<Docente> docentes = new BindingList<Docente>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_DOCENTES_X_CODIGOPUCP_NOMBRE";
                comando.Parameters.AddWithValue("_codigoPUCP_nombre", cadena);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Docente docente = new Docente();

                    docente.IdPersona = lector.GetInt32("id_persona");
                    docente.CodigoPUCP = lector.GetString("codigo_PUCP");
                    docente.Nombre = lector.GetString("nombre");
                    docente.ApellidoPaterno = lector.GetString("apellido_paterno");
                    docente.Categoria = lector.GetString("categoria");

                    docentes.Add(docente);
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

        public BindingList<Docente> listarPorIdProyecto(int idProyecto)
        {
            BindingList<Docente> docentes = new BindingList<Docente>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_JURADOS_X_ID_PROYECTO";
                comando.Parameters.AddWithValue("_id_proyecto", idProyecto);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Docente docente = new Docente();

                    docente.IdPersona = lector.GetInt32("id_docente");
                    docente.CodigoPUCP = lector.GetString("codigo_PUCP");
                    docente.Nombre = lector.GetString("nombre");
                    docente.ApellidoPaterno = lector.GetString("apellido_paterno");
                    docente.Categoria = lector.GetString("categoria");

                    docentes.Add(docente);
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
