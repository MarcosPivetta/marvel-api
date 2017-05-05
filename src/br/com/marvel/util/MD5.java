package br.com.marvel.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;

public class MD5 {
	public static void main(String args[]) throws Exception {
		long timestamp = new Date(System.currentTimeMillis()).getTime();
		String privateKey = "b46b7d4517eed47dc74fd0b3de1ca64ae05544c5";
		String publicKey = "1442fe0d3575e71c1563ab4666f3cf21";
		String yourString = timestamp + privateKey + publicKey;
		String baseUrl = "http://gateway.marvel.com/v1/public/stories/56971";
		byte[] bytesOfMessage = yourString.getBytes("UTF-8");
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] thedigest = md.digest(bytesOfMessage);
		System.out.println(baseUrl + "?ts=" + timestamp + "&apikey=" + publicKey + "&hash="
				+ String.format("%032x", new BigInteger(1, thedigest)));
	}
}