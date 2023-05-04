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
        private DesarrolladoraDAO daoDesarrolladora;
        private Desarrolladora desarrolladoraSeleccionada;
        public frmBusquedaDesarrolladoras()
        {
            InitializeComponent();
            daoDesarrolladora = new DesarrolladoraMySQL();

        }

        public Desarrolladora DesarrolladoraSeleccionada { get => desarrolladoraSeleccionada; set => desarrolladoraSeleccionada = value; } 

        private void txtNombre_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvDesarrolladoras.AutoGenerateColumns = false;
            dgvDesarrolladoras.DataSource = daoDesarrolladora.listarDesarrolladoresPorNombre(txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if(dgvDesarrolladoras.CurrentRow != null)
            {
                desarrolladoraSeleccionada = (Desarrolladora)dgvDesarrolladoras.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }

        private void frmBusquedaDesarrolladoras_Load(object sender, EventArgs e)
        {

        }
    }
}
