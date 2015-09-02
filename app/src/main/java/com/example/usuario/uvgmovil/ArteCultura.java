package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ArteCultura extends ActionBarActivity {
    private ListView mList;
    private String[] Lista = {"FanPage","Inscripcion"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artecultura);

        mList = (ListView)findViewById(R.id.LVartecultura);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                if (clickedViewedView.getText() == "FanPage") {
                    String url = "https://www.facebook.com/arteyculturauvg";
                    Intent intent = new Intent(ArteCultura.this, Facebook.class);
                    intent.putExtra("direccion", url);
                    intent.putExtra("tittle", "FanPage Arte y Cultura");
                    startActivity(intent);
                }
                if (clickedViewedView.getText() == "Inscripcion") {
                    String url = "https://docs.google.com/forms/d/15uxSJqhbeWZrtpV0Lo23gAKj0VhkU_BDxNAQGwUOB_w/viewform";
                    Intent intent = new Intent(ArteCultura.this, Facebook.class);
                    intent.putExtra("direccion", url);
                    intent.putExtra("tittle", "Inscripcion");
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_arte_cultura, menu);
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

        return super.onOptionsItemSelected(item);
    }
}