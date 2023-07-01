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
    public class AreaMySQL : AreaDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public BindingList<Area> listarTodas()
        {
            BindingList<Area> areas = new BindingList<Area>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_AREAS_TODAS";
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Area area = new Area();
                    area.IdArea = lector.GetInt32("id_area");
                    area.Nombre = lector.GetString("nombre");
                    areas.Add(area);
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
            return areas;
        }
    }
}
