using IngeSoftVirtual.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace IngeSoftVirtual
{
    public partial class frmGestionarCursos : Form
    {
        private Estado _estado;
        private ServiciosWSClient serviciosWS;
        private curso curso;

        public frmGestionarCursos()
        {
            InitializeComponent();
            this._estado = Estado.Inicial;
            estadoComponentes();
            serviciosWS = new ServiciosWSClient();
            cboEspecialidad.ValueMember = "idEspecialidad";
            cboEspecialidad.DisplayMember = "nombre";
            cboEspecialidad.DataSource = serviciosWS.listarEspecialidadesTodas();
        }

        public void limpiarComponentes()
        {
            txtIDCurso.Text = "";
            txtClave.Text = "";
            txtCreditos.Text = "";
            txtNombre.Text = "";
            cboEspecialidad.SelectedIndex = -1;
            txtPrecio.Text = "";
            dtpFechaInicio.Value = DateTime.Today;
            dtpFechaFin.Value = DateTime.Today;
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
                    txtIDCurso.Enabled = false;
                    txtClave.Enabled = false;
                    txtCreditos.Enabled = false;
                    txtNombre.Enabled = false;
                    cboEspecialidad.Enabled = false;
                    txtPrecio.Enabled = false;
                    dtpFechaInicio.Enabled = false;
                    dtpFechaFin.Enabled = false;
                    break;
                case Estado.Nuevo:
                    btnNuevo.Enabled = false;
                    btnGuardar.Enabled = true;
                    btnBuscar.Enabled = false;
                    btnCancelar.Enabled = true;
                    txtIDCurso.Enabled = true;
                    txtClave.Enabled = true;
                    txtCreditos.Enabled = true;
                    txtNombre.Enabled = true;
                    cboEspecialidad.Enabled = true;
                    txtPrecio.Enabled = true;
                    dtpFechaInicio.Enabled = true;
                    dtpFechaFin.Enabled = true;
                    break;
            }
        }

        private void btnCancelar_Click(object sender, EventArgs e)
        {
            _estado = Estado.Inicial;
            estadoComponentes();
            limpiarComponentes();
        }

        private void btnNuevo_Click(object sender, EventArgs e)
        {
            _estado = Estado.Nuevo;
            estadoComponentes();
            limpiarComponentes();
            curso = new curso();
        }

        private void cboEspecialidad_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void btnGuardar_Click(object sender, EventArgs e)
        {
            curso.clave=txtClave.Text;
            curso.precio=Double.Parse(txtPrecio.Text);
            curso.creditos=Int32.Parse(txtCreditos.Text);
            curso.nombre=txtNombre.Text;
            curso.especialidad = new especialidad();
            curso.fechaInicio = dtpFechaInicio.Value;
            curso.fechaInicioSpecified = true;
            curso.fechaFin = dtpFechaFin.Value;
            curso.fechaFinSpecified = true;
            curso.especialidad.idEspecialidad = (int)cboEspecialidad.SelectedValue;
            int resultado = serviciosWS.insertarCurso(curso);
            if (resultado != 0)
            {
                MessageBox.Show("Se ha registrado con éxito", "Mensaje de confirmación", MessageBoxButtons.OK, MessageBoxIcon.Information);
                _estado = Estado.Inicial;
                estadoComponentes();
            }
            else
                MessageBox.Show("Ha ocurrido un error con el registro", "Mensaje de error", MessageBoxButtons.OK, MessageBoxIcon.Error);
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            frmListarCursos frmListCur = new frmListarCursos();
            if(frmListCur.ShowDialog() == DialogResult.OK)
            {
                curso = frmListCur.CursoSeleccionado;
                txtClave.Text = curso.clave;
                txtCreditos.Text = curso.creditos.ToString();
                txtNombre.Text = curso.nombre;
                cboEspecialidad.SelectedValue = curso.especialidad.idEspecialidad;
                dtpFechaFin.Value = curso.fechaFin;
                dtpFechaInicio.Value = curso.fechaInicio;
                txtIDCurso.Text = curso.idCurso.ToString();
                txtPrecio.Text = curso.precio.ToString();
                _estado = Estado.Buscar;
                estadoComponentes();
            }
        }
    }
}
