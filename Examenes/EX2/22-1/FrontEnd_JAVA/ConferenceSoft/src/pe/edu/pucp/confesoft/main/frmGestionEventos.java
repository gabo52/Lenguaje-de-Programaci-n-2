package pe.edu.pucp.confesoft.main;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmGestionEventos extends javax.swing.JPanel {

    private File archivo;
    private Estado estado;
    
    public frmGestionEventos() {
        initComponents();
        colocarIconos();
        tblPonencias.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
        estado = Estado.Inicial;
        estadoComponentes();
    }

    public void limpiarComponentes()
    {
        txtID.setText("");
        txtNombre.setText("");
        dtpFechaEvento.setDate(new Date());
        txtDescripcion.setText("");
        txtCodigoPUCPPonente.setText("");
        txtNombrePonente.setText("");
        txtTituloPonencia.setText("");
        dtpHoraInicio.setValue(new Date());
        dtpHoraFin.setValue(new Date());
        pbPortada.setIcon(null);
        archivo = null;
    }
    
    public void estadoComponentes(){
        switch (estado) {
            case Inicial:
                btnNuevo.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnCancelar.setEnabled(false);
                btnSubirPortada.setEnabled(false);
                btnBuscarPonente.setEnabled(false);
                btnAgregarPonente.setEnabled(false);
                btnEliminarPonente.setEnabled(false);
                txtID.setEnabled(false);
                txtNombre.setEnabled(false);
                dtpFechaEvento.setEnabled(false);
                txtDescripcion.setEnabled(false);
                txtTituloPonencia.setEnabled(false);
                txtCodigoPUCPPonente.setEnabled(false);
                txtNombrePonente.setEnabled(false);
                dtpHoraInicio.setEnabled(false);
                dtpHoraFin.setEnabled(false);
                tblPonencias.setEnabled(false);
                break;
            case Nuevo:
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnBuscar.setEnabled(false);
                btnCancelar.setEnabled(true);
                btnSubirPortada.setEnabled(true);
                btnBuscarPonente.setEnabled(true);
                btnAgregarPonente.setEnabled(true);
                btnEliminarPonente.setEnabled(true);
                txtID.setEnabled(true);
                txtNombre.setEnabled(true);
                dtpFechaEvento.setEnabled(true);
                txtDescripcion.setEnabled(true);
                txtTituloPonencia.setEnabled(true);
                txtCodigoPUCPPonente.setEnabled(true);
                txtNombrePonente.setEnabled(true);
                dtpHoraInicio.setEnabled(true);
                dtpHoraFin.setEnabled(true);
                tblPonencias.setEnabled(true);
                break;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jfcPortada = new javax.swing.JFileChooser();
        jtbMenu = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        panelDatosGenerales = new javax.swing.JPanel();
        btnSubirPortada = new javax.swing.JButton();
        pbPortada = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        lblFechaEvento = new javax.swing.JLabel();
        dtpFechaEvento = new com.toedter.calendar.JDateChooser();
        lblDescripcion = new javax.swing.JLabel();
        jspDescripcion = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        panelPonencias = new javax.swing.JPanel();
        jspPonencias = new javax.swing.JScrollPane();
        tblPonencias = new javax.swing.JTable();
        lblCodigoPUCPPonente = new javax.swing.JLabel();
        txtCodigoPUCPPonente = new javax.swing.JTextField();
        btnBuscarPonente = new javax.swing.JButton();
        lblNombrePonente = new javax.swing.JLabel();
        txtNombrePonente = new javax.swing.JTextField();
        lblTituloPonencia = new javax.swing.JLabel();
        txtTituloPonencia = new javax.swing.JTextField();
        lblHoraInicio = new javax.swing.JLabel();
        dtpHoraInicio = new javax.swing.JSpinner();
        lblHoraFin = new javax.swing.JLabel();
        dtpHoraFin = new javax.swing.JSpinner();
        btnAgregarPonente = new javax.swing.JButton();
        btnEliminarPonente = new javax.swing.JButton();

        jtbMenu.setBackground(new java.awt.Color(255, 204, 204));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        btnNuevo.setBackground(new java.awt.Color(255, 204, 204));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        btnGuardar.setBackground(new java.awt.Color(255, 204, 204));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbMenu.add(btnGuardar);

        btnBuscar.setBackground(new java.awt.Color(255, 204, 204));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setFocusable(false);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnBuscar);

        btnCancelar.setBackground(new java.awt.Color(255, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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

        panelDatosGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del Evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 11))); // NOI18N

        btnSubirPortada.setText("Subir Portada del Evento");
        btnSubirPortada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirPortadaActionPerformed(evt);
            }
        });

        pbPortada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblID.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblID.setText("ID del Evento:");

        txtID.setEditable(false);
        txtID.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNombre.setText("Nombre del Evento:");

        lblFechaEvento.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaEvento.setText("Fecha del Evento:");

        dtpFechaEvento.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblDescripcion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblDescripcion.setText("Descripción del Evento:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        txtDescripcion.setWrapStyleWord(true);
        jspDescripcion.setViewportView(txtDescripcion);

        javax.swing.GroupLayout panelDatosGeneralesLayout = new javax.swing.GroupLayout(panelDatosGenerales);
        panelDatosGenerales.setLayout(panelDatosGeneralesLayout);
        panelDatosGeneralesLayout.setHorizontalGroup(
            panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pbPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSubirPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblID)
                            .addComponent(lblNombre)
                            .addComponent(lblFechaEvento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                                .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtpFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                                .addComponent(lblDescripcion)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jspDescripcion))))
                .addContainerGap())
        );
        panelDatosGeneralesLayout.setVerticalGroup(
            panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDatosGeneralesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSubirPortada)
                .addGap(6, 6, 6)
                .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaEvento)
                            .addComponent(dtpFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(lblDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pbPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        panelPonencias.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ponencias del Evento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 11))); // NOI18N

        tblPonencias.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        tblPonencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ponente", "Ponencia", "Hora Inicio", "Hora Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspPonencias.setViewportView(tblPonencias);
        if (tblPonencias.getColumnModel().getColumnCount() > 0) {
            tblPonencias.getColumnModel().getColumn(0).setResizable(false);
            tblPonencias.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblPonencias.getColumnModel().getColumn(1).setResizable(false);
            tblPonencias.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblPonencias.getColumnModel().getColumn(2).setResizable(false);
            tblPonencias.getColumnModel().getColumn(2).setPreferredWidth(130);
            tblPonencias.getColumnModel().getColumn(3).setResizable(false);
            tblPonencias.getColumnModel().getColumn(3).setPreferredWidth(130);
        }

        lblCodigoPUCPPonente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblCodigoPUCPPonente.setText("Código PUCP:");

        txtCodigoPUCPPonente.setEditable(false);
        txtCodigoPUCPPonente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnBuscarPonente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscarPonente.setText("...");
        btnBuscarPonente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarPonenteActionPerformed(evt);
            }
        });

        lblNombrePonente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNombrePonente.setText("Nombre del Ponente:");

        txtNombrePonente.setEditable(false);
        txtNombrePonente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblTituloPonencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblTituloPonencia.setText("Título de la Ponencia:");

        txtTituloPonencia.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblHoraInicio.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblHoraInicio.setText("Hora de Inicio:");

        dtpHoraInicio.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        dtpHoraInicio.setModel(new javax.swing.SpinnerDateModel());
        dtpHoraInicio.setEditor(new javax.swing.JSpinner.DateEditor(dtpHoraInicio, "HH:mm"));

        lblHoraFin.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblHoraFin.setText("Hora Fin:");

        dtpHoraFin.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        dtpHoraFin.setModel(new javax.swing.SpinnerDateModel());
        dtpHoraFin.setEditor(new javax.swing.JSpinner.DateEditor(dtpHoraFin, "HH:mm"));

        btnAgregarPonente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnAgregarPonente.setText("+");
        btnAgregarPonente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPonenteActionPerformed(evt);
            }
        });

        btnEliminarPonente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnEliminarPonente.setText("-");

        javax.swing.GroupLayout panelPonenciasLayout = new javax.swing.GroupLayout(panelPonencias);
        panelPonencias.setLayout(panelPonenciasLayout);
        panelPonenciasLayout.setHorizontalGroup(
            panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPonenciasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspPonencias)
                    .addGroup(panelPonenciasLayout.createSequentialGroup()
                        .addGroup(panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelPonenciasLayout.createSequentialGroup()
                                .addComponent(lblCodigoPUCPPonente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCodigoPUCPPonente, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscarPonente))
                            .addGroup(panelPonenciasLayout.createSequentialGroup()
                                .addComponent(lblNombrePonente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombrePonente, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPonenciasLayout.createSequentialGroup()
                                .addComponent(lblTituloPonencia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTituloPonencia, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 201, Short.MAX_VALUE))
                    .addGroup(panelPonenciasLayout.createSequentialGroup()
                        .addComponent(lblHoraInicio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtpHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(lblHoraFin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtpHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarPonente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarPonente)))
                .addContainerGap())
        );
        panelPonenciasLayout.setVerticalGroup(
            panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPonenciasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoPUCPPonente)
                    .addComponent(txtCodigoPUCPPonente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarPonente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombrePonente)
                    .addComponent(txtNombrePonente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloPonencia)
                    .addComponent(txtTituloPonencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPonenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoraInicio)
                    .addComponent(dtpHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoraFin)
                    .addComponent(dtpHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPonente)
                    .addComponent(btnEliminarPonente))
                .addGap(7, 7, 7)
                .addComponent(jspPonencias, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPonencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelDatosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPonencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirPortadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirPortadaActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "PNG", "jpg", "png");
        jfcPortada.setFileFilter(filtro);
        int resultado = jfcPortada.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                archivo = jfcPortada.getSelectedFile();
                Image img = new ImageIcon(archivo.toString()).getImage();
                Image newImg = img.getScaledInstance(pbPortada.getWidth(), pbPortada.getHeight(), java.awt.Image.SCALE_SMOOTH);
                pbPortada.setIcon(new ImageIcon(newImg));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSubirPortadaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JDialog formDialogBusqEventos = new JDialog();
        frmBusquedaEventos panelBusqEventos = new frmBusquedaEventos(formDialogBusqEventos);
        formDialogBusqEventos.add(panelBusqEventos);
        formDialogBusqEventos.pack();
        formDialogBusqEventos.setFocusable(true);
        formDialogBusqEventos.setTitle("Formulario de Búsqueda de Eventos");
        formDialogBusqEventos.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        formDialogBusqEventos.setModal(true);
        formDialogBusqEventos.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarPonenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarPonenteActionPerformed
        JDialog formDialogBusqIntegrantes = new JDialog();
        frmBusquedaIntegrantes panelBusqIntegrantes = new frmBusquedaIntegrantes(formDialogBusqIntegrantes);
        formDialogBusqIntegrantes.add(panelBusqIntegrantes);
        formDialogBusqIntegrantes.pack();
        formDialogBusqIntegrantes.setFocusable(true);
        formDialogBusqIntegrantes.setTitle("Formulario de Búsqueda de Integrantes");
        formDialogBusqIntegrantes.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        formDialogBusqIntegrantes.setModal(true);
        formDialogBusqIntegrantes.setVisible(true);
    }//GEN-LAST:event_btnBuscarPonenteActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        estado = Estado.Nuevo;
        estadoComponentes();
        limpiarComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estado = Estado.Inicial;
        estadoComponentes();
        limpiarComponentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarPonenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPonenteActionPerformed

    }//GEN-LAST:event_btnAgregarPonenteActionPerformed

    public void colocarIconos(){
        URL iconUrl = this.getClass().getResource("/pe/edu/pucp/confesoft/icons/nuevo.png");
        Image img = new ImageIcon(iconUrl).getImage();
        Image newimg = img.getScaledInstance(15, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnNuevo.setIcon(new ImageIcon(newimg));
        btnNuevo.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/confesoft/icons/guardar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnGuardar.setIcon(new ImageIcon(newimg));
        btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/confesoft/icons/buscar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnBuscar.setIcon(new ImageIcon(newimg));
        btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/confesoft/icons/cancelar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnCancelar.setIcon(new ImageIcon(newimg));
        btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPonente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarPonente;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarPonente;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSubirPortada;
    private com.toedter.calendar.JDateChooser dtpFechaEvento;
    private javax.swing.JSpinner dtpHoraFin;
    private javax.swing.JSpinner dtpHoraInicio;
    private javax.swing.JFileChooser jfcPortada;
    private javax.swing.JScrollPane jspDescripcion;
    private javax.swing.JScrollPane jspPonencias;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblCodigoPUCPPonente;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblFechaEvento;
    private javax.swing.JLabel lblHoraFin;
    private javax.swing.JLabel lblHoraInicio;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombrePonente;
    private javax.swing.JLabel lblTituloPonencia;
    private javax.swing.JPanel panelDatosGenerales;
    private javax.swing.JPanel panelPonencias;
    private javax.swing.JLabel pbPortada;
    private javax.swing.JTable tblPonencias;
    private javax.swing.JTextField txtCodigoPUCPPonente;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombrePonente;
    private javax.swing.JTextField txtTituloPonencia;
    // End of variables declaration//GEN-END:variables
}
