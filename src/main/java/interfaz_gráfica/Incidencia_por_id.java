/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package interfaz_gráfica;

import POJO.Incidencia;
import gestionConsultas.IncidenciaDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author edulumulu
 */
public class Incidencia_por_id extends javax.swing.JDialog {

    ArrayList<Incidencia> lista_incidencias = new ArrayList<>();
    IncidenciaDAO inidenciaDAO = new IncidenciaDAO();
    Incidencia incidencia_seleccionada;
    /**
     * Creates new form Incidencia_por_id
     */
    public Incidencia_por_id(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setear_valores();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        et_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bt_buscar = new javax.swing.JButton();
        lb_fecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lb_nombre_orogen = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lb_usuario_origen = new javax.swing.JLabel();
        lb_tel_origen = new javax.swing.JLabel();
        lb_id_origen = new javax.swing.JLabel();
        lb_usuario_destino = new javax.swing.JLabel();
        lb_tel_destino = new javax.swing.JLabel();
        lb_id_dest = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lb_nombre_destino = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lb_urge = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lb_detalle = new javax.swing.JLabel();
        bt_salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Incidencia por Id");
        setBackground(new java.awt.Color(51, 255, 51));
        setResizable(false);

        jLabel1.setText("Escribe el id de la incidenca:");

        jLabel2.setText("Fecha y hora:");

        bt_buscar.setText("Buscar");
        bt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_buscarActionPerformed(evt);
            }
        });

        lb_fecha.setForeground(new java.awt.Color(51, 51, 255));
        lb_fecha.setText("-");

        jLabel4.setText("Empleado origen:");

        lb_nombre_orogen.setForeground(new java.awt.Color(51, 51, 255));
        lb_nombre_orogen.setText("nombre");
        lb_nombre_orogen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_nombre_orogen.setIgnoreRepaint(true);

        jLabel5.setText("usuario");

        jLabel6.setText("tlefono");

        jLabel7.setText("Nombre");

        jLabel8.setText("id");

        lb_usuario_origen.setForeground(new java.awt.Color(51, 51, 255));
        lb_usuario_origen.setText("usuario");

        lb_tel_origen.setForeground(new java.awt.Color(51, 51, 255));
        lb_tel_origen.setText("telefono");

        lb_id_origen.setForeground(new java.awt.Color(51, 51, 255));
        lb_id_origen.setText("id");

        lb_usuario_destino.setForeground(new java.awt.Color(51, 51, 255));
        lb_usuario_destino.setText("usuario");

        lb_tel_destino.setForeground(new java.awt.Color(51, 51, 255));
        lb_tel_destino.setText("telefono");

        lb_id_dest.setForeground(new java.awt.Color(51, 51, 255));
        lb_id_dest.setText("id");

        jLabel9.setText("Empleado origen:");

        lb_nombre_destino.setForeground(new java.awt.Color(51, 51, 255));
        lb_nombre_destino.setText("nombre");
        lb_nombre_destino.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lb_nombre_destino.setIgnoreRepaint(true);

        jLabel3.setText("Importancia:");

        lb_urge.setForeground(new java.awt.Color(51, 51, 255));
        lb_urge.setText("importancia");

        jLabel11.setText("Detalle:");

        lb_detalle.setForeground(new java.awt.Color(51, 51, 255));
        lb_detalle.setText("Detalle");

        bt_salir.setText("Salir");
        bt_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(lb_detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lb_id_dest)
                                    .addComponent(lb_id_origen)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lb_nombre_destino, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lb_nombre_orogen, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lb_usuario_destino)
                                    .addComponent(lb_usuario_origen)
                                    .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lb_tel_destino)
                                    .addComponent(lb_tel_origen)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel6)))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(lb_fecha)
                            .addGap(28, 28, 28)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(lb_urge))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(et_id, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addComponent(bt_buscar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(bt_salir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(et_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_buscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lb_urge))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lb_fecha)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_id_origen)
                                    .addComponent(jLabel4))
                                .addGap(33, 33, 33)
                                .addComponent(lb_id_dest))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_nombre_orogen)
                                    .addComponent(lb_usuario_origen))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lb_usuario_destino)
                                    .addComponent(lb_nombre_destino))))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(lb_detalle)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(8, 8, 8)
                        .addComponent(lb_tel_origen)
                        .addGap(31, 31, 31)
                        .addComponent(lb_tel_destino)))
                .addGap(26, 26, 26)
                .addComponent(bt_salir)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_salirActionPerformed
        dispose();
    }//GEN-LAST:event_bt_salirActionPerformed

    /**
     * Comprueba que el campo id esté relleno, si lo está y existe la incidencia carga los datos de la misma en los label, si no muestra mensaje de que no existe
     * @param evt 
     */
    private void bt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_buscarActionPerformed
        
        if(et_id.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Tienes que rellenar el campo id","error", JOptionPane.ERROR_MESSAGE);
        }
        
        incidencia_seleccionada= IncidenciaDAO.obtener_incidencia_por_Id_incidencia(Integer.parseInt(et_id.getText()));
       
        if(incidencia_seleccionada != null){
            lb_fecha.setText(incidencia_seleccionada.getFecha_hora_generacion().toString());
            lb_detalle.setText(incidencia_seleccionada.getDetalle());
            lb_urge.setText(incidencia_seleccionada.obtenerUrgencia());
            
            lb_id_origen.setText(String.valueOf(incidencia_seleccionada.getId_empleado_origen().getId_empleado()));
            lb_nombre_orogen.setText(incidencia_seleccionada.getId_empleado_origen().getNombre_completo());
            lb_usuario_origen.setText(incidencia_seleccionada.getId_empleado_origen().getNombre_usuario());
            lb_tel_origen.setText(incidencia_seleccionada.getId_empleado_origen().getTelefono_contacto());
            
            
            lb_id_dest.setText(String.valueOf(incidencia_seleccionada.getId_empleado_destino().getId_empleado()));
            lb_nombre_destino.setText(incidencia_seleccionada.getId_empleado_destino().getNombre_completo());
            lb_usuario_destino.setText(incidencia_seleccionada.getId_empleado_destino().getNombre_usuario());
            lb_tel_destino.setText(incidencia_seleccionada.getId_empleado_destino().getTelefono_contacto());
            

            
        }else{
          JOptionPane.showMessageDialog(this, "Id no existente en la BBDD","error", JOptionPane.WARNING_MESSAGE);
          
          setear_valores();
            

        }
    }//GEN-LAST:event_bt_buscarActionPerformed

    /**
     * Deja en blanco los label que contendrán los datos de la incidencia selecionada
     */
    public void setear_valores(){
        lb_fecha.setText("");
            lb_detalle.setText("");
            lb_urge.setText("");
            
            lb_id_origen.setText("");
            lb_nombre_orogen.setText("");
            lb_usuario_origen.setText("");
            lb_usuario_origen.setHorizontalAlignment(JTextField.CENTER);
            lb_usuario_origen.setText("");
            lb_usuario_destino.setHorizontalAlignment(JTextField.CENTER);
            lb_tel_origen.setText("");
            
            
            lb_id_dest.setText("");
            lb_nombre_destino.setText("");
            lb_usuario_destino.setText("");
            lb_usuario_destino.setText("");
            lb_tel_destino.setText("");
    }
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
            java.util.logging.Logger.getLogger(Incidencia_por_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Incidencia_por_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Incidencia_por_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Incidencia_por_id.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Incidencia_por_id dialog = new Incidencia_por_id(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_buscar;
    private javax.swing.JButton bt_salir;
    private javax.swing.JTextField et_id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lb_detalle;
    private javax.swing.JLabel lb_fecha;
    private javax.swing.JLabel lb_id_dest;
    private javax.swing.JLabel lb_id_origen;
    private javax.swing.JLabel lb_nombre_destino;
    private javax.swing.JLabel lb_nombre_orogen;
    private javax.swing.JLabel lb_tel_destino;
    private javax.swing.JLabel lb_tel_origen;
    private javax.swing.JLabel lb_urge;
    private javax.swing.JLabel lb_usuario_destino;
    private javax.swing.JLabel lb_usuario_origen;
    // End of variables declaration//GEN-END:variables
}
