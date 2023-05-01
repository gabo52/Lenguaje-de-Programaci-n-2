using GameSoftController.DAO;
using GameSoftController.MySQL;
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
        public frmBusquedaDesarrolladoras()
        {
            InitializeComponent();
            daoDesarrolladora = new DesarrolladoraMySQL();

        }

        private void txtNombre_TextChanged(object sender, EventArgs e)
        {

        }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvDesarrolladoras.AutoGenerateColumns = false;
            dgvDesarrolladoras.DataSource = daoDesarrolladora.listarDesarrolladoresPorNombre(txtNombre.Text);
        }
    }
}
