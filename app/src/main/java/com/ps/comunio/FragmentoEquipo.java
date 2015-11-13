package com.ps.comunio;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sergiownd on 25/10/15.
 */
public class FragmentoEquipo extends ListFragment {
    private Equipo[] datos={
        new Equipo("Mantester Unido",150, R.drawable.manchester),
        new Equipo("Real Mandril",180, R.drawable.madrid),
        new Equipo("Cholsea",130, R.drawable.chelsea),
        new Equipo("Armético de Matriz",150, R.drawable.atleti),
        new Equipo("Bayar de Manich",150,R.drawable.munich),
    };

    public FragmentoEquipo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_equipo,container,false);
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

            return item;
        }
    }
}
