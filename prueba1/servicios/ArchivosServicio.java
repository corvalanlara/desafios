package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelos.Alumno;
import modelos.MateriaEnum;

public class ArchivosServicio {
	PromedioServicioImp promedioServicioImp;
	List<?> alumnosACargar;
	
	public static Map<String, Alumno> cargarDatos(String ruta) {
                File file = new File(ruta);
                Map<String, Alumno> lista = new HashMap<>();
		
		String lectura = "";
                if(file.isFile()) {
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
                        
                        System.out.println("Datos cargados correctamente");
                } else {
                        System.out.println("El archivo no existe");
                }
                
		AlumnoServicio service = AlumnoServicio.obtenerSingleton();
                service.addListaAListaAlumnos(lista);
                return lista;
	}
	
	public static void exportarDatos(Map<String, Alumno> alumnos, String ruta) {
		File archivo = new File(ruta);
                if(archivo.isDirectory())
                        ruta += "promedios.txt";
                List<Alumno> lista = new ArrayList<>(alumnos.values());
                Map<Alumno, Map<MateriaEnum, Double>> listaPromedios = new HashMap<>();
                for(Alumno alumno: lista) {
                    listaPromedios.put(alumno, alumno.getPromedios());
                }
                System.out.println(listaPromedios);
	}
}
