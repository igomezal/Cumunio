package com.ps.comunio;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by Ivan on 01/11/2015.
 */
public class GlobalClass extends Application {
    private String usuario = "";

    private ArrayList<Usuario> usuarios = new ArrayList<>();

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

        usuarios.add(new Usuario("Pepito", "0000", "pepito@gmail.com", "18/8/97"));
        usuarios.add(new Usuario("Jorge", "1995", "jorgape@gmail.com", "3/2/95"));

        noticias.add(new Noticia("Armetico de Matriz", "El Armetico de Matriz se alza con una nueva victoria tras derrotar al Real Mandril", "17-11-2015"));
        noticias.add(new Noticia("Comienza la temporada", "Ya era hora, tras unas largas vacaciones comenzamos con la nueva temporada", "16-11-2015"));
        noticias.add(new Noticia("Reparto de puntos", "Se han repartido los puntos de la jornada 10", "14-11-2015"));
        noticias.add(new Noticia("Nuevos jugadores mercado", "Han sido añadidos nuevos jugadores al mercado!", "10-11-2015"));
        noticias.add(new Noticia("Lesion de ultima hora", "Varanne va a estar un mes de baja", "22-12-2015"));

        equipos.add(new Equipo("Armético de Matriz",150, R.drawable.atleti,13,AM));
        equipos.add(new Equipo("Bayar de Manich", 150, R.drawable.munich, 10,BM));
        equipos.add(new Equipo("Cholsea",130, R.drawable.chelsea,5,CH));
        equipos.add(new Equipo("Mantester Unido",150, R.drawable.manchester,3,AMU));
        equipos.add(new Equipo("Real Mandril",180, R.drawable.madrid,2,RM));

        jugadoresDisponibles.add(new Jugador("Keylor Navas", "Real Madrid", "Portero", "7000000", 0.1,3.3,0.0,R.drawable.navas));
        jugadoresDisponibles.add(new Jugador("Lucas Perez", "Deportivo", "Centrocampista", "11250000", 0.2,5.5,3.0, R.drawable.lucas));
        jugadoresDisponibles.add(new Jugador("Nolito", "Celta", "Delantero", "15320000", 0.2,5.5,3.0,R.drawable.nolito));
        jugadoresDisponibles.add(new Jugador("Orellana", "Celta", "Centrocampista", "14190000", 0.2,5.5,3.0, R.drawable.orellana));
        jugadoresDisponibles.add(new Jugador("Iago Aspas","Celta","Delantero","11040000",0.2,5.5,3.0,R.drawable.aspas));
        jugadoresDisponibles.add(new Jugador("Cristiano Ronaldo","Real Madrid","Delantero","22910000",0.2,5.5,3.0,R.drawable.cristiano));
        jugadoresDisponibles.add(new Jugador("Benzema","Real Madrid","Delantero","14510000",0.2,5.5,3.0,R.drawable.benzema));
        jugadoresDisponibles.add(new Jugador("Modric","Real Madrid","Centrocampista","14300000",0.2,5.5,3.0,R.drawable.modric));
        jugadoresDisponibles.add(new Jugador("Marcelo","Real Madrid","Defensa","8450000",0.2,5.5,3.0,R.drawable.marcelo));
        jugadoresDisponibles.add(new Jugador("Saúl Berjón","Eibar","Centrocampista","6680000",0.2,5.5,3.0,R.drawable.saul));
        jugadoresDisponibles.add(new Jugador("Daniel Wass","Celta","Centrocampista","6540000",0.2,5.5,3.0,R.drawable.wass));
        jugadoresDisponibles.add(new Jugador("Griezmann","Atlético de Madrid","Delantero","21560000",0.2,5.5,3.0,R.drawable.griezmann));
        jugadoresDisponibles.add(new Jugador("Westermann","Betis","Defensa","5190000",0.2,5.5,3.0,R.drawable.westermann));
        jugadoresDisponibles.add(new Jugador("Jonathan Viera","Las Palmas","Centrocampista","7060000",0.2,5.5,3.0,R.drawable.viera));
        jugadoresDisponibles.add(new Jugador("Borja Bastón","Eibar","Delantero","6800000",0.2,5.5,3.0,R.drawable.defecto));
        jugadoresDisponibles.add(new Jugador("Lora","Sporting","Defensa","4070000",0.2,5.5,3.0,R.drawable.defecto));
        jugadoresDisponibles.add(new Jugador("Luis Suárez","Futbol Club Barcelona","Delantero","17690000",0.2,5.5,3.0,R.drawable.suarez));
        jugadoresDisponibles.add(new Jugador("Augusto Fernández", "Celta", "Centrocampista", "5640000", 0.2,5.5,3.0, R.drawable.augusto));
        jugadoresDisponibles.add(new Jugador("Sergi Roberto","Futbol Club Barcelona","Centrocampista","4420000",0.2,5.5,3.0,R.drawable.sergi));

