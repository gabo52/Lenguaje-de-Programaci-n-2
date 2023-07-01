package pe.edu.pucp.projectsoft.main;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;
import pe.edu.pucp.projectsoft.DAO.ProyectoDAO;
import pe.edu.pucp.projectsoft.MySQL.ProyectoMySQL;
import pe.edu.pucp.projectsoft.model.Proyecto;

public class frmBusquedaProyectos extends javax.swing.JPanel {
    private JDialog dialogo;
    private ProyectoDAO daoProyecto;
    private ArrayList<Proyecto> proyectos;
    private DefaultTableModel modeloProyectos;
    private Proyecto proyectoSeleccionado;

    public Proyecto getProyectoSeleccionado() {
        return proyectoSeleccionado;
    }

    public void setProyectoSeleccionado(Proyecto proyectoSeleccionado) {
        this.proyectoSeleccionado = proyectoSeleccionado;
    }

    public frmBusquedaProyectos() {
        initComponents();
        dgvProyectos.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
    }
    
    
    public frmBusquedaProyectos(JDialog dialogo) {
        initComponents();
        dgvProyectos.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
        daoProyecto = new ProyectoMySQL();
        modeloProyectos = (DefaultTableModel) dgvProyectos.getModel();
        this.dialogo = dialogo;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMenu = new javax.swing.JToolBar();
        lblTituloCodigoNombre = new javax.swing.JLabel();
        txtTituloCodigoNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jspProyectos = new javax.swing.JScrollPane();
        dgvProyectos = new javax.swing.JTable();

        jtbMenu.setBackground(new java.awt.Color(204, 204, 255));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        lblTituloCodigoNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblTituloCodigoNombre.setText("Ingrese el título o código o nombre del tesista:");

        txtTituloCodigoNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

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

        dgvProyectos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        dgvProyectos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Título del Proyecto", "Tesista"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspProyectos.setViewportView(dgvProyectos);
        if (dgvProyectos.getColumnModel().getColumnCount() > 0) {
            dgvProyectos.getColumnModel().getColumn(0).setResizable(false);
            dgvProyectos.getColumnModel().getColumn(0).setPreferredWidth(440);
            dgvProyectos.getColumnModel().getColumn(1).setResizable(false);
            dgvProyectos.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspProyectos)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTituloCodigoNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTituloCodigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloCodigoNombre)
                    .addComponent(txtTituloCodigoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspProyectos, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void completarTabla(){
        modeloProyectos.setRowCount(0);
        Object[] fila = new Object[3];
        for(Proyecto proy : proyectos){
            fila[0] = proy.getTitulo();
            fila[1] = proy.getEstudiante().getNombre() + " "+ proy.getEstudiante().getApellidoPaterno();
            modeloProyectos.addRow(fila);
        }
    }
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        proyectos = daoProyecto.listarPorTituloCodigoPUCPNombre(txtTituloCodigoNombre.getText());
        completarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        if(dgvProyectos.getSelectedRow() != -1){
            proyectoSeleccionado = proyectos.get(dgvProyectos.getSelectedRow());
            dialogo.setVisible(false);
        }
    }//GEN-LAST:event_btnSeleccionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JTable dgvProyectos;
    private javax.swing.JScrollPane jspProyectos;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblTituloCodigoNombre;
    private javax.swing.JTextField txtTituloCodigoNombre;
    // End of variables declaration//GEN-END:variables
}
