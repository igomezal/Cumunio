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

        EditText pass2Edit = (EditText)findViewById(R.id.editPass2);
        String strPass2 = pass2Edit.getText().toString();

        if((strUsuario != null && !strUsuario.isEmpty()) && (strPass != null && !strPass.isEmpty())){
            if(strPass.equals(strPass2)) {
                addUsuario(strUsuario, strPass, strCorreo);

                Toast.makeText(this, "Usuario " + strUsuario + " creado.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            else
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Usuario o contraseña vacios, intentelo de nuevo", Toast.LENGTH_LONG).show();
        }

    }

    public void addUsuario(String nombre,String contraseña,String correo){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://tomatodevelopers.com/cumunio/registro.php";

        RequestParams parametros = new RequestParams();

        parametros.put("nombre",nombre);
        parametros.put("contraseña",contraseña);
        parametros.put("correo",correo);

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
