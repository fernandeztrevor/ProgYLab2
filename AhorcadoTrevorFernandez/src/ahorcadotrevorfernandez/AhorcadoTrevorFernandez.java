/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadotrevorfernandez;

import ahorcadotrevorfernandez.Club;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tfernandez_mecon
 */
public class AhorcadoTrevorFernandez {

    /**
     * @param args the command line arguments
     */
    private static final String SERIALIZED_FILE_NAME = "primeraDivision.xml";
    
    public static void main(String[] args) {
        
        
        
    }
    
    public static void serializarClubes(List pD) {
        XMLEncoder encoder = null;
     
        try {
            FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE_NAME);
            BufferedOutputStream bos = new BufferedOutputStream(fos); 
            encoder = new XMLEncoder(bos);
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: No se pudieron guardar los clubes");
        }        
        
        encoder.writeObject(pD);
        encoder.close();
    }

    public static List deserializarClubes() {
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
        }
        
        List clubes = (List) decoder.readObject();

        return clubes;
    }

    
}
