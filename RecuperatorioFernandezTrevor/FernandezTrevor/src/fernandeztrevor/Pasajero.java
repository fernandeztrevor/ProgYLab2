/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fernandeztrevor;

/**
 *
 * @author tfernandez_mecon
 */
public class Pasajero {
    private String _apellido;
    private String _nombre;
    private String _dni;
    private Boolean _esPlus;

    public Pasajero(String _apellido, String _nombre){
        this._apellido = _apellido;
        this._nombre = _nombre;
    }
    
    public Pasajero(String _apellido, String _nombre, String _dni){
        this(_apellido, _nombre);
        this._dni = _dni;
    }
    
    public Pasajero(String _apellido, String _nombre, String _dni, Boolean _esPlus) {
        this(_apellido, _nombre, _dni);
        this._esPlus = _esPlus;
    }

    public Boolean getEsPlus() {
        return _esPlus;
    }

    
    
    public Boolean CompararPasajeros(Pasajero p1){
        Boolean retorno;
        
        retorno = this.equals(p1);
        
        return retorno;
    }
    
    @Override
    public boolean equals(Object obj){
        Boolean retorno;
        
        retorno = ((Pasajero)obj)._dni.equals(this._dni);
        
        return retorno;
    }
    
    
    public String getInfo(){
        StringBuilder retorno = new StringBuilder();
        
        retorno.append("Apellido: ").append(this._apellido);
        retorno.append("\nNombre: ").append(this._nombre);
        retorno.append("\nDNI: ").append(this._dni);
        retorno.append("\nEsPlus: ");
        if(this._esPlus){
            retorno.append("SI");
        }else{
            retorno.append("NO");
        }     
        retorno.append("\n");
        return retorno.toString();
    }
    
    public static void MostrarPasajero(Pasajero p1){
        System.out.println(p1.getInfo());
    }        
}
