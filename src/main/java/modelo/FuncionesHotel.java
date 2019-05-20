package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import conexion.ConexionBD;
import conexion.ConsultaBD;


public class FuncionesHotel {
	
	public Hotel hotel;
	public HabitacionHotel habitacion;
	public Cama cama;
	
	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();
	
	/**
	 * Lee de la base de datos todos los hoteles que no estan en la tabla reservas
	 * @return ArrayList de los hoteles no reservados
	 * @throws SQLException
	 */
	public ArrayList<Hotel> leerHoteles() throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";	String ubicacion="";	int nEstrellas=0; int codhotel;
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		
		// Inicio
		
		
		String query="select cod_hotel,nombre,ubicacion, nestrellas from hotel   where cod_hotel not in (select reservas_hotel.cod_hotel from reservas_hotel);";
	

					ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
					while(rs.next()) {
							hotel=new Hotel();
							codhotel = rs.getInt("cod_hotel");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							nEstrellas = rs.getInt("nestrellas");
							hotel.setCod_hotel(codhotel);
							hotel.setNombre(nombre);
							hotel.setUbicacion(ubicacion);
							hotel.setnEstrellas(nEstrellas);
							hoteles.add(hotel);
						}
				
		
					ArrayList<Hotel> hotelesOrden=leerHotelesOrden();
					hotelesOrden.addAll(hoteles);
		return hotelesOrden;

	}
	/**
 	 * Lee de la base de datos todos los hoteles en orden
 	 * @return Arraylist de todos los hoteles
 	 * @throws SQLException
 	 */
	public ArrayList<Hotel> leerHotelesOrden() throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";	String ubicacion="";	int nEstrellas=0; int codhotel;
		ArrayList<Hotel> hoteles2 =new ArrayList<Hotel>();
		
		// Inicio
		
		String query="select h.cod_hotel,h.nombre,h.ubicacion, h.nestrellas from hotel h ,reservas_hotel r where h.cod_hotel=r.cod_hotel  group by r.cod_hotel order by count(r.cod_hotel) desc; ";
		
	

					ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
					while(rs.next()) {
							hotel=new Hotel();
							codhotel = rs.getInt("cod_hotel");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							nEstrellas = rs.getInt("nestrellas");
							hotel.setCod_hotel(codhotel);
							hotel.setNombre(nombre);
							hotel.setUbicacion(ubicacion);
							hotel.setnEstrellas(nEstrellas);
							hoteles2.add(hotel);
						}
				
		
		
		return hoteles2;

	}
	
	/**
 	 * Busca en la base de datos todos los hoteles con la ubicacion que desee
 	 * @param ubicacion
 	 * @return ArrayList de todos los hoteles con esa ubicacion
 	 * @throws SQLException
 	 */
	public ArrayList<Hotel> buscarUbicacion(String ubicacion) throws SQLException{
		String nombre=""; int codhotel;int nEstrellas ;
		ArrayList<Hotel> hoteles =new ArrayList<Hotel>();
		
		
		String query="select cod_hotel,nombre,ubicacion,nestrellas from hotel where ubicacion='"+ubicacion+"';";
		
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		while(rs.next()) {
				codhotel=rs.getInt("cod_hotel");
				nombre = rs.getString("nombre");
				ubicacion = rs.getString("ubicacion");
				nEstrellas = rs.getInt("nestrellas");
				hotel=new Hotel();
				hotel.setCod_hotel(codhotel);
				hotel.setNombre(nombre);
				hotel.setUbicacion(ubicacion);
				hotel.setnEstrellas(nEstrellas);
				hoteles.add(hotel);
		}
		return hoteles;
	}
	/**
	 * Muestra todos los hoteles que tienen ese numero de estrellas
	 * @param estrellas
	 * @return ArrayList de los hoteles con las estrellas seleccionadas
	 * @throws SQLException
	 */
	public ArrayList<Hotel> filtrarPorEstrellas(int estrellas) throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String nombre="";	String ubicacion="";	int nEstrellas=0; int codhotel;
		ArrayList<Hotel> hoteles2 =new ArrayList<Hotel>();
		
		// Inicio
		
		String query="select cod_hotel,nombre,ubicacion, nestrellas from hotel  where nestrellas='"+estrellas+"'; ";
		
	

					ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
					while(rs.next()) {
							hotel=new Hotel();
							codhotel = rs.getInt("cod_hotel");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							nEstrellas = rs.getInt("nestrellas");
							hotel.setCod_hotel(codhotel);
							hotel.setNombre(nombre);
							hotel.setUbicacion(ubicacion);
							hotel.setnEstrellas(nEstrellas);
							hoteles2.add(hotel);
						}
				
		
		
		return hoteles2;

	}
	/**
	 * Metodo para buscar los las habitaciones de un hotel determinado
	 * @param codhotel
	 * @return devuelve un array con todos las habitaciones
	 * @throws SQLException
	 */
	public ArrayList<HabitacionHotel> leerHabitaciones(int codhotel) throws SQLException{
		String tipo="";
		float precio=0;
		int codHabitacion;
		int tamano;
		ArrayList<HabitacionHotel> habitaciones =new ArrayList<HabitacionHotel>();
		
		String query="select cod_habitacion,tipo,precio,tamano from habitacion_Hotel where cod_hotel='"+codhotel+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_habitacion");
			tipo = rs.getString("tipo");
			precio = rs.getFloat("precio");
			tamano=rs.getInt("tamano");
			habitacion =new HabitacionHotel();
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setPrecio(precio);
			habitacion.setTamano(tamano);
			habitaciones.add(habitacion);
		}
		return habitaciones;
	}
	/**
	 * Lee de la base de datos los tipos de cama que tienen esa habitacion
	 * @param codHabitacion
	 * @return ArrayList de las camas que tiene esa habitacion
	 * @throws SQLException
	 */
	public ArrayList<Cama> leerCamas(int codHabitacion) throws SQLException{
		String tipocama="";
		int npersonas;
		ArrayList<Cama> camas =new ArrayList<Cama>();
		
		String query="select a.cod_tipocama,a.tipocama,a.n_personas from cama a,habitacion_cama h where a.cod_tipocama=h.COD_TIPOCAMA and h.cod_habitacion='"+codHabitacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		while(rs.next()) {
			tipocama = rs.getString("tipocama");
			npersonas=rs.getInt("n_personas");
			cama =new Cama();
			cama.setTipoCama(tipocama);
			cama.setnPersonas(npersonas);
			camas.add(cama);
		}
		return camas;
	}
		
	/**
	 * Se mete en el array de reservas la habitacion escogida
	 * @param cod_habitacion
	 * @return la habitacion escogida
	 * @throws SQLException
	 */
	public HabitacionHotel reservarHabitacion(int cod_habitacion) throws SQLException{
		String tipo="";
		int tamano;
		float precio=0;
		int codHabitacion;
		habitacion =new HabitacionHotel();
		String query="select cod_habitacion,tipo,precio,tamano from habitacion_Hotel where cod_habitacion='"+cod_habitacion+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_habitacion");
			tipo = rs.getString("tipo");
			precio = rs.getFloat("precio");
			tamano=rs.getInt("tamano");
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setTamano(tamano);
			habitacion.setPrecio(precio);
		}
		return habitacion;
	}
	/**
 	* Muestra todas las ubicaciones de los hoteles
 	* @return Arraylist de las ubicaciones de los hoteles
 	* @throws SQLException
 	*/
	public ArrayList<String> mostrarUbicaciones () throws SQLException{ 
    	//Declaracion e incializacion de variables
		
		String ubicacion="";
		ArrayList<String> ubicaciones =new ArrayList<String>();
		String query="select distinct  ubicacion from hotel;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				
				
				ubicacion = rs.getString("ubicacion");
				
				ubicaciones.add(ubicacion);
			}
			
		return ubicaciones;

	}
	/**
	 * Compara con las fechas para saber si esa habitacion esta ya reservada en esas fechas
	 * @param cod
	 * @param fida
	 * @param fvuelta
	 * @return true, si esta ya reservada y false, si no esta reservada
	 * @throws SQLException
	 */
	public boolean habitaOcupada (int cod, Date fida,Date fvuelta) throws SQLException{ 
    	//Declaracion e incializacion de variables
	
		boolean r = false;

		Date fechaEntrada = null;
		Date fechaSalida = null;

		String query="select fechaEntrada,fechaSalida from reservas_hotel where cod_habitacion='"+cod+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	
		while(rs.next()) {
				fechaEntrada = rs.getDate("fechaEntrada");
				fechaSalida= rs.getDate("fechaSalida");			
			}
		System.out.println("Resultado de la select"+fechaEntrada);
	 if(fechaSalida==null || fechaEntrada==null) {
			r=false;
		}else {
			if((fvuelta.compareTo(fechaEntrada)>=0 && fida.compareTo(fechaSalida)<=0)) {
				//JOptionPane.showMessageDialog(miVentana, "Ocupado entre fechas  "+f1+"  y  "+f2+"", "Atencion!", JOptionPane.WARNING_MESSAGE);
				r=true;
			}
		}
		
       return r;
	}


	
}
