package com.ps.comunio;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Fragment1 extends ListFragment {

    private Jugador[] datos={
            new Jugador("Keylor Navas","Real Madrid","Portero","7000000", R.drawable.navas),
            new Jugador("Lucas Perez","Deportivo","Centrocampista","11250000", R.drawable.lucas),
            new Jugador("Nolito","Celta","Delantero","15320000", R.drawable.nolito),
            new Jugador("Orellana","Celta","Centrocampista","14190000", R.drawable.orellana),
            new Jugador("Cristiano Ronaldo","Real Madrid","Delantero","22910000", R.drawable.cristiano),
            new Jugador("Benzema","Real Madrid","Delantero","14510000", R.drawable.benzema),
            new Jugador("Modric","Real Madrid","Centrocampista","14300000", R.drawable.modric),
            new Jugador("Marcelo","Real Madrid","Defensa","8450000", R.drawable.marcelo),
            new Jugador("Saúl Berjón","Eibar","Centrocampista","6680000",R.drawable.saul),
            new Jugador("Daniel Wass","Celta","Centrocampista","6540000", R.drawable.cristiano),
            new Jugador("Griezmann","Atlético de Madrid","Delantero","21560000",R.drawable.wass),
            new Jugador("Westermann","Betis","Defensa","5190000", R.drawable.westermann),
            new Jugador("Jonathan Viera","Las Palmas","Centrocampista","7060000", R.drawable.viera),
            new Jugador("Norja Bastón","Eibar","Delantero","6800000", R.drawable.defecto),
            new Jugador("Lora","Sporting","Defensa","4070000", R.drawable.defecto),
            new Jugador("Luis Suárez","Futbol Club Barcelona","Delantero","17690000", R.drawable.suarez),
            new Jugador("Augusto Fernández","Celta","Centrocampista","5640000", R.drawable.augusto),
            new Jugador("Sergi Roberto","Futbol Club Barcelona","Centrocampista","4420000", R.drawable.sergi),
            new Jugador("David Simón","Las Palmas","Defensa","3910000", R.drawable.simon),
            new Jugador("Aduriz","Athletic Bilbao","Delantero","12420000", R.drawable.aduriz),
            new Jugador("Rubén Castro","Betis","Delantero","9500000", R.drawable.castro)

    };

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment1,container,false);
        AdaptadorJugador adapter = new AdaptadorJugador(getActivity(),datos);
        setListAdapter(adapter);

        return rootView;
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        Intent datoJugador = new Intent(getActivity(),DatosJugador.class);
        datoJugador.putExtra("dat",datos[position]);
        startActivity(datoJugador);
    }



    class AdaptadorJugador extends ArrayAdapter<Jugador>{
        public AdaptadorJugador(Context context, Jugador[] datos){
            super(context,R.layout.listitem_jugador,datos);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_jugador, null);

            TextView Nombre = (TextView) item.findViewById(R.id.NombreJugador);
            Nombre.setText(datos[position].getNombre());

            ImageView Imagen = (ImageView) item.findViewById(R.id.ImagenJugador);
            Imagen.setImageResource(datos[position].getImagen());

            return item;
        }
    }
}