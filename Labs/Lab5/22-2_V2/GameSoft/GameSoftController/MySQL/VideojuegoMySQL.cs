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
    public class VideojuegoMySQL : VideojuegoDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public int insertar(Videojuego videojuego)
        {
            int resultado = 0;
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "INSERTAR_VIDEOJUEGO";
                comando.Parameters.Add("_id_videojuego", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;

                comando.Parameters.AddWithValue("_fid_desarrolladora", videojuego.Desarrolladora.IdDesarrolladora);
                comando.Parameters.AddWithValue("_fid_genero", videojuego.Genero.IdGenero);
                comando.Parameters.AddWithValue("_fid_plataforma", videojuego.Plataforma);
                comando.Parameters.AddWithValue("_nombre", videojuego.Nombre);
                comando.Parameters.AddWithValue("_max_jugadores", videojuego.MaxJugadores);
                comando.Parameters.AddWithValue("_es_cooperativo", videojuego.Cooperativo);
                comando.Parameters.AddWithValue("_es_multiplayer", videojuego.Multiplayer);
                comando.Parameters.AddWithValue("_es_edicion_especial", videojuego.EdicionEspecial);
                comando.Parameters.AddWithValue("_precio", videojuego.Precio);
                comando.Parameters.AddWithValue("_descripcion", videojuego.Descripcion);
                comando.Parameters.AddWithValue("_portada", videojuego.Portada);
                comando.ExecuteNonQuery();
                videojuego.IdVideojuego = Int32.Parse(
                    comando.Parameters["_id_videojuego"].Value.ToString());
                resultado = videojuego.IdVideojuego;
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

        public BindingList<Videojuego> listarVideojuegosNombre(string nombre)
        {
            BindingList<Videojuego> videojuegos = new BindingList<Videojuego>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_VIDEOJUEGOS_POR_NOMBRE";
                comando.Parameters.AddWithValue("_nombre", nombre);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Videojuego videojuego = new Videojuego();
                    videojuego.Genero = new Genero();
                    videojuego.Desarrolladora = new Desarrolladora();
                    videojuego.IdVideojuego = lector.GetInt32("id_videojuego");
                    videojuego.Genero.IdGenero = lector.GetInt32("id_genero");
                    videojuego.Desarrolladora.IdDesarrolladora = lector.GetInt32("id_desarrolladora");
                    videojuego.Desarrolladora.Nombre = lector.GetString("nombre_desarrolladora");
                    videojuego.Genero.Nombre = lector.GetString("nombre_genero");
                    videojuego.Plataforma = lector.GetChar("id_plataforma");
                    videojuego.Nombre = lector.GetString("nombre_videojuego");
                    videojuego.MaxJugadores = lector.GetInt32("max_jugadores");
                    videojuego.Cooperativo = lector.GetBoolean("es_cooperativo");
                    videojuego.Multiplayer = lector.GetBoolean("es_multiplayer");
                    videojuego.EdicionEspecial = lector.GetBoolean("es_edicion_especial");
                    videojuego.Portada = (byte[])lector["portada"];
                    videojuego.Precio = lector.GetDouble("precio");
                    videojuego.Descripcion = lector.GetString("descripcion");
                    videojuegos.Add(videojuego);
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
            return videojuegos;
        }
    }
}
