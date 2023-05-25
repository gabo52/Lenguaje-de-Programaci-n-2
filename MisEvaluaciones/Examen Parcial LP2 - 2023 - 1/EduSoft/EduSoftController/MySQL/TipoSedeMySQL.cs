using EduSoftController.DAO;
using EduSoftDBManager;
using EduSoftModel;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftController.MySQL
{
    public class TipoSedeMySQL : TipoSedeDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public BindingList<TipoSede> listarTodas()
        {
            BindingList<TipoSede> tiposSede = new BindingList<TipoSede>();
            try {
            con = new MySqlConnection(DBManager.cadena);
            con.Open();
            comando = new MySqlCommand();
            comando.Connection = con;
            comando.CommandType = System.Data.CommandType.StoredProcedure;
            comando.CommandText = "LISTAR_TIPOS_SEDE_TODOS";
            lector = comando.ExecuteReader();
            while (lector.Read())
            {
                TipoSede tiposede = new TipoSede();
                tiposede.IdTipoSede = lector.GetInt32("id_tipo_sede");
                tiposede.Nombre = lector.GetString("nombre");
                tiposSede.Add(tiposede);
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
            return tiposSede;
        }
    }
}
