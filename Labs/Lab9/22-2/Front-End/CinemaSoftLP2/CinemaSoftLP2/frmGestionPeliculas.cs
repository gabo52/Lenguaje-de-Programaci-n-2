using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CinemaSoftLP2
{
    public partial class frmGestionPeliculas : Form
    {
        private Estado _estado;
        private string _rutaFotoPortada;
        public frmGestionPeliculas()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        public void limpiarComponentes()
        {
            txtIDPelicula.Text = "";
            txtTitulo.Text = "";
            dtpFechaEstreno.Value = DateTime.Now;
            cboGenero.SelectedIndex = -1;
            dtpDuracion.Value = new DateTime(DateTime.Now.Year, DateTime.Now.Month, DateTime.Now.Day, 01, 30, 00);
            cbSubtitulada.Checked = false;
            cbDoblada.Checked = false;
            txtSinopsis.Text = "";
            pbPortada.Image = null;
            _rutaFotoPortada = "";
            dgvActores.DataSource = null;
            txtIDActor.Text = "";
            txtNombreCompletoActor.Text = "";
        }
        public void establecerEstadoComponentes()
        {
            switch (_estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnBuscar.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDPelicula.Enabled = false;
                    txtTitulo.Enabled = false;
                    dtpFechaEstreno.Enabled = false;
                    cboGenero.Enabled = false;
                    dtpDuracion.Enabled = false;
                    cbDoblada.Enabled = false;
                    cbSubtitulada.Enabled = false;
                    txtSinopsis.Enabled = false;
                    btnSubirPortada.Enabled = false;
                    txtIDActor.Enabled = false;
                    txtNombreCompletoActor.Enabled = false;
                    btnBuscarActor.Enabled = false;
                    btnAgregarActor.Enabled = false;
                    btnEliminarActor.Enabled = false;
                    dgvActores.Enabled = false;
                    break;
                case Estado.Modificar:
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnCancelar.Enabled = true;
                    txtIDPelicula.Enabled = true;
                    txtTitulo.Enabled = true;
                    dtpFechaEstreno.Enabled = true;
                    cboGenero.Enabled = true;
                    dtpDuracion.Enabled = true;
                    cbDoblada.Enabled = true;
                    cbSubtitulada.Enabled = true;
                    txtSinopsis.Enabled = true;
                    btnSubirPortada.Enabled = true;
                    txtIDActor.Enabled = true;
                    txtNombreCompletoActor.Enabled = true;
                    btnBuscarActor.Enabled = true;
                    btnAgregarActor.Enabled = true;
                    btnEliminarActor.Enabled = true;
                    dgvActores.Enabled = true;
                    break;
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDPelicula.Enabled = false;
                    txtTitulo.Enabled = false;
                    dtpFechaEstreno.Enabled = false;
                    cboGenero.Enabled = false;
                    dtpDuracion.Enabled = false;
                    cbDoblada.Enabled = false;
                    cbSubtitulada.Enabled = false;
                    txtSinopsis.Enabled = false;
                    btnSubirPortada.Enabled = false;
                    txtIDActor.Enabled = false;
                    txtNombreCompletoActor.Enabled = false;
                    btnBuscarActor.Enabled = false;
                    btnAgregarActor.Enabled = false;
                    btnEliminarActor.Enabled = false;
                    dgvActores.Enabled = false;
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
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }
    }
}
