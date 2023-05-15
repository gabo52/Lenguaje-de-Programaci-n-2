using EduSoftDBManager.DAO;
using EduSoftLP2Controller.DAO;
using EduSoftLP2Controller.MySQL;
using EduSoftLP2Model;
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
using System.Xml.Linq;
using static System.Net.WebRequestMethods;

namespace EduSoftLP2
{
    public partial class frmGestionCursos : Form
    {
        /* Colocar los siguientes datos:
         * Nombre:
         * Código:
         */
        private Estado _estado;
        private string _rutaFotoPortada = "";
        private string _rutaArchivo = "";
        private Docente docente;
        EspecialidadDAO daoEspecialidad;
        DocenteDAO daoDocente;
        CursoDAO daocurso;
        Curso curso;
        public frmGestionCursos()
        {
            InitializeComponent();
            _estado = Estado.Inicial;
            estadoComponentes();
            daoEspecialidad= new EspecialidadMySQL();
            daocurso = new CursoMySQL();
            daoDocente = new DocenteMySQL();
            dgvDocentes.AutoGenerateColumns = false;
            cboEspecialidades.DisplayMember = "Nombre";
            cboEspecialidades.ValueMember = "IdEspecialidad";
            cboEspecialidades.DataSource = daoEspecialidad.listarTodos();
            limpiarComponentes();
        }

        public void estadoComponentes()
        {
            switch (_estado)
            {
                case Estado.Inicial:
                    btnNuevo.Enabled = true;
                    btnGuardar.Enabled = false;
                    btnBuscar.Enabled = true;
                    btnCancelar.Enabled = true;
                    txtNombreCurso.Enabled = false;
                    txtClave.Enabled = false;
                    dtpAnho.Enabled = false;
                    txtSemestre.Enabled = false;
                    rbVirtual.Enabled = false;
                    rbPresencial.Enabled = false;
                    rbSemiPresencial.Enabled = false;
                    btnSubirFoto.Enabled = false;
                    cboEspecialidades.Enabled = false;
                    cbComputadora.Enabled = false;
                    cbDispMovil.Enabled = false;
                    cbDispEspecial.Enabled = false;
                    txtSumilla.Enabled = false;
                    txtSilabo.Enabled = false;
                    btnSubirSilabo.Enabled = false;
                    btnDescargarSilabo.Enabled = false;
                    txtCodigoDocente.Enabled = false;
                    txtNombreDocente.Enabled = false;
                    btnBuscarDocente.Enabled = false;
                    btnAgregarDocente.Enabled = false;
                    btnEliminarDocente.Enabled = false;
                    dgvDocentes.Enabled = false;
                    break;
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtNombreCurso.Enabled = true;
                    txtClave.Enabled = true;
                    dtpAnho.Enabled = true;
                    txtSemestre.Enabled = true;
                    rbVirtual.Enabled = true;
                    rbPresencial.Enabled = true;
                    rbSemiPresencial.Enabled = true;
                    btnSubirFoto.Enabled = true;
                    cboEspecialidades.Enabled = true;
                    cbComputadora.Enabled = true;
                    cbDispMovil.Enabled = true;
                    cbDispEspecial.Enabled = true;
                    txtSumilla.Enabled = true;
                    txtSilabo.Enabled = true;
                    btnSubirSilabo.Enabled = true;
                    btnDescargarSilabo.Enabled = false;
                    txtCodigoDocente.Enabled = true;
                    txtNombreDocente.Enabled = true;
                    btnBuscarDocente.Enabled = true;
                    btnAgregarDocente.Enabled = true;
                    btnEliminarDocente.Enabled = true;
                    dgvDocentes.Enabled = true;
                    break;
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtNombreCurso.Enabled = true;
                    txtNombreCurso.ReadOnly = true;
                    txtClave.Enabled = true;
                    txtClave.ReadOnly = true;
                    dtpAnho.Enabled = false;
                    txtSemestre.Enabled = true;
                    txtSemestre.ReadOnly = true;
                    rbVirtual.Enabled = false;
                    rbPresencial.Enabled = false;
                    rbSemiPresencial.Enabled = false;
                    btnSubirFoto.Enabled = false;
                    cboEspecialidades.Enabled = false;
                    cbComputadora.Enabled = false;
                    cbDispMovil.Enabled = false;
                    cbDispEspecial.Enabled = false;
                    txtSumilla.Enabled = true;
                    txtSumilla.ReadOnly = true;
                    txtSilabo.Enabled = false;
                    btnSubirSilabo.Enabled = false;
                    btnDescargarSilabo.Enabled = true;
                    txtCodigoDocente.Enabled = false;
                    txtNombreDocente.Enabled = false;
                    btnBuscarDocente.Enabled = false;
                    btnAgregarDocente.Enabled = false;
                    btnEliminarDocente.Enabled = false;
                    dgvDocentes.Enabled = false;
                    break;
            }
        }

