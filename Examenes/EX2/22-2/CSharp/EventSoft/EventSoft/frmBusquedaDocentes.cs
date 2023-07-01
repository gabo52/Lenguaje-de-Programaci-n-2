using EventSoft.ServiciosWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EventSoft
{
    public partial class frmBusquedaDocentes : Form
    {
        ServiciosWSClient serviciosWS;
        docente docenteSeleccionado;
        int idEspecialidad;

        public docente DocenteSeleccionado { get => docenteSeleccionado; set => docenteSeleccionado = value; }

        public frmBusquedaDocentes()
        {
            InitializeComponent();
            serviciosWS = new ServiciosWSClient();
            dgvDocentes.AutoGenerateColumns = false;
        }

        public frmBusquedaDocentes(int idEspecialidad)
        {
            InitializeComponent();
            serviciosWS = new ServiciosWSClient();
            dgvDocentes.AutoGenerateColumns = false;
            this.idEspecialidad = idEspecialidad;
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvDocentes.DataSource = serviciosWS.listarDocentesPorCodigoPUCPNombreIdEspecialidad(txtNombreCodigo.Text, idEspecialidad);
        }

        private void dgvDocentes_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            docente docente = (docente)dgvDocentes.Rows[e.RowIndex].DataBoundItem;
            dgvDocentes.Rows[e.RowIndex].Cells[0].Value = docente.idDocente;
            dgvDocentes.Rows[e.RowIndex].Cells[1].Value = docente.nombre + " "
                + docente.apellidoPaterno + " "+docente.apellidoMaterno;
            dgvDocentes.Rows[e.RowIndex].Cells[2].Value = docente.especialidad.nombre;
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvDocentes.CurrentRow != null)
            {
                docenteSeleccionado = (docente)dgvDocentes.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
