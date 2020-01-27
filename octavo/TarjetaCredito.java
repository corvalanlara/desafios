public class TarjetaCredito extends Producto {
  
  private int cupo;
  private int deuda;
  
  public TarjetaCredito() {
    super();
  }
  
  public TarjetaCredito(String rut) {
    this.numeroCuenta = generarCuenta(rut, this);
    this.saldo = 0;
    this.deuda = 0;
    this.cupo = 250000;
  }
  
  public void pagar(int pago) {
    if (this.deuda < pago) {
      System.out.println("El pago igual o menor a la deuda total");
    } else if (this.deuda > pago) {
      this.deuda -= pago;
    } else {
      this.deuda = 0;
    }
  }
  
  public int getSaldo() {
    return this.saldo;
  }
  
  public int getCupo() {
    return this.cupo;
  }
  
  public int getDeuda() {
    return this.deuda;
  }
  
  public void setSaldo(int saldo) {
    this.saldo = saldo;
  }
  
  public void setCupo(int cupo) {
    this.cupo = cupo;
  }
  
  public void setDeuda(int deuda) {
    this.deuda = deuda;
  } 
  
  public String toString() {
    return "<Tarjeta de crédito: " + this.numeroCuenta + ">";
  }
}