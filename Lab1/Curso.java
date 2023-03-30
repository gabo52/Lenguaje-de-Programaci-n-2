import java.util.Date;

class Curso extends ProgramaAcademico{
	private Date fechaInicioClases;
	public Curso(String nombre, char modalidad, Date fechaInicioClases){
		super(nombre,modalidad);
		this.fechaInicioClases = fechaInicioClases;
	}

	public void setFecha(Date fechaInicioClases){
		this.fechaInicioClases = fechaInicioClases;
	}

	public Date getFecha(){
		return fechaInicioClases;
	}
}