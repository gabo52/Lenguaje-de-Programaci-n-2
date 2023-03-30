import	java.util.ArrayList;

class InstitucionEducativa{
	//Atributos
	private int idInstitucionEducativa;
	private String nombre;
	private String RUC;
	private ArrayList<Sede> sedes;



	//Constructos
	public InstitucionEducativa(){}
	public InstitucionEducativa(int idInstitucionEducativa,
		String nombre, String RUC){
		this.idInstitucionEducativa=idInstitucionEducativa;
		this.nombre = nombre;
		this.RUC = RUC;
	}	

	//Getters y setters
	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	//Para el lab1 solo declara los getters y setters q se vayan a usar
	public ArrayList<Sede>getSedes(){
		return sedes;
	}

	public void setSedes(ArrayList<Sede> sedes){
		this.sedes=sedes;
	}
}