package br.com.stefanini.scp.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 * Classe utilitaria para Datas
 * 
 * @author leandro
 *
 */
public class UtilData {

	private UtilData() {
	}
	
	public static LocalDate converterStringParaLocalDate(String str, FormatoData formato) {
		if (str != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato.getFormato());
			return LocalDate.parse(str, formatter);
		}
		return null;
	}
	
	public static String converterLocalDateParaString(LocalDate localDate, FormatoData formato) {
		if (localDate != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato.getFormato());
			return localDate.format(formatter);
		}
		return null;
	}
	
	public enum FormatoData {
		DATA_HORA_MIN_SEG("dd/MM/yyyy HH:mm:ss"),
		DATA("dd/MM/yyyy"),
		DATA_INTERNACIONAL("yyyy-MM-dd"),
		DATA_INTER_HORA("yyyy-MM-dd HH:mm"),
		DATA_HORA_MIN("dd/MM/yyyy HH:mm"),
		HORA_MINUTO_SEGUNDO("HH:mm:ss"),
		HORA_MINUTO("HH:mm"),
		ANO("yyyy"),
		MES("MM"),
		DIA("dd");

		private String formato;

		private FormatoData(String formato) {
			this.formato = formato;
		}
	
		public String getFormato() {
			return formato;
		}

		public static FormatoData getFormato(String formato) {
			return Arrays.asList(FormatoData.values()).stream().filter(f -> f.getFormato().equalsIgnoreCase(formato))
					.findFirst().get();
		}

	}
	
}
