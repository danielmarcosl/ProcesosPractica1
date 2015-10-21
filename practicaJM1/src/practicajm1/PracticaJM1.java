package practicajm1;

import java.io.InterruptedIOException;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import practicajm1.Metodos;

/**
 *
 * @author Daniel Marcos, Alvaro Gomez
 * @version 1.2 14/10/2015
 */
public class PracticaJM1 {

    // Variable global con el numero de usuarios
    static int nUsuarios;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        // Llamos al metodo para ver los uusarios
        Metodos.leerUsuarios();

        // Creamos un array de procesos
        ProcessBuilder[] proceso = new ProcessBuilder[nUsuarios]; // Array de procesos
        Process p[] = null;

        // Bucle para crear los 6 procesos, cada uno guardará en un documento el contenido de la carpeta de cada usuario
        try {
            BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuarios.txt"));
            String user = null;
            int count = 0;

            while ((user = leer.readLine()) != null) {
                p[count] = Metodos.leerContenidoUsuarios(user, proceso[count]).start();
                count++;
            }
            leer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        // Bucle para esperar que acaben los 6 procesos creados
        for (int i = 0; i < nUsuarios; i++) {
            Metodos.esperarProcesos(p[i]);
        }

        // Bucle para imprimir por pantalla el fichero de cada usuario
        for (int j = 0; j < nUsuarios; j++) {
            try {
                BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuario" + (j + 1) + ".txt"));
                String linea = null;

                System.out.println("El Usuario" + (j + 1) + " contiene en su carpeta los siguientes archivos:");
                while ((linea = leer.readLine()) != null) {
                    System.out.println(linea);
                }
                leer.close();
            } catch (IOException e) {
                System.out.println("Error: " + e);
            }
        }
    }
}
