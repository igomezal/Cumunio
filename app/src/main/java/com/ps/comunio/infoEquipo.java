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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class infoEquipo extends AppCompatActivity {

    private ArrayList<Equipo> datos= new ArrayList<Equipo>();
    private ArrayList<Jugador> datos2 = new ArrayList<>();
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
        datos2 = datos.get(position).getJugadores();
        lvEquipo=(ListView)findViewById(R.id.lvEquipo);
        tvNombre=(TextView)findViewById(R.id.tvEquipo);
        tvValor=(TextView)findViewById(R.id.tvValoracion);
        tvPuntos = (TextView)findViewById(R.id.tvPuntos);
        escudo = (ImageView)findViewById(R.id.imageEscudo);
        tvNombre.setText(datos.get(position).getNombre());
        tvValor.setText("Valor: "+Integer.toString(datos.get(position).getValor()));
        tvPuntos.setText("Puntos: "+Integer.toString(datos.get(position).getPuntos()));
        escudo.setImageResource(datos.get(position).getEqImagen());
        adaptadorListaEquipos adapter = new adaptadorListaEquipos(this,datos2);
        lvEquipo.setAdapter(adapter);
        Button sald = (Button) findViewById(R.id.floating_button19);
        sald.setText(getSald());
    }



    public ArrayList<Equipo> getEquipos(){
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        return globalVariable.getEquipos();
    }

    class adaptadorListaEquipos extends ArrayAdapter<Jugador> {
        public adaptadorListaEquipos (Context context, ArrayList<Jugador> datos){
            super(context,R.layout.listitem_jugador,datos2);
        }
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_jugador, null);
            ImageView Imagen = (ImageView) item.findViewById(R.id.imageView);
            TextView Nombre = (TextView) item.findViewById(R.id.NombreJugador);
            TextView Equipo = (TextView) item.findViewById(R.id.tVEquipo);
            TextView Valoracion = (TextView) item.findViewById(R.id.tvValoracion);
            Nombre.setText(datos2.get(position).getNombre());
            Equipo.setText(datos2.get(position).getEquipo());
            Valoracion.setText(datos2.get(position).getValoracion().toString());
            Imagen.setImageResource(datos2.get(position).getImagen());
            return item;
        }
    }
    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        return globalVariable.getSaldo();
    }

}
