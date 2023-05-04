using GameSoftController.DAO;
using GameSoftController.MySQL;
using GameSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GameSoft
{
    public partial class frmBusquedaVideojuegos : Form
    {
        Videojuego videojuegoSeleccionado;
        VideojuegoDAO daoVideojuego;
        public frmBusquedaVideojuegos()
        {
            InitializeComponent();
            daoVideojuego = new VideojuegoMySQL(); 
        }

       public Videojuego VideojuegoSeleccionado { get => videojuegoSeleccionado; set => videojuegoSeleccionado = value; }
        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvVideojuegos.CurrentRow != null)
            {
                videojuegoSeleccionado = (Videojuego)dgvVideojuegos.CurrentRow.DataBoundItem;

                this.DialogResult = DialogResult.OK;
            }
        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvVideojuegos.AutoGenerateColumns = false;
            dgvVideojuegos.DataSource = daoVideojuego.listarVideojuegosNombre(txtNombre.Text);
        }
    }
}
