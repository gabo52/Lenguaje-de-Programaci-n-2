public class Persona extends Colaborador{
    private String DNI;
    private String nombre;
    private String apellidoPaterno;
    
    public Persona(String DNI, String nombre, String apellidoPaterno, String telefono, String direccion){
        super(telefono,direccion);
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
    }

    @Override
    public String consultarDatos() {
        return "Persona Natural: " + DNI + " - " + nombre + " " + apellidoPaterno;
    }

}
