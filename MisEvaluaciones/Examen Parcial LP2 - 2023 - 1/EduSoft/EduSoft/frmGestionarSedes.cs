using EduSoftController.DAO;
using EduSoftController.MySQL;
using EduSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EduSoft
{
    /* Coloque sus datos
        * -------------------------------------------------
        * Nombre Completo: Gabriel Omar Durán Ruiz
        * Código PUCP: 20203371
        * Fecha de Modificación: 15/05/2023 
    */
    public partial class frmGestionarSedes : Form
    {

        private Estado _estado;
        private string _rutaFotoLocal;
        private Sede sede;
        private SedeDAO daoSede;
        private TipoSedeDAO daoTipoSede;
        private ProgramaAcademicoDAO daoProgramaAcademico;
        private ProgramaAcademico programaAcademico;

        public frmGestionarSedes()
        {
            InitializeComponent();
            dgvProgramasAcademicos.Columns[2].HeaderCell.Style.Alignment = DataGridViewContentAlignment.MiddleCenter;
            dgvProgramasAcademicos.Columns[3].HeaderCell.Style.Alignment = DataGridViewContentAlignment.MiddleCenter;
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
            daoTipoSede= new TipoSedeMySQL();
            daoSede = new SedeMySQL();
            daoProgramaAcademico = new ProgramaAcademicoMySQL();
            cboTipoSede.ValueMember = "IdTipoSede";
            cboTipoSede.DisplayMember = "Nombre";
            cboTipoSede.DataSource = daoTipoSede.listarTodas();
            dgvProgramasAcademicos.AutoGenerateColumns = false;
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
                    btnSubirFoto.Enabled = false;
                    btnBuscarEjecutivoResponsable.Enabled = false;
                    btnBuscarPrograma.Enabled = false;
                    btnAgregarProgramaAcademico.Enabled = false;
                    btnEliminarProgramaAcademico.Enabled = false;
                    txtIDSede.Enabled = false;
                    txtNombre.Enabled = false;
                    txtNombre.ReadOnly = false;
                    txtDireccion.Enabled = false;
                    txtDireccion.ReadOnly = false;
                    dtpFechaInauguracion.Enabled = false;
                    cboTipoSede.Enabled = false;
                    txtCantAulas.Enabled = false;
                    txtCantAulas.ReadOnly = false;
                    txtAforo.Enabled = false;
                    txtAforo.ReadOnly = false;
                    txtDNIEjecutivoResp.Enabled = false;
                    txtNombreEjecutivoResp.Enabled = false;
                    cbAuditorio.Enabled = false;
                    cbBiblioteca.Enabled = false;
                    cbEstacionamiento.Enabled = false;
                    cbSalasEstudio.Enabled = false;
                    cbCafeteria.Enabled = false;
                    txtClavePrograma.Enabled = false;
                    txtTipoPrograma.Enabled = false;
                    txtNombrePrograma.Enabled = false;
                    dgvProgramasAcademicos.Enabled = false;
                    break;
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    btnSubirFoto.Enabled = true;
                    btnBuscarEjecutivoResponsable.Enabled = true;
                    btnBuscarPrograma.Enabled = true;
                    btnAgregarProgramaAcademico.Enabled = true;
                    btnEliminarProgramaAcademico.Enabled = true;
                    txtIDSede.Enabled = true;
                    txtNombre.Enabled = true;
                    txtNombre.ReadOnly = false;
                    txtDireccion.Enabled = true;
                    txtDireccion.ReadOnly = false;
                    dtpFechaInauguracion.Enabled = true;
                    cboTipoSede.Enabled = true;
                    txtCantAulas.Enabled = true;
                    txtCantAulas.ReadOnly = false;
                    txtAforo.Enabled = true;
                    txtAforo.ReadOnly = false;
                    txtDNIEjecutivoResp.Enabled = true;
                    txtNombreEjecutivoResp.Enabled = true;
                    cbAuditorio.Enabled = true;
                    cbBiblioteca.Enabled = true;
                    cbEstacionamiento.Enabled = true;
                    cbSalasEstudio.Enabled = true;
                    cbCafeteria.Enabled = true;
                    txtClavePrograma.Enabled = true;
                    txtTipoPrograma.Enabled = true;
                    txtNombrePrograma.Enabled = true;
                    dgvProgramasAcademicos.Enabled = true;
                    break;
                case Estado.Buscar:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = false;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    btnSubirFoto.Enabled = false;
                    btnBuscarEjecutivoResponsable.Enabled = false;
                    btnBuscarPrograma.Enabled = false;
                    btnAgregarProgramaAcademico.Enabled = false;
                    btnEliminarProgramaAcademico.Enabled = false;
                    txtIDSede.Enabled = true;
                    txtNombre.Enabled = true;
                    txtNombre.ReadOnly = true;
                    txtDireccion.Enabled = true;
                    txtDireccion.ReadOnly = true;
                    dtpFechaInauguracion.Enabled = false;
                    cboTipoSede.Enabled = false;
                    txtCantAulas.Enabled = true;
                    txtCantAulas.ReadOnly = true;
                    txtAforo.Enabled = true;
                    txtAforo.ReadOnly = true;
                    txtDNIEjecutivoResp.Enabled = true;
                    txtNombreEjecutivoResp.Enabled = true;
                    cbAuditorio.Enabled = false;
                    cbBiblioteca.Enabled = false;
                    cbEstacionamiento.Enabled = false;
                    cbSalasEstudio.Enabled = false;
                    cbCafeteria.Enabled = false;
                    txtClavePrograma.Enabled = false;
                    txtTipoPrograma.Enabled = false;
                    txtNombrePrograma.Enabled = false;
                    dgvProgramasAcademicos.Enabled = true;
                    break;
            }
        }

        public void limpiarComponentes()
        {
            txtIDSede.Text = "";
            txtNombre.Text = "";
            txtDireccion.Text = "";
            dtpFechaInauguracion.Value = DateTime.Now;
            cboTipoSede.SelectedIndex = -1;
            txtCantAulas.Text = "";
            txtAforo.Text = "";
            pbFoto.Image = null;
            txtDNIEjecutivoResp.Text = "";
            txtNombreEjecutivoResp.Text = "";
            cbAuditorio.Checked = false;
            cbBiblioteca.Checked = false;
            cbEstacionamiento.Checked = false;
            cbSalasEstudio.Checked = false;
            cbCafeteria.Checked = false;
            dgvProgramasAcademicos.DataSource = null;
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            limpiarComponentes();
            establecerEstadoComponentes();
            sede = new Sede();
            sede.ProgramasAcademicos = new BindingList<ProgramaAcademico>();
            dgvProgramasAcademicos.DataSource = sede.ProgramasAcademicos;
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            limpiarComponentes();
            establecerEstadoComponentes();
        }

        private void btnSubirFoto_Click(object sender, EventArgs e)
        {
            try
            {
                if (ofdFoto.ShowDialog() == DialogResult.OK)
                {
                    _rutaFotoLocal = ofdFoto.FileName;
                    pbFoto.Image = Image.FromFile(_rutaFotoLocal);
                    FileStream fs = new FileStream(_rutaFotoLocal, FileMode.Open, FileAccess.Read);
                    BinaryReader br = new BinaryReader(fs);
                    sede.Foto = br.ReadBytes((int)fs.Length);
                    fs.Close();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("El archivo seleccionado no es un tipo de imagen válido");
            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmBusquedaSedes frmBusqSed = new frmBusquedaSedes();
            if (frmBusqSed.ShowDialog() == DialogResult.OK)
            {
                sede = frmBusqSed.SedeSeleccionada;
                txtIDSede.Text = sede.IdSede.ToString();
                txtNombre.Text = sede.Nombre;
                txtDireccion.Text = sede.Direccion;
                dtpFechaInauguracion.Value = sede.FechaInauguracion;
                cboTipoSede.SelectedValue = sede.TipoSede.IdTipoSede;
                txtCantAulas.Text = sede.CantidadAulas.ToString();
                txtAforo.Text = sede.AforoTotal.ToString();
                txtDNIEjecutivoResp.Text = sede.Ejecutivo.DNI;
                txtNombreEjecutivoResp.Text = sede.Ejecutivo.Nombre + " " + sede.Ejecutivo.ApellidoPaterno;

                if (sede.TieneAuditorio == true)
                {
                    cbAuditorio.Checked = true;
                }
                else
                {
                    cbAuditorio.Checked = false;
                }

                if (sede.TieneBiblioteca == true)
                {
                    cbBiblioteca.Checked = true;
                }
                else
                {
                    cbBiblioteca.Checked = false;
                }

                if (sede.TieneCafeteria == true)
                {
                    cbCafeteria.Checked = true;
                }
                else
                {
                    cbCafeteria.Checked = false;
                }

                if (sede.TieneEstacionamiento == true)
                {
                    cbEstacionamiento.Checked = true;
                }
                else
                {
                    cbEstacionamiento.Checked = false;
                }

                if (sede.TieneSalasEstudio == true)
                {
                    cbSalasEstudio.Checked = true;
                }
                else
                {
                    cbSalasEstudio.Checked = false;
                }

                MemoryStream ms = new MemoryStream(sede.Foto);
                pbFoto.Image = new Bitmap(ms);

                dgvProgramasAcademicos.DataSource = daoProgramaAcademico.listarPorIdSede(sede.IdSede);

            }
            _estado = Estado.Buscar;
            establecerEstadoComponentes();


        }

        private void btnBuscarEjecutivoResponsable_Click(object sender, EventArgs e)
        {
            frmBusquedaEjecutivos frmBusqEj = new frmBusquedaEjecutivos();
            if(frmBusqEj.ShowDialog() == DialogResult.OK)
            {
                sede.Ejecutivo = new Ejecutivo();
                sede.Ejecutivo = frmBusqEj.EjecutivoSeleccionado;
                txtDNIEjecutivoResp.Text = sede.Ejecutivo.DNI;
                txtNombreEjecutivoResp.Text = sede.Ejecutivo.Nombre + " " + sede.Ejecutivo.ApellidoPaterno;
            }
        }

        private void cboTipoSede_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnBuscarPrograma_Click(object sender, EventArgs e)
        {
            frmBusquedaProgramasAcademicos frmBusqProgAca = new frmBusquedaProgramasAcademicos();
            if(frmBusqProgAca.ShowDialog() == DialogResult.OK)
            {
                programaAcademico = frmBusqProgAca.ProgramaAcademicoSeleccionado;
                txtClavePrograma.Text = programaAcademico.Clave;
                txtNombrePrograma.Text = programaAcademico.Nombre;
                if(programaAcademico.TipoProgramaAcademico == 'C')
                {
                    txtTipoPrograma.Text = "CURSO";
                }
                else
                {
                    txtTipoPrograma.Text = "TALLER";
                }
                //txtTipoPrograma.Text = programaAcademico.TipoProgramaAcademico.ToString();
            }
        }

        private void btnAgregarProgramaAcademico_Click(object sender, EventArgs e)
        {
            //ProgramaAcademico progAc = new ProgramaAcademico();
            //progAc = programaAcademico;
            if (txtNombrePrograma.Text == "")
            {
                MessageBox.Show("Debe seleccionar un programa academico", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
            this.sede.ProgramasAcademicos.Add(programaAcademico);
            txtNombrePrograma.Text = "";
            txtTipoPrograma.Text = "";
            txtClavePrograma.Text = "";
        }

        private void btnEliminarProgramaAcademico_Click(object sender, EventArgs e)
        {
            if (dgvProgramasAcademicos.CurrentRow != null)
            {
                ProgramaAcademico progAcad = (ProgramaAcademico)dgvProgramasAcademicos.CurrentRow.DataBoundItem;
                this.sede.ProgramasAcademicos.Remove(progAcad);
                txtNombrePrograma.Text = "";
                txtTipoPrograma.Text = "";
                txtClavePrograma.Text = "";
            }
            else
            {
                MessageBox.Show("Debe seleccionar una linea de orden de venta", "Mensaje de advertencia", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }
        }

        private void dgvProgramasAcademicos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            try
            {
                ProgramaAcademico progAc = (ProgramaAcademico)dgvProgramasAcademicos.Rows[e.RowIndex].DataBoundItem;
                dgvProgramasAcademicos.Rows[e.RowIndex].Cells[0].Value = progAc.IdProgramaAcademico;
                dgvProgramasAcademicos.Rows[e.RowIndex].Cells[1].Value = progAc.Clave;
                dgvProgramasAcademicos.Rows[e.RowIndex].Cells[2].Value = progAc.Nombre;
                if (progAc.TipoProgramaAcademico == 'C')
                {
                    Curso curso = (Curso)dgvProgramasAcademicos.Rows[e.RowIndex].DataBoundItem;
                    dgvProgramasAcademicos.Rows[e.RowIndex].Cells[3].Value = curso.CantidadCreditos;
                    dgvProgramasAcademicos.Rows[e.RowIndex].Cells[4].Value = curso.FechaInicio.ToString("dd-MM-yyyy");
                }
                else
                {
                    Taller taller = (Taller)dgvProgramasAcademicos.Rows[e.RowIndex].DataBoundItem;
                    dgvProgramasAcademicos.Rows[e.RowIndex].Cells[3].Value = taller.CantidadHoras;
                    dgvProgramasAcademicos.Rows[e.RowIndex].Cells[4].Value = taller.FechaRealizacion.ToString("dd-MM-yyyy");
                }
            }
            catch (Exception ex)
            {

            }
        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            sede.Nombre = txtNombre.Text;
            sede.Direccion = txtDireccion.Text;
            sede.FechaInauguracion = dtpFechaInauguracion.Value;
            sede.TipoSede = new TipoSede();
            sede.TipoSede.IdTipoSede = (int)cboTipoSede.SelectedValue;
            sede.CantidadAulas = Int32.Parse(txtCantAulas.Text);
            sede.AforoTotal = Int32.Parse(txtAforo.Text);

            if (cbAuditorio.Checked == true)
            {
                sede.TieneAuditorio = true;
            }
            else
            {
                sede.TieneAuditorio = false;
            }

            if (cbBiblioteca.Checked == true)
            {
                sede.TieneBiblioteca = true;
            }
            else
            {
                sede.TieneBiblioteca = false;
            }

            if (cbCafeteria.Checked == true)
            {
                sede.TieneCafeteria = true;
            }
            else
            {
                sede.TieneCafeteria = false;
            }

            if (cbEstacionamiento.Checked == true)
            {
                sede.TieneEstacionamiento = true;
            }
            else
            {
                sede.TieneEstacionamiento = false;
            }

            if (cbSalasEstudio.Checked == true)
            {
                sede.TieneSalasEstudio = true;
            }
            else
            {
                sede.TieneSalasEstudio = false;
            }
            int resultado = daoSede.insertar(sede);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha registrado con éxito", "Mensaje de confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                txtIDSede.Text = resultado.ToString();
                _estado = Estado.Inicial;
                establecerEstadoComponentes();
            }
            else
                MessageBox.Show("Ha ocurrido un error con el registro", "Mensaje de error", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void dgvProgramasAcademicos_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
