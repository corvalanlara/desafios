import java.util.Scanner;
import java.util.ArrayList;

public class Menu {
  
  public static void Inicio() {
    System.out.println("¿Qué deseas hacer?");
    System.out.println("1.- Menú cuenta corriente");
    System.out.println("2.- Menú tarjeta de crédito");
    System.out.println("3.- Salir");
  }  
  
  public static void CuentaCorriente() {
    System.out.println("¿Qué deseas hacer?");
    System.out.println("1.- Retirar dinero");
    System.out.println("2.- Pagar mi deuda");
    System.out.println("3.- Volver al menú inicial");
  }
  
  public static void TarjetaCredito() {
    System.out.println("¿Qué deseas hacer?");
    System.out.println("1.- Pagar mi deuda");
    System.out.println("2.- Volver al menú inicial");
  }
  
  public static void Salir() {
    System.out.println("Cerrando sesión");
    System.out.println("Hasta luego");
  }
  
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
  
  public static void Login(ArrayList<Cliente> listaClientes) {
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
        MenuInicial(usuario);
        ingreso = true;
        continue;
      } else {
        System.out.println("Combinación incorrecta");
      }
    }
    
  }
  
    public static void MenuInicial(Cliente usuario) {
      int menu;
      boolean sesion = true;
      Scanner menut = new Scanner(System.in);
      
      while(sesion) {
      Menu.Inicio();
      menu = menut.nextInt();
      if(menu == 3) {
         Menu.Salir();
         sesion = false;
         continue;
      } else if (menu == 1) {
        MenuCuentaCorriente(usuario);
        break;
      } else if (menu == 2) {
        MenuTarjetaCredito(usuario);
        break;
      } else {
        System.out.println("Opción incorrecta. Elija nuevamente.");
      }

    }
  }
    
   public static void MenuCuentaCorriente(Cliente usuario) {
      int menu;
      boolean sesion = true;
      Scanner menut = new Scanner(System.in);
      
      while(sesion) {
      Menu.CuentaCorriente();
      menu = menut.nextInt();
      if(menu == 3) {
         MenuInicial(usuario);
        sesion = false;
        continue;
      } else if (menu == 1) {
        
      } else if (menu == 2) {
        
      } else {
        System.out.println("Opción incorrecta. Elija nuevamente.");
      }

    }
  }
   
    public static void MenuTarjetaCredito(Cliente usuario) {
      int menu;
      boolean sesion = true;
      Scanner menut = new Scanner(System.in);
      
      while(sesion) {
      Menu.TarjetaCredito();
      menu = menut.nextInt();
      if(menu == 2) {
        MenuInicial(usuario);
        sesion = false;
        continue;
      } else if (menu == 1) {
        System.out.println(usuario.getTarjetaCredito());
      } else {
        System.out.println("Opción incorrecta. Elija nuevamente.");
      }

    }
  }
  
}