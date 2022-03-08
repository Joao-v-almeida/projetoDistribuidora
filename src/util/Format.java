package util;

public class Format {
	public Double converterVirgulaParaPonto(String valor) {
		String retorno = new String();
		int tamanhoString = valor.length();
		for (int i = 0; i < tamanhoString; i++) {
			if (valor.charAt(i) == ',') {
				retorno += '.';
			} else {
				retorno += valor.charAt(i);
			}
		}
		return Double.parseDouble(retorno);
	}
}
