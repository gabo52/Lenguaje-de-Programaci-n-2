namespace RinconLibroSoft
{
    partial class frmGestionarLibros
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmGestionarLibros));
            this.lblGestionLibros = new System.Windows.Forms.Label();
            this.tsMenu = new System.Windows.Forms.ToolStrip();
            this.btnNuevo = new System.Windows.Forms.ToolStripButton();
            this.btnGuardar = new System.Windows.Forms.ToolStripButton();
            this.btnBuscar = new System.Windows.Forms.ToolStripButton();
            this.btnCancelar = new System.Windows.Forms.ToolStripButton();
            this.gbDatosGenerales = new System.Windows.Forms.GroupBox();
            this.btnBuscarAutor = new System.Windows.Forms.Button();
            this.txtAutor = new System.Windows.Forms.TextBox();
            this.txtPrecio = new System.Windows.Forms.TextBox();
            this.lblPrecio = new System.Windows.Forms.Label();
            this.btnEliminarAutor = new System.Windows.Forms.Button();
            this.btnAgregarAutor = new System.Windows.Forms.Button();
            this.dgvAutores = new System.Windows.Forms.DataGridView();
            this.ID = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NombreCompleto = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Nacionalidad = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.lblAutores = new System.Windows.Forms.Label();
            this.dtpFechaPublicacion = new System.Windows.Forms.DateTimePicker();
            this.lblFechaPublicacion = new System.Windows.Forms.Label();
            this.btnBuscarEditorial = new System.Windows.Forms.Button();
            this.txtEditorial = new System.Windows.Forms.TextBox();
            this.lblEditorial = new System.Windows.Forms.Label();
            this.txtNroPaginas = new System.Windows.Forms.TextBox();
            this.lblNroPaginas = new System.Windows.Forms.Label();
            this.rbIngles = new System.Windows.Forms.RadioButton();
            this.rbEspanhol = new System.Windows.Forms.RadioButton();
            this.lblIdioma = new System.Windows.Forms.Label();
            this.txtTitulo = new System.Windows.Forms.TextBox();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.btnSubirFoto = new System.Windows.Forms.Button();
            this.pbPortada = new System.Windows.Forms.PictureBox();
            this.txtIDLibro = new System.Windows.Forms.TextBox();
            this.lblIDLibro = new System.Windows.Forms.Label();
            this.ofdPortada = new System.Windows.Forms.OpenFileDialog();
            this.tsMenu.SuspendLayout();
            this.gbDatosGenerales.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvAutores)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbPortada)).BeginInit();
            this.SuspendLayout();
            // 
            // lblGestionLibros
            // 
            this.lblGestionLibros.AutoSize = true;
            this.lblGestionLibros.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblGestionLibros.Location = new System.Drawing.Point(29, 42);
            this.lblGestionLibros.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblGestionLibros.Name = "lblGestionLibros";
            this.lblGestionLibros.Size = new System.Drawing.Size(339, 20);
            this.lblGestionLibros.TabIndex = 0;
            this.lblGestionLibros.Text = "Gestión de Libros - El Rincón del Libro";
            // 
            // tsMenu
            // 
            this.tsMenu.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.tsMenu.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.btnNuevo,
            this.btnGuardar,
            this.btnBuscar,
            this.btnCancelar});
            this.tsMenu.Location = new System.Drawing.Point(0, 0);
            this.tsMenu.Name = "tsMenu";
            this.tsMenu.Size = new System.Drawing.Size(1067, 27);
            this.tsMenu.TabIndex = 1;
            this.tsMenu.Text = "toolStrip1";
            // 
            // btnNuevo
            // 
            this.btnNuevo.Image = ((System.Drawing.Image)(resources.GetObject("btnNuevo.Image")));
            this.btnNuevo.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnNuevo.Name = "btnNuevo";
            this.btnNuevo.Size = new System.Drawing.Size(76, 24);
            this.btnNuevo.Text = "&Nuevo";
            this.btnNuevo.Click += new System.EventHandler(this.btnNuevo_Click);
            // 
            // btnGuardar
            // 
            this.btnGuardar.Image = ((System.Drawing.Image)(resources.GetObject("btnGuardar.Image")));
            this.btnGuardar.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(86, 24);
            this.btnGuardar.Text = "&Guardar";
            this.btnGuardar.Click += new System.EventHandler(this.btnGuardar_Click);
            // 
            // btnBuscar
            // 
            this.btnBuscar.Image = ((System.Drawing.Image)(resources.GetObject("btnBuscar.Image")));
            this.btnBuscar.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(76, 24);
            this.btnBuscar.Text = "&Buscar";
            this.btnBuscar.Click += new System.EventHandler(this.btnBuscar_Click);
            // 
            // btnCancelar
            // 
            this.btnCancelar.Image = ((System.Drawing.Image)(resources.GetObject("btnCancelar.Image")));
            this.btnCancelar.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(90, 24);
            this.btnCancelar.Text = "&Cancelar";
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // gbDatosGenerales
            // 
            this.gbDatosGenerales.Controls.Add(this.btnBuscarAutor);
            this.gbDatosGenerales.Controls.Add(this.txtAutor);
            this.gbDatosGenerales.Controls.Add(this.txtPrecio);
            this.gbDatosGenerales.Controls.Add(this.lblPrecio);
            this.gbDatosGenerales.Controls.Add(this.btnEliminarAutor);
            this.gbDatosGenerales.Controls.Add(this.btnAgregarAutor);
            this.gbDatosGenerales.Controls.Add(this.dgvAutores);
            this.gbDatosGenerales.Controls.Add(this.lblAutores);
            this.gbDatosGenerales.Controls.Add(this.dtpFechaPublicacion);
            this.gbDatosGenerales.Controls.Add(this.lblFechaPublicacion);
            this.gbDatosGenerales.Controls.Add(this.btnBuscarEditorial);
            this.gbDatosGenerales.Controls.Add(this.txtEditorial);
            this.gbDatosGenerales.Controls.Add(this.lblEditorial);
            this.gbDatosGenerales.Controls.Add(this.txtNroPaginas);
            this.gbDatosGenerales.Controls.Add(this.lblNroPaginas);
            this.gbDatosGenerales.Controls.Add(this.rbIngles);
            this.gbDatosGenerales.Controls.Add(this.rbEspanhol);
            this.gbDatosGenerales.Controls.Add(this.lblIdioma);
            this.gbDatosGenerales.Controls.Add(this.txtTitulo);
            this.gbDatosGenerales.Controls.Add(this.lblTitulo);
            this.gbDatosGenerales.Controls.Add(this.btnSubirFoto);
            this.gbDatosGenerales.Controls.Add(this.pbPortada);
            this.gbDatosGenerales.Controls.Add(this.txtIDLibro);
            this.gbDatosGenerales.Controls.Add(this.lblIDLibro);
            this.gbDatosGenerales.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gbDatosGenerales.Location = new System.Drawing.Point(16, 76);
            this.gbDatosGenerales.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.gbDatosGenerales.Name = "gbDatosGenerales";
            this.gbDatosGenerales.Padding = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.gbDatosGenerales.Size = new System.Drawing.Size(1035, 463);
            this.gbDatosGenerales.TabIndex = 2;
            this.gbDatosGenerales.TabStop = false;
            this.gbDatosGenerales.Text = "Datos Generales del Libro";
            // 
            // btnBuscarAutor
            // 
            this.btnBuscarAutor.Location = new System.Drawing.Point(716, 272);
            this.btnBuscarAutor.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnBuscarAutor.Name = "btnBuscarAutor";
            this.btnBuscarAutor.Size = new System.Drawing.Size(56, 28);
            this.btnBuscarAutor.TabIndex = 47;
            this.btnBuscarAutor.Text = "...";
            this.btnBuscarAutor.UseVisualStyleBackColor = true;
            this.btnBuscarAutor.Click += new System.EventHandler(this.btnBuscarAutor_Click);
            // 
            // txtAutor
            // 
            this.txtAutor.Location = new System.Drawing.Point(183, 274);
            this.txtAutor.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtAutor.Name = "txtAutor";
            this.txtAutor.ReadOnly = true;
            this.txtAutor.Size = new System.Drawing.Size(527, 23);
            this.txtAutor.TabIndex = 46;
            // 
            // txtPrecio
            // 
            this.txtPrecio.Location = new System.Drawing.Point(409, 218);
            this.txtPrecio.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtPrecio.Name = "txtPrecio";
            this.txtPrecio.Size = new System.Drawing.Size(121, 23);
            this.txtPrecio.TabIndex = 45;
            // 
            // lblPrecio
            // 
            this.lblPrecio.AutoSize = true;
            this.lblPrecio.Location = new System.Drawing.Point(339, 222);
            this.lblPrecio.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblPrecio.Name = "lblPrecio";
            this.lblPrecio.Size = new System.Drawing.Size(59, 17);
            this.lblPrecio.TabIndex = 44;
            this.lblPrecio.Text = "Precio:";
            // 
            // btnEliminarAutor
            // 
            this.btnEliminarAutor.Location = new System.Drawing.Point(959, 271);
            this.btnEliminarAutor.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnEliminarAutor.Name = "btnEliminarAutor";
            this.btnEliminarAutor.Size = new System.Drawing.Size(56, 28);
            this.btnEliminarAutor.TabIndex = 43;
            this.btnEliminarAutor.Text = "-";
            this.btnEliminarAutor.UseVisualStyleBackColor = true;
            this.btnEliminarAutor.Click += new System.EventHandler(this.btnEliminarAutor_Click);
            // 
            // btnAgregarAutor
            // 
            this.btnAgregarAutor.Location = new System.Drawing.Point(895, 271);
            this.btnAgregarAutor.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnAgregarAutor.Name = "btnAgregarAutor";
            this.btnAgregarAutor.Size = new System.Drawing.Size(56, 28);
            this.btnAgregarAutor.TabIndex = 42;
            this.btnAgregarAutor.Text = "+";
            this.btnAgregarAutor.UseVisualStyleBackColor = true;
            this.btnAgregarAutor.Click += new System.EventHandler(this.btnAgregarAutor_Click);
            // 
            // dgvAutores
            // 
            this.dgvAutores.AllowUserToAddRows = false;
            this.dgvAutores.AllowUserToDeleteRows = false;
            this.dgvAutores.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvAutores.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.ID,
            this.NombreCompleto,
            this.Nacionalidad});
            this.dgvAutores.Location = new System.Drawing.Point(25, 308);
            this.dgvAutores.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.dgvAutores.Name = "dgvAutores";
            this.dgvAutores.ReadOnly = true;
            this.dgvAutores.RowHeadersWidth = 51;
            this.dgvAutores.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvAutores.Size = new System.Drawing.Size(989, 134);
            this.dgvAutores.TabIndex = 41;
            this.dgvAutores.CellFormatting += new System.Windows.Forms.DataGridViewCellFormattingEventHandler(this.dgvAutores_CellFormatting);
            // 
            // ID
            // 
            this.ID.HeaderText = "ID";
            this.ID.MinimumWidth = 6;
            this.ID.Name = "ID";
            this.ID.ReadOnly = true;
            this.ID.Width = 70;
            // 
            // NombreCompleto
            // 
            this.NombreCompleto.HeaderText = "Nombre Completo";
            this.NombreCompleto.MinimumWidth = 6;
            this.NombreCompleto.Name = "NombreCompleto";
            this.NombreCompleto.ReadOnly = true;
            this.NombreCompleto.Width = 300;
            // 
            // Nacionalidad
            // 
            this.Nacionalidad.HeaderText = "Nacionalidad";
            this.Nacionalidad.MinimumWidth = 6;
            this.Nacionalidad.Name = "Nacionalidad";
            this.Nacionalidad.ReadOnly = true;
            this.Nacionalidad.Width = 200;
            // 
            // lblAutores
            // 
            this.lblAutores.AutoSize = true;
            this.lblAutores.Location = new System.Drawing.Point(21, 278);
            this.lblAutores.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblAutores.Name = "lblAutores";
            this.lblAutores.Size = new System.Drawing.Size(150, 17);
            this.lblAutores.TabIndex = 40;
            this.lblAutores.Text = "Autor(es) del Libro:";
            // 
            // dtpFechaPublicacion
            // 
            this.dtpFechaPublicacion.Location = new System.Drawing.Point(411, 186);
            this.dtpFechaPublicacion.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.dtpFechaPublicacion.Name = "dtpFechaPublicacion";
            this.dtpFechaPublicacion.Size = new System.Drawing.Size(360, 23);
            this.dtpFechaPublicacion.TabIndex = 39;
            // 
            // lblFechaPublicacion
            // 
            this.lblFechaPublicacion.AutoSize = true;
            this.lblFechaPublicacion.Location = new System.Drawing.Point(224, 190);
            this.lblFechaPublicacion.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblFechaPublicacion.Name = "lblFechaPublicacion";
            this.lblFechaPublicacion.Size = new System.Drawing.Size(168, 17);
            this.lblFechaPublicacion.TabIndex = 38;
            this.lblFechaPublicacion.Text = "Fecha de Publicación:";
            // 
            // btnBuscarEditorial
            // 
            this.btnBuscarEditorial.Location = new System.Drawing.Point(959, 153);
            this.btnBuscarEditorial.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnBuscarEditorial.Name = "btnBuscarEditorial";
            this.btnBuscarEditorial.Size = new System.Drawing.Size(56, 28);
            this.btnBuscarEditorial.TabIndex = 37;
            this.btnBuscarEditorial.Text = "...";
            this.btnBuscarEditorial.UseVisualStyleBackColor = true;
            this.btnBuscarEditorial.Click += new System.EventHandler(this.btnBuscarEditorial_Click);
            // 
            // txtEditorial
            // 
            this.txtEditorial.Enabled = false;
            this.txtEditorial.Location = new System.Drawing.Point(411, 155);
            this.txtEditorial.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtEditorial.Name = "txtEditorial";
            this.txtEditorial.ReadOnly = true;
            this.txtEditorial.Size = new System.Drawing.Size(539, 23);
            this.txtEditorial.TabIndex = 36;
            // 
            // lblEditorial
            // 
            this.lblEditorial.AutoSize = true;
            this.lblEditorial.Location = new System.Drawing.Point(327, 159);
            this.lblEditorial.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblEditorial.Name = "lblEditorial";
            this.lblEditorial.Size = new System.Drawing.Size(73, 17);
            this.lblEditorial.TabIndex = 35;
            this.lblEditorial.Text = "Editorial:";
            // 
            // txtNroPaginas
            // 
            this.txtNroPaginas.Location = new System.Drawing.Point(412, 95);
            this.txtNroPaginas.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtNroPaginas.Name = "txtNroPaginas";
            this.txtNroPaginas.Size = new System.Drawing.Size(121, 23);
            this.txtNroPaginas.TabIndex = 34;
            // 
            // lblNroPaginas
            // 
            this.lblNroPaginas.AutoSize = true;
            this.lblNroPaginas.Location = new System.Drawing.Point(243, 100);
            this.lblNroPaginas.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblNroPaginas.Name = "lblNroPaginas";
            this.lblNroPaginas.Size = new System.Drawing.Size(155, 17);
            this.lblNroPaginas.TabIndex = 33;
            this.lblNroPaginas.Text = "Número de Páginas:";
            // 
            // rbIngles
            // 
            this.rbIngles.AutoSize = true;
            this.rbIngles.Location = new System.Drawing.Point(513, 127);
            this.rbIngles.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.rbIngles.Name = "rbIngles";
            this.rbIngles.Size = new System.Drawing.Size(72, 21);
            this.rbIngles.TabIndex = 32;
            this.rbIngles.TabStop = true;
            this.rbIngles.Text = "Inglés";
            this.rbIngles.UseVisualStyleBackColor = true;
            // 
            // rbEspanhol
            // 
            this.rbEspanhol.AutoSize = true;
            this.rbEspanhol.Location = new System.Drawing.Point(412, 127);
            this.rbEspanhol.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.rbEspanhol.Name = "rbEspanhol";
            this.rbEspanhol.Size = new System.Drawing.Size(87, 21);
            this.rbEspanhol.TabIndex = 31;
            this.rbEspanhol.TabStop = true;
            this.rbEspanhol.Text = "Español";
            this.rbEspanhol.UseVisualStyleBackColor = true;
            // 
            // lblIdioma
            // 
            this.lblIdioma.AutoSize = true;
            this.lblIdioma.Location = new System.Drawing.Point(339, 129);
            this.lblIdioma.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblIdioma.Name = "lblIdioma";
            this.lblIdioma.Size = new System.Drawing.Size(60, 17);
            this.lblIdioma.TabIndex = 30;
            this.lblIdioma.Text = "Idioma:";
            // 
            // txtTitulo
            // 
            this.txtTitulo.Location = new System.Drawing.Point(412, 65);
            this.txtTitulo.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtTitulo.Name = "txtTitulo";
            this.txtTitulo.Size = new System.Drawing.Size(601, 23);
            this.txtTitulo.TabIndex = 29;
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.Location = new System.Drawing.Point(273, 69);
            this.lblTitulo.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(123, 17);
            this.lblTitulo.TabIndex = 28;
            this.lblTitulo.Text = "Título del Libro:";
            // 
            // btnSubirFoto
            // 
            this.btnSubirFoto.BackgroundImage = global::RinconLibroSoft.Properties.Resources.upload;
            this.btnSubirFoto.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnSubirFoto.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSubirFoto.Location = new System.Drawing.Point(168, 218);
            this.btnSubirFoto.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.btnSubirFoto.Name = "btnSubirFoto";
            this.btnSubirFoto.Size = new System.Drawing.Size(48, 38);
            this.btnSubirFoto.TabIndex = 27;
            this.btnSubirFoto.UseVisualStyleBackColor = true;
            this.btnSubirFoto.Click += new System.EventHandler(this.btnSubirFoto_Click);
            // 
            // pbPortada
            // 
            this.pbPortada.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pbPortada.Location = new System.Drawing.Point(25, 33);
            this.pbPortada.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.pbPortada.Name = "pbPortada";
            this.pbPortada.Size = new System.Drawing.Size(190, 222);
            this.pbPortada.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbPortada.TabIndex = 2;
            this.pbPortada.TabStop = false;
            // 
            // txtIDLibro
            // 
            this.txtIDLibro.Location = new System.Drawing.Point(412, 37);
            this.txtIDLibro.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.txtIDLibro.Name = "txtIDLibro";
            this.txtIDLibro.ReadOnly = true;
            this.txtIDLibro.Size = new System.Drawing.Size(93, 23);
            this.txtIDLibro.TabIndex = 1;
            // 
            // lblIDLibro
            // 
            this.lblIDLibro.AutoSize = true;
            this.lblIDLibro.Location = new System.Drawing.Point(301, 41);
            this.lblIDLibro.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.lblIDLibro.Name = "lblIDLibro";
            this.lblIDLibro.Size = new System.Drawing.Size(97, 17);
            this.lblIDLibro.TabIndex = 0;
            this.lblIDLibro.Text = "ID del Libro:";
            // 
            // ofdPortada
            // 
            this.ofdPortada.FileName = "openFileDialog1";
            // 
            // frmGestionarLibros
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1067, 554);
            this.Controls.Add(this.gbDatosGenerales);
            this.Controls.Add(this.tsMenu);
            this.Controls.Add(this.lblGestionLibros);
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "frmGestionarLibros";
            this.Text = "Formulario de Gestión de Libros";
            this.tsMenu.ResumeLayout(false);
            this.tsMenu.PerformLayout();
            this.gbDatosGenerales.ResumeLayout(false);
            this.gbDatosGenerales.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvAutores)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pbPortada)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblGestionLibros;
        private System.Windows.Forms.ToolStrip tsMenu;
        private System.Windows.Forms.ToolStripButton btnNuevo;
        private System.Windows.Forms.ToolStripButton btnGuardar;
        private System.Windows.Forms.ToolStripButton btnBuscar;
        private System.Windows.Forms.ToolStripButton btnCancelar;
        private System.Windows.Forms.GroupBox gbDatosGenerales;
        private System.Windows.Forms.TextBox txtTitulo;
        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.Button btnSubirFoto;
        private System.Windows.Forms.PictureBox pbPortada;
        private System.Windows.Forms.TextBox txtIDLibro;
        private System.Windows.Forms.Label lblIDLibro;
        private System.Windows.Forms.Button btnEliminarAutor;
        private System.Windows.Forms.Button btnAgregarAutor;
        private System.Windows.Forms.DataGridView dgvAutores;
        private System.Windows.Forms.Label lblAutores;
        private System.Windows.Forms.DateTimePicker dtpFechaPublicacion;
        private System.Windows.Forms.Label lblFechaPublicacion;
        private System.Windows.Forms.Button btnBuscarEditorial;
        private System.Windows.Forms.TextBox txtEditorial;
        private System.Windows.Forms.Label lblEditorial;
        private System.Windows.Forms.TextBox txtNroPaginas;
        private System.Windows.Forms.Label lblNroPaginas;
        private System.Windows.Forms.RadioButton rbIngles;
        private System.Windows.Forms.RadioButton rbEspanhol;
        private System.Windows.Forms.Label lblIdioma;
        private System.Windows.Forms.OpenFileDialog ofdPortada;
        private System.Windows.Forms.TextBox txtPrecio;
        private System.Windows.Forms.Label lblPrecio;
        private System.Windows.Forms.DataGridViewTextBoxColumn ID;
        private System.Windows.Forms.DataGridViewTextBoxColumn NombreCompleto;
        private System.Windows.Forms.DataGridViewTextBoxColumn Nacionalidad;
        private System.Windows.Forms.Button btnBuscarAutor;
        private System.Windows.Forms.TextBox txtAutor;
    }
}

