package pe.edu.pucp.confesoft.model;

import java.io.Serializable;

public class Integrante implements Serializable{
    private int idIntegrante;
    private TipoIntegrante tipoIntegrante;
    private String codigoPUCP;
    private String nombre;
    private String apellidoPaterno;
    private boolean activo;

    public int getIdIntegrante() {
        return idIntegrante;
    }

    public void setIdIntegrante(int idIntegrante) {
        this.idIntegrante = idIntegrante;
    }

    public TipoIntegrante getTipoIntegrante() {
        return tipoIntegrante;
    }

    public void setTipoIntegrante(TipoIntegrante tipoIntegrante) {
        this.tipoIntegrante = tipoIntegrante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCodigoPUCP() {
        return codigoPUCP;
    }

    public void setCodigoPUCP(String codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
    }
    
}