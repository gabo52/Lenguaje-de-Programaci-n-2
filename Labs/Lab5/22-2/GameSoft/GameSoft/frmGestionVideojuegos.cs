using GameSoftController.DAO;
using GameSoftController.MySQL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GameSoft
{
    public partial class frmGestionVideojuegos : Form
    {
        private string _rutaFotoPortada = "";
        private Estado _estado;
        private GeneroDAO daoGenero;
       
        public frmGestionVideojuegos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
            daoGenero = new GeneroMySQL();
            cboGenero.DisplayMember = "nombre";
            cboGenero.ValueMember = "ID";
            cboGenero.DataSource = daoGenero.listarTodos();
           
        }

        public void limpiarComponentes()
        {
            txtIdVideojuego.Text = "";
            txtNombre.Text = "";
            txtDesarrolladora.Text = "";
            cboGenero.SelectedIndex = -1;
            rbPlaystation.Checked = false;
            rbNintendo.Checked = false;
            rbXbox.Checked = false;
            nudMaxJugadores.Value = 1;
            cbCooperativo.Checked = false;
            cbMultiplayer.Checked = false;
            cbEdicionEspecial.Checked = false;
            txtPrecio.Text = "";
            txtDescripcion.Text = "";
            pbPortada.Image = null;
        }

        public void establecerEstadoComponentes()
        {
            switch (_estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnBuscar.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnCancelar.Enabled = false;
                    btnBuscarDesarrolladora.Enabled = false;
                    btnSubirPortada.Enabled = false;
                    txtIdVideojuego.Enabled = false;
                    txtNombre.Enabled = false;
                    txtDesarrolladora.Enabled = false;
                    txtPrecio.Enabled = false;
                    txtDescripcion.Enabled = false;
                    cboGenero.Enabled = false;
                    rbPlaystation.Enabled = false;
                    rbNintendo.Enabled = false;
                    rbXbox.Enabled = false;
                    nudMaxJugadores.Enabled = false;
                    cbCooperativo.Enabled = false;
                    cbMultiplayer.Enabled = false;
                    cbEdicionEspecial.Enabled = false;
                    break;
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnCancelar.Enabled = true;
                    btnBuscarDesarrolladora.Enabled = true;
                    btnSubirPortada.Enabled = true;
                    txtIdVideojuego.Enabled = true;
                    txtNombre.Enabled = true;
                    txtDesarrolladora.Enabled = true;
                    txtPrecio.Enabled = true;
                    txtDescripcion.Enabled = true;
                    cboGenero.Enabled = true;
                    rbPlaystation.Enabled = true;
                    rbNintendo.Enabled = true;
                    rbXbox.Enabled = true;
                    nudMaxJugadores.Enabled = true;
                    cbCooperativo.Enabled = true;
                    cbMultiplayer.Enabled = true;
                    cbEdicionEspecial.Enabled = true;
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

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            establecerEstadoComponentes();
            limpiarComponentes();
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            establecerEstadoComponentes();
        }

        private void nudMaxJugadores_ValueChanged(object sender, EventArgs e)
        {

        }

        private void cboGenero_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {

        }
    }
}
