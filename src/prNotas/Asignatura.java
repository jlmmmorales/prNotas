package prNotas;

import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Asignatura {
	private String nombre;
		
	public Asignatura(String n){
		nombre = n;
	}
	
	public void leerDatos(String nomFichero) throws IOException, AlumnoException{
		try( Scanner fichero = new Scanner(new File(nomFichero))
		){
			while(fichero.hasNextLine()){
				StringAAlumno(fichero.nextLine());
			}
		}
		
	}
	
	private void StringAAlumno (String linea) throws AlumnoException{
		String nombre = "";
		String dni = "";
		Double nota = 0.0;
		Alumno alumno;
		
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[-]");
			if(sc.hasNext()){
				dni = sc.next(); 
				//System.out.println(dni);
			}
			if(sc.hasNext()){
				nombre = sc.next();
				//System.out.println(nombre);
			}
			if(sc.hasNext()){
				nota = sc.nextDouble();
				//System.out.println(nota);
			}
			if(dni.matches("[0-9]{8}[A-Z]")){
				if(nombre.matches("[a-zA-Z, ]+")){
					alumno = new Alumno(nombre, dni, nota);
					System.out.println(alumno.toString());
				}else{
					System.out.println("Nombre con formato incorrecto "+nombre);
				}
			}else{
				System.out.println("DNI con formato incorrecto "+dni);
			}
		}catch (InputMismatchException e){
			//throw new AlumnoException("ERROR: Se esperaba una nota numérica.");
			System.out.println("Nota no numerica "+linea);
		}
	}
	
	public String toString() {
		return nombre;
	}
}
