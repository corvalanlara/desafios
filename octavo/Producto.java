import java.util.UUID;
import java.lang.RuntimeException;

public class Producto {
  
  protected String numeroCuenta;
  protected int saldo;
  
  public String generarCuenta(String rut, Object object) {
    String code;
    if (object.getClass().getName() == "TarjetaCredito") {
      code = "01-";
    } else if (object.getClass().getName() == "CuentaCorriente") {
      code = "00-";
    } else {
      throw new RuntimeException("¡No existe ese producto!");
    }
    return code + rut.substring(0, rut.length() - 1);
  }
  
}