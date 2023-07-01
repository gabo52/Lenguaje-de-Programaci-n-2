package pe.edu.pucp.edusoftlp2.model;
public class DocenteExtranjero extends Docente{
    private Filiacion filiacion;
    private boolean dominaEspanhol;
    private boolean dominaIngles;
    private boolean gradoRevalidadoSUNEDU;
    private boolean activo;

    public Filiacion getFiliacion() {
        return filiacion;
    }

    public void setFiliacion(Filiacion filiacion) {
        this.filiacion = filiacion;
    }

    public boolean isDominaEspanhol() {
        return dominaEspanhol;
    }

    public void setDominaEspanhol(boolean dominaEspanhol) {
        this.dominaEspanhol = dominaEspanhol;
    }

    public boolean isDominaIngles() {
        return dominaIngles;
    }

    public void setDominaIngles(boolean dominaIngles) {
        this.dominaIngles = dominaIngles;
    }

    public boolean isGradoRevalidadoSUNEDU() {
        return gradoRevalidadoSUNEDU;
    }

    public void setGradoRevalidadoSUNEDU(boolean gradoRevalidadoSUNEDU) {
        this.gradoRevalidadoSUNEDU = gradoRevalidadoSUNEDU;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
}
