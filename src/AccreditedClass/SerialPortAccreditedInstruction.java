/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccreditedClass;

import AccesGUI.*;
import LinkingGUI.*;
import SharingGUI.*;
import SesameApp.*;
import HomeGUI.*;

import java.io.*;

/**
 *
 * @author LamineBA
 */
public class SerialPortAccreditedInstruction extends SerialPortGPIO{
    
    private String id_sesame_accredited = null;
    private String key_device_accredited = null; 
    private DeviceLinkingData device = null;
    private IdentifiantAndKeyTable table_id_key = null;
            
    public SerialPortAccreditedInstruction(int baudrate){
        super(baudrate);
        
        int count = 0;
        while(count<5){
            try {
                super.sendData(BONJOUR);
                System.out.println("Count = " + count);
                count += 1;
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
    
    /**
     * Methode : analyzeDataReceived => Traitement des données recu
     * @param received_data
     * @throws java.lang.InterruptedException
     */
    @Override
    public void analyzeDataReceived(String received_data) throws InterruptedException{
        super.setLastReceivedData(received_data);
        switch (received_data) {
            case BONJOUR:
                System.out.println("|BONJOUR| recu dans la classe herité");
                Thread.sleep(100);
                super.sendData(BONJOUR);
                break;
                
            case SCAN_SESAME_ENVIRONNANT:
                //reception_buffer = received_data;
                System.out.println("|SCAN_SESAME_ENVIRONNANT| recu dans la classe herité");
                Thread.sleep(100);
                super.sendData("RPi_GUEST");
                break;  
                    
            case "RPi_GUEST":
                System.out.println("|RPi_GUEST| recu dans la classe herité");
                Thread.sleep(100);
                super.sendData("RPi_GUEST");
                break;
                
            case DEMANDE_PARTAGE_ACCES:
                System.out.println("|DEMANDE_PARTAGE_ACCES| recu dans la classe herité");
                Thread.sleep(100);
                super.sendData(PARTAGE_ACCES_AUTORISEE);
                break;
            
            case DEMANDE_INFORMATION_IDENTIFICATION_ACCREDITEE:
                System.out.println("|DEMANDE_INFORMATION_IDENTIFICATION_ACCREDITEE| recu dans la classe herité");
                Thread.sleep(100);
                String [] accredited_data = this.arrangeAccreditedData();
                super.sendData(accredited_data);
                break;
                
            case INFORMATION_ACCREDITE_ENREGISTRE_CORRECTEMENT:
                System.out.println("|INFORMATION_ACCREDITE_ENREGISTRE_CORRECTEMENT| recu dans la classe herité");
                Thread.sleep(100);
                super.sendData(DEMANDE_INFORMATION_SESAME_DOORS);
                break;
                
            case DEMANDE_CONFIRMATION_DE_PARTAGE:
                Thread.sleep(50);
                System.out.println("DEMANDE_CONFIRMATION_DE_PARTAGE recu");
                boolean flag_l = sendSharingConfirmation();
                System.out.println("Confirmation de partage => Status = " + flag_l);
                break;
                
            case BEGIN:
                System.out.println("Reception de |BEGIN| dans la classe hérité");
                Thread.sleep(100);
                // reset the buffer
                super.resetBufferReception();
                super.setSavingFlag(true);
                break;
                
            case END:
                Thread.sleep(100);
                System.out.println("Reception de |END| dans la classe hérité");
                super.setSavingFlag(false);
                this.checkBufferData();
                break;
                
            case MERCI:
                System.out.println("Information envoyée avec succès et rajout de l'écouteur");
                sendData(FIN_DE_LA_COMMUNICATION);
                break;

            default:
                break;
        }
    }
    
    /**
     * Methode : saveSharerInformation() allows you to save all the information about the sharer
     * in a ser file. 
     * @param data : contains the data received in the serial port
     * @return true if the owner information is correct
     * @throws java.lang.InterruptedException
     */
    private boolean saveSharerInformation(String [] data) throws InterruptedException {
        boolean flag = false;

        if (super.isChecksumCorrect(data)){
            OwnerInformation user = new OwnerInformation(data);
            // Make the Serialization before closing the windows
            File file = new File("sharer_information.ser");
            try{
                try (FileOutputStream fileOut = new FileOutputStream(file); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    out.writeObject(user);
                    System.out.println(user);
                    flag = true;
                    System.out.println(file.getName() + " file is created correcly");
                }
            }catch(IOException i){
                System.out.println("Exception de Serialisation " + i.getMessage());
                flag = false;
            }
        }
        else{
            System.out.println("The data about the owner of the SESAME is not saved");
            flag = false;
        }

        return flag;
    }
    
    /**
     * Methode : saveSharedDevice() allows you to save all the information about the device
     * which the acces is shared in a ser file. 
     * @param data : contains the data received in the serial port
     * @return true if the device is saved
     * @throws java.lang.InterruptedException
     */
    private boolean saveSharedDevice(String [] data) throws InterruptedException {
        boolean flag = false;

        if (isChecksumCorrect(data)){
            device = new DeviceLinkingData(data);
            System.out.println("<=== Device Accredited ===>");
            System.out.println(device);
            System.out.println("<=== End Device Accredited ===>");
            
            // Make the Serialization before closing the windows
            File file = new File("device_linking_shared.ser");
            try{
                try (FileOutputStream fileOut = new FileOutputStream(file); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    out.writeObject(device);
                    System.out.println(device);
                    flag = true;
                    System.out.println(file.getName() + " file is created correcly");
                }
            }catch(IOException i){
                System.out.println("Exception de Serialisation " + i.getMessage());
                flag = false;
            }
        }
        else{
            System.out.println("The data about the device is not saved");
            flag = false;
        }
        
        if (device instanceof DeviceLinkingData){
            flag = true;
            id_sesame_accredited = device.getDeviceIdentifiant();
            System.out.println("Identifiant accrédité = " + id_sesame_accredited);
        }
        else{
            flag = false;
            id_sesame_accredited = "";
        }
        
        return flag;
    }
    
    /**
     * Methode checkBufferData() allows you to verify all the data saved in the buffer
     * @throws java.lang.InterruptedException
     */
    private void checkBufferData() throws InterruptedException{
        System.out.println("<--- BEGIN OF CALLING checkBufferData() methode --->");
        
        // Get the data saved in the buffer
        System.out.println("Contents of the buffer : " + super.getBufferReception());
        String [] data_in = SerialPortGPIO.extractBufferData(super.getBufferReception());
        
        // reset the reception buffer
        super.resetBufferReception();
        
        // Extract the first and last data to check the kind of request
        String first_data = data_in[0];
        String last_data  = data_in[data_in.length - 1];
        
        System.out.println("First = " + first_data);
        System.out.println("Last  = " + last_data);
        
        // Extract only the data about the request
        int size_data = data_in.length -2;
        String [] data_temp = new String[size_data];
        System.arraycopy(data_in, 1, data_temp, 0, size_data);
        for (int i=0; i<data_temp.length; i++){
            //data_temp[i] = data_in[i+1];
            System.out.println("Classe fille : valide data["+i+"] = " + data_temp[i]);
        }
        
        // Call the checkSavedData() methode to identify the kind of request
        boolean flag = checkSavedData(first_data, last_data, data_temp);
        
        System.out.println("<--- END OF CALLING checkBufferData() methode --->");
    }
    
    /**
     * Methode : checkSavedData : Traitement des données recu et sauvegarder dans le buffer de reception
     * @param first_data
     * @param last_data
     * @param data
     * @return flag : if the data is saved correctly
     * @throws java.lang.InterruptedException
     */
    private boolean checkSavedData(String first_data, String last_data, String [] data) throws InterruptedException{
        System.out.println("<--- BEGIN OF THE checkSavedData() methode --->");
        boolean flag = false;
        
        if ((first_data != null && first_data.equals(DEBUT_ENVOIE_INFORMATION_UTILISATEUR_PARTAGEANT)) && 
            (last_data  != null  && last_data.equals(FIN_ENVOIE_INFORMATION_UTILISATEUR_PARTAGEANT))){
            System.out.println("First if");
            if(data != null){
                
                System.out.println("Before calling saveSharerInformation()");
                flag = saveSharerInformation(data);
                System.out.println("After calling saveSharerInformation()");
                
                if(flag){
                    System.out.println("The data is saved correctly");
                    Thread.sleep(500);
                    this.sendData(INFORMATION_PARTAGEUR_ENREGISTRE_CORRECTEMENT);
                }
                else{
                    System.out.println("The data is not saved because it contains some invalid data");
                    Thread.sleep(500);
                    this.sendData(INFORMATION_PARTAGEUR_DONNEES_ERONEES);
                }
            }
            else{
                System.out.println("The data is not saved because it contains some invalid data");
                Thread.sleep(500);
                this.sendData(INFORMATION_PARTAGEUR_DONNEES_ERONEES);
                System.out.println("Le buffer est invalide");
                flag = false;
            }   
        }
        else if ((first_data != null && first_data.equals(DEBUT_ENVOIE_INFORMATION_SESAME_DOORS)) && 
            (last_data  != null  && last_data.equals(FIN_ENVOIE_INFORMATION_SESAME_DOORS))){
            System.out.println("First if");
            if(data != null){
                
                System.out.println("Before calling saveSharedDevice()");
                flag = saveSharedDevice(data);
                System.out.println("After calling saveSharedDevice()");
                
                if(flag){
                    System.out.println("The data is saved correctly");
                    Thread.sleep(500);
                    this.sendData(INFORMATION_SESAME_DOORS_ENREGISTRE_CORRECTEMENT);
                }
                else{
                    System.out.println("The data is not saved because it contains some invalid data");
                    Thread.sleep(500);
                    this.sendData(INFORMATION_SESAME_DOORS_DONNEES_ERONNEES);
                }
            }
            else{
                System.out.println("The data is not saved because it contains some invalid data");
                Thread.sleep(500);
                this.sendData(INFORMATION_SESAME_DOORS_DONNEES_ERONNEES);
                System.out.println("Le buffer est invalide");
                flag = false;
            }   
        }
        // ADD Device on the table which containing identifiant and key
        else if ((first_data != null && first_data.equals(DEBUT_ENVOIE_KEY_SHARE)) && 
                 (last_data  != null  && last_data.equals(FIN_ENVOIE_KEY_SHARE))){
            System.out.println("First if");
            if(data != null){
                
                System.out.println("Before calling add device on the table class");
                flag = addDeviceShared(data);
                System.out.println("After calling add device on the table class");
                
                System.out.println("Appel de la methode pour la sauvegarde = " + flag);
                if(flag){
                    Thread.sleep(500);
                    this.sendData(KEY_SHARE_ENREGISTREE_CORRECTEMENT);
                    System.out.println("|KEY_LINK_ENREGISTREE_CORRECTEMENT| is sent to the SESAME because the key is saved correclty");
                }
                else{
                    Thread.sleep(500);
                    this.sendData(KEY_SHARE_DONNEES_ERONNEES);
                    System.out.println("|KEY_LINK_DONNEES_ERONNEES| is sent to the SESAME because of the key is invalide");
                }
            }
        }
        // ===>
        else{
            flag = false;
            System.out.println("First Else ");
        }
        
        System.out.println("<--- END OF THE checkSavedData() methode -->");
        return flag; 
    }
    
    
    /**
     * Methode arrangeAccreditedData() allows you to arrange the information for Accreditation request
     * @throws java.lang.InterruptedException
     */
    private String [] arrangeAccreditedData(){
        System.out.println("<--- BEGIN OF CALLING sendAccreditedData() methode --->");
        String [] data_accredited = null; 
        String [] arranged_data = null;
        boolean extract_sharer = false;
        
        /* Deserializable of the file containing the information of the owner
         * to add the indentifier number and password 
         */          
        OwnerInformation user = null;
        File file = new File("owner_information.ser");
        try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            user = (OwnerInformation) in.readObject();
            //System.out.println("Extraction de OwnerInformation");
            data_accredited = user.getOwnerInformationForSharing();
            System.out.println(user);
            extract_sharer = true;
            
        }catch(IOException io){
            System.out.println("Exception de IO : " + io.getMessage());
            extract_sharer = false;
        }catch(ClassNotFoundException c){
           System.err.println("OwnerInformation class not found");
           extract_sharer = false;
        }
        
        if (extract_sharer){
            int formule = 0; 
            int number_element = data_accredited.length;
            int size_arranged = number_element+3;
            int checksum = 0;
            arranged_data = new String[size_arranged];
            
            // Send the first frame to inform the device all the data received after taht frame is to save
            arranged_data[0]  = DEBUT_ENVOIE_INFORMATION_UTILISATEUR_ACCREDITE;

            // Put the owner information without the ID of its Sesame
            System.arraycopy(data_accredited, 0, arranged_data, 1, number_element);
            
            // Put the Sesame Sharer ID on the variable "id_sesame_sharer"
            id_sesame_accredited = data_accredited[number_element-1];
            System.out.println("ID Of the sesame partageur extracted : " + id_sesame_accredited);
            
            // Create the checksum
            for (int j=0; j<number_element; j++){
                formule = formule + (number_element-j)*data_accredited[j].length();
            }
            checksum = formule - number_element*128;
            arranged_data[number_element+1] = Integer.toString(checksum);

            // Send the last frame to inform the device that is the last data
            arranged_data[number_element+2] = FIN_ENVOIE_INFORMATION_UTILISATEUR_ACCREDITE;
        }
        else{
            arranged_data = new String[1];
            arranged_data[0] = "NOK";
        }
        System.out.println("<--- END   OF CALLING sendAccreditedData() methode --->");
        return arranged_data;
    } 
    
    /**
     * Methode : addDeviceShared() allows you to add the device in the table which containing 
     * the id and the key information. 
     * @param data
     * @return true if the owner information is correct
     * @throws java.lang.InterruptedException
     */
    private boolean addDeviceShared(String [] data) throws InterruptedException {
        
        boolean flag = false;
        boolean flag_checksum = false;
        boolean flag_extract_user = false;
        boolean flag_extract_device = false;
        boolean flag_creating_device = false;
        boolean flag_serialization = false;
        boolean flag_end = false;
        
        int checksum_received = 0; 
        int checksum_calcule = 0;
        
        int key_size = 0;
        
        OwnerInformation user_new = null;
        DeviceLinkingData device_linking_new = null;
        
        DeviceLinkedData device_linked = null;
        
        IdentifiantAndKeyTable table_temp = null;
        
        if (data != null && data.length>=2){
            key_device_accredited = data[0];
            key_size = key_device_accredited.length();
            
            // Extract the checksul and convert it
            try{
                checksum_received = Integer.parseInt(data[1]);
            }catch(NumberFormatException ex){
                checksum_received = 0;
                System.out.println("Impossible de convert String to Intger : " + ex.getMessage());
            }
            
            // Calcul du checksul
            checksum_calcule  = (key_size*128) + (key_size/2)*64 + (key_size/4)*32; 
            checksum_calcule += (key_size/8)*16 + (key_size/16)*8 + (key_size/32)*4;
            checksum_calcule += (key_size/64)*2;
            
        }
        else{
            System.out.println("L'argument passé en paramètre est invalide");
            flag= false;
        }
        
        flag_checksum = checksum_calcule == checksum_received;
        
        // Test if the checksum is correct or not 
        if (flag_checksum){
            System.out.println("CRC Correct");

            File file = new File("sharer_information.ser");
            // Deserialization otf the sharer_information
            try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
                user_new = (OwnerInformation) in.readObject();
                System.out.println("<=== SHARER INFORMATION ===>");
                System.out.println(user_new);
                flag_extract_user = true;
                
            }catch(IOException i){
                flag_extract_user = false;
                System.out.println("IOException : " + i.getMessage());
            }catch(ClassNotFoundException c){
                flag_extract_user = false;
                System.out.println("OwnerInformation class not found " + c.getMessage());
            }
                    
            file = new File("device_linking_shared.ser");
            // Deserialization otf the DeviceLinkingInfo
            try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
                device_linking_new = (DeviceLinkingData) in.readObject();
                System.out.println("<=== DEVICE LINK SHARED INFORMATION ===>");
                System.out.println(device_linking_new);
                flag_extract_device = true;
                
            }catch(IOException i){
                flag_extract_device = false;
                System.out.println("IOException : " + i.getMessage());
            }catch(ClassNotFoundException c){
                flag_extract_device = false;
                System.out.println("DeviceLinkingData class not found " + c.getMessage());
            }
        }
        else{
            flag_extract_user = false;
            flag_extract_device = false;
            System.out.println("CRC inCorrect");
        }

        // Check if the extraction of the owner is done succesfully, create the class DeviceLinkedData
        if (flag_extract_user && flag_extract_device){
            // Create the DeviceLinkedData class
            device_linked = new DeviceLinkedData (user_new,device_linking_new, id_sesame_accredited, key_device_accredited);
            flag_creating_device = true;
        }
        else{
            flag_creating_device = false;
        }
        
        
        // Check if the class "DeviceLinkedData" is created correctly
        if (flag_creating_device){
            // Make the deserialization of the table file which is the database of the device
            File file = new File("identifiant_and_key_table.ser");
            try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
                table_temp = (IdentifiantAndKeyTable) in.readObject();

                // Add the device link information on the table
                table_temp.addDeviceForLink(device_linked);
                System.out.println("Content of the table after");
                System.out.println(table_temp);

                flag_serialization = true;

            }catch(IOException i){
                flag_serialization = false;
                System.out.println("IOException : " + i.getMessage());
            }catch(ClassNotFoundException c){
                flag_serialization =false;
                System.out.println("DeviceLinkingData class not found");
            }
        }
        else{
            System.out.println("'identifiant_and_key_table.ser' is not found in the current directory");
            flag_serialization = false;
        }

