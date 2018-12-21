/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernandeztrevor;

import java.util.ArrayList;

/**
 *
 * @author tfernandez_mecon
 */
public class FernandezTrevor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
        
        Pasajero pasajero1 = new Pasajero("apellido1", "nombre1", "_dni1", Boolean.TRUE);
        Pasajero pasajero2 = new Pasajero("apellido2", "nombre2", "_dni2", Boolean.FALSE);
        Pasajero pasajero3 = new Pasajero("apellido3", "nombre3", "_dni3", Boolean.TRUE);
        Pasajero pasajero4 = new Pasajero("apellido4", "nombre4", "_dni4", Boolean.FALSE);
        Pasajero pasajero5 = new Pasajero("apellido5", "nombre5", "_dni5", Boolean.TRUE);
        
        ArrayList<Vuelo> listaDeVuelos = new ArrayList<>();
        
        Vuelo vuelo1 = new Vuelo("fecha1", "empresa1", 100, 5);
        vuelo1.AgregarPasajero(pasajero1);
        vuelo1.AgregarPasajero(pasajero2);
        vuelo1.AgregarPasajero(pasajero3);
        vuelo1.AgregarPasajero(pasajero4);
        vuelo1.AgregarPasajero(pasajero5);
        
        listaDeVuelos.add(vuelo1);
        
        Vuelo vuelo2 = new Vuelo("fecha2", "empresa2", 200, 3);
        vuelo2.AgregarPasajero(pasajero1);
        vuelo2.AgregarPasajero(pasajero3);
        vuelo2.AgregarPasajero(pasajero5);
        listaDeVuelos.add(vuelo2);  
        
        vuelo1.MostrarVuelo();
        System.out.println("Valoracion del vuelo1: "+Vuelo.ValorarVuelo(vuelo1)+"\n\n");
        vuelo2.MostrarVuelo();
        System.out.println("Valoracion del vuelo2: "+Vuelo.ValorarVuelo(vuelo2)+"\n\n");        
 
        System.out.println("El gasto para el pasajero 5(plus) es: $" + Vuelo.CalcularGastoPasajero(listaDeVuelos, pasajero5));
    }   
    
    
}
