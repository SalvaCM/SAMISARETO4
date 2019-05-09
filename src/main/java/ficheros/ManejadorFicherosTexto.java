package ficheros;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

        String ruta = "C:\\SAMISAreservas\\reserva"+n+".txt";
        try {
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

}
