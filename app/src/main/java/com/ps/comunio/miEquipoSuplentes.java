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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class miEquipoSuplentes extends ListFragment {

    private ArrayList<Jugador> datos= new ArrayList<Jugador>();
    AdaptadorJugador adapter;
    private View rootView;
    private String user;
    private Button sald;
    private int saldo;

    public miEquipoSuplentes() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_fragment1,container,false);
        user = getGlobalUsuario();
        obtSaldo();
        obtJugadores();
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
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(getContext());
                        builder1.setTitle("Vender Jugador");
                        builder1.setMessage("¿Desea vender el jugador " + datos.get(identificador).getNombre() + " por " + datos.get(identificador).getValor()+"?");
                        builder1.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), "Ha vendido a " + datos.get(identificador).getNombre() + ".", Toast.LENGTH_LONG).show();
                                venta(datos.get(identificador).getNombre());
                                vender(datos.get(identificador));
                                obtJugadores();
                                obtSaldo();
                                adapter.notifyDataSetChanged();
                            }
                        });
                        builder1.setNegativeButton("No", null);
                        builder1.create().show();
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        AlertDialog.Builder builder2 = new AlertDialog.Builder(getContext());
                        builder2.setTitle("Hacer Titular");
                        builder2.setMessage("¿Desea hacer titular a " + datos.get(identificador).getNombre() + "?");
                        builder2.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getActivity(), datos.get(identificador).getNombre() + " ahora es titular.", Toast.LENGTH_LONG).show();
                                hacerTitular(datos.get(identificador));
                                obtJugadores();
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
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://cumunio.esy.es/fichar.php";
        RequestParams parametros = new RequestParams();

        parametros.put("user", "Nadie");
        parametros.put("nombre", player.getNombre());

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    public void hacerTitular(Jugador player){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://cumunio.esy.es/titular.php";
        RequestParams parametros = new RequestParams();

        parametros.put("titular", "Titular");
        parametros.put("nombre", player.getNombre());

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
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
            Valoracion.setText("Puntos:" + datos.get(position).getValoracion());

            return item;
        }
    }





    public void obtJugadores(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://cumunio.esy.es/jugador.php";

        RequestParams parametros = new RequestParams();

        //Sustituir por el usuario
        parametros.put("dueño", user);
        parametros.put("titular", "Suplente");

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    obtJugadoresJSON(new String(responseBody));
                    CargaLista();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public void obtJugadoresJSON(String response){
        datos.clear();
        try{
            JSONArray jsonArray = new JSONArray(response);
            String nombre,equipo,pos,valor;
            int puntos,imagen;

            for(int i=0;i<jsonArray.length();i++){
                nombre = jsonArray.getJSONObject(i).getString("Nombre");
                equipo = jsonArray.getJSONObject(i).getString("Equipo");
                pos = jsonArray.getJSONObject(i).getString("Posicion");
                valor = jsonArray.getJSONObject(i).getString("Coste");
                puntos = jsonArray.getJSONObject(i).getInt("Puntos");
                imagen = convertirRutaEnId(jsonArray.getJSONObject(i).getString("Imagen"));
                datos.add(new Jugador(nombre,equipo,pos,valor,puntos,imagen));
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
        adapter = new AdaptadorJugador(getActivity(),datos);
        setListAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
    public String getGlobalUsuario(){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getUsuario();
    }

    public void obtSaldo(){
        AsyncHttpClient client =new AsyncHttpClient();
        String url="http://cumunio.esy.es/saldo.php";

        RequestParams parametros = new RequestParams();
        parametros.put("usuario",user);
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
        sald = (Button) rootView.findViewById(R.id.floating_button);
        sald.setText(Integer.toString(saldo));
    }

    public void venta(String jugador){
        AsyncHttpClient client =new AsyncHttpClient();
        String url="http://cumunio.esy.es/venta.php";

        RequestParams parametros = new RequestParams();
        parametros.put("usuario",user);
        parametros.put("jugador",jugador);

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {

                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

}
