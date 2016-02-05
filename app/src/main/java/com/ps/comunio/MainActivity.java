package com.ps.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    String contra = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



    }
    public void sendMessage(View view){
        EditText usuario = (EditText) findViewById(R.id.username);
        String strUsuario = usuario.getText().toString();

        EditText pass = (EditText)findViewById(R.id.editText2);
        String strPass = pass.getText().toString();

        obtContraseña(strUsuario,strPass);



    }

    public void logTest(View view){
        Intent intent = new Intent(this, Menuss.class);
        //intent.putExtra(EXTRA_MESSAGE, strUsuario);
        setNombre("Pepito");
        startActivity(intent);
    }
    public void toRegistro(View view){
        final Intent intent = new Intent(this, RegistroActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void setNombre(String nombre){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.setUsuario(nombre);
    }

    public void obtContraseña(String nombre,String strPass){
        AsyncHttpClient client = new AsyncHttpClient();
        String url = "http://cumunio.esy.es/login.php";

        RequestParams parametros = new RequestParams();

        parametros.put("usuario",nombre);
        final String pass = strPass;
        final String strUsuario = nombre;
        client.post(url, parametros, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if(statusCode==200){
                    obtContraseñaJson(new String(responseBody));

                    if (pass.equals(contra)) {
                        Intent intent = new Intent(getApplicationContext(), Menuss.class);
                        setNombre(strUsuario);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
    public void obtContraseñaJson(String response){
        contra = "";
        try{
            JSONArray jsonArray = new JSONArray(response);
            for(int i=0;i<jsonArray.length();i++){
                contra =jsonArray.getJSONObject(i).getString("Contraseña");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}