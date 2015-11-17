package com.example.usuario.uvgmovil;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Portal extends AppCompatActivity {

    private ListView mList;
    private String[] Lista = {"Mi Horario","Mi Mapa Curricular","Mi Parqueo","Mis Notas"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mList = (ListView)findViewById(R.id.LVPortal);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                if (clickedViewedView.getText() == "Mi Horario") {
                    Intent intent = new Intent(Portal.this, mWebBrowser.class);
                    intent.putExtra("direccion", "http://uvgmobil.host22.com/uvgmobil/viewImage.php");
                    intent.putExtra("tittle", "Mi Horario");
                    startActivity(intent);
                }
                if (clickedViewedView.getText() == "Mi Mapa Curricular") {
                    Intent intent = new Intent(Portal.this, mWebBrowser.class);
                    intent.putExtra("direccion", "http://uvgmobil.host22.com/uvgmobil/viewMapa.php");
                    intent.putExtra("tittle", "Mi Mapa Curricular");
                    startActivity(intent);
                }
                if (clickedViewedView.getText() == "Mi Parqueo") {
                    //startActivity(new Intent(Portal.this, Comunidad_UVG.class));
                    //validamos que haya hecho login
                    UserConfigs conf = new UserConfigs(Portal.this);
                    if (!conf.getEmail().equals("correo")) {
                        startActivity(new Intent(Portal.this, ConsultaParqueo.class));

                    } else {
                        Intent i = new Intent(Portal.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
                        startActivity(i);
                    }
                }
                if(clickedViewedView.getText() == "Mis Notas"){
                    //validamos que haya hecho login
                    UserConfigs conf = new UserConfigs(Portal.this);
                    startActivity(new Intent(Portal.this, ConsultaNotas.class));

                }
            }
        });
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

            Intent i = new Intent(Portal.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
