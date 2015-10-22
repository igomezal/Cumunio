package com.ps.comunio;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class fragmentFichajes extends ListFragment {

    // Jugador de prueba para añadir
    private Jugador jugadorPrueba = new Jugador("Hola", "No se", "Delantero", "11111111");

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
    ArrayList <Jugador> fichajesMod = new ArrayList<>(Arrays.asList(fichajes));

    // TODO seguir con el metodo añadir fichaje
    // Cabecera que usaremos: (ArrayList<Jugador> fichajes, String nombre, String equipo, String posicion, String valor)
    // Cabecera de prueba:
    public ArrayList<Jugador> aniadirFichaje(Jugador nuevoFichaje){
        //Jugador nuevoFichaje = new Jugador(nombre, equipo, posicion, valor);
        fichajesMod.add(nuevoFichaje);

        Toast added = Toast.makeText(getActivity(), "Añadido", Toast.LENGTH_SHORT);
        added.show();

        return fichajesMod;
    }

    // TODO implementar el metodo borrar fichaje

    public fragmentFichajes() {
        // Required empty public constructor
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_fichajes, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    // TODO implementar el click del boton (+)
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        // Manejamos el click del usuario al boton (+)
        switch (item.getItemId()){
            case R.id.action_aniadirFichaje:
                aniadirFichaje(jugadorPrueba);
                return true;
            /*case R.id.action_settings:
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    class AdaptadorFichajes extends ArrayAdapter<Jugador>{

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

            // TODO arreglarlo
            //notifyDataSetChanged();

            return item;
        }
    }


}
