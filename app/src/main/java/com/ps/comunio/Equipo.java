package com.ps.comunio;

import java.util.ArrayList;

/**
 * Created by sergiownd on 25/10/15.
 */
public class Equipo {
    private String EqNombre;
    private int EqValor;
    private ArrayList<Jugador> EqJugadores;

    public Equipo (String name, int valor, ArrayList<Jugador> jugadores){
        this.EqNombre=name;
        this.EqValor=valor;
        this.EqJugadores=jugadores;

    }

    public String getNombre(){return this.EqNombre;}
    public void setNombre(String s){this.EqNombre=s;}
    public int getValor(){return this.EqValor;}
    public void setValor(int i){this.EqValor=i;}
    public ArrayList<Jugador> getJugadores (){return this.EqJugadores;}
}
