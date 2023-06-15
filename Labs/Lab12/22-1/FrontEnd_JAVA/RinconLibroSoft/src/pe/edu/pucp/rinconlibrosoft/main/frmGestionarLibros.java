package pe.edu.pucp.rinconlibrosoft.main;

import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmGestionarLibros extends javax.swing.JPanel {

    private File archivoFoto;
    private Estado estado;
    
    public frmGestionarLibros() {
        initComponents();
        colocarIconos();
        tblAutores.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
        estado = Estado.Inicial;
        establecerEstadoComponentes();
        limpiarComponentes();
    }
    
    public void establecerEstadoComponentes(){
        switch(estado)
            {
                case Inicial:
                    btnNuevo.setEnabled(true);
                    btnBuscar.setEnabled(true);
                    btnGuardar.setEnabled(false);
                    btnCancelar.setEnabled(true);
                    gbDatosGenerales.setEnabled(false);
                    for(Component c : gbDatosGenerales.getComponents())
                        c.setEnabled(false);
                    tblAutores.setEnabled(false);
                    break;
                case Modificar:
                case Nuevo:
                    btnNuevo.setEnabled(false);
                    btnBuscar.setEnabled(false);
                    btnGuardar.setEnabled(true);
                    btnCancelar.setEnabled(true);
                    gbDatosGenerales.setEnabled(true);
                    for(Component c : gbDatosGenerales.getComponents())
                        c.setEnabled(true);
                    tblAutores.setEnabled(true);
                    break;
                case Buscar:
                    btnNuevo.setEnabled(false);
                    btnBuscar.setEnabled(false);
                    btnGuardar.setEnabled(false);
                    btnCancelar.setEnabled(true);
                    gbDatosGenerales.setEnabled(false);
                    for(Component c : gbDatosGenerales.getComponents())
                        c.setEnabled(false);
                    tblAutores.setEnabled(false);
                    break;
            }
    }
    
    public void limpiarComponentes(){
        txtIDLibro.setText("");
        txtTitulo.setText("");
        txtNroPaginas.setText("");
        rbEspanhol.setSelected(false);
        rbIngles.setSelected(false);
        txtEditorial.setText("");
        dtpFechaPublicacion.setDate(new Date());
        txtPrecio.setText("");
        pbPortada.setIcon(null);
        archivoFoto = null;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ofdPortada = new javax.swing.JFileChooser();
        GrupoIdioma = new javax.swing.ButtonGroup();
        lblGestionLibros = new javax.swing.JLabel();
        jtbMenu = new javax.swing.JToolBar();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        gbDatosGenerales = new javax.swing.JPanel();
        jspAutores = new javax.swing.JScrollPane();
        tblAutores = new javax.swing.JTable();
        pbPortada = new javax.swing.JLabel();
        btnSubirFoto = new javax.swing.JButton();
        lblAutores = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        btnBuscarAutor = new javax.swing.JButton();
        btnAgregarAutor = new javax.swing.JButton();
        btnEliminarAutor = new javax.swing.JButton();
        lblIDLibro = new javax.swing.JLabel();
        txtIDLibro = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        txtNroPaginas = new javax.swing.JTextField();
        lblNroPaginas = new javax.swing.JLabel();
        lblIdioma = new javax.swing.JLabel();
        rbEspanhol = new javax.swing.JRadioButton();
        rbIngles = new javax.swing.JRadioButton();
        lblEditorial = new javax.swing.JLabel();
        lblFechaPublicacion = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        btnBuscarEditorial = new javax.swing.JButton();
        dtpFechaPublicacion = new com.toedter.calendar.JDateChooser();
        txtPrecio = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(816, 509));

        lblGestionLibros.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 13)); // NOI18N
        lblGestionLibros.setText("Gestión de Libros - El Rincón del Libro");

        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

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

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setFocusable(false);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGuardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jtbMenu.add(btnGuardar);

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

        gbDatosGenerales.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Generales del Libro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft Sans Serif", 1, 11))); // NOI18N

        tblAutores.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        tblAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre Completo", "Nacionalidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspAutores.setViewportView(tblAutores);
        if (tblAutores.getColumnModel().getColumnCount() > 0) {
            tblAutores.getColumnModel().getColumn(0).setResizable(false);
            tblAutores.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblAutores.getColumnModel().getColumn(1).setResizable(false);
            tblAutores.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblAutores.getColumnModel().getColumn(2).setResizable(false);
            tblAutores.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        pbPortada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSubirFoto.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSubirFoto.setText("Subir Portada");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });

        lblAutores.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblAutores.setText("Autor(es) del Libro:");

        txtAutor.setEditable(false);
        txtAutor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnBuscarAutor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscarAutor.setText("...");
        btnBuscarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAutorActionPerformed(evt);
            }
        });

        btnAgregarAutor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnAgregarAutor.setText("+");

        btnEliminarAutor.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnEliminarAutor.setText("-");

        lblIDLibro.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblIDLibro.setText("ID del Libro:");

        txtIDLibro.setEditable(false);
        txtIDLibro.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        txtTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblTitulo.setText("Título del Libro:");

        txtNroPaginas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        lblNroPaginas.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNroPaginas.setText("Número de Páginas:");

        lblIdioma.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblIdioma.setText("Idioma:");

        GrupoIdioma.add(rbEspanhol);
        rbEspanhol.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbEspanhol.setText("Español");

        GrupoIdioma.add(rbIngles);
        rbIngles.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbIngles.setText("Inglés");

        lblEditorial.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblEditorial.setText("Editorial:");

        lblFechaPublicacion.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblFechaPublicacion.setText("Fecha de Publicación:");

        lblPrecio.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblPrecio.setText("Precio:");

        txtEditorial.setEditable(false);

        btnBuscarEditorial.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscarEditorial.setText("...");
        btnBuscarEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarEditorialActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gbDatosGeneralesLayout = new javax.swing.GroupLayout(gbDatosGenerales);
        gbDatosGenerales.setLayout(gbDatosGeneralesLayout);
        gbDatosGeneralesLayout.setHorizontalGroup(
            gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspAutores)
                    .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pbPortada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSubirFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIDLibro)
                            .addComponent(lblTitulo)
                            .addComponent(lblNroPaginas)
                            .addComponent(lblIdioma)
                            .addComponent(lblEditorial)
                            .addComponent(lblFechaPublicacion)
                            .addComponent(lblPrecio))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo)
                            .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                                .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                                        .addComponent(rbEspanhol)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbIngles))
                                    .addComponent(txtNroPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                                        .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnBuscarEditorial))
                                    .addComponent(dtpFechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                        .addComponent(lblAutores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscarAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        gbDatosGeneralesLayout.setVerticalGroup(
            gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnSubirFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pbPortada, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(gbDatosGeneralesLayout.createSequentialGroup()
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtIDLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIDLibro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitulo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNroPaginas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNroPaginas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbEspanhol)
                            .addComponent(rbIngles)
                            .addComponent(lblIdioma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarEditorial)
                            .addComponent(lblEditorial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtpFechaPublicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFechaPublicacion))
                        .addGap(10, 10, 10)
                        .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPrecio))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(gbDatosGeneralesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutores)
                    .addComponent(txtAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAutor)
                    .addComponent(btnAgregarAutor)
                    .addComponent(btnEliminarAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gbDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblGestionLibros)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGestionLibros)
                .addGap(11, 11, 11)
                .addComponent(gbDatosGenerales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFotoActionPerformed
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG","PNG","jpg","png");
        ofdPortada.setFileFilter(filtro);
        int resultado = ofdPortada.showOpenDialog(null);
        if(resultado == JFileChooser.APPROVE_OPTION){
            try{
                archivoFoto = ofdPortada.getSelectedFile();
                Image img = new ImageIcon(archivoFoto.toString()).getImage();
                Image newImg = img.getScaledInstance(pbPortada.getWidth(), pbPortada.getHeight(), java.awt.Image.SCALE_SMOOTH);
                pbPortada.setIcon(new ImageIcon(newImg));
                
            }catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        } 
    }//GEN-LAST:event_btnSubirFotoActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        estado = Estado.Nuevo;
        limpiarComponentes();
        establecerEstadoComponentes();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        estado = Estado.Inicial;
        limpiarComponentes();
        establecerEstadoComponentes();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarEditorialActionPerformed
        JDialog formBusquedaEditoriales = new JDialog();
        frmBusquedaEditoriales panelBusqEditoriales = new frmBusquedaEditoriales(formBusquedaEditoriales);
        formBusquedaEditoriales.add(panelBusqEditoriales);
        formBusquedaEditoriales.pack();
        formBusquedaEditoriales.setModal(true);
        formBusquedaEditoriales.setFocusable(true);
        formBusquedaEditoriales.setTitle("Formulario de Búsqueda de Editoriales");
        formBusquedaEditoriales.setVisible(true);
    }//GEN-LAST:event_btnBuscarEditorialActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        JDialog formBusquedaLibros = new JDialog();
        frmBusquedaLibros panelBusqLibros = new frmBusquedaLibros(formBusquedaLibros);
        formBusquedaLibros.add(panelBusqLibros);
        formBusquedaLibros.pack();
        formBusquedaLibros.setModal(true);
        formBusquedaLibros.setFocusable(true);
        formBusquedaLibros.setTitle("Formulario de Búsqueda de Libros");
        formBusquedaLibros.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAutorActionPerformed
        JDialog formBusquedaAutores = new JDialog();
        frmBusquedaAutores panelBusqAutores = new frmBusquedaAutores(formBusquedaAutores);
        formBusquedaAutores.add(panelBusqAutores);
        formBusquedaAutores.pack();
        formBusquedaAutores.setModal(true);
        formBusquedaAutores.setFocusable(true);
        formBusquedaAutores.setTitle("Formulario de Búsqueda de Autores");
        formBusquedaAutores.setVisible(true);
    }//GEN-LAST:event_btnBuscarAutorActionPerformed

    public void colocarIconos(){
        URL iconUrl = this.getClass().getResource("/pe/edu/pucp/rinconlibrosoft/img/nuevo.png");
        Image img = new ImageIcon(iconUrl).getImage();
        Image newimg = img.getScaledInstance(15, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnNuevo.setIcon(new ImageIcon(newimg));
        btnNuevo.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/rinconlibrosoft/img/guardar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnGuardar.setIcon(new ImageIcon(newimg));
        btnGuardar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/rinconlibrosoft/img/buscar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnBuscar.setIcon(new ImageIcon(newimg));
        btnBuscar.setHorizontalTextPosition(SwingConstants.RIGHT);
        iconUrl = this.getClass().getResource("/pe/edu/pucp/rinconlibrosoft/img/cancelar.png");
        img = new ImageIcon(iconUrl).getImage();
        newimg = img.getScaledInstance(18, 17,  java.awt.Image.SCALE_SMOOTH ) ;
        btnCancelar.setIcon(new ImageIcon(newimg));
        btnCancelar.setHorizontalTextPosition(SwingConstants.RIGHT);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoIdioma;
    private javax.swing.JButton btnAgregarAutor;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarAutor;
    private javax.swing.JButton btnBuscarEditorial;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminarAutor;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSubirFoto;
    private com.toedter.calendar.JDateChooser dtpFechaPublicacion;
    private javax.swing.JPanel gbDatosGenerales;
    private javax.swing.JScrollPane jspAutores;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblAutores;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JLabel lblFechaPublicacion;
    private javax.swing.JLabel lblGestionLibros;
    private javax.swing.JLabel lblIDLibro;
    private javax.swing.JLabel lblIdioma;
    private javax.swing.JLabel lblNroPaginas;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JFileChooser ofdPortada;
    private javax.swing.JLabel pbPortada;
    private javax.swing.JRadioButton rbEspanhol;
    private javax.swing.JRadioButton rbIngles;
    private javax.swing.JTable tblAutores;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtIDLibro;
    private javax.swing.JTextField txtNroPaginas;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
