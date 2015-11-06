package practicajm1;

import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Daniel Marcos, Alvaro Gomez
 * @version 1.3 05/11/2015
 */
public class PracticaJM1 {

    // Variable global con el numero de usuarios
    static int nUsuarios = 0;
    // Ruta donde esta ubicada la carpeta que contiene los usuarios
    static String ruta = "C:\\Users\\Alumnot\\Documents\\Usuarios\\";
    // ArrayList que contendra los nombres de usuario
    static ArrayList<String> nombreUsuarios = new ArrayList<String>();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException, InterruptedException {

        // Almacenamos los nombres de las carpetas de usuario en un fichero de texto
        Metodos.leerUsuarios(ruta);

        // Almacenamos los nombres de usuario en un ArrayList
        Metodos.cogerNombres(ruta, nombreUsuarios);

        // Contamos los usuarios
        nUsuarios = nombreUsuarios.size();

        // Creamos un array de Process
        ProcessBuilder[] pb = new ProcessBuilder[nUsuarios];
        Process[] p = new Process[nUsuarios];

        // Bucle para crear los procesos
        // Cada proceso creara un documento con el contenido de cada carpeta de usuario
        for (int i = 0; i < nUsuarios; i++) {
            pb[i] = new ProcessBuilder("CMD", "/C", "dir /s /b " + ruta + nombreUsuarios.get(i));
            pb[i].redirectOutput(new File(ruta + nombreUsuarios.get(i) + ".txt"));
            p[i] = pb[i].start();
        }

        // Esperamos a que acaben los procesos
        for (int i = 0; i < nUsuarios; i++) {
            p[i].waitFor();
        }

        // Imprimimos por pantalla el documento de cada usuario
        Metodos.mostrarContenido(ruta,nUsuarios,nombreUsuarios);
    }
}
