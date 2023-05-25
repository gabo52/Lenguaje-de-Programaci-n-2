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
    public partial class frmBusquedaProgramasAcademicos : Form
    {
        ProgramaAcademicoDAO daoProgramaAcademico;
        ProgramaAcademico programaAcademicoSeleccionado;
        public frmBusquedaProgramasAcademicos()
        {
            InitializeComponent();
            dgvProgramas.Columns[2].HeaderCell.Style.Alignment = DataGridViewContentAlignment.MiddleCenter;
            dgvProgramas.Columns[3].HeaderCell.Style.Alignment = DataGridViewContentAlignment.MiddleCenter;
            dgvProgramas.AutoGenerateColumns = false;
            daoProgramaAcademico = new ProgramaAcademicoMySQL();
        }

        public ProgramaAcademico ProgramaAcademicoSeleccionado { get => programaAcademicoSeleccionado; set => programaAcademicoSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvProgramas.DataSource = daoProgramaAcademico.listarPorNombreClave(txtNombreClave.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvProgramas.CurrentRow != null)
            {

                programaAcademicoSeleccionado = (ProgramaAcademico)dgvProgramas.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }

        private void dgvProgramas_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            try
            {
                ProgramaAcademico progAc = (ProgramaAcademico)dgvProgramas.Rows[e.RowIndex].DataBoundItem;
                dgvProgramas.Rows[e.RowIndex].Cells[0].Value = progAc.IdProgramaAcademico;
                dgvProgramas.Rows[e.RowIndex].Cells[1].Value = progAc.Clave;
                dgvProgramas.Rows[e.RowIndex].Cells[2].Value = progAc.Nombre;
                if (progAc.TipoProgramaAcademico == 'C')
                {
                    Curso curso = (Curso)dgvProgramas.Rows[e.RowIndex].DataBoundItem;
                    dgvProgramas.Rows[e.RowIndex].Cells[3].Value = curso.CantidadCreditos;
                    dgvProgramas.Rows[e.RowIndex].Cells[4].Value = curso.FechaInicio.ToString("dd-MM-yyyy");
                }
                else
                {
                    Taller taller = (Taller)dgvProgramas.Rows[e.RowIndex].DataBoundItem;
                    dgvProgramas.Rows[e.RowIndex].Cells[3].Value = taller.CantidadHoras;
                    dgvProgramas.Rows[e.RowIndex].Cells[4].Value = taller.FechaRealizacion.ToString("dd-MM-yyyy");
                }
            }
            catch (Exception ex)
            {

            }
        }
    }
}
