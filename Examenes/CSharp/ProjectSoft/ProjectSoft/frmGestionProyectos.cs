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

namespace ProjectSoft
{
    public partial class frmGestionProyectos : Form
    {
        private Estado _estado;
        private string _rutaArchivoPDF = "";
        private string _rutaFoto = "";
        public frmGestionProyectos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            establecerEstadoComponentes();
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
                    txtEstudiante.Enabled = false;
                    btnBuscarEstudiante.Enabled = false;
                    txtTitulo.Enabled = false;
                    txtDescripcion.Enabled = false;
                    cboArea.Enabled = false;
                    btnSubirArchivo.Enabled = false;
                    btnDescargarArchivo.Enabled = false;
                    txtRutaArchivo.Enabled = false;
                    btnSubirFoto.Enabled = false;
                    txtCodigoPUCPDocente.Enabled = false;
                    txtNombreCompletoDocente.Enabled = false;
                    btnBuscarDocente.Enabled = false;
                    btnAgregarJurado.Enabled = false;
                    btnEliminarJurado.Enabled = false;
                    dgvJurados.Enabled = false;
                    break;
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtEstudiante.Enabled = true;
                    btnBuscarEstudiante.Enabled = true;
                    txtTitulo.Enabled = true;
                    txtDescripcion.Enabled = true;
                    cboArea.Enabled = true;
                    btnSubirArchivo.Enabled = true;
                    btnDescargarArchivo.Enabled = false;
                    txtRutaArchivo.Enabled = true;
                    btnSubirFoto.Enabled = true;
                    txtCodigoPUCPDocente.Enabled = true;
                    txtNombreCompletoDocente.Enabled = true;
                    btnBuscarDocente.Enabled = true;
                    btnAgregarJurado.Enabled = true;
                    btnEliminarJurado.Enabled = true;
                    dgvJurados.Enabled = true;
                    break;
                case Estado.Guardar:
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtEstudiante.Enabled = true;
                    btnBuscarEstudiante.Enabled = false;
                    txtTitulo.Enabled = false;
                    txtDescripcion.Enabled = false;
                    cboArea.Enabled = false;
                    btnSubirArchivo.Enabled = false;
                    btnDescargarArchivo.Enabled = true;
                    txtRutaArchivo.Enabled = true;
                    btnSubirFoto.Enabled = false;
                    txtCodigoPUCPDocente.Enabled = false;
                    txtNombreCompletoDocente.Enabled = false;
                    btnBuscarDocente.Enabled = false;
                    btnAgregarJurado.Enabled = false;
                    btnEliminarJurado.Enabled = false;
                    dgvJurados.Enabled = true;
                    break;
            }
        }

        public void limpiarComponentes()
        {
            txtEstudiante.Text = "";
            txtTitulo.Text = "";
            txtDescripcion.Text = "";
            cboArea.SelectedIndex = -1;
            pbFoto.Image = null;
            _rutaArchivoPDF = "";
            _rutaFoto = "";
            txtCodigoPUCPDocente.Text = "";
            txtNombreCompletoDocente.Text = "";
            dgvJurados.DataSource = null;
            txtRutaArchivo.Text = "";
        }

        private void btnBuscarEstudiante_Click(object sender, EventArgs e)
        {
            
        }

        private void btnSubirFoto_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdFoto.ShowDialog() == DialogResult.OK)
                {
                    _rutaFoto = ofdFoto.FileName;
                    pbFoto.Image = Image.FromFile(_rutaFoto);
                    /*
                    FileStream fs = new FileStream(_rutaFoto, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    _proyecto.Foto = br.ReadBytes((int)fs.Length);
                     */
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

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        private void btnSubirArchivo_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdArchivo.ShowDialog() == DialogResult.OK)
                {
                    _rutaArchivoPDF = ofdArchivo.FileName;
                    txtRutaArchivo.Text = _rutaArchivoPDF;
                    FileStream fs = new FileStream(_rutaArchivoPDF, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    //Asignamos el archivo al objeto
                    //this._proyecto.ArchivoTemaTesis = br.ReadBytes((int)fs.Length);
                    br.Close();
                    fs.Close();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ocurrió un error al seleccionar el archivo", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnDescargarArchivo_Click(object sender, EventArgs e)
        {
            if (sfdArchivo.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    String archivoGenerar = sfdArchivo.FileName;
                    //Convertimos el arreglo de Bytes a archivo
                    //File.WriteAllBytes(archivoGenerar, this._proyecto.ArchivoTemaTesis);
                    MessageBox.Show("Se ha guardado el archivo", "Mensaje de Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Se ha generado un error al momento de guardar el archivo", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }
    }
}
