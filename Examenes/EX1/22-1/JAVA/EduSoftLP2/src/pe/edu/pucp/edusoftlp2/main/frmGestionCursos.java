package pe.edu.pucp.edusoftlp2.main;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmGestionCursos extends javax.swing.JPanel {
    
    private Estado estado;
    private File archivoFoto;
    private File archivoPDF;
    
    /*
    Coloque aquí sus datos:
    Código:
    Nombre:
    */
    
    public frmGestionCursos() {
        initComponents();
        colocarIconos();
        dgvDocentes.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
        estado = Estado.Inicial;
        estadoComponentes();
        limpiarComponentes();
    }
    
    public void estadoComponentes(){
        switch (estado) {
            case Inicial:
                btnNuevo.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnCancelar.setEnabled(true);
                txtNombreCurso.setEnabled(false);
                txtClave.setEnabled(false);
                dtpAnho.setEnabled(false);
                txtSemestre.setEnabled(false);
                rbVirtual.setEnabled(false);
                rbPresencial.setEnabled(false);
                rbSemiPresencial.setEnabled(false);
                btnSubirFoto.setEnabled(false);
                cboEspecialidades.setEnabled(false);
                cbComputadora.setEnabled(false);
                cbDispMovil.setEnabled(false);
                cbDispEspecial.setEnabled(false);
                txtSumilla.setEnabled(false);
                txtSilabo.setEnabled(false);
                btnSubirSilabo.setEnabled(false);
                btnDescargarSilabo.setEnabled(false);
                txtCodigoDocente.setEnabled(false);
                txtNombreDocente.setEnabled(false);
                btnBuscarDocente.setEnabled(false);
                btnAgregarDocente.setEnabled(false);
                btnEliminarDocente.setEnabled(false);
                dgvDocentes.setEnabled(false);
                break;
            case Nuevo:
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnBuscar.setEnabled(false);
                btnCancelar.setEnabled(true);
                txtNombreCurso.setEnabled(true);
                txtClave.setEnabled(true);
                dtpAnho.setEnabled(true);
                txtSemestre.setEnabled(true);
                rbVirtual.setEnabled(true);
                rbPresencial.setEnabled(true);
                rbSemiPresencial.setEnabled(true);
                btnSubirFoto.setEnabled(true);
                cboEspecialidades.setEnabled(true);
                cbComputadora.setEnabled(true);
                cbDispMovil.setEnabled(true);
                cbDispEspecial.setEnabled(true);
                txtSumilla.setEnabled(true);
                txtSilabo.setEnabled(true);
                btnSubirSilabo.setEnabled(true);
                btnDescargarSilabo.setEnabled(false);
                txtCodigoDocente.setEnabled(true);
                txtNombreDocente.setEnabled(true);
                btnBuscarDocente.setEnabled(true);
                btnAgregarDocente.setEnabled(true);
                btnEliminarDocente.setEnabled(true);
                dgvDocentes.setEnabled(true);
                break;
            case Buscar:
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnBuscar.setEnabled(false);
                btnCancelar.setEnabled(true);
                txtNombreCurso.setEnabled(true);
                txtNombreCurso.setEditable(false);
                txtClave.setEnabled(true);
                txtClave.setEditable(false);
                dtpAnho.setEnabled(false);
                txtSemestre.setEnabled(true);
                txtSemestre.setEditable(false);
                rbVirtual.setEnabled(false);
                rbPresencial.setEnabled(false);
                rbSemiPresencial.setEnabled(false);
                btnSubirFoto.setEnabled(false);
                cboEspecialidades.setEnabled(false);
                cbComputadora.setEnabled(false);
                cbDispMovil.setEnabled(false);
                cbDispEspecial.setEnabled(false);
                txtSumilla.setEnabled(true);
                txtSumilla.setEditable(false);
                txtSilabo.setEnabled(false);
                btnSubirSilabo.setEnabled(false);
                btnDescargarSilabo.setEnabled(true);
                txtCodigoDocente.setEnabled(false);
                txtNombreDocente.setEnabled(false);
                btnBuscarDocente.setEnabled(false);
                btnAgregarDocente.setEnabled(false);
                btnEliminarDocente.setEnabled(false);
                dgvDocentes.setEnabled(false);
                break;
        }
    }
    
    public void limpiarComponentes()
    {
        txtNombreCurso.setText("");
        txtClave.setText("");
        dtpAnho.setValue(Calendar.getInstance().get(Calendar.YEAR));
        txtSemestre.setText("");
        rbVirtual.setSelected(false);
        rbPresencial.setSelected(false);
        rbSemiPresencial.setSelected(false);
        cboEspecialidades.setSelectedIndex(-1);
        cbComputadora.setSelected(false);
        cbDispMovil.setSelected(false);
        cbDispEspecial.setSelected(false);
        txtSumilla.setText("");
        txtSilabo.setText("");
        txtCodigoDocente.setText("");
        txtNombreDocente.setText("");
        pbFoto.setIcon(null);
        archivoFoto = null;
        archivoPDF = null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ofdFoto = new javax.swing.JFileChooser();
        ofdSilabo = new javax.swing.JFileChooser();
        bgModalidad = new javax.swing.ButtonGroup();
        jtbMenu = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        tbInfoCursos = new javax.swing.JTabbedPane();
        tabDatosGenerales = new javax.swing.JPanel();
        lblNombreCurso = new javax.swing.JLabel();
        txtNombreCurso = new javax.swing.JTextField();
        pbFoto = new javax.swing.JLabel();
        lblClave = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        lblSemestre = new javax.swing.JLabel();
        dtpAnho = new com.toedter.calendar.JYearChooser();
        lblGuion = new javax.swing.JLabel();
        txtSemestre = new javax.swing.JTextField();
        lblModalidad = new javax.swing.JLabel();
        rbVirtual = new javax.swing.JRadioButton();
        rbPresencial = new javax.swing.JRadioButton();
        rbSemiPresencial = new javax.swing.JRadioButton();
        lblEspecialidad = new javax.swing.JLabel();
        cboEspecialidades = new javax.swing.JComboBox<>();
        lblRequerimientos = new javax.swing.JLabel();
        cbComputadora = new javax.swing.JCheckBox();
        cbDispMovil = new javax.swing.JCheckBox();
        cbDispEspecial = new javax.swing.JCheckBox();
        lblSumilla = new javax.swing.JLabel();
        jspSumilla = new javax.swing.JScrollPane();
        txtSumilla = new javax.swing.JTextArea();
        lblSilabo = new javax.swing.JLabel();
        txtSilabo = new javax.swing.JTextField();
        btnSubirSilabo = new javax.swing.JButton();
        btnDescargarSilabo = new javax.swing.JButton();
        btnSubirFoto = new javax.swing.JButton();
        tabDocentes = new javax.swing.JPanel();
        jspDocentes = new javax.swing.JScrollPane();
        dgvDocentes = new javax.swing.JTable();
        lblCodigoDocente = new javax.swing.JLabel();
        txtCodigoDocente = new javax.swing.JTextField();
        lblNombreDocente = new javax.swing.JLabel();
        txtNombreDocente = new javax.swing.JTextField();
        btnBuscarDocente = new javax.swing.JButton();
        btnEliminarDocente = new javax.swing.JButton();
        btnAgregarDocente = new javax.swing.JButton();

        jtbMenu.setBackground(new java.awt.Color(204, 204, 255));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        btnNuevo.setBackground(new java.awt.Color(204, 204, 255));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setFocusable(false);
        btnNuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        jtbMenu.add(btnNuevo);

        btnGuardar.setBackground(new java.awt.Color(204, 204, 255));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbMenu.add(btnGuardar);

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbMenu.add(btnBuscar);

        btnCancelar.setBackground(new java.awt.Color(204, 204, 255));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusable(false);
        btnCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnCancelar);

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblTitulo.setText("Gestión de Cursos del Departamento de Ingeniería - PUCP");

        tbInfoCursos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblNombreCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNombreCurso.setText("Nombre del Curso:");

        txtNombreCurso.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        pbFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblClave.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblClave.setText("Clave del Curso:");

        txtClave.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblSemestre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblSemestre.setText("Semestre:");

        dtpAnho.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblGuion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblGuion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGuion.setText("-");

        txtSemestre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtSemestre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblModalidad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblModalidad.setText("Modalidad del Curso:");

        bgModalidad.add(rbVirtual);
        rbVirtual.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbVirtual.setText("Virtual");

        bgModalidad.add(rbPresencial);
        rbPresencial.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbPresencial.setText("Presencial");

        bgModalidad.add(rbSemiPresencial);
        rbSemiPresencial.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbSemiPresencial.setText("Semi-Presencial");

        lblEspecialidad.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblEspecialidad.setText("Especialidad:");

        lblRequerimientos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblRequerimientos.setText("Requerimientos:");

        cbComputadora.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        cbComputadora.setText("Computadora");

        cbDispMovil.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        cbDispMovil.setText("Dispositivo Móvil");

        cbDispEspecial.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        cbDispEspecial.setText("Dispositivo Especializado");

        lblSumilla.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblSumilla.setText("Sumilla:");

        txtSumilla.setColumns(20);
        txtSumilla.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtSumilla.setLineWrap(true);
        txtSumilla.setRows(5);
        txtSumilla.setWrapStyleWord(true);
        jspSumilla.setViewportView(txtSumilla);

        lblSilabo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblSilabo.setText("Sílabo del Curso:");

        txtSilabo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnSubirSilabo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSubirSilabo.setText("Subir");
        btnSubirSilabo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirSilaboActionPerformed(evt);
            }
        });

        btnDescargarSilabo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnDescargarSilabo.setText("Descargar");
        btnDescargarSilabo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarSilaboActionPerformed(evt);
            }
        });

        btnSubirFoto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSubirFoto.setText("Subir Foto");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabDatosGeneralesLayout = new javax.swing.GroupLayout(tabDatosGenerales);
        tabDatosGenerales.setLayout(tabDatosGeneralesLayout);
        tabDatosGeneralesLayout.setHorizontalGroup(
            tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSilabo)
                    .addComponent(lblSumilla)
                    .addComponent(lblRequerimientos)
                    .addComponent(lblNombreCurso)
                    .addComponent(lblClave)
                    .addComponent(lblSemestre)
                    .addComponent(lblModalidad)
                    .addComponent(lblEspecialidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtClave)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, tabDatosGeneralesLayout.createSequentialGroup()
                                    .addComponent(dtpAnho, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lblGuion, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(tabDatosGeneralesLayout.createSequentialGroup()
                                .addComponent(rbVirtual)
                                .addGap(18, 18, 18)
                                .addComponent(rbPresencial)
                                .addGap(18, 18, 18)
                                .addComponent(rbSemiPresencial))
                            .addComponent(cboEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubirFoto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pbFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jspSumilla)
                    .addGroup(tabDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(cbComputadora)
                        .addGap(18, 18, 18)
                        .addComponent(cbDispMovil)
                        .addGap(18, 18, 18)
                        .addComponent(cbDispEspecial)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(txtSilabo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubirSilabo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescargarSilabo)))
                .addContainerGap())
        );
        tabDatosGeneralesLayout.setVerticalGroup(
            tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreCurso)
                            .addComponent(btnSubirFoto))
                        .addGap(18, 18, 18)
                        .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblClave))
                        .addGap(18, 18, 18)
                        .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtpAnho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblGuion)
                                .addComponent(txtSemestre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSemestre))
                        .addGap(18, 18, 18)
                        .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbVirtual)
                            .addComponent(rbPresencial)
                            .addComponent(rbSemiPresencial)
                            .addComponent(lblModalidad))
                        .addGap(18, 18, 18)
                        .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboEspecialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEspecialidad)))
                    .addComponent(pbFoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbComputadora)
                    .addComponent(cbDispMovil)
                    .addComponent(cbDispEspecial)
                    .addComponent(lblRequerimientos))
                .addGap(18, 18, 18)
                .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspSumilla, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSumilla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tabDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSilabo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSubirSilabo)
                    .addComponent(btnDescargarSilabo)
                    .addComponent(lblSilabo))
                .addContainerGap())
        );

        tbInfoCursos.addTab("Datos Generales", tabDatosGenerales);

        dgvDocentes.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        dgvDocentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código PUCP", "Nombre Completo", "Categoría/Filiación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspDocentes.setViewportView(dgvDocentes);
        if (dgvDocentes.getColumnModel().getColumnCount() > 0) {
            dgvDocentes.getColumnModel().getColumn(0).setResizable(false);
            dgvDocentes.getColumnModel().getColumn(0).setPreferredWidth(100);
            dgvDocentes.getColumnModel().getColumn(1).setResizable(false);
            dgvDocentes.getColumnModel().getColumn(1).setPreferredWidth(400);
            dgvDocentes.getColumnModel().getColumn(2).setResizable(false);
            dgvDocentes.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        lblCodigoDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblCodigoDocente.setText("Código PUCP:");

        txtCodigoDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblNombreDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNombreDocente.setText("Nombre Completo:");

        txtNombreDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnBuscarDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscarDocente.setText("...");

        btnEliminarDocente.setText("-");

        btnAgregarDocente.setText("+");

        javax.swing.GroupLayout tabDocentesLayout = new javax.swing.GroupLayout(tabDocentes);
        tabDocentes.setLayout(tabDocentesLayout);
        tabDocentesLayout.setHorizontalGroup(
            tabDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDocentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspDocentes)
                    .addGroup(tabDocentesLayout.createSequentialGroup()
                        .addGroup(tabDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreDocente)
                            .addComponent(lblCodigoDocente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tabDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabDocentesLayout.createSequentialGroup()
                                .addComponent(txtCodigoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(tabDocentesLayout.createSequentialGroup()
                                .addComponent(txtNombreDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(187, 187, 187)
                        .addComponent(btnAgregarDocente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarDocente)))
                .addContainerGap())
        );
        tabDocentesLayout.setVerticalGroup(
            tabDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDocentesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoDocente)
                    .addComponent(txtCodigoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDocente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabDocentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDocente)
                    .addComponent(txtNombreDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarDocente)
                    .addComponent(btnAgregarDocente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspDocentes, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        tbInfoCursos.addTab("Docentes Asignados", tabDocentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbInfoCursos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tbInfoCursos)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        estado = Estado.Nuevo;
        limpiarComponentes();
        estadoComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estado = Estado.Inicial;
        limpiarComponentes();
        estadoComponentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFotoActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG","PNG","jpg","png");
        ofdFoto.setFileFilter(filtro);
        int resultado = ofdFoto.showOpenDialog(null);
        if(resultado == JFileChooser.APPROVE_OPTION){
            try{
                archivoFoto = ofdFoto.getSelectedFile();
                Image img = new ImageIcon(archivoFoto.toString()).getImage();
                Image newImg = img.getScaledInstance(pbFoto.getWidth(), pbFoto.getHeight(), java.awt.Image.SCALE_SMOOTH);
                pbFoto.setIcon(new ImageIcon(newImg));
                
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }        
    }//GEN-LAST:event_btnSubirFotoActionPerformed

    private void btnSubirSilaboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirSilaboActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF","pdf");
        ofdSilabo.setFileFilter(filtro);
        int resultado = ofdSilabo.showOpenDialog(null);
        //Si ha seleccionado un archivo
        if(resultado == JFileChooser.APPROVE_OPTION){
            //Asignamos el archivo a la variable
            this.archivoPDF = ofdSilabo.getSelectedFile();
            //Convertimos el archivo a byte[] y lo asignamos al objeto Articulo
            try{
                txtSilabo.setText(this.archivoPDF.getPath());
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe","Mensaje de Error",JOptionPane.ERROR_MESSAGE);
                System.out.println("Error al momento de convertir el archivo a byte[]");
            }
        }
    }//GEN-LAST:event_btnSubirSilaboActionPerformed

    private void btnDescargarSilaboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarSilaboActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF","pdf");
        ofdSilabo.setFileFilter(filtro);
        int resultado = ofdSilabo.showOpenDialog(null);
        //Si ha seleccionado una ruta y nombre
        if(resultado == JFileChooser.APPROVE_OPTION){
            File archivoGenerar = ofdSilabo.getSelectedFile();
            try{
                FileOutputStream fos = new FileOutputStream(archivoGenerar);
                fos.flush();
                fos.close();
                JOptionPane.showMessageDialog(null, "Se ha generado el archivo PDF","Mensaje de Confirmación",JOptionPane.INFORMATION_MESSAGE);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error al momento de generar el PDF","Mensaje de Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDescargarSilaboActionPerformed

    public void colocarIconos(){
        URL iconUrl = this.getClass().getResource("/pe/edu/pucp/edusoftlp2/img/nuevo.png");
        Image img = new ImageIcon(iconUrl).getImage();
        Image newimg = img.getScaledInstance(15, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnNuevo.setIcon(new ImageIcon(newimg));
        btnNuevo.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/edusoftlp2/img/guardar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnGuardar.setIcon(new ImageIcon(newimg));
        btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/edusoftlp2/img/buscar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnBuscar.setIcon(new ImageIcon(newimg));
        btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/edusoftlp2/img/cancelar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnCancelar.setIcon(new ImageIcon(newimg));
        btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgModalidad;
    private javax.swing.JButton btnAgregarDocente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarDocente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDescargarSilabo;
    private javax.swing.JButton btnEliminarDocente;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JButton btnSubirSilabo;
    private javax.swing.JCheckBox cbComputadora;
    private javax.swing.JCheckBox cbDispEspecial;
    private javax.swing.JCheckBox cbDispMovil;
    private javax.swing.JComboBox<String> cboEspecialidades;
    private javax.swing.JTable dgvDocentes;
    private com.toedter.calendar.JYearChooser dtpAnho;
    private javax.swing.JScrollPane jspDocentes;
    private javax.swing.JScrollPane jspSumilla;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblClave;
    private javax.swing.JLabel lblCodigoDocente;
    private javax.swing.JLabel lblEspecialidad;
    private javax.swing.JLabel lblGuion;
    private javax.swing.JLabel lblModalidad;
    private javax.swing.JLabel lblNombreCurso;
    private javax.swing.JLabel lblNombreDocente;
    private javax.swing.JLabel lblRequerimientos;
    private javax.swing.JLabel lblSemestre;
    private javax.swing.JLabel lblSilabo;
    private javax.swing.JLabel lblSumilla;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JFileChooser ofdFoto;
    private javax.swing.JFileChooser ofdSilabo;
    private javax.swing.JLabel pbFoto;
    private javax.swing.JRadioButton rbPresencial;
    private javax.swing.JRadioButton rbSemiPresencial;
    private javax.swing.JRadioButton rbVirtual;
    private javax.swing.JPanel tabDatosGenerales;
    private javax.swing.JPanel tabDocentes;
    private javax.swing.JTabbedPane tbInfoCursos;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtCodigoDocente;
    private javax.swing.JTextField txtNombreCurso;
    private javax.swing.JTextField txtNombreDocente;
    private javax.swing.JTextField txtSemestre;
    private javax.swing.JTextField txtSilabo;
    private javax.swing.JTextArea txtSumilla;
    // End of variables declaration//GEN-END:variables
}
