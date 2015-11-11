package com.ps.comunio;

import java.util.ArrayList;

/**
 * Created by sergiownd on 25/10/15.
 */
public class Equipo {
    private String EqNombre;
    private int EqValor;
    private ArrayList<Jugador> EqJugadores;
    private int EqImagen;

    public Equipo (String name, int valor,int imagen){
        this.EqNombre=name;
        this.EqValor=valor;
        this.EqImagen=imagen;
    }

    public String getNombre(){return this.EqNombre;}
    public void setNombre(String s){this.EqNombre=s;}
    public int getValor(){return this.EqValor;}
    public void setValor(int i){this.EqValor=i;}
    public ArrayList<Jugador> getJugadores (){return this.EqJugadores;}
    public int getEqImagen(){return this.EqImagen;}
    public void setImagen(int s){this.EqImagen=1;}
}
