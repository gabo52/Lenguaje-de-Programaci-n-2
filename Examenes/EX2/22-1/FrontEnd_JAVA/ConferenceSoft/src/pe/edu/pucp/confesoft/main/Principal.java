package pe.edu.pucp.confesoft.main;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Principal {
    public static void main(String[] args){
        /* look and feel */
        try{
            for(javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
                if(("Windows".equals(info.getName()))){
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        JFrame formGestionEventos = new JFrame();
        frmGestionEventos panelGestCursos = new frmGestionEventos();
        formGestionEventos.add(panelGestCursos);
        formGestionEventos.setLocationRelativeTo(null);
        formGestionEventos.pack();
        formGestionEventos.setTitle("Formulario de Gestión de Eventos");
        formGestionEventos.setFocusable(true);
        formGestionEventos.setResizable(false);
        formGestionEventos.setLocationRelativeTo(null);
        formGestionEventos.setDefaultCloseOperation(EXIT_ON_CLOSE);
        formGestionEventos.setVisible(true);
    }
}
