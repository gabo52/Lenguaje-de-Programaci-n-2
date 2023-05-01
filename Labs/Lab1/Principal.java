import java.text.SimpleDateFormat;
import java.util.ArrayList;

class Principal{
	public static void main(String[] args)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		InstitucionEducativa iel = new InstitucionEducativa();
		InstitucionEducativa ie2 = 
		new InstitucionEducativa(1,"COLEGIO LOS BACKYARDIGANS","1234562");


		System.out.println(ie2.getNombre());
		InstitucionEducativa ie3 = ie2;
		ie3.setNombre("COLEGIO PRUEBA");
		System.out.println(ie2.getNombre());
		variable = "COLEGIO JUAN XX";
		System.out.println(ie2.getNombre());


		//Llama al garbage collector
		System.gc();

		Curso curso = new Curso("LP2",'P',sdf.parse("24-03-2023"));
		System.out.println(curso.getFechaInicioClases());
		System.out.println("Impresion de prueba....");

		Sede sede1 = new Sede("SEDE SAN MIGUEL", "Av. Universitaria 2023");
		Sede sede2 = new Sede("SEDE PUEBLO LIBRE", "Av. Los Tulipanes 4232");

		ie2.setSedes(new ArrayList<>());
		ie2.getSedes().add(sede1);
		ie2.getSedes().add(sede2);


	}
}