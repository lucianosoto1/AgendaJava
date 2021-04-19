package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Processor {

    private List<Contact> contacts = new ArrayList<>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void leerArchivo(String archivo){
        FileReader fr = null;
        BufferedReader br = null;
        try {
            File data = new File (archivo);
            fr = new FileReader (data);
            br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine())!=null) {
                linea.trim();
                String [] contact = linea.split(",");
                contacts.add(new Contact(contact[0].split(":")[1], contact[1].split(":")[1], contact[2].split(":")[1]));
            }
        }
        catch(Exception leerArchivoException){
        	leerArchivoException.printStackTrace();
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception leerArchivoException){
            	leerArchivoException.printStackTrace();
            }
        }
    }

    public void guardarContacto (String name, String surname, String email){
        contacts.add(new Contact(name, surname, email));
    }

    public void borrarContacto (String email){
        var contactDelete = contacts.stream().filter(contact -> !contact.getEmail().trim().equals(email.trim()));
       
    }

    public void guardarAgenda(String archive) throws IOException {
        File archivo = new File(archive);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            contacts.forEach(contact -> {
                try {
                    bw.write(contact.toString() +"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
        bw.close();
    }
}
