using EduSoftLP2Controller.DAO;
using EduSoftLP2Controller.MySQL;
using EduSoftLP2Model;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EduSoftLP2
{
    public partial class frmBusquedaCursos : Form
    {
        CursoDAO daoCurso;
        Curso cursoSeleccionado;
        public frmBusquedaCursos()
        {
            InitializeComponent();
            daoCurso = new CursoMySQL();
            dgvCursos.AutoGenerateColumns = false;
        }

        public Curso CursoSeleccionado { get => cursoSeleccionado; set => cursoSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvCursos.DataSource = daoCurso.listarPorNombreClave(txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvCursos.CurrentRow != null)
            {
                cursoSeleccionado = (Curso)dgvCursos.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }

        private void dgvCursos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            Curso cur = (Curso)dgvCursos.Rows[e.RowIndex].DataBoundItem;
            dgvCursos.Rows[e.RowIndex].Cells[0].Value = cur.IdCurso;
            dgvCursos.Rows[e.RowIndex].Cells[1].Value = cur.Clave;
            dgvCursos.Rows[e.RowIndex].Cells[2].Value = cur.Nombre;
            dgvCursos.Rows[e.RowIndex].Cells[3].Value = cur.Semestre;
            dgvCursos.Rows[e.RowIndex].Cells[4].Value = cur.Modalidad.ToString();
        }
    }
}
