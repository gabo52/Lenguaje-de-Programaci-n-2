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
    public partial class frmBusquedaPeliculas : Form
    {
        pelicula peliculaSeleccionada;
        ServiciosWSClient serviciosWS;
        public frmBusquedaPeliculas()
        {
            InitializeComponent();
            dgvPeliculas.AutoGenerateColumns = false;
            serviciosWS= new ServiciosWSClient();
        }

        public pelicula PeliculaSeleccionada { get => peliculaSeleccionada; set => peliculaSeleccionada = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvPeliculas.DataSource = serviciosWS.listarPeliculasPorTitulo(txtTitulo.Text);
        }

        private void dgvPeliculas_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            ServiciosWS.pelicula pelicula = (pelicula)
            dgvPeliculas.Rows[e.RowIndex].DataBoundItem;
            dgvPeliculas.Rows[e.RowIndex].
                Cells[0].Value = pelicula.idPelicula;
            dgvPeliculas.Rows[e.RowIndex].
                Cells[1].Value = pelicula.titulo;
            dgvPeliculas.Rows[e.RowIndex].
                Cells[2].Value = pelicula.duracion;
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            peliculaSeleccionada = (pelicula)
                dgvPeliculas.CurrentRow.DataBoundItem;
            peliculaSeleccionada.actores
                = serviciosWS.listarActoresPorIdPelicula
                (peliculaSeleccionada.idPelicula);
            this.DialogResult = DialogResult.OK;
        }
    }
}
