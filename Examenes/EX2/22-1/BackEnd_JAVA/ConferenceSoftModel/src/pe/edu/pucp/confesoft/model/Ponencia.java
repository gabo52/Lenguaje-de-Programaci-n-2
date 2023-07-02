package pe.edu.pucp.confesoft.model;
import java.io.Serializable;
import java.sql.Time;
public class Ponencia implements Serializable{
    private int idPonencia;
    private Integrante ponente;
    private String titulo;
    private Time horaInicio;
    private Time horaFin;
    private boolean activo;

    public int getIdPonencia() {
        return idPonencia;
    }

    public void setIdPonencia(int idPonencia) {
        this.idPonencia = idPonencia;
    }

    public Integrante getPonente() {
        return ponente;
    }

    public void setPonente(Integrante ponente) {
        this.ponente = ponente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}