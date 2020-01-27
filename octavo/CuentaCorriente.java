package octavo;

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
  
  public void pagar(int pago) {
    if (this.costo >= pago) {
      this.costo += pago;
    } else {
      System.out.println("El pago excede la deuda.");
    }
  }
  
  public void abonar(int abono) {
    this.saldo += abono;
  }
  
  public void retirar(int dinero) {
    if (this.saldo >= dinero) {
      this.saldo += dinero;
    } else {
      System.out.println("No tienes suficientes fondos.");
    }
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
  
  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }
  
  public String getNumeroCuenta() {
	  return this.numeroCuenta;
  }
  
  public String toString() {
    return "<Cuenta corriente: " + this.numeroCuenta + ">";
  }
}