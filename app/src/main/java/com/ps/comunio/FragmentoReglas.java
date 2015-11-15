package com.ps.comunio;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sergiownd on 13/11/15.
 */
public class FragmentoReglas extends Fragment {
    public FragmentoReglas (){
    }

    public View OnCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.frame_inicio,container,false);
        return rootView;
    }

}
