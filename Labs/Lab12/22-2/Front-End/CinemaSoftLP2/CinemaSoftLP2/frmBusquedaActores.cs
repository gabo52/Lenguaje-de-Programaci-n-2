using CinemaSoftLP2.ServiciosWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CinemaSoftLP2
{
    public partial class frmBusquedaActores : Form
    {
        ServiciosWSClient servicioWS;
        actor actorSeleccionado;

        public actor ActorSeleccionado { get => actorSeleccionado; set => actorSeleccionado = value; }

        public frmBusquedaActores()
        {
            InitializeComponent();
            dgvActores.AutoGenerateColumns = false;
            servicioWS = new ServiciosWSClient();
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvActores.DataSource = servicioWS.listarActoresPorNombre(txtNombre.Text);
        }

        private void dgvActores_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            actor actor = (actor)
                dgvActores.Rows[e.RowIndex].DataBoundItem;
            dgvActores.Rows[e.RowIndex].
                Cells[0].Value = actor.idActor;
            dgvActores.Rows[e.RowIndex].
                Cells[1].Value = actor.nombre + " " + actor.apellidoPaterno;
            dgvActores.Rows[e.RowIndex].
                Cells[2].Value = actor.nacionalidad;
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            actorSeleccionado = (actor)dgvActores.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }
    }
}
