using CinemaSoftLP2.ServiciosWS;
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

namespace CinemaSoftLP2
{
    public partial class frmGestionPeliculas : Form
    {
        private Estado _estado;
        private string _rutaFotoPortada;
        private ServiciosWSClient servicioWS;
        private actor actorSeleccionado;
        private BindingList<actor> actores;
        private pelicula pelicula;
        public frmGestionPeliculas()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
            servicioWS = new ServiciosWSClient();
            cboGenero.ValueMember = "idGenero";
            cboGenero.DisplayMember = "nombre";
            cboGenero.DataSource = servicioWS.listarGenerosTodos();
            dgvActores.AutoGenerateColumns = false;
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
            actores = new BindingList<actor>();
            dgvActores.DataSource = actores;
            
            pelicula = new pelicula();
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        private void btnBuscarActor_Click(object sender, EventArgs e)
        {
            frmBusquedaActores frmBusqAct = new frmBusquedaActores();
            if(frmBusqAct.ShowDialog() == DialogResult.OK)
            {
                actorSeleccionado = frmBusqAct.ActorSeleccionado;
                txtIDActor.Text = actorSeleccionado.idActor.ToString();
                txtNombreCompletoActor.Text = actorSeleccionado.nombre + " " + actorSeleccionado.apellidoPaterno;
            }
        }

        private void cboGenero_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void pbPortada_Click(object sender, EventArgs e)
        {

        }

        private void btnAgregarActor_Click(object sender, EventArgs e)
        {
            actores.Add(actorSeleccionado);
            txtIDActor.Text = "";
            txtNombreCompletoActor.Text = "";
        }

        private void dgvActores_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dgvActores_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            try
            {
                actor actor = (actor)dgvActores.Rows[e.RowIndex].DataBoundItem;
                dgvActores.Rows[e.RowIndex].Cells[0].Value = actor.nombre + " " + actor.apellidoPaterno;
                dgvActores.Rows[e.RowIndex].Cells[1].Value = actor.nacionalidad;
            }
            catch (Exception ex)
            {

            }
        }

        private void btnEliminarActor_Click(object sender, EventArgs e)
        {
            if (dgvActores.CurrentRow != null)
            {
                actor actor = (actor)dgvActores.CurrentRow.DataBoundItem;
                this.actores.Remove(actor);
            }
            else
            {
                MessageBox.Show("Debe seleccionar una linea de orden de venta", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            pelicula.actores = actores.ToArray();
            pelicula.titulo = txtTitulo.Text;
            pelicula.duracion = dtpDuracion.Value.ToString("hh:mm");
            FileStream fs = new FileStream(_rutaFotoPortada, FileMode.Open, FileAccess.Read);
            BinaryReader br = new BinaryReader(fs);
            pelicula.portada = br.ReadBytes((int)fs.Length);
            fs.Close();
            pelicula.genero = new genero();
            pelicula.genero.idGenero = (int)cboGenero.SelectedValue;
            pelicula.fechaEstreno = dtpFechaEstreno.Value;
            pelicula.fechaEstrenoSpecified = true;
            if (cbDoblada.Checked == true)
            {
                pelicula.disponibleDoblada = true;
            }
            else
            {
                pelicula.disponibleDoblada=false;
            }

            if(cbSubtitulada.Checked == true)
            {
                pelicula.disponibleSubtitulada = true;
            }
            else
            {
                pelicula.disponibleSubtitulada=false;
            }
            pelicula.sinopsis = txtSinopsis.Text;

            int resultado= servicioWS.insertarPelicula(pelicula);

            
            if (resultado != 0)
            {
                txtIDPelicula.Text = resultado.ToString();
                MessageBox.Show("Se ha registrado correctamente",
                "Mensaje de éxito", MessageBoxButtons.OK,
                MessageBoxIcon.Information);
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
                "Mensaje de éxito", MessageBoxButtons.OK,
                MessageBoxIcon.Error);
            }
            _estado = Estado.Buscar;
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaPeliculas frmBusqPel = new frmBusquedaPeliculas();
            if(frmBusqPel.ShowDialog() == DialogResult.OK) {
                pelicula = frmBusqPel.PeliculaSeleccionada;
                txtIDPelicula.Text = pelicula.idPelicula.ToString();

                dtpDuracion.Value = DateTime.ParseExact(pelicula.duracion, "hh:mm", null);

                MemoryStream ms = new MemoryStream(pelicula.portada);
                pbPortada.Image = new Bitmap(ms);

                dtpFechaEstreno.Value = pelicula.fechaEstreno;
                cboGenero.SelectedValue = pelicula.genero.idGenero;
                if (pelicula.disponibleDoblada == true)
                {
                    cbDoblada.Checked = true;
                }
                else
                {
                    cbDoblada.Checked = false;
                }

                if(pelicula.disponibleSubtitulada == true)
                {
                    cbSubtitulada.Checked = true;
                }
                else
                {
                    cbSubtitulada .Checked = false;
                }

                txtSinopsis.Text = pelicula.sinopsis;
                txtTitulo.Text = pelicula.titulo;
                actores = new BindingList<actor>(pelicula.actores.ToList());
                dgvActores.DataSource = actores;
                _estado = Estado.Buscar;
                establecerEstadoComponentes();
            }
        }
    }
}
