package com.rossos.cryptography;

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
	// All ciphers have these 3 variables in-common
	public Cipher (int encOrDec, String phrase) {
		this.encOrDec = encOrDec;
		if (encOrDec == Driver.DECODE) 
			encoded = phrase;
		else
			decoded = phrase;
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
