package septimo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vendedor extends Persona {
	
	private ArrayList<Entrada> entradasVendidas = new ArrayList<Entrada>();
	private ArrayList<EntradaVIP> entradasVIPVendidas = new ArrayList<EntradaVIP>();

	public Vendedor(String rut, LocalDate fechaNacimiento, String nombre) {
		super(rut, fechaNacimiento, nombre);
		System.out.println("Vendedor creado");
	}
	
	public boolean vender(Cliente cliente, Evento evento) {
		if (cliente.edad() < evento.getEdadMinima()) {
			System.out.printf("%s no tiene la edad mínima para acceder a este evento%n", cliente.getNombre());
			return false;
		} else {
			Entrada entrada = new Entrada(20000, 1, cliente, this);
			evento.addListaEntradas(entrada);
			this.addEntradaVendida(entrada);
			cliente.addEntradaComprada(entrada);
			System.out.printf("Vendiendo entrada a cliente %s (%s) para evento %s%n", cliente.getNombre(), cliente.getRut(), evento.getNombre());
			return true;
		}
	}

	public String toString() {
		return String.format("Vendedor: %s", getNombre());
	}

	public ArrayList<Entrada> getEntradasVendidas() {
		return entradasVendidas;
	}

	public void addEntradaVendida(Entrada entradasVendidas) {
		this.entradasVendidas.add(entradasVendidas);
	}

	public ArrayList<EntradaVIP> getEntradasVIPVendidas() {
		return entradasVIPVendidas;
	}

	public void addEntradaVIPVendida(EntradaVIP entradasVIPVendidas) {
		this.entradasVIPVendidas.add(entradasVIPVendidas);
	}
	
	public int totalEntradasVendidas() {
		int normales = this.getEntradasVendidas().size();
		int especiales = this.getEntradasVIPVendidas().size();
		System.out.printf("El vendedor %s ha vendido:%n%d entradas normales%n%d entradas VIP%n", this.getNombre(), normales, especiales);
		return this.getEntradasVendidas().size() + this.getEntradasVIPVendidas().size();
	}
}
