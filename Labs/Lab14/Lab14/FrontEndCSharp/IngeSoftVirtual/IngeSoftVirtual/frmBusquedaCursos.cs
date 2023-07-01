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

    public partial class frmListarCursos : Form
    {
        private ServiciosWSClient servicioWS;
        private curso cursoSeleccionado;
        public frmListarCursos()
        {
            InitializeComponent();
            dgvCursos.AutoGenerateColumns = false;
            servicioWS = new ServiciosWSClient();
        }

        public curso CursoSeleccionado { get => cursoSeleccionado; set => cursoSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvCursos.DataSource = servicioWS.listarCursosPorNombre(txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            cursoSeleccionado = (curso)dgvCursos.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void dgvCursos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            curso curso = (curso)
                dgvCursos.Rows[e.RowIndex].DataBoundItem;
            dgvCursos.Rows[e.RowIndex].
                Cells[0].Value = curso.idCurso;
            dgvCursos.Rows[e.RowIndex].
                Cells[1].Value = curso.nombre;
            dgvCursos.Rows[e.RowIndex].
                Cells[2].Value = curso.especialidad;
        }
    }
}
