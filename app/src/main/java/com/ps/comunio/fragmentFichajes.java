package com.ps.comunio;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class fragmentFichajes extends ListFragment {

    private Jugador[] fichajes = {
            new Jugador("F - Keylor Navas","Real Madrid","Portero","7000000"),
            new Jugador("F - Lucas Perez","Deportivo","Centrocampista","11250000"),
            new Jugador("F - Nolito","Celta","Delantero","15320000"),
            new Jugador("F - Orellana","Celta","Centrocampista","14190000"),
            new Jugador("F - Iago Aspas","Celta","Delantero","11040000"),
            new Jugador("F - Cristiano Ronaldo","Real Madrid","Delantero","22910000"),
            new Jugador("F - Benzema","Real Madrid","Delantero","14510000"),
            new Jugador("F - Modric","Real Madrid","Centrocampista","14300000"),
            new Jugador("F - Marcelo","Real Madrid","Defensa","8450000"),
            new Jugador("F - Saúl Berjón","Eibar","Centrocampista","6680000"),
            new Jugador("F - Daniel Wass","Celta","Centrocampista","6540000"),
            new Jugador("F - Griezmann","Atlético de Madrid","Delantero","21560000")
    };
    private ArrayList <Jugador> fichajesMod = new ArrayList<>(Arrays.asList(fichajes));

    // TODO implementar el metodo borrar fichaje

    public fragmentFichajes() {
        // Required empty public constructor
    }
    
    // TODO seguir con el metodo añadir fichaje
    // Cabecera que usaremos: (ArrayList<Jugador> fichajes, String nombre, String equipo, String posicion, String valor)
    // Cabecera de prueba:
    public void aniadirFichaje(Jugador nuevoFichaje){
        //Jugador nuevoFichaje = new Jugador(nombre, equipo, posicion, valor);
        fichajesMod.add(nuevoFichaje);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fichajes, container, false);

        AdaptadorFichajes adapter = new AdaptadorFichajes(getActivity(), fichajesMod);
        setListAdapter(adapter);

        return rootView;
    }

    public static class AdaptadorFichajes extends ArrayAdapter<Jugador>{

        ArrayList<Jugador> fichajesCopia;
        public AdaptadorFichajes(Context context, ArrayList<Jugador> fichajesMod){
            super(context, R.layout.listitem_jugador, fichajesMod);
            this.fichajesCopia = fichajesMod;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_jugador, null);

            TextView Nombre = (TextView)item.findViewById(R.id.NombreJugador);
            Nombre.setText(fichajesCopia.get(position).getNombre());

            notifyDataSetChanged();

            return item;
        }
    }

    public ArrayList<Jugador> getFichajesMod(){
        return fichajesMod;
    }

    public void setFichajesMod(ArrayList<Jugador> fichajesMod){
        this.fichajesMod = fichajesMod;
    }
}
