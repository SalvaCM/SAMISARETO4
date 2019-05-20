package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import conexion.ConexionBD;
import conexion.ConsultaBD;

public class FuncionesApartamento {
	
	public Apartamento apartamento;

 	ConexionBD miConexion = new ConexionBD();
	ConsultaBD miConsulta = new ConsultaBD();
	Connection con = miConexion.ConectarBD();

	/**
	 * Lee de la base de datos todos los apartamentos que no estan en la tabla reservas
	 * @return ArrayList de apartamentos no reservados
	 * @throws SQLException
	 */
	
 	public ArrayList<Apartamento> leerApartamento() throws SQLException{ 
    	//Declaracion e incializacion de variables

 		String nombre="";	
		String ubicacion=""; 
		int codapartamento;
		int tamano;
		float precio;
		int piso;

 		ArrayList<Apartamento> apartamentos =new ArrayList<Apartamento>();

 		// Inicio

 		String query="SELECT `COD_APARTAMENTO`, `NOMBRE`, `UBICACION`, `TAMANO`, `PRECIO`, `PISO` FROM apartamento where cod_apartamento NOT IN (select reserva_apartamento.cod_apart from reserva_apartamento)";

 		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	

 		while(rs.next()) {
							apartamento=new Apartamento();

 							codapartamento = rs.getInt("cod_apartamento");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							tamano = rs.getInt("tamano");
							precio = rs.getFloat("precio");
							piso = rs.getInt("piso");
							
 							apartamento.setCod_apartamento(codapartamento);
							apartamento.setNombre(nombre);
							apartamento.setUbicacion(ubicacion);
							apartamento.setTamano(tamano);
							apartamento.setPrecio(precio);
							apartamento.setPiso(piso);

 							apartamentos.add(apartamento);
				}
 		ArrayList<Apartamento> apartamentosOrden=leerApartamentoOrden();
 		apartamentosOrden.addAll(apartamentos);
 		

 		return apartamentosOrden;

 	}

 	
 	/**
 	 * Lee de la base de datos todos los apartamentos en orden
 	 * @return Arraylist de todos los apartamentos
 	 * @throws SQLException
 	 */

 	public ArrayList<Habitacion> leerHabitaciones(int codApart) throws SQLException{
		String tipo="";
		int codHabitacion;
		int tamano;
		ArrayList<Habitacion> habitaciones =new ArrayList<Habitacion>();
		
		String query="select h.cod_habitacion,h.tipo,h.tamano from habitacion h,habitacion_apart hc where hc.cod_apart='"+codApart+"' and hc.cod_habitacion=h.cod_habitacion;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_habitacion");
			tipo = rs.getString("tipo");
			tamano=rs.getInt("tamano");
			Habitacion habitacion =new Habitacion();
			habitacion.setCodHabitacion(codHabitacion);
			habitacion.setTipo(tipo);
			habitacion.setTamano(tamano);
			habitaciones.add(habitacion);
		}
		return habitaciones;
	}

 	public ArrayList<Apartamento> leerApartamentoOrden() throws SQLException{ 
    	//Declaracion e incializacion de variables

 		String nombre="";	
		String ubicacion=""; 
		int codapartamento;
		int tamano;
		float precio;
		int piso;

 		ArrayList<Apartamento> apartamentos =new ArrayList<Apartamento>();

 		// Inicio

 		String query="SELECT a.COD_APARTAMENTO, a.NOMBRE, a.UBICACION,a. TAMANO, a.PRECIO,a.PISO FROM apartamento a, reserva_apartamento r where a.cod_apartamento=r.cod_apart group by r.cod_apart order by count(r.cod_apart) desc;";

 		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	

 		while(rs.next()) {
							apartamento=new Apartamento();

 							codapartamento = rs.getInt("cod_apartamento");
							nombre = rs.getString("nombre");
							ubicacion = rs.getString("ubicacion");
							tamano = rs.getInt("tamano");
							precio = rs.getFloat("precio");
							piso = rs.getInt("piso");
							
 							apartamento.setCod_apartamento(codapartamento);
							apartamento.setNombre(nombre);
							apartamento.setUbicacion(ubicacion);
							apartamento.setTamano(tamano);
							apartamento.setPrecio(precio);
							apartamento.setPiso(piso);

 							apartamentos.add(apartamento);
				}

 		return apartamentos;

 	}
 	/**
 	* Muestra todas las ubicaciones de los apartamentos
 	* @return Arraylist de las ubicaciones de los apartamentos
 	* @throws SQLException
 	*/
 	public ArrayList<String> mostrarUbicaciones () throws SQLException{ 
    	//Declaracion e incializacion de variables

 		String ubicacion="";
		ArrayList<String> ubicaciones =new ArrayList<String>();
		String query="select distinct ubicacion from apartamento;";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);	

 		while(rs.next()) {		
				ubicacion = rs.getString("ubicacion");
				ubicaciones.add(ubicacion);
			}

 		return ubicaciones;

 	}
 	/**
 	 * Busca en la base de datos todos los apartamentos con la ubicacion que desee
 	 * @param ubicacion
 	 * @return ArrayList de todos los apartamentos con esa ubicacion
 	 * @throws SQLException
 	 */
 	public ArrayList<Apartamento> buscarUbicacion(String ubicacion) throws SQLException{

 		String nombre="";	
		int codapartamento;
		int tamano;
		float precio;
		int piso;


 		ArrayList<Apartamento> apartamentos =new ArrayList<Apartamento>();


 		String query="select * from apartamento where ubicacion='"+ubicacion+"';";

 		ResultSet rs = miConsulta.hacerConsultaBD(con, query);

 		while(rs.next()) {

 			apartamento=new Apartamento();

 			codapartamento = rs.getInt("cod_apartamento");
			nombre = rs.getString("nombre");
			ubicacion = rs.getString("ubicacion");
			tamano = rs.getInt("tamano");
			precio = rs.getFloat("precio");
			piso = rs.getInt("piso");

 			apartamento.setCod_apartamento(codapartamento);
			apartamento.setNombre(nombre);
			apartamento.setUbicacion(ubicacion);
			apartamento.setTamano(tamano);
			apartamento.setPrecio(precio);
			apartamento.setPiso(piso);

 			apartamentos.add(apartamento);
		}

 		return apartamentos;
	}
 	public ArrayList<Dormitorio> leerDormitorios(int codApart) throws SQLException{
		String tipo="";
		int codHabitacion;
		int tamano;int capacidad;int nCamas;
		ArrayList<Dormitorio> dormitorios =new ArrayList<Dormitorio>();
		
		String query="select d.cod_dormitorio,d.tipo,d.ncamas,d.capacidad from dormitorio_apart d where d.cod_apart='"+codApart+"';";
		ResultSet rs = miConsulta.hacerConsultaBD(con, query);
		
		while(rs.next()) {
			codHabitacion = rs.getInt("cod_dormitorio");
			tipo = rs.getString("tipo");
			//tamano=rs.getInt("tamano");
			capacidad=rs.getInt("capacidad");
			nCamas=rs.getInt("nCamas");
			Dormitorio dormitorio =new Dormitorio();
			dormitorio.setCodHabitacion(codHabitacion);
			dormitorio.setTipo(tipo);
			//dormitorio.setTamano(tamano);
			dormitorio.setCapacidad(capacidad);
			dormitorio.setnCamas(nCamas);
			dormitorios.add(dormitorio);
		}
		return dormitorios;
	}
 	
}
