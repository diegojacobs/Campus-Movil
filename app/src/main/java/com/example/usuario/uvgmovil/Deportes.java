package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Diego Jacobs on 29/07/2015.
 */
public class Deportes extends ActionBarActivity {

    private ListView mList;
    private String[] Lista = {"Torneos Internos","Entrenos Deportivos"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deportes);

        mList = (ListView)findViewById(R.id.LVdeportes);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                if (clickedViewedView.getText() == "Torneos Internos") {
                    startActivity(new Intent(Deportes.this, TorneosInternos.class));
                }
                if (clickedViewedView.getText() == "Entrenos Deportivos") {
                    startActivity(new Intent(Deportes.this, Entrenos_Deportivos.class));
                }
            }
        });
    }
}