        AMU.add(new Jugador("Tiago", "Atl.Madrid", "Centrocampista", "5000000", 0.1,3.3,0.0, R.drawable.defecto));
        AMU.add(new Jugador("Beñat","Atl.Bilbao","Centrocampista","2000000",0.2,5.5,3.0,R.drawable.defecto));
        AMU.add(new Jugador("Vitolo","Sevilla","Centrocampista","20000000",0.2,5.5,3.0,R.drawable.defecto));
        AMU.add(new Jugador("Modric","Real Madrid","Centrocampista","80000000",0.1,3.3,0.0,R.drawable.defecto));
        AMU.add(new Jugador("Guaita","Getafe","Portero","2000000",0.2,3.3,0.0,R.drawable.defecto));
        AMU.add(new Jugador("Jimenez","Atl.Madrid","Defensa","3000000",0.4,3.3,0.0,R.drawable.defecto));
        AMU.add(new Jugador("Pepe","Real Madrid","Defensa","7000000",0.1,3.5,0.0,R.drawable.defecto));
        AMU.add(new Jugador("Gaya","Valencia","Defensa","5000000",0.1,3.3,0.6,R.drawable.defecto));
        AMU.add(new Jugador("Juanfran","Atl.Madrid","Defensa","6000000",0.1,3.3,0.0,R.drawable.defecto));
        AMU.add(new Jugador("Adrian", "Villareal", "Delantero", "5000000", 0.1,3.9,0.0, R.drawable.defecto));
        AMU.add(new Jugador("Negredo","Valencia","Delantero","5500000",0.1,3.3,0.0,R.drawable.defecto));
        RM.add(new Jugador("Gabi","Atl.Madrid","Centrocampista","5000000",0.1,3.3,0.4,R.drawable.defecto));
        RM.add(new Jugador("San Jose","Atl.Bilbao","Centrocampista","2000000",0.2,5.5,3.0,R.drawable.defecto));
        RM.add(new Jugador("Reyes","Sevilla","Centrocampista","20000000",0.2,4.5,3.0,R.drawable.defecto));
        RM.add(new Jugador("Kross","Real Madrid","Centrocampista","80000000",1.1,3.3,0.0,R.drawable.defecto));
        RM.add(new Jugador("Diego","Getafe","Portero","2000000",0.1,3.3,0.5,R.drawable.defecto));
        RM.add(new Jugador("Godin","Atl.Madrid","Defensa","3000000",0.1,3.3,0.8,R.drawable.defecto));
        RM.add(new Jugador("Ramos","Real Madrid","Defensa","7000000",0.1,3.3,0.1,R.drawable.defecto));
        RM.add(new Jugador("Mustafi","Valencia","Defensa","5000000",0.1,3.3,0.4,R.drawable.defecto));
        RM.add(new Jugador("Gamez","Atl.Madrid","Defensa","6000000",0.1,3.4,0.0,R.drawable.defecto));
        RM.add(new Jugador("Soldado","Villareal","Delantero","5000000",0.5,3.3,0.0,R.drawable.defecto));
        RM.add(new Jugador("Rodrigo","Valencia","Delantero","5500000",0.1,3.3,0.0,R.drawable.defecto));
        CH.add(new Jugador("Koke","Atl.Madrid","Centrocampista","5000000",0.6,3.3,0.0,R.drawable.defecto));
        CH.add(new Jugador("Diaz","Atl.Bilbao","Centrocampista","2000000",0.2,5.5,3.0,R.drawable.defecto));
        CH.add(new Jugador("Luis","Sevilla","Centrocampista","20000000",0.2,5.5,3.0,R.drawable.defecto));
        CH.add(new Jugador("Vazquez","Real Madrid","Centrocampista","80000000",0.6,3.3,0.00,R.drawable.defecto));
        CH.add(new Jugador("Jose","Getafe","Portero","2000000",0.1,3.3,0.0,R.drawable.defecto));
        CH.add(new Jugador("Savic","Atl.Madrid","Defensa","3000000",0.1,3.3,0.6,R.drawable.defecto));
        CH.add(new Jugador("Varane","Real Madrid","Defensa","7000000",0.1,3.3,0.0,R.drawable.defecto));
        CH.add(new Jugador("Vicent","Valencia","Defensa","5000000",0.1,3.4,0.0,R.drawable.defecto));
        CH.add(new Jugador("Filipe","Atl.Madrid","Defensa","6000000",0.1,3.3,0.0,R.drawable.defecto));
        CH.add(new Jugador("Luis","Villareal","Delantero","5000000",0.1,3.4,0.0,R.drawable.defecto));
        CH.add(new Jugador("Alcacer","Valencia","Delantero","5500000",0.1,3.3,0.0,R.drawable.defecto));
        AM.add(new Jugador("Saul","Atl.Madrid","Centrocampista","5000000",0.2,3.3,0.0,R.drawable.defecto));
        AM.add(new Jugador("Castolo","Atl.Bilbao","Centrocampista","2000000",0.4,5.5,3.0,R.drawable.defecto));
        AM.add(new Jugador("Benatia","Sevilla","Centrocampista","20000000",0.2,5.6,3.0,R.drawable.defecto));
        AM.add(new Jugador("Gonzo","Real Madrid","Centrocampista","80000000",0.1,4.3,0.0,R.drawable.defecto));
        AM.add(new Jugador("Benet","Getafe","Portero","2000000",0.1,3.3,0.0,R.drawable.defecto));
        AM.add(new Jugador("Savs","Atl.Madrid","Defensa","3000000",0.1,3.3,0.5,R.drawable.defecto));
        AM.add(new Jugador("Borja","Real Madrid","Defensa","7000000",0.1,3.3,0.4,R.drawable.defecto));
        AM.add(new Jugador("Abelardo","Valencia","Defensa","5000000",0.1,3.3,0.1,R.drawable.defecto));
        AM.add(new Jugador("Torres","Atl.Madrid","Defensa","6000000",0.1,3.3,0.0,R.drawable.defecto));
        AM.add(new Jugador("Federico","Villareal","Delantero","5000000",0.1,3.4,0.0,R.drawable.defecto));
        AM.add(new Jugador("Falcao","Valencia","Delantero","5500000",0.1,3.3,0.0,R.drawable.defecto));
        BM.add(new Jugador("Thiago","Atl.Madrid","Centrocampista","5000000",0.1,3.4,0.0,R.drawable.defecto));
        BM.add(new Jugador("Gotze","Atl.Bilbao","Centrocampista","2000000",0.2,5.5,3.0,R.drawable.defecto));
        BM.add(new Jugador("Ribery","Sevilla","Centrocampista","20000000",0.2,5.5,3.1,R.drawable.defecto));
        BM.add(new Jugador("Alonso","Real Madrid","Centrocampista","80000000",0.1,3.7,0.0,R.drawable.defecto));
        BM.add(new Jugador("Neuer","Getafe","Portero","2000000",0.1,3.3,0.1,R.drawable.defecto));
        BM.add(new Jugador("Boateng","Atl.Madrid","Defensa","3000000",0.1,1.3,0.0,R.drawable.defecto));
        BM.add(new Jugador("Lahm","Real Madrid","Defensa","7000000",0.1,3.3,0.0,R.drawable.defecto));
        BM.add(new Jugador("Benatia","Valencia","Defensa","5000000",0.1,3.2,0.0,R.drawable.defecto));
        BM.add(new Jugador("Bernat","Atl.Madrid","Defensa","6000000",0.1,3.6,0.0,R.drawable.defecto));
        BM.add(new Jugador("Muller","Villareal","Delantero","5000000",0.1,3.2,0.0,R.drawable.defecto));
        BM.add(new Jugador("Lewandowsky","Valencia","Delantero","5500000",0.4,3.3,0.0,R.drawable.defecto));
    }

    public ArrayList<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
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
    public ArrayList<Jugador> getJugadoresSuplentes() {
        return this.jugadoresSuplentes;
    }
    public void ficharJugador(Jugador player){
        jugadoresDisponibles.remove(player);
        jugadoresFichados.add(player);
        int a = Integer.parseInt(getSaldo());
        int b = Integer.parseInt(player.getValor());
        a = a - b;
        setSaldo(Integer.toString(a));
    }
    public String getSaldo(){return this.saldo;}
    public void setSaldo(String saldo){this.saldo=saldo;}
    public void serSuplente(Jugador player){
        jugadoresFichados.remove(player);
        jugadoresSuplentes.add(player);
    }
    public void serTitular(Jugador player){
        jugadoresSuplentes.remove(player);
        jugadoresFichados.add(player);
    }
    public void venderJugador(Jugador player){
        jugadoresFichados.remove(player);
    }
    public ArrayList<Jugador> getJugadoresDisponibles(){
        return this.jugadoresDisponibles;
    }
    public ArrayList<Noticia>getNoticias(){
        return this.noticias;
    }
    public ArrayList<Equipo>getEquipos(){return  this.equipos;}
    public boolean saldoSuficiente(Jugador player){
        int a = Integer.parseInt(getSaldo());
        int b = Integer.parseInt(player.getValor());
        return ((a-b)>=0);
    }

    public void addUsuarioArray(Usuario user){
        usuarios.add(user);
    }

}
