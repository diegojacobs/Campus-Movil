package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class ConsultaParqueo extends AppCompatActivity {

    private TextView t_parqueo_asignado;

    // ArrayList Saldos
    private ArrayList carnets = new ArrayList();
    private ArrayList parqueos = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_parqueo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtener textView por Id
        t_parqueo_asignado = (TextView) findViewById(R.id.textView25);

        // Cargar valores del WebService
        LoadAllUsers cf = new LoadAllUsers();
        try {
            String status = cf.execute().get();
            carnets = cf.getCarnets();
            parqueos = cf.getParqueos();
            // Obtener los datos del usuario que haya hecho LogIn
            UserConfigs conf = new UserConfigs(this);
            String carnet = conf.getCarnet();
            int index = carnets.indexOf(carnet);
            // Establecer valores en los textView
            if (index != -1) {
                String n_parqueo = (String) parqueos.get(index);
                if (n_parqueo.equals("0"))
                    t_parqueo_asignado.setText("Parqueo asignado: NO ASIGNADO");
                else
                    t_parqueo_asignado.setText("Parqueo asignado: "+n_parqueo);
            }
            else
            {
                t_parqueo_asignado.setText("Parqueo asignado: NO HAY REGISTRO");

            }

        }
        catch (ExecutionException | InterruptedException ei) {
            ei.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);

        UserConfigs conf = new UserConfigs(this);
        if (conf.getEmail().equals("correo"))
            menu.findItem(R.id.action_signout).setTitle("Sign In");
        else
            menu.findItem(R.id.action_signout).setTitle("Sign Out");

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

        if (id == R.id.action_signout) {
            UserConfigs conf = new UserConfigs(this);
            conf.setEmail("correo");
            conf.setNotifications(true);

            Intent i = new Intent(ConsultaParqueo.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
