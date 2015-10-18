package com.ps.comunio;

import java.io.Serializable;

/**
 * Created by Ivan on 17/10/2015.
 */
public class Jugador implements Serializable {
    private String Nombre;
    private String Equipo;
    private String Posicion;
    private String Valor;
    public Jugador(String Nombre,String Equipo,String Posicion,String Valor){
        this.Nombre = Nombre;
        this.Equipo = Equipo;
        this.Posicion = Posicion;
        this.Valor = Valor;
    }
    public String getNombre(){
        return this.Nombre;
    }
    public String getEquipo(){
        return this.Equipo;
    }
    public String getPosicion(){
        return this.Posicion;
    }
    public String getValor(){
        return this.Valor;
    }
}
