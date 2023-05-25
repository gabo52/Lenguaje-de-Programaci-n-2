package pe.edu.pucp.projectsoft.main;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.projectsoft.DAO.DocenteDAO;
import pe.edu.pucp.projectsoft.MySQL.DocenteMySQL;
import pe.edu.pucp.projectsoft.MySQL.EstudianteMySQL;
import pe.edu.pucp.projectsoft.model.Docente;

public class frmBusquedaDocente extends javax.swing.JPanel {
    DocenteDAO daoDocente;
    JDialog dialogo;
    private DefaultTableModel modeloDocentes;
    private ArrayList<Docente> docentes;
    private Docente docenteSeleccionado;
    
    public Docente getDocenteSeleccionado() {
        return docenteSeleccionado;
    }

    public void setDocenteSeleccionado(Docente docenteSeleccionado) {
        this.docenteSeleccionado = docenteSeleccionado;
    }
    

    public frmBusquedaDocente() {
        initComponents();
        dgvDocentes.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
    }
    
    public void completarTabla(){
        modeloDocentes.setRowCount(0);
        Object[] fila = new Object[3];
        for(Docente doc : docentes){
            fila[0] =   doc.getCodigoPUCP();
            fila[1] = doc.getNombre() + " " + doc.getApellidoPaterno();
            fila[2] = doc.getCategoria();
            modeloDocentes.addRow(fila);
        }
    }
    
    public frmBusquedaDocente(JDialog dialogo) {
        initComponents();
        daoDocente = new DocenteMySQL();
        modeloDocentes = (DefaultTableModel) dgvDocentes.getModel();
        dgvDocentes.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
        this.dialogo = dialogo;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMenu = new javax.swing.JToolBar();
        lblNombre = new javax.swing.JLabel();
        txtCodigoNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jspDocentes = new javax.swing.JScrollPane();
        dgvDocentes = new javax.swing.JTable();

        jtbMenu.setBackground(new java.awt.Color(204, 204, 255));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNombre.setText("Ingrese el código PUCP o nombre del docente:");

        txtCodigoNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnSeleccionar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        dgvDocentes.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        dgvDocentes.setModel(new javax.swing.table.DefaultTableModel(
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
        jspDocentes.setViewportView(dgvDocentes);
        if (dgvDocentes.getColumnModel().getColumnCount() > 0) {
            dgvDocentes.getColumnModel().getColumn(0).setResizable(false);
            dgvDocentes.getColumnModel().getColumn(0).setPreferredWidth(130);
            dgvDocentes.getColumnModel().getColumn(1).setResizable(false);
            dgvDocentes.getColumnModel().getColumn(1).setPreferredWidth(330);
            dgvDocentes.getColumnModel().getColumn(2).setResizable(false);
            dgvDocentes.getColumnModel().getColumn(2).setPreferredWidth(160);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspDocentes)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtCodigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspDocentes, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        docentes = daoDocente.listarPorCodigoPUCPNombre(txtCodigoNombre.getText());
        completarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if(dgvDocentes.getSelectedRow() != -1){
            docenteSeleccionado = docentes.get(dgvDocentes.getSelectedRow());
            dialogo.setVisible(false);
        }

    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JTable dgvDocentes;
    private javax.swing.JScrollPane jspDocentes;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCodigoNombre;
    // End of variables declaration//GEN-END:variables
}
