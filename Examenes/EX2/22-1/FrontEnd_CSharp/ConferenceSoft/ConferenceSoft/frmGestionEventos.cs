using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
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
        public frmGestionEventos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            estadoComponentes();
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
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            estadoComponentes();
            limpiarComponentes();
        }
    }
}
