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

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class fragmentInicio extends Fragment {

    private ListView lvNoticias;
    private ArrayList<Noticia> datos= new ArrayList<Noticia>();
    private AdaptadorNoticias adapter;
    private Button sald;
    private int saldo;
    private View rootView;
    private String user;

    public fragmentInicio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.frame_inicio, container, false);
        lvNoticias = (ListView)rootView.findViewById(R.id.lvNoticias);
        user = getGlobalUsuario();
        obtSaldo();
        obtNoticias();

        return rootView;
    }

    class AdaptadorNoticias extends ArrayAdapter<Noticia> {
        public AdaptadorNoticias(Context context, List<Noticia> datos){
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

    public void obtNoticias(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://tefox.esy.es/noticias.php";

        RequestParams parametros = new RequestParams();


        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    obtNoticiaJSON(new String(responseBody));
                    CargaLista();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public void obtNoticiaJSON(String response){
        try{
            JSONArray jsonArray = new JSONArray(response);
            String titulo;
            String cuerpo;
            String fecha;
            for(int i=0;i<jsonArray.length();i++){
                titulo = jsonArray.getJSONObject(i).getString("titulo");
                cuerpo = jsonArray.getJSONObject(i).getString("cuerpo");
                fecha = jsonArray.getJSONObject(i).getString("fecha");
                datos.add(new Noticia(titulo,cuerpo,fecha));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void CargaLista(){
        adapter = new AdaptadorNoticias(getActivity(),datos);
        lvNoticias.setAdapter(adapter);
    }

    public void obtSaldo(){
        AsyncHttpClient client =new AsyncHttpClient();
        String url="http://tefox.esy.es/saldo.php";

        RequestParams parametros = new RequestParams();
        parametros.put("usuario","\""+user+"\"");
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
        sald = (Button) rootView.findViewById(R.id.floating_button2);
        sald.setText(Integer.toString(saldo));
    }
    public String getGlobalUsuario(){
        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getUsuario();
    }
}




