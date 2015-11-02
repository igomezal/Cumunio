package com.ps.comunio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DatosJugador extends AppCompatActivity {
    Jugador jug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_jugador);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textEquipo = (TextView) findViewById(R.id.textView4);
        TextView textPosicion = (TextView) findViewById(R.id.textView5);
        TextView textValor = (TextView) findViewById(R.id.textView6);

        jug = (Jugador)getIntent().getExtras().getSerializable("dat");
        setTitle(jug.getNombre());
        textEquipo.setText("Equipo: "+jug.getEquipo());
        textPosicion.setText("Posición: "+jug.getPosicion());
        textValor.setText("Valor: "+jug.getValor());

    }
    public void fichar(View view){
        Toast.makeText(this, "Fichado "+jug.getNombre(),Toast.LENGTH_LONG).show();
        ficharGlobal(jug);
    }
    public void ficharGlobal(Jugador player){
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        globalVariable.ficharJugador(player);
    }
}
