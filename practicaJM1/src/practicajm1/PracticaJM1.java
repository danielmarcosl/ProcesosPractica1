package practicajm1;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

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
        // Creamos un array de procesos
        ProcessBuilder[] proceso = new ProcessBuilder[nUsuarios]; // Array de procesos

        // Bucle para crear los 6 procesos, cada uno guardará en un documento el contenido de la carpeta de cada usuario
        try {
            BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alumnot\\Documents\\Usuarios\\usuarios.txt"));
            String user = null;
            int count = 0;
            
            for (int i = 0; i < nUsuarios; i++) {
                user = leer.readLine();
                if (!(user.indexOf('.') >= 0)) {
                    Metodos.leerContenidoUsuarios(user, proceso[count]);
                }
            }
            leer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Bucle para imprimir por pantalla el fichero de cada usuario
        try {
            Metodos.mostrarContenido();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
