package com.ps.comunio;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment1 extends ListFragment {

    private Jugador[] datos={
            new Jugador("Keylor Navas","Real Madrid","Portero","7000000"),
            new Jugador("Lucas Perez","Deportivo","Centrocampista","11250000"),
            new Jugador("Nolito","Celta","Delantero","15320000"),
            new Jugador("Orellana","Celta","Centrocampista","14190000"),
            new Jugador("Iago Aspas","Celta","Delantero","11040000"),
            new Jugador("Cristiano Ronaldo","Real Madrid","Delantero","22910000"),
            new Jugador("Benzema","Real Madrid","Delantero","14510000"),
            new Jugador("Modric","Real Madrid","Centrocampista","14300000"),
            new Jugador("Marcelo","Real Madrid","Defensa","8450000"),
            new Jugador("Saúl Berjón","Eibar","Centrocampista","6680000"),
            new Jugador("Daniel Wass","Celta","Centrocampista","6540000"),
            new Jugador("Griezmann","Atlético de Madrid","Delantero","21560000"),
            new Jugador("Westermann","Betis","Defensa","5190000"),
            new Jugador("Jonathan Viera","Las Palmas","Centrocampista","7060000"),
            new Jugador("Borja Bastón","Eibar","Delantero","6800000"),
            new Jugador("Lora","Sporting","Defensa","4070000"),
            new Jugador("Luis Suárez","Futbol Club Barcelona","Delantero","17690000"),
            new Jugador("Augusto Fernández","Celta","Centrocampista","5640000"),
            new Jugador("Sergi Roberto","Futbol Club Barcelona","Centrocampista","4420000"),
            new Jugador("David Simón","Las Palmas","Defensa","3910000"),
            new Jugador("Aduriz","Athletic Bilbao","Delantero","12420000"),
            new Jugador("Rubén Castro","Betis","Delantero","9500000")
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

            return item;
        }
    }
}