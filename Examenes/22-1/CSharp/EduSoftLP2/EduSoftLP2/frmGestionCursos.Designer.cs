namespace EduSoftLP2
{
    partial class frmGestionCursos
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(frmGestionCursos));
            this.tbDatosCurso = new System.Windows.Forms.TabControl();
            this.tbDatosGenerales = new System.Windows.Forms.TabPage();
            this.btnSubirFoto = new System.Windows.Forms.Button();
            this.pbFoto = new System.Windows.Forms.PictureBox();
            this.btnDescargarSilabo = new System.Windows.Forms.Button();
            this.btnSubirSilabo = new System.Windows.Forms.Button();
            this.txtSilabo = new System.Windows.Forms.TextBox();
            this.lblSilabo = new System.Windows.Forms.Label();
            this.txtSumilla = new System.Windows.Forms.TextBox();
            this.lblSumilla = new System.Windows.Forms.Label();
            this.lblGuion = new System.Windows.Forms.Label();
            this.txtSemestre = new System.Windows.Forms.TextBox();
            this.lblSemestre = new System.Windows.Forms.Label();
            this.dtpAnho = new System.Windows.Forms.DateTimePicker();
            this.cbDispMovil = new System.Windows.Forms.CheckBox();
            this.cbDispEspecial = new System.Windows.Forms.CheckBox();
            this.cbComputadora = new System.Windows.Forms.CheckBox();
            this.lblRequerimientos = new System.Windows.Forms.Label();
            this.cboEspecialidades = new System.Windows.Forms.ComboBox();
            this.lblEspecialidad = new System.Windows.Forms.Label();
            this.rbSemiPresencial = new System.Windows.Forms.RadioButton();
            this.rbPresencial = new System.Windows.Forms.RadioButton();
            this.rbVirtual = new System.Windows.Forms.RadioButton();
            this.lblModalidad = new System.Windows.Forms.Label();
            this.txtClave = new System.Windows.Forms.TextBox();
            this.lblClave = new System.Windows.Forms.Label();
            this.txtNombreCurso = new System.Windows.Forms.TextBox();
            this.lblNombreCurso = new System.Windows.Forms.Label();
            this.tbMatriculados = new System.Windows.Forms.TabPage();
            this.btnEliminarDocente = new System.Windows.Forms.Button();
            this.btnAgregarDocente = new System.Windows.Forms.Button();
            this.btnBuscarDocente = new System.Windows.Forms.Button();
            this.txtNombreDocente = new System.Windows.Forms.TextBox();
            this.txtCodigoDocente = new System.Windows.Forms.TextBox();
            this.lblNombreDocente = new System.Windows.Forms.Label();
            this.lblCodigoDocente = new System.Windows.Forms.Label();
            this.dgvDocentes = new System.Windows.Forms.DataGridView();
            this.CodigoPUCP = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.NombreCompleto = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.CategoriaFiliacion = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.lblTitulo = new System.Windows.Forms.Label();
            this.tsMenu = new System.Windows.Forms.ToolStrip();
            this.btnNuevo = new System.Windows.Forms.ToolStripButton();
            this.btnGuardar = new System.Windows.Forms.ToolStripButton();
            this.btnBuscar = new System.Windows.Forms.ToolStripButton();
            this.btnCancelar = new System.Windows.Forms.ToolStripButton();
            this.ofdFoto = new System.Windows.Forms.OpenFileDialog();
            this.ofdArchivo = new System.Windows.Forms.OpenFileDialog();
            this.sfdArchivo = new System.Windows.Forms.SaveFileDialog();
            this.tbDatosCurso.SuspendLayout();
            this.tbDatosGenerales.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbFoto)).BeginInit();
            this.tbMatriculados.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvDocentes)).BeginInit();
            this.tsMenu.SuspendLayout();
            this.SuspendLayout();
            // 
            // tbDatosCurso
            // 
            this.tbDatosCurso.Controls.Add(this.tbDatosGenerales);
            this.tbDatosCurso.Controls.Add(this.tbMatriculados);
            this.tbDatosCurso.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbDatosCurso.Location = new System.Drawing.Point(12, 65);
            this.tbDatosCurso.Name = "tbDatosCurso";
            this.tbDatosCurso.SelectedIndex = 0;
            this.tbDatosCurso.Size = new System.Drawing.Size(776, 373);
            this.tbDatosCurso.TabIndex = 0;
            // 
            // tbDatosGenerales
            // 
            this.tbDatosGenerales.BackColor = System.Drawing.SystemColors.Control;
            this.tbDatosGenerales.Controls.Add(this.btnSubirFoto);
            this.tbDatosGenerales.Controls.Add(this.pbFoto);
            this.tbDatosGenerales.Controls.Add(this.btnDescargarSilabo);
            this.tbDatosGenerales.Controls.Add(this.btnSubirSilabo);
            this.tbDatosGenerales.Controls.Add(this.txtSilabo);
            this.tbDatosGenerales.Controls.Add(this.lblSilabo);
            this.tbDatosGenerales.Controls.Add(this.txtSumilla);
            this.tbDatosGenerales.Controls.Add(this.lblSumilla);
            this.tbDatosGenerales.Controls.Add(this.lblGuion);
            this.tbDatosGenerales.Controls.Add(this.txtSemestre);
            this.tbDatosGenerales.Controls.Add(this.lblSemestre);
            this.tbDatosGenerales.Controls.Add(this.dtpAnho);
            this.tbDatosGenerales.Controls.Add(this.cbDispMovil);
            this.tbDatosGenerales.Controls.Add(this.cbDispEspecial);
            this.tbDatosGenerales.Controls.Add(this.cbComputadora);
            this.tbDatosGenerales.Controls.Add(this.lblRequerimientos);
            this.tbDatosGenerales.Controls.Add(this.cboEspecialidades);
            this.tbDatosGenerales.Controls.Add(this.lblEspecialidad);
            this.tbDatosGenerales.Controls.Add(this.rbSemiPresencial);
            this.tbDatosGenerales.Controls.Add(this.rbPresencial);
            this.tbDatosGenerales.Controls.Add(this.rbVirtual);
            this.tbDatosGenerales.Controls.Add(this.lblModalidad);
            this.tbDatosGenerales.Controls.Add(this.txtClave);
            this.tbDatosGenerales.Controls.Add(this.lblClave);
            this.tbDatosGenerales.Controls.Add(this.txtNombreCurso);
            this.tbDatosGenerales.Controls.Add(this.lblNombreCurso);
            this.tbDatosGenerales.Font = new System.Drawing.Font("Microsoft Sans Serif", 8.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tbDatosGenerales.Location = new System.Drawing.Point(4, 26);
            this.tbDatosGenerales.Name = "tbDatosGenerales";
            this.tbDatosGenerales.Padding = new System.Windows.Forms.Padding(3);
            this.tbDatosGenerales.Size = new System.Drawing.Size(768, 343);
            this.tbDatosGenerales.TabIndex = 0;
            this.tbDatosGenerales.Text = "Datos Generales";
            // 
            // btnSubirFoto
            // 
            this.btnSubirFoto.BackgroundImage = global::EduSoftLP2.Properties.Resources.upload;
            this.btnSubirFoto.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnSubirFoto.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnSubirFoto.Location = new System.Drawing.Point(714, 117);
            this.btnSubirFoto.Name = "btnSubirFoto";
            this.btnSubirFoto.Size = new System.Drawing.Size(36, 31);
            this.btnSubirFoto.TabIndex = 26;
            this.btnSubirFoto.UseVisualStyleBackColor = true;
            this.btnSubirFoto.Click += new System.EventHandler(this.btnSubirFoto_Click);
            // 
            // pbFoto
            // 
            this.pbFoto.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.pbFoto.Location = new System.Drawing.Point(562, 16);
            this.pbFoto.Name = "pbFoto";
            this.pbFoto.Size = new System.Drawing.Size(188, 132);
            this.pbFoto.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pbFoto.TabIndex = 25;
            this.pbFoto.TabStop = false;
            // 
            // btnDescargarSilabo
            // 
            this.btnDescargarSilabo.Location = new System.Drawing.Point(668, 303);
            this.btnDescargarSilabo.Name = "btnDescargarSilabo";
            this.btnDescargarSilabo.Size = new System.Drawing.Size(82, 23);
            this.btnDescargarSilabo.TabIndex = 24;
            this.btnDescargarSilabo.Text = "Descargar";
            this.btnDescargarSilabo.UseVisualStyleBackColor = true;
            this.btnDescargarSilabo.Click += new System.EventHandler(this.btnDescargarSilabo_Click);
            // 
            // btnSubirSilabo
            // 
            this.btnSubirSilabo.Location = new System.Drawing.Point(587, 303);
            this.btnSubirSilabo.Name = "btnSubirSilabo";
            this.btnSubirSilabo.Size = new System.Drawing.Size(75, 23);
            this.btnSubirSilabo.TabIndex = 23;
            this.btnSubirSilabo.Text = "Subir";
            this.btnSubirSilabo.UseVisualStyleBackColor = true;
            this.btnSubirSilabo.Click += new System.EventHandler(this.btnSubirSilabo_Click);
            // 
            // txtSilabo
            // 
            this.txtSilabo.Location = new System.Drawing.Point(161, 305);
            this.txtSilabo.Name = "txtSilabo";
            this.txtSilabo.Size = new System.Drawing.Size(420, 23);
            this.txtSilabo.TabIndex = 22;
            // 
            // lblSilabo
            // 
            this.lblSilabo.AutoSize = true;
            this.lblSilabo.Location = new System.Drawing.Point(39, 308);
            this.lblSilabo.Name = "lblSilabo";
            this.lblSilabo.Size = new System.Drawing.Size(130, 17);
            this.lblSilabo.TabIndex = 21;
            this.lblSilabo.Text = "Sílabo del curso:";
            // 
            // txtSumilla
            // 
            this.txtSumilla.Location = new System.Drawing.Point(161, 216);
            this.txtSumilla.Multiline = true;
            this.txtSumilla.Name = "txtSumilla";
            this.txtSumilla.Size = new System.Drawing.Size(589, 77);
            this.txtSumilla.TabIndex = 20;
            // 
            // lblSumilla
            // 
            this.lblSumilla.AutoSize = true;
            this.lblSumilla.Location = new System.Drawing.Point(92, 219);
            this.lblSumilla.Name = "lblSumilla";
            this.lblSumilla.Size = new System.Drawing.Size(65, 17);
            this.lblSumilla.TabIndex = 19;
            this.lblSumilla.Text = "Sumilla:";
            // 
            // lblGuion
            // 
            this.lblGuion.AutoSize = true;
            this.lblGuion.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblGuion.Location = new System.Drawing.Point(252, 80);
            this.lblGuion.Name = "lblGuion";
            this.lblGuion.Size = new System.Drawing.Size(14, 18);
            this.lblGuion.TabIndex = 18;
            this.lblGuion.Text = "-";
            // 
            // txtSemestre
            // 
            this.txtSemestre.Location = new System.Drawing.Point(267, 78);
            this.txtSemestre.MaxLength = 1;
            this.txtSemestre.Name = "txtSemestre";
            this.txtSemestre.Size = new System.Drawing.Size(35, 23);
            this.txtSemestre.TabIndex = 17;
            this.txtSemestre.TextAlign = System.Windows.Forms.HorizontalAlignment.Center;
            // 
            // lblSemestre
            // 
            this.lblSemestre.AutoSize = true;
            this.lblSemestre.Location = new System.Drawing.Point(80, 82);
            this.lblSemestre.Name = "lblSemestre";
            this.lblSemestre.Size = new System.Drawing.Size(81, 17);
            this.lblSemestre.TabIndex = 16;
            this.lblSemestre.Text = "Semestre:";
            // 
            // dtpAnho
            // 
            this.dtpAnho.CustomFormat = "yyyy";
            this.dtpAnho.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            this.dtpAnho.Location = new System.Drawing.Point(161, 78);
            this.dtpAnho.MaxDate = new System.DateTime(2023, 12, 31, 0, 0, 0, 0);
            this.dtpAnho.Name = "dtpAnho";
            this.dtpAnho.ShowUpDown = true;
            this.dtpAnho.Size = new System.Drawing.Size(87, 23);
            this.dtpAnho.TabIndex = 15;
            // 
            // cbDispMovil
            // 
            this.cbDispMovil.AutoSize = true;
            this.cbDispMovil.Location = new System.Drawing.Point(277, 184);
            this.cbDispMovil.Name = "cbDispMovil";
            this.cbDispMovil.Size = new System.Drawing.Size(151, 21);
            this.cbDispMovil.TabIndex = 14;
            this.cbDispMovil.Text = "Dispositivo Móvil";
            this.cbDispMovil.UseVisualStyleBackColor = true;
            // 
            // cbDispEspecial
            // 
            this.cbDispEspecial.AutoSize = true;
            this.cbDispEspecial.Location = new System.Drawing.Point(418, 184);
            this.cbDispEspecial.Name = "cbDispEspecial";
            this.cbDispEspecial.Size = new System.Drawing.Size(214, 21);
            this.cbDispEspecial.TabIndex = 13;
            this.cbDispEspecial.Text = "Dispositivo Especializado";
            this.cbDispEspecial.UseVisualStyleBackColor = true;
            // 
            // cbComputadora
            // 
            this.cbComputadora.AutoSize = true;
            this.cbComputadora.Location = new System.Drawing.Point(161, 183);
            this.cbComputadora.Name = "cbComputadora";
            this.cbComputadora.Size = new System.Drawing.Size(126, 21);
            this.cbComputadora.TabIndex = 12;
            this.cbComputadora.Text = "Computadora";
            this.cbComputadora.UseVisualStyleBackColor = true;
            // 
            // lblRequerimientos
            // 
            this.lblRequerimientos.AutoSize = true;
            this.lblRequerimientos.Location = new System.Drawing.Point(46, 184);
            this.lblRequerimientos.Name = "lblRequerimientos";
            this.lblRequerimientos.Size = new System.Drawing.Size(126, 17);
            this.lblRequerimientos.TabIndex = 11;
            this.lblRequerimientos.Text = "Requerimientos:";
            // 
            // cboEspecialidades
            // 
            this.cboEspecialidades.FormattingEnabled = true;
            this.cboEspecialidades.Location = new System.Drawing.Point(161, 146);
            this.cboEspecialidades.Name = "cboEspecialidades";
            this.cboEspecialidades.Size = new System.Drawing.Size(355, 25);
            this.cboEspecialidades.TabIndex = 9;
            this.cboEspecialidades.SelectedIndexChanged += new System.EventHandler(this.cboEspecialidades_SelectedIndexChanged);
            // 
            // lblEspecialidad
            // 
            this.lblEspecialidad.AutoSize = true;
            this.lblEspecialidad.Location = new System.Drawing.Point(62, 149);
            this.lblEspecialidad.Name = "lblEspecialidad";
            this.lblEspecialidad.Size = new System.Drawing.Size(105, 17);
            this.lblEspecialidad.TabIndex = 8;
            this.lblEspecialidad.Text = "Especialidad:";
            // 
            // rbSemiPresencial
            // 
            this.rbSemiPresencial.AutoSize = true;
            this.rbSemiPresencial.Location = new System.Drawing.Point(344, 113);
            this.rbSemiPresencial.Name = "rbSemiPresencial";
            this.rbSemiPresencial.Size = new System.Drawing.Size(145, 21);
            this.rbSemiPresencial.TabIndex = 7;
            this.rbSemiPresencial.TabStop = true;
            this.rbSemiPresencial.Text = "Semi-presencial";
            this.rbSemiPresencial.UseVisualStyleBackColor = true;
            // 
            // rbPresencial
            // 
            this.rbPresencial.AutoSize = true;
            this.rbPresencial.Location = new System.Drawing.Point(243, 113);
            this.rbPresencial.Name = "rbPresencial";
            this.rbPresencial.Size = new System.Drawing.Size(105, 21);
            this.rbPresencial.TabIndex = 6;
            this.rbPresencial.TabStop = true;
            this.rbPresencial.Text = "Presencial";
            this.rbPresencial.UseVisualStyleBackColor = true;
            // 
            // rbVirtual
            // 
            this.rbVirtual.AutoSize = true;
            this.rbVirtual.Location = new System.Drawing.Point(161, 113);
            this.rbVirtual.Name = "rbVirtual";
            this.rbVirtual.Size = new System.Drawing.Size(76, 21);
            this.rbVirtual.TabIndex = 5;
            this.rbVirtual.TabStop = true;
            this.rbVirtual.Text = "Virtual";
            this.rbVirtual.UseVisualStyleBackColor = true;
            // 
            // lblModalidad
            // 
            this.lblModalidad.AutoSize = true;
            this.lblModalidad.Location = new System.Drawing.Point(19, 115);
            this.lblModalidad.Name = "lblModalidad";
            this.lblModalidad.Size = new System.Drawing.Size(161, 17);
            this.lblModalidad.TabIndex = 4;
            this.lblModalidad.Text = "Modalidad del Curso:";
            // 
            // txtClave
            // 
            this.txtClave.Location = new System.Drawing.Point(161, 47);
            this.txtClave.MaxLength = 6;
            this.txtClave.Name = "txtClave";
            this.txtClave.Size = new System.Drawing.Size(107, 23);
            this.txtClave.TabIndex = 3;
            // 
            // lblClave
            // 
            this.lblClave.AutoSize = true;
            this.lblClave.Location = new System.Drawing.Point(45, 50);
            this.lblClave.Name = "lblClave";
            this.lblClave.Size = new System.Drawing.Size(127, 17);
            this.lblClave.TabIndex = 2;
            this.lblClave.Text = "Clave del Curso:";
            // 
            // txtNombreCurso
            // 
            this.txtNombreCurso.Location = new System.Drawing.Point(161, 16);
            this.txtNombreCurso.Name = "txtNombreCurso";
            this.txtNombreCurso.Size = new System.Drawing.Size(386, 23);
            this.txtNombreCurso.TabIndex = 1;
            // 
            // lblNombreCurso
            // 
            this.lblNombreCurso.AutoSize = true;
            this.lblNombreCurso.Location = new System.Drawing.Point(32, 19);
            this.lblNombreCurso.Name = "lblNombreCurso";
            this.lblNombreCurso.Size = new System.Drawing.Size(143, 17);
            this.lblNombreCurso.TabIndex = 0;
            this.lblNombreCurso.Text = "Nombre del Curso:";
            // 
            // tbMatriculados
            // 
            this.tbMatriculados.BackColor = System.Drawing.SystemColors.Control;
            this.tbMatriculados.Controls.Add(this.btnEliminarDocente);
            this.tbMatriculados.Controls.Add(this.btnAgregarDocente);
            this.tbMatriculados.Controls.Add(this.btnBuscarDocente);
            this.tbMatriculados.Controls.Add(this.txtNombreDocente);
            this.tbMatriculados.Controls.Add(this.txtCodigoDocente);
            this.tbMatriculados.Controls.Add(this.lblNombreDocente);
            this.tbMatriculados.Controls.Add(this.lblCodigoDocente);
            this.tbMatriculados.Controls.Add(this.dgvDocentes);
            this.tbMatriculados.Location = new System.Drawing.Point(4, 26);
            this.tbMatriculados.Name = "tbMatriculados";
            this.tbMatriculados.Padding = new System.Windows.Forms.Padding(3);
            this.tbMatriculados.Size = new System.Drawing.Size(768, 343);
            this.tbMatriculados.TabIndex = 1;
            this.tbMatriculados.Text = "Docentes Asignados";
            // 
            // btnEliminarDocente
            // 
            this.btnEliminarDocente.Location = new System.Drawing.Point(712, 41);
            this.btnEliminarDocente.Name = "btnEliminarDocente";
            this.btnEliminarDocente.Size = new System.Drawing.Size(38, 23);
            this.btnEliminarDocente.TabIndex = 7;
            this.btnEliminarDocente.Text = "-";
            this.btnEliminarDocente.UseVisualStyleBackColor = true;
            this.btnEliminarDocente.Click += new System.EventHandler(this.btnEliminarDocente_Click);
            // 
            // btnAgregarDocente
            // 
            this.btnAgregarDocente.Location = new System.Drawing.Point(668, 41);
            this.btnAgregarDocente.Name = "btnAgregarDocente";
            this.btnAgregarDocente.Size = new System.Drawing.Size(38, 23);
            this.btnAgregarDocente.TabIndex = 6;
            this.btnAgregarDocente.Text = "+";
            this.btnAgregarDocente.UseVisualStyleBackColor = true;
            this.btnAgregarDocente.Click += new System.EventHandler(this.btnAgregarDocente_Click);
            // 
            // btnBuscarDocente
            // 
            this.btnBuscarDocente.Location = new System.Drawing.Point(265, 11);
            this.btnBuscarDocente.Name = "btnBuscarDocente";
            this.btnBuscarDocente.Size = new System.Drawing.Size(36, 23);
            this.btnBuscarDocente.TabIndex = 5;
            this.btnBuscarDocente.Text = "...";
            this.btnBuscarDocente.UseVisualStyleBackColor = true;
            this.btnBuscarDocente.Click += new System.EventHandler(this.btnBuscarDocente_Click);
            // 
            // txtNombreDocente
            // 
            this.txtNombreDocente.Location = new System.Drawing.Point(128, 43);
            this.txtNombreDocente.Name = "txtNombreDocente";
            this.txtNombreDocente.Size = new System.Drawing.Size(383, 23);
            this.txtNombreDocente.TabIndex = 4;
            // 
            // txtCodigoDocente
            // 
            this.txtCodigoDocente.Location = new System.Drawing.Point(128, 13);
            this.txtCodigoDocente.Name = "txtCodigoDocente";
            this.txtCodigoDocente.Size = new System.Drawing.Size(131, 23);
            this.txtCodigoDocente.TabIndex = 3;
            // 
            // lblNombreDocente
            // 
            this.lblNombreDocente.AutoSize = true;
            this.lblNombreDocente.Location = new System.Drawing.Point(12, 46);
            this.lblNombreDocente.Name = "lblNombreDocente";
            this.lblNombreDocente.Size = new System.Drawing.Size(141, 17);
            this.lblNombreDocente.TabIndex = 2;
            this.lblNombreDocente.Text = "Nombre Completo:";
            // 
            // lblCodigoDocente
            // 
            this.lblCodigoDocente.AutoSize = true;
            this.lblCodigoDocente.Location = new System.Drawing.Point(35, 16);
            this.lblCodigoDocente.Name = "lblCodigoDocente";
            this.lblCodigoDocente.Size = new System.Drawing.Size(109, 17);
            this.lblCodigoDocente.TabIndex = 1;
            this.lblCodigoDocente.Text = "Código PUCP:";
            // 
            // dgvDocentes
            // 
            this.dgvDocentes.AllowUserToAddRows = false;
            this.dgvDocentes.AllowUserToDeleteRows = false;
            this.dgvDocentes.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dgvDocentes.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.CodigoPUCP,
            this.NombreCompleto,
            this.CategoriaFiliacion});
            this.dgvDocentes.Location = new System.Drawing.Point(15, 73);
            this.dgvDocentes.Name = "dgvDocentes";
            this.dgvDocentes.ReadOnly = true;
            this.dgvDocentes.RowHeadersWidth = 51;
            this.dgvDocentes.SelectionMode = System.Windows.Forms.DataGridViewSelectionMode.FullRowSelect;
            this.dgvDocentes.Size = new System.Drawing.Size(736, 255);
            this.dgvDocentes.TabIndex = 0;
            this.dgvDocentes.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dgvDocentes_CellContentClick);
            this.dgvDocentes.CellFormatting += new System.Windows.Forms.DataGridViewCellFormattingEventHandler(this.dgvDocentes_CellFormatting);
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
            this.NombreCompleto.Width = 400;
            // 
            // CategoriaFiliacion
            // 
            this.CategoriaFiliacion.HeaderText = "Categoría/Filiación";
            this.CategoriaFiliacion.MinimumWidth = 6;
            this.CategoriaFiliacion.Name = "CategoriaFiliacion";
            this.CategoriaFiliacion.ReadOnly = true;
            this.CategoriaFiliacion.Width = 150;
            // 
            // lblTitulo
            // 
            this.lblTitulo.AutoSize = true;
            this.lblTitulo.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lblTitulo.Location = new System.Drawing.Point(13, 34);
            this.lblTitulo.Name = "lblTitulo";
            this.lblTitulo.Size = new System.Drawing.Size(504, 20);
            this.lblTitulo.TabIndex = 1;
            this.lblTitulo.Text = "Gestión de Cursos del Departamento de Ingeniería - PUCP";
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
            this.tsMenu.Size = new System.Drawing.Size(800, 27);
            this.tsMenu.TabIndex = 2;
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
            // ofdFoto
            // 
            this.ofdFoto.FileName = "openFileDialog1";
            // 
            // ofdArchivo
            // 
            this.ofdArchivo.FileName = "openFileDialog1";
            // 
            // frmGestionCursos
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.tsMenu);
            this.Controls.Add(this.lblTitulo);
            this.Controls.Add(this.tbDatosCurso);
            this.Name = "frmGestionCursos";
            this.Text = "Formulario de Gestión de Cursos";
            this.tbDatosCurso.ResumeLayout(false);
            this.tbDatosGenerales.ResumeLayout(false);
            this.tbDatosGenerales.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pbFoto)).EndInit();
            this.tbMatriculados.ResumeLayout(false);
            this.tbMatriculados.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.dgvDocentes)).EndInit();
            this.tsMenu.ResumeLayout(false);
            this.tsMenu.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TabControl tbDatosCurso;
        private System.Windows.Forms.TabPage tbDatosGenerales;
        private System.Windows.Forms.TabPage tbMatriculados;
        private System.Windows.Forms.Label lblTitulo;
        private System.Windows.Forms.ToolStrip tsMenu;
        private System.Windows.Forms.ToolStripButton btnNuevo;
        private System.Windows.Forms.ToolStripButton btnGuardar;
        private System.Windows.Forms.ToolStripButton btnBuscar;
        private System.Windows.Forms.ToolStripButton btnCancelar;
        private System.Windows.Forms.TextBox txtClave;
        private System.Windows.Forms.Label lblClave;
        private System.Windows.Forms.TextBox txtNombreCurso;
        private System.Windows.Forms.Label lblNombreCurso;
        private System.Windows.Forms.CheckBox cbDispEspecial;
        private System.Windows.Forms.CheckBox cbComputadora;
        private System.Windows.Forms.Label lblRequerimientos;
        private System.Windows.Forms.ComboBox cboEspecialidades;
        private System.Windows.Forms.Label lblEspecialidad;
        private System.Windows.Forms.RadioButton rbSemiPresencial;
        private System.Windows.Forms.RadioButton rbPresencial;
        private System.Windows.Forms.RadioButton rbVirtual;
        private System.Windows.Forms.Label lblModalidad;
        private System.Windows.Forms.DateTimePicker dtpAnho;
        private System.Windows.Forms.CheckBox cbDispMovil;
        private System.Windows.Forms.TextBox txtSemestre;
        private System.Windows.Forms.Label lblSemestre;
        private System.Windows.Forms.Label lblGuion;
        private System.Windows.Forms.Button btnDescargarSilabo;
        private System.Windows.Forms.Button btnSubirSilabo;
        private System.Windows.Forms.TextBox txtSilabo;
        private System.Windows.Forms.Label lblSilabo;
        private System.Windows.Forms.TextBox txtSumilla;
        private System.Windows.Forms.Label lblSumilla;
        private System.Windows.Forms.Button btnBuscarDocente;
        private System.Windows.Forms.TextBox txtNombreDocente;
        private System.Windows.Forms.TextBox txtCodigoDocente;
        private System.Windows.Forms.Label lblNombreDocente;
        private System.Windows.Forms.Label lblCodigoDocente;
        private System.Windows.Forms.DataGridView dgvDocentes;
        private System.Windows.Forms.DataGridViewTextBoxColumn CodigoPUCP;
        private System.Windows.Forms.DataGridViewTextBoxColumn NombreCompleto;
        private System.Windows.Forms.DataGridViewTextBoxColumn CategoriaFiliacion;
        private System.Windows.Forms.PictureBox pbFoto;
        private System.Windows.Forms.Button btnSubirFoto;
        private System.Windows.Forms.OpenFileDialog ofdFoto;
        private System.Windows.Forms.OpenFileDialog ofdArchivo;
        private System.Windows.Forms.SaveFileDialog sfdArchivo;
        private System.Windows.Forms.Button btnEliminarDocente;
        private System.Windows.Forms.Button btnAgregarDocente;
    }
}

