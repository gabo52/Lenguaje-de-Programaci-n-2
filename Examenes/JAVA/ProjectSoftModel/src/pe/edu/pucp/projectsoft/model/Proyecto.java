package pe.edu.pucp.projectsoft.model;
import java.util.ArrayList;
public class Proyecto {
    private int idProyecto;
    private Area area;
    private Estudiante estudiante;
    private ArrayList<Docente> jurados;
    private String titulo;
    private String descripcion;
    private byte[] foto;
    private byte[] archivoTemaTesis;
    private boolean activo;

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<Docente> getJurados() {
        return jurados;
    }

    public void setJurados(ArrayList<Docente> jurados) {
        this.jurados = jurados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getArchivoTemaTesis() {
        return archivoTemaTesis;
    }

    public void setArchivoTemaTesis(byte[] archivoTemaTesis) {
        this.archivoTemaTesis = archivoTemaTesis;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}