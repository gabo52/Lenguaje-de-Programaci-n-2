package pe.edu.pucp.edusoftlp2.model;
import java.util.ArrayList;
public class Curso {
    private int idCurso;
    private Especialidad especialidad;
    private Modalidad modalidad;
    private ArrayList<Docente> docentes;
    private String nombre;
    private String clave;
    private String semestre;
    private boolean reqComputadora;
    private boolean reqDispMovil;
    private boolean reqDispEspecial;
    private String sumilla;
    private byte[] foto;
    private byte[] silabo;

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Modalidad getModalidad() {
        return modalidad;
    }

    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }

    public ArrayList<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(ArrayList<Docente> docentes) {
        this.docentes = docentes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public boolean isReqComputadora() {
        return reqComputadora;
    }

    public void setReqComputadora(boolean reqComputadora) {
        this.reqComputadora = reqComputadora;
    }

    public boolean isReqDispMovil() {
        return reqDispMovil;
    }

    public void setReqDispMovil(boolean reqDispMovil) {
        this.reqDispMovil = reqDispMovil;
    }

    public boolean isReqDispEspecial() {
        return reqDispEspecial;
    }

    public void setReqDispEspecial(boolean reqDispEspecial) {
        this.reqDispEspecial = reqDispEspecial;
    }

    public String getSumilla() {
        return sumilla;
    }

    public void setSumilla(String sumilla) {
        this.sumilla = sumilla;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getSilabo() {
        return silabo;
    }

    public void setSilabo(byte[] silabo) {
        this.silabo = silabo;
    }
    
}