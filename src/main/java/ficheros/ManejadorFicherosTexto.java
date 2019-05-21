package ficheros;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import modelo.FuncionesReserva;


public class ManejadorFicherosTexto {
    
    
    // Constructor por defecto
    /**
     * Crea una instancia de ManejadorFicherosTexto
     */
    public ManejadorFicherosTexto() {

    }
    FuncionesReserva funcionesReserva = new FuncionesReserva();
    
    
    
    /**
     * Metodo que escribe en un fichero de texto
     * @param rutaFichero - La ruta del fichero que se va a escribir. Si no existe el fichero se crear�
     * @param lineas - array de String con las lineas a escribir
     * @throws IOException
     */
    
    public void archivoTexto(String reserva) {
    int n =funcionesReserva.buscarNumeroReservaHotel();
   try {
        //String[] contenido =  {"HOLA","SARA"};
        
        String ruta = "C:\\SAMISAreservas\\reserva"+n+".txt";
        File file = new File(ruta);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
       
        // Si el archivo no existe es creado
        if (!file.exists()) {
            file.createNewFile();
            
         }
        
        bw.write(reserva);
        
 
        bw.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
   public  void leerContenido() throws FileNotFoundException, IOException {
  int n =funcionesReserva.buscarNumeroReservaHotel();
  String ruta = "C:\\SAMISAreservas\\reserva"+n+".txt";
       File file = new File(ruta);
        String cadena;
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            System.out.println(cadena);
        }
        b.close();
  }

}
