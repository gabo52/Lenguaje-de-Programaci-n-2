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
    public partial class frmBusquedaProyectos : Form
    {
        ProyectoDAO daoProyecto;
        Proyecto proyectoSeleccionado;

        public Proyecto ProyectoSeleccionado { get => proyectoSeleccionado; set => proyectoSeleccionado = value; }

        public frmBusquedaProyectos()
        {
            InitializeComponent();
            dgvProyectos.AutoGenerateColumns = false;
            daoProyecto = new ProyectoMySQL();
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvProyectos.DataSource = daoProyecto.listarXTituloCodigoPUCPNombre(txtTituloCodigoNombre.Text);
        }

        private void dgvProyectos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            Proyecto proyecto = (Proyecto)dgvProyectos.Rows[e.RowIndex].DataBoundItem;
            dgvProyectos.Rows[e.RowIndex].Cells[0].Value = proyecto.Titulo;
            dgvProyectos.Rows[e.RowIndex].Cells[1].Value = proyecto.Estudiante.Nombre;
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvProyectos.CurrentRow != null)
            {
                proyectoSeleccionado = (Proyecto)dgvProyectos.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
