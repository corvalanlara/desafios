package cuarto;

import java.util.Scanner;

public class Patrones {

	public static void main(String[] args) {
		System.out.println("Elige el patrón a imprimir");
		System.out.println("1: *.");
		System.out.println("2: 1234");
		System.out.println("3: ||*");
		System.out.print("> ");
		
		Scanner input = new Scanner(System.in);
		int opcion = input.nextInt();
		
		while (opcion > 3 || opcion < 1) {
			System.out.println("La opción es incorrecta. Ingrese nuevamente.");
			System.out.print("> ");
			opcion = input.nextInt();
		}
		
		String patron;
		
		if(opcion == 1) {
			patron = "*.";
		} else if (opcion == 2) {
			patron = "1234";
		} else if (opcion == 3) {
			patron = "||*";
		} else {
			input.close();
			throw new java.lang.RuntimeException("WHAT THE FUCK!");
		}
		
		System.out.println("¿Cuántas veces se debe imprimir?");
		System.out.println("> ");
		
		int veces = input.nextInt();
		
		while (veces <= 0) {
			System.out.println("La opción es incorrecta. Ingrese nuevamente.");
			System.out.print("> ");
			veces = input.nextInt();
		}
		
		input.close();
		
		String f = "";
		for(int i = 0; i < veces; i++) {
			f = f + patron;
		}
		
		//Limitado a carácteres
		String g = f.substring(0, veces);
		System.out.println(g);

	}

}
