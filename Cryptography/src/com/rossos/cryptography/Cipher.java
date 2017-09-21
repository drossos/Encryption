package com.rossos.cryptography;

/**
 * @author Daniel Rossos
 *
 */
public abstract class Cipher {
	/*
	 * Daniel Rossos 9/19/2017
	 * This design was made at a later date re-hauling 
	 * some cipher algorithms to make into a more functional
	 * program
	 * 
	 */
	private String decoded;
	private String encoded;
	private int encOrDec;
	public static final int DECODE = 1;
	public static final int ENCODE = 0;
	// All ciphers have these 3 variables in-common
	/**
	 * @param encOrDec int deciding to encode (0) or decode (1)
	 * @param phrase String for encoding or decoding
	 */
	public Cipher (int encOrDec, String phrase) {
		this.encOrDec = encOrDec;
		if (encOrDec == DECODE) {
			encoded = phrase;
			decoded = "";
		}
		else {
			decoded = phrase;
			encoded = "";
		}
	}
	
	public String getDecoded() {
		return decoded;
	}

	public void setDecoded(String decoded) {
		this.decoded = decoded;
	}

	public String getEncoded() {
		return encoded;
	}

	public void setEncoded(String encoded) {
		this.encoded = encoded;
	}

	public int getEncOrDec() {
		return encOrDec;
	}

	public void setEncOrDec(int encOrDec) {
		this.encOrDec = encOrDec;
	}

}
