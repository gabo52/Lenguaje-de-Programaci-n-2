using ProjectSoftController.DAO;
using ProjectSoftController.MySQL;
using ProjectSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectSoft
{
    public partial class frmBusquedaEstudiantes : Form
    {
        EstudianteDAO daoEstudiante;
        private Estudiante estudianteSeleccionado;
        public frmBusquedaEstudiantes()
        {
            InitializeComponent();
            daoEstudiante = new EstudianteMySQL();
            dgvEstudiantes.AutoGenerateColumns = false;
        }

        public Estudiante EstudianteSeleccionado { get => estudianteSeleccionado; set => estudianteSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvEstudiantes.DataSource = daoEstudiante.listarPorNombreYCodigo(txtCodigoNombre.Text);
        }

        private void txtCodigoNombre_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvEstudiantes.CurrentRow != null)
            {
                estudianteSeleccionado = (Estudiante)dgvEstudiantes.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
