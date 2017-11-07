import java.io.IOException;

import prNotas.AlumnoException;
import prNotas.Asignatura;

public class TestNotas {
    
    public static void main(String[] args) {
        Asignatura algebra = new Asignatura("Algebra");
    
        System.out.println("\n\n Lectura de fichero");
        try {
            algebra.leerDatos("datosAlumnos.txt");
        } catch (IOException e) {
            System.out.println("Fichero no existe " + e.getMessage());
        } catch (AlumnoException e){
        	System.out.println("Error al crear alumno: "+ e.getMessage());
        }
        
        System.out.println(algebra);
    }
}
