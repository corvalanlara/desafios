package octavo;

import java.lang.RuntimeException;

public class Producto {
  
  protected String numeroCuenta;
  protected int saldo;
  
  public String generarCuenta(String rut, Object object) {
    String code;
    System.out.println(object.getClass().getSimpleName());
    if (object.getClass().getSimpleName().equals("TarjetaCredito")) {
      code = "01-";
    } else if (object.getClass().getSimpleName().equals("CuentaCorriente")) {
      code = "00-";
    } else {
      throw new RuntimeException("¡No existe ese producto!");
    }
    return code + rut.substring(0, rut.length() - 1);
  }
  
}