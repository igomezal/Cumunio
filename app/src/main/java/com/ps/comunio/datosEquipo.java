package com.ps.comunio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by sergiownd on 15/11/15.
 */
public class datosEquipo extends AppCompatActivity{
    private ArrayList<Jugador> datos;
    private ListView listado;
    //public final static String EXTRA_MESSAGE = "com.ps.comunio.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista_jugadores_equipo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.datos = (ArrayList<Jugador>) getIntent().getExtras().getSerializable("datoEquipo");
        listado = (ListView) findViewById(R.id.listaJugadoresE);
        adaptadorListaEquipos adapter = new adaptadorListaEquipos(this,datos);
        listado.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class adaptadorListaEquipos extends ArrayAdapter<Jugador>{
        public adaptadorListaEquipos (Context context, ArrayList<Jugador> datos){
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
            Valoracion.setText(datos.get(position).getValoracion().toString());
            Imagen.setImageResource(datos.get(position).getImagen());
            return item;
        }
    }
}
