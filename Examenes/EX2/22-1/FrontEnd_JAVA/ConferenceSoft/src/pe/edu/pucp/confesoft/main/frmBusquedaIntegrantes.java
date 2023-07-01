package pe.edu.pucp.confesoft.main;

import java.awt.Font;
import javax.swing.JDialog;

public class frmBusquedaIntegrantes extends javax.swing.JPanel {
    private JDialog dialogo;
    public frmBusquedaIntegrantes(JDialog dialogo) {
        initComponents();
        this.dialogo = dialogo;
        tblIntegrantes.getTableHeader().setFont(new Font("Microsoft Sans Serif", 1, 11));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbMenu = new javax.swing.JToolBar();
        lblTipoIntegrante = new javax.swing.JLabel();
        rbTodos = new javax.swing.JRadioButton();
        rbDocentes = new javax.swing.JRadioButton();
        rbEgresados = new javax.swing.JRadioButton();
        rbAlumnos = new javax.swing.JRadioButton();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jspIntegrantes = new javax.swing.JScrollPane();
        tblIntegrantes = new javax.swing.JTable();

        jtbMenu.setBackground(new java.awt.Color(255, 204, 204));
        jtbMenu.setFloatable(false);
        jtbMenu.setRollover(true);

        lblTipoIntegrante.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblTipoIntegrante.setText("Tipo de Integrante:");

        rbTodos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbTodos.setText("Todos");

        rbDocentes.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbDocentes.setText("Docentes");

        rbEgresados.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbEgresados.setText("Egresados");

        rbAlumnos.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        rbAlumnos.setText("Alumnos");

        lblNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        lblNombre.setText("Ingrese el nombre del integrante:");

        txtNombre.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnBuscar.setText("Buscar");

        btnSeleccionar.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        btnSeleccionar.setText("Seleccionar");

        tblIntegrantes.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 11)); // NOI18N
        tblIntegrantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código PUCP", "Nombre Completo", "Tipo Integrante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jspIntegrantes.setViewportView(tblIntegrantes);
        if (tblIntegrantes.getColumnModel().getColumnCount() > 0) {
            tblIntegrantes.getColumnModel().getColumn(0).setResizable(false);
            tblIntegrantes.getColumnModel().getColumn(0).setPreferredWidth(120);
            tblIntegrantes.getColumnModel().getColumn(1).setResizable(false);
            tblIntegrantes.getColumnModel().getColumn(1).setPreferredWidth(300);
            tblIntegrantes.getColumnModel().getColumn(2).setResizable(false);
            tblIntegrantes.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspIntegrantes)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipoIntegrante)
                        .addGap(18, 18, 18)
                        .addComponent(rbTodos)
                        .addGap(18, 18, 18)
                        .addComponent(rbDocentes)
                        .addGap(18, 18, 18)
                        .addComponent(rbEgresados)
                        .addGap(18, 18, 18)
                        .addComponent(rbAlumnos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jtbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoIntegrante)
                    .addComponent(rbTodos)
                    .addComponent(rbDocentes)
                    .addComponent(rbEgresados)
                    .addComponent(rbAlumnos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnSeleccionar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jspIntegrantes, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JScrollPane jspIntegrantes;
    private javax.swing.JToolBar jtbMenu;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTipoIntegrante;
    private javax.swing.JRadioButton rbAlumnos;
    private javax.swing.JRadioButton rbDocentes;
    private javax.swing.JRadioButton rbEgresados;
    private javax.swing.JRadioButton rbTodos;
    private javax.swing.JTable tblIntegrantes;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
