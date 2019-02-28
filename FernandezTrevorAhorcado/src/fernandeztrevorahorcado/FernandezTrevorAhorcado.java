/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernandeztrevorahorcado;

import java.util.Scanner;

/**
 *
 * @author tfernandez_mecon
 */
public class FernandezTrevorAhorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Palabra palabra = new Palabra("San Martin de San Juan");
       int contador=6;
       Scanner lector = new Scanner(System.in);
       String ingreso;
       String auxiliar = palabra.getPalabra();
       String oculto = Palabra.ocultarPalabra(palabra.getPalabra());
       oculto = palabra.decubrirLetra(" ", oculto, palabra.getPalabra());

        auxiliar = auxiliar.toLowerCase();
        
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
        }
        else{
            if(contador==0){
                System.out.println("GAME OVER");
                break;
            }
        }
        
        
        }
        
        
           
        
        
    }
    
}
