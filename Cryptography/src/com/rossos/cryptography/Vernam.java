package com.rossos.cryptography;
import java.util.Scanner;

/**
 * @author Daniel Rossos
 *
 */
public abstract class Vernam {
	private int NUMBER_OF_BITS  = 7;
	//TODO something wrong with comparing each bit by bit to create product
	/**
	 * Does not currently work and is abstract until fixed and working
	 */
	public Vernam(int choice){
		Scanner keyboard  = new Scanner(System.in);
		if (choice == Cipher.ENCODE){
			System.out.println("Enter decoded message: ");
			String decoded = keyboard.nextLine().trim().toUpperCase();
			System.out.println("Enter in the key of equal length");
			String key = keyboard.nextLine().trim().toUpperCase();
			
			byte[]decodedArray = decoded.getBytes();
			byte[]keyArray = key.getBytes();
			byte [] encodedArray = xOr(decodedArray, keyArray);
			
			System.out.println("Decoded Message in Binary is:");
			for (byte x :decodedArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
				System.out.print("\t\t\t");
			}
			System.out.println();
			System.out.println("Key in Binary is:");
			for (byte x :keyArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
				System.out.print("\t\t\t");
			}
			System.out.println();
			System.out.println("The encrypted message is");
			for (byte x :encodedArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
				System.out.print("\t\t\t");
			}
			System.out.println();
			
			
			
			 
		}
		if (choice == Cipher.DECODE){
			System.out.println("Enter in encoded message. Make sure it is only 1s and 0s and have a space seperating each character.");
			String encoded = keyboard.nextLine().trim();
			System.out.println("Enter in the key");
			byte[]keyArray = keyboard.nextLine().trim().toUpperCase().getBytes();
			//TODO make this line spliter better and more versatiel
			String [] bits = encoded.split(" ");
			byte [] codedBits = new byte[bits.length];
			for (int i  = 0; i < bits.length; i++){
				codedBits[i] = (byte) Integer.parseInt(bits[i],2);
			}
			byte[] decoded = xOr(codedBits, keyArray);
			
			System.out.println("Key in Binary is:");
			for (byte x :keyArray){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
				System.out.print("\t\t\t");
			}
			System.out.println();
			System.out.println("The decrypted message is");
			for (byte x :decoded){
				System.out.print(formatNumBit(Integer.toBinaryString(x)));
				System.out.print("\t\t\t");
		}
			System.out.println();
		}
		
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
		int count  = 0;
		byte [] product = new byte [decodedArray.length];
		for (int i = decodedArray.length-1; i >= 0; i--){
			product[i] = (byte) (decodedArray[count]^keyArray[count]);
			count ++;
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
