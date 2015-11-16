package com.ps.comunio;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by sergiownd on 25/10/15.
 */
public class FragmentoEquipo extends ListFragment {
    private Equipo[] datos={
        new Equipo("Mantester Unido",150, R.drawable.manchester,3),
        new Equipo("Real Mandril",180, R.drawable.madrid,2),
        new Equipo("Cholsea",130, R.drawable.chelsea,5),
        new Equipo("Armético de Matriz",150, R.drawable.atleti,13),
        new Equipo("Bayar de Manich",150,R.drawable.munich,10),
    };

    public FragmentoEquipo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_equipo,container,false);
        Button sald = (Button) rootView.findViewById(R.id.floating_button1);
        sald.setText(getSald());
        Arrays.sort(datos);
        AdaptadorEquipo adapter = new AdaptadorEquipo(getActivity(),datos);
        setListAdapter(adapter);

        return rootView;
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

            TextView puntos = (TextView)item.findViewById(R.id.tvPtos);
            puntos.setText("Puntos: "+datos[position].getPuntos());

            return item;
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        final int identificador = position;
        Equipo eSelect=datos[position];
        Intent intent = new Intent(getContext(), infoEquipo.class);
        intent.putExtra("position", Integer.toString(position));
        startActivity(intent);
    }
    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getSaldo();
    }
}
