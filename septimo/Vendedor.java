package septimo;

import java.time.LocalDate;

public class Vendedor extends Persona {
	
	int entradasVendidas;
	int entradasVIPVendidas;

	public Vendedor(String rut, LocalDate fechaNacimiento, String nombre) {
		super(rut, fechaNacimiento, nombre);
		System.out.println("Vendedor creado");
	}

	public String toString() {
		return String.format("Vendedor: %s", this.nombre);
	}
}
