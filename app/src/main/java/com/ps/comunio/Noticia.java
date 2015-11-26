package com.ps.comunio;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mario on 16/11/2015.
 */
public class Noticia implements Serializable{
    @SerializedName("titular")
    private String titular;
    @SerializedName("cuerpo")
    private String cuerpo;
    @SerializedName("fecha")
    private String fecha;

    public Noticia(String titular, String cuerpo,String fecha){
        this.titular=titular;
        this.cuerpo=cuerpo;
        this.fecha=fecha;
    }

    public String getTitular(){
        return this.titular;
    }

    public String getCuerpo(){
        return this.cuerpo;
    }

    public String getFecha(){
        return this.fecha;
    }

    public void setTitular(String titular){this.titular=titular;}

    public void setCuerpo(String cuerpo){this.cuerpo=cuerpo;}
    public void setFecha(String fecha){this.fecha=fecha;}
}
