package com.ps.comunio;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import cz.msebera.android.httpclient.Header;

public class infoEquipo extends AppCompatActivity {

    private ArrayList<Jugador> datos= new ArrayList<Jugador>();
    private String dueño;
    private int imagen,puntos,valor;
    private ListView lvEquipo;
    private TextView tvNombre,tvValor,tvPuntos;
    private ImageView escudo;
    private AdaptadorJugador adapter;
    private int saldo;
    private Button sald;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_equipo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = getGlobalUsuario();

        dueño = getIntent().getStringExtra("Equipo");
        imagen = getIntent().getIntExtra("Imagen", 0);
        puntos = getIntent().getIntExtra("Puntos",0);
        valor = getIntent().getIntExtra("Valor",0);

        lvEquipo=(ListView)findViewById(R.id.lvEquipo);
        tvNombre=(TextView)findViewById(R.id.tvEquipo);
        tvValor=(TextView)findViewById(R.id.tvValoracion);
        tvPuntos = (TextView)findViewById(R.id.tvPuntos);
        escudo = (ImageView)findViewById(R.id.imageEscudo);

        tvNombre.setText("Equipo de "+dueño);
        tvValor.setText("Valor: "+valor);
        tvPuntos.setText("Puntos: " + puntos);
        escudo.setImageResource(imagen);
        obtSaldo();
        obtJugadores();

        Button sald = (Button) findViewById(R.id.floating_button19);
        sald.setText(getSald());
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

    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        return globalVariable.getSaldo();
    }

    public void obtJugadores(){
        AsyncHttpClient client = new AsyncHttpClient();
        String url="http://tomatodevelopers.com/cumunio/jugador.php";

        RequestParams parametros = new RequestParams();

        //Sustituir por el usuario
        parametros.put("dueño", dueño);
        parametros.put("titular", "Titular");

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
        Context context = getBaseContext();
        return context.getResources().getIdentifier(nombre, "drawable", context.getPackageName());
    }

    public void CargaLista(){
        adapter = new AdaptadorJugador(this.getBaseContext(),datos);
        lvEquipo.setAdapter(adapter);
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
        sald = (Button) findViewById(R.id.floating_button19);
        sald.setText(Integer.toString(saldo));
    }

    public String getGlobalUsuario(){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        return globalVariable.getUsuario();
    }
}
