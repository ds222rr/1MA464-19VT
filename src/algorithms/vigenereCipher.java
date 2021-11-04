package algorithms;

import java.util.Scanner;

public class vigenereCipher {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter option (e)ncryption or (d)ecryption: ");
		String option = sc.next();
		System.out.print("Enter key: ");
		String key = sc.next();
		int [] keyArray = new int[key.length()];
		for (int i = 0; i < key.length(); i ++) {
			char c = key.charAt(i);
			int temp = (int) c - 97;
			keyArray[i] = temp;
		}
		System.out.print("Enter text: ");
		String text = sc.next();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			int j = i%key.length();
			char pc = text.charAt(i);
			int temp = (int) pc - 97;
			if (option.equals("e")) {
				temp = temp + keyArray[j];
			}
			if (option.equals("d")) {
				temp = temp - keyArray[j] + 26;
			}
			char cc = (char) ((temp%26) + 97);
			sb.append(cc);
		}
		System.out.print("Result: \n" + sb.toString());
		sc.close();
	}
}
