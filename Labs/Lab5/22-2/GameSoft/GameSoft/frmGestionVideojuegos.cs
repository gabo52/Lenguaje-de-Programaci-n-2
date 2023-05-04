using GameSoftController.DAO;
using GameSoftController.MySQL;
using GameSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Linq.Expressions;
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
        private VideojuegoDAO daoVideojuego;
        private Videojuego videojuego;
        public frmGestionVideojuegos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
            daoGenero = new GeneroMySQL();
            daoVideojuego = new VideojuegoMySQL();
            cboGenero.DisplayMember = "Nombre";
            cboGenero.ValueMember = "IdGenero";
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
            videojuego = new Videojuego();
        }

        private void nudMaxJugadores_ValueChanged(object sender, EventArgs e)
        {

        }

        private void cboGenero_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            videojuego.Genero = new Genero();
            videojuego.Genero.IdGenero = (int)cboGenero.SelectedValue;
            if (rbNintendo.Checked == true)
            {
                videojuego.Plataforma = 'N';
            }
            else if (rbPlaystation.Checked == true)
            {
                videojuego.Plataforma = 'P';
            }
            else videojuego.Plataforma = 'X';
            videojuego.MaxJugadores = (int)nudMaxJugadores.Value;

            if (cbCooperativo.Checked == true)
            {
                videojuego.Cooperativo = true;
            }
            else videojuego.Cooperativo = false;

            if (cbEdicionEspecial.Checked == true)
            {
                videojuego.EdicionEspecial = true;
            }
            else videojuego.EdicionEspecial = false;

            if (cbMultiplayer.Checked == true)
            {
                videojuego.Multiplayer = true;
            }
            else videojuego.Multiplayer = false;
            videojuego.Nombre = txtNombre.Text;
            videojuego.Precio = double.Parse(txtPrecio.Text);
            videojuego.Descripcion= txtDescripcion.Text;
            videojuego.Activo = true;

            //videojuego.Portada = (byte[])reader["portada"];
            int result=daoVideojuego.insertar(videojuego);
            

            if (result != 0)
            {
                MessageBox.Show("Se ha registrado con éxito",
                        "Mensaje de confirmación", MessageBoxButtons.OK,
                        MessageBoxIcon.Information);
                txtDesarrolladora.Text = result.ToString();
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
                        "Mensaje de error", MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
            }
        }

        private void txtDesarrolladora_TextChanged(object sender, EventArgs e)
        {
            FileStream fs = new FileStream(_rutaFotoPortada, FileMode.Open, FileAccess.Read);
            BinaryReader br = new BinaryReader(fs);
            videojuego.Portada = br.ReadBytes((int)fs.Length);
            fs.Close();
        }

        private void btnBuscarDesarrolladora_Click(object sender, EventArgs e)
        {
            frmBusquedaDesarrolladoras formBusqDes = new frmBusquedaDesarrolladoras();
            if (formBusqDes.ShowDialog() == DialogResult.OK)
            {
                this.videojuego.Desarrolladora = new Desarrolladora();
                this.videojuego.Desarrolladora = formBusqDes.DesarrolladoraSeleccionada;
                txtDesarrolladora.Text = videojuego.Desarrolladora.Nombre;
            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaVideojuegos formBusqDes = new frmBusquedaVideojuegos();
            if (formBusqDes.ShowDialog() == DialogResult.OK)
            {
                
                this.videojuego = formBusqDes.VideojuegoSeleccionado;
                
                txtDesarrolladora.Text = videojuego.Desarrolladora.Nombre;
                txtDescripcion.Text = videojuego.Descripcion;
                txtIdVideojuego.Text = videojuego.IdVideojuego.ToString();
                txtNombre.Text = videojuego.Nombre;
                txtPrecio.Text = videojuego.Precio.ToString();
                cboGenero.SelectedValue= videojuego.Genero.IdGenero;
                if (videojuego.Plataforma == 'P')
                {
                    rbPlaystation.Checked= true;
                }else if (videojuego.Plataforma == 'N')
                {
                    rbNintendo.Checked= true;
                }
                else
                {
                    rbXbox.Checked= true;
                }
                if (videojuego.Cooperativo == true)
                {
                    cbCooperativo.Checked= true;
                }
                else
                {
                    cbCooperativo.Checked = false;
                }
                if (videojuego.EdicionEspecial == true)
                {
                    cbEdicionEspecial.Checked = true;
                }
                else
                {
                    cbEdicionEspecial.Checked = false;
                }
                if(videojuego.Multiplayer == true)
                {
                    cbMultiplayer.Checked= true;
                }
                else
                {
                    cbMultiplayer.Checked = false;
                }
                MemoryStream ms = new MemoryStream(videojuego.Portada);
                pbPortada.Image = new Bitmap(ms);
                _estado = Estado.Buscar;
                establecerEstadoComponentes();
            }
        }
    }
}
