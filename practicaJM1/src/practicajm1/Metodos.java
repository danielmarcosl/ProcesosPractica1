package practicajm1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

        pb.redirectOutput(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuarios.txt")); // Ubicacion de destino del resultado del comando
        pb.redirectError(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\errorusuarios.txt")); // Ubicacion de destino si ocurre algun error

        try {
            pb.start(); // Lanza el proceso
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Lanza un proceso hijo que recorre la carpeta del usuario y almacena el
     * indice del contenido en un fichero de texto
     *
     * @param nUsuario numero de hilo
     */
    public static void leerContenidoUsuarios(String user, Process p) {

        //Runtime.getRuntime().exec("C:\DoStuff.exe -arg1 -arg2");
        p = new ProcessBuilder("CMD", "/C", "dir /b C:\\Users\\Alumnot\\Documents\\Usuarios\\" + user);

        p.redirectOutput(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\" + user + ".txt"));
        p.redirectError(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\ERROR-" + user + ".txt"));
        try {
            p.start(); // Lanza el proceso
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
