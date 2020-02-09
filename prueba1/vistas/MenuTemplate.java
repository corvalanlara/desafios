package vistas;

import java.util.HashMap;
import java.util.Scanner;
import modelos.Alumno;
import servicios.AlumnoServicio;

public abstract class MenuTemplate {
	protected Scanner scanner;
	
	protected MenuTemplate() {
		super();
		this.scanner = new Scanner(System.in);;
	}

	public void cargarDatos() {
	}            
	             
	public void exportarDatos() {
	}
	
	public void crearAlumno() {
	}
	
	public void agregarMateria() {
	}
	
	public void agregarNotaPasoUno() {
	}
	
	public void listarAlumnos() {
	}
	
	public void terminarPrograma() {
	}
	
	public void iniciarMenu() {
		this.scanner = new Scanner(System.in);
                AlumnoServicio lista = AlumnoServicio.obtenerSingleton(new HashMap<String, Alumno>());
			while(true) {
				System.out.println("Menu Principal:");
				System.out.println("1.- Crear Alumnos");
				System.out.println("2.- Listar Alumnos");
				System.out.println("3.- Agregar Materias");
				System.out.println("4.- Agregar Notas");
				System.out.println("5.- Cargar Datos");
				System.out.println("6.- Exportar Datos");
				System.out.println("7.- Salir");
				System.out.print("Selección: ");
				int opcion = this.scanner.nextInt();
				
				switch(opcion) {
					case 1:
						crearAlumno();
						break;
					case 2:
						listarAlumnos();
						break;
					case 3:
						agregarMateria();
						break;
					case 4:
						agregarNotaPasoUno();
						break;
					case 5:
						cargarDatos();
						break;
					case 6:
						exportarDatos();
						break;
					case 7:
						terminarPrograma();
						break;
					default:
						System.out.println("Número incorrecto. Intenta nuevamente.");
						break;
				}
		}
	}
	
}
