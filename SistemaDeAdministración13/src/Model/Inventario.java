
package Model;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class Inventario {
    private ArrayList<Producto> Productos;

    public ArrayList<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(ArrayList<Producto> Productos) {
        this.Productos = Productos;
    }

    public Inventario(ArrayList<Producto> Productos) {
        this.Productos = Productos;
    }
    
    public Inventario() {
        Productos = new ArrayList<>();
    }
    
    public void IngresarBD(Producto Prod){  //// nuevo
        Productos.add(Prod);
    }
      public void IngresarProducto(Producto Prod){
        
           if (VerificarCodigoRepetido(Prod.getCodigo())==1) {  /// Si se encuentra el codigo del producto
                JOptionPane.showMessageDialog(null, "El codigo ingresado ya fue registrado, intente con otro codigo ", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {  ///Si no se encuentra 
                if (VerificarLote(Prod.getLote())==0) {  ///Si no se encuentra el lote
                    Productos.add(Prod);
                } else {
                   JOptionPane.showMessageDialog(null, "El lote ingresado ya fue registrado, intente con otro numero de lote ", "Warning", JOptionPane.WARNING_MESSAGE);
                }   
            }
    }
    public int VerificarCodigoRepetido(String Codigo){
        if (Productos!=null && !Productos.isEmpty()) {
           for (int i=0;i<Productos.size();i++) {
             
                if (Codigo.equals(Productos.get(i).getCodigo())==true) {
                 
                    return 1; /// Si retorna 1 es porque el codigo esta repetido
                }
            } 
        }
        return 0;
         
    }
    /// POR CODIGO
    public int VerificarExistenciaProductoCodigo(String Codigo){
        if (Productos!=null && !Productos.isEmpty()) {
               for (int i=0;i<Productos.size();i++) {

                    if (Codigo.equals(Productos.get(i).getCodigo())==true && Productos.get(i).getNumExistencia()>0) {

                        return 1; /// Si retorna 1 es porque  hay existencia del producto
                    }
                } 
            }
        return 0;
    }
    /// POR NOMBRE
     public int VerificarExistenciaProductoNombre(String Nombre){
        if (Productos!=null && !Productos.isEmpty()) {
               for (int i=0;i<Productos.size();i++) {

                    if (Nombre.equals(Productos.get(i).getNombre())==true && Productos.get(i).getNumExistencia()>0) {

                        return 1; /// Si retorna 1 es porque hay existencia del producto
                    }
                } 
            }
        return 0;
    }
    
     public int VerificarLote(int Lote){
      
        if (Productos!=null && !Productos.isEmpty()) {
           for (int i=0;i<Productos.size();i++) {
                if (Lote==Productos.get(i).getLote()) {
                    return 1;  /// Si retorna 1 es porque el lote  esta repetido
                }
            } 
        } 
        return 0;  /// Si retorna cero es porque el lote no esta repetido
    } 
   public void EliminarProducto(int fila){
       if (Productos!=null && Productos.isEmpty()==false) {
           if (fila>=0) {
               Productos.remove(fila); 
           } else {
               JOptionPane.showMessageDialog(null, "No se puede eliminar debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
           }
          
       } else {
           JOptionPane.showMessageDialog(null, "No existe el producto, la lista esta vacia ", "Warning", JOptionPane.WARNING_MESSAGE);
       }
   }
   
   /// ESTA MEDIO HECHO O TERMINAR O ELIMINAR 
   // SE USO COMO METODO DE PRUEBA 
   public void MostrarInventario (){
       for (int i=0;i<Productos.size();i++) {
           System.out.println("/////////////////////////////////////");
           System.out.println("Nombre:"+Productos.get(i).getNombre());
           System.out.println("Codigo:"+Productos.get(i).getCodigo());
           System.out.println("Precio:"+Productos.get(i).getPrecio());
           System.out.println("Numero de existencia:"+Productos.get(i).getNumExistencia());
           System.out.println("Numero de unidades vendidas:"+Productos.get(i).getNumVendidas());
             System.out.println("/////////////////////////////////////");
           
        }
   } 

     public void ConsultarProducto (String Codigo){
        int Existencia=0;
        for (int i=0;i<Productos.size();i++) {
           if (Codigo.equals(Productos.get(i).getCodigo())==true) {
               Existencia=1;
                JOptionPane.showMessageDialog(null,"******************************************************************************************"
               + "\n\n------------------------D-A-T-O-S---D-E-L---P-R-O-D-U-C-T-O-----------------------------"
               + "\n****************************************************************************************"              
               +"\n\nNOMBRE -> "+Productos.get(i).getNombre()
               +"\nFECHA DE VENCIMIENTO -> "+Productos.get(i).getFechaVencimiento()
               +"\nCODIGO -> "+Productos.get(i).getCodigo()
               +"\nCOSTO -> "+Productos.get(i).getCosto()
               +"\nLOTE -> "+Productos.get(i).getLote()
               +"\nCANTIDAD EN EXISTENCIA -> "+Productos.get(i).getNumExistencia()
               +"\nCANTIDAD VENDIDA  ->" +Productos.get(i).getNumVendidas()    
               +"\n PRECIO ->"+Productos.get(i).getPrecio()   
               );  
           }
        }
         if (Existencia==0) {
             JOptionPane.showMessageDialog(null, "No se encontro el producto", "Warning", JOptionPane.WARNING_MESSAGE);   
         }
   } 
    
   public void OrdenarMenorAMayor(){ //METODO DE BURBUJA
       
       if (Productos!=null && Productos.isEmpty()==false) {
           int largo=Productos.size()-1;
           Producto Aux=new Producto();
           for (int i = 0; i < largo; i++) {
               for (int j = 0; j < largo; j++) {
                   if (Productos.get(j).getNumVendidas()>Productos.get(j+1).getNumVendidas()) {
                       Aux=Productos.get(j);
                       Productos.set(j, Productos.get(j+1));
                       Productos.set((j+1), Aux);
                   }
               }
           }
       } else {
          JOptionPane.showMessageDialog(null, "La lista esta vacia ", "Warning", JOptionPane.WARNING_MESSAGE);  
       }
   }  
     
     
      public void OrdenarMayorAMenor(){ //METODO DE BURBUJA
       
       if (Productos!=null && Productos.isEmpty()==false) {
           int largo=Productos.size()-1;
           Producto Aux=new Producto();
           for (int i = 0; i < largo; i++) {
               for (int j = 0; j < largo; j++) {
                   if (Productos.get(j).getNumVendidas()<Productos.get(j+1).getNumVendidas()) {
                       Aux=Productos.get(j);
                       Productos.set(j, Productos.get(j+1));
                       Productos.set((j+1), Aux);
                   }
               }
           }
       } else {
           JOptionPane.showMessageDialog(null, "La lista esta vacia ", "Warning", JOptionPane.WARNING_MESSAGE);    
       }
   }    
     
   public void ModificarProducto (int fila, int colummna){
       
    if (fila>=0) {
        Producto Prod=new Producto(); 
        if (colummna==0) {
            String Nombre = JOptionPane.showInputDialog(null,"Introduzca el nuevo nombre");
            if (Nombre!=null) {
               if(Prod.ValidarNombre(Nombre)==true){
                 Productos.get(fila).setNombre(Nombre.trim());
                } 
            }
            
        }
        
        if (colummna==1) {
            
            String Codigo = JOptionPane.showInputDialog(null,"Introduzca el nuevo codigo");
            if (Codigo!=null) {
                if(Prod.ValidarCodigo(Codigo)==true){
                    if (VerificarCodigoRepetido(Codigo)==0) {
                        Productos.get(fila).setCodigo(Codigo);
                    }else{
                         JOptionPane.showMessageDialog(null, "El codigo ya existe, no sera ingresado ", "Warning", JOptionPane.WARNING_MESSAGE);   
                    }
                }else{JOptionPane.showMessageDialog(null, "El codigo no puede contener caracteres ", "Warning", JOptionPane.WARNING_MESSAGE);  }
            }
        }
         
        if (colummna==2) {
            try{
                String cadena=JOptionPane.showInputDialog(null,"Introduzca el nuevo precio ");
                if (cadena!=null) {
                   float precio = Float.parseFloat(cadena);
                   Productos.get(fila).setPrecio(precio); 
                } 
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción, ni tampoco comas ", "Warning", JOptionPane.WARNING_MESSAGE);}
        }
        
        if (colummna==3) {
            try{
                String cadena=JOptionPane.showInputDialog(null,"Introduzca el nuevo costo ");
                if (cadena!=null) {
                    float costo = Float.parseFloat(cadena);
                    Productos.get(fila).setCosto(costo);
                }
                
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción, ni tampoco comas ", "Warning", JOptionPane.WARNING_MESSAGE);}
        }
        
       
        if (colummna==4) {
           try{
                String cadena=JOptionPane.showInputDialog(null,"Introduzca el nuevo año");
                if (cadena!=null) {
                    int año= Integer.parseInt(cadena);               
                    if (año>=2022 && año<=2045) {
                        String cadena2=JOptionPane.showInputDialog(null,"Introduzca el nuevo mes");
                        if (cadena2!=null) {
                            int mes= Integer.parseInt(cadena2); 
                            if (mes>=1 && mes<=12 ) {  ///Año biciesto
                                String cadena3=JOptionPane.showInputDialog(null,"Introduzca el nuevo dia");
                                if (cadena3!=null) {
                                    int dia= Integer.parseInt(cadena3); 

                                    if((mes==1 || mes ==3 || mes== 5 || mes==7 || mes==8 || mes==10 || mes ==12) && (dia>=1 && dia<=31 )){
                                        Productos.get(fila).setAño(año);
                                        Productos.get(fila).setDia(dia);
                                        Productos.get(fila).setMes(mes);
                                        Productos.get(fila).ConcatenarFecha(dia, mes, año);
                                    }
                                    if ((mes==4||mes==6||mes==9||mes==11)&& (dia>=1 && dia<=30)) {
                                        Productos.get(fila).setAño(año);
                                        Productos.get(fila).setDia(dia);
                                        Productos.get(fila).setMes(mes);
                                        Productos.get(fila).ConcatenarFecha(dia, mes, año);
                                    } 
                                    if (mes==2) {
                                            if (año%4==0) {
                                               if ( dia>=1 && dia<=29) {
                                                    Productos.get(fila).setAño(año);
                                                    Productos.get(fila).setDia(dia);
                                                    Productos.get(fila).setMes(mes);
                                                    Productos.get(fila).ConcatenarFecha(dia, mes, año);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ERROR el dia debe estar en un rango entre 1-29 ", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
                                                } 
                                            } else {
                                                if (dia>=1 && dia<=28) {
                                                    Productos.get(fila).setAño(año);
                                                    Productos.get(fila).setDia(dia);
                                                    Productos.get(fila).setMes(mes);
                                                    Productos.get(fila).ConcatenarFecha(dia, mes, año);
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "ERROR el dia debe estar en un rango entre 1-28 ", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
                                                }
                                            }
                                    }else{
                                        if( !((mes==1 || mes ==3 || mes== 5 || mes==7 || mes==8 || mes==10 || mes ==12) && (dia>=1 && dia<=31 )) && !(mes==4||mes==6||mes==9||mes==11)  ){
                                             JOptionPane.showMessageDialog(null, "ERROR el dia debe estar en un rango entre 1-31 ", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE); 
                                        }else{
                                            if(!((mes==4||mes==6||mes==9||mes==11) && (dia>=1 && dia<=30)) && !(mes==1 || mes ==3 || mes== 5 || mes==7 || mes==8 || mes==10 || mes ==12) ){
                                                JOptionPane.showMessageDialog(null, "ERROR el dia debe estar en un rango entre 1-30", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);        
                                            }
                                        }
                                    }
                                    
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "El mes debe estar en un rango entre 1-12 ", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);   
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "El año debe estar en un rango entre 2022-2045 ", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);   
                    }    
               }
                  
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción ", "Warning", JOptionPane.WARNING_MESSAGE); }
        }
        
        if (colummna==5) {
            try{
                String cadena=JOptionPane.showInputDialog(null,"Introduzca el nuevo numero de lote");
                if (cadena!=null) {
                    int lote= Integer.parseInt(cadena);               
                    if (VerificarLote(lote)==0) {
                        Productos.get(fila).setLote(lote);
                    }else{
                        JOptionPane.showMessageDialog(null, "El numero de lote ya existe, no sera ingresado ", "Warning", JOptionPane.WARNING_MESSAGE);   
                    }    
                }
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción ", "Warning", JOptionPane.WARNING_MESSAGE);}
        }
       
        if (colummna==6) {
            JOptionPane.showMessageDialog(null, "No se puede modificar la cantidad en existencia","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
        }
        
        if (colummna==7) {
            try{
                String cadena=JOptionPane.showInputDialog(null,"Introduzca el nuevo numero de unidades vendidas");
                if (cadena!=null) {
                    int Nvendidas= Integer.parseInt(cadena);               
                    Productos.get(fila).setNumVendidas(Nvendidas);   
                } 
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción ", "Warning", JOptionPane.WARNING_MESSAGE);}
        }
        
        if (colummna==8) {
            try{
                String cadena=JOptionPane.showInputDialog(null,"Esta en oferta \n\n"+"1. Si\n"+"2.No\n\n");
                if (cadena!=null) {
                    int Oferta = Integer.parseInt(cadena);
                    if (Oferta==1) {
                        Productos.get(fila).setOferta("Si");
                    } else {
                        if (Oferta==2) {
                           Productos.get(fila).setOferta("No");
                        } else {
                             JOptionPane.showMessageDialog(null, "ERROR el numero ingresado no esta en el rango 1-2 por lo tanto no va a ser modificado ", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);    
                        }
                    }
                }
                       
            }catch(NumberFormatException ex){JOptionPane.showMessageDialog(null, "ADVERTENCIA, no se pueden escribir caracteres en esta opción ", "Warning", JOptionPane.WARNING_MESSAGE);}
        }
         
    } else {
         JOptionPane.showMessageDialog(null, "No se puede modificar los datos, debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
    }
   
   }  
     
     ///PROBAR
   public void OrdenarListaExistenciaMenorAMayor(){ ///LOS ORDENA DE TAL FORMA QUE LOS QUE TENGA MENOR A O IGUAL A 5 EXISTENCIAS QUEDEN DE PRIMEROS 
       if (Productos!=null && Productos.isEmpty()==false) {
           int largo=Productos.size()-1;
           Producto Aux=new Producto();
           for (int i = 0; i < largo; i++) {
               for (int j = 0; j < largo; j++) {
                   if (Productos.get(j).getNumExistencia()>Productos.get(j+1).getNumExistencia()) {
                       Aux=Productos.get(j);
                       Productos.set(j, Productos.get(j+1));
                       Productos.set((j+1), Aux);
                   }
               }
           }
       } else {
          JOptionPane.showMessageDialog(null, "La lista esta vacia ", "Warning", JOptionPane.WARNING_MESSAGE);  
       }
   }  
     
     
     
     
     
     
     
}
