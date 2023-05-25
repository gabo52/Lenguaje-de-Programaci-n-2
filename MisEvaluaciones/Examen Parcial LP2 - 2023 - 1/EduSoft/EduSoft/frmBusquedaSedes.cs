using EduSoftController.DAO;
using EduSoftController.MySQL;
using EduSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EduSoft
{
    public partial class frmBusquedaSedes : Form
    {
        ProgramaAcademicoDAO daoProgramaAcademico;
        SedeDAO daoSede;
        Sede sedeSeleccionada;
        public frmBusquedaSedes()
        {
            InitializeComponent();
            daoProgramaAcademico = new ProgramaAcademicoMySQL();
            daoSede = new SedeMySQL();
            dgvSedes.AutoGenerateColumns = false;
        }

        public Sede SedeSeleccionada { get => sedeSeleccionada; set => sedeSeleccionada = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvSedes.DataSource = daoSede.listarPorNombre(txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            sedeSeleccionada = (Sede)
                dgvSedes.CurrentRow.DataBoundItem;
            sedeSeleccionada.ProgramasAcademicos = daoProgramaAcademico.listarPorIdSede(sedeSeleccionada.IdSede);
            this.DialogResult = DialogResult.OK;
        }

        private void dgvSedes_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            Sede sede = (Sede)dgvSedes.Rows[e.RowIndex].DataBoundItem;
            dgvSedes.Rows[e.RowIndex].Cells[0].Value = sede.IdSede;
            dgvSedes.Rows[e.RowIndex].Cells[1].Value = sede.Nombre;
            dgvSedes.Rows[e.RowIndex].Cells[2].Value = sede.Direccion;
        }

        private void txtNombre_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
