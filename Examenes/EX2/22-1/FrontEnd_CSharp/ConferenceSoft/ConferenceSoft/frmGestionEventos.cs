using ConferenceSoft.serviciosWS;
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

namespace ConferenceSoft
{
    public partial class frmGestionEventos : Form
    {
        private Estado _estado;
        private string _rutaFotoPortada;
        private integrante integranteSeleccionado;
        private evento evento;
        private BindingList<ponencia> ponencias;
        private ServiciosWSClient serviciosWS;

        public frmGestionEventos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            estadoComponentes();
            dgvPonencias.AutoGenerateColumns = false;
            serviciosWS = new ServiciosWSClient();
        }

        public void limpiarComponentes()
        {
            txtID.Text = "";
            txtNombre.Text = "";
            dtpFechaEvento.Value = DateTime.Now;
            txtDescripcion.Text = "";
            txtCodigoPUCPPonente.Text = "";
            txtNombrePonente.Text = "";
            txtTituloPonencia.Text = "";
            dtpHoraInicio.Value = DateTime.Now;
            dtpHoraFin.Value = DateTime.Now;
            pbPortada.Image = null;
        }

        public void estadoComponentes()
        {
            switch (this._estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnBuscar.Enabled = true;
                    btnCancelar.Enabled = false;
                    btnSubirPortada.Enabled = false;
                    btnBuscarPonente.Enabled = false;
                    btnAgregarPonente.Enabled = false;
                    btnEliminarPonente.Enabled = false;
                    txtID.Enabled = false;
                    txtNombre.Enabled = false;
                    dtpFechaEvento.Enabled = false;
                    txtDescripcion.Enabled = false;
                    txtTituloPonencia.Enabled = false;
                    txtCodigoPUCPPonente.Enabled = false;
                    txtNombrePonente.Enabled = false;
                    dtpHoraInicio.Enabled = false;
                    dtpHoraFin.Enabled = false;
                    dgvPonencias.Enabled = false;
                    break;
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    btnSubirPortada.Enabled = true;
                    btnBuscarPonente.Enabled = true;
                    btnAgregarPonente.Enabled = true;
                    btnEliminarPonente.Enabled = true;
                    txtID.Enabled = true;
                    txtNombre.Enabled = true;
                    dtpFechaEvento.Enabled = true;
                    txtDescripcion.Enabled = true;
                    txtTituloPonencia.Enabled = true;
                    txtCodigoPUCPPonente.Enabled = true;
                    txtNombrePonente.Enabled = true;
                    dtpHoraInicio.Enabled = true;
                    dtpHoraFin.Enabled = true;
                    dgvPonencias.Enabled = true;
                    break;
            }
        }


        private void btnSubirPortada_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdPortada.ShowDialog() == DialogResult.OK)
                {
                    _rutaFotoPortada = ofdPortada.FileName;
                    pbPortada.Image = Image.FromFile(_rutaFotoPortada);
                    FileStream fs = new FileStream(_rutaFotoPortada, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    evento.portada = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("El archivo seleccionado no es un tipo de imagen válido");
            }
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            estadoComponentes();
            limpiarComponentes();
            evento = new evento();
            ponencias = new BindingList<ponencia>();
            dgvPonencias.DataSource = ponencias;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            estadoComponentes();
            limpiarComponentes();

        }

        private void btnBuscarPonente_Click(object sender, EventArgs e)
        {
            frmBusquedaIntegrantes frmBusqInt = new frmBusquedaIntegrantes();
            if(frmBusqInt.ShowDialog()== DialogResult.OK)
            {
                integranteSeleccionado = frmBusqInt.IntegranteSeleccionado;
                txtCodigoPUCPPonente.Text = integranteSeleccionado.codigoPUCP;
                txtNombrePonente.Text = integranteSeleccionado.nombre + " "+integranteSeleccionado.apellidoPaterno;
            }
        }

        private void btnAgregarPonente_Click(object sender, EventArgs e)
        {
            if (integranteSeleccionado != null)
            {
                ponencia ponencia = new ponencia();
                ponencia.titulo = txtTituloPonencia.Text;
                ponencia.horaInicio = dtpHoraInicio.Value.ToString("HH:mm"); ;
                ponencia.horaFin = dtpHoraFin.Value.ToString("HH:mm");
                ponencia.ponente = integranteSeleccionado;
                ponencias.Add(ponencia);
                integranteSeleccionado = null;
                txtTituloPonencia.Text = "";
                txtCodigoPUCPPonente.Text = "";
                txtNombrePonente.Text = "";
            }
        }

        private void dgvPonencias_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            ponencia ponencia = (ponencia)
               dgvPonencias.Rows[e.RowIndex].DataBoundItem;
            dgvPonencias.Rows[e.RowIndex].
                Cells[0].Value = ponencia.ponente.nombre+" "+ponencia.ponente.apellidoPaterno;
            dgvPonencias.Rows[e.RowIndex].
                Cells[1].Value = ponencia.titulo;
            dgvPonencias.Rows[e.RowIndex].
                Cells[2].Value = ponencia.horaInicio;
            dgvPonencias.Rows[e.RowIndex].
                Cells[3].Value = ponencia.horaFin;
        }

        private void btnEliminarPonente_Click(object sender, EventArgs e)
        {
            if (dgvPonencias.CurrentRow != null)
            {
                ponencia ponencia = (ponencia)dgvPonencias.CurrentRow.DataBoundItem;
                this.ponencias.Remove(ponencia);
            }
            else
            {
                MessageBox.Show("Debe seleccionar una ponencia", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            evento.nombre = txtNombre.Text;
            evento.fecha = dtpFechaEvento.Value;
            evento.fechaSpecified = true;
            evento.descripcion = txtDescripcion.Text;
            evento.ponencias = ponencias.ToArray();
            int resultado = serviciosWS.insertarEvento(evento);
            if (resultado != 0)
            {
                txtID.Text = resultado.ToString();
                MessageBox.Show("Se ha registrado correctamente",
                "Mensaje de éxito", MessageBoxButtons.OK,
                MessageBoxIcon.Information);
                _estado = Estado.Guardar;
                estadoComponentes();
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
            if(frmBusqEvent.ShowDialog() == DialogResult.OK)
            {
                evento = frmBusqEvent.EventoSeleccionado;

                txtID.Text = evento.idEvento.ToString();
                txtNombre.Text = evento.nombre;
                dtpFechaEvento.Value = evento.fecha;
                txtDescripcion.Text = evento.descripcion;

                dgvPonencias.DataSource = evento.ponencias;

                MemoryStream ms = new MemoryStream(evento.portada);
                pbPortada.Image = new Bitmap(ms);
                _estado = Estado.Buscar;
            }
        }
    }
}
