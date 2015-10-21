package com.example.usuario.uvgmovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String user;
    private String pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().hide();
    }
    public void OnClickButton(View v) {
        if ((v.getId() == R.id.BtnLogin)) {
            EditText usuario = (EditText) findViewById(R.id.TUsuarioIngresado);
            String usuarioIngresado = usuario.getText().toString();
            if (usuarioIngresado.length() >= 12) {   //si el usuario no termina en lo esperado da un error y contiene longitud mínima
                String validacion = usuarioIngresado.substring(usuarioIngresado.length() - 11);   // cadena de validacion
                if (validacion.equals("@uvg.edu.gt")) {
                    Intent i = new Intent(MainActivity.this, Principal.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
                    i.putExtra("Usuario", usuarioIngresado);
                    user = usuarioIngresado;
                    startActivity(i);                                       // lanza la nueva actividad
                }

            }
        }
        if(v.getId()==R.id.BtnInvitado){
            Intent i = new Intent(MainActivity.this, Principal.class);
            startActivity(i);
        }
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
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
}
