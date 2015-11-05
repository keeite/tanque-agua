/*
 * Main.java
 */
package net.ausiasmarch.tanque.gui;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.ausiasmarch.common.Convert;
import net.ausiasmarch.tanque.modelo.*;

/**
 *
 * @author  Administrador
 */
public class Main extends javax.swing.JFrame {
    
    private ControlRiego controlRiego;
    private EstadoTanque estado; 
    private Tanque tanque;
    
    public Main() {
        initComponents();
        controlRiego = new ControlRiego();
        controlRiego.ControlRiego(controlRiego.getEstado());
        setSize(580, 450);
        setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
    * initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is
    * always regenerated by the Form Editor.
    */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonLlenarMedio = new javax.swing.JButton();
        jButtonVaciarMedio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNivelSequia = new javax.swing.JTextField();
        jTextFieldNivelHumedad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tanque de agua");
        setResizable(false);

        jButtonLlenarMedio.setText("Llenar Medio");
        jButtonLlenarMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLlenarMedioActionPerformed(evt);
            }
        });

        jButtonVaciarMedio.setText("Vaciar Medio");
        jButtonVaciarMedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVaciarMedioActionPerformed(evt);
            }
        });

        jLabel1.setText("Nivel de sequía [0-10]:");

        jTextFieldNivelSequia.setText("5");
        jTextFieldNivelSequia.setName("Sequía"); // NOI18N

        jTextFieldNivelHumedad.setText("5");
        jTextFieldNivelHumedad.setName("Humedad"); // NOI18N

        jLabel2.setText("Nivel de humedad del suelo [0-10]:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNivelSequia)
                    .addComponent(jTextFieldNivelHumedad))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLlenarMedio)
                    .addComponent(jButtonVaciarMedio))
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNivelSequia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonLlenarMedio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNivelHumedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVaciarMedio))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLlenarMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLlenarMedioActionPerformed
        if(!Convert.isValidInt(jTextFieldNivelSequia.getText())){
            this.mensaje("El valor de la sequia no es un numero entero.");
            return;
        }
        controlRiego.setSequia(Convert.parseInt(jTextFieldNivelSequia.getText()));
        if(controlRiego.permitidoLlenar() != 0){
           this.mensaje(controlRiego.getMensaje());
           return;
        }
        tanque.llenarMedio();
        controlRiego.setEstado(tanque.getEstado());
        
    }//GEN-LAST:event_jButtonLlenarMedioActionPerformed

    private void jButtonVaciarMedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVaciarMedioActionPerformed
        if(!Convert.isValidInt(jTextFieldNivelHumedad.getText())){
            this.mensaje("El valor de la humedad no es un numero entero.");
            return;
        }
        controlRiego.setHumedad(Convert.parseInt(jTextFieldNivelHumedad.getText()));
        controlRiego.setEstado(tanque.getEstado());
        if(controlRiego.permitidoVaciar() != 0){
           this.mensaje(controlRiego.getMensaje());
           return;
        }
        
        tanque.vaciarMedio();
        controlRiego.setEstado(tanque.getEstado());
        
    } //GEN-LAST:event_jButtonVaciarMedioActionPerformed

    
    private void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        try {
            String look = UIManager.getSystemLookAndFeelClassName();
            javax.swing.UIManager.setLookAndFeel(look);

            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (info.getName().equals(("Nimbus"))) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | 
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            throw new RuntimeException(ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLlenarMedio;
    private javax.swing.JButton jButtonVaciarMedio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextFieldNivelHumedad;
    private javax.swing.JTextField jTextFieldNivelSequia;
    // End of variables declaration//GEN-END:variables
}
