
package Model;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Proveedor {
   
    private ArrayList<Producto> NuevoCatalogo;
 
  

    public ArrayList<Producto> getNuevoCatalogo() {
        return NuevoCatalogo;
    }

    public void setNuevoCatalogo(ArrayList<Producto> NuevoCatalogo) {
        this.NuevoCatalogo = NuevoCatalogo;
    }

    public Proveedor(ArrayList<Producto> NuevoCatalogo) {
        this.NuevoCatalogo = NuevoCatalogo;
    }

     public void IngresarProducto(Producto Prod){
        
           if (VerificarCodigoRepetido(Prod.getCodigo())==1) {  /// Si se encuentra el codigo del producto
                JOptionPane.showMessageDialog(null, "El codigo ingresado ya fue registrado, intente con otro codigo ", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {  ///Si no se encuentra 
                if (VerificarLote(Prod.getLote())==0) {  ///Si no se encuentra el lote
                    NuevoCatalogo.add(Prod);
                } else {
                   JOptionPane.showMessageDialog(null, "El lote ingresado ya fue registrado, intente con otro numero de lote ", "Warning", JOptionPane.WARNING_MESSAGE);
                }   
            }
    }
        public int VerificarCodigoRepetido(String Codigo){
        if (NuevoCatalogo!=null && !NuevoCatalogo.isEmpty()) {
           for (int i=0;i<NuevoCatalogo.size();i++) {
             
                if (Codigo.equals(NuevoCatalogo.get(i).getCodigo())==true) {
                 
                    return 1; /// Si retorna 1 es porque el codigo esta repetido
                }
            } 
        }
        return 0;
         
    }
             public int VerificarLote(int Lote){
      
        if (NuevoCatalogo!=null && !NuevoCatalogo.isEmpty()) {
           for (int i=0;i<NuevoCatalogo.size();i++) {
                if (Lote==NuevoCatalogo.get(i).getLote()) {
                    return 1;  /// Si retorna 1 es porque el lote  esta repetido
                }
            } 
        } 
        return 0;  /// Si retorna cero es porque el lote no esta repetido
    } 
    
    public Proveedor() {
        NuevoCatalogo = new ArrayList<>();
   
    }
    
    public int VerificarExistenciaCodigo(String Codigo){
        if (NuevoCatalogo!=null && !NuevoCatalogo.isEmpty()) {
           for (int i=0;i<NuevoCatalogo.size();i++) {
             
                if (Codigo.equals(NuevoCatalogo.get(i).getCodigo())==true) {
                 
                    return 1; /// Si retorna 1 es porque el codigo existe
                }
            } 
        }
        return 0;
         
    }
    
    public int CantidadExistente(String Codigo){
        if (VerificarExistenciaCodigo(Codigo)==1) {
          for (int i=0;i<NuevoCatalogo.size();i++) {
                if (Codigo.equals(NuevoCatalogo.get(i).getCodigo())==true) {
                    return NuevoCatalogo.get(i).getNumExistencia();
                }
            }  
        } 
        return 0;
    }
    
    
    public void RestarProductos(int cantidad, String Codigo){
        for (int i = 0; i < NuevoCatalogo.size(); i++) {
            if (Codigo.equals(NuevoCatalogo.get(i).getCodigo())) {
                int numero=NuevoCatalogo.get(i).getNumExistencia();
                numero=numero-cantidad;
                NuevoCatalogo.get(i).setNumExistencia(numero);
            }
        }
    }
    
    ///PARA PODER USAR ESTE METODO EN EL VIEW HAY QUE ORDENAR LA LISTA
    public ArrayList<Producto> ReponerInventario(ArrayList<Producto> Inventario, int fila){
        if (fila>=0) {
            if (NuevoCatalogo!=null && NuevoCatalogo.isEmpty()==false) {  
                if (VerificarExistenciaCodigo(Inventario.get(fila).getCodigo())==1) {
                    try{
                        String cadena=JOptionPane.showInputDialog(null,"Introduzca la cantidad a reponer"+"\nCantidad Disponible -> "+CantidadExistente(Inventario.get(fila).getCodigo()));
                        if (cadena!=null) {
                            int cantidad= Integer.parseInt(cadena);               
                            if (cantidad>=1 ) {
                                if (cantidad<=CantidadExistente(Inventario.get(fila).getCodigo())) {
                                    int reponer=Inventario.get(fila).getNumExistencia();
                                    reponer=reponer+cantidad;
                                    Inventario.get(fila).setNumExistencia(reponer);
                                    RestarProductos(cantidad,Inventario.get(fila).getCodigo());
                                } else {
                                    JOptionPane.showMessageDialog(null, "Actualmente el proveedor no posee la cantidad de unidades que usted esta pidiendo", "Warning", JOptionPane.WARNING_MESSAGE);   
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "La cantidad a reponer debe ser mayor a 1 ", "Warning", JOptionPane.WARNING_MESSAGE);   
                            }
                        }    
                    }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción ", "Warning", JOptionPane.WARNING_MESSAGE); }
                } else {
                    JOptionPane.showMessageDialog(null, "El proveedor actualmente no tiene disponible este producto ", "Warning", JOptionPane.WARNING_MESSAGE);   
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede reponer el inventario, el provedor no tiene productos","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
            }
        } else {
             JOptionPane.showMessageDialog(null, "No se puede reponer el inventario, debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
        }
        
    return Inventario;
    }
    
}
