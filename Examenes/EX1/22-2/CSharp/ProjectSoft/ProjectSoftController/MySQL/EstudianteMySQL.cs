using MySqlConnector;
using ProjectSoftController.DAO;
using ProjectSoftDBManager;
using ProjectSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectSoftController.MySQL
{
    public class EstudianteMySQL : EstudianteDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;

        public int insertar(Estudiante estudiante)
        {
            int resultado = 0;
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "INSERTAR_ESTUDIANTE";
                comando.Parameters.Add("_id_estudiante", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_codigo_PUCP", estudiante.CodigoPUCP);
                comando.Parameters.AddWithValue("_nombre", estudiante.Nombre);
                comando.Parameters.AddWithValue("_apellido_paterno", estudiante.ApellidoPaterno);
                comando.Parameters.AddWithValue("_CRAEST", estudiante.CRAEST);
                comando.ExecuteNonQuery();
                estudiante.IdPersona = Int32.Parse(
                    comando.Parameters["_id_estudiante"].Value.ToString());
                resultado = estudiante.IdPersona;
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

        public BindingList<Estudiante> listarPorNombreYCodigo(string cadena)
        {
            BindingList<Estudiante> estudiantes = new BindingList<Estudiante>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_ESTUDIANTES_X_CODIGOPUCP_NOMBRE";
                comando.Parameters.AddWithValue("_codigoPUCP_nombre", cadena);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Estudiante estudiante = new Estudiante();
                    estudiante.IdPersona = lector.GetInt32("id_persona");
                    estudiante.CodigoPUCP = lector.GetString("codigo_PUCP");
                    estudiante.Nombre = lector.GetString("nombre");
                    estudiante.ApellidoPaterno = lector.GetString("apellido_paterno");
                    estudiante.CRAEST = lector.GetDouble("CRAEST");


                    estudiantes.Add(estudiante);
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
            return estudiantes;
        }
    }
}
