package com.ps.comunio;

/**
 * Created by Mario on 16/11/2015.
 */
public class Noticia {
    private String titular, cuerpo;

    public Noticia(String titular, String cuerpo) {
        this.titular = titular;
        this.cuerpo = cuerpo;
    }

    public String getTitular() {
        return this.titular;
    }

    public String getCuerpo() {
        return this.cuerpo;
    }
}
