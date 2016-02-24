// SESAME
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SesameApp;

import AccesGUI.*;
import HomeGUI.*;
import LinkingGUI.*;
import SharingGUI.*;

/**
 *
 * @author LamineBA
 */
public interface ConstantsConfiguration {
    
    final String BONJOUR = "BR_01";
    
    //<========================== DEBUT CAS "RATTACHER" =======================>
    
    /*                            ----------------                            */
    
    //<=========================== DEBUT "RATTACHER" =========================>//
    // Code de terminaison "01" correspond à la fonction "RATTACHER"
    final String DEMANDE_ENREGISTREMENT_PROPRIETAIRE   = "DEP_01";
    final String ENREGISTREMENT_PROPRIETAIRE_AUTORISEE = "EPA_01";
    
    final String DEBUT_ENVOIE_INFORMATION_PROPRIETAIRE = "DEIP_01";
    final String FIN_ENVOI_INFORMATION_PROPRIETAIRE    = "FEIP_01";
    
    final String PROPRITAIRE_ENREGISTREE_CORRECTEMENT  = "PEC_01";
    final String DONNEES_PROPRIETAIRE_RECUES_ERONNEES  = "DPRE_01";
    
    final String DEMANDE_RATTACHEMENT_SESAME = "DRS_01";
    final String RATTACHEMENT_AUTORISEE_PERIPHERIQUE = "RAP_01";
    
    final String DEBUT_ENVOI_INFORMATION_RATTACHEMENT = "DEIR_01";
    final String FIN_ENVOI_INFORMATION_RATTACHEMENT = "FEIR_01";
    
    final String SESAME_RATTACHE_CORRECTEMENT = "SRC_01";
    final String DONNEES_SESAME_RECUES_ERONNEES = "DSRE_01";
    
    final String DEMANDE_CONFIRMATION_RATTACHEMENT = "DCR_01";
    
    final String DEBUT_ENVOIE_CONFIRMATION_RATTACHEMENT = "DECR_01";
    final String FIN_ENVOIE_CONFIRMATION_RATTACHEMENT   = "FECR_01";
    
    final String DEBUT_ENVOIE_KEY_LINK = "DEKL_01";
    final String FIN_ENVOIE_KEY_LINK   = "FEKL_01";
    
    final String KEY_LINK_ENREGISTREE_CORRECTEMENT = "KLEC_01";
    final String KEY_LINK_DONNEES_ERONNEES   = "KLDE_01";
    //<========================== FIN CAS "RATTACHER" =========================>
    
    /*                            ----------------                            */
    
    //<=========================== DEBUT "ACCEDER" ==========================>//
    // Code de terminaison "02" correspond à la fonction "ACCEDER"
    final String DEMANDE_ETABLISSEMENT_CONNEXION_ACCES = "DECA_02";
    final String ETABLISSEMENT_CONNEXION_ACCES_ETABLIE = "ECAE_02";
    
    final String DEBUT_ENVOIE_DONNEES_ACCES = "DEDA_02";
    final String FIN_ENVOIE_DONNEES_ACCES   = "FEDA_02";
    
    final String DEMANDE_ACCES_AUTORISEE = "DAA_02";
    final String DEMANDE_ACCES_REFUSEE   = "DAR_02";
    
    final String OUVRIR = "ON_02";
    final String FERMER = "OFF_02";
    
    final String SERRURE_DEVEROUILLEE = "SD_02";
    final String SERRURE_VERROUILLEE  = "SV_02";
    final String ETAT_SERRURE_INCONNU = "ESI_02";
    //<========================== FIN CAS "ACCEDER" ===========================>
    
    /*                            ----------------                            */
    
    //<=========================== DEBUT "PARTAGE CLE ACCES" ================>//
    // Code de terminaison "03" correspond à la fonction "PARTAGER"
    final String SCAN_SESAME_ENVIRONNANT = "SSE_03";
    
    final String DEMANDE_PARTAGE_ACCES   = "DPA_03";
    final String PARTAGE_ACCES_AUTORISEE = "PAA_03";
    
    final String DEBUT_ENVOIE_INFORMATION_UTILISATEUR_PARTAGEANT = "DEIUP_03";
    final String FIN_ENVOIE_INFORMATION_UTILISATEUR_PARTAGEANT   = "FEIPA_03";
    
    final String INFORMATION_PARTAGEUR_ENREGISTRE_CORRECTEMENT  = "IPEC_03";
    final String INFORMATION_PARTAGEUR_DONNEES_ERONEES          = "IPDE_03";
    
    final String DEMANDE_INFORMATION_IDENTIFICATION_ACCREDITEE = "DIIA_03";
    
    final String DEBUT_ENVOIE_INFORMATION_UTILISATEUR_ACCREDITE = "DEIUA_03";
    final String FIN_ENVOIE_INFORMATION_UTILISATEUR_ACCREDITE   = "FEIUA_03";
    
