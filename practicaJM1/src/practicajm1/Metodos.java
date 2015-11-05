package practicajm1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
    public static void leerUsuarios(String ruta) throws InterruptedException, IOException {

        // Declaramos el proceso con el comando a ejecutar
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "dir /b " + ruta);

        pb.redirectOutput(new File(ruta + "usuarios.txt")); // Ubicacion de destino del resultado del comando

        Process p = pb.start(); // Lanza el proceso
        p.waitFor(); // Espera a que acabe
    }

    /**
     * Metodo para almacenar en un ArrayList los nombres de usuario
     *
     * @param ruta Directorio donde estan las carpetas de usuario
     * @param nombres ArrayList donde se almacenaran los nombres de usuario
     * @throws IOException
     */
    public static void cogerNombres(String ruta, ArrayList<String> nombres) throws IOException {
        // Abrimos el documento con los nombres de usuario
        BufferedReader leer = new BufferedReader(new FileReader(ruta + "usuarios.txt"));
        // Variable donde se almacenara cada linea del fichero
        String linea;

        // Recorremos el documento
        while ((linea = leer.readLine()) != null) {
            // Filtramos el contenido para solo sacar carpetas
            if (!(linea.indexOf('.') >= 0)) {
                // Agregamos al ArrayList el nombre de usuario
                nombres.add(linea);
            }
        }
        // Cerramos el documento
        leer.close();
    }

    /**
     * Metodo para leer el contenido de los ficheros de cada usuario
     *
     * @param ruta Directorio de las carpetas de usuario
     * @param nUsuarios Numero de usuarios
     * @param user ArrayList que contiene los nombres de usuario
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void mostrarContenido(String ruta, int nUsuarios, ArrayList<String> user) throws FileNotFoundException, IOException {

        for (int i = 0; i < nUsuarios; i++) {
            // Abrimos el documento de cada usuario
            BufferedReader carpetaUsuario = new BufferedReader(new FileReader(ruta + user.get(i) + ".txt"));
            // Variable para almacenar cada linea del documento
            String linea;

            System.out.println("El Usuario " + user.get(i) + " contiene en su carpeta los siguientes archivos:");
            // Recorremos el documento
            while ((linea = carpetaUsuario.readLine()) != null) {
                // Imprimimos cada linea
                System.out.println(linea);
            }
            // Cerramos el documento
            carpetaUsuario.close();
        }
    }
}
