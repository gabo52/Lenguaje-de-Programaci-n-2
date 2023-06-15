package pe.edu.pucp.rinconlibrosoft.main;

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
        
        JFrame frameGestionLibros = new JFrame();
        frmGestionarLibros panelGestionLibros = new frmGestionarLibros();
        frameGestionLibros.add(panelGestionLibros);
        frameGestionLibros.pack();
        frameGestionLibros.setFocusable(true);
        frameGestionLibros.setResizable(false);
        frameGestionLibros.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameGestionLibros.setVisible(true);
    }
}
