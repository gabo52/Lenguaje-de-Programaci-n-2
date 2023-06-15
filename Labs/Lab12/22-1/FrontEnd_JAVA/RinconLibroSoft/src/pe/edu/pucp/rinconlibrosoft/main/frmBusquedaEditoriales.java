package pe.edu.pucp.rinconlibrosoft.main;

import java.awt.Font;
import javax.swing.JDialog;

public class frmBusquedaEditoriales extends javax.swing.JPanel {

    private JDialog formDialogo;
    
    public frmBusquedaEditoriales(JDialog formDialogo) {
        initComponents();
        this.formDialogo = formDialogo;
        tblEditoriales.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEditorial = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jspEditoriales = new javax.swing.JScrollPane();
        tblEditoriales = new javax.swing.JTable();

        lblEditorial.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblEditorial.setText("Ingrese el nombre de la editorial:");

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");

        btnSeleccionar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSeleccionar.setText("Seleccionar");

        tblEditoriales.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        tblEditoriales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre de la Editorial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspEditoriales.setViewportView(tblEditoriales);
        if (tblEditoriales.getColumnModel().getColumnCount() > 0) {
            tblEditoriales.getColumnModel().getColumn(0).setResizable(false);
            tblEditoriales.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblEditoriales.getColumnModel().getColumn(1).setResizable(false);
            tblEditoriales.getColumnModel().getColumn(1).setPreferredWidth(400);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspEditoriales)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEditorial)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEditorial)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspEditoriales, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jspEditoriales;
    private javax.swing.JLabel lblEditorial;
    private javax.swing.JTable tblEditoriales;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
