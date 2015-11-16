package com.example.usuario.uvgmovil;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String user;
    private String pass;
    private ArrayList carnets = new ArrayList();
    private ArrayList names = new ArrayList();
    private ArrayList emails = new ArrayList();
    private ArrayList passwords = new ArrayList();
    private ArrayList facultad = new ArrayList();
    private ArrayList carreras = new ArrayList();
    private ArrayList parqueos = new ArrayList();
    private ArrayList mapasC = new ArrayList();
    private ArrayList horarios = new ArrayList();
    private UserConfigs conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conf = new UserConfigs(this);
        if (conf.getEmail().equals("correo")) {
            setContentView(R.layout.activity_main);

            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            getSupportActionBar().hide();

            if (internetON()) {
                // Cargar los productos en el Background Thread
                Users usuarios = new Users();

                carnets = usuarios.getCarnets();
                names = usuarios.getNames();
                emails = usuarios.getEmails();
                passwords = usuarios.getPasswords();
                facultad = usuarios.getFacultades();
                parqueos = usuarios.getParqueos();
                carreras = usuarios.getCarreras();
            }

        }
        else
        {
            Intent i = new Intent(MainActivity.this, Principal.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            finish();
        }
    }
    public void OnClickButton(View v) {
        if ((v.getId() == R.id.BtnLogin)) {

            if (internetON()) {

                EditText usuario = (EditText) findViewById(R.id.TUsuarioIngresado);
                EditText password = (EditText) findViewById(R.id.TPassIngresado);
                String usuarioIngresado = usuario.getText().toString().trim();
                String passwordIngresado = password.getText().toString();

                if (emails.contains(usuarioIngresado)) {
                    int index = emails.indexOf(usuarioIngresado);
                    if (passwords.get(index).equals(passwordIngresado)) {
                        conf.setEmail(usuarioIngresado);
                        conf.setPassword(passwordIngresado);
                        conf.setCarnet(carnets.get(index).toString());
                        conf.setCarrera(carreras.get(index).toString());
                        conf.setFacultad(facultad.get(index).toString());
                        conf.setName(names.get(index).toString());
                        conf.setParqueo(parqueos.get(index).toString());

                        Intent i = new Intent(MainActivity.this, Principal.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
                        startActivity(i);                                       // lanza la nueva actividad
                        finish();
                    }
                    else
                        Toast.makeText(this,"Password erroneo",Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(this,"Correo erroneo",Toast.LENGTH_LONG).show();
            }
            else
                Toast.makeText(this,"Debe tener conexión a internet",Toast.LENGTH_LONG).show();
        }
        if(v.getId()==R.id.BtnInvitado){
            Intent i = new Intent(MainActivity.this, Principal.class);
            startActivity(i);
            finish();
        }
    }

    public boolean internetON() {
        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED || connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        } else
            connected = false;

        return connected;
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
        {
            this.finish();
            System.exit(0);
        }
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
