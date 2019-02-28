/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernandeztrevorahorcado;

/**
 *
 * @author tfernandez_mecon
 */
public class Palabra {
    private String palabra;

    public Palabra(String palabra) {
        this.palabra = palabra;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
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
       
       index = palabra.indexOf(ingreso);
       retorno.insert(index, ingreso);
       retorno.deleteCharAt(index+1);
       
       return retorno.toString();
   }
}
