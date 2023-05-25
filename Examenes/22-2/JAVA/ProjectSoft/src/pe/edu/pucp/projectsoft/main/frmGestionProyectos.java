package pe.edu.pucp.projectsoft.main;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import java.nio.file.Files;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import pe.edu.pucp.projectsoft.DAO.AreaDAO;
import pe.edu.pucp.projectsoft.DAO.EstudianteDAO;
import pe.edu.pucp.projectsoft.DAO.ProyectoDAO;
import pe.edu.pucp.projectsoft.MySQL.AreaMySQL;
import pe.edu.pucp.projectsoft.MySQL.EstudianteMySQL;
import pe.edu.pucp.projectsoft.MySQL.ProyectoMySQL;
import pe.edu.pucp.projectsoft.model.Area;
import pe.edu.pucp.projectsoft.model.Docente;
import pe.edu.pucp.projectsoft.model.Estudiante;
import pe.edu.pucp.projectsoft.model.Proyecto;

public class frmGestionProyectos extends javax.swing.JPanel {
    private Proyecto proyecto;
    private ProyectoDAO daoProyecto;
    private File archivoPDF;
    private File archivoFoto;
    private Estado estado;
    private Estudiante estudiante;
    private EstudianteDAO daoEstudiante;
    private Docente docente;
    private DefaultComboBoxModel modeloAreas;
    private AreaDAO daoArea;
    
