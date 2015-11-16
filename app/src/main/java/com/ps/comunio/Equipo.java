package com.ps.comunio;

import java.util.ArrayList;

/**
 * Created by sergiownd on 25/10/15.
 */
public class Equipo {
    private String EqNombre;
    private int EqValor;
    private int EqImagen;
    private ArrayList<Jugador> EqJugadores;

    public Equipo (String name, int valor, int imagen, ArrayList<Jugador> jugadores){
        this.EqNombre=name;
        this.EqValor=valor;
        this.EqImagen=imagen;
        this.EqJugadores=jugadores;
    }

    public String getNombre(){return this.EqNombre;}
    public void setNombre(String s){this.EqNombre=s;}
    public int getValor(){return this.EqValor;}
    public void setValor(int i){this.EqValor=i;}
    public int getEqImagen(){return this.EqImagen;}
    public void setEqImagen(int imagen){this.EqImagen = imagen;}
    public ArrayList<Jugador> getJugadores (){return this.EqJugadores;}
}
