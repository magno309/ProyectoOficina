/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.Conexion;
import Datos.daoClientes;
import Datos.daoServicios;
import Modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luis_
 */
public class frmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form frmPrincipal
     *
     * @throws java.lang.Exception
     */
    public frmPrincipal() throws Exception {
        initComponents();
        this.listaClientes = new ArrayList();
        try {
            dc = new daoClientes();
            ds = new daoServicios();
            dc.getDb().obtenerConexion();
            ds.getDb().obtenerConexion();
            recargarTabla();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectarse a la base de datos\n");
            conectarDB();
        }
    }

    private ArrayList<Cliente> listaClientes;
    public static daoClientes dc;
    public static daoServicios ds;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnConectar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        btnAgregarCliente = new javax.swing.JMenuItem();
        btnEditarCliente = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnRegistrarServicio = new javax.swing.JMenuItem();
        btnVerServicio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Directorio");
        setMaximumSize(new java.awt.Dimension(724, 419));
        setMinimumSize(new java.awt.Dimension(600, 310));

        jLabel1.setText("Buscar cliente:");

        txtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jTable1.setMinimumSize(new java.awt.Dimension(225, 64));
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Archivo");

        btnConectar.setText("Conectar...");
        btnConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConectarActionPerformed(evt);
            }
        });
        jMenu1.add(btnConectar);
        jMenu1.add(jSeparator1);

        jMenu3.setText("Clientes");

        btnAgregarCliente.setText("Agregar...");
        btnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarClienteActionPerformed(evt);
            }
        });
        jMenu3.add(btnAgregarCliente);

        btnEditarCliente.setText("Editar...");
        btnEditarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarClienteActionPerformed(evt);
            }
        });
        jMenu3.add(btnEditarCliente);

        jMenu1.add(jMenu3);

        jMenu4.setText("Servicios");

        btnRegistrarServicio.setText("Registrar servicio...");
        btnRegistrarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarServicioActionPerformed(evt);
            }
        });
        jMenu4.add(btnRegistrarServicio);

        btnVerServicio.setText("Ver servicios...");
        btnVerServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerServicioActionPerformed(evt);
            }
        });
        jMenu4.add(btnVerServicio);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 974, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarDB() {
        Conexion c = new frmConexion(this, true).showDialog();
        if (c != null) {
            if (c.isValida()) {
                dc.setDb(c);
                ds.setDb(c);
                recargarTabla();
            }else{
                System.exit(0);
            }
        } else {
            
        }
    }

    public void recargarTabla() {
        // TODO add your handling code here:
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        listaClientes.clear();
        //modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Ciudad");
        modelo.addColumn("Telefono");
        modelo.addColumn("Celular");
        try {
            ResultSet rs = dc.ObtenerTodos();
            while (rs.next()) {
                Object fila[] = new Object[5];
                listaClientes.add(new Cliente((int) rs.getObject(1), rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString(), rs.getObject(6).toString()));
                listaClientes.stream().map((cliente) -> {
                    fila[0] = cliente.getNombre();
                    return cliente;
                }).map((cliente) -> {
                    fila[1] = cliente.getDireccion();
                    return cliente;
                }).map((cliente) -> {
                    fila[2] = cliente.getCiudad();
                    return cliente;
                }).map((cliente) -> {
                    fila[3] = cliente.getTelefono();
                    return cliente;
                }).forEachOrdered((cliente) -> {
                    fila[4] = cliente.getCelular();
                });
                modelo.addRow(fila);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al conectarse a la base de datos\n");
            conectarDB();
        }
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        //modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Celular");
        listaClientes.clear();
        try {
            ResultSet rs = dc.BuscarPorNombre(txtCliente.getText());
            while (rs.next()) {
                Object fila[] = new Object[5];
                listaClientes.add(new Cliente((int) rs.getObject(1), rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString(), rs.getObject(6).toString()));
                listaClientes.stream().map((cliente) -> {
                    fila[0] = cliente.getNombre();
                    return cliente;
                }).map((cliente) -> {
                    fila[1] = cliente.getDireccion();
                    return cliente;
                }).map((cliente) -> {
                    fila[2] = cliente.getCiudad();
                    return cliente;
                }).map((cliente) -> {
                    fila[3] = cliente.getTelefono();
                    return cliente;
                }).forEachOrdered((cliente) -> {
                    fila[4] = cliente.getCelular();
                });
                modelo.addRow(fila);
            }
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Error al conectarse a la base de datos\n");
            Conexion c = new frmConexion(this, true).showDialog();
            dc.setDb(c);
            ds.setDb(c);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarClienteActionPerformed
        // TODO add your handling code here:
        try {
            int index = jTable1.getSelectedRow();
            frmCliente frm = new frmCliente(listaClientes.get(index), 1, this, true);
            frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frm.setLocationRelativeTo(null);
            frm.setTitle("Cliente no.: " + listaClientes.get(index).getId());
            frm.setVisible(true);
            recargarTabla();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún cliente!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarClienteActionPerformed

    private void btnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarClienteActionPerformed
        frmCliente frm = new frmCliente(this, true);
        frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        recargarTabla();
    }//GEN-LAST:event_btnAgregarClienteActionPerformed

    private void btnRegistrarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarServicioActionPerformed
        // TODO add your handling code here:
        try {
            int index = jTable1.getSelectedRow();
            frmServicios frm = new frmServicios(this, true, listaClientes.get(index).getId());
            frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frm.setLocationRelativeTo(null);
            frm.setTitle("Registrar servicio - Cliente: " + listaClientes.get(index).getNombre());
            frm.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún cliente!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistrarServicioActionPerformed

    private void btnVerServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerServicioActionPerformed
        // TODO add your handling code here:
        try {
            int index = jTable1.getSelectedRow();
            frmCliente frm = new frmCliente(listaClientes.get(index), 2, this, true);
            frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frm.setLocationRelativeTo(null);
            frm.setTitle("Cliente no.: " + listaClientes.get(index).getId());
            frm.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún cliente!", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerServicioActionPerformed

    private void btnConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConectarActionPerformed
        Conexion c = new frmConexion(this, true).showDialog();
        dc.setDb(c);
        ds.setDb(c);
    }//GEN-LAST:event_btnConectarActionPerformed

    private void txtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteActionPerformed
        DefaultTableModel modelo = new DefaultTableModel();
        jTable1.setModel(modelo);
        //modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        modelo.addColumn("Celular");
        listaClientes.clear();
        try {
            ResultSet rs = dc.BuscarPorNombre(txtCliente.getText());
            while (rs.next()) {
                Object fila[] = new Object[5];
                listaClientes.add(new Cliente((int) rs.getObject(1), rs.getObject(2).toString(), rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString(), rs.getObject(6).toString()));
                listaClientes.stream().map((cliente) -> {
                    fila[0] = cliente.getNombre();
                    return cliente;
                }).map((cliente) -> {
                    fila[1] = cliente.getDireccion();
                    return cliente;
                }).map((cliente) -> {
                    fila[2] = cliente.getCiudad();
                    return cliente;
                }).map((cliente) -> {
                    fila[3] = cliente.getTelefono();
                    return cliente;
                }).forEachOrdered((cliente) -> {
                    fila[4] = cliente.getCelular();
                });
                modelo.addRow(fila);
            }
        } catch (SQLException | NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Error al conectarse a la base de datos\n");
            Conexion c = new frmConexion(this, true).showDialog();
            dc.setDb(c);
            ds.setDb(c);
        }
    }//GEN-LAST:event_txtClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new frmPrincipal().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(frmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAgregarCliente;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JMenuItem btnConectar;
    private javax.swing.JMenuItem btnEditarCliente;
    private javax.swing.JMenuItem btnRegistrarServicio;
    private javax.swing.JMenuItem btnVerServicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
