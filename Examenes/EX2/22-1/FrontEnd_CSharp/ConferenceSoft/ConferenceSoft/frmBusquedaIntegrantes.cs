using ConferenceSoft.serviciosWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ConferenceSoft
{
    public partial class frmBusquedaIntegrantes : Form
    {
        private ServiciosWSClient serviciosWS;
        private integrante integranteSeleccionado;
        public frmBusquedaIntegrantes()
        {
            InitializeComponent();
            serviciosWS = new ServiciosWSClient();
            rbTodos.Checked = true;
            dgvIntegrantes.AutoGenerateColumns = false;
        }

        public integrante IntegranteSeleccionado { get => integranteSeleccionado; set => integranteSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            char tipo;
            if(rbTodos.Checked==true) {
                tipo = 'T';
            }else if(rbAlumnos.Checked==true)
            {
                tipo = 'A';
            }else if(rbDocentes.Checked==true) {
                tipo = 'D';
            }
            else
            {
                tipo = 'E';
            }
            dgvIntegrantes.DataSource = serviciosWS.listarIntegrantesPorNombreTipo(txtNombre.Text, tipo);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            integranteSeleccionado = (integrante)
               dgvIntegrantes.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void dgvIntegrantes_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            integrante integrante = (integrante)
               dgvIntegrantes.Rows[e.RowIndex].DataBoundItem;
            dgvIntegrantes.Rows[e.RowIndex].
                Cells[0].Value = integrante.codigoPUCP;
            dgvIntegrantes.Rows[e.RowIndex].
                Cells[1].Value = integrante.nombre+" "+ integrante.apellidoPaterno;
            dgvIntegrantes.Rows[e.RowIndex].
                Cells[2].Value = integrante.tipoIntegrante.descripcion;
        }
    }
}
