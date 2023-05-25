using EduSoftController.DAO;
using EduSoftController.MySQL;
using EduSoftModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EduSoft
{
    public partial class frmBusquedaEjecutivos : Form
    {
        EjecutivoDAO daoEjecutivo;
        Ejecutivo ejecutivoSeleccionado;
        public frmBusquedaEjecutivos()
        {
            InitializeComponent();
            dgvEjecutivos.AutoGenerateColumns = false;
            daoEjecutivo = new EjecutivoMySQL();
        }

        public Ejecutivo EjecutivoSeleccionado { get => ejecutivoSeleccionado; set => ejecutivoSeleccionado = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvEjecutivos.DataSource = daoEjecutivo.listarPorNombreDNI(txtNombreDNI.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            if (dgvEjecutivos.CurrentRow != null)
            {
                ejecutivoSeleccionado = (Ejecutivo)dgvEjecutivos.CurrentRow.DataBoundItem;
                this.DialogResult = DialogResult.OK;
            }
        }

        private void dgvEjecutivos_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void dgvEjecutivos_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            try
            {
                Ejecutivo ejec = (Ejecutivo)dgvEjecutivos.Rows[e.RowIndex].DataBoundItem;
                dgvEjecutivos.Rows[e.RowIndex].Cells[0].Value = ejec.DNI    ;
                dgvEjecutivos.Rows[e.RowIndex].Cells[1].Value = ejec.Nombre + " " + ejec.ApellidoPaterno;
            }
            catch (Exception ex)
            {

            }
        }
    }
}
