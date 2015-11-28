package com.ps.comunio;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class fragmentInicio extends Fragment {

    private ListView lvNoticias;
    private ArrayList<Noticia> datos= new ArrayList<Noticia>();
    AdaptadorNoticias adapter;
    public fragmentInicio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.frame_inicio, container, false);
        Button sald = (Button) rootView.findViewById(R.id.floating_button2);
        sald.setText(getSald());
        datos = getNoticias();
        lvNoticias = (ListView)rootView.findViewById(R.id.lvNoticias);
        adapter = new AdaptadorNoticias(getActivity(),datos);
        lvNoticias.setAdapter(adapter);
        return rootView;
    }

    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getSaldo();
    }
    class AdaptadorNoticias extends ArrayAdapter<Noticia> {
        public AdaptadorNoticias(Context context, ArrayList<Noticia> datos){
            super(context,R.layout.listitem_noticia,datos);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_noticia, null);

            TextView cabecera = (TextView) item.findViewById(R.id.tvCabecera);
            TextView fecha = (TextView) item.findViewById(R.id.tvFecha);
            TextView contenido = (TextView) item.findViewById(R.id.tvContenido);

            cabecera.setText(datos.get(position).getTitular());
            fecha.setText(datos.get(position).getFecha());
            contenido.setText(datos.get(position).getCuerpo());

            return item;
        }
    }
    public ArrayList<Noticia> getNoticias(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getNoticias();
    }
}




