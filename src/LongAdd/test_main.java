package LongAdd;

import java.util.Scanner;

public class test_main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String strA,strB;
		
		System.out.println("Input the first LongNum:");
		strA = in.nextLine();
		
		System.out.println("Input the Second LongNum:");
		strB = in.nextLine();
		
		LongInt strC = null;
		System.out.println(strC.LongAdd(strA, strB));	
	}
}
