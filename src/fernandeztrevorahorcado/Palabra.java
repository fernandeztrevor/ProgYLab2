/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernandeztrevorahorcado;

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

    public void setearPalabra(List lista){
        int index = (int) (Math.random()*26);
        
        
        this.palabra = ((Club) (lista.get(index))).getName();
        this.ayuda = ((Club) (lista.get(index))).getBarrio();
        
    }
    
   public static String ocultarPalabra(String palabra){
    StringBuilder retorno = new StringBuilder();
      for(int i = palabra.length(); i > 0; i--){
            retorno.append("*");
        }
      
      return retorno.toString();
   }
   
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
       /*
       index = palabra.indexOf(ingreso);
       retorno.insert(index, ingreso);
       retorno.deleteCharAt(index+1);*/
       
       return retorno.toString();
   }
   
   
}
