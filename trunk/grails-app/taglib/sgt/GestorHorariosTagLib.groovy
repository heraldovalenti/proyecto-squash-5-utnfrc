package sgt

import com.sun.org.apache.xalan.internal.xsltc.compiler.FormatNumberCall;

class GestorHorariosTagLib {

	static namespace = "gestorhorarios"
	
	/**
	 * Convierte un dia en contraccion a el nombre completo
	 * 
	 * @attr dia (String): el dia que se quiere convertir, en formato:
	 * <Lu - Ma  -Mi - Ju - Vi - Sa - Do>
	 */
	def diaCompleto = { attrs ->
		def res = "No valido"
		switch(attrs.dia) {
			case 'Lu':
			res = "Lunes"
			break;
			
			case 'Ma':
			res = "Martes"
			break;
			
			case 'Mi':
			res = "Miercoles"
			break;
			
			case 'Ju':
			res = "Jueves"
			break;
			
			case 'Vi':
			res = "Viernes"
			break;
			
			case 'Sa':
			res = "Sabado"
			break;
			
			case 'Do':
			res = "Domingo"
			break;
		}
		out << res
	}
	
	/**
	 * Convierte un valor entre 0 y 1439 a horas y minutos
	 * 
	 * @attr value (Integer): el valor a convertir a horas y minutos
	 */
	def aHorasYMinutos = { attrs ->
		def value = 0
		try {
			value = Integer.parseInt(attrs.value)
		} catch (NumberFormatException ex) {}
		if (value > 1439 || value < 0) {
			value = 0;
		}
		def horas = (Integer)(value / 60)
		def minutos = value % 60
		out << horas.toString()
		out << ":"
		out << minutos.toString()
	}
	
	/**
	 * Convierte una horario dado en horas y minutos
	 * a un valor entre 0 y 1439.
	 * 
	 * @attr minutos (Integer): cantidad de minutos (entre 0 y 59)
	 * @attr horas (Integer): cantidad de horas (entre 0 y 23)
	 */
	def aValor = { attrs ->
		def minutos = 0
		def horas = 0
		try {
			minutos = Integer.parseInt(attrs.minutos)
		} catch (NumberFormatException ex) {}
		try {
			horas = Integer.parseInt(attrs.horas)
		} catch (NumberFormatException ex) {}
		if (minutos < 0 || minutos > 59) minutos = 0
		if (horas < 0 || horas > 23) horas = 0
		def res = horas * 60 + minutos
		out << res.toString()
	}
	
	/**
	 * Convierte un valor entre 0 y 1439 a el valor de 
	 * horario correspondiente, en horas.
	 * 
	 * @attr value (Integer): un valor entre 0 y 1439.
	 */
	def aHoras = { attrs ->
		def value = 0
		try {
			value = Integer.parseInt(attrs.value)
		} catch (NumberFormatException ex) {}
		if (value > 1439 || value < 0) {
			value = 0;
		}
		def horas = (Integer)(value / 60)
		out << horas.toString()
	}
	
	/**
	 * Convierte un valor entre 0 y 1439 a el valor de 
	 * horario correspondiente, en minutos.
	 * 
	 * @attr value (Integer): un valor entre 0 y 1439.
	 */
	def aMinutos = { attrs ->
		def value = 0
		try {
			value = Integer.parseInt(attrs.value)
		} catch (NumberFormatException ex) {}
		if (value > 1439 || value < 0) {
			value = 0;
		}
		def minutos = value % 60
		out << minutos.toString()
	}
	
	/**
	 * Muestra un selector de horario, en horas y minutos.
	 * 
	 * @attr name (String): el nombre del componente.
	 * @attr value (Integer): el valor a seleccionar, entre 0 y 1439.
	 */
	def selectorHorarios = { attrs ->
		def value = 0
		try {
			value = Integer.parseInt(attrs.value)
		} catch (NumberFormatException ex) { }
		if (value > 1439 || value < 0) {
			value = 0;
		}
		def horas = (Integer)(value / 60)
		def minutos = value % 60
		def nameHoras = attrs.name.concat("Horas")
		def nameMinutos = attrs.name.concat("Minutos")
		out << g.select(from: 0..23, name: nameHoras, value: horas) 
		out << ":" 
		out << g.select(from: 0..59, name: nameMinutos, value: minutos)
	}
}
