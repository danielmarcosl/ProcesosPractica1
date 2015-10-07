package practicajm1;

import java.io.*;
import java.util.*;

/**
 *
 * @author Daniel Marcos, Alvaro Gomez
 * @version 1
 */
public class PracticaJM1 {

    // Variable global con el numero de usuarios
    static int nUsuarios = 5;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws InterruptedException {

        try {
            // Creamos un array de procesos
            Process[] proceso = new Process[nUsuarios]; // Array de procesos

            // Bucle para crear los 6 procesos, cada uno guardará en un documento el contenido de la carpeta de cada usuario
            for (int i = 0; i < nUsuarios; i++) {
                ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "dir /b C:\\Users\\Alumnot\\Documents\\Usuarios\\Usuario" + (i + 1));

                pb.redirectOutput(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuario" + (i + 1) + ".txt"));
                pb.redirectError(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\error.txt"));
                proceso[i] = pb.start();
            }

            // Bucle para esperar que acaben los 6 procesos creados
            for (int i = 0; i < nUsuarios; i++) {
                int rc = proceso[i].waitFor();
            }

            // Bucle para imprimir por pantalla el fichero de cada usuario
            for (int j = 0; j < nUsuarios; j++) {
                BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuario" + (j + 1) + ".txt"));
                String linea = null;

                System.out.println("El Usuario" + (j + 1) + " contiene en su carpeta los siguientes archivos:");
                while ((linea = leer.readLine()) != null) {
                    System.out.println(linea);
                }

                leer.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
