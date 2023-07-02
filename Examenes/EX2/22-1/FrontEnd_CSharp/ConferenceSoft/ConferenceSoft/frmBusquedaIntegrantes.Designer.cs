namespace ConferenceSoft
{
    partial class frmBusquedaIntegrantes
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblTipoIntegrante = new System.Windows.Forms.Label();
            this.rbTodos = new System.Windows.Forms.RadioButton();
            this.rbDocentes = new System.Windows.Forms.RadioButton();
            this.rbAlumnos = new System.Windows.Forms.RadioButton();
            this.dgvIntegrantes = new System.Windows.Forms.DataGridView();
            this.CodigoPUCP = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NombreCompleto = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.TipoIntegrante = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.lblNombre = new System.Windows.Forms.Label();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.btnSeleccionar = new System.Windows.Forms.Button();
            this.rbEgresados = new System.Windows.Forms.RadioButton();
            this.btnBuscar = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dgvIntegrantes)).BeginInit();
            this.SuspendLayout();
            // 
            // lblTipoIntegrante
            // 
            this.lblTipoIntegrante.AutoSize = true;
            this.lblTipoIntegrante.Location = new System.Drawing.Point(17, 16);
            this.lblTipoIntegrante.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblTipoIntegrante.Name = "lblTipoIntegrante";
            this.lblTipoIntegrante.Size = new System.Drawing.Size(119, 16);
            this.lblTipoIntegrante.TabIndex = 0;
            this.lblTipoIntegrante.Text = "Tipo de Integrante:";
            // 
            // rbTodos
            // 
            this.rbTodos.AutoSize = true;
            this.rbTodos.Location = new System.Drawing.Point(155, 14);
            this.rbTodos.Margin = new System.Windows.Forms.Padding(4);
            this.rbTodos.Name = "rbTodos";
            this.rbTodos.Size = new System.Drawing.Size(68, 20);
            this.rbTodos.TabIndex = 1;
            this.rbTodos.TabStop = true;
            this.rbTodos.Text = "Todos";
            this.rbTodos.UseVisualStyleBackColor = true;
            // 
            // rbDocentes
            // 
            this.rbDocentes.AutoSize = true;
            this.rbDocentes.Location = new System.Drawing.Point(240, 14);
            this.rbDocentes.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.rbDocentes.Name = "rbDocentes";
            this.rbDocentes.Size = new System.Drawing.Size(86, 20);
            this.rbDocentes.TabIndex = 2;
            this.rbDocentes.TabStop = true;
            this.rbDocentes.Text = "Docentes";
            this.rbDocentes.UseVisualStyleBackColor = true;
            // 
            // rbAlumnos
            // 
            this.rbAlumnos.AutoSize = true;
            this.rbAlumnos.Location = new System.Drawing.Point(453, 14);
            this.rbAlumnos.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.rbAlumnos.Name = "rbAlumnos";
            this.rbAlumnos.Size = new System.Drawing.Size(80, 20);
            this.rbAlumnos.TabIndex = 3;
            this.rbAlumnos.TabStop = true;
            this.rbAlumnos.Text = "Alumnos";
            this.rbAlumnos.UseVisualStyleBackColor = true;
            // 
            // dgvIntegrantes
            // 
            this.dgvIntegrantes.AllowUserToAddRows = false;
            this.dgvIntegrantes.AllowUserToDeleteRows = false;
            this.dgvIntegrantes.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvIntegrantes.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.CodigoPUCP,
            this.NombreCompleto,
            this.TipoIntegrante});
            this.dgvIntegrantes.Location = new System.Drawing.Point(12, 85);
            this.dgvIntegrantes.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.dgvIntegrantes.Name = "dgvIntegrantes";
            this.dgvIntegrantes.ReadOnly = true;
            this.dgvIntegrantes.RowHeadersWidth = 51;
            this.dgvIntegrantes.RowTemplate.Height = 24;
            this.dgvIntegrantes.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvIntegrantes.Size = new System.Drawing.Size(1017, 261);
            this.dgvIntegrantes.TabIndex = 4;
            this.dgvIntegrantes.CellFormatting += new System.Windows.Forms.DataGridViewCellFormattingEventHandler(this.dgvIntegrantes_CellFormatting);
            // 
            // CodigoPUCP
            // 
            this.CodigoPUCP.HeaderText = "Código PUCP";
            this.CodigoPUCP.MinimumWidth = 6;
            this.CodigoPUCP.Name = "CodigoPUCP";
            this.CodigoPUCP.ReadOnly = true;
            this.CodigoPUCP.Width = 120;
            // 
            // NombreCompleto
            // 
            this.NombreCompleto.HeaderText = "Nombre Completo";
            this.NombreCompleto.MinimumWidth = 6;
            this.NombreCompleto.Name = "NombreCompleto";
            this.NombreCompleto.ReadOnly = true;
            this.NombreCompleto.Width = 300;
            // 
            // TipoIntegrante
            // 
            this.TipoIntegrante.HeaderText = "Tipo Integrante";
            this.TipoIntegrante.MinimumWidth = 6;
            this.TipoIntegrante.Name = "TipoIntegrante";
            this.TipoIntegrante.ReadOnly = true;
            this.TipoIntegrante.Width = 150;
            // 
            // lblNombre
            // 
            this.lblNombre.AutoSize = true;
            this.lblNombre.Location = new System.Drawing.Point(21, 47);
            this.lblNombre.Name = "lblNombre";
            this.lblNombre.Size = new System.Drawing.Size(202, 16);
            this.lblNombre.TabIndex = 5;
            this.lblNombre.Text = "Ingrese el nombre del integrante:";
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(240, 44);
            this.txtNombre.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(420, 22);
            this.txtNombre.TabIndex = 6;
            // 
            // btnSeleccionar
            // 
            this.btnSeleccionar.Location = new System.Drawing.Point(911, 41);
            this.btnSeleccionar.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnSeleccionar.Name = "btnSeleccionar";
            this.btnSeleccionar.Size = new System.Drawing.Size(119, 28);
            this.btnSeleccionar.TabIndex = 8;
            this.btnSeleccionar.Text = "Seleccionar";
            this.btnSeleccionar.UseVisualStyleBackColor = true;
            this.btnSeleccionar.Click += new System.EventHandler(this.btnSeleccionar_Click);
            // 
            // rbEgresados
            // 
            this.rbEgresados.AutoSize = true;
            this.rbEgresados.Location = new System.Drawing.Point(341, 14);
            this.rbEgresados.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.rbEgresados.Name = "rbEgresados";
            this.rbEgresados.Size = new System.Drawing.Size(95, 20);
            this.rbEgresados.TabIndex = 9;
            this.rbEgresados.TabStop = true;
            this.rbEgresados.Text = "Egresados";
            this.rbEgresados.UseVisualStyleBackColor = true;
            // 
            // btnBuscar
            // 
            this.btnBuscar.Location = new System.Drawing.Point(668, 43);
            this.btnBuscar.Margin = new System.Windows.Forms.Padding(4);
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(100, 28);
            this.btnBuscar.TabIndex = 10;
            this.btnBuscar.Text = "Buscar";
            this.btnBuscar.UseVisualStyleBackColor = true;
            this.btnBuscar.Click += new System.EventHandler(this.btnBuscar_Click);
            // 
            // frmBusquedaIntegrantes
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1041, 358);
            this.Controls.Add(this.btnBuscar);
            this.Controls.Add(this.rbEgresados);
            this.Controls.Add(this.btnSeleccionar);
            this.Controls.Add(this.txtNombre);
            this.Controls.Add(this.lblNombre);
            this.Controls.Add(this.dgvIntegrantes);
            this.Controls.Add(this.rbAlumnos);
            this.Controls.Add(this.rbDocentes);
            this.Controls.Add(this.rbTodos);
            this.Controls.Add(this.lblTipoIntegrante);
            this.Margin = new System.Windows.Forms.Padding(4);
            this.Name = "frmBusquedaIntegrantes";
            this.Text = "Formulario de Búsqueda de Integrantes";
            ((System.ComponentModel.ISupportInitialize)(this.dgvIntegrantes)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblTipoIntegrante;
        private System.Windows.Forms.RadioButton rbTodos;
        private System.Windows.Forms.RadioButton rbDocentes;
        private System.Windows.Forms.RadioButton rbAlumnos;
        private System.Windows.Forms.DataGridView dgvIntegrantes;
        private System.Windows.Forms.Label lblNombre;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.Button btnSeleccionar;
        private System.Windows.Forms.RadioButton rbEgresados;
        private System.Windows.Forms.Button btnBuscar;
        private System.Windows.Forms.DataGridViewTextBoxColumn CodigoPUCP;
        private System.Windows.Forms.DataGridViewTextBoxColumn NombreCompleto;
        private System.Windows.Forms.DataGridViewTextBoxColumn TipoIntegrante;
    }
}