/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Administrador;
import Model.ConectarBD;
import Model.Producto;
import Model.Inventario;
import Model.Persona;
import Model.PersonalAdministrativo;
import Model.Proveedor;
import Model.ReportesPDF;
import Model.Transaccion;
import View.Cliente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;



import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Alex Altuve
 */
public class Controller {
    JTextField  Nombretxtx,Cedulatxt,Telefonotxt,Direcciontxt, Usuariotxt, Passwordtxt, NumTarjetatxt, TotalPagartxt;  /// Var de Admin y Nombre (comun de admin y producto)
    JTextField ErrorNombre, ErrorCedula, ErrorTelefono, ErrorDireccion, ErrorTarjeta;
    JTextField Codigotxt, Existenciatxt, Costotxt, Lotetxt, PagoCompratxt;  /// Var de Productos
    JComboBox Dia, Mes, Año; /// Var Productos
    JRadioButton PagoTarjeta, PagoEfectivo;
    ButtonGroup AmbasOpciones;
    Inventario ListaProduc;
    Proveedor ListaProducProveedor;  /// Para agregar producto
    PersonalAdministrativo ListaAdmin; // Para agregar administrador
    Transaccion client, producaCompras;
   
    ReportesPDF ReporteInv, ListaClientes;
    JTable TablaProductos, TablaAdmin, TablaInventario, TablaCarrito, TablaVentas;  // para llenar tablas
    Connection cn = ConectarBD.conectar();
  
//////////////////////////////////Productos ////////////////////////////////////////    
    public Controller(){
        ListaClientes = new ReportesPDF();
        ListaProduc= new Inventario();
        ListaProducProveedor= new Proveedor();   
        ReporteInv = new ReportesPDF();
    }
///////////////////////////////////////////Controlador para view productos////////////////////////////////
    public Controller(JTextField Nombretxtx, JTextField Codigotxt, JTextField Existenciatxt, JTextField Costotxt, JTextField Lotetxt, JComboBox Dia, JComboBox Mes, JComboBox Año, JTable TablaProductos,JTextField ErrorNombre, JTextField ErrorCodigo, JTextField ErrorLote) {
        this.Nombretxtx = Nombretxtx;
        this.Codigotxt = Codigotxt;
        this.Existenciatxt = Existenciatxt;
        this.Costotxt = Costotxt;
        this.Lotetxt = Lotetxt;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        this.ErrorNombre = ErrorNombre;
        this.ErrorCedula = ErrorCodigo;
        this.ErrorTelefono = ErrorLote;
     
        ListaProduc= new Inventario();
        this.TablaProductos = TablaProductos;
    }

///////////////////////////////////////////Controlador para view administrador////////////////////////////////   

    public Controller(JTextField Nombretxtx, JTextField Cedulatxt, JTextField Telefonotxt, JTextField Direcciontxt, JTextField Usuariotxt, JTextField Passwordtxt, JTextField ErrorNombre, JTextField ErrorCedula, JTextField ErrorTelefono, JTextField ErrorDireccion, JTable TablaAdmin) {
        this.Nombretxtx = Nombretxtx;
        this.Cedulatxt = Cedulatxt;
        this.Telefonotxt = Telefonotxt;
        this.Direcciontxt = Direcciontxt;
        this.Usuariotxt = Usuariotxt;
        this.Passwordtxt = Passwordtxt;
        this.ErrorNombre = ErrorNombre;
        this.ErrorCedula = ErrorCedula;
        this.ErrorTelefono = ErrorTelefono;
        this.ErrorDireccion = ErrorDireccion ;
        this.TablaAdmin = TablaAdmin;
        ListaAdmin = new PersonalAdministrativo();
    }
//////////////////////Contructor para Inventario////////////////////////////////////////

    public Controller(JTextField Codigotxt, JTable TablaInventario) {
        this.Codigotxt = Codigotxt;
        this.TablaInventario = TablaInventario;
        ListaProduc= new Inventario();
        ReporteInv = new ReportesPDF();
    }
 /////////////////////////////Constructor del Login ///////////////////////////////
    
    public Controller(JTextField Usuariotxt, JTextField Password){
        this.Usuariotxt = Usuariotxt;
        this.Passwordtxt = Password;
        ListaAdmin = new PersonalAdministrativo();
    }
 ///////////////////////Constructor para PrincipalAdmin///////////////////////////////////////////////////   
    public Controller(JTextField Usuariotxt){
        this.Usuariotxt = Usuariotxt;
      
        ListaAdmin = new PersonalAdministrativo();
    }
    
/////////////Contructor Cliente /////////////////////////   

    public Controller(JTextField Direcciontxt, JTextField Codigotxt, JTextField Costotxt, JTable TablaInventario, JTable TablaCarrito) {
       
        this.Direcciontxt = Direcciontxt; //codigo para buscar en carrito
        this.Codigotxt = Codigotxt;// codigo para buscar en inventario
        this.Costotxt = Costotxt; //total a pagar
       
        this.TablaInventario = TablaInventario;
        this.TablaCarrito = TablaCarrito; 
        ListaProduc= new Inventario();
        client= new Transaccion();   
       
       
    }
 //////////////////Constructor ProductosReponer/////////////////////////////////////////////////////

    public Controller(JTable TablaInventario) {

        this.TablaInventario = TablaInventario;
        ListaProduc= new Inventario();
        ListaProducProveedor= new Proveedor();    
    }

   /////////////////////////////Construcctor Historial Ventas///////////////////////////////////////////////////////////////////
    public void LlenarControllerVentas(JTable TablaVentas) {

        this.TablaVentas = TablaVentas;
        ReporteInv = new ReportesPDF();
 
    }
    
    /////////////////////////////Constructor Datos cliente Compra/////////////////////////////////////////////

