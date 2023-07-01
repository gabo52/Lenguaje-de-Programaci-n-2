package pe.edu.pucp.edusoftlp2.model;
public class Docente {
    private int idDocente;
    private String codigoPUCP;
    private String nombre;
    private String apellidoPaterno;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String maximoGradoAlcanzado;

    public int getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public String getCodigoPUCP() {
        return codigoPUCP;
    }

    public void setCodigoPUCP(String codigoPUCP) {
        this.codigoPUCP = codigoPUCP;
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

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getMaximoGradoAlcanzado() {
        return maximoGradoAlcanzado;
    }

    public void setMaximoGradoAlcanzado(String maximoGradoAlcanzado) {
        this.maximoGradoAlcanzado = maximoGradoAlcanzado;
    }
    
    
}
