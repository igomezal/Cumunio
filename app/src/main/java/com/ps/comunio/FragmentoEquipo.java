package com.ps.comunio;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sergiownd on 25/10/15.
 */
public class FragmentoEquipo extends ListFragment {
    private ArrayList<Jugador> AMU = new ArrayList<Jugador>();
    private ArrayList<Jugador> RM = new ArrayList<Jugador>();
    private ArrayList<Jugador> CH = new ArrayList<Jugador>();
    private ArrayList<Jugador> AM = new ArrayList<Jugador>();
    private ArrayList<Jugador> BM = new ArrayList<Jugador>();

    private Equipo[] datos={
            new Equipo("Mantester Unido",150, R.drawable.manchester,AMU),
            new Equipo("Real Mandril",180, R.drawable.madrid,RM),
            new Equipo("Cholsea",130, R.drawable.chelsea,CH),
            new Equipo("Armético de Matriz",150, R.drawable.atleti,AM),
            new Equipo("Bayar de Manich",150,R.drawable.munich,BM),
    };


    public FragmentoEquipo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this
        AMU.add(new Jugador("Tiago", "Atl.Madrid", "Centrocampista", "5000000", 19.0, R.drawable.defecto));
        AMU.add(new Jugador("Beñat","Atl.Bilbao","Centrocampista","2000000",9.0,R.drawable.defecto));
        AMU.add(new Jugador("Vitolo","Sevilla","Centrocampista","20000000",20.0,R.drawable.defecto));
        AMU.add(new Jugador("Modric","Real Madrid","Centrocampista","80000000",50.0,R.drawable.defecto));
        AMU.add(new Jugador("Guaita","Getafe","Portero","2000000",13.0,R.drawable.defecto));
        AMU.add(new Jugador("Jimenez","Atl.Madrid","Defensa","3000000",16.0,R.drawable.defecto));
        AMU.add(new Jugador("Pepe","Real Madrid","Defensa","7000000",19.0,R.drawable.defecto));
        AMU.add(new Jugador("Gaya","Valencia","Defensa","5000000",49.0,R.drawable.defecto));
        AMU.add(new Jugador("Juanfran","Atl.Madrid","Defensa","6000000",49.4,R.drawable.defecto));
        AMU.add(new Jugador("Adrian", "Villareal", "Delantero", "5000000", 29.6, R.drawable.defecto));
        AMU.add(new Jugador("Negredo","Valencia","Delantero","5500000",9.0,R.drawable.defecto));
        RM.add(new Jugador("Gabi","Atl.Madrid","Centrocampista","5000000",19.0,R.drawable.defecto));
        RM.add(new Jugador("San Jose","Atl.Bilbao","Centrocampista","2000000",9.0,R.drawable.defecto));
        RM.add(new Jugador("Reyes","Sevilla","Centrocampista","20000000",20.0,R.drawable.defecto));
        RM.add(new Jugador("Kross","Real Madrid","Centrocampista","80000000",50.0,R.drawable.defecto));
        RM.add(new Jugador("Diego","Getafe","Portero","2000000",13.0,R.drawable.defecto));
        RM.add(new Jugador("Godin","Atl.Madrid","Defensa","3000000",16.0,R.drawable.defecto));
        RM.add(new Jugador("Ramos","Real Madrid","Defensa","7000000",19.0,R.drawable.defecto));
        RM.add(new Jugador("Mustafi","Valencia","Defensa","5000000",49.0,R.drawable.defecto));
        RM.add(new Jugador("Gamez","Atl.Madrid","Defensa","6000000",49.0,R.drawable.defecto));
        RM.add(new Jugador("Soldado","Villareal","Delantero","5000000",29.0,R.drawable.defecto));
        RM.add(new Jugador("Rodrigo","Valencia","Delantero","5500000",9.0,R.drawable.defecto));
        CH.add(new Jugador("Koke","Atl.Madrid","Centrocampista","5000000",19.0,R.drawable.defecto));
        CH.add(new Jugador("Diaz","Atl.Bilbao","Centrocampista","2000000",9.0,R.drawable.defecto));
        CH.add(new Jugador("Luis","Sevilla","Centrocampista","20000000",20.0,R.drawable.defecto));
        CH.add(new Jugador("Vazquez","Real Madrid","Centrocampista","80000000",50.0,R.drawable.defecto));
        CH.add(new Jugador("Jose","Getafe","Portero","2000000",13.0,R.drawable.defecto));
        CH.add(new Jugador("Savic","Atl.Madrid","Defensa","3000000",16.0,R.drawable.defecto));
        CH.add(new Jugador("Varane","Real Madrid","Defensa","7000000",19.0,R.drawable.defecto));
        CH.add(new Jugador("Vicent","Valencia","Defensa","5000000",49.0,R.drawable.defecto));
        CH.add(new Jugador("Filipe","Atl.Madrid","Defensa","6000000",49.0,R.drawable.defecto));
        CH.add(new Jugador("Luis","Villareal","Delantero","5000000",29.0,R.drawable.defecto));
        CH.add(new Jugador("Alcacer","Valencia","Delantero","5500000",9.0,R.drawable.defecto));
        AM.add(new Jugador("Saul","Atl.Madrid","Centrocampista","5000000",19.5,R.drawable.defecto));
        AM.add(new Jugador("Castolo","Atl.Bilbao","Centrocampista","2000000",9.3,R.drawable.defecto));
        AM.add(new Jugador("Benatia","Sevilla","Centrocampista","20000000",20.2,R.drawable.defecto));
        AM.add(new Jugador("Gonzo","Real Madrid","Centrocampista","80000000",50.7,R.drawable.defecto));
        AM.add(new Jugador("Benet","Getafe","Portero","2000000",13.9,R.drawable.defecto));
        AM.add(new Jugador("Savs","Atl.Madrid","Defensa","3000000",16.0,R.drawable.defecto));
        AM.add(new Jugador("Borja","Real Madrid","Defensa","7000000",19.1,R.drawable.defecto));
        AM.add(new Jugador("Abelardo","Valencia","Defensa","5000000",49.4,R.drawable.defecto));
        AM.add(new Jugador("Torres","Atl.Madrid","Defensa","6000000",49.6,R.drawable.defecto));
        AM.add(new Jugador("Federico","Villareal","Delantero","5000000",29.7,R.drawable.defecto));
        AM.add(new Jugador("Falcao","Valencia","Delantero","5500000",9.7,R.drawable.defecto));
        BM.add(new Jugador("Thiago","Atl.Madrid","Centrocampista","5000000",19.1,R.drawable.defecto));
        BM.add(new Jugador("Gotze","Atl.Bilbao","Centrocampista","2000000",9.4,R.drawable.defecto));
        BM.add(new Jugador("Ribery","Sevilla","Centrocampista","20000000",20.7,R.drawable.defecto));
        BM.add(new Jugador("Alonso","Real Madrid","Centrocampista","80000000",50.9,R.drawable.defecto));
        BM.add(new Jugador("Neuer","Getafe","Portero","2000000",13.0,R.drawable.defecto));
        BM.add(new Jugador("Boateng","Atl.Madrid","Defensa","3000000",16.7,R.drawable.defecto));
        BM.add(new Jugador("Lahm","Real Madrid","Defensa","7000000",19.9,R.drawable.defecto));
        BM.add(new Jugador("Benatia","Valencia","Defensa","5000000",49.6,R.drawable.defecto));
        BM.add(new Jugador("Bernat","Atl.Madrid","Defensa","6000000",49.4,R.drawable.defecto));
        BM.add(new Jugador("Muller","Villareal","Delantero","5000000",29.7,R.drawable.defecto));
        BM.add(new Jugador("Lewandowsky","Valencia","Delantero","5500000",9.6,R.drawable.defecto));

