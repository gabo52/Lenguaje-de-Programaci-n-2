package pe.edu.pucp.edusoftlp2.model;
public class DocentePUCP extends Docente{
    private String categoria;
    private boolean activo;

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
