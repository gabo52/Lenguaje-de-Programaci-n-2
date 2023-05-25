using EduSoftController.DAO;
using EduSoftDBManager;
using EduSoftModel;
using MySql.Data.MySqlClient;
using MySqlX.XDevAPI;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EduSoftController.MySQL
{
    public class SedeMySQL : SedeDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public int insertar(Sede sede)
        {
            int resultado = 0;
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "INSERTAR_SEDE";
                comando.Parameters.Add("_id_sede", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_fid_tipo_sede", sede.TipoSede.IdTipoSede);
                comando.Parameters.AddWithValue("_fid_ejecutivo_responsable", sede.Ejecutivo.IdEjecutivo);
                comando.Parameters.AddWithValue("_nombre", sede.Nombre);
                comando.Parameters.AddWithValue("_direccion", sede.Direccion);
                comando.Parameters.AddWithValue("_fecha_inauguracion", sede.FechaInauguracion);
                comando.Parameters.AddWithValue("_cantidad_aulas", sede.CantidadAulas);
                comando.Parameters.AddWithValue("_aforo_total", sede.AforoTotal);
                comando.Parameters.AddWithValue("_foto", sede.Foto);
                comando.Parameters.AddWithValue("_tiene_auditorio", sede.TieneAuditorio);
                comando.Parameters.AddWithValue("_tiene_biblioteca", sede.TieneBiblioteca);
                comando.Parameters.AddWithValue("_tiene_estacionamiento", sede.TieneEstacionamiento);
                comando.Parameters.AddWithValue("_tiene_salas_estudio", sede.TieneSalasEstudio);
                comando.Parameters.AddWithValue("_tiene_cafeteria", sede.TieneCafeteria);
                comando.ExecuteNonQuery();
                sede.IdSede = Int32.Parse(
                    comando.Parameters["_id_sede"].Value.ToString());
                foreach (ProgramaAcademico progAc in sede.ProgramasAcademicos)
                {
                    comando.Parameters.Clear();
                    comando.CommandText = "INSERTAR_SEDE_PROGRAMA_ACADEMICO";
                    comando.Parameters.Add("_id_sede_programa_academico", MySqlDbType.Int32)
                    .Direction = System.Data.ParameterDirection.Output;
                    comando.Parameters.AddWithValue("_fid_sede", sede.IdSede);
                    comando.Parameters.AddWithValue("_fid_programa_academico",progAc.IdProgramaAcademico);
                    comando.ExecuteNonQuery();
                    progAc.IdProgramaAcademico = Int32.Parse(
                    comando.Parameters["_id_sede_programa_academico"].Value.ToString());
                }

                resultado = sede.IdSede;
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

        public BindingList<Sede> listarPorNombre(string nombreSede)
        {
            BindingList<Sede> sedes = new BindingList<Sede>();
            try
            {
                con = new MySqlConnection(DBManager.cadena);
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.CommandText = "LISTAR_SEDES_X_NOMBRE";
                comando.Parameters.AddWithValue("_nombre", nombreSede);
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Sede sede = new Sede();
                    sede.IdSede = lector.GetInt32("id_sede");
                    sede.TipoSede = new TipoSede();
                    sede.TipoSede.IdTipoSede = lector.GetInt32("id_tipo_sede");
                    sede.TipoSede.Nombre = lector.GetString("nombre_tipo_sede");
                    sede.Nombre = lector.GetString("nombre_sede");
                    sede.Direccion = lector.GetString("direccion");
                    sede.FechaInauguracion = lector.GetDateTime("fecha_inauguracion");
                    sede.CantidadAulas = lector.GetInt32("cantidad_aulas");
                    sede.AforoTotal = lector.GetInt32("aforo_total");
                    if (!lector.IsDBNull(lector.GetOrdinal("foto"))) sede.Foto = (byte[])lector["foto"];
                    sede.TieneAuditorio = lector.GetBoolean("tiene_auditorio");
                    sede.TieneBiblioteca = lector.GetBoolean("tiene_biblioteca");
                    sede.TieneEstacionamiento = lector.GetBoolean("tiene_estacionamiento");
                    sede.TieneSalasEstudio = lector.GetBoolean("tiene_salas_estudio");
                    sede.TieneCafeteria = lector.GetBoolean("tiene_cafeteria");
                    sede.Ejecutivo = new Ejecutivo();
                    sede.Ejecutivo.IdEjecutivo = lector.GetInt32("id_ejecutivo");
                    sede.Ejecutivo.DNI = lector.GetString("DNI");
                    sede.Ejecutivo.Nombre = lector.GetString("nombre_ejecutivo");
                    sede.Ejecutivo.ApellidoPaterno = lector.GetString("apellido_paterno");
                    sedes.Add(sede);
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
            return sedes;
        }
    }
}
