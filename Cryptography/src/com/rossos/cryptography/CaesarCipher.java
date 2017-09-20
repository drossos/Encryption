package com.rossos.cryptography;

public class CaesarCipher extends Cipher {
	private int shift;

	public CaesarCipher(int encOrDec, String phrase, int caesarShift) {
		super(encOrDec, phrase);
		this.shift = caesarShift;
		if (encOrDec == Driver.DECODE) {
			super.setDecoded(reduceShift(super.getEncoded(), this.getDecoded(), shift));
		} else {
			super.setEncoded(applyShift(super.getEncoded(), this.getDecoded(), shift));
		}

	}

	public String applyShift(String encoded, String decoded, int shift) {
		//must assign a value to the string to be empty that way does 
		//not add on to "null"
		encoded = "";
		for (int i = 0; i < decoded.length(); i++) {
			char currentChar = decoded.charAt(i);
			for (int k = 0; k < shift; k++) {
				currentChar = (char) (currentChar + 1);
				if (currentChar == 91)
					currentChar = (char) 65;
			}
			encoded += "" + currentChar;
		}
		super.setEncoded(encoded);
		return encoded;

	}

	public String reduceShift(String encoded, String decoded, int shift) {
		decoded = "";
		for (int i = 0; i < encoded.length(); i++) {
			char currentChar = encoded.charAt(i);
			for (int k = 0; k < shift; k++) {
				currentChar = (char) (currentChar - 1);
				if (currentChar == 64)
					currentChar = (char) 90;
			}
			decoded += "" + currentChar;
		}
		super.setDecoded(decoded);
		return decoded;

	}

	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		this.shift = shift;
	}

}
