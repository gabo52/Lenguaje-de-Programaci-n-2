using RinconLibroSoft.ServiciosWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace RinconLibroSoft
{
    public partial class frmBusquedaAutores : Form
    {
        ServiciosWSClient serviciosWS;
        autor autorSeleccionado;
        public frmBusquedaAutores()
        {
            InitializeComponent();
            dgvAutores.AutoGenerateColumns = false;
            serviciosWS= new ServiciosWSClient();
        }

        public autor AutorSeleccionado { get => autorSeleccionado; set => autorSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvAutores.DataSource = serviciosWS.listarAutoresPorNombre(txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            autorSeleccionado = (autor)dgvAutores.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void dgvAutores_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            autor autor = (autor)
                dgvAutores.Rows[e.RowIndex].DataBoundItem;
            dgvAutores.Rows[e.RowIndex].
                Cells[0].Value = autor.idAutor;
            dgvAutores.Rows[e.RowIndex].
                Cells[1].Value = autor.nombre+" "+autor.apellidoPaterno;
            dgvAutores.Rows[e.RowIndex].
                Cells[2].Value = autor.nacionalidad;
        }
    }
}
