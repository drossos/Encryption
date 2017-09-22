package com.rossos.cryptography;
import java.util.Scanner;

/**
 * @author Daniel Rossos
 *
 */
public class Vernam extends Cipher{
	private final int NUMBER_OF_BITS  = 7;
	private String key;
	private byte[]decodedArray;
	private byte[]keyArray;
	private byte [] encodedArray;
	//TODO currently only compares first bit on the decode, works on the decode
	/**
	 * Does not currently work and is abstract until fixed and working
	 * @param key 
	 * @param phrase 
	 */
	public Vernam(int encOrDec, String phrase, String key){
		super(encOrDec, phrase);
		this.key = key;
		
		if (encOrDec == Cipher.ENCODE){
			decodedArray = getDecoded().getBytes();
			keyArray = key.getBytes();
			encodedArray = xOr(decodedArray, keyArray);
			
			System.out.println("Decoded Message in Binary is:");
			for (byte x :decodedArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
			}
			System.out.println();
			System.out.println("Key in Binary is:");
			for (byte x :keyArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
			}
			System.out.println();
			System.out.println("The encrypted message is");
			for (byte x :encodedArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
			}
			System.out.println();
			
			
			
			 
		}
		if (encOrDec == Cipher.DECODE){
			encodedArray = parseEncodedString(getEncoded());
			keyArray = key.getBytes();
			decodedArray = xOr(encodedArray, keyArray);
			
			//TODO make this line splitter better and more versatile
			String [] bits = getEncoded().split(" ");
			byte [] codedBits = new byte[bits.length];
			for (int i  = 0; i < bits.length; i++){
				codedBits[i] = (byte) Integer.parseInt(bits[i],2);
			}
			byte[] decoded = xOr(codedBits, keyArray);
			
			System.out.println("Key in Binary is:");
			for (byte x :keyArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
				System.out.print("\t\t");
			}
			System.out.println();
			System.out.println("The decrypted message is");
			for (byte x :decoded){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
				System.out.print("\t\t");
		}
			System.out.println();
		}
		
	}

	private byte[] parseEncodedString(String encoded) {
		int count = 0;
		byte[] temp = new byte[encoded.length()/NUMBER_OF_BITS];
		for (int i  = 0; i < encoded.length(); i+=8) {
			String str = "";
			for (int j = 0; j < NUMBER_OF_BITS+1; j++) {
				str += ""+ encoded.charAt(j);
			}
			temp[count] = (byte) Integer.parseInt(str);
			count++;
		}
		return temp;
	}

	private String formatNumBit(String binaryString) {
		StringBuffer str = new StringBuffer(binaryString);
		for(int n=str.length(); n<NUMBER_OF_BITS; n++) {
            str.insert(0, "0");
            }
		binaryString = str.toString();
		return binaryString;
	}

	private byte[] xOr(byte[] decodedArray, byte[] keyArray) {
		byte [] product = new byte [decodedArray.length];
		for (int i = 0; i < product.length; i++){
			product[i] = (byte) (decodedArray[i]^keyArray[i]);
			
		}
		return (product);
	}

	private byte[] reverseArray(byte[] product) {
		byte [] reverse = new byte [product.length];
		int count = 0;
		for (int i  = product.length-1; i>= 0; i--){
			reverse[count] = product[i];
			count++;
		}
		return reverse;
	}
	
	
	
}
