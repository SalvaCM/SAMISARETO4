package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Modelo;
import vista.Ventana;

public class ControladorRegistro implements ActionListener {
	
	private Ventana miVentana;
	private Modelo miModelo;

	
	FuncionesControlador funciones = new FuncionesControlador();
	
	/**
	 * Constructor de la clase
	 * @param miVentana instancia de la ventna principal
	 * @param miModelo instancia del modelo para acceder a las funciones de los paneles
	 * @param miControlador 
	 */
	public ControladorRegistro(Ventana miVentana, Modelo miModelo) {
		
		this.miVentana = miVentana;
		this.miModelo = miModelo;

		miVentana.registro.btnCancelar.addActionListener(this);
		miVentana.registro.btnRegistrarse.addActionListener(this);
	
	}
	
	/**
	 * Metodo para las llamadas a los botones de la ventana resumen
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (((JButton) e.getSource()).getName()) {
		case "btnRegistro": 
	
			try {
				JTextArea textArea = new JTextArea(25, 50);
			      textArea.setText( "CONDICIONES DE USO\r\n" + 
			      		"\r\n" + 
			      		"1�. Identificaci�n de las partes. Definici�n de usuario.\r\n" + 
			      		"\r\n" + 
			      		"Los t�rminos y condiciones que contiene el presente documento regulan el acceso y uso de la Web www.viajesSAMISA.com , (en adelante viajesSamisa.com o el sitio Web)\r\n" + 
			      		"\r\n" + 
			      		"La marca SAMISA que es propiedad de COMUNIDAD DE AGENCIAS DE VIAJES, S.A. , con domicilio en calle Altas Calles 15,plantas 6� y 7�, Bilabo.\r\n" + 
			      		"\r\n" + 
			      		"El acceso y uso del sitio Web otorga a quien lo realiza la condici�n de usuario del mismo, aceptando desde ese momento y sin reserva alguna las presentes Condiciones de Uso, reserv�ndose el derecho a modificar o actualizar las mismas en cualquier momento, sin necesidad de comunicaci�n previa a los usuarios, y sin perjuicio todo ello de que VIAJES SAMISA pudiera establecer Condiciones Particulares para la regulaci�n de determinados servicios.\r\n" + 
			      		"\r\n" + 
			      		"En caso de que el usuario sea menor de edad deber� contar con autorizaci�n previa de sus padres, tutores o representantes legales, quienes ser�n considerados a todos los efectos responsables de los actos y gastos realizados por dichos menores a su cargo, declinando VIAJES SAMISA en caso contrario, cualquier responsabilidad al respecto.\r\n" + 
			      		"\r\n" + 
			      		"Las presentes Condiciones de Uso y Contrataci�n, no excluyen la posibilidad de que determinados servicios prestados a trav�s de este sitio Web, por sus circunstancias particulares, est�n sometidas a condiciones espec�ficas de Uso y Contrataci�n., que pueden sustituir, complementa y/o modificar las presentes Condiciones.\r\n" + 
			      		"\r\n" + 
			      		"2�. Sobre el Servicio.\r\n" + 
			      		"\r\n" + 
			      		"Con el uso del sitio Web, los usuarios tienen acceso a informaci�n de servicios tur�sticos de terceros proveedores, incluso de viajes combinados, teniendo la posibilidad de su contrataci�n a trav�s del mismo. Estos servicios ser�n suministrados por VIAJES SAMISA, en su calidad de agencia de viajes minorista, limit�ndose la responsabilidad a la legalmente establecida para esta actividad, dado que la organizaci�n t�cnica de los servicios y formalizaci�n de reservas ser�n realizadas por las compa��as a�reas y resto de prestatarios de los servicios tur�sticos.\r\n" + 
			      		"\r\n" + 
			      		"La contrataci�n de los servicios se realizar� con arreglo a las presentes condiciones de uso, las condiciones generales espec�ficas establecidas para cada servicio, las condiciones particulares que se pudieran establecer para los servicios concretos los proveedores de los mismos, as� como a la normativa vigente de aplicaci�n.\r\n" + 
			      		"\r\n" + 
			      		"No obstante lo anterior, la contrataci�n de viajes combinados estar� sujeta a lo dispuesto en el Real Decreto Legislativo 1/2007, de 16 de noviembre, por el que se aprueba el texto refundido de la Ley General para la Defensa de los Consumidores y Usuarios y otras leyes complementarias, as� como a las condiciones espec�ficas acordadas con el Usuario en funci�n del Mayorista que organice el viaje combinado, actuando VIAJES SAMISA como agencia de viajes minorista.\r\n" + 
			      		"\r\n" + 
			      		"El Usuario acepta los t�rminos y condiciones de compra que sean establecidos por cualquier proveedor u organizador con el que decida contratar, incluyendo el abono de cualesquier importe devengado y el cumplimiento de cualesquiera normas y restricciones acerca de la disponibilidad de tarifas, productos o servicios tur�sticos.\r\n" + 
			      		"\r\n" + 
			      		"Los proveedores de productos o servicios y los organizadores de viajes combinados, cada uno dentro del �mbito de sus respectivas obligaciones, ser�n responsables frente al Usuario del cumplimiento de las obligaciones derivadas de la normativa en vigor y de los t�rminos y condiciones de venta de cada uno de los productos y servicios o viajes combinados que se contraten, sin que VIAJES SAMISA asuma obligaci�n ni responsabilidad alguna respecto de aquellos productos o servicios que no preste directamente.\r\n" + 
			      		"\r\n" + 
			      		"3�. Obligaciones del usuario.\r\n" + 
			      		"\r\n" + 
			      		"El Usuario se obliga a usar el sitio Web conforme a la legalidad vigente, as� como a no utilizar el mismo con fines il�citos o lesivos para los derechos e intereses de su titular, o de terceros, y a no causar perjuicios o impedir el normal funcionamiento de viajeszeppelin.com.\r\n" + 
			      		"\r\n" + 
			      		"El usuario consiente en aceptar y respetar los t�rminos y condiciones de adquisici�n de los servicios que sean establecidos por los distintos proveedores con que el usuario decida contratar.\r\n" + 
			      		"\r\n" + 
			      		"El usuario se obliga al abono de los servicios y productos contratados mediante tarjeta de d�bito (Visa electr�n) o cr�dito (Visa), a trav�s de la pasarela de pago habilitada en el sitio web a tal efecto.\r\n" + 
			      		"\r\n" + 
			      		"4�. Limitaci�n de Responsabilidad\r\n" + 
			      		"\r\n" + 
			      		"A.- Del usuario.\r\n" + 
			      		"El uso que realice el usuario de viajeszeppelin.com ser� responsabilidad �nica y exclusiva de �ste, exonerando a COMUNIDAD DE AGENCIAS DE VIAJES, S.A. de cualquier da�o o perjuicio que directa o indirectamente pudiera ocasionar, al propio usuario o a terceros, la no observaci�n de las presentes Condiciones de Uso por parte del usuario.\r\n" + 
			      		"\r\n" + 
			      		"B.- De los proveedores de servicios o productos.\r\n" + 
			      		"Ser� responsabilidad de �stos, la elaboraci�n y actualizaci�n relativas a sus ofertas, servicios o productos, y a los datos que de ellos se deriven, sin que VIAJES SAMISA sea responsable del mantenimiento, actualizaci�n o supervisi�n de la mencionada informaci�n. Los distintos proveedores de servicios o productos, as� como los organizadores de viajes combinados, ser�n responsables cada uno por sus respectivas obligaciones frente al usuario, respondiendo por su cumplimiento derivado tanto de la legislaci�n vigente, "
			      		+ "\r\n"+"como de los t�rminos y condiciones contra�dos por la venta de alguno de sus servicios, "
			      		+ "\r\n"+"productos o viajes combinados contratados, sin que le puedan ser imputada responsabilidad alguna a VIAJES SAMISA por aquellos servicios o productos que no preste directamente, que se mostrar�n en la pantalla, y que el usuario acepta expl�citamente para finalizar su reserva o compra.\r\n" + 
			      		"\r\n" + 
			      		"C.- De COMUNIDAD AGENCIAS DE VIAJES, S.A.\r\n" + 
			      		"VIAJES SAMISA responder� frente al usuario de las obligaciones derivadas por su �mbito de gesti�n, y en concreto, la emisi�n y gesti�n de billetes a�reos, as� como el env�o de documentaci�n, en su caso, y la formalizaci�n de reservas, incluyendo la facilitaci�n de tarifas\r\n" + 
			      		"\r\n" + 
			      		"VIAJES SAMISA no se har� responsable ni directa ni subsidiariamente de las siguientes responsabilidades:\r\n" + 
			      		"\r\n" + 
			      		"La calidad del servicio, el correcto funcionamiento o la disponibilidad y continuidad del sitio web, as� como todas las responsabilidades derivadas de otros proveedores ajenos a VIAJES SAMISA.\r\n" + 
			      		"Las informaciones y datos introducidos por terceras personas distintas al personal de VIAJES SAMISA.\r\n" + 
			      		"Los da�os que puedan ocasionarse a los equipos de los usuarios por la utilizaci�n del sitio web\r\n" + 
			      		"Si en casos de fuerza mayor se derivasen deficiencias en las reservas, confirmaciones de las mismas, o en la ejecuci�n de los servicios o productos que se contraten a trav�s del sitio web, y sin que tengan la condici�n de previsibles o puedan ser solucionables por la Agencia salvo que fuesen como consecuencia de negligencia imputable a VIAJES ZEPPELIN\r\n" + 
			      		"La vulneraci�n de los derechos de propiedad intelectual e industrial, al honor, a la intimidad personal y familiar y a la imagen de las personas, pertenecientes a un tercero, como consecuencia de la transmisi�n, difusi�n, almacenamiento o puesta a disposici�n de accesos a los contenidos del sitio web.\r\n" + 
			      		"Los enlaces e hipertextos que habilita iag7viajes.com, para que el usuario acceda a los servicios y productos prestados por terceros, por no pertenecer ni tener control por parte de VIAJES ZEPPELIN. No siendo responsable del funcionamiento de dichos enlaces e hipertextos, as� como de la informaci�n que pudieren contener la web enlazada.\r\n" + 
			      		"Las erratas, imprecisiones o errores de cualquier g�nero, por lo que VIAJES SAMISA no garantiza la exactitud o fiabilidad de la informaci�n contenida en el sitio web.\r\n" + 
			      		"\r\n" + 
			      		"5�. Propiedad Intelectual e Industrial.\r\n" + 
			      		"\r\n" + 
			      		"COMUNIDAD DE AGENCIAS DE VIAJES, S.A. es titular de todos los derechos de propiedad industrial e industrial, marcas, patentes y copyright sobre las marcas y logotipos referentes a las marcas VIAJES SAMISA y www.viajeSAMISA.com, quedando expresamente prohibido el uso o reproducci�n de los mismos, por terceros, m�s all� de los expresamente previstos en las presentes Condiciones de Uso. Igualmente a trav�s del sitio Web se puede acceder a contenidos y elementos que igualmente est�n sujetos" + 
			      		"\r\n"+ "y protegidos por derechos de propiedad industrial e intelectual, patentes, marcas y copyright de terceros titulares quedando expresamente prohibida cualquier uso, alteraci�n, modificaci�n, explotaci�n, reproducci�n, comunicaci�n o cualquier otro derecho que corresponda al titular del derecho afectado\r\n" + 
			      		"\r\n" + 
			      		"6�. Tratamiento de datos de car�cter personal. Pol�tica de privacidad.\r\n" + 
			      		"\r\n" + 
			      		"VIAJES SAMISA en cumplimiento de la normativa vigente aplicable (L.O. 15/1999 de 13 de diciembre, sobre la Protecci�n de Datos de Car�cter Personal) tiene implantada una pol�tica de Protecci�n de Datos que regula la recogida, almacenamiento, tratamiento y uso de los datos personales que el usuario facilite. En este sentido, VIAJES SAMISA garantiza el cumplimiento por su parte de dicha pol�tica que puede ser consultada por el usuario accediendo al enlace Protecci�n de Datos que aparece en el men� inferior del sitio web.\r\n" + 
			      		"\r\n" + 
			      		"El usuario, con la cumplimentaci�n y env�o de los formularios existentes en viajesSAMISA.com o con el env�o de correos electr�nicos a la direcci�n de contacto habilitada a tal efecto en la web, presta su consentimiento al tratamiento automatizado de los datos incluidos en los mismos, autorizando igualmente a COMUNIDAD DE AGENCIAS DE VIAJES, S.A. a incluir sus datos personales en los ficheros correspondientes para su utilizaci�n y tratamiento automatizado," 
			      		+ "\r\n"+"para la gesti�n y registro de las operaciones contratadas, a lo que los Usuarios prestan su consentimiento.\r\n" + 
			      		"\r\n" + 
			      		"Viajeszeppelin.com utiliza cookies cuando el Usuario navegue por el sitio Web. Estas cookies se asocian con un Usuario an�nimo y su equipo, no proporcionando referencias que permitan deducir datos personales del mismo. Por medio de las cookies, el sitio Web puede reconocer a los Usuarios registrados, sin que �stos tengan que registrarse en cada acceso al sitio Web al �rea reservado para los Usuarios registrados. En todo momento, el Usuario tiene la opci�n de "
			      		+ "impedir la generaci�n de cookies, mediante la selecci�n de la correspondiente opci�n en su navegador.\r\n" + 
			      		"\r\n" + 
			      		"Igualmente, en aplicaci�n de lo establecido en el art�culo 22 de la Ley 34/2002, de 11 de julio, de servicios de la sociedad de la informaci�n y comercio electr�nico (LSSICE), VIAJES SAMISA informa a los titulares de los datos, de su intenci�n de enviarles comunicaciones comerciales por correo electr�nico o por cualquier otro medio de comunicaci�n electr�nica una vez hayan autorizado el mismo.\r\n" + 
			      		"\r\n" + 
			      		"El consentimiento prestado por el Usuario titular de los datos de car�cter personal para su uso, a los efectos anteriormente mencionados, tiene car�cter revocable en todo momento, sin efectos retroactivos. Igualmente, respecto de estos datos, podr� ejercitar los derechos de acceso, rectificaci�n, cancelaci�n y oposici�n previstos en la Ley, dirigi�ndose, por cualquier medio que permita acreditar el env�o y la recepci�n, VIAJES SAMISA,calle Ruiz Perell�, 15 28028 Madrid o bien mediante correo electr�nico a info@viajesSAMISA.com\r\n" + 
			      		"\r\n" + 
			      		"7�. Modificaci�n y cancelaci�n de las presentes Condiciones.\r\n" + 
			      		"\r\n" + 
			      		"VIAJES SAMISA se reserva el derecho a modificar total o parcialmente viajeszeppelin.com, su dise�o, contenidos y servicios, as� como las presentes Condiciones de Uso cuando as� lo estime oportuno. Igualmente, VIAJES SAMISA se reserva el derecho a interrumpir, suspender temporalmente o cancelar definitivamente viajeszeppelin.com o cualquiera de los contenidos o servicios que lo integran, a su �nica y entera discreci�n.\r\n" + 
			      		"\r\n" + 
			      		"8�. Legislaci�n aplicable y resoluci�n de conflictos.\r\n" + 
			      		"\r\n" + 
			      		"Las partes, renuncian expresamente a su propio fuero, aceptando como legislaci�n aplicable a las presentes Condiciones de Uso y Contrataci�n, el ordenamiento jur�dico espa�ol, y para la resoluci�n de cuantas controversias o litigios pudieran derivarse de las mismas acuerdan someterse a la jurisdicci�n de los Juzgados y Tribunales de Madrid.\r\n" + 
			      		"\r\n" + 
			      		""
			    		  
			      		);
			      textArea.setEditable(false);
			      
			      // wrap a scrollpane around it
			      JScrollPane scrollPane = new JScrollPane(textArea);
			      Date fechaRegistro=new Date();
			      // display them in a message dialog
			      int  confirmado=  JOptionPane.showConfirmDialog(null, scrollPane,"   Acepte las condiciones de uso",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			      if (JOptionPane.OK_OPTION== confirmado) {
			    	   System.out.println("confirmado");
			    	   if(miModelo.misFuncionesRegistro.comprobarCamposRegistro(miVentana.registro.textFieldDni.getText(), miVentana.registro.textFieldNombre.getText(),  miVentana.registro.textFieldApellido.getText(), miVentana.registro.fechaNac.getDate(),miVentana.registro.passwordField.getPassword())) {
							try {
								miModelo.misFuncionesRegistro.registrarNuevoCliente(miVentana.registro.textFieldDni.getText(), miVentana.registro.textFieldNombre.getText(),  miVentana.registro.textFieldApellido.getText(), miVentana.registro.fechaNac.getDate(),miVentana.registro.passwordField.getPassword(),fechaRegistro);
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							funciones.cambiarDePanel(miVentana.registro, miVentana.login); 
						}
				       
			      }
							
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			miVentana.registro.textFieldDni.setText("");
			miVentana.registro.textFieldNombre.setText("");
			miVentana.registro.textFieldApellido.setText("");
			miVentana.registro.passwordField.setText("");
		
				break;

			    
		
		case "btnCancelarRegistro": funciones.cambiarDePanel(miVentana.registro, miVentana.login);	
		miVentana.registro.textFieldDni.setText("");
		miVentana.registro.textFieldNombre.setText("");
		miVentana.registro.textFieldApellido.setText("");
		miVentana.registro.passwordField.setText("");
		
				break;

		}
	}	

}
