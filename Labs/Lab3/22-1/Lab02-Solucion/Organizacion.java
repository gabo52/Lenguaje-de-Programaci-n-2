public class Organizacion extends Colaborador{
    private String RUC;
    private String razonSocial;
    
    public Organizacion(String RUC, String razonSocial, String telefono, String direccion){
        super(telefono, direccion);
        this.RUC = RUC;
        this.razonSocial = razonSocial;
    }

    @Override
    public String consultarDatos() {
        return "Organizacion: " + RUC + " - " + razonSocial;
    }

}
