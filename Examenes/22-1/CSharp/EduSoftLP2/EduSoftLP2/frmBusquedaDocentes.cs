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
    public partial class frmBusquedaDocentes : Form
    {
        DocenteDAO daoDocente;
        Docente docenteSeleccionado;
        public frmBusquedaDocentes()
        {
            InitializeComponent();
            dgvDocentes.AutoGenerateColumns = false;

        }

        public Docente DocenteSeleccionado { get => docenteSeleccionado; set => docenteSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            daoDocente = new DocenteMySQL();
            dgvDocentes.DataSource = daoDocente.listarPorNombreCodigo(txtNombreCodigo.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvDocentes.CurrentRow != null)
            {
                docenteSeleccionado = (Docente)dgvDocentes.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }

        private void dgvDocentes_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dgvDocentes_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            Docente doc = (Docente)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
            if (doc.CodigoPUCP[0]=='E')
            {
                DocenteExtranjero docExt = (DocenteExtranjero)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
                dgvDocentes.Rows[e.RowIndex].Cells[0].Value = docExt.CodigoPUCP;
                dgvDocentes.Rows[e.RowIndex].Cells[1].Value = "Extranjero";
                dgvDocentes.Rows[e.RowIndex].Cells[2].Value = docExt.Nombre + " " + docExt.ApellidoPaterno;
                dgvDocentes.Rows[e.RowIndex].Cells[3].Value = docExt.Filiacion.Siglas;
            }
            else
            {
                DocentePUCP docpucp = (DocentePUCP)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
                dgvDocentes.Rows[e.RowIndex].Cells[0].Value = docpucp.CodigoPUCP;
                dgvDocentes.Rows[e.RowIndex].Cells[1].Value = "PUCP";
                dgvDocentes.Rows[e.RowIndex].Cells[2].Value = docpucp.Nombre + " " + docpucp.ApellidoPaterno;
                dgvDocentes.Rows[e.RowIndex].Cells[3].Value = docpucp.Categoria;
            }
            
        }
    }
}
