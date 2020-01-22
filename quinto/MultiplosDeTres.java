package quinto;

import java.util.ArrayList;

public class MultiplosDeTres {

	public static void main(String[] args) {
		ArrayList<Integer> multiplos = filtro(args);
		suma(multiplos);
		promedio(multiplos);
	}
	
	private static ArrayList<Integer> filtro(String[] args) {
		ArrayList<Integer> multiplos = new ArrayList<Integer>();
		for(int i = 0; i < args.length; i++) {
			int num = Integer.parseInt(args[i]);
			if (num % 3 == 0) {
				multiplos.add(num);
			}
		}
		return multiplos;
	}
	
	private static void suma(ArrayList<Integer> numeros) {
		int suma = 0;
		for(int numero: numeros)
			suma += numero;
		System.out.println(suma);
	}
	
	private static void promedio(ArrayList<Integer> numeros) {
		int suma = 0;
		for(int numero: numeros)
			suma += numero;
		System.out.println(suma/numeros.size());
	}

}
