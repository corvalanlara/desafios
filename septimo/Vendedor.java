package septimo;

import java.time.LocalDate;

public class Vendedor extends Persona {
	
	private int entradasVendidas;
	private int entradasVIPVendidas;

	public Vendedor(String rut, LocalDate fechaNacimiento, String nombre) {
		super(rut, fechaNacimiento, nombre);
		System.out.println("Vendedor creado");
	}

	public String toString() {
		return String.format("Vendedor: %s", getNombre());
	}

	public int getEntradasVendidas() {
		return entradasVendidas;
	}

	public void setEntradasVendidas(int entradasVendidas) {
		this.entradasVendidas = entradasVendidas;
	}

	public int getEntradasVIPVendidas() {
		return entradasVIPVendidas;
	}

	public void setEntradasVIPVendidas(int entradasVIPVendidas) {
		this.entradasVIPVendidas = entradasVIPVendidas;
	}
	
}
