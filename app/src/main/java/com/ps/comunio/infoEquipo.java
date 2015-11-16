package com.ps.comunio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class infoEquipo extends AppCompatActivity {

    private ArrayList<Equipo> datos= new ArrayList<Equipo>();

    private ListView lvEquipo;
    private TextView tvNombre,tvValor,tvPuntos;
    private Integer position;
    private ImageView escudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_equipo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        datos = getEquipos();
        Collections.sort(datos, new Comparator<Equipo>() {
            @Override
            public int compare(Equipo lhs, Equipo rhs) {
                return new Integer(rhs.getPuntos()).compareTo(new Integer(lhs.getPuntos()));
            }
        });
        position = Integer.parseInt(getIntent().getStringExtra("position"));
        lvEquipo=(ListView)findViewById(R.id.lvEquipo);
        tvNombre=(TextView)findViewById(R.id.tvEquipo);
        tvValor=(TextView)findViewById(R.id.tvValoracion);
        tvPuntos = (TextView)findViewById(R.id.tvPuntos);
        escudo = (ImageView)findViewById(R.id.imageEscudo);
        tvNombre.setText(datos.get(position).getNombre());
        tvValor.setText("Valor: "+Integer.toString(datos.get(position).getValor()));
        tvPuntos.setText("Puntos: "+Integer.toString(datos.get(position).getPuntos()));
        escudo.setImageResource(datos.get(position).getEqImagen());
    }



    public ArrayList<Equipo> getEquipos(){
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        return globalVariable.getEquipos();
    }

}
