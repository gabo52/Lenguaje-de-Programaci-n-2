using EduSoftDBManager;
using EduSoftDBManager.DAO;
using EduSoftLP2Model;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftLP2Controller.MySQL
{
    public class EspecialidadMySQL : EspecialidadDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public BindingList<Especialidad> listarTodos()
        {
            BindingList<Especialidad> especialidades = new BindingList<Especialidad>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_ESPECIALIDADES_TODAS";
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Especialidad especialidad = new Especialidad();
                    especialidad.IdEspecialidad = lector.GetInt32("id_especialidad");
                    especialidad.Nombre = lector.GetString("nombre");
                    especialidades.Add(especialidad);
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
            return especialidades;
        }
    }
}
