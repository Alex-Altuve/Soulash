
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public abstract class Cliente extends Persona{

    protected ArrayList<Producto> Carrito;
    
    
    public Cliente(ArrayList<Producto> Carrito, String nombre, String cedula, String telefono, String direccion) {
        super(nombre, cedula, telefono, direccion);
        this.Carrito = Carrito;
    }

    public ArrayList<Producto> getCarrito() {
        return Carrito;
    }

   

    public void setCarrito(ArrayList<Producto> Carrito) {
        this.Carrito = Carrito;
    }

    public Cliente() {
        super();
        Carrito = new ArrayList<>();
      
    }
 
    public void AgregarCarrito(ArrayList<Producto>  Aux, int fila){
        if (fila>=0) {
            try{
                if (VerificarCodigoCarrito(Aux.get(fila).getCodigo())==1) {
                    String cadena=JOptionPane.showInputDialog(null,"El codigo que desea agregar, ya esta en su carrito\n ¿Desea modificar la cantidad? \n\n"+"1. Si\n"+"2.No\n\n");
                    if (cadena!=null) {
                        int Continuar = Integer.parseInt(cadena);
                        if (Continuar==1) {
                            String cadena2=JOptionPane.showInputDialog(null,"Introduzca la cantidad que desea del producto");
                            if (cadena2!=null) {
                                int cantidad= Integer.parseInt(cadena2); 
                                if (cantidad>=1) {
                                    if (cantidad<=Aux.get(fila).getNumExistencia() ){
                                        for (int i = 0; i < Carrito.size(); i++) {
                                            if (Carrito.get(i).getCodigo().equals(Aux.get(fila).getCodigo())) {
                                                Carrito.get(i).setNumExistencia(cantidad);

                                            }
                                        }
                                    } else {
                                       JOptionPane.showMessageDialog(null, "No hay suficiente existencia del producto","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);  
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "ERROR la cantidad debe ser mayor o igual a 1","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
                                }
                            }
                        } else {
                            if (Continuar==2) {
                               //NO HACE NADA
                            } else {
                                 JOptionPane.showMessageDialog(null, "ERROR el numero ingresado no esta en el rango 1-2  ", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);    
                            }
                        }
                    }
                } else {
                    String cadena=JOptionPane.showInputDialog(null,"Introduzca la cantidad que desea del producto");
                    if (cadena!=null) {
                        int cantidad= Integer.parseInt(cadena); 
                        if (cantidad>=1) {
                            if (cantidad<=Aux.get(fila).getNumExistencia()){
                                Producto Prod=new Producto();

                                Prod.IngresarDatosCompletos(Aux.get(fila).getNombre(),Aux.get(fila).getCodigo(), Aux.get(fila).getCosto(),cantidad, Aux.get(fila).getLote(), Aux.get(fila).getDia(), Aux.get(fila).getMes(), Aux.get(fila).getAño());
                                Prod.setFechaVencimiento(Aux.get(fila).getFechaVencimiento());
                                Carrito.add(Prod);
                            } else {
                               JOptionPane.showMessageDialog(null, "No hay suficiente existencia del producto","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);  
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR la cantidad debe ser mayor o igual a 1","ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
                        }
                    }
                }
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción ", "Warning", JOptionPane.WARNING_MESSAGE); }
        } else {
             JOptionPane.showMessageDialog(null, "No se puede agregar al carrito debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
        }
    
    }
 
////////////////////////////////////////////////
    
    public void EliminarCarrito(int fila){
        if (Carrito!=null && Carrito.isEmpty()==false) {
           if (fila>=0) {
             
              Carrito.remove(fila); 
           } else {
               JOptionPane.showMessageDialog(null, "No se puede eliminar debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
           }
       } else {
           JOptionPane.showMessageDialog(null, "No existe el producto, la lista esta vacia ", "Warning", JOptionPane.WARNING_MESSAGE);
       }
    
    }
    
    
    public int VerificarCodigoCarrito(String Codigo){
        if (Carrito!=null && !Carrito.isEmpty()) {
           for (int i=0;i<Carrito.size();i++) {
             
                if (Codigo.equals(Carrito.get(i).getCodigo())==true) {
                 
                    return 1; /// Si retorna 1 es porque el codigo ya existe
                }
            } 
        }
        return 0;/// Si retorna 0 es porque el codigo NO existe
         
    }
public void VaciarCarrito(){
    if (Carrito!=null && !Carrito.isEmpty()) {
        Carrito.removeAll(Carrito);
    } else {
         JOptionPane.showMessageDialog(null, "El carrito ya esta vacio ", "Warning", JOptionPane.WARNING_MESSAGE);
    }
    

}
   
    
}
