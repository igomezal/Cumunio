package com.ps.comunio;

/**
 * Created by Mario on 16/11/2015.
 */
public class Noticia {
    private String titular,cuerpo,fecha;
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
}
