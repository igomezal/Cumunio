package com.ps.comunio;

import android.app.Dialog;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class fragmentFichajes extends ListFragment {
    /*public class fragmentElegirFichajes extends ListFragment{

    }*/
    ArrayAdapter<Jugador> adapter;

    // Jugador de prueba para añadir
    private Jugador jugadorPrueba = new Jugador("Hola", "No se", "Delantero", "11111111", R.drawable.cristiano);

    private Jugador[] fichajes = {
            new Jugador("F - Keylor Navas","Real Madrid","Portero","7000000", R.drawable.cristiano),
            new Jugador("F - Lucas Perez","Deportivo","Centrocampista","11250000", R.drawable.cristiano),
            new Jugador("F - Nolito","Celta","Delantero","15320000", R.drawable.cristiano),
            new Jugador("F - Orellana","Celta","Centrocampista","14190000", R.drawable.cristiano),
            new Jugador("F - Iago Aspas","Celta","Delantero","11040000", R.drawable.cristiano),
            new Jugador("F - Cristiano Ronaldo","Real Madrid","Delantero","22910000", R.drawable.cristiano),
            new Jugador("F - Benzema","Real Madrid","Delantero","14510000", R.drawable.cristiano),
            new Jugador("F - Modric","Real Madrid","Centrocampista","14300000", R.drawable.cristiano),
            new Jugador("F - Marcelo","Real Madrid","Defensa","8450000", R.drawable.cristiano),
            new Jugador("F - Saúl Berjón","Eibar","Centrocampista","6680000", R.drawable.cristiano),
            new Jugador("F - Daniel Wass","Celta","Centrocampista","6540000", R.drawable.cristiano),
            new Jugador("F - Griezmann","Atlético de Madrid","Delantero","21560000", R.drawable.cristiano)
    };
    private ArrayList <Jugador> fichajesMod = new ArrayList<>(Arrays.asList(fichajes));

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

        adapter = new AdaptadorFichajes(getActivity(), fichajesMod);
        setListAdapter(adapter);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater){
        inflater.inflate(R.menu.menu_fichajes, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.boton_fichar:
                // Metodo para añadir fichajes
                ficharJugador(getView());
                return true;
            //TODO implementar un metodo para borrar fichajes
            /*case R.id.boton_borrar:
                Metodo para borrar fichajes
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
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

            ImageView Imagen = (ImageView) item.findViewById(R.id.ImagenJugador);
            Imagen.setImageResource(fichajesCopia.get(position).getImagen());

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

    private void fichar(Jugador jugadorFichar){

        // Añade un jugador y actualiza la tabla
        fichajesMod.add(jugadorFichar);
        adapter.notifyDataSetChanged();

        // Ponemos un mensaje
        Toast.makeText(getContext(), "Jugador fichado correctamente", Toast.LENGTH_SHORT).show();
    }
    // metodo que maneja el toque del boton de cada jugador
    public void ficharJugador(View view){

        final Dialog dialogFichar = new Dialog(getContext());

        //TODO seguir implementando el alertDialog de fichar

        fichar(jugadorPrueba);
    }
}