        View rootView = inflater.inflate(R.layout.fragment_equipo,container,false);
        Button sald = (Button) rootView.findViewById(R.id.floating_button1);
        sald.setText(getSald());
        AdaptadorEquipo adapter = new AdaptadorEquipo(getActivity(),datos);
        setListAdapter(adapter);

        return rootView;
    }

    public void onListItemClick (ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);
                Intent intent = new Intent(this.getContext(),datosEquipo.class);
                intent.putExtra("Nombre",datos[position].getNombre());
                intent.putExtra("datoEquipo",datos[position].getJugadores());
               startActivity(intent);
    }
    class AdaptadorEquipo extends ArrayAdapter<Equipo>{
        public AdaptadorEquipo(Context context, Equipo[] datos){
            super(context,R.layout.listitem_equipo,datos);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_equipo, null);

            TextView Nombre = (TextView) item.findViewById(R.id.NombreEquipo);
            Nombre.setText(datos[position].getNombre());

            TextView Valor = (TextView) item.findViewById(R.id.EqValor);
            Valor.setText("Valor: " + datos[position].getValor() + " millones.");

            ImageView ImagenEquipo = (ImageView) item.findViewById(R.id.ImagenEquipo);
            ImagenEquipo.setImageResource(datos[position].getEqImagen());

            return item;
        }
    }
    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getSaldo();
    }
}
