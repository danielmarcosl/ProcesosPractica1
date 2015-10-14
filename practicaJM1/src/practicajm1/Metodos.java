package practicajm1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Daniel Marcos, Alvaro Gomez
 * @version 1.2 14/10/2015
 */
public class Metodos {

    /**
     * Lanza un proceso hijo que recorre la ubicacion donde se encuentran los
     * usuarios y almacena los nombres en un fichero de texto
     */
    public static void leerUsuarios() {

        // Declaramos el proceso con el comando a ejecutar
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "dir /b C:\\Users\\Alumnot\\Documents\\Usuarios"); 

        pb.redirectOutput(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuario.txt")); // Ubicacion de destino del resultado del comando
        pb.redirectError(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\errorusuarios.txt")); // Ubicacion de destino si ocurre algun error

        try {
            pb.start(); // Lanza el proceso
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
