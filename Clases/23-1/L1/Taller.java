import java.time.LocalTime;
import java.util.Date;
import java.text.SimpleDateFormat;
 class Taller extends ProgramaAcademico{
    private Date fecha;
    private LocalTime horaIni;
    private LocalTime horaFin;

    
    public Taller(String nombre, String clave, char modalidad, double precio, Date fecha, LocalTime horaIni, LocalTime horaFin){
        super(nombre,clave,modalidad,precio);
        this.fecha=fecha;
        this.horaIni=horaIni;
        this.horaFin=horaFin;
    }

    @Override
    public String consultarDatos(){
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        return "TALLER: " + getClave()+" - " + getNombre() + " - S/. " + getPrecio() + " - Fecha: " + 
        sdf.format(fecha);
    }
}