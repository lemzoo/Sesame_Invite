// Saisir info sur le peripherique a rattacher + saisie Mot de passe + saisie code e rattachement
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkingGUI;

import AccesGUI.*;
import HomeGUI.*;
import SesameApp.*;
import SharingGUI.*;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

/**
 *
 * @author LamineBA
 */
public class PeripheriqueContrat extends javax.swing.JFrame {

    /**
     * Creates new form SecondWindows
     */
    public PeripheriqueContrat() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        decliner_jbutton = new javax.swing.JToggleButton();
        accepter_jbutton = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Conditions Générales de Rattachement");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setText("Conditions Générales de Rattachement");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 15, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        decliner_jbutton.setBackground(new java.awt.Color(255, 0, 0));
        decliner_jbutton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        decliner_jbutton.setText("Decliner");
        decliner_jbutton.setSize(new java.awt.Dimension(140, 30));
        decliner_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decliner_jbuttonActionPerformed(evt);
            }
        });

        accepter_jbutton.setBackground(new java.awt.Color(0, 255, 51));
        accepter_jbutton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        accepter_jbutton.setText("Accepter");
        accepter_jbutton.setSize(new java.awt.Dimension(140, 30));
        accepter_jbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accepter_jbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(decliner_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(accepter_jbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(decliner_jbutton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accepter_jbutton)))
        );

        jPanel4.setBackground(new java.awt.Color(51, 0, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(0, 8));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Ce contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations\net d'engagement. EveryGates respecte votre vie privée. \n\nCe contrat a pour but de sensibiliser l'utilisateur du système\nde EveryGates de prendre conscience les règles d'utilisations");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(432, 568));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void accepter_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accepter_jbuttonActionPerformed
        close();
        PeripheriqueIdentification periph = new PeripheriqueIdentification();
        periph.setVisible(true);
    }//GEN-LAST:event_accepter_jbuttonActionPerformed

    private void decliner_jbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decliner_jbuttonActionPerformed
        close();
        Peripherique periph = new Peripherique();
        periph.setVisible(true);
    }//GEN-LAST:event_decliner_jbuttonActionPerformed

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
            java.util.logging.Logger.getLogger(PeripheriqueContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PeripheriqueContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PeripheriqueContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PeripheriqueContrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PeripheriqueContrat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton accepter_jbutton;
    private javax.swing.JToggleButton decliner_jbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables

    private void close(){
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }
    
    private static final long serialVersionUID = 42L; 
}