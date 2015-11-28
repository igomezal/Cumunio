package com.ps.comunio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistroActivity extends AppCompatActivity {

    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        usuarios = getUsuarios();

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

            Usuario nuevoUser = new Usuario(strUsuario, strPass, strCorreo, strFechaNacimiento);

            addUsuario(nuevoUser);

            Toast.makeText(this, "Usuario " + nuevoUser.getUser() + " creado.", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Usuario o contraseña vacios, intentelo de nuevo", Toast.LENGTH_LONG).show();
        }

    }

    public ArrayList<Usuario> getUsuarios(){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        return globalVariable.getUsuarios();
    }

    public void addUsuario(Usuario usuario){
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.addUsuarioArray(usuario);
    }


}
