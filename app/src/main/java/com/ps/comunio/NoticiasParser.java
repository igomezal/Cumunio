package com.ps.comunio;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by sergiownd on 24/11/15.
 */
public class NoticiasParser {
    public ArrayList<Noticia> leerFlujoJsonNoticia (InputStream in) throws IOException{
        JsonReader reader = new JsonReader(new InputStreamReader(in,"UTF-8"));
        try {
            return leerArrayNoticias (reader);
        } finally {
            reader.close();
        }
    }

    public ArrayList<Noticia> leerArrayNoticias(JsonReader reader) throws IOException{
        ArrayList<Noticia> noticias = new ArrayList<>();
        reader.beginArray();
        while (reader.hasNext()){
            noticias.add(leerNoticias(reader));
        }
        reader.endArray();
        return noticias;
    }

    public Noticia leerNoticias (JsonReader reader) throws IOException{
        String titular,cuerpo,fecha;
        titular = null;
        cuerpo = null;
        fecha = null;

        reader.beginObject();

        while (reader.hasNext()){
            String name = reader.nextName();
            switch (name){
                case "titulo":
                    titular = reader.nextString();
                    break;
                case "cuerpo":
                    cuerpo = reader.nextString();
                    break;
                case "fecha":
                    fecha = reader.nextString();
                    break;
                default:
                    reader.skipValue();
                    break;
            }
        }
        reader.endObject();
        return new Noticia(titular,cuerpo,fecha);
    }
}
