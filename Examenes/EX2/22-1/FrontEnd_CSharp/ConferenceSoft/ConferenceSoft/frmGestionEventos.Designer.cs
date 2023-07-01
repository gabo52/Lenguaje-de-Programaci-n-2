namespace ConferenceSoft
{
    partial class frmGestionEventos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmGestionEventos));
            this.tsMenu = new System.Windows.Forms.ToolStrip();
            this.btnNuevo = new System.Windows.Forms.ToolStripButton();
            this.btnGuardar = new System.Windows.Forms.ToolStripButton();
            this.btnBuscar = new System.Windows.Forms.ToolStripButton();
            this.btnCancelar = new System.Windows.Forms.ToolStripButton();
            this.gbDatosEvento = new System.Windows.Forms.GroupBox();
            this.txtDescripcion = new System.Windows.Forms.TextBox();
            this.lblDescripcion = new System.Windows.Forms.Label();
            this.dtpFechaEvento = new System.Windows.Forms.DateTimePicker();
            this.lblFechaEvento = new System.Windows.Forms.Label();
            this.txtNombre = new System.Windows.Forms.TextBox();
            this.txtID = new System.Windows.Forms.TextBox();
            this.btnSubirPortada = new System.Windows.Forms.Button();
            this.lblNombreEvento = new System.Windows.Forms.Label();
            this.lblID = new System.Windows.Forms.Label();
            this.pbPortada = new System.Windows.Forms.PictureBox();
            this.ofdPortada = new System.Windows.Forms.OpenFileDialog();
            this.gbDatosPonentes = new System.Windows.Forms.GroupBox();
            this.dtpHoraFin = new System.Windows.Forms.DateTimePicker();
            this.lblHoraFin = new System.Windows.Forms.Label();
            this.txtTituloPonencia = new System.Windows.Forms.TextBox();
            this.lblTituloPonencia = new System.Windows.Forms.Label();
            this.dtpHoraInicio = new System.Windows.Forms.DateTimePicker();
            this.lblHoraInicio = new System.Windows.Forms.Label();
            this.btnEliminarPonente = new System.Windows.Forms.Button();
            this.btnAgregarPonente = new System.Windows.Forms.Button();
            this.btnBuscarPonente = new System.Windows.Forms.Button();
            this.txtCodigoPUCPPonente = new System.Windows.Forms.TextBox();
            this.lblCodigoPUCPPonente = new System.Windows.Forms.Label();
            this.txtNombrePonente = new System.Windows.Forms.TextBox();
            this.lblNombrePonente = new System.Windows.Forms.Label();
            this.dgvPonencias = new System.Windows.Forms.DataGridView();
            this.Ponente = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.Ponencia = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.HoraInicio = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.HoraFin = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.tsMenu.SuspendLayout();
            this.gbDatosEvento.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbPortada)).BeginInit();
            this.gbDatosPonentes.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvPonencias)).BeginInit();
            this.SuspendLayout();
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
            this.tsMenu.Size = new System.Drawing.Size(866, 27);
            this.tsMenu.TabIndex = 0;
            this.tsMenu.Text = "toolStrip1";
            // 
            // btnNuevo
            // 
            this.btnNuevo.Image = ((System.Drawing.Image)(resources.GetObject("btnNuevo.Image")));
            this.btnNuevo.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnNuevo.Name = "btnNuevo";
            this.btnNuevo.Size = new System.Drawing.Size(66, 24);
            this.btnNuevo.Text = "&Nuevo";
            this.btnNuevo.Click += new System.EventHandler(this.btnNuevo_Click);
            // 
            // btnGuardar
            // 
            this.btnGuardar.Image = ((System.Drawing.Image)(resources.GetObject("btnGuardar.Image")));
            this.btnGuardar.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnGuardar.Name = "btnGuardar";
            this.btnGuardar.Size = new System.Drawing.Size(73, 24);
            this.btnGuardar.Text = "&Guardar";
            // 
            // btnBuscar
            // 
            this.btnBuscar.Image = ((System.Drawing.Image)(resources.GetObject("btnBuscar.Image")));
            this.btnBuscar.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnBuscar.Name = "btnBuscar";
            this.btnBuscar.Size = new System.Drawing.Size(66, 24);
            this.btnBuscar.Text = "&Buscar";
            // 
            // btnCancelar
            // 
            this.btnCancelar.Image = ((System.Drawing.Image)(resources.GetObject("btnCancelar.Image")));
            this.btnCancelar.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.btnCancelar.Name = "btnCancelar";
            this.btnCancelar.Size = new System.Drawing.Size(77, 24);
            this.btnCancelar.Text = "&Cancelar";
            this.btnCancelar.Click += new System.EventHandler(this.btnCancelar_Click);
            // 
            // gbDatosEvento
            // 
            this.gbDatosEvento.Controls.Add(this.txtDescripcion);
            this.gbDatosEvento.Controls.Add(this.lblDescripcion);
            this.gbDatosEvento.Controls.Add(this.dtpFechaEvento);
            this.gbDatosEvento.Controls.Add(this.lblFechaEvento);
            this.gbDatosEvento.Controls.Add(this.txtNombre);
            this.gbDatosEvento.Controls.Add(this.txtID);
            this.gbDatosEvento.Controls.Add(this.btnSubirPortada);
            this.gbDatosEvento.Controls.Add(this.lblNombreEvento);
            this.gbDatosEvento.Controls.Add(this.lblID);
            this.gbDatosEvento.Controls.Add(this.pbPortada);
            this.gbDatosEvento.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gbDatosEvento.Location = new System.Drawing.Point(9, 29);
            this.gbDatosEvento.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbDatosEvento.Name = "gbDatosEvento";
            this.gbDatosEvento.Padding = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbDatosEvento.Size = new System.Drawing.Size(848, 232);
            this.gbDatosEvento.TabIndex = 1;
            this.gbDatosEvento.TabStop = false;
            this.gbDatosEvento.Text = "Datos del Evento";
            // 
            // txtDescripcion
            // 
            this.txtDescripcion.Location = new System.Drawing.Point(184, 141);
            this.txtDescripcion.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtDescripcion.Multiline = true;
            this.txtDescripcion.Name = "txtDescripcion";
            this.txtDescripcion.Size = new System.Drawing.Size(656, 79);
            this.txtDescripcion.TabIndex = 9;
            // 
            // lblDescripcion
            // 
            this.lblDescripcion.AutoSize = true;
            this.lblDescripcion.Location = new System.Drawing.Point(182, 116);
            this.lblDescripcion.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblDescripcion.Name = "lblDescripcion";
            this.lblDescripcion.Size = new System.Drawing.Size(143, 13);
            this.lblDescripcion.TabIndex = 8;
            this.lblDescripcion.Text = "Descripción del Evento:";
            // 
            // dtpFechaEvento
            // 
            this.dtpFechaEvento.Location = new System.Drawing.Point(305, 72);
            this.dtpFechaEvento.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.dtpFechaEvento.Name = "dtpFechaEvento";
            this.dtpFechaEvento.Size = new System.Drawing.Size(261, 19);
            this.dtpFechaEvento.TabIndex = 7;
            // 
            // lblFechaEvento
            // 
            this.lblFechaEvento.AutoSize = true;
            this.lblFechaEvento.Location = new System.Drawing.Point(190, 75);
            this.lblFechaEvento.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblFechaEvento.Name = "lblFechaEvento";
            this.lblFechaEvento.Size = new System.Drawing.Size(111, 13);
            this.lblFechaEvento.TabIndex = 6;
            this.lblFechaEvento.Text = "Fecha del Evento:";
            // 
            // txtNombre
            // 
            this.txtNombre.Location = new System.Drawing.Point(305, 46);
            this.txtNombre.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtNombre.Name = "txtNombre";
            this.txtNombre.Size = new System.Drawing.Size(535, 19);
            this.txtNombre.TabIndex = 5;
            // 
            // txtID
            // 
            this.txtID.Location = new System.Drawing.Point(305, 23);
            this.txtID.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtID.Name = "txtID";
            this.txtID.ReadOnly = true;
            this.txtID.Size = new System.Drawing.Size(68, 19);
            this.txtID.TabIndex = 4;
            this.txtID.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // btnSubirPortada
            // 
            this.btnSubirPortada.BackgroundImage = global::ConferenceSoft.Properties.Resources.upload;
            this.btnSubirPortada.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnSubirPortada.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSubirPortada.Location = new System.Drawing.Point(131, 188);
            this.btnSubirPortada.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.btnSubirPortada.Name = "btnSubirPortada";
            this.btnSubirPortada.Size = new System.Drawing.Size(38, 30);
            this.btnSubirPortada.TabIndex = 3;
            this.btnSubirPortada.UseVisualStyleBackColor = true;
            this.btnSubirPortada.Click += new System.EventHandler(this.btnSubirPortada_Click);
            // 
            // lblNombreEvento
            // 
            this.lblNombreEvento.AutoSize = true;
            this.lblNombreEvento.Location = new System.Drawing.Point(182, 48);
            this.lblNombreEvento.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblNombreEvento.Name = "lblNombreEvento";
            this.lblNombreEvento.Size = new System.Drawing.Size(119, 13);
            this.lblNombreEvento.TabIndex = 2;
            this.lblNombreEvento.Text = "Nombre del Evento:";
            // 
            // lblID
            // 
            this.lblID.AutoSize = true;
            this.lblID.Location = new System.Drawing.Point(212, 25);
            this.lblID.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblID.Name = "lblID";
            this.lblID.Size = new System.Drawing.Size(89, 13);
            this.lblID.TabIndex = 1;
            this.lblID.Text = "ID del Evento:";
            // 
            // pbPortada
            // 
            this.pbPortada.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pbPortada.Location = new System.Drawing.Point(12, 23);
            this.pbPortada.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.pbPortada.Name = "pbPortada";
            this.pbPortada.Size = new System.Drawing.Size(157, 196);
            this.pbPortada.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbPortada.TabIndex = 0;
            this.pbPortada.TabStop = false;
            // 
            // ofdPortada
            // 
            this.ofdPortada.FileName = "ofdPortada";
            // 
            // gbDatosPonentes
            // 
            this.gbDatosPonentes.Controls.Add(this.dtpHoraFin);
            this.gbDatosPonentes.Controls.Add(this.lblHoraFin);
            this.gbDatosPonentes.Controls.Add(this.txtTituloPonencia);
            this.gbDatosPonentes.Controls.Add(this.lblTituloPonencia);
            this.gbDatosPonentes.Controls.Add(this.dtpHoraInicio);
            this.gbDatosPonentes.Controls.Add(this.lblHoraInicio);
            this.gbDatosPonentes.Controls.Add(this.btnEliminarPonente);
            this.gbDatosPonentes.Controls.Add(this.btnAgregarPonente);
            this.gbDatosPonentes.Controls.Add(this.btnBuscarPonente);
            this.gbDatosPonentes.Controls.Add(this.txtCodigoPUCPPonente);
            this.gbDatosPonentes.Controls.Add(this.lblCodigoPUCPPonente);
            this.gbDatosPonentes.Controls.Add(this.txtNombrePonente);
            this.gbDatosPonentes.Controls.Add(this.lblNombrePonente);
            this.gbDatosPonentes.Controls.Add(this.dgvPonencias);
            this.gbDatosPonentes.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.gbDatosPonentes.Location = new System.Drawing.Point(9, 266);
            this.gbDatosPonentes.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbDatosPonentes.Name = "gbDatosPonentes";
            this.gbDatosPonentes.Padding = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.gbDatosPonentes.Size = new System.Drawing.Size(848, 255);
            this.gbDatosPonentes.TabIndex = 2;
            this.gbDatosPonentes.TabStop = false;
            this.gbDatosPonentes.Text = "Ponencias del Evento";
            // 
            // dtpHoraFin
            // 
            this.dtpHoraFin.CustomFormat = "HH:mm";
            this.dtpHoraFin.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpHoraFin.Location = new System.Drawing.Point(295, 101);
            this.dtpHoraFin.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.dtpHoraFin.Name = "dtpHoraFin";
            this.dtpHoraFin.ShowUpDown = true;
            this.dtpHoraFin.Size = new System.Drawing.Size(78, 19);
            this.dtpHoraFin.TabIndex = 13;
            // 
            // lblHoraFin
            // 
            this.lblHoraFin.AutoSize = true;
            this.lblHoraFin.Location = new System.Drawing.Point(230, 103);
            this.lblHoraFin.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblHoraFin.Name = "lblHoraFin";
            this.lblHoraFin.Size = new System.Drawing.Size(59, 13);
            this.lblHoraFin.TabIndex = 12;
            this.lblHoraFin.Text = "Hora Fin:";
            // 
            // txtTituloPonencia
            // 
            this.txtTituloPonencia.Location = new System.Drawing.Point(151, 74);
            this.txtTituloPonencia.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtTituloPonencia.Name = "txtTituloPonencia";
            this.txtTituloPonencia.Size = new System.Drawing.Size(426, 19);
            this.txtTituloPonencia.TabIndex = 11;
            // 
            // lblTituloPonencia
            // 
            this.lblTituloPonencia.AutoSize = true;
            this.lblTituloPonencia.Location = new System.Drawing.Point(13, 77);
            this.lblTituloPonencia.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblTituloPonencia.Name = "lblTituloPonencia";
            this.lblTituloPonencia.Size = new System.Drawing.Size(134, 13);
            this.lblTituloPonencia.TabIndex = 10;
            this.lblTituloPonencia.Text = "Título de la Ponencia:";
            // 
            // dtpHoraInicio
            // 
            this.dtpHoraInicio.CustomFormat = "HH:mm";
            this.dtpHoraInicio.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpHoraInicio.Location = new System.Drawing.Point(109, 101);
            this.dtpHoraInicio.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.dtpHoraInicio.Name = "dtpHoraInicio";
            this.dtpHoraInicio.ShowUpDown = true;
            this.dtpHoraInicio.Size = new System.Drawing.Size(78, 19);
            this.dtpHoraInicio.TabIndex = 9;
            // 
            // lblHoraInicio
            // 
            this.lblHoraInicio.AutoSize = true;
            this.lblHoraInicio.Location = new System.Drawing.Point(14, 103);
            this.lblHoraInicio.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblHoraInicio.Name = "lblHoraInicio";
            this.lblHoraInicio.Size = new System.Drawing.Size(91, 13);
            this.lblHoraInicio.TabIndex = 8;
            this.lblHoraInicio.Text = "Hora de Inicio:";
            // 
            // btnEliminarPonente
            // 
            this.btnEliminarPonente.Location = new System.Drawing.Point(747, 98);
            this.btnEliminarPonente.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.btnEliminarPonente.Name = "btnEliminarPonente";
            this.btnEliminarPonente.Size = new System.Drawing.Size(38, 23);
            this.btnEliminarPonente.TabIndex = 7;
            this.btnEliminarPonente.Text = "-";
            this.btnEliminarPonente.UseVisualStyleBackColor = true;
            // 
            // btnAgregarPonente
            // 
            this.btnAgregarPonente.Location = new System.Drawing.Point(705, 98);
            this.btnAgregarPonente.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.btnAgregarPonente.Name = "btnAgregarPonente";
            this.btnAgregarPonente.Size = new System.Drawing.Size(38, 23);
            this.btnAgregarPonente.TabIndex = 6;
            this.btnAgregarPonente.Text = "+";
            this.btnAgregarPonente.UseVisualStyleBackColor = true;
            // 
            // btnBuscarPonente
            // 
            this.btnBuscarPonente.Location = new System.Drawing.Point(246, 22);
            this.btnBuscarPonente.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.btnBuscarPonente.Name = "btnBuscarPonente";
            this.btnBuscarPonente.Size = new System.Drawing.Size(40, 23);
            this.btnBuscarPonente.TabIndex = 5;
            this.btnBuscarPonente.Text = "...";
            this.btnBuscarPonente.UseVisualStyleBackColor = true;
            // 
            // txtCodigoPUCPPonente
            // 
            this.txtCodigoPUCPPonente.Location = new System.Drawing.Point(106, 24);
            this.txtCodigoPUCPPonente.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtCodigoPUCPPonente.Name = "txtCodigoPUCPPonente";
            this.txtCodigoPUCPPonente.ReadOnly = true;
            this.txtCodigoPUCPPonente.Size = new System.Drawing.Size(134, 19);
            this.txtCodigoPUCPPonente.TabIndex = 4;
            // 
            // lblCodigoPUCPPonente
            // 
            this.lblCodigoPUCPPonente.AutoSize = true;
            this.lblCodigoPUCPPonente.Location = new System.Drawing.Point(13, 26);
            this.lblCodigoPUCPPonente.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblCodigoPUCPPonente.Name = "lblCodigoPUCPPonente";
            this.lblCodigoPUCPPonente.Size = new System.Drawing.Size(87, 13);
            this.lblCodigoPUCPPonente.TabIndex = 3;
            this.lblCodigoPUCPPonente.Text = "Código PUCP:";
            // 
            // txtNombrePonente
            // 
            this.txtNombrePonente.Location = new System.Drawing.Point(143, 49);
            this.txtNombrePonente.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.txtNombrePonente.Name = "txtNombrePonente";
            this.txtNombrePonente.ReadOnly = true;
            this.txtNombrePonente.Size = new System.Drawing.Size(396, 19);
            this.txtNombrePonente.TabIndex = 2;
            // 
            // lblNombrePonente
            // 
            this.lblNombrePonente.AutoSize = true;
            this.lblNombrePonente.Location = new System.Drawing.Point(13, 52);
            this.lblNombrePonente.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.lblNombrePonente.Name = "lblNombrePonente";
            this.lblNombrePonente.Size = new System.Drawing.Size(126, 13);
            this.lblNombrePonente.TabIndex = 1;
            this.lblNombrePonente.Text = "Nombre del Ponente:";
            // 
            // dgvPonencias
            // 
            this.dgvPonencias.AllowUserToAddRows = false;
            this.dgvPonencias.AllowUserToDeleteRows = false;
            this.dgvPonencias.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvPonencias.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.Ponente,
            this.Ponencia,
            this.HoraInicio,
            this.HoraFin});
            this.dgvPonencias.Location = new System.Drawing.Point(12, 128);
            this.dgvPonencias.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.dgvPonencias.Name = "dgvPonencias";
            this.dgvPonencias.ReadOnly = true;
            this.dgvPonencias.RowHeadersWidth = 51;
            this.dgvPonencias.RowTemplate.Height = 24;
            this.dgvPonencias.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvPonencias.Size = new System.Drawing.Size(828, 117);
            this.dgvPonencias.TabIndex = 0;
            // 
            // Ponente
            // 
            this.Ponente.HeaderText = "Ponente";
            this.Ponente.MinimumWidth = 6;
            this.Ponente.Name = "Ponente";
            this.Ponente.ReadOnly = true;
            this.Ponente.Width = 200;
            // 
            // Ponencia
            // 
            this.Ponencia.HeaderText = "Ponencia";
            this.Ponencia.MinimumWidth = 6;
            this.Ponencia.Name = "Ponencia";
            this.Ponencia.ReadOnly = true;
            this.Ponencia.Width = 300;
            // 
            // HoraInicio
            // 
            this.HoraInicio.HeaderText = "Hora Inicio";
            this.HoraInicio.MinimumWidth = 6;
            this.HoraInicio.Name = "HoraInicio";
            this.HoraInicio.ReadOnly = true;
            this.HoraInicio.Width = 130;
            // 
            // HoraFin
            // 
            this.HoraFin.HeaderText = "Hora Fin";
            this.HoraFin.MinimumWidth = 6;
            this.HoraFin.Name = "HoraFin";
            this.HoraFin.ReadOnly = true;
            this.HoraFin.Width = 130;
            // 
            // frmGestionEventos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(866, 526);
            this.Controls.Add(this.gbDatosPonentes);
            this.Controls.Add(this.gbDatosEvento);
            this.Controls.Add(this.tsMenu);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "frmGestionEventos";
            this.Text = "Formulario de Eventos";
            this.tsMenu.ResumeLayout(false);
            this.tsMenu.PerformLayout();
            this.gbDatosEvento.ResumeLayout(false);
            this.gbDatosEvento.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbPortada)).EndInit();
            this.gbDatosPonentes.ResumeLayout(false);
            this.gbDatosPonentes.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvPonencias)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStrip tsMenu;
        private System.Windows.Forms.ToolStripButton btnNuevo;
        private System.Windows.Forms.ToolStripButton btnGuardar;
        private System.Windows.Forms.ToolStripButton btnBuscar;
        private System.Windows.Forms.ToolStripButton btnCancelar;
        private System.Windows.Forms.GroupBox gbDatosEvento;
        private System.Windows.Forms.TextBox txtNombre;
        private System.Windows.Forms.TextBox txtID;
        private System.Windows.Forms.Button btnSubirPortada;
        private System.Windows.Forms.Label lblNombreEvento;
        private System.Windows.Forms.Label lblID;
        private System.Windows.Forms.PictureBox pbPortada;
        private System.Windows.Forms.OpenFileDialog ofdPortada;
        private System.Windows.Forms.TextBox txtDescripcion;
        private System.Windows.Forms.Label lblDescripcion;
        private System.Windows.Forms.DateTimePicker dtpFechaEvento;
        private System.Windows.Forms.Label lblFechaEvento;
        private System.Windows.Forms.GroupBox gbDatosPonentes;
        private System.Windows.Forms.DataGridView dgvPonencias;
        private System.Windows.Forms.Button btnEliminarPonente;
        private System.Windows.Forms.Button btnAgregarPonente;
        private System.Windows.Forms.Button btnBuscarPonente;
        private System.Windows.Forms.TextBox txtCodigoPUCPPonente;
        private System.Windows.Forms.Label lblCodigoPUCPPonente;
        private System.Windows.Forms.TextBox txtNombrePonente;
        private System.Windows.Forms.Label lblNombrePonente;
        private System.Windows.Forms.TextBox txtTituloPonencia;
        private System.Windows.Forms.Label lblTituloPonencia;
        private System.Windows.Forms.DateTimePicker dtpHoraInicio;
        private System.Windows.Forms.Label lblHoraInicio;
        private System.Windows.Forms.DateTimePicker dtpHoraFin;
        private System.Windows.Forms.Label lblHoraFin;
        private System.Windows.Forms.DataGridViewTextBoxColumn Ponente;
        private System.Windows.Forms.DataGridViewTextBoxColumn Ponencia;
        private System.Windows.Forms.DataGridViewTextBoxColumn HoraInicio;
        private System.Windows.Forms.DataGridViewTextBoxColumn HoraFin;
    }
}

