package com.ps.comunio;

import java.util.ArrayList;

/**
 * Created by sergiownd on 25/10/15.
 */
public class Equipo implements Comparable<Equipo> {
    private String EqNombre;
    private int EqValor;
    private int EqImagen;
    private int puntos;
    private ArrayList<Jugador> EqJugadores;

    public Equipo (String name, int imagen,int puntos,ArrayList<Jugador> EqJugadores){
        this.EqNombre=name;
        this.EqValor=0;
        this.EqImagen=imagen;
        this.puntos=puntos;
        this.EqJugadores = EqJugadores;

    }

    public String getNombre(){return this.EqNombre;}
    public void setNombre(String s){this.EqNombre=s;}
    public int getValor(){return this.EqValor;}
    public int getPuntos(){return this.puntos;}
    public void setValor(int i){this.EqValor=i;}
    public int getEqImagen(){return this.EqImagen;}
    public void setEqImagen(int imagen){this.EqImagen = imagen;}
    public ArrayList<Jugador> getJugadores (){return this.EqJugadores;}

    @Override
    public int compareTo(Equipo another) {
        if(this.puntos<another.puntos)
            return 1;
        if(this.puntos>another.puntos)
            return -1;
        return 0;
    }

    public void actualizaPuntos (){
        for (int i=0; i<this.EqJugadores.size();i++){
            this.EqValor += this.EqJugadores.get(i).getValoracion();
        }
    }
}
