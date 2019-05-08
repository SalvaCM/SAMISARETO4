package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FuncionesPago {

	
	public double sumarDineroPago(String valor, double pagado) {

		pagado = pagado + Double.parseDouble(valor);

		return pagado;
			
	}
	public double tasa(Date f1, Date f2) {
		Double tasa = 1d;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Para declarar valores en nuevos objetos date, usa el mismo formato date que usaste al crear las fechas 
		Date date1 = null;
		Date date2 = null ;
		Date date3 = null;
		Date date4 = null ;
		Date date5 = null;
		Date date6 = null ;
		Date date7 = null;
		
		
		try {
			//verano
			 date1 = sdf.parse("2019-06-21");
			 date2 = sdf.parse("2019-09-23");
			 //asuncion de la virgen
			 date3 = sdf.parse("2019-08-15");
			 //dia de la hispanidad
			 date4 = sdf.parse("2019-10-12");
			 //todos los santos
			 date5 = sdf.parse("2019-11-01");
			 //dia constitucion
			 date6 = sdf.parse("2019-12-06");
			 //navidad
			 date7 = sdf.parse("2019-12-25");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		if(f1==null && f2==null) {
			tasa=1d;
			
		}else {
			
		
		if((f2.compareTo(date1)>=0 && f1.compareTo(date2)<=0)) {
				tasa=1.5;
				if((f2.compareTo(date3)>=0 && f1.compareTo(date3)<=0)) {
					tasa=1.6;
				}
			}
		if((f2.compareTo(date4)>=0 && f1.compareTo(date4)<=0)) {
			tasa=1.25;
			
		}
		if((f2.compareTo(date5)>=0 && f1.compareTo(date5)<=0)) {
			tasa=1.35;
			
		}
		if((f2.compareTo(date6)>=0 && f1.compareTo(date6)<=0)) {
			tasa=1.15;
			
		}
		if((f2.compareTo(date7)>=0 && f1.compareTo(date7)<=0)) {
			tasa=1.65;
			
		}
		}
		
		return tasa;
			
	}
	

}
