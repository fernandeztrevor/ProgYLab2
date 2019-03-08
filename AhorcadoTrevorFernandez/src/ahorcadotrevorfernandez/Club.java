/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadotrevorfernandez;

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
public class Club {
    private String name;
    private String barrio;

    private static final String SERIALIZED_FILE_NAME = "primeraDivision.xml";
    public Club(){}
    
    public Club(String name, String barrio) {
        this.name = name;
        this.barrio = barrio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

//devuelve un string con todos los clubes
    public static String listarClubes(List lista){

        StringBuilder retorno = new StringBuilder();
        
        for(Object club : lista ){
            Club c;
            c =(Club)club;
                retorno.append(c.name).append("\n");
        }
        return retorno.toString(); 
    }
    
//devuelve una lista con todos los clubes
    public static void setearClubes(List lista){
        Club Argentinos = new Club("Argentinos", "La Paternal");
        Club Aldosivi = new Club("Aldosivi", "Mar del Plata");
        Club Banfield = new Club("Banfield", "Banfield");
        Club Belgrano = new Club("Belgrano", "Cordoba");
        Club Boca = new Club("Boca", "La Boca");
        Club Colon = new Club("Colon", "Santa Fe");
        Club Huracan = new Club("Huracan", "Parque Patricios");
        Club Independiente = new Club("Independiente", "Avellaneda");
        Club Lanus = new Club("Lanus", "Lanus");
        Club Newells = new Club("Newells", "Rosario");
        Club Patronato = new Club("Patronato", "Parana");
        Club River = new Club("River", "Nuñez");
        Club Rosario = new Club("Rosario Central", "Rosario");
        Club SanLorenzo = new Club("San Lorenzo", "Bajo Flores");        
        Club SanMartinDeSanJuan = new Club("San Martin De San Juan", "San Juan");
        Club SanMartinDeTucuman = new Club("San Martin De Tucuman", "Tucuman");
        Club Talleres = new Club("Talleres", "Cordoba");
        Club Tigre = new Club("Tigre", "Victoria");
        Club AtleticoTucuman = new Club("Atletico Tucuman", "Tucuman");
        Club Union = new Club("Union", "Santa Fe");
        Club Velez = new Club("Velez", "Liniers");
        Club Gimnasia = new Club("Gimnasia", "La Plata");
        Club GodoyCruz = new Club("Godoy Cruz", "Godoy Cruz");
        Club Estudiantes = new Club("Estudiantes", "La Plata");
        Club DefensaYJusticia = new Club("Defensa Y Justicia", "Florencio Varela");
        Club Racing = new Club("Racing", "Avellaneda");
        
        lista.add(Argentinos);
        lista.add(Aldosivi);
        lista.add(Banfield);
        lista.add(Belgrano);
        lista.add(Boca);
        lista.add(Colon);
        lista.add(Huracan);
        lista.add(Independiente);
        lista.add(Lanus);
        lista.add(Newells);
        lista.add(Patronato);
        lista.add(River);
        lista.add(Rosario);
        lista.add(SanLorenzo);
        lista.add(SanMartinDeSanJuan);
        lista.add(SanMartinDeTucuman);
        lista.add(Talleres);
        lista.add(Tigre);
        lista.add(AtleticoTucuman);
        lista.add(Union);
        lista.add(Velez);
        lista.add(Gimnasia);
        lista.add(GodoyCruz);
        lista.add(Estudiantes);
        lista.add(DefensaYJusticia);
        lista.add(Racing); 
    }  
   
//guarda la lista en un archivo xml
    public static void serializarClubes(List pD) {
        XMLEncoder encoder = null;  

        try {
            FileOutputStream fos = new FileOutputStream(SERIALIZED_FILE_NAME);
            BufferedOutputStream bos = new BufferedOutputStream(fos); 
            encoder = new XMLEncoder(bos);
            System.out.println("Archivo generado");
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("ERROR: No se pudieron guardar los clubes");
        }        
        
        encoder.writeObject(pD);
        encoder.close();
    }

//importa una lista desde una archivo xml, si el archivo no existe, genera la lista y el archivo
    public static List deserializarClubes() {
        XMLDecoder decoder = null;
        List clubes = new ArrayList(); 
        try {  

            decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(SERIALIZED_FILE_NAME)));
            clubes = (List) decoder.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Archivo no encontrado");
            Club.setearClubes(clubes);
            serializarClubes(clubes);
            
            return clubes;
        }

        return clubes;
    }
}


