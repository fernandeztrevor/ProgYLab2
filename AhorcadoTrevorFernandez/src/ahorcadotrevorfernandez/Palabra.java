/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadotrevorfernandez;


import java.util.List;


/**
 *
 * @author tfernandez_mecon
 */

public class Palabra {
    private String palabra;
    private String ayuda;

    
    public Palabra() {
    }
    
    public Palabra(String palabra, String ayuda) {
        this.palabra = palabra;
        this.ayuda = ayuda;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getAyuda() {
        return ayuda;
    }

    public void setAyuda(String ayuda) {
        this.ayuda = ayuda;
    }

    //selecciona una palabra random de la lista y la setea
    public void setearPalabra(List lista){
        int index = (int) (Math.random()*26);
        
        this.palabra = ((Club) (lista.get(index))).getName();
        this.ayuda = ((Club) (lista.get(index))).getBarrio();  
    }
    
    //se devuelve un string con tantos * como cantidad de letras tiene la palabra que recibe
    public static String ocultarPalabra(String palabra){
    StringBuilder retorno = new StringBuilder();
      for(int i = palabra.length(); i > 0; i--){
            retorno.append("*");
        }
      
      return retorno.toString();
   }
   
    //se le pasa una letra, recorre el string, la inserta y borra el caracter siguiente
    public String decubrirLetra(String ingreso, String oculto, String palabra){
       StringBuilder retorno = new StringBuilder();
       int index;
              
       retorno.append(oculto);
       
       for(int i = 0; i < palabra.length(); i++){
           
           if(Character.compare(ingreso.charAt(0), palabra.charAt(i)) == 0){
            retorno.insert(i, ingreso);
            retorno.deleteCharAt(i+1);   
           }         
       }
       
       return retorno.toString();
   }
    
    //busca si la palabra contiene la letra
    public String buscarLetra(Palabra auxiliar, String oculto, String ingreso){
       String retorno = null;
       
       if((auxiliar.getPalabra()).contains("a")){
            oculto = auxiliar.decubrirLetra("a", oculto, auxiliar.getPalabra()); 
            
        }else{
            retorno = "Fallaste!";
        }
       
       return retorno;
       
   }

    //devuelve un string con la ubicacion de la imagen según el contador
    public String stringImagen(int contador){
    String url = null;
    
    switch(contador){
        case 0:
            url = "/ahorcadotrevorfernandez/ahorcado6b.jpg";
            break;
        case 1:
            url = "/ahorcadotrevorfernandez/ahorcado5.jpg";
            break;
        case 2:
            url = "/ahorcadotrevorfernandez/ahorcado4.jpg";
            break;
        case 3:
            url = "/ahorcadotrevorfernandez/ahorcado3.jpg";
            break;
        case 4:
            url = "/ahorcadotrevorfernandez/ahorcado2.jpg";
            break;
        case 5:
            url = "/ahorcadotrevorfernandez/ahorcado1.jpg";
            break;
        case 6:
            url = "/ahorcadotrevorfernandez/ahorcado0.jpg";
            break;
    }
    
    return url;
    
}
       
}
