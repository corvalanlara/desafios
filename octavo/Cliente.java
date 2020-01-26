public class Cliente {
  
  String rut;
  
  CuentaCorriente cuentaCorriente;
  TarjetaCredito tarjetaCredito;
  int clave;
  
  public Cliente(String rut, int clave) {
    this.rut = rut;
    this.clave = clave;
  }
  
  public void abrirCuentaCorriente() {
    this.cuentaCorriente = new CuentaCorriente(this.rut);
  }
  
  public void abrirTarjetaCredito() {
    this.tarjetaCredito = new TarjetaCredito(this.rut);
  }
  
  public CuentaCorriente getCuentaCorriente() {
    return this.cuentaCorriente;
  }
  
  public TarjetaCredito getTarjetaCredito() {
    return this.tarjetaCredito;
  }
}