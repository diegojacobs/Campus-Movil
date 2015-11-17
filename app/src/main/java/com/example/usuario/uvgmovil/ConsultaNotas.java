package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by William on 16/11/2015.
 */
public class ConsultaNotas extends AppCompatActivity {
    private TextView t_cod_curso;

    // ArrayList Saldos
    private ArrayList codigo_curso = new ArrayList();
    private ArrayList nombre_curso = new ArrayList();
    private ArrayList notas = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta_notas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Obtener textView por Id
        t_cod_curso= (TextView) findViewById(R.id.textView22);

        // Cargar valores del WebService
        LoadAllUsers cf = new LoadAllUsers();
        try {
            String status = cf.execute().get();
            codigo_curso = cf.getCodigo_curso();
            nombre_curso = cf.getNombre_curso();
            notas = cf.getNota();
            String notaA ="";
            for(int j=0;j<notas.size();j=j+1){
                notaA=notaA+(String)nombre_curso.get(j)+"\n"+"  RENDIMIENTO   " + notas.get(j) + "\n";

            }

            t_cod_curso.setText(notaA);



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

            Intent i = new Intent(ConsultaNotas.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