        // Check if the flag serialization is correct then make the serialization in the file   
        if (flag_serialization){
            // Make the serialization to save the new added device on the table
            File file = new File("identifiant_and_key_table.ser");
            try(FileOutputStream fileOut = new FileOutputStream(file); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(table_temp);
                // End of the Serialization for IdentifiantAndKeyTable
                System.out.println("Serialized of the new IdentifiantAndKeyTable is saved in identifiant_and_key_table.ser");
                flag_end = true;
            }catch(IOException io){
                flag_end = false;
                System.out.println("Exception for IdentifiantAndKeyTable : " + io.getMessage());
                System.out.println("Serialized of the new IdentifiantAndKeyTable is not done : check error");
            }
        }
        else{
            flag_end = false;
            System.out.println("impossible to read the 'identifiant_and_key_table.ser' file or the file is not found");
        }
        
        return flag_end;
    }
    
    /**
     * Methode : sendSharingConfirmation() allow you to send the confirmation of the sharing to the Sesame adminsitrator
     * @return flag if the linking confirmation is sent
     * @throws java.lang.InterruptedException
     */
    private boolean sendSharingConfirmation() throws InterruptedException{
        System.out.println("<--- BEGIN : sendSharingConfirmation --->");
        boolean flag = false;
        OwnerInformation owner = null;
        String id_sesame = null;
        String [] confirmation_partage = new String[4];
        
        File file = new File("owner_information.ser");
        
        // Make the serialization
        try (FileInputStream fileIn = new FileInputStream(file); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            owner = (OwnerInformation) in.readObject();
            id_sesame = owner.getOwnerIdentifiant();
            System.out.println("Identifiant du Sesame = " + id_sesame);
           
            int formule = id_sesame.length()*128;

            // Make the table for the linking confirmation
            confirmation_partage[0] = DEBUT_ENVOIE_CONFIRMATION_PARTAGE;
            confirmation_partage[1] = id_sesame;
            confirmation_partage[2] = Integer.toString(formule);
            confirmation_partage[3] = FIN_ENVOIE_CONFIRMATION_PARTAGE;

            flag = true;
            
        }catch(IOException i){
            flag = false;
            System.out.println("IOException : " + i.getMessage());
        }catch(ClassNotFoundException c){
           System.out.println("DeviceLinkingData class not found");
           flag =false;
        }

        if (flag){
        	// send the linking confirmation
            sendData(confirmation_partage);
            System.out.println("Identifiant of the Peripherique is sent to the Sesame");
        }
        else{
            System.out.println("Identifiant of the Peripherique is not sent to the Sesame");
        }
        System.out.println("<--- END   : sendSharingConfirmation --->");

        return flag;
    }
    
    public static void main(String [] args){
        SerialPortAccreditedInstruction test = new SerialPortAccreditedInstruction(9600);
        int count = 0;
        while (true){
            if (count<5){
                System.out.println("Count SESAME DOORS = " + count);
            }
            count ++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
        }
    }
}
