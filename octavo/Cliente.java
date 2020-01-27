package octavo;

public class Cliente {
  
  String rut;
  String nombre;
  CuentaCorriente cuentaCorriente;
  TarjetaCredito tarjetaCredito;
  int clave;
  
  public Cliente(String rut, String nombre, int clave) {
    this.nombre = nombre;
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
  
  public String getNombre() {
    return this.nombre;
  }
  
  public int getClave() {
    return this.clave;
  }
  
  public String getRut() {
    return this.rut;
  }
  
  public String toString() {
    return "<Cliente: " + this.nombre + ">";
  }
}