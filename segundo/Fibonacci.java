package segundo;

import java.util.Scanner;

public class Fibonacci {
	
	public static int fibo(int n) {
		if (n < 0) {
			throw new java.lang.RuntimeException("WHAT THE FUCK!");
		} else if (n == 0) {
			return 0;
		} else if (n == 1) {
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int usuario = sc.nextInt();
		sc.close();
		
		for(int i = 0; i < usuario; i++) {
			System.out.println(fibo(i));
		}
		

	}

}
