package vistas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import modelos.Alumno;
import modelos.Materia;
import modelos.MateriaEnum;
import servicios.AlumnoServicio;

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
		lista.addListaAlumnos(rut, nuevo);
		System.out.println(nuevo);
	}
	
	@Override
	public void agregarMateria() {
                this.scanner = new Scanner(System.in);
		System.out.print("Ingresa rut del alumno: ");
		String rut = this.scanner.nextLine();
		
		AlumnoServicio lista = AlumnoServicio.obtenerSingleton(new HashMap<String, Alumno>());
		Alumno alumno;
		if(lista.getListaAlumnos().containsKey(rut)) {
			alumno = lista.getListaAlumnos().get(rut);
                        
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
		if(lista.getListaAlumnos().containsKey(rut)) {
			alumno = lista.getListaAlumnos().get(rut);
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
		System.out.println(lista.getListaAlumnos());
	}
	
	@Override
	public void cargarDatos() {
                this.scanner = new Scanner(System.in);
		System.out.println("Ingresa la ruta en donde se encuentra el archivo notas.csv:");
		String file = this.scanner.nextLine();
		
		Map<String, Alumno> lista = new HashMap<String, Alumno>();
		
		String lectura = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			lectura = br.readLine();
			while(lectura!=null) {
				ArrayList<String> temp = new ArrayList<String>(Arrays.asList(lectura.split(",")));
				String rut = temp.get(0);
				String nombre = temp.get(1);
				MateriaEnum materia = MateriaEnum.valueOf(temp.get(2));
				double nota = Double.parseDouble(temp.get(3));
				
				if(lista.get(rut) != null) {
					Alumno alumno = lista.get(rut);
					alumno.addMaterias(materia);
					alumno.addNota(materia, nota);
					
				} else {
					Alumno alumno = new Alumno(rut, nombre, "", "");
					alumno.addMaterias(materia);
					alumno.addNota(materia, nota);
					lista.put(rut, alumno);
				}

				lectura = br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
		AlumnoServicio service = AlumnoServicio.obtenerSingleton();
                service.addListaAListaAlumnos(lista);
		System.out.println("Datos cargados correctamente");
	}

        @Override
        public void exportarDatos() {
                
        }
       
}
