/**
 * Inicio del programa.
 * 
 * @author Daniel Corvalán 
 * @version 1.0
 */
public class Inicio
{
  public static void main(String[] args) {
    
    Cliente cliente = new Cliente("17399074K", 7456);
    cliente.abrirCuentaCorriente();
    cliente.abrirTarjetaCredito();
    System.out.println(cliente.getCuentaCorriente() + " " + cliente.getCuentaCorriente().getSaldo());
    System.out.println(cliente.getTarjetaCredito() + " Saldo disponible:" + cliente.getTarjetaCredito().getSaldo()
                         + " Cupo: " + cliente.getTarjetaCredito().getCupo());

  }
}
