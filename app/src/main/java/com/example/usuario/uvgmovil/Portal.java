package com.example.usuario.uvgmovil;

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
    // Progress Dialog
    private ProgressDialog pDialog;

    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> empresaList;


    // url to get all products list
    //private static String url_all_empresas = "http://basededatosremotas.meximas.com/ramiroconnect/get_all_empresas.php";
    private static String url_all_empresas = "http://uvgmobil.host22.com/uvgmobil/get_all_empresas.php";
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_PRODUCTS = "empresas";
    private static final String TAG_ID = "id";
    private static final String TAG_NOMBRE = "nombre";

    // products JSONArray
    JSONArray products = null;

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Hashmap para el ListView
        empresaList = new ArrayList<HashMap<String, String>>();
        lista = (ListView) findViewById(R.id.listAllProducts);

        // Cargar los productos en el Background Thread
        new LoadAllProducts(empresaList,Portal.this,lista).execute();

    }

}
