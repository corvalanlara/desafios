package octavo;

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
  
  public static void PagarDeudaTarjeta() {
	    System.out.println("¿Qué deseas hacer?");
	    System.out.println("1.- Pagar deuda completa");
	    System.out.println("2.- Pagar otro monto"); 
	    System.out.println("3.- Volver al menú anterior"); 
  }
  
  public static void Salir() {
    System.out.println("Cerrando sesión");
    System.out.println("Hasta luego");
  }
  
  public static void EstadoCuenta(Cliente cliente) {
	  CuentaCorriente cuenta = cliente.getCuentaCorriente();
	  System.out.println("Cuenta n° " + cuenta.getNumeroCuenta());
	  System.out.println("Saldo disponible: " + cuenta.getSaldo());
	  System.out.println("Deuda: " + cuenta.getCosto());
  }
  
  public static void EstadoTarjeta(Cliente cliente) {
	  TarjetaCredito cuenta = cliente.getTarjetaCredito();
	  System.out.println("Cuenta n° " + cuenta.getNumeroCuenta());
	  System.out.println("Saldo disponible: " + cuenta.getSaldo());
	  System.out.println("Deuda: " + cuenta.getDeuda());
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
         System.exit(0);
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
      Menu.EstadoCuenta(usuario);
      Menu.CuentaCorriente();
      menu = menut.nextInt();
      
      if(menu == 3) {
         MenuInicial(usuario);
        sesion = false;
        continue;
      } else if (menu == 1) {
        MenuRetiroDinero(usuario);
        continue;
      } else if (menu == 2) {
        MenuPagarDeuda(usuario);
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
      Menu.EstadoTarjeta(usuario);
      Menu.TarjetaCredito();
      menu = menut.nextInt();

      if(menu == 2) {
        MenuInicial(usuario);
        sesion = false;
        continue;
      } else if (menu == 1) {
        MenuPagarDeudaTarjeta(usuario);
      } else {
        System.out.println("Opción incorrecta. Elija nuevamente.");
      }

    }
      

  }
    
    public static void MenuRetiroDinero(Cliente usuario) {
        int menu;
        boolean sesion = true;
        Scanner menut = new Scanner(System.in);
        CuentaCorriente cuenta = usuario.getCuentaCorriente();
        int saldo = cuenta.getSaldo();
        
        System.out.println("¿Cuánto desea retirar? (0 para cancelar)");
        menu = menut.nextInt();
        if(menu == 0) {
        	
        } else if (menu > 0 && menu <= saldo) {
        	cuenta.setSaldo(saldo - menu);
        	System.out.println("Dinero retirado, volviendo al menú de cuenta corriente");
        } else {
        	 System.out.println("Saldo insuficiente. Intente con otro monto.");
        }


    }
    
    public static void MenuPagarDeuda(Cliente usuario) {
    	CuentaCorriente cuenta = usuario.getCuentaCorriente();
    	int deuda = cuenta.getCosto();
    	int saldo = cuenta.getSaldo();
    	if(deuda > 0) {
    		if(saldo >= deuda) {
    			cuenta.setSaldo(saldo - deuda);
    			cuenta.setCosto(0);
    			System.out.println("Su deuda ha sido pagada. Volviendo al Menú Cuenta Corriente");
    		} else {
    			System.out.println("No es posible cancelar la deuda");
    		
    		}
    	} else {
    		System.out.println("No existe deuda alguna.");
    	}
    	
    }
    
    public static void MenuPagarDeudaTarjeta(Cliente usuario) {
        int menu;
        boolean sesion = true;
        Scanner menut = new Scanner(System.in);

        while(sesion) {
        Menu.PagarDeudaTarjeta();
        menu = menut.nextInt();

        if(menu == 3) {
          MenuTarjetaCredito(usuario);
          sesion = false;
          continue;
        } else if (menu == 1) {
        	MenuPagarDeudaTotalTarjeta(usuario);
        } else if(menu == 2) {
        	MenuPagarDeudaParcialTarjeta(usuario);
        }

      }
    	
    }
    
    public static void MenuPagarDeudaTotalTarjeta(Cliente usuario) {
    	TarjetaCredito cuenta = usuario.getTarjetaCredito();
    	int deuda = cuenta.getDeuda();
    	int saldo = cuenta.getSaldo();

      	if(deuda > 0) {
  			if(saldo >= deuda) {
  				cuenta.setSaldo(saldo - deuda);
  				cuenta.setDeuda(0);
  				System.out.println("Su deuda ha sido pagada. Volviendo al Menú anterior.");
  			} else {
  				System.out.println("No tienes suficiente saldo para cancelar la deuda");
  			}
  		} else {
  			System.out.println("No existe deuda alguna.");
  		}
    	
    }
    
    public static void MenuPagarDeudaParcialTarjeta(Cliente usuario) {
        int menu;
        boolean sesion = true;
        Scanner menut = new Scanner(System.in);
    	TarjetaCredito cuenta = usuario.getTarjetaCredito();
    	int deuda = cuenta.getDeuda();
    	int saldo = cuenta.getSaldo();

        while(sesion) {
        System.out.println("¿Qué monto deseas aplicar a tu deuda?");
        menu = menut.nextInt();

      	if(deuda > 0) {
  			if(saldo >= menu) {
  				cuenta.setSaldo(saldo - menu);
  				cuenta.setDeuda(deuda - menu);
  				System.out.println("Su deuda ha sido pagada parcialmente. Volviendo al Menú anterior.");
  	          sesion = false;
  	          continue;
  			} else {
  				System.out.println("No tienes suficiente saldo para cancelar la deuda");
  	          sesion = false;
  	          continue;
  			}
  		} else {
  			System.out.println("No existe deuda alguna.");
            sesion = false;
            continue;
  		}

      }
    	
    }
  
}