    final String INFORMATION_ACCREDITE_ENREGISTRE_CORRECTEMENT = "IAEC_03";
    final String INFORMATION_ACCREDITE_DONNEES_ERONNEES        = "IADE_03";
    
    final String DEMANDE_INFORMATION_SESAME_DOORS      = "DISD_03";
    
    final String DEBUT_ENVOIE_INFORMATION_SESAME_DOORS = "DEISD_03";
    final String FIN_ENVOIE_INFORMATION_SESAME_DOORS   = "FEISD_03";
    
    final String INFORMATION_SESAME_DOORS_ENREGISTRE_CORRECTEMENT = "ISDEC_03";
    final String INFORMATION_SESAME_DOORS_DONNEES_ERONNEES        = "ISDDE_03";
    
    final String DEBUT_ENVOIE_KEY_SHARE = "DEKS_03";
    final String FIN_ENVOIE_KEY_SHARE   = "FEKS_03";
    
    final String KEY_SHARE_ENREGISTREE_CORRECTEMENT = "KSEC_03";
    final String KEY_SHARE_DONNEES_ERONNEES   = "KSDE_03";
    
    final String DEMANDE_CONFIRMATION_DE_PARTAGE = "DCDP_03";
    
    final String DEBUT_ENVOIE_CONFIRMATION_PARTAGE = "DECP_03";
    final String FIN_ENVOIE_CONFIRMATION_PARTAGE = "FECP_03";
    //<=========================== FIN PARTAGE ACCES ========================>//
    
    final String AUTRE_DEMANDE = "AD_01";
    final String MERCI = "MI_01";
    final String FIN_DE_LA_COMMUNICATION = "FC_01";
    
    final String BEGIN = "BGN_01";
    final String END = "END_01";
    
    
    
    /**
     * Methode extractBufferData() allows you to extract all the data saved in the serial buffer
     * @param string_buffer is the input of the methode which contains the received data
     * @return data_out[] is the data arranged on the array String
     */
    /*public static String [] extractBufferData(String string_buffer){
        System.out.println("<--- BEGIN OF THE extractBufferData() methode --->");
        
        String [] data_in = new String[100];
        String [] data_out;
        
        System.out.println("Buffer = " + string_buffer);
        
        boolean flag_buffer_content = string_buffer.length()>0;
        
        //Check the data saved in the buffer
        int buffer_size = 0;       
        
        // Put the buffer contents in the char Array
        char[] charArray = null; //string_buffer.toCharArray();
        String temp = "";
        
        if (flag_buffer_content){
            //Check the data saved in the buffer
            buffer_size = string_buffer.length();       

            // Put the buffer contents in the char Array
            charArray = string_buffer.toCharArray();
        }
        else{
            System.out.println("Le buffer est vide");
            String str_default = "02AB02CD06EFGHIJ";
            buffer_size = str_default.length();
            charArray = str_default.toCharArray();
        }
        
        // Extract the first data which contains 7 charactere
        int count = 0;
        int size = 0;

        // Extract the first size of the first frame
        temp = String.valueOf(charArray[count]) + String.valueOf(charArray[count+1]);
        count = count + 2;
        System.out.println("Premier Cast = " + temp);
        int size_charactere = 0;
        try{
            size_charactere = Integer.parseInt(temp);
        }catch(NumberFormatException ex){
            size_charactere = 0;
            System.out.println("Error while trying to convert String to Integer. The data is : " + temp);
        }
        
        boolean flag_extraction = true;
        while ((count <= buffer_size-1) && flag_extraction){
            temp = "";
            for (int j=count; j<(count + size_charactere); j++){
                char char_ = charArray[j];
                temp = temp + String.valueOf(char_);
                //System.out.println("Temp = " + temp);
            }
            data_in[size] = temp;
            //System.out.println("Data extracted["+size+"] = " + data_in[size]);
            size ++;
            
            // Check if you have got the end of the buffer to stop extracting
            if (buffer_size - (count+size_charactere) <=1){
                flag_extraction = false;
            }
            else{
                temp = String.valueOf(charArray[count + size_charactere]) + String.valueOf(charArray[count + size_charactere+1]);                
                
                //System.out.println("Size futur data = " + temp);
                count = count + size_charactere + 2;
                try{
                    size_charactere = Integer.parseInt(temp);
                }catch(NumberFormatException ex){
                    size_charactere = 0;
                    System.out.println("Error while trying to convert String to Integer " + ex.getMessage());
                }
            }
            
        }
        
        int count_data = 0;
        while(data_in[count_data]!= null){
            count_data ++;
        }
        data_out = new String[count_data];
        System.arraycopy(data_in, 0, data_out, 0, count_data);
        
        System.out.println("<--- END OF THE extractBufferData() methode --->");
        
        return data_out; 
    }
    */
}