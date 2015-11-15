package com.ps.comunio;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import java.util.ArrayList;

public class Fragment1 extends ListFragment {

    private ArrayList<Jugador> datos= new ArrayList<Jugador>();
    AdaptadorJugador adapter;
    View rootView;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        datos = getJugadores();
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment1,container,false);
        Button sald = (Button) rootView.findViewById(R.id.floating_button);
        sald.setText(getSald());
        adapter = new AdaptadorJugador(getActivity(),datos);
        setListAdapter(adapter);
        return rootView;
    }



    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        final int identificador = position;
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Fichar");
        builder.setMessage("¿Desea fichar a " + datos.get(position).getNombre() + " por " + datos.get(position).getValor() + "?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (puedoFichar(datos.get(identificador))) {
                    Toast.makeText(getActivity(), "Fichado " + datos.get(identificador).getNombre(), Toast.LENGTH_LONG).show();
                    fichar(datos.get(identificador));
                    datos = getJugadores();
                    Button sald = (Button) rootView.findViewById(R.id.floating_button);
                    sald.setText(getSald());
                } else {
                    Toast.makeText(getActivity(), "No tienes saldo suficiente para fichar a " + datos.get(identificador).getNombre(), Toast.LENGTH_LONG).show();
                }
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", null);
        builder.create().show();
        adapter.notifyDataSetChanged();
    }




    class AdaptadorJugador extends ArrayAdapter<Jugador>{
        public AdaptadorJugador(Context context, ArrayList<Jugador> datos){
            super(context,R.layout.listitem_jugador,datos);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_jugador, null);
            ImageView Imagen = (ImageView) item.findViewById(R.id.imageView);
            TextView Nombre = (TextView) item.findViewById(R.id.NombreJugador);
            TextView Equipo = (TextView) item.findViewById(R.id.tVEquipo);
            TextView Valoracion = (TextView) item.findViewById(R.id.tvValoracion);
            Nombre.setText(datos.get(position).getNombre());
            Equipo.setText(datos.get(position).getEquipo());
            Valoracion.setText("Valor: " + datos.get(position).getValoracion());
            Imagen.setImageResource(datos.get(position).getImagen());
            return item;
        }
    }
    public void fichar(Jugador player){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        globalVariable.ficharJugador(player);
    }
    public ArrayList<Jugador> getJugadores(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getJugadoresDisponibles();
    }
    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getSaldo();
    }
    public boolean puedoFichar(Jugador player){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.saldoSuficiente(player);
    }
}