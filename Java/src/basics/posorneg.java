package basics;

import java.util.Scanner;

public class posorneg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter no: ");
		int n = scan.nextInt();
		scan.close();
		
		int a = n>>31;
		if (n==0)
			System.out.println("neither positive nor negative");
		else if ((a&1)==0)
			System.out.println("given no is positive");
		else
			System.out.println("negative");
	}

}