    public frmGestionProyectos() {
        initComponents();
        dgvJurados.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
        colocarIconos();
        
        cboArea.setRenderer( new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if(value instanceof Area){
                setText(((Area)value).getNombre());
            }
            return this;
            }
        });
        


        estado = Estado.Inicial;
        establecerEstadoComponentes();
        
        daoArea = new AreaMySQL();
        daoProyecto = new ProyectoMySQL();
        modeloAreas = new DefaultComboBoxModel(daoArea.listarTodas().toArray());
        cboArea.setModel(modeloAreas);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ofdArchivo = new javax.swing.JFileChooser();
        ofdFoto = new javax.swing.JFileChooser();
        jtbMenu = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        tcProyecto = new javax.swing.JTabbedPane();
        tpDatosGenerales = new javax.swing.JPanel();
        pbFoto = new javax.swing.JLabel();
        txtEstudiante = new javax.swing.JTextField();
        btnSubirFoto = new javax.swing.JButton();
        lblEstudiante = new javax.swing.JLabel();
        btnBuscarEstudiante = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        jspTitulo = new javax.swing.JScrollPane();
        txtTitulo = new javax.swing.JTextPane();
        lblDescripcion = new javax.swing.JLabel();
        jspDescripcion = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        lblArea = new javax.swing.JLabel();
        cboArea = new javax.swing.JComboBox<>();
        lblArchivoTemaTesis = new javax.swing.JLabel();
        txtRutaArchivo = new javax.swing.JTextField();
        btnSubirArchivo = new javax.swing.JButton();
        btnDescargarArchivo = new javax.swing.JButton();
        tpJurados = new javax.swing.JPanel();
        jspJurados = new javax.swing.JScrollPane();
        dgvJurados = new javax.swing.JTable();
        lblCodigoPUCPDocente = new javax.swing.JLabel();
        lblNombreCompletoDocente = new javax.swing.JLabel();
        txtCodigoPUCPDocente = new javax.swing.JTextField();
        txtNombreCompletoDocente = new javax.swing.JTextField();
        btnBuscarDocente = new javax.swing.JButton();
        btnAgregarJurado = new javax.swing.JButton();
        btnEliminarJurado = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(799, 412));

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
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jtbMenu.add(btnGuardar);

        btnBuscar.setBackground(new java.awt.Color(204, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
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

        tcProyecto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        pbFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtEstudiante.setEditable(false);
        txtEstudiante.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnSubirFoto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSubirFoto.setText("Subir Foto");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });

        lblEstudiante.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblEstudiante.setText("Estudiante:");

        btnBuscarEstudiante.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscarEstudiante.setText("...");
        btnBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEstudianteActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblTitulo.setText("Título:");

        txtTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        jspTitulo.setViewportView(txtTitulo);

        lblDescripcion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblDescripcion.setText("Descripción:");

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        txtDescripcion.setRows(5);
        jspDescripcion.setViewportView(txtDescripcion);

        lblArea.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblArea.setText("Área Temática:");

        cboArea.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        cboArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAreaActionPerformed(evt);
            }
        });

        lblArchivoTemaTesis.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblArchivoTemaTesis.setText("Archivo PDF del Tema de Tesis:");

        txtRutaArchivo.setEditable(false);
        txtRutaArchivo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnSubirArchivo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSubirArchivo.setText("Subir");
        btnSubirArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirArchivoActionPerformed(evt);
            }
        });

        btnDescargarArchivo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnDescargarArchivo.setText("Descargar");
        btnDescargarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescargarArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tpDatosGeneralesLayout = new javax.swing.GroupLayout(tpDatosGenerales);
        tpDatosGenerales.setLayout(tpDatosGeneralesLayout);
        tpDatosGeneralesLayout.setHorizontalGroup(
            tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(lblArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSubirFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(pbFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                                .addComponent(txtEstudiante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jspTitulo)
                            .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                                .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblEstudiante)
                                    .addComponent(lblTitulo)
                                    .addComponent(lblDescripcion))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jspDescripcion)))
                    .addComponent(txtRutaArchivo)
                    .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(lblArchivoTemaTesis)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
                        .addComponent(btnSubirArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDescargarArchivo)))
                .addContainerGap())
        );
        tpDatosGeneralesLayout.setVerticalGroup(
            tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(pbFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSubirFoto))
                    .addGroup(tpDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(lblEstudiante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarEstudiante))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescripcion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jspDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(cboArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tpDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDescargarArchivo)
                        .addComponent(btnSubirArchivo))
                    .addComponent(lblArchivoTemaTesis, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tcProyecto.addTab("Datos Generales del Proyecto de Tesis", tpDatosGenerales);

        dgvJurados.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        dgvJurados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código PUCP", "Nombre Completo", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspJurados.setViewportView(dgvJurados);
        if (dgvJurados.getColumnModel().getColumnCount() > 0) {
            dgvJurados.getColumnModel().getColumn(0).setResizable(false);
            dgvJurados.getColumnModel().getColumn(0).setPreferredWidth(130);
            dgvJurados.getColumnModel().getColumn(1).setResizable(false);
            dgvJurados.getColumnModel().getColumn(1).setPreferredWidth(350);
            dgvJurados.getColumnModel().getColumn(2).setResizable(false);
            dgvJurados.getColumnModel().getColumn(2).setPreferredWidth(170);
        }

        lblCodigoPUCPDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblCodigoPUCPDocente.setText("Código PUCP:");

        lblNombreCompletoDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNombreCompletoDocente.setText("Nombre Completo:");

        txtCodigoPUCPDocente.setEditable(false);
        txtCodigoPUCPDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        txtNombreCompletoDocente.setEditable(false);
        txtNombreCompletoDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnBuscarDocente.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscarDocente.setText("...");
        btnBuscarDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDocenteActionPerformed(evt);
            }
        });

        btnAgregarJurado.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnAgregarJurado.setText("+");

        btnEliminarJurado.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnEliminarJurado.setText("-");

        javax.swing.GroupLayout tpJuradosLayout = new javax.swing.GroupLayout(tpJurados);
        tpJurados.setLayout(tpJuradosLayout);
        tpJuradosLayout.setHorizontalGroup(
            tpJuradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tpJuradosLayout.createSequentialGroup()
                .addGroup(tpJuradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tpJuradosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jspJurados))
                    .addGroup(tpJuradosLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(tpJuradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombreCompletoDocente)
                            .addComponent(lblCodigoPUCPDocente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(tpJuradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tpJuradosLayout.createSequentialGroup()
                                .addComponent(txtCodigoPUCPDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(tpJuradosLayout.createSequentialGroup()
                                .addComponent(txtNombreCompletoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(btnAgregarJurado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarJurado)))))
                .addContainerGap())
        );
        tpJuradosLayout.setVerticalGroup(
            tpJuradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tpJuradosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(tpJuradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoPUCPDocente)
                    .addComponent(txtCodigoPUCPDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarDocente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tpJuradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreCompletoDocente)
                    .addComponent(txtNombreCompletoDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarJurado)
                    .addComponent(btnEliminarJurado))
                .addGap(14, 14, 14)
                .addComponent(jspJurados, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tcProyecto.addTab("Jurados del Proyecto", tpJurados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tcProyecto)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tcProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tcProyecto.getAccessibleContext().setAccessibleName("tcProyectos");
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarComponentes()
    {
        txtEstudiante.setText("");
        txtTitulo.setText("");
        txtDescripcion.setText("");
        cboArea.setSelectedIndex(-1);
        pbFoto.setIcon(null);
        archivoPDF = null;
        archivoFoto = null;
        txtCodigoPUCPDocente.setText("");
        txtRutaArchivo.setText("");
        txtNombreCompletoDocente.setText("");
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        proyecto.setArea((Area)cboArea.getSelectedItem());
        proyecto.setDescripcion(txtDescripcion.getText());
        proyecto.setTitulo(txtTitulo.getText());
        int resultado = daoProyecto.insertar(proyecto);
        if(resultado != 0){
            JOptionPane.showMessageDialog(this, "Se ha registrado con éxito","Mensaje de confirmación", JOptionPane.INFORMATION_MESSAGE);
            estado = Estado.Inicial;
            establecerEstadoComponentes();
        }else
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error con el registro","Mensaje de error", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSubirArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirArchivoActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("PDF","pdf");
        ofdArchivo.setFileFilter(filtro);
        int resultado = ofdArchivo.showOpenDialog(null);
        //Si ha seleccionado un archivo
        if(resultado == JFileChooser.APPROVE_OPTION){
            //Asignamos el archivo a la variable
            this.archivoPDF = ofdArchivo.getSelectedFile();
            //Convertimos el archivo a byte[] y lo asignamos al objeto Articulo
            try{
                txtRutaArchivo.setText(this.archivoPDF.getPath());
                proyecto.setArchivoTemaTesis(Files.readAllBytes(this.archivoPDF.toPath()));
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "El archivo seleccionado no existe","Mensaje de Error",JOptionPane.ERROR_MESSAGE);
                System.out.println("Error al momento de convertir el archivo a byte[]");
            }
        }
    }//GEN-LAST:event_btnSubirArchivoActionPerformed

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
                proyecto.setFoto(Files.readAllBytes(archivoFoto.toPath()));
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSubirFotoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        estado = Estado.Nuevo;
        proyecto = new Proyecto();
        limpiarComponentes();
        establecerEstadoComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estado = Estado.Inicial;
        limpiarComponentes();
        establecerEstadoComponentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JDialog formModal = new JDialog();
        frmBusquedaProyectos panelBusqProyect = new frmBusquedaProyectos(formModal);
        formModal.add(panelBusqProyect);
        formModal.pack();
        formModal.setResizable(false);
        formModal.setTitle("Formulario de Búsqueda de Proyectos");
        formModal.setModal(true);
        formModal.setVisible(true);
        if(panelBusqProyect.getProyectoSeleccionado()!=null){
            proyecto = panelBusqProyect.getProyectoSeleccionado();
            txtDescripcion.setText(proyecto.getDescripcion());
            txtEstudiante.setText(proyecto.getEstudiante().getNombre() + " " + proyecto.getEstudiante().getApellidoPaterno());
            txtTitulo.setText(proyecto.getTitulo());
            
            Image img = new ImageIcon(proyecto.getFoto()).getImage();
            Image newImg = img.getScaledInstance(pbFoto.getWidth(), pbFoto.getHeight(), 
            java.awt.Image.SCALE_SMOOTH);
            pbFoto.setIcon(new ImageIcon(newImg));
            
            cboArea.getModel().setSelectedItem(proyecto.getArea());
            

            estado = Estado.Buscar;
            establecerEstadoComponentes();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEstudianteActionPerformed
        // TODO add your handling code here:
        JDialog formModal = new JDialog();
        frmBusquedaEstudiantes panelBusqEst = new frmBusquedaEstudiantes(formModal);
        formModal.add(panelBusqEst);
        formModal.pack();
        formModal.setResizable(false);
        formModal.setTitle("Formulario de Búsqueda de Estudiantes");
        formModal.setModal(true);
        formModal.setVisible(true);
        if(panelBusqEst.getEstudianteSeleccionado()!=null){
            estudiante = panelBusqEst.getEstudianteSeleccionado();
            txtEstudiante.setText(estudiante.getNombre()+" "+estudiante.getApellidoPaterno());
            proyecto.setEstudiante(estudiante);
            //estado = Estado.Buscar;
            //establecerEstadoComponentes();
        }
    }//GEN-LAST:event_btnBuscarEstudianteActionPerformed

    private void cboAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAreaActionPerformed

    private void btnBuscarDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDocenteActionPerformed
        JDialog formModal = new JDialog();
        frmBusquedaDocente panelBusqDoc = new frmBusquedaDocente(formModal);
        formModal.add(panelBusqDoc);
        formModal.pack();
        formModal.setResizable(false);
        formModal.setTitle("Formulario de Búsqueda de Docentes");
        formModal.setModal(true);
        formModal.setVisible(true);
        if(panelBusqDoc.getDocenteSeleccionado()!=null){
            docente = panelBusqDoc.getDocenteSeleccionado();
            txtCodigoPUCPDocente.setText(docente.getCodigoPUCP());
            txtNombreCompletoDocente.setText(docente.getNombre() + " " + docente.getApellidoPaterno());
            //txtEstudiante.setText(estudiante.getNombre()+" "+estudiante.getApellidoPaterno());
            //estado = Estado.Buscar;
            //establecerEstadoComponentes();
        }
    }//GEN-LAST:event_btnBuscarDocenteActionPerformed

    private void btnDescargarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescargarArchivoActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG","PNG","jpg","png");
        ofdArchivo.setFileFilter(filtro);
        int resultado = ofdArchivo.showSaveDialog(null);
        if(resultado == JFileChooser.APPROVE_OPTION){
            try{
                File archivoSeleccionado = ofdArchivo.getSelectedFile();
                FileOutputStream fos = new FileOutputStream(archivoSeleccionado);
                fos.write(this.proyecto.getArchivoTemaTesis());
                fos.flush();
                fos.close();
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDescargarArchivoActionPerformed

    public void establecerEstadoComponentes(){
        switch (estado) {
            case Inicial:
                btnNuevo.setEnabled(true);
                btnGuardar.setEnabled(false);
                btnBuscar.setEnabled(true);
                btnCancelar.setEnabled(true);
                txtEstudiante.setEnabled(false);
                btnBuscarEstudiante.setEnabled(false);
                txtTitulo.setEnabled(false);
                txtDescripcion.setEnabled(false);
                cboArea.setEnabled(false);
                btnSubirArchivo.setEnabled(false);
                btnDescargarArchivo.setEnabled(false);
                txtRutaArchivo.setEnabled(false);
                btnSubirFoto.setEnabled(false);
                txtCodigoPUCPDocente.setEnabled(false);
                txtNombreCompletoDocente.setEnabled(false);
                btnBuscarDocente.setEnabled(false);
                btnAgregarJurado.setEnabled(false);
                btnEliminarJurado.setEnabled(false);
                dgvJurados.setEnabled(false);
                break;
            case Nuevo:
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(true);
                btnBuscar.setEnabled(false);
                btnCancelar.setEnabled(true);
                txtEstudiante.setEnabled(true);
                btnBuscarEstudiante.setEnabled(true);
                txtTitulo.setEnabled(true);
                txtDescripcion.setEnabled(true);
                cboArea.setEnabled(true);
                btnSubirArchivo.setEnabled(true);
                btnDescargarArchivo.setEnabled(false);
                txtRutaArchivo.setEnabled(true);
                btnSubirFoto.setEnabled(true);
                txtCodigoPUCPDocente.setEnabled(true);
                txtNombreCompletoDocente.setEnabled(true);
                btnBuscarDocente.setEnabled(true);
                btnAgregarJurado.setEnabled(true);
                btnEliminarJurado.setEnabled(true);
                dgvJurados.setEnabled(true);
                break;
            case Guardar:
            case Buscar:
                btnNuevo.setEnabled(false);
                btnGuardar.setEnabled(false);
                btnBuscar.setEnabled(false);
                btnCancelar.setEnabled(true);
                txtEstudiante.setEnabled(true);
                btnBuscarEstudiante.setEnabled(false);
                txtTitulo.setEnabled(false);
                txtDescripcion.setEnabled(false);
                cboArea.setEnabled(false);
                btnSubirArchivo.setEnabled(false);
                btnDescargarArchivo.setEnabled(true);
                txtRutaArchivo.setEnabled(true);
                btnSubirFoto.setEnabled(false);
                txtCodigoPUCPDocente.setEnabled(false);
                txtNombreCompletoDocente.setEnabled(false);
                btnBuscarDocente.setEnabled(false);
                btnAgregarJurado.setEnabled(false);
                btnEliminarJurado.setEnabled(false);
                dgvJurados.setEnabled(true);
                break;
            }
        }
    
    public void colocarIconos(){
        URL iconUrl = this.getClass().getResource("/pe/edu/pucp/projectsoft/img/nuevo.png");
        Image img = new ImageIcon(iconUrl).getImage();
        Image newimg = img.getScaledInstance(15, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnNuevo.setIcon(new ImageIcon(newimg));
        btnNuevo.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/projectsoft/img/guardar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnGuardar.setIcon(new ImageIcon(newimg));
        btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/projectsoft/img/buscar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnBuscar.setIcon(new ImageIcon(newimg));
        btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/projectsoft/img/cancelar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnCancelar.setIcon(new ImageIcon(newimg));
        btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarJurado;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarDocente;
    private javax.swing.JButton btnBuscarEstudiante;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDescargarArchivo;
    private javax.swing.JButton btnEliminarJurado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<String> cboArea;
    private javax.swing.JTable dgvJurados;
    private javax.swing.JScrollPane jspDescripcion;
    private javax.swing.JScrollPane jspJurados;
    private javax.swing.JScrollPane jspTitulo;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblArchivoTemaTesis;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCodigoPUCPDocente;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblNombreCompletoDocente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JFileChooser ofdArchivo;
    private javax.swing.JFileChooser ofdFoto;
    private javax.swing.JLabel pbFoto;
    private javax.swing.JTabbedPane tcProyecto;
    private javax.swing.JPanel tpDatosGenerales;
    private javax.swing.JPanel tpJurados;
    private javax.swing.JTextField txtCodigoPUCPDocente;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtEstudiante;
    private javax.swing.JTextField txtNombreCompletoDocente;
    private javax.swing.JTextField txtRutaArchivo;
    private javax.swing.JTextPane txtTitulo;
    // End of variables declaration//GEN-END:variables
}
