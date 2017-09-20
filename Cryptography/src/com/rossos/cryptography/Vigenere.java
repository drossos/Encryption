package com.rossos.cryptography;

import java.util.Scanner;
public class Vigenere extends Cipher{
	private String key;
	public Vigenere(int encOrDec, String phrase, String key) {
		super(encOrDec,phrase);
		this.key = key;
		if (encOrDec == Driver.ENCODE) {
			super.setEncoded(encode(super.getDecoded(),super.getEncoded()));
			
			System.out.println("Encoded message is: " + super.getEncoded());
		}
		if (encOrDec == Driver.DECODE) {
			super.setDecoded(decode(super.getDecoded(),super.getEncoded()));
			System.out.println("Encoded message is: " + super.getDecoded());
	}
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