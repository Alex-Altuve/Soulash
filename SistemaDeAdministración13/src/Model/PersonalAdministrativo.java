
package Model;

import java.util.ArrayList;
import java.time.LocalDate;
import javax.swing.JOptionPane;


public class PersonalAdministrativo {
    private ArrayList<Administrador> Administradores;
     LocalDate fecha = LocalDate.now();
    public ArrayList<Administrador> getAdministradores() {
        return Administradores;
    }

    public void setAdministrador(ArrayList<Administrador> Administradores) {
        this.Administradores = Administradores;
    }

    public PersonalAdministrativo(ArrayList<Administrador> Administradores) {
        this.Administradores = Administradores;
    }
    
    public PersonalAdministrativo() {
        Administradores = new ArrayList<>();
    }
    
    
 
       //NOTA: DONDE SE IMPLEMENTE ESTE METODO DEBE COLOCARSE UN JOptionPain PARA DECIR QUE NO SE ENCONTRO EL USUARIO
    public int InicioSesion ( String Usuario,String Contraseña){
        if (Administradores!=null && !Administradores.isEmpty()) {
           for (int i=0;i<Administradores.size();i++) {
             
                if ((Administradores.get(i).getUsuario().equals(Usuario.trim())) && (Administradores.get(i).getContraseña().equals(Contraseña.trim()))) {
                    Administradores.get(i).setFechaIngreso(fecha.toString()); ///MODIFICA LA FECHA DE ACCESO DEL ADMINISTRADOR
                    return 1; /// Si retorna 1 es porque se encontro el administrador 
                }
            } 
        }
        return 0;//Retorna 0 en caso de no encontrarlo
    }
   
    public int VerificarExistenciaCedula(Administrador Admin){
        if (Administradores!=null && !Administradores.isEmpty()) {
           for (int i=0;i<Administradores.size();i++) {
             
                if ((Administradores.get(i).getCedula().equals(Admin.getCedula()))) {
                    return 1; /// Si retorna 1 es porque se encontro el administrador 
                }
            } 
        }
        return 0;//Retorna 0 en caso de no encontrarlo
    
    }
    public int VerificarExistenciaUsuario(Administrador Admin){
        if (Administradores!=null && !Administradores.isEmpty()) {
           for (int i=0;i<Administradores.size();i++) {
             
                if (Administradores.get(i).getUsuario().equals(Admin.getUsuario())) {
                    return 1; /// Si retorna 1 es porque se encontro el usuario 
                }
            } 
        }
        return 0;//Retorna 0 en caso de no encontrarlo
    
    }
  public void RegistrarPerfil ( Administrador Admin){
      if (VerificarExistenciaCedula(Admin)==1) {
          JOptionPane.showMessageDialog(null, "ADVERTENCIA ya existe un administrador con esa cedula, por lo tanto no va a ser agregado","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
      } else {
          if (VerificarExistenciaUsuario(Admin)==1) {
              JOptionPane.showMessageDialog(null, "ADVERTENCIA ya existe un administrador con esa nombre de usuario, por lo tanto no va a ser agregado","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
          } else {
              Administradores.add(Admin);
          }
          
      }  
  }
    
 public void EliminarPerfil(int fila){
     if (Administradores!=null && !Administradores.isEmpty()) {
         if (fila>=0) {
             if (Administradores.size()>1) {
                  Administradores.remove(fila);
             } else {
                 JOptionPane.showMessageDialog(null, "No se puede eliminar, la lista de administradores no puede quedar vacia","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
             }
         } else {
             JOptionPane.showMessageDialog(null, "No se puede eliminar, debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
         }
                    
    }else{
    JOptionPane.showMessageDialog(null, "ADVERTENCIA La lista de administradores esta vacia","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
    }
 }   
 
 public void ConsultarAdministrador(int fila){
     if (Administradores!=null && !Administradores.isEmpty()) {
         if (fila>=0) {
            Administradores.get(fila).MostrarDatos("0"); 
         } else {
             JOptionPane.showMessageDialog(null, "No se puede consultar debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
         }
                    
    }else{
    JOptionPane.showMessageDialog(null, "ADVERTENCIA La lista de administradores esta vacia","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
    }
        
 }
 
 
 ///NOTA:CADA VEZ QUE SE HAGAN MODIFICACIONES EL JTABLE DEBE ACTUALIZARSE 
 public void ModificarAdministrador(int fila,int columna){
     
     if (fila>=0) {
         if (columna==0) {
             String Usuario = JOptionPane.showInputDialog(null,"Introduzca el nuevo Usuario");
            if(Usuario!="" && Usuario!=null){
                 Administradores.get(fila).setUsuario(Usuario.trim()); 
            }
         }
         if(columna==1){
            String Contraseña = JOptionPane.showInputDialog(null,"Introduzca la nueva contraseña");
            if(Contraseña!="" && Contraseña!=null){
                 Administradores.get(fila).setContraseña(Contraseña.trim()); 
            }
         }
         if (columna==2) {
             JOptionPane.showMessageDialog(null, "No se puede modificar la fecha de ingreso","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
         }
     } else {
         JOptionPane.showMessageDialog(null, "No se puede modificar los datos, debe seleccionar una fila","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE); 
     }
 
 
 }
 
}
