/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernandeztrevorahorcado;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tfernandez_mecon
 */
public class FernandezTrevorAhorcado {

    /**
     * @param args the command line arguments
     */
    private static final String SERIALIZED_FILE_NAME = "primeraDivision.xml";
    public static void main(String[] args) {
       
        int contador = 6;
        Scanner lector = new Scanner(System.in);
        String ingreso;
        
        
        //creo una lista con los equipos y trato de cargarlos de archivo, si no puedo creo el archivo y la lista
        List primeraDivision = new ArrayList();          
        if(!deserializarClubes(primeraDivision)){
        serializarClubes(primeraDivision);
        }
               
        //seteo un equipo en la palabra a adivinar
        Palabra palabra = new Palabra();
        palabra.setearPalabra(primeraDivision);
        
        //oculto la palabra a adivinar
        String auxiliar = palabra.getPalabra();
        String oculto = Palabra.ocultarPalabra(palabra.getPalabra());
        
        //agrego los espacios a la palabra oculta (si tiene)
        oculto = palabra.decubrirLetra(" ", oculto, palabra.getPalabra());        
        auxiliar = auxiliar.toLowerCase();
        
        //creo un bucle pidiendo letras
        for(;;){
        System.out.println(oculto);                
        
        System.out.println("Ingrese una letra: ");
        ingreso = lector.next();        
        
        if(auxiliar.contains(ingreso)){
            oculto = palabra.decubrirLetra(ingreso, oculto, auxiliar);  
        }else{
            System.out.println("Fallaste!");
            contador--;
        }  
     
        if(!oculto.contains("*")){
            System.out.println("GANASTE!, la palabra oculta era " + palabra.getPalabra());
            break;
        }else{
            if(contador==0){
                System.out.println("GAME OVER");
                break;
            }
            if(contador == 1){
                System.out.println("Último intento");
                System.out.println("Pista: su cancha esta ubicada en " + palabra.getAyuda()+"\n");         
            }
        }
        }
    }
    
    public static void serializarClubes(List pD) {
        XMLEncoder encoder = null;
     
        try {
            FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE_NAME);
            BufferedOutputStream bos = new BufferedOutputStream(fos); 
            encoder = new XMLEncoder(bos);
            Club.setearClubes(pD);
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: No se pudieron guardar los clubes");
        }        
        
        encoder.writeObject(pD);
        encoder.close();
    }

   /* public static List deserializarClubes() {
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
        }
        
        List clubes = (List) decoder.readObject();

        return clubes;
    }*/
    
    public static Boolean deserializarClubes(List pD){
        Boolean retorno = false;
        
        XMLDecoder decoder = null;
        try {
            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
            retorno = true;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
            return false;
        }
        
        
        List clubes = (List) decoder.readObject();
        pD.addAll(clubes);
        
        return retorno;
    }
       
}
