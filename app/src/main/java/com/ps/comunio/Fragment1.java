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
            new Jugador("Keylor Navas","Real Madrid","Portero","7000000",0.1),
            new Jugador("Lucas Perez","Deportivo","Centrocampista","11250000",0.2),
            new Jugador("Nolito","Celta","Delantero","15320000",23.2),
            new Jugador("Orellana","Celta","Centrocampista","14190000",21.2),
            new Jugador("Iago Aspas","Celta","Delantero","11040000",23.1),
            new Jugador("Cristiano Ronaldo","Real Madrid","Delantero","22910000",1.1),
            new Jugador("Benzema","Real Madrid","Delantero","14510000",1.4),
            new Jugador("Modric","Real Madrid","Centrocampista","14300000",3.1),
            new Jugador("Marcelo","Real Madrid","Defensa","8450000",2.3),
            new Jugador("Saúl Berjón","Eibar","Centrocampista","6680000",7.8),
            new Jugador("Daniel Wass","Celta","Centrocampista","6540000",8.9),
            new Jugador("Griezmann","Atlético de Madrid","Delantero","21560000",6.7),
            new Jugador("Westermann","Betis","Defensa","5190000",6.7),
            new Jugador("Jonathan Viera","Las Palmas","Centrocampista","7060000",6.7),
            new Jugador("Borja Bastón","Eibar","Delantero","6800000",7.7),
            new Jugador("Lora","Sporting","Defensa","4070000",8.8),
            new Jugador("Luis Suárez","Futbol Club Barcelona","Delantero","17690000",9.9),
            new Jugador("Augusto Fernández","Celta","Centrocampista","5640000",4.7),
            new Jugador("Sergi Roberto","Futbol Club Barcelona","Centrocampista","4420000",8.8),
            new Jugador("David Simón","Las Palmas","Defensa","3910000",9.9),
            new Jugador("Aduriz","Athletic Bilbao","Delantero","12420000",5.5),
            new Jugador("Rubén Castro","Betis","Delantero","9500000",9.9)
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
            TextView Equipo = (TextView) item.findViewById(R.id.tVEquipo);
            TextView Valoracion = (TextView) item.findViewById(R.id.tvValoracion);
            Nombre.setText(datos[position].getNombre());
            Equipo.setText(datos[position].getEquipo());
            Valoracion.setText(datos[position].getValoracion().toString());


            return item;
        }
    }
}