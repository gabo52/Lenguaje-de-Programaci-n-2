using GameSoftController.DAO;
using GameSoftDBManager;
using GameSoftModel;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GameSoftController.MySQL
{
    public class DesarrolladoraMySQL : DesarrolladoraDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public BindingList<Desarrolladora> listarDesarrolladoresPorNombre(string nombre)
        {
            BindingList<Desarrolladora> desarrolladoras = new BindingList<Desarrolladora>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_DESARROLLADORAS_POR_NOMBRE";
                comando.Parameters.AddWithValue("_nombre", nombre);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Desarrolladora desarrolladora = new Desarrolladora();
                    desarrolladora.IdDesarrolladora = lector.GetInt32("id_desarrolladora");
                    desarrolladora.Nombre = lector.GetString("nombre");
                    desarrolladoras.Add(desarrolladora);
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
            return desarrolladoras;
        }
    }
}
