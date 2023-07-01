package pe.edu.pucp.edusoftlp2.main;

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
        
        JFrame frameGestionCursos = new JFrame();
        frmGestionCursos panelGestionCursos = new frmGestionCursos();
        frameGestionCursos.add(panelGestionCursos);
        frameGestionCursos.pack();
        frameGestionCursos.setFocusable(true);
        frameGestionCursos.setResizable(false);
        frameGestionCursos.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frameGestionCursos.setVisible(true);
    }
}
