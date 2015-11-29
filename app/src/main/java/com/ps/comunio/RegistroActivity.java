package com.ps.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void registrarUsuario(View view){

        EditText userEdit = (EditText) findViewById(R.id.editUser);
        String strUsuario = userEdit.getText().toString();

        EditText passEdit = (EditText)findViewById(R.id.editPass);
        String strPass = passEdit.getText().toString();

        EditText correoEdit = (EditText) findViewById(R.id.editCorreo);
        String strCorreo = correoEdit.getText().toString();

        EditText fechaNacimientoEdit = (EditText)findViewById(R.id.editFechanacimiento);
        String strFechaNacimiento = fechaNacimientoEdit.getText().toString();

        if((strUsuario != null && !strUsuario.isEmpty()) && (strPass != null && !strPass.isEmpty())){

            addUsuario(strUsuario,strPass,strCorreo,strFechaNacimiento);

            Toast.makeText(this, "Usuario " + strUsuario + " creado.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario o contraseña vacios, intentelo de nuevo", Toast.LENGTH_LONG).show();
        }

    }

    public void addUsuario(String nombre,String contraseña,String correo,String fecha){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://tefox.esy.es/registro.php";

        RequestParams parametros = new RequestParams();

        parametros.put("nombre","\""+nombre+"\"");
        parametros.put("contraseña","\""+contraseña+"\"");
        parametros.put("correo","\""+correo+"\"");
        parametros.put("fecha","\""+fecha+"\"");

        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println("Registrado");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("No registrado");
            }
        });
    }




}
