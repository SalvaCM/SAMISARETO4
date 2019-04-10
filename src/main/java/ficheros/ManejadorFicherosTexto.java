package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManejadorFicherosTexto {
    
    // Atributos
    private File fichero;    
    private FileReader fileReader;
    private BufferedReader bufferedReader;
    private FileWriter fileWriter;
    private BufferedWriter bufferedWriter;
    
    // Constructor por defecto
    /**
     * Crea una instancia de ManejadorFicherosTexto
     */
    public ManejadorFicherosTexto() {
	
    }
    
    
    
    
    /**
     * Metodo que escribe en un fichero de texto
     * @param rutaFichero - La ruta del fichero que se va a escribir. Si no existe el fichero se crear�
     * @param lineas - array de String con las lineas a escribir
     * @throws IOException
     */
    
    public void archivoTexto(String reserva) {
    	int n=(int) (Math.random() * 1000) + 1;
    try {
        String ruta = "C:\\worspace\\reserva"+n+".txt";
        //String[] contenido =  {"HOLA","SARA"};
        File file = new File(ruta);
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        
        	bw.write(reserva+"\n");
    	
        
        bw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
/*--------------------------------------------------------------------------------------------------------------------------------*/    
    /* 
    public static void main(String[] args) {
	ManejadorFicheros fich = new ManejadorFicheros();
	String[] pruebaEscribir = new String[2];
	pruebaEscribir[0] = "Linea 1";
	pruebaEscribir[1] = "Linea 2";
	try {
	    fich.escribirFichero("prueba.txt", pruebaEscribir);
	    fich.leerFichero("prueba.txt");
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }*/
}
