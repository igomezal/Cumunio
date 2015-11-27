package com.ps.comunio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ivan on 20/11/2015.
 */
public class miEquipo extends Fragment{
    View rootView;
    private FragmentTabHost mTabHost;

    public miEquipo() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_tab_equipo,container,false);
        mTabHost = (FragmentTabHost) rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(),getChildFragmentManager(),R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("fragmentb").setIndicator("Titulares"), miEquipoTitulares.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("fragmentc").setIndicator("Suplentes"),miEquipoSuplentes.class,null);


        return rootView;
    }
}
