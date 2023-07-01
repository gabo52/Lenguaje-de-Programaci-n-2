using EventSoft.ServiciosWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EventSoft
{
    public partial class frmGestionEventos : Form
    {
        ServiciosWSClient serviciosWS;
        private Estado _estado;
        private string _rutaFoto = "";
        private docente docenteSeleccionado;
        private evento evento;
        private actividad actividadSeleccionada;
        private BindingList<docente> docentes;
        private BindingList<actividad> actividades;
        public frmGestionEventos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            
            establecerEstadoComponentes();
            serviciosWS = new ServiciosWSClient();
            cboEspecialidad.ValueMember = "idEspecialidad";
            cboEspecialidad.DisplayMember = "nombre";
            cboEspecialidad.DataSource = serviciosWS.listarEspecialidadesTodas();

            dgvDocentes.AutoGenerateColumns = false;
            dgvActividades.AutoGenerateColumns = false;
        }

        public void establecerEstadoComponentes()
        {
            switch (_estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnBuscar.Enabled = true;
                    btnCancelar.Enabled = true;
                    txtIDEvento.Enabled = false;
                    txtNombreEvento.Enabled = false;
                    dtpFechaInicio.Enabled = false;
                    dtpFechaFin.Enabled = false;
                    btnSubirFoto.Enabled = false;
                    cboEspecialidad.Enabled = false;
                    txtCosto.Enabled = false;
                    txtCodigoPUCPDocente.Enabled = false;
                    txtNombreDocente.Enabled = false;
                    btnBuscarDocente.Enabled = false;
                    btnAgregarActividad.Enabled = false;
                    btnEliminarActividad.Enabled = false;
                    btnAgregarDocente.Enabled = false;
                    btnEliminarDocente.Enabled = false;
                    dgvDocentes.Enabled = false;
                    txtNombreActividad.Enabled = false;
                    dtpFechaActividad.Enabled = false;
                    dtpHoraInicio.Enabled = false;
                    dtpHoraFin.Enabled = false;
                    dgvActividades.Enabled = false;
                    break;
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDEvento.Enabled = true;
                    txtNombreEvento.Enabled = true;
                    dtpFechaInicio.Enabled = true;
                    dtpFechaFin.Enabled = true;
                    btnSubirFoto.Enabled = true;
                    cboEspecialidad.Enabled = true;
                    txtCosto.Enabled = true;
                    txtCodigoPUCPDocente.Enabled = true;
                    txtNombreDocente.Enabled = true;
                    btnBuscarDocente.Enabled = true;
                    btnAgregarActividad.Enabled = true;
                    btnEliminarActividad.Enabled = true;
                    btnAgregarDocente.Enabled = true;
                    btnEliminarDocente.Enabled = true;
                    dgvDocentes.Enabled = true;
                    txtNombreActividad.Enabled = true;
                    dtpFechaActividad.Enabled = true;
                    dtpHoraInicio.Enabled = true;
                    dtpHoraFin.Enabled = true;
                    dgvActividades.Enabled = true;
                    break;
                case Estado.Guardar:
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDEvento.Enabled = false;
                    txtNombreEvento.Enabled = false;
                    dtpFechaInicio.Enabled = false;
                    dtpFechaFin.Enabled = false;
                    btnSubirFoto.Enabled = false;
                    cboEspecialidad.Enabled = false;
                    txtCosto.Enabled = false;
                    txtCodigoPUCPDocente.Enabled = false;
                    txtNombreDocente.Enabled = false;
                    btnBuscarDocente.Enabled = false;
                    btnAgregarActividad.Enabled = false;
                    btnEliminarActividad.Enabled = false;
                    btnAgregarDocente.Enabled = false;
                    btnEliminarDocente.Enabled = false;
                    dgvDocentes.Enabled = false;
                    txtNombreActividad.Enabled = false;
                    dtpFechaActividad.Enabled = false;
                    dtpHoraInicio.Enabled = false;
                    dtpHoraFin.Enabled = false;
                    dgvActividades.Enabled = false;
                    break;
            }
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            limpiarComponentes();
            establecerEstadoComponentes();
            actividades = new BindingList<actividad>();
            docentes = new BindingList<docente>();
            evento = new evento();
            dgvDocentes.DataSource = docentes;
            dgvActividades.DataSource = actividades;
        }

        public void limpiarComponentes()
        {
            txtIDEvento.Text = "";
            txtNombreEvento.Text = "";
            dtpFechaInicio.Value = DateTime.Now;
            dtpFechaFin.Value = DateTime.Now;
            cboEspecialidad.SelectedIndex = -1;
            txtCosto.Text = "";
            dgvDocentes.DataSource = null;
            txtCodigoPUCPDocente.Text = "";
            txtNombreDocente.Text = "";
            txtNombreActividad.Text = "";
            dtpFechaActividad.Value = DateTime.Now;
            dtpHoraInicio.Value = DateTime.Now;
            dtpHoraFin.Value = DateTime.Now;
            dgvActividades.DataSource = null;
        }

        private void btnSubirFoto_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdFoto.ShowDialog() == DialogResult.OK)
                {
                    _rutaFoto = ofdFoto.FileName;
                    pbFoto.Image = Image.FromFile(_rutaFoto);
                    
                    FileStream fs = new FileStream(_rutaFoto, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    evento.foto = br.ReadBytes((int)fs.Length);
                    
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("El archivo seleccionado no es un tipo de imagen válido");
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        private void cboEspecialidad_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnBuscarDocente_Click(object sender, EventArgs e)
        {
            frmBusquedaDocentes frmBusqDoc = new frmBusquedaDocentes((int)cboEspecialidad.SelectedValue);
            if(frmBusqDoc.ShowDialog() == DialogResult.OK)
            {
                docenteSeleccionado = frmBusqDoc.DocenteSeleccionado;
                //llenar Datos
                txtCodigoPUCPDocente.Text = docenteSeleccionado.codigoPUCP;
                txtNombreDocente.Text = docenteSeleccionado.nombre + " "
                + docenteSeleccionado.apellidoPaterno + " " + docenteSeleccionado.apellidoMaterno;
            }
        }

        private void btnAgregarDocente_Click(object sender, EventArgs e)
        {
            if (docenteSeleccionado != null)
            {
                docentes.Add(docenteSeleccionado);
                txtCodigoPUCPDocente.Text = "";
                txtNombreDocente.Text = "";
                docenteSeleccionado = null;
            }
            else
            {
                MessageBox.Show("Debe seleccionar un docente", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void dgvDocentes_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            try{
                docente docente = (docente)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
                dgvDocentes.Rows[e.RowIndex].Cells[0].Value = docente.idDocente;
                dgvDocentes.Rows[e.RowIndex].Cells[1].Value = docente.nombre + " "
                    + docente.apellidoPaterno + " " + docente.apellidoMaterno;
                dgvDocentes.Rows[e.RowIndex].Cells[2].Value = docente.especialidad.nombre;
            }
            catch(Exception ex)
            {

            }
        }

        private void btnEliminarDocente_Click(object sender, EventArgs e)
        {
            if(dgvDocentes.CurrentRow != null)
            {
                docente docente = (docente)dgvDocentes.CurrentRow.DataBoundItem;
                this.docentes.Remove(docente);
            }
            else
            {
                MessageBox.Show("Debe seleccionar un docente", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void btnAgregarActividad_Click(object sender, EventArgs e)
        {
            actividadSeleccionada = new actividad();
            actividadSeleccionada.horaInicio = dtpHoraInicio.Value.ToString("HH:mm"); ;
            actividadSeleccionada.horaFin = dtpHoraFin.Value.ToString("HH:mm"); ;
            actividadSeleccionada.nombre = txtNombreActividad.Text;
            actividadSeleccionada.fecha = dtpFechaActividad.Value;
            actividadSeleccionada.fechaSpecified = true;

            if (actividadSeleccionada != null)
            {
                actividades.Add(actividadSeleccionada);
                txtNombreActividad.Text = "";
                actividadSeleccionada = null;
            }
            else
            {
                MessageBox.Show("Debe seleccionar una actividad", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void dgvActividades_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            try
            {
                actividad actividad = (actividad)dgvActividades.Rows[e.RowIndex].DataBoundItem;
                dgvActividades.Rows[e.RowIndex].Cells[0].Value = actividad.nombre;
                dgvActividades.Rows[e.RowIndex].Cells[1].Value = actividad.fecha.ToString("dd-MM-yyyy");
                dgvActividades.Rows[e.RowIndex].Cells[2].Value = actividad.horaInicio;
                dgvActividades.Rows[e.RowIndex].Cells[3].Value = actividad.horaFin;
            }
            catch (Exception ex)
            {

            }
        }

        private void btnEliminarActividad_Click(object sender, EventArgs e)
        {
            if (dgvActividades.CurrentRow != null)
            {
                actividad actividad = (actividad)dgvActividades.CurrentRow.DataBoundItem;
                this.actividades.Remove(actividad);
            }
            else
            {
                MessageBox.Show("Debe seleccionar un docente", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
            }
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            evento.nombre = txtNombreEvento.Text;
            evento.fechaInicio = dtpFechaInicio.Value;
            evento.fechaInicioSpecified = true;
            evento.fechaFin = dtpFechaFin.Value;
            evento.fechaFinSpecified = true;
            evento.especialidad = new especialidad();
            evento.especialidad.idEspecialidad = (int)cboEspecialidad.SelectedValue;
            evento.costo = Double.Parse(txtCosto.Text);
            evento.responsables = docentes.ToArray();
            evento.actividades = actividades.ToArray();

            int resultado = serviciosWS.insertarEvento(evento);
            if (resultado != 0)
            {
                txtIDEvento.Text = resultado.ToString();
                MessageBox.Show("Se ha registrado correctamente",
                "Mensaje de éxito", MessageBoxButtons.OK,
                MessageBoxIcon.Information);
                _estado = Estado.Guardar;
                establecerEstadoComponentes();
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
                "Mensaje de éxito", MessageBoxButtons.OK,
                MessageBoxIcon.Error);
            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaEventos frmBusqEvent = new frmBusquedaEventos();
            if(frmBusqEvent.ShowDialog() == DialogResult.OK )
            {
                evento = frmBusqEvent.EventoSeleccionado;
                
                //llenas info
                txtIDEvento.Text = evento.idEvento.ToString();
                txtNombreEvento.Text = evento.nombre;


                dtpFechaInicio.Value = evento.fechaInicio;
                dtpFechaFin.Value = evento.fechaFin;
                cboEspecialidad.SelectedValue = evento.especialidad;
                txtCosto.Text = evento.costo.ToString();


                if (evento.foto!=null) {
                    MemoryStream ms = new MemoryStream(evento.foto);
                    pbFoto.Image = new Bitmap(ms);
                }

                dgvActividades.DataSource = evento.actividades;
                dgvDocentes.DataSource = evento.responsables;
                
            }
        }
    }
}
