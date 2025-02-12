package com.tecno.infraestructura.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.tecno.dominio.modelo.MensajeError;

public class StringUtil {

	private StringUtil() {
	}

	public static boolean isNotNullOrEmpty(String str) {
		return (str != null && !str.isEmpty());
	}

	public static MensajeError validarCarteresEspeciales(String cadena) {
		MensajeError e = null;
		Pattern pat = Pattern.compile("^[a-zA-Z0-9 ]+$");
		Matcher mat = pat.matcher(cadena);
		if (!mat.matches()) {
			e = new MensajeError();
			e.setCodigo("400");
			e.setMensaje("Mensaje de Error ");
			e.setDescripcion("El campo no debe tener caracteres especiales!");
		}
		return e;
	}
}