    public Controller(JTextField Nombretxtx, JTextField Cedulatxt, JTextField Telefonotxt, JTextField Direcciontxt, JTextField NumTarjetatxt, JRadioButton Tarjeta, JRadioButton Efectivo, JTextField ErrorNombre, JTextField ErrorCedula, JTextField ErrorTelefono, JTextField ErrorDireccion, JTextField ErrorTarjeta, JTextField MontoPagar, ButtonGroup TaryEfec, Transaccion Carrito) {
        this.Nombretxtx = Nombretxtx;
        this.Cedulatxt = Cedulatxt;
        this.Telefonotxt = Telefonotxt;
        this.Direcciontxt = Direcciontxt;
        this.NumTarjetatxt = NumTarjetatxt;
        this.TotalPagartxt=MontoPagar;
        this.PagoTarjeta=Tarjeta;
        this.PagoEfectivo= Efectivo;
        ///////////////////////////////
        this.ErrorNombre = ErrorNombre;
        this.ErrorCedula = ErrorCedula;
        this.ErrorTelefono = ErrorTelefono;
        this.ErrorDireccion = ErrorDireccion;
        this.ErrorTarjeta = ErrorTarjeta;
       ////////////////////////////////
        ReporteInv = new ReportesPDF();  
        ListaProduc= new Inventario();
        ListaClientes = new ReportesPDF(); 
        this.producaCompras=Carrito;
        this.AmbasOpciones=TaryEfec;
       
    }
   
    
    //////////////////////////////////////////////////////////
    public void iniciaVentana(JFrame ventana, String ruta) {
        ventana.setLocationRelativeTo(null);
        ventana.setIconImage(new ImageIcon(ruta).getImage());
        ventana.setResizable(false);
        ventana.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
    public void activaVentana(JFrame ventana,JFrame ventana2) {
        
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana2.dispose(); 
    }
    public void ConectarPanel(JPanel origen, JPanel destino, int ancho, int alto, int x, int y){
          
        destino.setSize(ancho, alto);
        destino.setLocation(x,y);
        origen.removeAll();
        origen.add(destino, BorderLayout.CENTER);
        origen.revalidate();
        origen.repaint();
    }
    public void CrearFuentetoErrores(JTextField copy){
        Font fuente = new Font("", Font.BOLD, 9);
        copy.setForeground(Color.red);
        copy.setFont(fuente);
    }
  /////////////////////////////////////PRODUCTOS///////////////////////////////////////////////////////////////////////
     public void LLenarCamposErrores(Producto produc, Inventario Lista ){
       
        if(produc.ValidarNombre(Nombretxtx.getText())== false){
            CrearFuentetoErrores(ErrorNombre);
            ErrorNombre.setText("*Cumplir formato [(A)riel (M)ax]");
        }
        if(Lista.VerificarCodigoRepetido(Codigotxt.getText())== 1){
            CrearFuentetoErrores(ErrorCedula);
            ErrorCedula.setText("*Este codigo ya esta registrado");
        }
        if(Lista.VerificarLote(Integer.parseInt(Lotetxt.getText()))== 1){
            CrearFuentetoErrores(ErrorTelefono);
            ErrorTelefono.setText("*Este num Lote ya esta registrado");
        }
       
    }
    public void ReiniciarComboBox(){
        llenar_comboMes_Dia();
        Año.setSelectedIndex(0);
        Mes.setSelectedIndex(0);
    }
    public void llenar_comboMes_Dia(){
        
        int year = Integer.parseInt((String) Año.getSelectedItem());
        int mes= Mes.getSelectedIndex();
        
            Dia.removeAllItems();
            Dia.addItem("1");
            Dia.addItem("2");
            Dia.addItem("3");
            Dia.addItem("4");
            Dia.addItem("5");
            Dia.addItem("6");
            Dia.addItem("7");
            Dia.addItem("8");
            Dia.addItem("9");
            Dia.addItem("10");
            Dia.addItem("11");
            Dia.addItem("12");
            Dia.addItem("13");
            Dia.addItem("14");
            Dia.addItem("15");
            Dia.addItem("16");
            Dia.addItem("17");
            Dia.addItem("18");
            Dia.addItem("19");
            Dia.addItem("20");
            Dia.addItem("21");
            Dia.addItem("22");
            Dia.addItem("23");
            Dia.addItem("24");
            Dia.addItem("25");
            Dia.addItem("26");
            Dia.addItem("27");
            Dia.addItem("28");
            if(mes!=1){
                Dia.addItem("29");
                Dia.addItem("30");
            }else{
                if(mes==1 && (year % 4) ==0){
                     Dia.addItem("29");
                }
            }
            if(mes==0|| mes ==2 || mes== 4 || mes==6 || mes==7 || mes==9 || mes ==11){
                Dia.addItem("31");
            }
 
    } 
   
    public boolean VerificarVaciosProd(){
         return "".equals(Lotetxt.getText()) || "".equals(Nombretxtx.getText()) || "".equals(Codigotxt.getText()) || "".equals(Existenciatxt.getText()) || "".equals(Costotxt.getText());
    }
    public void  LlenarArrayListconBD(){
        try{
           
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM inventario");
            String datos[]= new String[9]; 
            ListaProduc.getProductos().clear();
            while (rs.next()) {
                Producto prod = new Producto();
                datos[0]=rs.getString(1); // nombre
                datos[1]=rs.getString(2); // codigo
                datos[2]=rs.getString(3); // precio
                datos[3]=rs.getString(4); //costo
                datos[4]=rs.getString(5);  // vencimeinto
                datos[5]=rs.getString(6); // lote
                datos[6]=rs.getString(7); // existencia
                datos[7]=rs.getString(8); //vendidas
                datos[8]=rs.getString(9); // en oferta

                prod.IngresarDatosCompletosBD(datos[0],datos[1], datos[3], datos[2], datos[6],datos[5],datos[7],datos[4],datos[8]);
                
                ListaProduc.getProductos().add(prod);
           
            }
            
           
        }catch(Exception e){
             System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
        }
            
    }
    public void LlenarTablaProductos(JTable TablaProductos) {  ///// revisar
        
            String[] columna = {"Nombre","Código", "Precio", "Costo", "F.Vencimiento", "N° Lote", "N° Existencia", "Unid.Vendidas", "En Oferta"};
            DefaultTableModel dtm = new DefaultTableModel(null, columna){
              @Override
              public boolean isCellEditable(int row, int column){
                  return false; 
              }
            };  
           
            for (int i=0; i<ListaProduc.getProductos().size(); i++) { 
                String[] row = {ListaProduc.getProductos().get(i).getNombre(), ListaProduc.getProductos().get(i).getCodigo(), Float.toString(ListaProduc.getProductos().get(i).getPrecio()),Float.toString(ListaProduc.getProductos().get(i).getCosto()), ListaProduc.getProductos().get(i).getFechaVencimiento(), Integer.toString(ListaProduc.getProductos().get(i).getLote()), Integer.toString(ListaProduc.getProductos().get(i).getNumExistencia()), Integer.toString(ListaProduc.getProductos().get(i).getNumVendidas()), ListaProduc.getProductos().get(i).getOferta()};
               dtm.addRow(row);
     
            }
           TablaProductos.setModel(dtm);

       
    }
    
    
    public void VaciarCamposProduc(){
        Nombretxtx.setText("");
        Codigotxt.setText("");
        Existenciatxt.setText("");
        Costotxt.setText("");
        Lotetxt.setText("");
        ErrorNombre.setText("");
        ErrorCedula.setText("");
        ErrorTelefono.setText("");
    }
  
   
    public void InsertarProductoBD(Inventario ListaProd){
        try {
            Statement stm= (Statement) cn.createStatement();
           
            for (int i=0; i<ListaProd.getProductos().size();i++)  { 
              
                 String Nombre=ListaProd.getProductos().get(i).getNombre();
                 String Cod=ListaProd.getProductos().get(i).getCodigo();
                 String Fecha= ListaProd.getProductos().get(i).getFechaVencimiento();
                 Float prec=ListaProd.getProductos().get(i).getPrecio();
                 Float costo=ListaProd.getProductos().get(i).getCosto();
                 int Exis=ListaProd.getProductos().get(i).getNumExistencia();
                 int vendidas= ListaProd.getProductos().get(i).getNumVendidas();
                 int lote = ListaProd.getProductos().get(i).getLote();
                 String oferta= ListaProd.getProductos().get(i).getOferta();
                 String insert="INSERT INTO inventario VALUES('"+Nombre+"','"+Cod+"','"+prec+"','"+costo+"','"+Fecha+"','"+lote+"','"+Exis+"','"+vendidas+"','"+oferta+"');";
            
                stm.executeUpdate(insert);
            }
           
        } catch (SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
       
    }
    
    public void AgregarProductoBoton(){  /// investigar sobre cerra la conexion de la base de datos
        Producto prod = new Producto();
       
        if(VerificarVaciosProd()!=true){
           
            if(prod.ValidarNombre(Nombretxtx.getText()) == true && prod.ValidarCodigo(Codigotxt.getText()) == true && ListaProduc.VerificarLote(Integer.parseInt(Lotetxt.getText())) == 0 && ListaProduc.VerificarCodigoRepetido(Codigotxt.getText())==0){
                int dia=1, mes=1 ,año=2022;
                dia+= Dia.getSelectedIndex();
                mes+=(Integer) Mes.getSelectedIndex();
                año+=(Integer)Año.getSelectedIndex();
                prod.IngresarDatosCompletos(Nombretxtx.getText(), Codigotxt.getText(), Float.parseFloat(Costotxt.getText()),Integer.parseInt(Existenciatxt.getText()),Integer.parseInt(Lotetxt.getText()),dia, mes, año);
              
                ListaProduc.IngresarProducto(prod);
                ////////////////////////Conexion con BD
                VaciarBDInventario();
                InsertarProductoBD(ListaProduc);
                LlenarTablaProductos(TablaProductos);
                /////////////////////////////////////////
                
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
                VaciarCamposProduc();
                ReiniciarComboBox();
            }else{
                 
                LLenarCamposErrores(prod, ListaProduc);
                
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede agregar el producto si algunos de los campos esta vacio","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
   
    public void VaciarBDInventario(){
        try{
            
               Statement st = cn.createStatement();
               st.execute("DELETE FROM inventario");
   
        }catch (SQLException e) {
                System.err.println("Error al vaciar la base de datos inventario." + e);
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
        }
         
    }
    public void EliminarProductoconBD(){  
        int fila=-1;
        String id="";
        fila= TablaProductos.getSelectedRow();
        if(fila!=-1){
            VaciarBDInventario();
             
            ListaProduc.EliminarProducto(fila);
               
                
            InsertarProductoBD(ListaProduc);
            LlenarTablaProductos(TablaProductos);
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente el producto");
           
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para poder eliminarla","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void ModificarProducto(){
        int fila=-1;
        int columna=-1;
        fila= TablaProductos.getSelectedRow();
        columna= TablaProductos.getSelectedColumn();
        if(fila!=-1 && columna!=-1){
            VaciarBDInventario();
            ListaProduc.ModificarProducto(fila, columna);
           
            InsertarProductoBD(ListaProduc);
            LlenarTablaProductos(TablaProductos);
               
         
          
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila y columna del dato del producto a modificar","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
 ///////////////////////////////////////////////////ADMINISTRADOR/////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
   
     public void VaciarCamposAdmin(){
        Nombretxtx.setText("");
        Telefonotxt.setText("");
        Cedulatxt.setText("");
        Direcciontxt.setText("");
        Usuariotxt.setText("");
        Passwordtxt.setText(""); 
        ErrorNombre.setText("");
        ErrorCedula.setText("");
        ErrorTelefono.setText("");
        ErrorDireccion.setText("");
    }
    
    public void VaciarBDadmin(){
        try{
            
               Statement st = cn.createStatement();
               st.execute("DELETE FROM administradores");
   
        }catch (SQLException e) {
                System.err.println("Error al vaciar la base de datos administradores." + e);
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
        }
         
    }
     public void  LlenarArrayListAdminconBD(){
        try{
           
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM administradores");
            String datos[]= new String[7]; 
            ListaAdmin.getAdministradores().clear();
            while (rs.next()) {
                Administrador admin = new Administrador();
                datos[0]=rs.getString(1); // nombre
                datos[1]=rs.getString(2); // cedula
                datos[2]=rs.getString(3); // telefono
                datos[3]=rs.getString(4); //direccion
                datos[4]=rs.getString(5);  // usuario
                datos[5]=rs.getString(6); // password
                datos[6]=rs.getString(7); // fecha de ingreso
                ///////////////////////
                admin.IngresarAdministrador(datos[4], datos[5], datos[0], datos[1], datos[2], datos[3]);
                admin.setFechaIngreso(datos[6]);
                /////////////////
                ListaAdmin.getAdministradores().add(admin);
           
            }
         
        }catch(Exception e){
             System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
        }
            
    }
    public void LLenarCamposErrores(Administrador admin){
        if(admin.ValidarCedula(Cedulatxt.getText())== false){
            CrearFuentetoErrores(ErrorCedula);          
            ErrorCedula.setText("*Numeros entre 6 y 8 digitos");
        }
       
        if(admin.ValidarNombre(Nombretxtx.getText())== false){
            CrearFuentetoErrores(ErrorNombre);
            ErrorNombre.setText("*Cumplir formato [(N)ombre (A)pellido]");
        }
        if(admin.ValidarTelefono(Telefonotxt.getText())== false){
            CrearFuentetoErrores(ErrorTelefono);
            ErrorTelefono.setText("*Debe contener 11 digitos");
        }
         if(admin.ValidarDireccion(Direcciontxt.getText())== false){
             CrearFuentetoErrores(ErrorDireccion);
            ErrorDireccion.setText("*No todo puede estar en mayuscula");
        }
    }
    public boolean VerificarVaciosAdmin(){
         return "".equals(Telefonotxt.getText()) || "".equals(Nombretxtx.getText()) || "".equals(Cedulatxt.getText()) || "".equals(Direcciontxt.getText()) || "".equals(Usuariotxt.getText()) || "".equals(Passwordtxt.getText());
    }
    
    public void LlenarTablaAdmin(){
        String[] columna = {"Usuario", "Contraseña", "Fecha Ingreso"};
        DefaultTableModel dtm = new DefaultTableModel(null,columna){
          @Override
          public boolean isCellEditable(int row, int column){
              return false; 
          }
        };
        for (Administrador admin :  ListaAdmin.getAdministradores())  { 
             
               String[] row = {admin.getUsuario(), admin.getContraseña(), admin.getFechaIngreso()};
               dtm.addRow(row);
        }
      TablaAdmin.setModel(dtm);    
    
    }
   
    public void InsertarAdminBD(PersonalAdministrativo admin){
        try {
            Statement stm= (Statement) cn.createStatement();
   
            for (int i=0; i<admin.getAdministradores().size();i++){ 
              
                 String Nombre=ListaAdmin.getAdministradores().get(i).getNombre();
                 String Cedula=ListaAdmin.getAdministradores().get(i).getCedula();
                 String Telefono= ListaAdmin.getAdministradores().get(i).getTelefono();
                 String Direccion=ListaAdmin.getAdministradores().get(i).getDireccion();
                 String Usuario=ListaAdmin.getAdministradores().get(i).getUsuario();
                 String Password=ListaAdmin.getAdministradores().get(i).getContraseña();
                 String Fecha_Ingreso= ListaAdmin.getAdministradores().get(i).getFechaIngreso();
                
                 String insert="INSERT INTO administradores VALUES('"+Nombre+"','"+Cedula+"','"+Telefono+"','"+Direccion+"','"+Usuario+"','"+Password+"','"+Fecha_Ingreso+"');";
         
                stm.executeUpdate(insert);
            }
           
        } catch (SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
        
    }
    
    public void AgregarAdministradorBoton(){
        Administrador admin = new Administrador();
        if(VerificarVaciosAdmin()!=true){
            if(admin.ValidarCedula(Cedulatxt.getText())== true && admin.ValidarDireccion(Direcciontxt.getText())== true && admin.ValidarNombre(Nombretxtx.getText())==true && admin.ValidarTelefono(Telefonotxt.getText())== true){
                admin.IngresarAdministrador(Usuariotxt.getText(), Passwordtxt.getText(),Nombretxtx.getText(), Cedulatxt.getText(),Telefonotxt.getText(), Direcciontxt.getText());
               
                ListaAdmin.RegistrarPerfil(admin);
                ////////// con conexion bd
                VaciarBDadmin();
                InsertarAdminBD(ListaAdmin);               
                LlenarTablaAdmin();
                //////////
              
                VaciarCamposAdmin();
                
            }else{
                LLenarCamposErrores(admin);  
              
            }
        }else{
            JOptionPane.showMessageDialog(null, "No se puede agregar al administrador si algunos de los campos esta vacio","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void EliminarAdministrador(){ // probar
      
        int fila=-1;
   
        fila= TablaAdmin.getSelectedRow();
        if(fila!=-1){
            VaciarBDadmin();
            ListaAdmin.EliminarPerfil(fila);
            
            InsertarAdminBD(ListaAdmin);          
            LlenarTablaAdmin();
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para poder eliminarla","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
        
    
    }
    public void ModificarAdministrador(){ ///probar
        int fila=-1;
        int columna=-1;
        fila= TablaAdmin.getSelectedRow();
        columna= TablaAdmin.getSelectedColumn();
        if(fila!=-1 && columna!=-1){
            VaciarBDadmin();
            ListaAdmin.ModificarAdministrador(fila, columna);
            InsertarAdminBD(ListaAdmin);  
            LlenarTablaAdmin();
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila y columna del dato del producto a modificar","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void ConsultarAdministrador(){
        int fila=-1;
       
        fila= TablaAdmin.getSelectedRow();
        if(fila!=-1){
            ListaAdmin.ConsultarAdministrador(fila);
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila y columna del dato del producto a modificar","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
  
    ///////////////////////////////////////////////////////////////////INVENTARIO/////////////////////////////////////////////////////////////////////////////////////////////////////////

    
    
    public void OrdenarMayorMenorPorVentas(){
        ListaProduc.OrdenarMayorAMenor();  
        LlenarTablaProductos(TablaInventario);
   
    }
  
    public void GenerarReporteInventarioPDF(){
        ReporteInv.ReportesInventario();
    }
     public void OrdenarMenorMayorPorVentas(){
       
       
        ListaProduc.OrdenarMenorAMayor();
        LlenarTablaProductos(TablaInventario);
      
    }
    public void ConsultarInventario(String Codigo){
       ListaProduc.ConsultarProducto(Codigo);
    } 
///////////////////////////////LOGIN ADMIN////////////////////////////////////////////////
    
    
    public int IniciarSesionAdmin(){
        if(ListaAdmin.InicioSesion(Usuariotxt.getText(), Passwordtxt.getText()) ==1){
            VaciarBDadmin();
            InsertarAdminBD(ListaAdmin);  
           
        }
        return ListaAdmin.InicioSesion(Usuariotxt.getText().trim(), Passwordtxt.getText().trim());
    }
    
    public void LLenarSaludo(JTextField User, JTextField Password){
        Font fuente = new Font("", Font.BOLD, 45);
        Usuariotxt.setForeground(new java.awt.Color(153,204,255));
        Usuariotxt.setFont(fuente);
        
        for(Administrador admin : ListaAdmin.getAdministradores()){
           
            if(admin.getUsuario().equals(User.getText().trim()) && admin.getContraseña().equals(Password.getText().trim())){
                
                Usuariotxt.setText(admin.getNombre().trim());
            }
        }
    }
  ///////////////////////////////Llenar Tabla Proveedor/////////////////////////////////////////
    
    public void LlenarRegistroProveedorBD(){  //// cambiar ListaProcuProveedor por un objeto de Proveedor
        try {
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM proveedores_productos");
            String datos[]= new String[9]; 
            ListaProducProveedor.getNuevoCatalogo().clear();
          
            while (rs.next()) {
                Producto prod = new Producto();
                datos[0]=rs.getString(1); // nombre
                datos[1]=rs.getString(2); // codigo
                datos[2]=rs.getString(3); // precio
                datos[3]=rs.getString(4); //costo
                datos[4]=rs.getString(5);  // vencimeinto
                datos[5]=rs.getString(6); // lote
                datos[6]=rs.getString(7); // existencia
                datos[7]=rs.getString(8); //vendidas
                datos[8]=rs.getString(9); // en oferta

                prod.IngresarDatosCompletosBD(datos[0],datos[1], datos[3], datos[2], datos[6],datos[5],datos[7],datos[4],datos[8]);
                
                ListaProducProveedor.getNuevoCatalogo().add(prod);
           
            }
        } catch (SQLException e) {
            
             System.out.println("Error en conexión local " + e);
             JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void LlenarTablaProveedor(JTable TablaProductos) {  //cambiar ListaProcuProveedor por un objeto de Proveedor
        
            String[] columna = {"Nombre","Código", "Precio", "Costo", "F.Vencimiento", "N° Lote", "N° Existencia", "Unid.Vendidas", "En Oferta"};
            DefaultTableModel dtm = new DefaultTableModel(null, columna){
              @Override
              public boolean isCellEditable(int row, int column){
                  return false; 
              }
            };  
           
            for (int i=0; i<ListaProducProveedor.getNuevoCatalogo().size(); i++) { 
                String[] row = {ListaProducProveedor.getNuevoCatalogo().get(i).getNombre(), ListaProducProveedor.getNuevoCatalogo().get(i).getCodigo(), Float.toString(ListaProducProveedor.getNuevoCatalogo().get(i).getPrecio()),Float.toString(ListaProducProveedor.getNuevoCatalogo().get(i).getCosto()), ListaProducProveedor.getNuevoCatalogo().get(i).getFechaVencimiento(), Integer.toString(ListaProducProveedor.getNuevoCatalogo().get(i).getLote()), Integer.toString(ListaProducProveedor.getNuevoCatalogo().get(i).getNumExistencia()), Integer.toString(ListaProducProveedor.getNuevoCatalogo().get(i).getNumVendidas()), ListaProducProveedor.getNuevoCatalogo().get(i).getOferta()};
               dtm.addRow(row);
     
            }
           TablaProductos.setModel(dtm);
    }
    ////////////////////////////METODOS CLIENTE//////////////////////////////////////
  
    public void ConsultarCarrito(String Codigo){
        client.MostrarDatos(Codigo);
    }
    public Transaccion getListaCarritodeCliente(){
        return client;
    }
    public void LlenarTablaCarrito(){
        String[] columna = {"Nombre","Código", "Precio","Fecha de Vencimiento", "Cantidad a llevar"};
            DefaultTableModel dtm = new DefaultTableModel(null, columna){
              @Override
              public boolean isCellEditable(int row, int column){
                  return false; 
              }
            };  
           
            for (int i=0; i< client.getCarrito().size(); i++) { 
                String[] row = {client.getCarrito().get(i).getNombre(), client.getCarrito().get(i).getCodigo(), Float.toString(client.getCarrito().get(i).getPrecio()),client.getCarrito().get(i).getFechaVencimiento(),Integer.toString(client.getCarrito().get(i).getNumExistencia())};
               dtm.addRow(row);
     
            }
        TablaCarrito.setModel(dtm);
    }
    
    public void AgregaraCarrito(){
       int fila=-1;
       
        fila= TablaInventario.getSelectedRow();
        if(fila!=-1){
           
            client.AgregarCarrito(ListaProduc.getProductos(), fila);
            LlenarTablaCarrito();
            client.CalcularMonto();
            Costotxt.setText(Float.toString(client.getMonto()));
           
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila que desea agregar al carrito","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void EliminarProductodeCarrito(){
        int fila=-1;
       
        fila= TablaCarrito.getSelectedRow();
        if(fila!=-1){
            client.EliminarCarrito(fila);          
            LlenarTablaCarrito();
            client.CalcularMonto();
            Costotxt.setText(Float.toString(client.getMonto()));
            
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar la fila que desea eliminar al carrito","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void VaciarCarrito(){
        client.VaciarCarrito();
        LlenarTablaCarrito();
        client.CalcularMonto();
        Costotxt.setText(Float.toString(client.getMonto()));
    }
  ////////////////////////Metodos para Productos Reponer//////////////////////////////////////////////
    public void LLenarTablaReponerProduc(){
        String[] columna = {"Nombre","Código", "Precio", "Costo", "F.Vencimiento", "N° Lote", "N° Existencia", "Unid.Vendidas", "En Oferta"};
            DefaultTableModel dtm = new DefaultTableModel(null, columna){
              @Override
              public boolean isCellEditable(int row, int column){
                  return false; 
              }
            };  
           
            for (int i=0; i<ListaProduc.getProductos().size(); i++) { 
               if(ListaProduc.getProductos().get(i).getNumExistencia()<=5){
                    String[] row = {ListaProduc.getProductos().get(i).getNombre(), ListaProduc.getProductos().get(i).getCodigo(), Float.toString(ListaProduc.getProductos().get(i).getPrecio()),Float.toString(ListaProduc.getProductos().get(i).getCosto()), ListaProduc.getProductos().get(i).getFechaVencimiento(), Integer.toString(ListaProduc.getProductos().get(i).getLote()), Integer.toString(ListaProduc.getProductos().get(i).getNumExistencia()), Integer.toString(ListaProduc.getProductos().get(i).getNumVendidas()), ListaProduc.getProductos().get(i).getOferta()};
                    dtm.addRow(row);
               }
     
            }
           TablaInventario.setModel(dtm);

    }
  
    public void MenoraMayorExistencia(){
        ListaProduc.OrdenarListaExistenciaMenorAMayor();  
        LLenarTablaReponerProduc();
    }
    
    public void InsertarProductoProveedorBD( Proveedor ListaProd){
        try {
            Statement stm= (Statement) cn.createStatement();
           
            for (int i=0; i<ListaProd.getNuevoCatalogo().size();i++)  { 
              
                 String Nombre=ListaProd.getNuevoCatalogo().get(i).getNombre();
                 String Cod=ListaProd.getNuevoCatalogo().get(i).getCodigo();
                 String Fecha= ListaProd.getNuevoCatalogo().get(i).getFechaVencimiento();
                 Float prec=ListaProd.getNuevoCatalogo().get(i).getPrecio();
                 Float costo=ListaProd.getNuevoCatalogo().get(i).getCosto();
                 int Exis=ListaProd.getNuevoCatalogo().get(i).getNumExistencia();
                 int vendidas= ListaProd.getNuevoCatalogo().get(i).getNumVendidas();
                 int lote = ListaProd.getNuevoCatalogo().get(i).getLote();
                 String oferta= ListaProd.getNuevoCatalogo().get(i).getOferta();
                 String insert="INSERT INTO proveedores_productos VALUES('"+Nombre+"','"+Cod+"','"+prec+"','"+costo+"','"+Fecha+"','"+lote+"','"+Exis+"','"+vendidas+"','"+oferta+"');";
            
                stm.executeUpdate(insert);
            }
           
        } catch (SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
       
    }
   public void VaciarBDProveedor(){
        try{
            
            Statement st = cn.createStatement();
            st.execute("DELETE FROM proveedores_productos");
   
        }catch (SQLException e) {
            System.err.println("Error al vaciar la base de datos proveedor." + e);
            JOptionPane.showMessageDialog(null, "Error al eliminar producto");
        }
         
    }
    public void ReponerProductos(){//YA SIRVE
        int fila;
   
        fila= TablaInventario.getSelectedRow();
        if(fila>=0){
            ListaProduc.setProductos(ListaProducProveedor.ReponerInventario(ListaProduc.getProductos(),fila));   
            VaciarBDProveedor();
            InsertarProductoProveedorBD(ListaProducProveedor);
            VaciarBDInventario();
            InsertarProductoBD(ListaProduc);
            LLenarTablaReponerProduc();
           
        }else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila para poder reponer ese producto","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }   
    }
    
    ////////////////////////Metodos Compra Parte Cliente//////////////////////////////////
    public void LlenarDatos(String nombre,String telefono,String cedula,String direccion){
        Nombretxtx.setText(nombre);
        Telefonotxt.setText(telefono);
        Cedulatxt.setText(cedula);
        Direcciontxt.setText(direccion);
    }
    
    public void VerificarExistenciaCliente(String Cedula){
        ArrayList<Persona> compradores;
        compradores = new ArrayList<>();
        try{
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery(" SELECT * FROM compradores ");
            String datos[]= new String[4]; 
            while (rs.next()) {
                Persona comp=new Persona();
                datos[0]=rs.getString(1); // nombre
                datos[1]=rs.getString(2); // cedula
                datos[2]=rs.getString(3); // telefono
                datos[3]=rs.getString(4); //direccion
                comp.IngresarDatosCompletosBD(datos[0],datos[1], datos[2], datos[3]);

                compradores.add(comp);
            }
        }catch(Exception e){
            System.err.println("Error al llenar arraylist." + e);
            JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
        }
        boolean validar=false;
        for (int i = 0; i < compradores.size(); i++) {
            if (validar==false) {
                if (compradores.get(i).getCedula().equals(Cedula)) {
                    validar=true;
                    String Nombre=compradores.get(i).getNombre();
                    String Direccion= compradores.get(i).getDireccion();
                    String Telefono= compradores.get(i).getTelefono();
                    LlenarDatos(Nombre,Telefono,Cedula,Direccion);
                }
            }
        }
        if (validar==false && Cedula!=null) {
            JOptionPane.showMessageDialog(null, "No se encontro la cedula ingresada");
        }
    }
    public boolean VerificarVaciosDatosCliente(){
      
        return Nombretxtx.getText().isEmpty() || Cedulatxt.getText().isEmpty() || Telefonotxt.getText().isEmpty() || Direcciontxt.getText().isEmpty() || (PagoTarjeta.isSelected() && PagoEfectivo.isSelected()); 
    }
    public void VaciarCamposVenta(){
        Nombretxtx.setText("");
        Telefonotxt.setText("");
        Cedulatxt.setText("");
        Direcciontxt.setText("");
        NumTarjetatxt.setText("");
        ErrorNombre.setText("");
        ErrorCedula.setText("");
        ErrorTelefono.setText("");
        ErrorDireccion.setText("");
        ErrorTarjeta.setText("");
        TotalPagartxt.setText("");
        AmbasOpciones.clearSelection();
    }
    public void LlenarCampoErrores(Transaccion Compra){
     
        if(Compra.ValidarCedula(Cedulatxt.getText())== false){
            CrearFuentetoErrores(ErrorCedula);          
            ErrorCedula.setText("*Numeros entre 6 y 8 digitos");
        }
       
        if(Compra.ValidarNombre(Nombretxtx.getText())== false){
            CrearFuentetoErrores(ErrorNombre);
            ErrorNombre.setText("*Cumplir formato [(N)ombre (A)pellido]");
        }
        if(Compra.ValidarTelefono(Telefonotxt.getText())== false){
            CrearFuentetoErrores(ErrorTelefono);
            ErrorTelefono.setText("*Debe contener 11 digitos");
        }
        if(Compra.ValidarDireccion(Direcciontxt.getText())== false){
            CrearFuentetoErrores(ErrorDireccion);
            ErrorDireccion.setText("*No todo puede estar en mayuscula");
        }
        if((NumTarjetatxt.getText().length()>18 ||NumTarjetatxt.getText().length()<18) && (PagoTarjeta.isSelected()==true) ){
            CrearFuentetoErrores(ErrorTarjeta);
            ErrorTarjeta.setText("*El N° tarjeta no debe sobrepasar ni se menor los 18 digitos, ni debe estar vacio");
        }
    }
    public void IngresarVentaBD(ReportesPDF ListaVentas){
        try {
            Statement stm= (Statement) cn.createStatement();
           
            for (int i=0; i<ListaVentas.getTransacciones().size();i++)  { 
                 
                 String Nombre=ListaVentas.getTransacciones().get(i).getNombre();
                 String Cedula= ListaVentas.getTransacciones().get(i).getCedula();
                 String Telefono=ListaVentas.getTransacciones().get(i).getTelefono();
                 String Direccion= ListaVentas.getTransacciones().get(i).getDireccion();
                 Float monto=ListaVentas.getTransacciones().get(i).getMonto();
                 String TipoPago=ListaVentas.getTransacciones().get(i).getTipodePago();
                 int NumFactura=ListaVentas.getTransacciones().get(i).getNumFactura();
                 String NumTarjeta= ListaVentas.getTransacciones().get(i).getNumTarjeta();               
                 String Fecha= ListaVentas.getTransacciones().get(i).getFecha();
                
                 String insert="INSERT INTO ventas VALUES('"+Nombre+"','"+Cedula+"','"+Telefono+"','"+Direccion+"','"+monto+"','"+TipoPago+"','"+NumFactura+"','"+NumTarjeta+"','"+Fecha+"');";
            
                stm.executeUpdate(insert);
            }
           
        } catch (SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
    }
      public void VaciarBDVentas(){
        try{
            
            Statement st = cn.createStatement();
            st.execute("DELETE FROM ventas");
   
        }catch (SQLException e) {
                System.err.println("Error al vaciar la base de datos ventas." + e);
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
        }
         
    }
    public void ConfirmaciondeCompra(JFrame origen){
        LlenarArrayListconBD();
        Transaccion Compra = new Transaccion();
       
        if(VerificarVaciosDatosCliente()==false){
        
            if(Compra.ValidarCedula(Cedulatxt.getText())==true && Compra.ValidarNombre(Nombretxtx.getText())==true && Compra.ValidarTelefono(Telefonotxt.getText())== true && Compra.ValidarDireccion(Direcciontxt.getText())== true){
                
                if(((NumTarjetatxt.getText().length()==18)==true && PagoTarjeta.isSelected()==true) || PagoEfectivo.isSelected()==true){
                    int Tpago=0;
                    if((NumTarjetatxt.getText().length()==18)==true && PagoTarjeta.isSelected()==true){
                       Tpago=1;
                    }
                    if(PagoEfectivo.isSelected()==true){
                        Tpago=2;
                    }
                    ListaProduc.setProductos(Compra.RealizarCompra(ListaProduc.getProductos(),Tpago,NumTarjetatxt.getText(), Nombretxtx.getText(), Cedulatxt.getText(), Telefonotxt.getText(), Direcciontxt.getText(), ReporteInv.getTransacciones(), producaCompras.getCarrito()));
                    String Cedula=Cedulatxt.getText().trim();
                    String Nombre=Nombretxtx.getText().trim();
                    String Direccion= Direcciontxt.getText().trim();
                    String Telefono= Telefonotxt.getText().trim();
                    ReporteInv.IngresarTransaccion(Compra);
                    VaciarBDVentas();
                    IngresarVentaBD(ReporteInv);  
                    ////////////////////////////////////////////////
                    JOptionPane.showMessageDialog(null, "Registro exitoso.");
                    ReporteInv.FacturadeCompra(producaCompras, Compra);

                    /////////////////////////////////////////////////
                    VaciarCamposVenta();
                    VaciarBDInventario();
                    InsertarProductoBD(ListaProduc);
                    ////METER USUARIO SI NO EXISTE EN LA BASE DE DATOS///
                    ArrayList<Persona> compradores;
                    compradores = new ArrayList<>();
                    try{
          
                    Statement pst = cn.createStatement();
                    ResultSet rs= pst.executeQuery(" SELECT * FROM compradores ");
                    String datos[]= new String[4]; 
                    
                    while (rs.next()) {
                            Persona comp=new Persona();
                            datos[0]=rs.getString(1); // nombre
                            datos[1]=rs.getString(2); // cedula
                            datos[2]=rs.getString(3); // telefono
                            datos[3]=rs.getString(4); //direccion
                           

                            comp.IngresarDatosCompletosBD(datos[0],datos[1], datos[2], datos[3]);

                            compradores.add(comp);

                    }
                    }catch(Exception e){
                         System.err.println("Error al llenar arraylist." + e);
                         JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
                    }
                    boolean validar=false;
                    for (int i = 0; i < compradores.size(); i++) {
                        if (compradores.get(i).getCedula().trim().equals(Cedula.trim())) {
                            validar=true;
                        }
                    }
                    if (validar==false) {
                        Persona comp=new Persona();
                        comp.setCedula(Cedula);
                        comp.setDireccion(Direccion);
                        comp.setNombre(Nombre);
                        comp.setTelefono(Telefono);
                        compradores.add(comp);
                        try{
                            Statement st = cn.createStatement();
                            st.execute("DELETE FROM compradores");
                        }catch (SQLException e) {
                            System.err.println("Error al vaciar la base de datos compradores." + e);
                            JOptionPane.showMessageDialog(null, "Error al eliminar comprador");
                        }
                        try {
                            Statement stm= (Statement) cn.createStatement();

                            for (int i=0; i<compradores.size();i++){ 

                                 String nombre=compradores.get(i).getNombre();
                                 String cedula=compradores.get(i).getCedula();
                                 String telefono= compradores.get(i).getTelefono();
                                 String direccion=compradores.get(i).getDireccion();

                                 String insert="INSERT INTO compradores VALUES('"+nombre+"','"+cedula+"','"+telefono+"','"+direccion+"');";

                                stm.executeUpdate(insert);
                            }

                        } catch (SQLException e) {
                             System.err.println("Error al ingresarlo en la BD " + e);
                             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
                        }
                    }
                    //////////////////////VOLVER//////////////////////////////////
                    Cliente destino = new  Cliente();
                    activaVentana(destino, origen);

                   
                }else{
                    
                    if(PagoTarjeta.isSelected()==true){                      
                       LlenarCampoErrores(Compra);     
                    } 
                    if(PagoEfectivo.isSelected()==true){
                        ErrorTarjeta.setText("");
                    }
                }
               
            }else{
                 
               LlenarCampoErrores(Compra);    
               if(PagoEfectivo.isSelected()==true){
                   ErrorTarjeta.setText(""); 
               }
            }
        }else{
             JOptionPane.showMessageDialog(null,"Registo invalido, hay campos vacios ","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    ///////////////////////////////////VENTAS HISTORIAL EN ADMIN////////////////////////////////////////////
      public void GenerarReporteVentasPDF(){
        ReporteInv.ReporteVentas();
    }
    public void LlenarArrayHistorialVentasBD(){
        try{   
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM ventas");
            String datos[]= new String[9]; 
            ReporteInv.getTransacciones().clear();
          
            while (rs.next()) {
                Transaccion Compra = new Transaccion();
                datos[0]=rs.getString(1); // nombre
                datos[1]=rs.getString(2); // cedula
                datos[2]=rs.getString(3); // telefono
                datos[3]=rs.getString(4); //direccion
                datos[4]=rs.getString(5);  // Monto
                datos[5]=rs.getString(6); // tipo pago
                datos[6]=rs.getString(7); // num factura
                datos[7]=rs.getString(8); //num tarjeta
                datos[8]=rs.getString(9); // fecha
                Compra.IngresarDatosCompletosBD(datos[0], datos[1], datos[2], datos[3], Float.parseFloat(datos[4]), datos[5],Integer.parseInt(datos[6]), datos[7], datos[8]);
                ReporteInv.IngresarTransaccion(Compra);
            }
        } catch (SQLException e){
            
             System.out.println("Error en conexión local " + e);
             JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
        }
    }
    public void LLenarTablaHistorialVentas(){
        String[] columna = {"Nombre del Comprador","Num Factura", "Monto Pagado", "Tipo Pago", "Fecha de la Compra"};
            DefaultTableModel dtm = new DefaultTableModel(null, columna){
              @Override
              public boolean isCellEditable(int row, int column){
                  return false; 
              }
            };  
           
            for (int i=0; i<ReporteInv.getTransacciones().size(); i++) { 
                String[] row = {ReporteInv.getTransacciones().get(i).getNombre(),Integer.toString(ReporteInv.getTransacciones().get(i).getNumFactura()), Float.toString(ReporteInv.getTransacciones().get(i).getMonto()),ReporteInv.getTransacciones().get(i).getTipodePago(), ReporteInv.getTransacciones().get(i).getFecha()};
                dtm.addRow(row);     
            }
           TablaVentas.setModel(dtm);
    }
    public void VerMayor(){
        ReporteInv.OrdenarMayorAMenor();
        LLenarTablaHistorialVentas();
    }
    public void VerMenor(){
        ReporteInv.OrdenarMenorAMayor();
        LLenarTablaHistorialVentas();
    }
    /////////////////////////////METODOS CLIENTES REGULARES////////////////////////////////////////
    public void VaciarBDClientes(){
        try{
            
            Statement st = cn.createStatement();
            st.execute("DELETE FROM clientes");
   
        }catch (SQLException e) {
                System.err.println("Error al vaciar la base de datos ventas." + e);
                JOptionPane.showMessageDialog(null, "Error al eliminar producto");
        }
    }
   
    public void InsertarClienteenBD(ReportesPDF ListaClientes){ /// para llenar la base de datos
        try {
            Statement stm= (Statement) cn.createStatement();
           
            for (int i=0; i<ListaClientes.getTransacciones().size();i++) { 
              
                 String Nombre=ListaClientes.getTransacciones().get(i).getNombre();
                 String Cedula=ListaClientes.getTransacciones().get(i).getCedula();
                 String Telefono= ListaClientes.getTransacciones().get(i).getTelefono();
                 String Direccion= ListaClientes.getTransacciones().get(i).getDireccion();
                 String insert="INSERT INTO clientes VALUES('"+Nombre+"','"+Cedula+"','"+Telefono+"','"+Direccion+"');";
            
                stm.executeUpdate(insert);
            }
           
        } catch (SQLException e) {
             System.err.println("Error al ingresarlo en la BD " + e);
             JOptionPane.showMessageDialog(null, "¡Contacte al administrador!");
        }
    }
     public void  LlenarArrayListClienteconBD(){
        try{
           
            Statement pst = cn.createStatement();
            ResultSet rs= pst.executeQuery("SELECT * FROM clientes");
            String datos[]= new String[4]; 
            ListaClientes.getTransacciones().clear();
            while (rs.next()) {
               Transaccion cliente = new Transaccion();
                datos[0]=rs.getString(1); // nombre
                datos[1]=rs.getString(2); // cedula
                datos[2]=rs.getString(3); // telefono
                datos[3]=rs.getString(4); //direccion
              
                ///////////////////////
                cliente.IngresarDatosCompletosBD(datos[0], datos[1], datos[2], datos[3], Float.parseFloat("0"), "",0,"","" );
               
                /////////////////
                ListaClientes.getTransacciones().add(cliente);
           
            }
         
        }catch(Exception e){
             System.err.println("Error al llenar arraylist." + e);
             JOptionPane.showMessageDialog(null, "Debe estara ctivo la base de datos, ¡Contacte al administrador!");
        }
            
    }
}
