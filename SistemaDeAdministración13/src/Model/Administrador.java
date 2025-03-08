
package Model;

import javax.swing.JOptionPane;



public class Administrador extends Persona{
    private String Usuario;
    private String Contraseña;
    private String FechaIngreso;
    
    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }
    
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public Administrador(String FechaIngreso, String Usuario, String Contraseña, String nombre, String cedula, String telefono, String direccion) {
        super(nombre, cedula, telefono, direccion);
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.FechaIngreso=FechaIngreso;
    }

    public Administrador() {
        super();
        Usuario = "";
        Contraseña = "";
        FechaIngreso="No ha ingresado";
    }
    
    public void IngresarAdministrador( String Usuario, String Contraseña, String nombre, String cedula, String telefono, String direccion){
        setUsuario(Usuario.trim());
        setContraseña(Contraseña.trim());
        setNombre(nombre.trim());
        setCedula(cedula);
        setTelefono(telefono);
        setDireccion(direccion.trim());
    }
    /////AGREGAR METODO ABSTRACTO////
    public void MostrarDatos(String Codigo) {
        JOptionPane.showMessageDialog(null,"******************************************************************************************"
               + "\n\n------------------------D-A-T-O-S---D-E-L---A-D-M-I-N-I-S-T-R-A-D-O-R------------------------"
               + "\n****************************************************************************************"              
               +"\n\nUSUARIO -> "+Usuario
               +"\nCONTRASEÑA -> "+Contraseña
               +"\nNOMBRE -> "+nombre
               +"\nCEDULA -> "+cedula
               +"\nTELEFONO -> "+telefono
               +"\nDIRECCION -> "+direccion
               +"\nULTIMA FECHA DE INGRESO -> "+FechaIngreso
        );
    }
    
 
 
 
 
 
 
}
