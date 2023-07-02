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
    public partial class frmBusquedaEventos : Form
    {
        ServiciosWSClient serviciosWS;
        evento eventoSeleccionado;

        public frmBusquedaEventos()
        {
            InitializeComponent();
            serviciosWS=new ServiciosWSClient();
            dgvEventos.AutoGenerateColumns = false;
        }

        public evento EventoSeleccionado { get => eventoSeleccionado; set => eventoSeleccionado = value; }

        private void dgvEventos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            evento evento = (evento)dgvEventos.Rows[e.RowIndex].DataBoundItem;
            dgvEventos.Rows[e.RowIndex].
                Cells[0].Value = evento.idEvento;
            dgvEventos.Rows[e.RowIndex].
                Cells[1].Value = evento.nombre;
            dgvEventos.Rows[e.RowIndex].
                Cells[2].Value = evento.fecha.ToString("dd-MM-yyyy");
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvEventos.DataSource = serviciosWS.listarEventosPorNombre(txtNombre.Text);

        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            eventoSeleccionado = (evento)dgvEventos.CurrentRow.DataBoundItem;
            eventoSeleccionado.ponencias = serviciosWS.listarPonenciasPorIdEvento(eventoSeleccionado.idEvento);
            this.DialogResult = DialogResult.OK;
        }
    }
}
