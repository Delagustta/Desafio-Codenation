package com.gustavo.codenationProject.criptografias;

import java.math.BigInteger;
import java.security.MessageDigest;

public class SHA1 {

	public static String sha1(String text) {

		String sha1 = "";

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(text.getBytes("utf8"));
			sha1 = String.format("%040x", new BigInteger(1, digest.digest()));

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println( "The sha1 of \""+ text + "\" is:");
		System.out.println( sha1 );
		return sha1;

	}
	
	

}
