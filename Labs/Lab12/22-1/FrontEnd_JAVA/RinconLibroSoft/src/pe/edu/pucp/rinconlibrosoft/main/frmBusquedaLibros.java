package pe.edu.pucp.rinconlibrosoft.main;

import java.awt.Font;
import javax.swing.JDialog;

public class frmBusquedaLibros extends javax.swing.JPanel {

    private JDialog formDialogo;
    
    public frmBusquedaLibros(JDialog formDialogo) {
        initComponents();
        this.formDialogo = formDialogo;
        tblLibros.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        txtTituloEditorial = new javax.swing.JTextField();
        jspLibros = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(970, 328));

        lblTitulo.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblTitulo.setText("Ingrese el título del libro o nombre de la editorial:");

        txtTituloEditorial.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        tblLibros.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Título", "Editorial", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspLibros.setViewportView(tblLibros);
        if (tblLibros.getColumnModel().getColumnCount() > 0) {
            tblLibros.getColumnModel().getColumn(0).setResizable(false);
            tblLibros.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblLibros.getColumnModel().getColumn(1).setResizable(false);
            tblLibros.getColumnModel().getColumn(1).setPreferredWidth(370);
            tblLibros.getColumnModel().getColumn(2).setResizable(false);
            tblLibros.getColumnModel().getColumn(2).setPreferredWidth(280);
            tblLibros.getColumnModel().getColumn(3).setResizable(false);
            tblLibros.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        btnBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");

        btnSeleccionar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSeleccionar.setText("Seleccionar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspLibros)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTituloEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(txtTituloEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspLibros, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jspLibros;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextField txtTituloEditorial;
    // End of variables declaration//GEN-END:variables
}
