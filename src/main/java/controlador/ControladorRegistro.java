package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
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
			      		"1ª. Identificación de las partes. Definición de usuario.\r\n" + 
			      		"\r\n" + 
			      		"Los términos y condiciones que contiene el presente documento regulan el acceso y uso de la Web www.viajesSAMISA.com , (en adelante viajesSamisa.com o el sitio Web)\r\n" + 
			      		"\r\n" + 
			      		"La marca SAMISA que es propiedad de COMUNIDAD DE AGENCIAS DE VIAJES, S.A. , con domicilio en calle Altas Calles 15,plantas 6ª y 7ª, Bilabo.\r\n" + 
			      		"\r\n" + 
			      		"El acceso y uso del sitio Web otorga a quien lo realiza la condición de usuario del mismo, aceptando desde ese momento y sin reserva alguna las presentes Condiciones de Uso, reservándose el derecho a modificar o actualizar las mismas en cualquier momento, sin necesidad de comunicación previa a los usuarios, y sin perjuicio todo ello de que VIAJES SAMISA pudiera establecer Condiciones Particulares para la regulación de determinados servicios.\r\n" + 
			      		"\r\n" + 
			      		"En caso de que el usuario sea menor de edad deberá contar con autorización previa de sus padres, tutores o representantes legales, quienes serán considerados a todos los efectos responsables de los actos y gastos realizados por dichos menores a su cargo, declinando VIAJES SAMISA en caso contrario, cualquier responsabilidad al respecto.\r\n" + 
			      		"\r\n" + 
			      		"Las presentes Condiciones de Uso y Contratación, no excluyen la posibilidad de que determinados servicios prestados a través de este sitio Web, por sus circunstancias particulares, estén sometidas a condiciones específicas de Uso y Contratación., que pueden sustituir, complementa y/o modificar las presentes Condiciones.\r\n" + 
			      		"\r\n" + 
			      		"2ª. Sobre el Servicio.\r\n" + 
			      		"\r\n" + 
			      		"Con el uso del sitio Web, los usuarios tienen acceso a información de servicios turísticos de terceros proveedores, incluso de viajes combinados, teniendo la posibilidad de su contratación a través del mismo. Estos servicios serán suministrados por VIAJES SAMISA, en su calidad de agencia de viajes minorista, limitándose la responsabilidad a la legalmente establecida para esta actividad, dado que la organización técnica de los servicios y formalización de reservas serán realizadas por las compañías aéreas y resto de prestatarios de los servicios turísticos.\r\n" + 
			      		"\r\n" + 
			      		"La contratación de los servicios se realizará con arreglo a las presentes condiciones de uso, las condiciones generales específicas establecidas para cada servicio, las condiciones particulares que se pudieran establecer para los servicios concretos los proveedores de los mismos, así como a la normativa vigente de aplicación.\r\n" + 
			      		"\r\n" + 
			      		"No obstante lo anterior, la contratación de viajes combinados estará sujeta a lo dispuesto en el Real Decreto Legislativo 1/2007, de 16 de noviembre, por el que se aprueba el texto refundido de la Ley General para la Defensa de los Consumidores y Usuarios y otras leyes complementarias, así como a las condiciones específicas acordadas con el Usuario en función del Mayorista que organice el viaje combinado, actuando VIAJES SAMISA como agencia de viajes minorista.\r\n" + 
			      		"\r\n" + 
			      		"El Usuario acepta los términos y condiciones de compra que sean establecidos por cualquier proveedor u organizador con el que decida contratar, incluyendo el abono de cualesquier importe devengado y el cumplimiento de cualesquiera normas y restricciones acerca de la disponibilidad de tarifas, productos o servicios turísticos.\r\n" + 
			      		"\r\n" + 
			      		"Los proveedores de productos o servicios y los organizadores de viajes combinados, cada uno dentro del ámbito de sus respectivas obligaciones, serán responsables frente al Usuario del cumplimiento de las obligaciones derivadas de la normativa en vigor y de los términos y condiciones de venta de cada uno de los productos y servicios o viajes combinados que se contraten, sin que VIAJES SAMISA asuma obligación ni responsabilidad alguna respecto de aquellos productos o servicios que no preste directamente.\r\n" + 
			      		"\r\n" + 
			      		"3ª. Obligaciones del usuario.\r\n" + 
			      		"\r\n" + 
			      		"El Usuario se obliga a usar el sitio Web conforme a la legalidad vigente, así como a no utilizar el mismo con fines ilícitos o lesivos para los derechos e intereses de su titular, o de terceros, y a no causar perjuicios o impedir el normal funcionamiento de viajeszeppelin.com.\r\n" + 
			      		"\r\n" + 
			      		"El usuario consiente en aceptar y respetar los términos y condiciones de adquisición de los servicios que sean establecidos por los distintos proveedores con que el usuario decida contratar.\r\n" + 
			      		"\r\n" + 
			      		"El usuario se obliga al abono de los servicios y productos contratados mediante tarjeta de débito (Visa electrón) o crédito (Visa), a través de la pasarela de pago habilitada en el sitio web a tal efecto.\r\n" + 
			      		"\r\n" + 
			      		"4ª. Limitación de Responsabilidad\r\n" + 
			      		"\r\n" + 
			      		"A.- Del usuario.\r\n" + 
			      		"El uso que realice el usuario de viajeszeppelin.com será responsabilidad única y exclusiva de éste, exonerando a COMUNIDAD DE AGENCIAS DE VIAJES, S.A. de cualquier daño o perjuicio que directa o indirectamente pudiera ocasionar, al propio usuario o a terceros, la no observación de las presentes Condiciones de Uso por parte del usuario.\r\n" + 
			      		"\r\n" + 
			      		"B.- De los proveedores de servicios o productos.\r\n" + 
			      		"Será responsabilidad de éstos, la elaboración y actualización relativas a sus ofertas, servicios o productos, y a los datos que de ellos se deriven, sin que VIAJES SAMISA sea responsable del mantenimiento, actualización o supervisión de la mencionada información. Los distintos proveedores de servicios o productos, así como los organizadores de viajes combinados, serán responsables cada uno por sus respectivas obligaciones frente al usuario, respondiendo por su cumplimiento derivado tanto de la legislación vigente, "
			      		+ "\r\n"+"como de los términos y condiciones contraídos por la venta de alguno de sus servicios, "
			      		+ "\r\n"+"productos o viajes combinados contratados, sin que le puedan ser imputada responsabilidad alguna a VIAJES SAMISA por aquellos servicios o productos que no preste directamente, que se mostrarán en la pantalla, y que el usuario acepta explícitamente para finalizar su reserva o compra.\r\n" + 
			      		"\r\n" + 
			      		"C.- De COMUNIDAD AGENCIAS DE VIAJES, S.A.\r\n" + 
			      		"VIAJES SAMISA responderá frente al usuario de las obligaciones derivadas por su ámbito de gestión, y en concreto, la emisión y gestión de billetes aéreos, así como el envío de documentación, en su caso, y la formalización de reservas, incluyendo la facilitación de tarifas\r\n" + 
			      		"\r\n" + 
			      		"VIAJES SAMISA no se hará responsable ni directa ni subsidiariamente de las siguientes responsabilidades:\r\n" + 
			      		"\r\n" + 
			      		"La calidad del servicio, el correcto funcionamiento o la disponibilidad y continuidad del sitio web, así como todas las responsabilidades derivadas de otros proveedores ajenos a VIAJES SAMISA.\r\n" + 
			      		"Las informaciones y datos introducidos por terceras personas distintas al personal de VIAJES SAMISA.\r\n" + 
			      		"Los daños que puedan ocasionarse a los equipos de los usuarios por la utilización del sitio web\r\n" + 
			      		"Si en casos de fuerza mayor se derivasen deficiencias en las reservas, confirmaciones de las mismas, o en la ejecución de los servicios o productos que se contraten a través del sitio web, y sin que tengan la condición de previsibles o puedan ser solucionables por la Agencia salvo que fuesen como consecuencia de negligencia imputable a VIAJES ZEPPELIN\r\n" + 
			      		"La vulneración de los derechos de propiedad intelectual e industrial, al honor, a la intimidad personal y familiar y a la imagen de las personas, pertenecientes a un tercero, como consecuencia de la transmisión, difusión, almacenamiento o puesta a disposición de accesos a los contenidos del sitio web.\r\n" + 
			      		"Los enlaces e hipertextos que habilita iag7viajes.com, para que el usuario acceda a los servicios y productos prestados por terceros, por no pertenecer ni tener control por parte de VIAJES ZEPPELIN. No siendo responsable del funcionamiento de dichos enlaces e hipertextos, así como de la información que pudieren contener la web enlazada.\r\n" + 
			      		"Las erratas, imprecisiones o errores de cualquier género, por lo que VIAJES SAMISA no garantiza la exactitud o fiabilidad de la información contenida en el sitio web.\r\n" + 
			      		"\r\n" + 
			      		"5ª. Propiedad Intelectual e Industrial.\r\n" + 
			      		"\r\n" + 
			      		"COMUNIDAD DE AGENCIAS DE VIAJES, S.A. es titular de todos los derechos de propiedad industrial e industrial, marcas, patentes y copyright sobre las marcas y logotipos referentes a las marcas VIAJES SAMISA y www.viajeSAMISA.com, quedando expresamente prohibido el uso o reproducción de los mismos, por terceros, más allá de los expresamente previstos en las presentes Condiciones de Uso. Igualmente a través del sitio Web se puede acceder a contenidos y elementos que igualmente están sujetos" + 
			      		"\r\n"+ "y protegidos por derechos de propiedad industrial e intelectual, patentes, marcas y copyright de terceros titulares quedando expresamente prohibida cualquier uso, alteración, modificación, explotación, reproducción, comunicación o cualquier otro derecho que corresponda al titular del derecho afectado\r\n" + 
			      		"\r\n" + 
			      		"6ª. Tratamiento de datos de carácter personal. Política de privacidad.\r\n" + 
			      		"\r\n" + 
			      		"VIAJES SAMISA en cumplimiento de la normativa vigente aplicable (L.O. 15/1999 de 13 de diciembre, sobre la Protección de Datos de Carácter Personal) tiene implantada una política de Protección de Datos que regula la recogida, almacenamiento, tratamiento y uso de los datos personales que el usuario facilite. En este sentido, VIAJES SAMISA garantiza el cumplimiento por su parte de dicha política que puede ser consultada por el usuario accediendo al enlace Protección de Datos que aparece en el menú inferior del sitio web.\r\n" + 
			      		"\r\n" + 
			      		"El usuario, con la cumplimentación y envío de los formularios existentes en viajesSAMISA.com o con el envío de correos electrónicos a la dirección de contacto habilitada a tal efecto en la web, presta su consentimiento al tratamiento automatizado de los datos incluidos en los mismos, autorizando igualmente a COMUNIDAD DE AGENCIAS DE VIAJES, S.A. a incluir sus datos personales en los ficheros correspondientes para su utilización y tratamiento automatizado," 
			      		+ "\r\n"+"para la gestión y registro de las operaciones contratadas, a lo que los Usuarios prestan su consentimiento.\r\n" + 
			      		"\r\n" + 
			      		"Viajeszeppelin.com utiliza cookies cuando el Usuario navegue por el sitio Web. Estas cookies se asocian con un Usuario anónimo y su equipo, no proporcionando referencias que permitan deducir datos personales del mismo. Por medio de las cookies, el sitio Web puede reconocer a los Usuarios registrados, sin que éstos tengan que registrarse en cada acceso al sitio Web al área reservado para los Usuarios registrados. En todo momento, el Usuario tiene la opción de "
			      		+ "impedir la generación de cookies, mediante la selección de la correspondiente opción en su navegador.\r\n" + 
			      		"\r\n" + 
			      		"Igualmente, en aplicación de lo establecido en el artículo 22 de la Ley 34/2002, de 11 de julio, de servicios de la sociedad de la información y comercio electrónico (LSSICE), VIAJES SAMISA informa a los titulares de los datos, de su intención de enviarles comunicaciones comerciales por correo electrónico o por cualquier otro medio de comunicación electrónica una vez hayan autorizado el mismo.\r\n" + 
			      		"\r\n" + 
			      		"El consentimiento prestado por el Usuario titular de los datos de carácter personal para su uso, a los efectos anteriormente mencionados, tiene carácter revocable en todo momento, sin efectos retroactivos. Igualmente, respecto de estos datos, podrá ejercitar los derechos de acceso, rectificación, cancelación y oposición previstos en la Ley, dirigiéndose, por cualquier medio que permita acreditar el envío y la recepción, VIAJES SAMISA,calle Ruiz Perelló, 15 28028 Madrid o bien mediante correo electrónico a info@viajesSAMISA.com\r\n" + 
			      		"\r\n" + 
			      		"7ª. Modificación y cancelación de las presentes Condiciones.\r\n" + 
			      		"\r\n" + 
			      		"VIAJES SAMISA se reserva el derecho a modificar total o parcialmente viajeszeppelin.com, su diseño, contenidos y servicios, así como las presentes Condiciones de Uso cuando así lo estime oportuno. Igualmente, VIAJES SAMISA se reserva el derecho a interrumpir, suspender temporalmente o cancelar definitivamente viajeszeppelin.com o cualquiera de los contenidos o servicios que lo integran, a su única y entera discreción.\r\n" + 
			      		"\r\n" + 
			      		"8ª. Legislación aplicable y resolución de conflictos.\r\n" + 
			      		"\r\n" + 
			      		"Las partes, renuncian expresamente a su propio fuero, aceptando como legislación aplicable a las presentes Condiciones de Uso y Contratación, el ordenamiento jurídico español, y para la resolución de cuantas controversias o litigios pudieran derivarse de las mismas acuerdan someterse a la jurisdicción de los Juzgados y Tribunales de Madrid.\r\n" + 
			      		"\r\n" + 
			      		""
			    		  
			      		);
			      textArea.setEditable(false);
			      
			      // wrap a scrollpane around it
			      JScrollPane scrollPane = new JScrollPane(textArea);
			      
			      // display them in a message dialog
			      int  confirmado=  JOptionPane.showConfirmDialog(null, scrollPane,"   Acepte las condiciones de uso",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
			      if (JOptionPane.OK_OPTION== confirmado) {
			    	   System.out.println("confirmado");
			    	   if(miModelo.misFuncionesRegistro.comprobarCamposRegistro(miVentana.registro.textFieldDni.getText(), miVentana.registro.textFieldNombre.getText(),  miVentana.registro.textFieldApellido.getText(), miVentana.registro.fechaNac.getDate(),miVentana.registro.passwordField.getPassword())) {
							miModelo.misFuncionesRegistro.registrarNuevoCliente(miVentana.registro.textFieldDni.getText(), miVentana.registro.textFieldNombre.getText(),  miVentana.registro.textFieldApellido.getText(), miVentana.registro.fechaNac.getDate(),miVentana.registro.passwordField.getPassword());
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
				break;

			    
		
		case "btnCancelarRegistro": funciones.cambiarDePanel(miVentana.registro, miVentana.login);		
				break;

		}
	}	

}
