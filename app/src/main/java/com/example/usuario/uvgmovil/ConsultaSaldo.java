package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Daniel Orozco on 27/10/2015.
 */

public class ConsultaSaldo extends AppCompatActivity {

    private TextView t_saldo_vencido;
    private TextView t_saldo_p_vencer;
    private TextView t_saldo_p_cargar;

    // ArrayList Saldos
    private ArrayList carnets_saldos = new ArrayList();
    private ArrayList c_saldo_vencido = new ArrayList();
    private ArrayList saldo_vencido = new ArrayList();
    private ArrayList c_saldo_p_vencer = new ArrayList();
    private ArrayList saldo_p_vencer = new ArrayList();
    private ArrayList saldo_p_cargar = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_saldo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtener textView por Id
        t_saldo_vencido = (TextView) findViewById(R.id.textView22);
        t_saldo_p_vencer = (TextView) findViewById(R.id.textView23);
        t_saldo_p_cargar = (TextView) findViewById(R.id.textView24);

        // Cargar valores del WebService
        LoadAllUsers cf = new LoadAllUsers();
        try {
            String status = cf.execute().get();
            carnets_saldos = cf.getCarnets_saldos();
            c_saldo_vencido = cf.getC_saldo_vencido();
            saldo_vencido = cf.getSaldo_vencido();
            c_saldo_p_vencer = cf.getC_saldo_p_vencer();
            saldo_p_vencer = cf.getSaldo_p_vencer();
            saldo_p_cargar = cf.getSaldo_p_cargar();
            // Obtener los datos del usuario que haya hecho LogIn
            UserConfigs conf = new UserConfigs(this);
            String carnet = conf.getCarnet();
            int index = carnets_saldos.indexOf(carnet);
            // Establecer valores en los textView
            if (index != -1) {
                t_saldo_vencido.setText("Saldo vencido: " + saldo_vencido.get(index));
                t_saldo_p_vencer.setText("Saldo por vencer: " + saldo_p_vencer.get(index));
                t_saldo_p_cargar.setText("Saldo por cargar: " + saldo_p_cargar.get(index));
            }
            else
            {
                t_saldo_vencido.setText("Saldo vencido: NO HAY REGISTRO");
                t_saldo_p_vencer.setText("Saldo por vencer: NO HAY REGISTRO");
                t_saldo_p_cargar.setText("Saldo por cargar: NO HAY REGISTRO");
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

            Intent i = new Intent(ConsultaSaldo.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}

