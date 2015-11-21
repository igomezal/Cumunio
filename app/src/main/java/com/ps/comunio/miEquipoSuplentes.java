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


public class miEquipoSuplentes extends ListFragment {

    private ArrayList<Jugador> datos= new ArrayList<Jugador>();
    private AdaptadorJugador adapter;
    private View rootView;


    public miEquipoSuplentes() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        datos = getSuplentes();

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
        final String[] items = {"Vender","Hacer Titular"};
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Gestión de jugador").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                switch (item) {
                    case 0:
                        //Metodo vender
                        double c = Integer.parseInt(datos.get(identificador).getValor()) * 0.95;
                        int valorV = (int) c;
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                        builder1.setTitle("Vender Jugador");
                        builder1.setMessage("¿Desea vender el jugador " + datos.get(identificador).getNombre() + " por " + valorV + "?");
                        builder1.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "Ha vendido a " + datos.get(identificador).getNombre() + ".", Toast.LENGTH_LONG).show();
                                vender(datos.get(identificador));
                                datos = getSuplentes();
                                Button sald = (Button) rootView.findViewById(R.id.floating_button);
                                sald.setText(getSald());
                                adapter.notifyDataSetChanged();
                            }
                        });
                        builder1.setNegativeButton("No", null);
                        builder1.create().show();
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        //Metodo Suplente
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                        builder2.setTitle("Hacer Titular");
                        builder2.setMessage("¿Desea hacer titular a " + datos.get(identificador).getNombre() + "?");
                        builder2.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), datos.get(identificador).getNombre() + " ahora es titular. ", Toast.LENGTH_LONG).show();
                                hacerTitular(datos.get(identificador));
                                datos = getSuplentes();
                                adapter.notifyDataSetChanged();
                            }
                        });
                        builder2.setNegativeButton("No", null);
                        builder2.create().show();
                        adapter.notifyDataSetChanged();
                        break;
                }
            }
        });
        builder.create().show();
        adapter.notifyDataSetChanged();
    }

    public void vender(Jugador player){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplication();
        globalVariable.venderJugadorSuplente(player);
    }

    public void hacerTitular(Jugador player){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        globalVariable.serTitular(player);
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
            Imagen.setImageResource(datos.get(position).getImagen());
            Valoracion.setText("Valor:" + datos.get(position).getValoracion());

            return item;
        }
    }

    public ArrayList<Jugador> getSuplentes(){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        return globalVariable.getJugadoresSuplentes();
    }
    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getSaldo();
    }
}
