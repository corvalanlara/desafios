package noveno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		ArrayList<Articulo> carrito = new ArrayList<Articulo>();
		carrito.add(new Polera("Variant Rojo", 9000, 2002, 29, "Variant", "Rojo"));
		carrito.add(new Polera("Variant Verde", 8000, 2002, 29, "Variant", "Verde"));
		System.out.println(carrito);
		
		int total = carrito.stream().mapToInt(n -> n.precio).sum();
		System.out.println(total);
		
		boolean credito = true; //false if debito
		
		if (credito == true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("¿Cuántas cuotas?");
			int cuotas = sc.nextInt();
			
			System.out.println(total / cuotas);
			Orden orden = new Orden("Melipilla", "Daniel", carrito, total, LocalDateTime.now());
			System.out.println(orden);
			
		} else {
			Orden orden = new Orden("Melipilla", "Daniel", carrito, total, LocalDateTime.now());
			System.out.println(orden);
			
		}
		

		

	}

}
