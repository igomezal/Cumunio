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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import cz.msebera.android.httpclient.Header;

/**
 * Created by sergiownd on 25/10/15.
 */
public class FragmentoEquipo extends ListFragment {
    private ArrayList<Equipo> datos =new ArrayList<Equipo>();
    private AdaptadorEquipo adapter;
    private View rootView;
    private Button sald;
    private String user;
    private int saldo;

    public FragmentoEquipo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_equipo,container,false);
        user = getGlobalUsuario();
        obtSaldo();
        obtEquipos();
        return rootView;
    }


    class AdaptadorEquipo extends ArrayAdapter<Equipo>{
        public AdaptadorEquipo(Context context, ArrayList<Equipo> datos){
            super(context,R.layout.listitem_equipo,datos);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_equipo, null);

            TextView Nombre = (TextView) item.findViewById(R.id.NombreEquipo);
            Nombre.setText("Equipo de "+datos.get(position).getNombre());

            TextView Valor = (TextView) item.findViewById(R.id.EqValor);
            Valor.setText("");

            ImageView ImagenEquipo = (ImageView) item.findViewById(R.id.ImagenEquipo);
            ImagenEquipo.setImageResource(datos.get(position).getEqImagen());

            TextView puntos = (TextView)item.findViewById(R.id.tvPtos);
            puntos.setText("Puntos: " + datos.get(position).getPuntos());

            return item;
        }
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
        final int identificador = position;

        Intent intent = new Intent(getContext(), infoEquipo.class);
        intent.putExtra("Equipo", datos.get(identificador).getNombre());
        intent.putExtra("Imagen",datos.get(identificador).getEqImagen());
        intent.putExtra("Puntos",datos.get(identificador).getPuntos());
        intent.putExtra("Valor",datos.get(identificador).getValor());

        startActivity(intent);
    }


    public void obtEquipos(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://tomatodevelopers.com/cumunio/equipos.php";

        RequestParams parametros = new RequestParams();

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    obtEquiposJSON(new String(responseBody));
                    CargaLista();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public void obtEquiposJSON(String response){
        datos.clear();
        try{
            JSONArray jsonArray = new JSONArray(response);
            String nombre;
            int imagen,puntos;

            for(int i=0;i<jsonArray.length();i++){
                nombre = jsonArray.getJSONObject(i).getString("Nombre");
                imagen = convertirRutaEnId(jsonArray.getJSONObject(i).getString("Avatar"));
                puntos = jsonArray.getJSONObject(i).getInt("Puntos");
                datos.add(new Equipo(nombre,imagen,puntos));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private int convertirRutaEnId(String nombre){
        Context context = getActivity().getBaseContext();
        return context.getResources().getIdentifier(nombre, "drawable", context.getPackageName());
    }

    public void CargaLista(){
        adapter = new AdaptadorEquipo(getActivity(),datos);
        Collections.sort(datos);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void obtSaldo(){
        AsyncHttpClient client =new AsyncHttpClient();
        String url="http://tomatodevelopers.com/cumunio/saldo.php";

        RequestParams parametros = new RequestParams();
        parametros.put("usuario", user);
        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    obtSaldoJson(new String(responseBody));
                    botonSaldo();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
    public void obtSaldoJson(String response){
        saldo = 0;
        try{
            JSONArray jsonArray = new JSONArray(response);
            for(int i=0;i<jsonArray.length();i++){
                saldo = jsonArray.getJSONObject(i).getInt("Saldo");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void botonSaldo(){
        sald = (Button) rootView.findViewById(R.id.floating_button1);
        sald.setText(Integer.toString(saldo));
    }

    public String getGlobalUsuario(){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getUsuario();
    }

}
