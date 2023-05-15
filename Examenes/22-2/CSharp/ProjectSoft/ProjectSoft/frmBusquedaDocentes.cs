using ProjectSoftController.DAO;
using ProjectSoftController.MySQL;
using ProjectSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectSoft
{
    public partial class frmBusquedaDocentes : Form
    {
        DocenteDAO daoDocente;
        Docente docenteSeleccionado;
        public frmBusquedaDocentes()
        {
            InitializeComponent();
            daoDocente = new DocenteMySQL();
            dgvDocentes.AutoGenerateColumns = false;
        }

        public Docente DocenteSeleccionado { get => docenteSeleccionado; set => docenteSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvDocentes.DataSource = daoDocente.listarPorCodigoNombre(txtCodigoNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvDocentes.CurrentRow != null)
            {
                docenteSeleccionado = (Docente)dgvDocentes.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }
    }
}
