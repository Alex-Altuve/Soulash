
package Model;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReportesPDF {
    private ArrayList<Transaccion> Transacciones;

    public ReportesPDF(ArrayList<Transaccion> Transacciones) {
        this.Transacciones = Transacciones;
    }

    public ReportesPDF() {
        Transacciones = new ArrayList<>();
    }
    public ArrayList<Transaccion> getTransacciones() {
        return Transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> Transacciones) {
        this.Transacciones = Transacciones;
    }
    
    
    public void ReportesInventario(){
        LocalDate fecha = LocalDate.now();
        try{
            Document documento = new Document();
            String ruta = "ReporteInventario.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();
            Image image1=null;
            try{
                image1=Image.getInstance("src/Imagenes/Imagen1.png");
                image1.scaleAbsolute(130,130);
                image1.setAbsolutePosition(30, 680);
            }catch(Exception e){
                System.out.println("error 1"+e);
            }
            documento.add(image1);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            Paragraph titulo2 = new Paragraph();
            titulo2.setAlignment(Paragraph.ALIGN_RIGHT);
            titulo2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD));
            titulo2.add("\n\nReporte de los productos en el Inventario\n");            
            titulo2.add("---------------------"+fecha.toString()+"-----------------------\n\n");
            documento.add(titulo2);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            Paragraph titulo3 = new Paragraph();
            titulo3.setAlignment(Paragraph.ALIGN_CENTER);
            titulo3.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD));
            titulo3.add("------Lista de Productos------\n\n");    
            documento.add(titulo3);
            
            PdfPCell nombreProd = new PdfPCell(new Phrase("Nombre"));
          
            nombreProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell codigoProd= new PdfPCell(new Phrase("Code"));
            codigoProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell precioProd = new PdfPCell(new Phrase("Precio"));
            precioProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell costo = new PdfPCell(new Phrase("Costo"));
            costo.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell vencimiento = new PdfPCell(new Phrase("F.Vcto"));
            vencimiento.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell nLote = new PdfPCell(new Phrase("N° Lote"));
            nLote.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell unidE = new PdfPCell(new Phrase("N° Stock"));
            unidE.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell unidV = new PdfPCell(new Phrase("N° Sold"));
            unidV.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell oferta= new PdfPCell(new Phrase("En Oferta"));
            oferta.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
            PdfPTable tabla = new PdfPTable(9);
            Font fuente= new Font();
            fuente.setSize(12);
            
            tabla.setWidthPercentage(100);
            tabla.addCell(nombreProd);
            tabla.addCell(codigoProd);
            tabla.addCell(precioProd);
            tabla.addCell(costo);
            tabla.addCell(vencimiento);
            tabla.addCell(nLote);
            tabla.addCell(unidE);
            tabla.addCell(unidV);
            tabla.addCell(oferta);
            try{
                 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_soulash","root","");
                 System.out.println("Conexion establecida...");
                Statement stmt=cn.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from inventario");
               
                while(rs.next()){
                   
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));
                            tabla.addCell(rs.getString(5));
                            tabla.addCell(rs.getString(6));
                            tabla.addCell(rs.getString(7));
                            tabla.addCell(rs.getString(8));
                            tabla.addCell(rs.getString(9));
                       
                    
                }
            
                cn.close(); 
            }catch(Exception e){
                 System.out.println("error 2"+e);
            }
            documento.add(tabla);
            documento.close();
             JOptionPane.showMessageDialog(null,  "Se creo el archivo 'ReporteInventario.pdf' en la carpeta del proyecto");
        }catch(Exception e){
             System.out.println("error 3"+e);
        }
    }    
    
    public void ReporteVentas(){
            LocalDate fecha = LocalDate.now();
        try{
            Document documento = new Document();
            String ruta = "ReporteVentas.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();
            Image image1=null;
            try{
                image1=Image.getInstance("src/Imagenes/Imagen1.png");
                image1.scaleAbsolute(130,130);
                image1.setAbsolutePosition(30, 680);
            }catch(Exception e){
                System.out.println("error 1"+e);
            }
            documento.add(image1);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            Paragraph titulo2 = new Paragraph();
            titulo2.setAlignment(Paragraph.ALIGN_RIGHT);
            titulo2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD));
            titulo2.add("\n\nReporte de las Ventas                    \n");            
            titulo2.add("---------------------"+fecha.toString()+"-----------------------\n\n");
            documento.add(titulo2);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            
            Paragraph titulo3 = new Paragraph();
            titulo3.setAlignment(Paragraph.ALIGN_CENTER);
            titulo3.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD));
            titulo3.add("------Lista de Ventas------\n\n");    
            documento.add(titulo3);
            
            PdfPCell nombreProd = new PdfPCell(new Phrase("Nombre"));
          
            nombreProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell cedulaProd= new PdfPCell(new Phrase("Cedula"));
            cedulaProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell telefonoProd = new PdfPCell(new Phrase("Telefono"));
            telefonoProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell direccion = new PdfPCell(new Phrase("Direccion"));
            direccion.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell monto = new PdfPCell(new Phrase("Monto Pagado"));
            monto.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell tipo_pago = new PdfPCell(new Phrase("Tipo de Pago"));
            tipo_pago.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell nfactura = new PdfPCell(new Phrase("N° Factura"));
            nfactura.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell numtarjeta = new PdfPCell(new Phrase("N° Tarjeta"));
            numtarjeta.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell nfecha= new PdfPCell(new Phrase("Fecha"));
            nfecha.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
            PdfPTable tabla = new PdfPTable(9);
            Font fuente= new Font();
            fuente.setSize(12);
            
            tabla.setWidthPercentage(100);
            tabla.addCell(nombreProd);
            tabla.addCell(cedulaProd);
            tabla.addCell(telefonoProd);
            tabla.addCell(direccion);
            tabla.addCell(monto);
            tabla.addCell(tipo_pago);
            tabla.addCell(nfactura);
            tabla.addCell(numtarjeta);
            tabla.addCell(nfecha);
            try{
                 Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_soulash","root","");
                 System.out.println("Conexion establecida...");
                Statement stmt=cn.createStatement();  
                ResultSet rs=stmt.executeQuery("select * from ventas");
               
                while(rs.next()){
                   
                            tabla.addCell(rs.getString(1));
                            tabla.addCell(rs.getString(2));
                            tabla.addCell(rs.getString(3));
                            tabla.addCell(rs.getString(4));
                            tabla.addCell(rs.getString(5));
                            tabla.addCell(rs.getString(6));
                            tabla.addCell(rs.getString(7));
                            tabla.addCell(rs.getString(8));
                            tabla.addCell(rs.getString(9));
                       
                    
                }
            
                cn.close(); 
            }catch(Exception e){
                 System.out.println("error 2"+e);
            }
            documento.add(tabla);
            documento.close();
             JOptionPane.showMessageDialog(null,  "Se creo el archivo 'ReporteVentas.pdf' en la carpeta del proyecto");
        }catch(Exception e){
             System.out.println("error 3"+e);
        }
    
    
    }
    
    
    //////Terminar Factura
    public void FacturadeCompra(Transaccion ListaCarrito, Transaccion DatosCliente){
        LocalDate fecha = LocalDate.now();
        
        try{
            Document documento = new Document();
            String ruta = "FacturaCompra.pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();
            Image image1=null;
            try{
                image1=Image.getInstance("src/Imagenes/Imagen1.png");
                image1.scaleAbsolute(130,130);
                image1.setAbsolutePosition(30, 680);
            }catch(Exception e){
                System.out.println("error 1"+e);
            }
            documento.add(image1);
            
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
      
            
            Paragraph texto2= new Paragraph();          
            texto2.setAlignment(Paragraph.ALIGN_RIGHT);     
            texto2.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD));
            texto2.add("\n\nFactura de la Compra N ("+DatosCliente.getNumFactura()+")         "); 
            texto2.add("\n---------------------"+fecha.toString()+"-----------------------\n\n"); 
            documento.add(texto2);
            
            Paragraph texto3= new Paragraph();          
            texto3.setAlignment(Paragraph.ALIGN_CENTER);     
            texto3.setFont(FontFactory.getFont("Tahoma", 15, Font.BOLD));
           
            texto3.add("    R.I.F.: J-00012255-5\n\n"); 
            documento.add(texto3);
            documento.add(Chunk.NEWLINE);
            documento.add(Chunk.NEWLINE);
       
            
            Paragraph texto1= new Paragraph();
           
            texto1.setAlignment(Paragraph.ALIGN_LEFT);
            texto1.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD));
            texto1.add("\nDATOS DEL CLIENTE\n");          
            texto1.add("\nNOMBRE -> "+DatosCliente.getNombre());
            texto1.add("\nCEDULA -> "+DatosCliente.getCedula()); 
            texto1.add("\nTELEFONO -> "+DatosCliente.getTelefono());
            texto1.add("\nDIRECCION-> "+DatosCliente.getDireccion());
            texto1.add("\nTIPO DE PAGO-> "+DatosCliente.getTipodePago());
            if("Tarjeta".equals(DatosCliente.getTipodePago())){
               texto1.add("\nNÚMERO DE TARJETA-> "+DatosCliente.getNumTarjeta());
            }
          
            documento.add(texto1);
            documento.add(Chunk.NEWLINE);
          
            Paragraph titulo3 = new Paragraph();
            titulo3.setAlignment(Paragraph.ALIGN_CENTER);
            titulo3.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD));
            titulo3.add("\n\n------Lista de los productos comprados------\n\n");  
          
            documento.add(titulo3);
            
            PdfPCell nombreProd = new PdfPCell(new Phrase("Nombre"));          
            nombreProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell codigoProd= new PdfPCell(new Phrase("Codigo"));
            codigoProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell precioProd = new PdfPCell(new Phrase("Precio"));
            precioProd.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell vencimiento = new PdfPCell(new Phrase("F.Vcto"));
            vencimiento.setBackgroundColor(BaseColor.LIGHT_GRAY);
            PdfPCell cantidad = new PdfPCell(new Phrase("Cantidad a llevar"));
            cantidad.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
           
            PdfPTable tabla = new PdfPTable(5);
          
            tabla.setWidthPercentage(100);
            tabla.addCell(nombreProd);
            tabla.addCell(codigoProd);
            tabla.addCell(precioProd);
            tabla.addCell(vencimiento);
            tabla.addCell(cantidad);
         
            for(int i=0; i< ListaCarrito.getCarrito().size(); i++){
                 tabla.addCell(ListaCarrito.getCarrito().get(i).getNombre());
                 tabla.addCell(ListaCarrito.getCarrito().get(i).getCodigo());
                 tabla.addCell(Float.toString(ListaCarrito.getCarrito().get(i).getPrecio()));
                 tabla.addCell(ListaCarrito.getCarrito().get(i).getFechaVencimiento());
                 tabla.addCell(Integer.toString(ListaCarrito.getCarrito().get(i).getNumExistencia()));
              
            }
            documento.add(tabla);
            /////////////////////////////////
            documento.add(Chunk.NEWLINE);
            Paragraph titulo4 = new Paragraph();
            titulo4.setAlignment(Paragraph.ALIGN_LEFT);
            titulo4.setFont(FontFactory.getFont("Tahoma", 12, Font.BOLD));
            titulo4.add("----> TOTAL A PAGAR "+DatosCliente.getMonto());
            documento.add(titulo4);
            ////////////////////////////////////////////////
            documento.close();
             JOptionPane.showMessageDialog(null,  "Se creo el archivo 'FacturaCompra.pdf' en la carpeta del proyecto");
        }catch(Exception e){
             System.out.println("error 3"+e);
        }
    }    
    
    
    
    public void IngresarTransaccion (Transaccion Cuenta){
       Transacciones.add(Cuenta);
    }
     public void OrdenarMayorAMenor(){ //METODO DE BURBUJA
       
       if ( Transacciones!=null &&  Transacciones.isEmpty()==false) {
           int largo= Transacciones.size()-1;
           Transaccion Aux=new Transaccion();
           for (int i = 0; i < largo; i++) {
               for (int j = 0; j < largo; j++) {
                   if ( Transacciones.get(j).getMonto()< Transacciones.get(j+1).getMonto()) {
                       Aux= Transacciones.get(j);
                        Transacciones.set(j,  Transacciones.get(j+1));
                        Transacciones.set((j+1), Aux);
                   }
               }
           }
       } else {
           JOptionPane.showMessageDialog(null, "La lista esta vacia ", "Warning", JOptionPane.WARNING_MESSAGE);    
       }
   }   
    public void OrdenarMenorAMayor(){ //METODO DE BURBUJA
       
       if ( Transacciones!=null &&  Transacciones.isEmpty()==false) {
           int largo= Transacciones.size()-1;
           Transaccion Aux=new Transaccion();
           for (int i = 0; i < largo; i++) {
               for (int j = 0; j < largo; j++) {
                   if ( Transacciones.get(j).getMonto()> Transacciones.get(j+1).getMonto()) {
                       Aux= Transacciones.get(j);
                        Transacciones.set(j,  Transacciones.get(j+1));
                        Transacciones.set((j+1), Aux);
                   }
               }
           }
       } else {
           JOptionPane.showMessageDialog(null, "La lista esta vacia ", "Warning", JOptionPane.WARNING_MESSAGE);    
       }
   }    
     
    
    
}
