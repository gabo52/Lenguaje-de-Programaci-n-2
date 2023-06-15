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
    public partial class frmBusquedaLibros : Form
    {
        ServiciosWSClient serviciosWS;
        libro libroSeleccionado;
        public frmBusquedaLibros()
        {
            InitializeComponent();
            serviciosWS = new ServiciosWSClient();
            dgvLibros.AutoGenerateColumns=false;
        }

        public libro LibroSeleccionado { get => libroSeleccionado; set => libroSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvLibros.DataSource = serviciosWS.listarLibrosPorTituloOEditorial(txtTituloEditorial.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            libroSeleccionado = (libro)dgvLibros.CurrentRow.DataBoundItem;
            libroSeleccionado.autores = serviciosWS.listarAutoresPorIdLibro(libroSeleccionado.idLibro);
            this.DialogResult = DialogResult.OK;
        }

        private void dgvLibros_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            libro libro = (libro)
                dgvLibros.Rows[e.RowIndex].DataBoundItem;
            dgvLibros.Rows[e.RowIndex].
                Cells[0].Value = libro.idLibro;
            dgvLibros.Rows[e.RowIndex].
                Cells[1].Value = libro.titulo;

            dgvLibros.Rows[e.RowIndex].
                Cells[2].Value = libro.editorial.nombre;
            dgvLibros.Rows[e.RowIndex].
                Cells[3].Value = libro.precio;
        }
    }
}
