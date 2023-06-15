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
    
    public partial class frmBusquedaEditoriales : Form
    {
        private editorial editorialSeleccionada;
        private ServiciosWSClient servicioWS;
        public frmBusquedaEditoriales()
        {
            InitializeComponent();
            dgvEditoriales.AutoGenerateColumns = false;
            servicioWS = new ServiciosWSClient();
        }

        public editorial EditorialSeleccionada { get => editorialSeleccionada; set => editorialSeleccionada = value; }

        private void btnBuscar_Click(object sender, EventArgs e)
        {
            dgvEditoriales.DataSource= servicioWS.listarEditorialPorNombre(txtNombre.Text);
        }

        private void btnSeleccionar_Click(object sender, EventArgs e)
        {
            editorialSeleccionada = (editorial)dgvEditoriales.CurrentRow.DataBoundItem;
            this.DialogResult = DialogResult.OK;
        }

        private void dgvEditoriales_CellFormatting(object sender, DataGridViewCellFormattingEventArgs e)
        {
            editorial editorial = (editorial)
                dgvEditoriales.Rows[e.RowIndex].DataBoundItem;
            dgvEditoriales.Rows[e.RowIndex].
                Cells[0].Value = editorial.idEditorial;
            dgvEditoriales.Rows[e.RowIndex].
                Cells[1].Value = editorial.nombre;
        }
    }
}
