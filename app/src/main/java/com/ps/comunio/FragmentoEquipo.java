package com.ps.comunio;

import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by sergiownd on 25/10/15.
 */
public class FragmentoEquipo extends ListFragment {
    private Equipo[] datos={
        new Equipo("Mantester Unido",150000000),
        new Equipo("Real Mandril",180000000),
        new Equipo("Cholsea",130000000),
        new Equipo("Armético de Matriz",150000000),
        new Equipo("Bayar de Manich",150000000),
    };
    public FragmentoEquipo() {
        // Required empty public constructor
    }

    //quedan todos los metodos estos raros que no tengo ni idea de hacerlos.
}
