using RinconLibroSoft.ServiciosWS;
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

namespace RinconLibroSoft
{
    public partial class frmGestionarLibros : Form
    {
        private string _rutaFotoPortada;
        private Estado _estado;
        private autor autorSeleccionado;
        private editorial editorialSeleccionada;
        private libro libro;
        private BindingList<autor> autores;
        private ServiciosWSClient serviciosWS;
        public frmGestionarLibros()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            establecerEstadoComponentes();
            limpiarComponentes();
            serviciosWS = new ServiciosWSClient();
            dgvAutores.AutoGenerateColumns = false;
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
                    gbDatosGenerales.Enabled = false;
                    break;
                case Estado.Modificar:
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnCancelar.Enabled = true;
                    gbDatosGenerales.Enabled = true;
                    break;
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnCancelar.Enabled = true;
                    gbDatosGenerales.Enabled = false;
                    break;
            }
        }

        public void limpiarComponentes()
        {
            txtIDLibro.Text = "";
            txtTitulo.Text = "";
            txtNroPaginas.Text = "";
            rbEspanhol.Checked = false;
            rbIngles.Checked = false;
            txtEditorial.Text = "";
            dtpFechaPublicacion.Value = DateTime.Now;
            txtPrecio.Text = "";
            pbPortada.Image = null;
            _rutaFotoPortada = "";
        }

        private void btnSubirFoto_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdPortada.ShowDialog() == DialogResult.OK)
                {
                    _rutaFotoPortada = ofdPortada.FileName;
                    pbPortada.Image = Image.FromFile(_rutaFotoPortada);

                    FileStream fs = new FileStream(_rutaFotoPortada, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    libro.portada = br.ReadBytes((int)fs.Length);
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
            limpiarComponentes();
            establecerEstadoComponentes();
            libro = new libro();
            autores = new BindingList<autor>();
            dgvAutores.DataSource = autores;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        private void btnBuscarAutor_Click(object sender, EventArgs e)
        {
            frmBusquedaAutores frmBusqAut = new frmBusquedaAutores();
            if(frmBusqAut.ShowDialog() == DialogResult.OK)
            {
                autorSeleccionado = frmBusqAut.AutorSeleccionado;
                txtAutor.Text = autorSeleccionado.nombre + " " + autorSeleccionado.apellidoPaterno;
            }
        }

        private void btnBuscarEditorial_Click(object sender, EventArgs e)
        {
            frmBusquedaEditoriales frmBusqEdit = new frmBusquedaEditoriales();
            if(frmBusqEdit.ShowDialog() == DialogResult.OK)
            {
                editorialSeleccionada = frmBusqEdit.EditorialSeleccionada;
                txtEditorial.Text = editorialSeleccionada.nombre;
            }
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            libro.titulo = txtTitulo.Text;
            libro.nroPaginas = Int32.Parse(txtNroPaginas.Text);
            if (rbEspanhol.Checked == true)
            {
                libro.idioma = 'E';
            }
            else
            {
                libro.idioma = 'I';
            }
            libro.editorial = editorialSeleccionada;
            libro.fechaPublicacion = dtpFechaPublicacion.Value;
            libro.fechaPublicacionSpecified = true;
            libro.precio = Double.Parse(txtPrecio.Text);
            libro.autores = autores.ToArray();

            int resultado = serviciosWS.insertarLibro(libro);
            if (resultado != 0)
            {
                txtIDLibro.Text = resultado.ToString();
                MessageBox.Show("Se ha registrado correctamente",
                "Mensaje de éxito", MessageBoxButtons.OK,
                MessageBoxIcon.Information);
                _estado = Estado.Buscar;
                establecerEstadoComponentes();
            }
            else
            {
                MessageBox.Show("Ha ocurrido un error con el registro",
                "Mensaje de éxito", MessageBoxButtons.OK,
                MessageBoxIcon.Error);
            }
        }

        private void btnAgregarAutor_Click(object sender, EventArgs e)
        {
            autores.Add(autorSeleccionado);
            txtAutor.Text = "";
        }

        private void dgvAutores_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            autor autor = (autor)
                dgvAutores.Rows[e.RowIndex].DataBoundItem;
            dgvAutores.Rows[e.RowIndex].
                Cells[0].Value = autor.idAutor;
            dgvAutores.Rows[e.RowIndex].
                Cells[1].Value = autor.nombre + " " + autor.apellidoPaterno;
            dgvAutores.Rows[e.RowIndex].
                Cells[2].Value = autor.nacionalidad;
        }

        private void btnEliminarAutor_Click(object sender, EventArgs e)
        {
            if (dgvAutores.CurrentRow != null)
            {
                autor autor = (autor)dgvAutores.CurrentRow.DataBoundItem;
                this.autores.Remove(autor);
            }
            else
            {
                MessageBox.Show("Debe seleccionar una linea de orden de venta", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaLibros frmBusqLib = new frmBusquedaLibros();
            if(frmBusqLib.ShowDialog() == DialogResult.OK)
            {
                libro = frmBusqLib.LibroSeleccionado;
                autores = new BindingList<autor>(libro.autores.ToList());
                dgvAutores.DataSource = autores;

                txtIDLibro.Text =libro.idLibro.ToString();
                txtTitulo.Text = libro.titulo;
                txtNroPaginas.Text = libro.nroPaginas.ToString();

                if (libro.idioma == 'E')
                {
                    rbEspanhol.Checked = true;
                    rbIngles.Checked = false;
                }
                else
                {
                    rbIngles.Checked = true;
                    rbEspanhol.Checked = false;
                }

                txtEditorial.Text = libro.editorial.nombre;
                dtpFechaPublicacion.Value = libro.fechaPublicacion;
                txtPrecio.Text = libro.precio.ToString();

                MemoryStream ms = new MemoryStream(libro.portada);
                pbPortada.Image = new Bitmap(ms);

                _estado = Estado.Buscar;
                establecerEstadoComponentes();
            }
        }
    }
}
