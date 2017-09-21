package com.rossos.cryptography;

/**
 * @author Daniel Rossos
 *
 */
public class CaesarCipher extends Cipher {
	private int shift;

	/**
	 * @param encOrDec int deciding to encode (0) or decode (1)
	 * @param phrase String for encoding or decoding
	 * @param caesarShift int used to decide how much to shift the phrase in encoding or decoding
	 * @return returns an instance of CaesarCipher
	 */
	public CaesarCipher(int encOrDec, String phrase, int caesarShift) {
		super(encOrDec, phrase);
		this.shift = caesarShift;
		if (encOrDec == Cipher.DECODE) {
			super.setDecoded(reduceShift(super.getEncoded(), shift));
		} else {
			super.setEncoded(applyShift(this.getDecoded(), shift));
		}

	}

	/**
	 * @param decoded String that is in plain text to be encoded
	 * @param shift int shift that will be used to encode plaintext
	 * @return Returns a String that he been encoded
	 */
	private String applyShift(String decoded, int shift) {
		//must assign a value to the string to be empty that way does 
		//not add on to "null"
		String encoded = "";
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

	/**
	 * @param encoded String of encoded cipher text 
	 * @param shift int shift to move cipher text back
	 * @return
	 */
	private String reduceShift(String encoded, int shift) {
		String decoded = "";
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
