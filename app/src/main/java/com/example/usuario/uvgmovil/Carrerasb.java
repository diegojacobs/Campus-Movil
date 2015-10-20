package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Diego Jacobs on 05/08/2015.
 */
public class Carrerasb extends ActionBarActivity{

    private ListView mList;
    private final String[]ListaFac={"Ingeniería","Colegio universitario y asuntos estudiantiles","Ciencias y Humanidades","Ciencias Sociales","Educación"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrerasb);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mList = (ListView) findViewById(R.id.LVcarreras);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, ListaFac); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
               switch ((String)clickedViewedView.getText()){

                   case ("Ingeniería"):
                       startActivity(new Intent(Carrerasb.this, CarrerasIngenieria.class));
                       break;

                   case ("Colegio universitario y asuntos estudiantiles"):
                       Uri uri =Uri.parse("http://uvg.edu.gt/universitario/");
                       Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                       startActivity(intent);
                       break;

                   case ("Ciencias y Humanidades"):
                       startActivity(new Intent(Carrerasb.this, CarrerasCCHH.class));
                       break;

                   case ("Ciencias Sociales"):
                       startActivity(new Intent(Carrerasb.this, CarrerasCCSS.class));
                       break;

                   case ("Educación"):
                       startActivity(new Intent(Carrerasb.this, CarrerasEDU.class));
                       break;
               }

           }
        });
    }
}
