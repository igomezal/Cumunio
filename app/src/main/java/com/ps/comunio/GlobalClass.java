package com.ps.comunio;

import android.app.Application;


/**
 * Created by Ivan on 01/11/2015.
 */
public class GlobalClass extends Application {

    private String usuario = "";

    public void setUsuario(String nombre){
        this.usuario=nombre;
    }
    public String getUsuario(){
        return this.usuario;
    }
}
