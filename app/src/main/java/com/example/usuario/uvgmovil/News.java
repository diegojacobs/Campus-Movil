package com.example.usuario.uvgmovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class News extends AppCompatActivity {
    private ListView mList;
    private String[] Lista = {"UVG Hoy","Deportes UVG","Comunidad UVG","Centro de investigaciones"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mList = (ListView)findViewById(R.id.LVnews);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                if (clickedViewedView.getText() == "UVG Hoy") {
                    startActivity(new Intent(News.this, UVGHoy.class));
                }
                if (clickedViewedView.getText() == "Deportes UVG") {
                    startActivity(new Intent(News.this, Deportes.class));
                }
                if (clickedViewedView.getText() == "Comunidad UVG") {
                    startActivity(new Intent(News.this, Comunidad_UVG.class));
                }
                if (clickedViewedView.getText() == "Centro de investigaciones") {
                    String url="http://www.uvg.edu.gt/investigacion/index.html#";
                    Uri uri =Uri.parse(url);
                    Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(intent);
                }
            }
        });
    }

}
