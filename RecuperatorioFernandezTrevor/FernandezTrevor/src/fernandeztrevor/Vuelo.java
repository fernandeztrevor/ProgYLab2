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
public class Vuelo {
    private String _fecha;
    private String _empresa;
    private float _precio;
    private ArrayList<Pasajero> _listaDePasajeros;
    private int _cantMaxima;

    public int getCantMaxima() {
        return _cantMaxima;
    }

    public Vuelo (){
        this._listaDePasajeros = new ArrayList<>();
    }
    
    public Vuelo(int _cantMaxima){
        this();
        this._cantMaxima = _cantMaxima;
    }
    
    public Vuelo(String _fecha, String _empresa, float _precio, int _cantMaxima) {
        this(_cantMaxima);
        this._fecha = _fecha;
        this._empresa = _empresa;
        this._precio = _precio;
    }
    
    public String getInfoVuelo(){
        StringBuilder retorno = new StringBuilder();
        
        retorno.append("Fecha: ").append(this._fecha);
        retorno.append("\nEmpresa: ").append(this._empresa);
        retorno.append("\nPrecio: ").append(this._precio);
        retorno.append("\nCantidadMaxima: ").append(this.getCantMaxima());
        retorno.append("\n");
        retorno.append("\nLista de pasajeros: \n");
        for(Pasajero i : this._listaDePasajeros){
            retorno.append(i.getInfo()).append("\n");
        }              
        
        return retorno.toString();
    }
    
    public Boolean AgregarPasajero(Pasajero p1){
        Boolean retorno = false;
        Boolean yaEsta = false;
        
        if(this._listaDePasajeros.size() < this._cantMaxima){
            for(Pasajero i : this._listaDePasajeros){
                if(p1.CompararPasajeros(i)){
                    yaEsta = true;
                    break;
                }
            }
        }
        if(!yaEsta){
            this._listaDePasajeros.add(p1);
            retorno = true;
        }
        return retorno;
    }
    
    public void MostrarVuelo(){
        System.out.println(this.getInfoVuelo());
    }
    
    public static float ValorarVuelo(Vuelo v1){
        float retorno = 0;   
        
        for(Pasajero i : v1._listaDePasajeros){
           if(i.getEsPlus()){
               retorno = (float) (retorno + (v1._precio*(0.8)));
           }
           else{
               retorno = retorno + v1._precio;
           }
        }
        
        return retorno;        
    }
    
    public static float CalcularGastoPasajero(ArrayList<Vuelo> vuelos, Pasajero p1){
        float retorno = 0;
        float descuento = 1;
        
        if(p1.getEsPlus()){
            descuento = (float)0.8;
        }
        
        for(Vuelo i : vuelos){
            if(i._listaDePasajeros.contains(p1)){
                retorno = retorno + i._precio*descuento;
            }
        }
        
        return retorno;
    }
    
}
