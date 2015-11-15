package com.ps.comunio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class fragmentInicio extends Fragment {


    public fragmentInicio() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.frame_inicio, container, false);
        Button sald = (Button) rootView.findViewById(R.id.floating_button2);
        sald.setText(getSald());
        return rootView;
    }
    public String getSald(){
        GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        return globalVariable.getSaldo();
    }
}




