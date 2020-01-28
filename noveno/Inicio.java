package noveno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Inicio {

	public static void main(String[] args) {
		ArrayList<Articulo> stock = new ArrayList<Articulo>();
		stock.add(new Polera("Variant Rojo", 9000, 2002, 29, "Variant", "rojo"));
		stock.add(new Polera("Variant Verde", 8000, 2002, 29, "Variant", "verde"));
		stock.add(new Pantalon("Variant Caqui Corto", 15000, 1000, 30, "Variant", "caqui", 2));
		stock.add(new Pantalon("Variant Caqui Corto", 15000, 1000, 30, "Variant", "caqui", 2));
		stock.add(new Pantalon("Variant Negro Largo", 19000, 1001, 30, "Variant", "negro", 2));
		stock.add(new Zapatos("Mega CZ50", 23000, 3003, 34, "Mega", "CZ50"));
		stock.add(new Zapatos("Mega CX50", 20000, 3004, 40, "Mega", "CX50"));
		System.out.println(stock);
		
		ArrayList<Articulo> carrito = new ArrayList<Articulo>();
		
		while (true) {
		int respuesta = Menu.Inicio();
		System.out.println(respuesta);
		
		switch (respuesta) {
			case 1:
				for (Articulo item: stock) {
					System.out.println(item);
				}
				break;
			case 2:
				Menu.ingresarItems(stock, carrito);
				break;
			case 3:
				int total = carrito.stream().mapToInt(n -> n.precio).sum();
				System.out.println(total);
				
				boolean credito = Menu.metodoPago(carrito);
				
				Scanner input = new Scanner(System.in);
				
				System.out.println("¿Cuál es su nombre?");
				String nombre = input.nextLine();
				
				System.out.println("¿Cuál es su dirección?");
				String direccion = input.nextLine();
				if (credito == true) {
					
					System.out.println("¿Cuántas cuotas?");
					String cuotas = input.nextLine();
					
					System.out.println("Cuotas de " + (total / Integer.parseInt(cuotas)));
					
					Orden orden = new Orden(direccion, nombre, carrito, total, LocalDateTime.now());
					System.out.println(orden);
					
				} else {
					Orden orden = new Orden(direccion, nombre, carrito, total, LocalDateTime.now());
					System.out.println(orden);
					
				}
				System.out.println("Muchas gracias por su compra");
				System.exit(0);
				break;
			case 4:
				System.out.println("¡Adios!");
				System.exit(0);
			}
		}

		
	}

}
