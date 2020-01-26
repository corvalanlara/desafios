public class CuentaCorriente extends Producto {
  
  int costo;
  
  public CuentaCorriente() {
    super();
  }
  
  public CuentaCorriente(String rut) {
    this.numeroCuenta = generarCuenta(rut, this);
    this.saldo = 0;
    this.costo = 15000;
  }
  
  public int getSaldo() {
    return this.saldo;
  }
  
  public int getCosto() {
    return this.costo;
  }
  
  public void setCosto(int costo) {
    this.costo = costo;
  }
  
  public void setSaldo(int saldot) {
    this.saldo = saldo;
  }
  
  public String toString() {
    return "<Cuenta corriente: " + this.numeroCuenta + ">";
  }
}