        public void limpiarComponentes()
        {
            txtNombreCurso.Text = "";
            txtClave.Text = "";
            dtpAnho.Value = DateTime.Now;
            txtSemestre.Text = "";
            rbVirtual.Checked = false;
            rbPresencial.Checked = false;
            rbSemiPresencial.Checked = false;
            cboEspecialidades.SelectedIndex = -1;
            cbComputadora.Checked = false;
            cbDispMovil.Checked = false;
            cbDispEspecial.Checked = false;
            txtSumilla.Text = "";
            txtSilabo.Text = "";
            txtCodigoDocente.Text = "";
            txtNombreDocente.Text = "";
            pbFoto.Image = null;
            _rutaFotoPortada = "";
            _rutaArchivo = "";
        }
        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            limpiarComponentes(); ;
            estadoComponentes();
            docente = new Docente();
            curso = new Curso();
            curso.Docentes = new BindingList<Docente>();
            dgvDocentes.DataSource = curso.Docentes;
        }

        private void btnSubirFoto_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdFoto.ShowDialog() == DialogResult.OK)
                {
                    _rutaFotoPortada = ofdFoto.FileName;
                    pbFoto.Image = Image.FromFile(_rutaFotoPortada);
                    FileStream fs = new FileStream(_rutaFotoPortada, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    curso.Foto = br.ReadBytes((int)fs.Length);
                    fs.Close();
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
            estadoComponentes();
        }

        private void btnSubirSilabo_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdArchivo.ShowDialog() == DialogResult.OK)
                {
                    _rutaArchivo = ofdArchivo.FileName;
                    txtSilabo.Text = _rutaArchivo;
                    FileStream fs = new FileStream(_rutaArchivo, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    curso.Silabo = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ocurrió un error al seleccionar el archivo", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }

        private void btnDescargarSilabo_Click(object sender, EventArgs e)
        {
            if (sfdArchivo.ShowDialog() == DialogResult.OK)
            {
                try
                {
                    String archivoGenerar = sfdArchivo.FileName;
                    System.IO.File.WriteAllBytes(archivoGenerar, this.curso.Silabo);
                    MessageBox.Show("Se ha guardado el archivo", "Mensaje de Confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Se ha generado un error al momento de guardar el archivo", "Mensaje de Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void cboEspecialidades_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnBuscarDocente_Click(object sender, EventArgs e)
        {
            frmBusquedaDocentes frmBusquedaDoc = new frmBusquedaDocentes();
            if (frmBusquedaDoc.ShowDialog()==DialogResult.OK)
            {
                this.docente = frmBusquedaDoc.DocenteSeleccionado;
                txtCodigoDocente.Text = docente.CodigoPUCP;
                txtNombreDocente.Text = docente.Nombre;
            }
        }

        private void btnAgregarDocente_Click(object sender, EventArgs e)
        {
            if (txtNombreDocente.Text == "")
            {
                MessageBox.Show("Debe seleccionar un docente", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            curso.Docentes.Add(docente);
            txtCodigoDocente.Text = "";
            txtNombreDocente.Text = "";
        }

        private void dgvDocentes_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            Docente doc = (Docente)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
            if (doc.CodigoPUCP[0] == 'E')
            {
                DocenteExtranjero docExt = (DocenteExtranjero)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
                dgvDocentes.Rows[e.RowIndex].Cells[0].Value = docExt.CodigoPUCP;
                dgvDocentes.Rows[e.RowIndex].Cells[1].Value = docExt.Nombre + " " + docExt.ApellidoPaterno;
                dgvDocentes.Rows[e.RowIndex].Cells[2].Value = docExt.Filiacion.Nombre;
            }
            else
            {
                DocentePUCP docpucp = (DocentePUCP)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
                dgvDocentes.Rows[e.RowIndex].Cells[0].Value = docpucp.CodigoPUCP;
                dgvDocentes.Rows[e.RowIndex].Cells[1].Value = docpucp.Nombre + " " + docpucp.ApellidoPaterno;
                dgvDocentes.Rows[e.RowIndex].Cells[2].Value = docpucp.Categoria;
            }
        }

        private void dgvDocentes_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            curso.Especialidad = new Especialidad();
            curso.Especialidad.IdEspecialidad = (int)cboEspecialidades.SelectedValue;
            if (cbDispMovil.Checked == true)
            {
                curso.ReqDispMovil = true;
            }
            else
            {
                curso.ReqDispEspecial = false;
            }

            if (cbDispEspecial.Checked == true)
            {
                curso.ReqDispEspecial = true;
            }
            else
            {
                curso.ReqDispEspecial = false;
            }

            if(cbComputadora.Checked == true)
            {
                curso.ReqComputadora = true;
            }
            else
            {
                curso.ReqDispEspecial = false;
            }

            curso.Nombre = txtNombreCurso.Text;
            curso.Clave = txtClave.Text;
            curso.Semestre = dtpAnho.Value.Year.ToString() + "-"+ txtSemestre.Text;
            if(rbPresencial.Checked == true)
            {
                curso.Modalidad = Modalidad.PRESENCIAL; 
            }else if (rbSemiPresencial.Checked == true)
            {
                curso.Modalidad = Modalidad.SEMIPRESENCIAL;

            }
            else
            {
                curso.Modalidad = Modalidad.VIRTUAL;
            }

            curso.Sumilla = txtSumilla.Text;
            int resultado = daocurso.insertar(curso);
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

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaCursos frmBusqCur = new frmBusquedaCursos();
            if(frmBusqCur.ShowDialog() == DialogResult.OK)
            {
                this.curso = frmBusqCur.CursoSeleccionado;
                txtClave.Text = curso.Clave;
                txtNombreCurso.Text = curso.Nombre;
                txtSemestre.Text = curso.Semestre[5].ToString();
                string year = curso.Semestre.Substring(0,curso.Semestre.Length-2);
                dtpAnho.Value = DateTime.ParseExact(year, "yyyy", null);

                if (curso.ReqDispEspecial == true)
                {
                    cbDispEspecial.Checked = true;
                }
                else
                {
                    cbDispEspecial.Checked = false;
                }

                if (curso.ReqComputadora == true)
                {
                    cbComputadora.Checked = true;
                }
                else
                {
                    cbComputadora.Checked = false;
                }

                if (curso.ReqDispMovil == true)
                {
                    cbDispMovil.Checked = true;
                }
                else
                {
                    cbDispMovil.Checked = false;
                }

                if (curso.Modalidad.ToString()=="PRESENCIAL")
                {
                    rbPresencial.Checked = true;
                }else if(curso.Modalidad.ToString() == "SEMIPRESENCIAL")
                {
                    rbSemiPresencial.Checked = true;
                }
                else
                {
                    rbVirtual.Checked= true;
                }

                txtSumilla.Text = curso.Sumilla;
                MemoryStream ms = new MemoryStream(curso.Foto);
                pbFoto.Image = new Bitmap(ms);
                cboEspecialidades.SelectedValue = curso.Especialidad.IdEspecialidad;
                dgvDocentes.DataSource = daoDocente.listarPorIdCurso(curso.IdCurso);
                _estado = Estado.Buscar;
                estadoComponentes();
            }
        }

        private void btnEliminarDocente_Click(object sender, EventArgs e)
        {
            if (dgvDocentes.CurrentRow != null)
            {
                Docente doc = (Docente)dgvDocentes.CurrentRow.DataBoundItem;
                this.curso.Docentes.Remove(doc);
            }
            else
            {
                MessageBox.Show("Debe seleccionar un docente", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
        }
    }
}
