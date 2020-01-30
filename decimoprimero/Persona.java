package decimoprimero;

public class Persona {

	String nombre;
	String correo;
	String ciudad;
	int monto;
	
	public Persona(String nombre, String correo, String ciudad, int monto) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.ciudad = ciudad;
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", correo=" + correo + ", ciudad=" + ciudad + ", monto=" + monto + "]";
	}

	public int getMonto() {
		return monto;
	}

	
}
