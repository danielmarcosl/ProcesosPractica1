package ejercicio2;

import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ejercicio2 {

    public static void main(String args[]) 
    {
        try 
        {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter escribir = new BufferedWriter(new FileWriter("C:\\Users\\Alumnot\\Documents\\tokenteclado.txt"));

            System.out.println("La primera fila es: num@num");
            System.out.println("La siguientes: @num@num");
            for (int i = 0; i < 2; i++) 
            {
                if (i == 0) 
                {
                    System.out.println("La primera fila: num@num");
                    System.out.println("A partir de la segunda fila: @num@");
                }
                
                StringTokenizer st = new StringTokenizer(teclado.readLine(), " ");
                while (st.hasMoreTokens()) 
                {
                    escribir.write(st.nextToken());
                    escribir.newLine();
                }
            }
            escribir.close();

            BufferedReader leer = new BufferedReader(new FileReader("C:\\Users\\Alumnot\\Documents\\tokenteclado.txt"));
            String linea;
            while ((linea = leer.readLine()) != null) 
            {
                StringTokenizer st = new StringTokenizer(linea, "@");
            }
        } catch (IOException e) 
        {
            // Si ha habido un error, mostrarlo
            System.out.println("Error: " + e);
            
        }
    }
}

// Añadir al ejercicio anterior un token que separe las palabras que introducimos por teclado.
