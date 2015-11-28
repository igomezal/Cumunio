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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //public final static String EXTRA_MESSAGE = "com.ps.comunio.MESSAGE";
    ArrayList<Usuario> usuarios = new ArrayList<>();

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

        usuarios = getUsuarios();

        for(int i = 0; i < usuarios.size(); i++) {
            if (strUsuario.equals(usuarios.get(i).getUser()) && strPass.equals(usuarios.get(i).getPass())) {
                Intent intent = new Intent(this, Menuss.class);

                setNombre(usuarios.get(i).getUser());
                startActivity(intent);
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show();
            }
        }
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

    public ArrayList<Usuario> getUsuarios(){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        return globalVariable.getUsuarios();
    }
}