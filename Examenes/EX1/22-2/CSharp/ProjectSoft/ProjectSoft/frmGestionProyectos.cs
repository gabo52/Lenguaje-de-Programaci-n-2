using ProjectSoftController.DAO;
using ProjectSoftController.MySQL;
using ProjectSoftModel;
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
        private Estudiante estudiante;
        private DocenteDAO daoDocente;
        private Docente docente;
        private AreaDAO daoArea;
        private Proyecto proyecto;
        private ProyectoDAO daoProyecto;

        public frmGestionProyectos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            establecerEstadoComponentes();
            daoArea = new AreaMySQL();
            daoProyecto = new ProyectoMySQL();
            daoDocente = new DocenteMySQL();
            cboArea.DisplayMember = "Nombre";
            cboArea.ValueMember = "IdArea";
            cboArea.DataSource = daoArea.listarTodas();
            dgvJurados.AutoGenerateColumns = false;
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
            frmBusquedaEstudiantes frmBusqEst = new frmBusquedaEstudiantes();
            if(frmBusqEst.ShowDialog() == DialogResult.OK)
            {
                this.estudiante = frmBusqEst.EstudianteSeleccionado;
                txtEstudiante.Text = estudiante.CodigoPUCP + " - "+ estudiante.NombreCompleto.ToString()+ " - "+ estudiante.CRAEST;
            }
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
                    proyecto.Foto = br.ReadBytes((int)fs.Length);

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
            proyecto = new Proyecto();
            proyecto.Jurados = new BindingList<Docente> ();
            dgvJurados.DataSource = proyecto.Jurados;
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
                    this.proyecto.ArchivoTemaTesis = br.ReadBytes((int)fs.Length);
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
                    File.WriteAllBytes(archivoGenerar, this.proyecto.ArchivoTemaTesis);
                    MessageBox.Show("Se ha guardado el archivo", "Mensaje de Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Se ha generado un error al momento de guardar el archivo", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void txtEstudiante_TextChanged(object sender, EventArgs e)
        {

        }

        public void mostrarFormulario(Form form)
        {
            this.Controls.Clear();
            form.TopLevel = false;
            form.FormBorderStyle = FormBorderStyle.None;
            this.Controls.Add(form);
            form.Visible = true;
        }

        private void cboArea_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            //insertamos un estudiante
            proyecto.Estudiante = estudiante;
            proyecto.Titulo = txtTitulo.Text;
            proyecto.Descripcion = txtDescripcion.Text;
            proyecto.Area = new Area();

            proyecto.Area.IdArea = (int)cboArea.SelectedValue;

            


            int resultado = daoProyecto.insertar(proyecto);
            if (resultado != 0)
            { 
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
        }

        private void btnBuscarDocente_Click(object sender, EventArgs e)
        {
            frmBusquedaDocentes frmBusqDoc = new frmBusquedaDocentes();
            if (frmBusqDoc.ShowDialog() == DialogResult.OK)
            {
                this.docente = frmBusqDoc.DocenteSeleccionado;
                txtNombreCompletoDocente.Text = docente.NombreCompleto;
                txtCodigoPUCPDocente.Text = docente.CodigoPUCP;
            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaProyectos frmBusqProy = new frmBusquedaProyectos();
            if (frmBusqProy.ShowDialog() == DialogResult.OK)
            {
                this.proyecto = frmBusqProy.ProyectoSeleccionado;
                //llenar campos de proyecto seleccionado
                txtDescripcion.Text = proyecto.Descripcion;
                txtTitulo.Text = proyecto.Titulo;
                txtEstudiante.Text = proyecto.Estudiante.Nombre + " "+ proyecto.Estudiante.ApellidoPaterno;
                dgvJurados.DataSource = daoDocente.listarPorIdProyecto(proyecto.IdProyecto);
                MemoryStream ms = new MemoryStream(proyecto.Foto);
                pbFoto.Image = new Bitmap(ms);

                _estado = Estado.Buscar;
                establecerEstadoComponentes();
            }
        }

        private void btnAgregarJurado_Click(object sender, EventArgs e)
        {
            Docente doc = new Docente();
            doc = docente;
            proyecto.Jurados.Add(doc);
            txtCodigoPUCPDocente.Text = " ";
            txtNombreCompletoDocente.Text = " ";
            
        }

        private void dgvJurados_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            Docente doc = (Docente)dgvJurados.Rows[e.RowIndex].DataBoundItem;
            dgvJurados.Rows[e.RowIndex].Cells[0].Value = doc.CodigoPUCP;
            dgvJurados.Rows[e.RowIndex].Cells[1].Value = doc.NombreCompleto;
            dgvJurados.Rows[e.RowIndex].Cells[2].Value = doc.Categoria;
        }
    }
}
