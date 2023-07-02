package pe.edu.pucp.confesoft.model;

import java.io.Serializable;

public class TipoIntegrante implements Serializable{
    private int idTipoIntegrante;
    private String descripcion;

    public int getIdTipoIntegrante() {
        return idTipoIntegrante;
    }

    public void setIdTipoIntegrante(int idTipoIntegrante) {
        this.idTipoIntegrante = idTipoIntegrante;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}