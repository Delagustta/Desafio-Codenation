package com.gustavo.codenationProject.criptografias;

public class CifraDeCesar {
	

	public static String decifrar(int key, String textoCifrado) {
		textoCifrado = textoCifrado.toLowerCase();
		String text = "";
		int min = 97;
		int max = 122;

		for (int i = 0; i < textoCifrado.length(); i++) {
			
			int caracter = (int) textoCifrado.charAt(i);

			if (caracter < min || caracter > max) {
				
				text += (char) caracter;

			} else {
				
				int ASCII = ((int) textoCifrado.charAt(i)) - key;
				
				if (ASCII < min) {
					ASCII = max - (min - ASCII) + 1;
				}
				
				text += (char) ASCII;
				
			} 

		}
		System.out.println(text);
		return text;

	}

}
