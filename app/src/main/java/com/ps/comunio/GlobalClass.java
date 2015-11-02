package com.ps.comunio;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Ivan on 01/11/2015.
 */
public class GlobalClass extends Application {
    private String usuario = "";
    private ArrayList<Jugador> jugadoresDisponibles = new ArrayList<Jugador>();
    private ArrayList<Jugador> jugadoresFichados= new ArrayList<Jugador>();

    @Override
    public void onCreate(){
        super.onCreate();
        jugadoresDisponibles.add(new Jugador("Keylor Navas", "Real Madrid", "Portero", "7000000", 0.1,R.drawable.navas));
        jugadoresDisponibles.add(new Jugador("Lucas Perez","Deportivo","Centrocampista","11250000",0.2,R.drawable.lucas));
        jugadoresDisponibles.add(new Jugador("Nolito", "Celta", "Delantero", "15320000", 23.2,R.drawable.nolito));
        jugadoresDisponibles.add(new Jugador("Orellana","Celta","Centrocampista","14190000",21.2,R.drawable.orellana));
        jugadoresDisponibles.add(new Jugador("Iago Aspas","Celta","Delantero","11040000",23.1,R.drawable.aspas));
        jugadoresDisponibles.add(new Jugador("Cristiano Ronaldo","Real Madrid","Delantero","22910000",1.1,R.drawable.cristiano));
        jugadoresDisponibles.add(new Jugador("Benzema","Real Madrid","Delantero","14510000",1.4,R.drawable.benzema));
        jugadoresDisponibles.add(new Jugador("Modric","Real Madrid","Centrocampista","14300000",3.1,R.drawable.modric));
        jugadoresDisponibles.add(new Jugador("Marcelo","Real Madrid","Defensa","8450000",2.3,R.drawable.marcelo));
        jugadoresDisponibles.add(new Jugador("Saúl Berjón","Eibar","Centrocampista","6680000",7.8,R.drawable.saul));
        jugadoresDisponibles.add(new Jugador("Daniel Wass","Celta","Centrocampista","6540000",8.9,R.drawable.wass));
        jugadoresDisponibles.add(new Jugador("Griezmann","Atlético de Madrid","Delantero","21560000",6.7,R.drawable.griezmann));
        jugadoresDisponibles.add(new Jugador("Westermann","Betis","Defensa","5190000",6.7,R.drawable.westermann));
        jugadoresDisponibles.add(new Jugador("Jonathan Viera","Las Palmas","Centrocampista","7060000",6.7,R.drawable.viera));
        jugadoresDisponibles.add(new Jugador("Borja Bastón","Eibar","Delantero","6800000",7.7,R.drawable.defecto));
        jugadoresDisponibles.add(new Jugador("Lora","Sporting","Defensa","4070000",8.8,R.drawable.defecto));
        jugadoresDisponibles.add(new Jugador("Luis Suárez","Futbol Club Barcelona","Delantero","17690000",9.9,R.drawable.suarez));
        jugadoresDisponibles.add(new Jugador("Augusto Fernández","Celta","Centrocampista","5640000",4.7,R.drawable.augusto));
        jugadoresDisponibles.add(new Jugador("Sergi Roberto","Futbol Club Barcelona","Centrocampista","4420000",8.8,R.drawable.sergi));
        jugadoresDisponibles.add(new Jugador("David Simón","Las Palmas","Defensa","3910000",9.9,R.drawable.simon));
        jugadoresDisponibles.add(new Jugador("Aduriz","Athletic Bilbao","Delantero","12420000",5.5,R.drawable.aduriz));
        jugadoresDisponibles.add(new Jugador("Rubén Castro","Betis","Delantero","9500000",9.9,R.drawable.castro));
    }
    public void setUsuario(String nombre){
        this.usuario=nombre;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public ArrayList<Jugador> getJugadoresFichados(){
        return this.jugadoresFichados;
    }
    public void ficharJugador(Jugador player){
        jugadoresDisponibles.remove(player);
        jugadoresFichados.add(player);
    }
    public void venderJugador(Jugador player){
        jugadoresFichados.remove(player);
    }
    public ArrayList<Jugador> getJugadoresDisponibles(){
        return this.jugadoresDisponibles;
    }

}
