package com.rossos.cryptography;
import java.util.Scanner;
/**
 * @author Daniel Rossos
 *
 */
public class Vigenere extends Cipher{
	private String key;
	/**
	 * @param encOrDec int deciding to encode (0) or decode (1)
	 * @param phrase String for encoding or decoding
	 * @param key String that will be compared against in making and
	 * decoding the message
	 */
	
	public Vigenere(int encOrDec, String phrase, String key) {
		super(encOrDec,phrase);
		this.key = formatKey(key,phrase);
		if (encOrDec == Cipher.ENCODE) {
			super.setEncoded(encode(super.getDecoded(),super.getEncoded()));
			
			System.out.println("Encoded message is: " + super.getEncoded());
		}
		if (encOrDec == Cipher.DECODE) {
			super.setDecoded(decode(super.getDecoded(),super.getEncoded()));
			System.out.println("Encoded message is: " + super.getDecoded());
	}
	}
	
	private String formatKey(String key2, String phrase) {
		String updateKey = key2;
		int indexInKey = 0;
		while (updateKey.length() < phrase.length()) {
			if (indexInKey == key2.length())
				indexInKey = 0;
			updateKey += key2.charAt(indexInKey);
		}
		
		return updateKey;
	}

	private String decode(String decoded, String encoded) {
		int keyIndex = 0;
		for (int i = 0; i < encoded.length();i++){
			char x = (char) (encoded.charAt(i) - (key.charAt(keyIndex)-65));
			if (x < 65)
				x += 26;
			decoded += x;
			keyIndex++;
			if (keyIndex == key.length())
				keyIndex = 0;
		}
		return decoded;
	}

	private String encode(String decoded, String encoded) {
		int keyIndex = 0;
		for (int i = 0; i < decoded.length();i++){
			char x = (char) (decoded.charAt(i) + (key.charAt(keyIndex)-65));
			if (x > 90)
				x -= 26;
			encoded += x;
			keyIndex++;
			if (keyIndex == key.length())
				keyIndex = 0;
		}
		return encoded;
	}

	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
}