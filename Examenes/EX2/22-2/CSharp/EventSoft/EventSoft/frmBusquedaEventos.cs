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
    public partial class frmBusquedaEventos : Form
    {
        ServiciosWSClient servicioWS;
        private evento eventoSeleccionado;
        public frmBusquedaEventos()
        {
            InitializeComponent();
            dgvEventos.AutoGenerateColumns = false;
            servicioWS = new ServiciosWSClient();
        }

        public evento EventoSeleccionado { get => eventoSeleccionado; set => eventoSeleccionado = value; }

        private void dgvEventos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            try
            {
                evento evento = (evento)dgvEventos.Rows[e.RowIndex].DataBoundItem;
                dgvEventos.Rows[e.RowIndex].Cells[0].Value = evento.idEvento;
                dgvEventos.Rows[e.RowIndex].Cells[1].Value = evento.nombre;

            }
            catch (Exception ex)
            {

            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvEventos.DataSource = servicioWS.listarEventosPorNombre(txtNombreID.Text);

        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvEventos.CurrentRow != null)
            {
                eventoSeleccionado = (evento)dgvEventos.CurrentRow.DataBoundItem;
                eventoSeleccionado.responsables = servicioWS.listarDocentePorIdEvento(eventoSeleccionado.idEvento);
                eventoSeleccionado.actividades = servicioWS.listarActividadesPorIdEvento(eventoSeleccionado.idEvento);
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
