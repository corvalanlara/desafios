package noveno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

	public static int Inicio() {
		int num;
		
		while(true) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("¿Qué deseas hacer?");
		System.out.println("1.- Ver productos disponibles");
		System.out.println("2.- Ingresar ítem al carrito");
		System.out.println("3.- Procesar compra");
		System.out.println("4.- Salir");
		
		num = sc.nextInt();
		
			if(num > 0 && num < 5) {
				break;
			}
		}
		
		return num;
				
	}
	
	public static void ingresarItems(ArrayList<Articulo> stock, ArrayList<Articulo> carrito) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa el código del producto a ingresar");
		int codigo = sc.nextInt();
		
		Articulo unico = stock.stream().filter(n -> n.codigo == codigo).findAny().get();
		carrito.add(unico);
		System.out.println(carrito);
	}
	
	public static boolean metodoPago(ArrayList<Articulo> carrito) {
		int num;
		
		while(true) {
			Scanner sc = new Scanner(System.in);

			System.out.println("Elije método de pago");
			System.out.println("1.- Crédito");
			System.out.println("2.- Débito");
		
			num = sc.nextInt();
		
			if(num > 0 && num < 3) {
				break;
			}
		
		
		}
			if (num == 1) {
				return true;
			} else {
				return false;
			}
		
	}
	
		
	
}
