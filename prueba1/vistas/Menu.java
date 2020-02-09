package vistas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;
import servicios.ArchivosServicio;

public class Menu extends MenuTemplate {
	
	@Override
	public void terminarPrograma() {
		System.exit(0);
	}
	
	@Override
	public void crearAlumno() {
                this.scanner = new Scanner(System.in);
		System.out.print("Ingresa RUT: ");
		String rut = this.scanner.nextLine();
		System.out.print("Ingresa nombre: ");
		String nombre = this.scanner.nextLine();
		System.out.print("Ingresa apellido: ");
		String apellido = this.scanner.nextLine();
		System.out.print("Ingresa dirección: ");
		String direccion = this.scanner.nextLine();
		Alumno nuevo = new Alumno(rut, nombre, apellido, direccion);
		AlumnoServicio lista = AlumnoServicio.obtenerSingleton();
                lista.crearAlumno(nuevo);
	}
	
	@Override
	public void agregarMateria() {
                this.scanner = new Scanner(System.in);
		System.out.print("Ingresa rut del alumno: ");
		String rut = this.scanner.nextLine();
		
		AlumnoServicio lista = AlumnoServicio.obtenerSingleton(new HashMap<String, Alumno>());
		Alumno alumno;
		if(lista.listarAlumnos().containsKey(rut)) {
			alumno = lista.listarAlumnos().get(rut);
                        
                        System.out.println("1.- " + MateriaEnum.MATEMATICAS);
                        System.out.println("2.- " + MateriaEnum.LENGUAJE);
                        System.out.println("3.- " + MateriaEnum.CIENCIA);
                        System.out.println("4.- " + MateriaEnum.HISTORIA);

                        System.out.print("Selecciona una Materia: ");
                        int opcion = Integer.parseInt(this.scanner.nextLine());
                        switch (opcion) {
                                case 1:
                                        alumno.addMaterias(MateriaEnum.MATEMATICAS);
                                        break;
                                case 2:
                                        alumno.addMaterias(MateriaEnum.LENGUAJE);
                                        break;
                                case 3:
                                        alumno.addMaterias(MateriaEnum.CIENCIA);
                                        break;
                                case 4:
                                        alumno.addMaterias(MateriaEnum.HISTORIA);
                                        break;
                                default:
                                        System.out.println("Opción no válida");
                        }
                        System.out.println("Materia ingresada exitosamente");
		} else {
			System.out.println("No existe un alumno con ese RUN");
		}
	}
	
	@Override
	public void agregarNotaPasoUno() {
                this.scanner = new Scanner(System.in);
		System.out.print("Ingresa rut del alumno: ");
		String rut = this.scanner.nextLine();
		
		AlumnoServicio lista = AlumnoServicio.obtenerSingleton(new HashMap<String, Alumno>());
		Alumno alumno;
		if(lista.listarAlumnos().containsKey(rut)) {
			alumno = lista.listarAlumnos().get(rut);
                        List<Materia> materias = alumno.getMaterias();
                        if(materias.size() > 0) {
                                System.out.println("Ingrese el número");
                                Map<Integer, Materia> mapamateria = new HashMap<>();
                                int i;
                                for(i = 0; i < materias.size(); i++) {
                                        System.out.println((i + 1) + ".- " + materias
                                                .get(i)
                                                .getNombre());
                                        mapamateria.put(i + 1, materias.get(i));    
                                }
                                int opcion = Integer.parseInt(this.scanner.nextLine()) - 1;
                                if(opcion >= 0 && opcion < i) {
                                        MateriaEnum materia = materias.get(opcion).getEnum();
                                        System.out.printf("Ingresa la nota del alumno: ");
                                        double nota = Double.parseDouble(this.scanner.nextLine());
                                        if (nota > 0 && nota <= 7.0) {
                                                alumno.addNota(materia, nota);
                                                System.out.println("Nota ingresada");
                                        } else {
                                                System.out.println("Nota fuera de rango");
                                        }
                                } else {
                                    System.out.println("Opción incorrecta. Inténtelo nuevamente");
                                }
                        } else {
                                System.out.println("El alumno no tiene materias registradas.");
                        }
		} else {
			System.out.println("No existe un alumno con ese RUN");
		}

                
		System.out.print("Seleccionar materia: ");
	}
	
	@Override
	public void listarAlumnos() {
		AlumnoServicio lista = AlumnoServicio.obtenerSingleton();
                if(lista.listarAlumnos().isEmpty()) {
                        System.out.println("No hay alumnos registrados");
                } else {
                        System.out.println(lista.listarAlumnos());
                }
	}
	
	@Override
	public void cargarDatos() {
                this.scanner = new Scanner(System.in);
		System.out.println("Ingresa la ruta en donde se encuentra el archivo notas.csv:");
		String file = this.scanner.nextLine();
		
                ArchivosServicio.cargarDatos(file);
	}

        @Override
        public void exportarDatos() {
                this.scanner = new Scanner(System.in);
		System.out.println("Ingresa la ruta en donde se encontrará el archivo promedios.txt:");
		String file = this.scanner.nextLine();
                
                AlumnoServicio service = AlumnoServicio.obtenerSingleton();
                ArchivosServicio.exportarDatos(service.listarAlumnos(), file);
        }
       
}
