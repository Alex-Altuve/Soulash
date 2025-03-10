/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Controller;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex Altuve
 */
public class ProductosAgregar extends javax.swing.JPanel {
    Controller control;
     
    /**
     * Creates new form ProductosAgregar
     */
    public ProductosAgregar() {
        initComponents();
        control = new Controller(NombreP, CodigoP, NumExistencia, Costo, Lote, Día, Mes, Año,ListaProduc, Error_Nombre, Error_Codigo, Error_Lote);
        control.llenar_comboMes_Dia();
        control.LlenarArrayListconBD();
        control.LlenarTablaProductos(ListaProduc);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        NombreP = new javax.swing.JTextField();
        CodigoP = new javax.swing.JTextField();
        Costo = new javax.swing.JTextField();
        Lote = new javax.swing.JTextField();
        Día = new javax.swing.JComboBox<>();
        Mes = new javax.swing.JComboBox<>();
        Año = new javax.swing.JComboBox<>();
        NumExistencia = new javax.swing.JTextField();
        Modificar = new javax.swing.JButton();
        Agregar = new javax.swing.JButton();
        Eliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaProduc = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Error_Nombre = new javax.swing.JTextField();
        Error_Codigo = new javax.swing.JTextField();
        Error_Lote = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(880, 660));
        setMinimumSize(new java.awt.Dimension(880, 660));
        setPreferredSize(new java.awt.Dimension(880, 660));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Agregar.png"))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, 60));

