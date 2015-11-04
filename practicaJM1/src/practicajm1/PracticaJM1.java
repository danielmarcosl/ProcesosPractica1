package practicajm1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import practicajm1.Metodos;

/**
 *
 * @author Daniel Marcos, Alvaro Gomez
 * @version 1.2 14/10/2015
 */
public class PracticaJM1 {

    // Variable global con el numero de usuarios
    static int nUsuarios = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        // Llamos al metodo para ver los usuarios
        try {
            Metodos.leerUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Llamamos al metodo para contar los usuarios
        try {
            nUsuarios = Metodos.contarUsuarios();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Creamos un array de procesos en ProcessBuilder
        ProcessBuilder[] proceso = new ProcessBuilder[nUsuarios]; // Array de procesos
        // Creamos un array de Process para lanzarlos
        Process[] proc = new Process[nUsuarios];

        // Bucle para crear los 6 procesos, cada uno guardará en un documento el contenido de la carpeta de cada usuario
        try {
            BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuarios.txt"));
            String user = null; // Nombre del usuario
            int count = 0; // Contador para lanzar los procesos

            for (int i = 0; i < nUsuarios; i++) {
                user = leer.readLine();
                if (!(user.indexOf('.') >= 0)) {
                    // Creamos el proceso con el comando para recorrer la carpeta del usuario
                    proceso[count] = new ProcessBuilder("CMD", "/C", "dir /s /b C:\\Users\\Alumnot\\Documents\\Usuarios\\" + user);
                    // Redireccionamos la salida del comando a un fichero de texto con el nombre del usuario
                    proceso[count].redirectOutput(new File("C:\\Users\\Alumnot\\Documents\\Usuarios\\" + user + ".txt"));
                    // Lanzamos los procesos
                    proc[count] = proceso[count].start();
                    //proc[count].waitFor();
                }
            }

            //Esperamos a que acaben los procesos lanzamos
            for (int j = 0; j < nUsuarios; j++) {
                proc[j].waitFor();
            }
            leer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            Metodos.limpiarFicheros();
//        } catch (IOException ex) {
//            Logger.getLogger(PracticaJM1.class.getName()).log(Level.SEVERE, null, ex);
//        }
        // Bucle para imprimir por pantalla el fichero de cada usuario
        try {
            Metodos.mostrarContenido();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
