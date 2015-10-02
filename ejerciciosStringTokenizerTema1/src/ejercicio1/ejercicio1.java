package ejercicio1;

import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ejercicio1 
{

    public static void main(String args[]) throws IOException 
    {
        try {
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter escribir = new BufferedWriter(new FileWriter("C:\\Users\\Alumnot\\Documents\\tokenteclado.txt"));

            System.out.println("La primera fila es: num@num");
            System.out.println("La siguientes: @num@num");
            for (int i = 0; i < 2; i++) 
            {
                if (i == 0) 
                {
                    System.out.println("La primera fila: num@num");                    
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
        }
        catch (IOException e) 
        {
        	// Si ha habido un error, mostrarlo
            System.out.println("Error: " + e);
        }
    }
}

/* Crear fichero token por teclado
BFR teclado=new BFR(ISR(System.in)
BFW ESCRIBIR = newBFW(FW("......txt"))
	for (int i=0; i<2; i++){
		sout("La primera fila: num@num");
		sout("La siguientes: @num@num");
	stokenizer st=new st(teclado.readLine(),"@");
		while(st.hashMoreTokens()){
			Escribir.write(st.nextToken());
		}
	}
	es.close();
*/
