
package Model;



public class Persona {
    protected String nombre;
    protected String cedula;
    protected String telefono;
    protected String direccion;

    public Persona(String nombre, String cedula, String telefono, String direccion) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.direccion = direccion;
    }
    public Persona() {
        nombre = null;
        cedula = null;
        telefono = null;
        direccion = null;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

     public boolean ValidarNombre(String nombre){
        if(nombre.matches("([A-Z]{1}[a-z]+[ ]*?){1,2}$")==false){
             //JOptionPane.showMessageDialog(null,"ERROR por favor ingrese el dato de nuevo");
        }
        return nombre.matches("([A-Z]{1}[a-z]+[ ]*?){1,2}$");  
    }
    public boolean ValidarCedula(String cedula){
        if(cedula.matches("[0-9]{6,8}")==false){
            // JOptionPane.showMessageDialog(null,"ERROR por favor ingrese el dato de nuevo (solo numeros)");
        }
        return cedula.matches("[0-9]{6,8}");  
    }
     public boolean ValidarTelefono(String telefono){
        if(telefono.matches("[0-9]{11}")==false){
           //  JOptionPane.showMessageDialog(null,"ERROR por favor ingrese el dato de nuevo (solo numeros)");
        }
        return telefono.matches("[0-9]{11}");  
    }
     public boolean ValidarDireccion(String direccion){///PROBAR LA EXPRESION REGULAR
     
        if(direccion.matches("([A-Z0-9]{1}[a-z0-9]+[ ]*?)+$")==false){
           //  JOptionPane.showMessageDialog(null,"ERROR por favor ingrese el dato de nuevo");
           
        }
        return direccion.matches("([A-Z0-9]{1}[a-z0-9]+[ ]*?)+$");  
    }
     
   public void IngresarDatosCompletosBD(String nombre, String cedula, String telefono, String direccion){
       setNombre(nombre.trim());
       setCedula(cedula);
       setTelefono(telefono);
       setDireccion(direccion.trim());
   }
     
     
     
     
     
}
