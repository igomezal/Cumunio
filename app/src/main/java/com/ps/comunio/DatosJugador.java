package com.ps.comunio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DatosJugador extends AppCompatActivity {

    // Jugador de prueba para añadir
    private Jugador jugadorPrueba = new Jugador("Hola", "No se", "Delantero", "11111111");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_jugador);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textEquipo = (TextView) findViewById(R.id.textView4);
        TextView textPosicion = (TextView) findViewById(R.id.textView5);
        TextView textValor = (TextView) findViewById(R.id.textView6);

        Jugador jug = (Jugador)getIntent().getExtras().getSerializable("dat");

        setTitle(jug.getNombre());

        textEquipo.setText("Equipo: "+jug.getEquipo());
        textPosicion.setText("Posición: "+jug.getPosicion());
        textValor.setText("Valor: "+jug.getValor());

    }

    //TODO metodo que maneja el toque del boton de cada jugador
    public void ficharJugador(View view){

        // Creamos una instancia del fragment
        fragmentFichajes fragment = new fragmentFichajes();

        // Creamos una copia del arraylist de la clase del fragment y un adapter
        ArrayList<Jugador> fichajes = fragment.getFichajesMod();
        fragmentFichajes.AdaptadorFichajes adapter = null;

        // Añadimos un jugador de prueba al arraylist (funciona)
        fichajes.add(jugadorPrueba);

        // Actualizamos el adapter y lo colocamos al list (que es el fragment)
        adapter = new fragmentFichajes.AdaptadorFichajes(getApplicationContext(), fichajes);
        fragment.setListAdapter(adapter);

        // Actualizamos cuando se cambie
        adapter.notifyDataSetChanged();

        // Ponemos un mensaje
        Toast.makeText(getApplicationContext(), "Jugador fichado correctamente", Toast.LENGTH_SHORT).show();
    }

}
