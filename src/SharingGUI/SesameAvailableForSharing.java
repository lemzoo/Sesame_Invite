/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SharingGUI;

import AccesGUI.*;
import HomeGUI.*;
import LinkingGUI.*;
import SesameApp.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author LamineBA
 */
public class SesameAvailableForSharing extends JFrame implements ListSelectionListener, ConstantsConfiguration {

    /**
     * Creates new form ManageAcces
     */
    private String selected_item="";
    private SerialPortGPIO port = null;
    
    public SesameAvailableForSharing() {
        initComponents();
        port = new SerialPortGPIO(115200);

        try {
            // init the list
            fillOutTheChoiceList();
        } catch (InterruptedException ex) {
            Logger.getLogger(SesameAvailableForSharing.class.getName()).log(Level.SEVERE, null, ex);
        }
        choisir_jbutton.setEnabled(false);
        relancer_jbutton.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel_titre = new javax.swing.JPanel();
        titre_fenetre = new javax.swing.JLabel();
        separator_jpanel = new javax.swing.JPanel();
        relancer_jbutton = new javax.swing.JButton();
        choisir_jbutton = new javax.swing.JButton();
        liste_sesame_dispo = new java.awt.List();
        separator_jpanel1 = new javax.swing.JPanel();
        jPanel_note = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        javax.swing.JTextArea note_important = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des Sesame disponible pour le partage");

        titre_fenetre.setFont(new java.awt.Font("Monaco", 1, 14)); // NOI18N
        titre_fenetre.setText("Liste des Sesames disponibles pour le partage");

        javax.swing.GroupLayout jpanel_titreLayout = new javax.swing.GroupLayout(jpanel_titre);
        jpanel_titre.setLayout(jpanel_titreLayout);
        jpanel_titreLayout.setHorizontalGroup(
            jpanel_titreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_titreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titre_fenetre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );
        jpanel_titreLayout.setVerticalGroup(
            jpanel_titreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel_titreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titre_fenetre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        separator_jpanel.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout separator_jpanelLayout = new javax.swing.GroupLayout(separator_jpanel);
        separator_jpanel.setLayout(separator_jpanelLayout);
        separator_jpanelLayout.setHorizontalGroup(
            separator_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separator_jpanelLayout.setVerticalGroup(
            separator_jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        relancer_jbutton.setBackground(new java.awt.Color(255, 153, 153));
        relancer_jbutton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        relancer_jbutton.setText("Relancer la recherche");
        relancer_jbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                relancer_jbuttonMouseReleased(evt);
            }
        });

        choisir_jbutton.setBackground(new java.awt.Color(153, 255, 51));
        choisir_jbutton.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        choisir_jbutton.setText("Choisir");
        choisir_jbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                choisir_jbuttonMouseReleased(evt);
            }
        });

        liste_sesame_dispo.setBackground(new java.awt.Color(153, 153, 255));
        liste_sesame_dispo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liste_sesame_dispoMouseClicked(evt);
                listeAccrediteeMouseClickedEvent(evt);
            }
        });
        liste_sesame_dispo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                liste_sesame_dispoActionPerformed(evt);
            }
        });

        separator_jpanel1.setBackground(new java.awt.Color(0, 153, 255));

        javax.swing.GroupLayout separator_jpanel1Layout = new javax.swing.GroupLayout(separator_jpanel1);
        separator_jpanel1.setLayout(separator_jpanel1Layout);
        separator_jpanel1Layout.setHorizontalGroup(
            separator_jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        separator_jpanel1Layout.setVerticalGroup(
            separator_jpanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        note_important.setEditable(false);
        note_important.setColumns(20);
        note_important.setRows(5);
        note_important.setText("<=====  NOTE IMPORTANT AVANT LE PARTAGE =====>\nIL FAUT ACTIVER LA FONCTION PERMETTANT DE RECEVOIR\nLE PARTAGE SUR LE SESAME DESTINATAIRE DU PARTAGE\nAVANT DE LANCER LA RECHERCHE DES SESAMES DISPONIBLE\n<==================================>");
        jScrollPane1.setViewportView(note_important);

        javax.swing.GroupLayout jPanel_noteLayout = new javax.swing.GroupLayout(jPanel_note);
        jPanel_note.setLayout(jPanel_noteLayout);
        jPanel_noteLayout.setHorizontalGroup(
            jPanel_noteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel_noteLayout.setVerticalGroup(
            jPanel_noteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_noteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(relancer_jbutton)
                            .addComponent(jpanel_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(choisir_jbutton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(separator_jpanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(liste_sesame_dispo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(separator_jpanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel_note, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator_jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_note, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(liste_sesame_dispo, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separator_jpanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(relancer_jbutton)
                    .addComponent(choisir_jbutton))
                .addGap(15, 15, 15))
        );

        //liste_peripherique.addListSelectionListener(this);

        setSize(new java.awt.Dimension(407, 526));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void liste_sesame_dispoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liste_sesame_dispoMouseClicked
        // TODO add your handling code here:
        selected_item = liste_sesame_dispo.getSelectedItem();
        System.out.println("Vous avez selectionné l'utilisateur : " + selected_item);
        relancer_jbutton.setEnabled(true);
    }//GEN-LAST:event_liste_sesame_dispoMouseClicked

    private void choisir_jbuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_choisir_jbuttonMouseReleased
        // TODO add your handling code here:
        IdentifyTheReceiver id_guest = new IdentifyTheReceiver ();
        id_guest.setGuestId(selected_item);
        id_guest.setVisible(true);
    }//GEN-LAST:event_choisir_jbuttonMouseReleased

    private void relancer_jbuttonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_relancer_jbuttonMouseReleased
        // Lancer la recherche de Sesame environnant pendant 60 secondes.
        // Diseable the button until finishing the scan of the Sesame
        relancer_jbutton.setEnabled(false);
        choisir_jbutton.setEnabled(false);
        liste_sesame_dispo.setEnabled(false);
        try {
            // init the list
            fillOutTheChoiceList();
        } catch (InterruptedException ex) {
            Logger.getLogger(SesameAvailableForSharing.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Rendre le bouton actif
        relancer_jbutton.setEnabled(true);
        liste_sesame_dispo.setEnabled(true);
    }//GEN-LAST:event_relancer_jbuttonMouseReleased

    private void listeAccrediteeMouseClickedEvent(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeAccrediteeMouseClickedEvent
        // TODO add your handling code here:
    }//GEN-LAST:event_listeAccrediteeMouseClickedEvent

    private void liste_sesame_dispoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_liste_sesame_dispoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_liste_sesame_dispoActionPerformed

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
            java.util.logging.Logger.getLogger(SesameAvailableForSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SesameAvailableForSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SesameAvailableForSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SesameAvailableForSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SesameAvailableForSharing().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton choisir_jbutton;
    private javax.swing.JPanel jPanel_note;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpanel_titre;
    private java.awt.List liste_sesame_dispo;
    private javax.swing.JButton relancer_jbutton;
    private javax.swing.JPanel separator_jpanel;
    private javax.swing.JPanel separator_jpanel1;
    private javax.swing.JLabel titre_fenetre;
    // End of variables declaration//GEN-END:variables
    private String [] device_list = {"DEVICE 01", "DEVICE 02", "DEVICE XYZ", "DEVICE ACD",
                                     "SESAME DOORS", "SESAME", "EveryGates", "Vitry sur Seine", "Paris", "France"};
    ListSelectionListener ecouteur = null;    
    /**
     * Methode : fillOutTheChoiceList() allows you to fill out the choice list for the user
     * This methode will search all the device linked with this SESAME. 
     */
    private void fillOutTheChoiceList() throws InterruptedException{
        System.out.println("<--- BEGIN : fillOutTheChoiceList() --->");
        System.out.println("Size of the device available list = " + liste_sesame_dispo.getItemCount());
        /*for (int i=0; i<liste_sesame_dispo.getItemCount(); i++){
            liste_sesame_dispo.remove(i);
        }*/
        liste_sesame_dispo.removeAll();
        System.out.println("Size of the device available list after resetting = " + liste_sesame_dispo.getItemCount());
        String [] all_device_name;
        
        // Call the methode scanSesameAround()"
        all_device_name = this.scanSesameAround();
        
        if (all_device_name.length>0){
            // Fit the device array list 
            for (int i=0; i<all_device_name.length; i++){
                liste_sesame_dispo.add(all_device_name[i], i);
            }
        }
        else{
            for (int i=0; i<all_device_name.length; i++){
                liste_sesame_dispo.add(device_list[i], i);
            }
        }
        System.out.println("Size of the device available list after = " + liste_sesame_dispo.getItemCount());
        System.out.println("<--- END : fillOutTheChoiceList() --->");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
    
    /**
     * Methode : scanneSesameAround() allow you to scan and to get the ID of the Sesame
     * @return String[] which contains all detected SESAME. 
     */
    private String[] scanSesameAround() throws InterruptedException{
        System.out.println("<--- BEGIN : scanSesameAround() --->");
        
        String [] sesame_scanned = new String[15];
        String [] sesame_available;
        boolean flag_scan_time = true;
        // Launch the scan until during second
        int TEMPO_SCAN_TIME = 2000; 
        int tempo = 0;
        int count_sesame = 0;
        String received_data_new = "NEW";
        String received_data_old = "OLD";
        
        // First send the command to get the Sesame available around
        port.sendData(SCAN_SESAME_ENVIRONNANT);
        port.setLastReceivedData("");
        
        while(flag_scan_time){
            if (tempo >= TEMPO_SCAN_TIME){
                flag_scan_time = false;
            }
            else{
                received_data_new = port.getLastReceivedData();
                if (received_data_new != null && received_data_new.length()>0 && !received_data_new.equals(received_data_old)){
                    sesame_scanned[count_sesame] = received_data_new;
                    count_sesame ++;
                    //System.out.println("Data written = " + received_data_new);
                }
                received_data_old = received_data_new;
                tempo += 10;
                Thread.sleep(10);
            }
        }
        
        if (count_sesame >0){
            sesame_available = new String[count_sesame];
            for(int i=0; i<count_sesame; i++){
                sesame_available[i] = sesame_scanned[i];
            }
        }
        else{
            sesame_available = new String[1];
            sesame_available[0] = "Pas de Sesame Disponible";
        }
        System.out.println("<--- END : scanSesameAround() --->");
        
        for (int i=0; i<sesame_available.length; i++)
            System.out.println("Device Scanned Number : " + i + " Device Name = " + sesame_available[i]);
        return sesame_available;
    }
}