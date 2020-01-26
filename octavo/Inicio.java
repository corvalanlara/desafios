import java.util.Scanner;
import java.util.ArrayList;

/**
 * Inicio del programa.
 * 
 * @author Daniel Corvalán 
 * @version 1.0
 */
public class Inicio {
  
  /**
   * Devuelve -1 si no se encuentra el Cliente. De otra manera, devuelve su posición en la ArrayList.
   */ 
  public static int buscar(String rut, int clave, ArrayList<Cliente> listaClientes) {
    for(Cliente cliente: listaClientes) {
      if(cliente.getRut().equals(rut) && cliente.getClave() == clave) {
        return listaClientes.indexOf(cliente);
      }
    }
    return -1;
  }
  
  public static void main(String[] args) {
    
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
    Cliente cliente = new Cliente("17399074K", "Daniel Corvalán", 7777);
    listaClientes.add(cliente);
    cliente.abrirCuentaCorriente();
    cliente.abrirTarjetaCredito();
    cliente.getCuentaCorriente().abonar(220000);
    
    boolean sesion = false;
    boolean ingreso = false;
    String rut;
    String clave;
    Cliente usuario;
      
    Scanner input = new Scanner(System.in);
    
    while(ingreso == false) {
      System.out.println("Ingrese rut");
      rut = input.nextLine();
      System.out.println("Ingrese clave de acceso");
      clave = input.nextLine();
      int ubicacion = buscar(rut, Integer.parseInt(clave), listaClientes);
      if(ubicacion != -1) {
        usuario = listaClientes.get(ubicacion);
        System.out.println("Bienvenido, " + usuario.getNombre());
        ingreso = true;
        sesion = true;
      } else {
        System.out.println("Combinación incorrecta");
      }
    }
    
    while(sesion) {
      sesion = false;
    }

  }
}
