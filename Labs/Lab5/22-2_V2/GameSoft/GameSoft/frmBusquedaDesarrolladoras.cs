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
    public partial class frmBusquedaDesarrolladoras : Form
    {
        DesarrolladoraDAO daoDesarrolladora;
        Desarrolladora desarrolladoraSeleccionada;
        public frmBusquedaDesarrolladoras()
        {
            InitializeComponent();
            daoDesarrolladora = new DesarrolladoraMySQL();
            dgvDesarrolladoras.AutoGenerateColumns = false;
        }

        public Desarrolladora DesarrolladoraSeleccionada { get => desarrolladoraSeleccionada; set => desarrolladoraSeleccionada = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvDesarrolladoras.DataSource = daoDesarrolladora.listarDesarrolladorasNombre(txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if(dgvDesarrolladoras.CurrentRow != null)
            {
                DesarrolladoraSeleccionada = (Desarrolladora)dgvDesarrolladoras.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }

        private void dgvDesarrolladoras_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
