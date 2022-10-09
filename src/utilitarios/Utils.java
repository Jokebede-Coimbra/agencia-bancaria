package utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Utils {

	static NumberFormat formatarValores = new DecimalFormat("R$ #,##0.00");

	// Transformar de Double para String
	public static String doubleToString(Double valor) {
		return formatarValores.format(valor);
	}
}
