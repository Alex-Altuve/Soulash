
package Model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;

public class Transaccion extends Cliente {
    private float Monto;
    private String TipodePago;
    private int NumFactura;
    private String NumTarjeta;
    private String Fecha;
    LocalDate fecha = LocalDate.now();

    public float getMonto() {
        return Monto;
    }

    public void setMonto(float Monto) {
        this.Monto = Monto;
    }
   
    public String getTipodePago() {
        return TipodePago;
    }

    public void setTipodePago(String TipodePago) {
        this.TipodePago = TipodePago;
    }

    public int getNumFactura() {
        return NumFactura;
    }

    public void setNumFactura(int NumFactura) {
        this.NumFactura = NumFactura;
    }

    public String getNumTarjeta() {
        return NumTarjeta;
    }

    public void setNumTarjeta(String NumTarjeta) {
        this.NumTarjeta = NumTarjeta;
    }

 

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Transaccion(float Monto, String TipodePago, int NumFactura, String NumTarjeta, String Fecha, ArrayList<Producto> Carrito, String nombre, String cedula, String telefono, String direccion) {
        super(Carrito, nombre, cedula, telefono, direccion);
        this.Monto = Monto;
        this.TipodePago = TipodePago;
        this.NumFactura = NumFactura;
        this.NumTarjeta = NumTarjeta;
        this.Fecha = Fecha;
    }

    
    public Transaccion() {
        super();
        Monto = 0;
        TipodePago =null;
        NumFactura = 0;
        NumTarjeta = null;
        Fecha = null;
    }
///HACER LA REPECTIVA MODIFICACION CON EL TIPODEPAGO---AGREGARLO
   public void IngresarDatos( String nombre, String cedula, String telefono, String direccion, ArrayList<Transaccion> Factura){
       setFecha(fecha.toString());
       CalcularMonto();
       setNombre(nombre.trim());
       setCedula(cedula);
       setTelefono(telefono);
       setDireccion(direccion.trim());
       GenerarNumeroFactura(Factura);
   }
   public void IngresarDatosCompletosBD(String nombre, String cedula, String telefono, String direccion, Float monto, String TipoPago, int NumFactura, String NumTarjeta, String Fecha){
       CalcularMonto();
       setNombre(nombre.trim());
       setCedula(cedula);
       setTelefono(telefono);
       setDireccion(direccion.trim());
       setTipodePago(TipoPago);
       setMonto(monto);
       setFecha(Fecha);
       setNumFactura(NumFactura);
       setNumTarjeta(NumTarjeta);
       
   }
   public void DefinirTipoPago(int numero, String NumTarjeta){
       if (numero==1) {
           TipodePago="Tarjeta";
           this.NumTarjeta=NumTarjeta;
       } else {
           if(numero==2){
               TipodePago="Efectivo";
           }
       }
   }
   public void CalcularMonto(){
   float monto=0;
       for (int i = 0; i < Carrito.size(); i++) {
           monto+= (Carrito.get(i).getNumExistencia()*Carrito.get(i).getPrecio());
          
       }
         setMonto(monto);
   }

    public void MostrarDatos(String Codigo) {
        if (Carrito!=null && !Carrito.isEmpty()) {
            boolean existencia=false;
            
            for (int i = 0; i < Carrito.size(); i++) {
             
                if (Codigo.equals(Carrito.get(i).getCodigo())) {
                    existencia=true;
                }
            }
            
            if (existencia==true) {
                JOptionPane.showMessageDialog(null, "El producto esta en el carrito ");
            } else {
                JOptionPane.showMessageDialog(null, "El producto no esta en el carrito ");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El carrito esta vacio ", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void GenerarNumeroFactura(ArrayList<Transaccion> Factura){
        NumFactura=Factura.size()+1;
    }
    
    /// EL ARRAYLIST DE INVENTARIO ES EL DEL INVENTARIO Y EL ARRAYLIST DE FACTURAS ES EL DE TRANSACCIONES 
    /// DESPUES DE APLICAR ESTE METODO SE DEBE LLAMAR A LA CLAS REPORTES PDF E INGRESAR LA TRANSACCION, ASI COMO TAMBIEN IMPRIMIR LA FACTURA
    public ArrayList<Producto> RealizarCompra(ArrayList<Producto> Inventario,int numero, String NumTarjeta, String nombre, String cedula, String telefono, String direccion, ArrayList<Transaccion> Factura, ArrayList<Producto> carrito){
        Carrito=carrito;
        DefinirTipoPago(numero, NumTarjeta);
        IngresarDatos(nombre,cedula, telefono, direccion, Factura);
        
      
        for (int i = 0; i < carrito.size(); i++) {  //Ciclo del carrito 
            for (int j = 0; j < Inventario.size(); j++) { ///Ciclo del inventario
                if (carrito.get(i).getCodigo().equals(Inventario.get(j).getCodigo())) {
                    int cantidad=carrito.get(i).getNumExistencia();
                    int existencia=Inventario.get(j).getNumExistencia();
                    existencia=existencia-cantidad;
                    Inventario.get(j).setNumExistencia(existencia);
                    int vendidas=Inventario.get(j).getNumVendidas();
                    vendidas=vendidas+cantidad;
                    Inventario.get(j).setNumVendidas(vendidas);
                }
            }
        }
        return Inventario;
    }
    
}