        NombreP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NombreP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombrePActionPerformed(evt);
            }
        });
        NombreP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NombrePKeyTyped(evt);
            }
        });
        add(NombreP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 160, 40));

        CodigoP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CodigoP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CodigoPActionPerformed(evt);
            }
        });
        CodigoP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CodigoPKeyTyped(evt);
            }
        });
        add(CodigoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 130, 40));

        Costo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Costo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostoActionPerformed(evt);
            }
        });
        Costo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CostoKeyTyped(evt);
            }
        });
        add(Costo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 120, 40));

        Lote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Lote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                LoteKeyTyped(evt);
            }
        });
        add(Lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 120, 40));

        Día.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DíaActionPerformed(evt);
            }
        });
        add(Día, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 80, 30));

        Mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        Mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MesActionPerformed(evt);
            }
        });
        add(Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 100, 30));

        Año.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045" }));
        Año.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñoActionPerformed(evt);
            }
        });
        add(Año, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 90, 80, 30));

        NumExistencia.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NumExistencia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                NumExistenciaKeyTyped(evt);
            }
        });
        add(NumExistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 120, 40));

        Modificar.setBackground(new java.awt.Color(204, 204, 255));
        Modificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });
        add(Modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 570, 120, 40));

        Agregar.setBackground(new java.awt.Color(204, 204, 255));
        Agregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Agregar.setText("Agregar");
        Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarActionPerformed(evt);
            }
        });
        add(Agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 570, 120, 40));

        Eliminar.setBackground(new java.awt.Color(204, 204, 255));
        Eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Eliminar.setText("Eliminar");
        Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarActionPerformed(evt);
            }
        });
        add(Eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 120, 40));

        ListaProduc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Código", "Precio", "Costo", "F. Vencimiento", "N° Lote", "N° Existencia", "Unid. Vendidas", "En Oferta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ListaProduc.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(ListaProduc);
        if (ListaProduc.getColumnModel().getColumnCount() > 0) {
            ListaProduc.getColumnModel().getColumn(0).setResizable(false);
            ListaProduc.getColumnModel().getColumn(0).setHeaderValue("Nombre");
            ListaProduc.getColumnModel().getColumn(1).setResizable(false);
            ListaProduc.getColumnModel().getColumn(1).setHeaderValue("Código");
            ListaProduc.getColumnModel().getColumn(2).setResizable(false);
            ListaProduc.getColumnModel().getColumn(2).setHeaderValue("Precio");
            ListaProduc.getColumnModel().getColumn(3).setResizable(false);
            ListaProduc.getColumnModel().getColumn(3).setHeaderValue("Costo");
            ListaProduc.getColumnModel().getColumn(4).setResizable(false);
            ListaProduc.getColumnModel().getColumn(4).setHeaderValue("F. Vencimiento");
            ListaProduc.getColumnModel().getColumn(5).setResizable(false);
            ListaProduc.getColumnModel().getColumn(5).setHeaderValue("N° Lote");
            ListaProduc.getColumnModel().getColumn(6).setResizable(false);
            ListaProduc.getColumnModel().getColumn(6).setHeaderValue("N° Existencia");
            ListaProduc.getColumnModel().getColumn(7).setResizable(false);
            ListaProduc.getColumnModel().getColumn(7).setHeaderValue("Unid. Vendidas");
            ListaProduc.getColumnModel().getColumn(8).setResizable(false);
            ListaProduc.getColumnModel().getColumn(8).setHeaderValue("En Oferta");
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 820, 230));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("N°  de existencia");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Modifica.png"))); // NOI18N
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 500, 70, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("N° Lote");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 190, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Costo");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nombre");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, -1, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/AgregarP.png"))); // NOI18N
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 70, 60));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Código");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Día");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Elimina.png"))); // NOI18N
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 70, 60));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Mes");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Año");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, -1));

        Error_Nombre.setEditable(false);
        Error_Nombre.setBackground(new java.awt.Color(0,0,0,1));
        Error_Nombre.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Error_Nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Error_Nombre.setBorder(null);
        add(Error_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 180, -1));

        Error_Codigo.setEditable(false);
        Error_Codigo.setBackground(new java.awt.Color(0,0,0,1));
        Error_Codigo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Error_Codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Error_Codigo.setBorder(null);
        add(Error_Codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 180, -1));

        Error_Lote.setEditable(false);
        Error_Lote.setBackground(new java.awt.Color(0,0,0,1));
        Error_Lote.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        Error_Lote.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Error_Lote.setBorder(null);
        add(Error_Lote, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 230, 180, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoSecundario.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 660));
    }// </editor-fold>//GEN-END:initComponents

    private void NombrePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombrePActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombrePActionPerformed

    private void CostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CostoActionPerformed

    private void DíaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DíaActionPerformed
       
    }//GEN-LAST:event_DíaActionPerformed

    private void MesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MesActionPerformed
        control.llenar_comboMes_Dia();
    }//GEN-LAST:event_MesActionPerformed

    private void AñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñoActionPerformed
       control.llenar_comboMes_Dia();
    }//GEN-LAST:event_AñoActionPerformed

    private void CodigoPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CodigoPActionPerformed
       
    }//GEN-LAST:event_CodigoPActionPerformed

    private void CodigoPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CodigoPKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57) || key==127 || key==8;

        if (!numeros)
        {
            JOptionPane.showMessageDialog(null, "ERROR no se aceptan caracteres especiales ni letras","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
        if (CodigoP.getText().trim().length() >=12) {
            JOptionPane.showMessageDialog(null, "ADVERTENCIA el codigo debe tener entre 1 y 12 digitos","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_CodigoPKeyTyped

    private void LoteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_LoteKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57) || key == 127 || key == 8;

        if (!numeros) {
            JOptionPane.showMessageDialog(null, "ERROR no se aceptan caracteres especiales ni letras", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_LoteKeyTyped

    private void NumExistenciaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NumExistenciaKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57) || key==127 || key==8;

        if (!numeros)
        {
            JOptionPane.showMessageDialog(null, "No se aceptan caracteres especiales ni letras","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
    }//GEN-LAST:event_NumExistenciaKeyTyped

    private void NombrePKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NombrePKeyTyped
         int key = evt.getKeyChar();

        boolean mayusculas = key >= 65 && key <= 90;
        boolean minusculas = (key >= 97 && key <= 122) || key==127 || key==8;
        boolean espacio = key == 32;

        if (!(minusculas || mayusculas || espacio)){
        
            JOptionPane.showMessageDialog(null, "No se aceptan caracteres especiales ni numeros","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
           
            evt.consume();
        }
    }//GEN-LAST:event_NombrePKeyTyped

    private void CostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CostoKeyTyped
        int key = evt.getKeyChar();

        boolean numeros = (key >= 48 && key <= 57) || key==127 || key==8|| key==46;

        if (!numeros)
        {
            JOptionPane.showMessageDialog(null, "No se aceptan caracteres especiales, letras ni comas","WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
            evt.consume();
        }
        
    }//GEN-LAST:event_CostoKeyTyped

    private void AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarActionPerformed
        
        control.AgregarProductoBoton();
    
       
    
    }//GEN-LAST:event_AgregarActionPerformed

    private void EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarActionPerformed
       control.EliminarProductoconBD();
    }//GEN-LAST:event_EliminarActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed
       control.ModificarProducto();
    }//GEN-LAST:event_ModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Agregar;
    private javax.swing.JComboBox<String> Año;
    private javax.swing.JTextField CodigoP;
    private javax.swing.JTextField Costo;
    private javax.swing.JComboBox<String> Día;
    private javax.swing.JButton Eliminar;
    private javax.swing.JTextField Error_Codigo;
    private javax.swing.JTextField Error_Lote;
    private javax.swing.JTextField Error_Nombre;
    private javax.swing.JTable ListaProduc;
    private javax.swing.JTextField Lote;
    private javax.swing.JComboBox<String> Mes;
    private javax.swing.JButton Modificar;
    private javax.swing.JTextField NombreP;
    private javax.swing.JTextField NumExistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
