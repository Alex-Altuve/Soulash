
package Model;
import java.time.LocalDate;


public class Producto {
    private String Nombre;
    private String Codigo;
    private float Precio;
    private float Costo;
    private int NumVendidas;
    private int NumExistencia;
    private int Lote;
    private String FechaVencimiento;
    private int Dia;
    private int Mes;
    private int Año;
    private String Oferta;

    
    
     LocalDate fecha = LocalDate.now();
    public Producto(String Oferta,String Nombre, String Codigo, float Precio, float Costo, int NumVendidas, int NumExistencia, int Lote, String FechaVencimiento, int Dia, int Mes, int Año) {
        this.Nombre = Nombre;
        this.Codigo = Codigo;
        this.Precio = Precio;
        this.Costo = Costo;
        this.NumVendidas = NumVendidas;
        this.NumExistencia = NumExistencia;
        this.Lote = Lote;
        this.FechaVencimiento = FechaVencimiento;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        this.Oferta=Oferta;
    }

    
 public Producto() {
        Nombre = "";
        Codigo = "";
        Precio = 0;
        Costo=0;
        NumExistencia = 0;
        NumVendidas=0;
        Lote = 0;
        FechaVencimiento = "";
        Dia = 0;
        Mes = 0;
        Año = 0;
        Oferta="";
    }

    public String getOferta() {
        return Oferta;
    }

    public void setOferta(String Oferta) {
        this.Oferta = Oferta;
    }
    
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }

    public float getCosto() {
        return Costo;
    }

    public void setCosto(float Costo) {
        this.Costo = Costo;
    }

    public int getNumVendidas() {
        return NumVendidas;
    }

    public void setNumVendidas(int NumVendidas) {
        this.NumVendidas = NumVendidas;
    }

    public int getNumExistencia() {
        return NumExistencia;
    }

    public void setNumExistencia(int NumExistencia) {
        this.NumExistencia = NumExistencia;
    }

    public int getLote() {
        return Lote;
    }

    public void setLote(int Lote) {
        this.Lote = Lote;
    }

    public String getFechaVencimiento() {
        return FechaVencimiento;
    }

    public void setFechaVencimiento(String FechaVencimiento) {
        this.FechaVencimiento = FechaVencimiento;
    }

    public int getDia() {
        return Dia;
    }

    public void setDia(int Dia) {
        this.Dia = Dia;
    }

    public int getMes() {
        return Mes;
    }

    public void setMes(int Mes) {
        this.Mes = Mes;
    }

    public int getAño() {
        return Año;
    }

    public void setAño(int Año) {
        this.Año = Año;
    }
    
    
    
    ///TERMINAR DE INGRESAR LOS DATOS Y VALIDARLOS
  public void IngresarDatosCompletos(String Nombre, String Codigo, float Costo, int NumExistencia, int Lote,int Dia, int Mes, int Año){
      setNombre(Nombre.trim());
      setCodigo(Codigo);
      setCosto(Costo);
      setNumExistencia(NumExistencia);
      setLote(Lote);
      setDia(Dia);
      setMes(Mes);
      setAño(Año);
      DeterminarOferta(Dia,Mes,Año);
      CalcularPrecio(Costo,Dia,Mes,Año);
      ConcatenarFecha(Dia,Mes,Año);
  
  }
  ///// nuevo
  public void IngresarDatosCompletosBD(String Nombre, String Codigo, String Costo, String Precio, String NumExistencia, String Lote, String Vendidas, String Vencimiento, String Oferta){
    
      setNombre(Nombre.trim());
      setCodigo(Codigo);
      setCosto(Float.parseFloat(Costo));
      setPrecio(Float.parseFloat(Precio));
      setNumExistencia(Integer.parseInt(NumExistencia));
      setNumVendidas(Integer.parseInt(Vendidas));
      setLote(Integer.parseInt(Lote));
      setFechaVencimiento(Vencimiento);
      setOferta(Oferta);
      
  
  }
    public boolean ValidarCodigo(String Codigo){
//        if(Codigo.matches("[0-9]{1,12}")==false){
//             JOptionPane.showMessageDialog(null,"ERROR por favor ingrese el dato de nuevo (solo numeros)de 1-12 digitos");
//        }
        return Codigo.matches("[0-9]{1,12}");
     }
//    public boolean ValidarAño(String Año){
//        if(Año.matches("[0-9]{1,4}")==false){
//             JOptionPane.showMessageDialog(null,"ERROR por favor ingrese el dato de nuevo (solo numeros)de 1-4 digitos");
//        }
//        return Año.matches("[0-9]{1,4}");
//     }
//    public boolean ValidarMesDia(String DiaMes){
//        if(DiaMes.matches("[0-9]{1,2}")==false){
//             JOptionPane.showMessageDialog(null,"ERROR por favor ingrese el dato de nuevo (solo numeros)de 1-2 digitos");
//        }
//        return DiaMes.matches("[0-9]{1,2}");
//     }
    public boolean ValidarNombre(String nombre){
//       
        return nombre.matches("([A-Z]{1}[a-z]+[ ]*?){1,2}$");  
    }
  public boolean DeterminarVencido(int dia, int mes, int año){
       //False si no esta vencido y true si esta vencido;
    int mesActual= fecha.getMonthValue();
    int añoActual = fecha.getYear();
    int diaActual= fecha.getDayOfMonth();
    if (año==añoActual) {
        if (mes==mesActual) {
            if (dia==diaActual) {
                return true;
            } else {
                return dia<diaActual;
            } 
        }else {
            return mes<mesActual;
        }
    } else {
        return año<añoActual;
    }
  }
    
  public void ConcatenarFecha(int dia, int mes, int año){
      String Dia=Integer.toString(dia);
      String Mes=Integer.toString(mes);
      String Año=Integer.toString(año);
      FechaVencimiento=Dia+"-"+Mes+"-"+Año;
  }
  
  
  public void CalcularPrecio(float Costo,int dia, int mes, int año){
      if (DeterminarVencido(dia,mes,año)==true) { //APLICAR DESCUENTO DEL 40%
          float descontar=(Costo*40)/100;
          Precio=Costo-descontar;
      } else { //SUBIR EL PRECIO PARA OBTENER UNA GANANCIA (SUBIR EL PRECIO UN 20%)
          float sumar=(Costo*20)/100;
          Precio=Costo+sumar;
      }
  
  }
   public void DeterminarOferta(int dia, int mes, int año){
      if (DeterminarVencido(dia,mes,año)==true){
          Oferta="Si";
      
      }else{
          Oferta="No";
      }
  
  }
    
    
  
    
    
}
