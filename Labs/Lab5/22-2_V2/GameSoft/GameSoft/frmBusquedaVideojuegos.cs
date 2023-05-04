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
        VideojuegoDAO daoVideojuego;
        Videojuego videojuegoSeleccionado;
        public frmBusquedaVideojuegos()
        {
            InitializeComponent();
            daoVideojuego = new VideojuegoMySQL();
            dgvVideojuegos.AutoGenerateColumns = false;
        }

        public Videojuego VideojuegoSeleccionado { get => videojuegoSeleccionado; set => videojuegoSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvVideojuegos.DataSource = daoVideojuego.listarVideojuegosNombre(txtNombre.Text);

        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvVideojuegos.CurrentRow != null)
            {
                VideojuegoSeleccionado = (Videojuego)dgvVideojuegos.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
