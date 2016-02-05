package com.ps.comunio;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Ivan on 01/11/2015.
 */
public class GlobalClass extends Application {
    private String usuario = "";
    private ArrayList<Jugador> jugadoresDisponibles = new ArrayList<Jugador>();
    private ArrayList<Jugador> jugadoresFichados= new ArrayList<Jugador>();
    private ArrayList<Jugador> jugadoresSuplentes= new ArrayList<Jugador>();
    private ArrayList<Noticia> noticias= new ArrayList<Noticia>();
    private ArrayList<Equipo> equipos= new ArrayList<Equipo>();
    private ArrayList<Jugador> AMU = new ArrayList<Jugador>();
    private ArrayList<Jugador> RM = new ArrayList<Jugador>();
    private ArrayList<Jugador> CH = new ArrayList<Jugador>();
    private ArrayList<Jugador> AM = new ArrayList<Jugador>();
    private ArrayList<Jugador> BM = new ArrayList<Jugador>();
    private String saldo = "133000000";

    @Override
    public void onCreate(){
        super.onCreate();
        noticias.add(new Noticia("Armetico de Matriz", "El Armetico de Matriz se alza con una nueva victoria tras derrotar al Real Mandril", "17-11-2015"));
        noticias.add(new Noticia("Comienza la temporada", "Ya era hora, tras unas largas vacaciones comenzamos con la nueva temporada", "16-11-2015"));
        noticias.add(new Noticia("Reparto de puntos", "Se han repartido los puntos de la jornada 10", "14-11-2015"));
        noticias.add(new Noticia("Nuevos jugadores mercado", "Han sido añadidos nuevos jugadores al mercado!", "10-11-2015"));
    }
    public void setUsuario(String nombre){
        this.usuario=nombre;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public String getSaldo(){return this.saldo;}



}
