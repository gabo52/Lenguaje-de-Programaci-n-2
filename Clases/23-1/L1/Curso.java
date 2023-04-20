import java.time.LocalTime;
import java.util.Date;
class Curso extends ProgramaAcademico{
    private int cantHorPorSem;
    private float creditos;
    private Date fechaIni;
    private Date fechaFin;
    private LocalTime horaIniClase;
    private LocalTime horaFinClase;
    private DiaSemana diaDictado;

    public Curso(String nombre, String clave, char modalidad, double precio,int cantHorPorSem, float creditos, 
    Date fechaIni, Date fechaFin,DiaSemana diaDictado, LocalTime horaIniClase, LocalTime horaFinClase){
        super(nombre,clave,modalidad,precio);
        this.cantHorPorSem=cantHorPorSem;
        this.creditos=creditos;
        this.fechaIni=fechaIni;
        this.fechaFin=fechaFin;
        this.horaIniClase=horaIniClase;
        this.horaFinClase=horaFinClase;
        this.diaDictado=diaDictado;
    }
    @Override
    public String consultarDatos(){
        return "CURSO: " + getClave()+" - " + getNombre() + " - S/. " + getPrecio() + " - CRED: "+creditos;
    }
}