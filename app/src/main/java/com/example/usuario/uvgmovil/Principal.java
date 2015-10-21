package com.example.usuario.uvgmovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Principal extends AppCompatActivity {
    ImageView mBtnPago;
    ImageView mBtnNews;
    ImageView mBtnInfo;
    ImageView mBtnMap;
    ImageView mBtnPortal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mBtnPago = (ImageView) findViewById(R.id.BtnPago);
        mBtnNews = (ImageView) findViewById(R.id.BtnNews);
        mBtnInfo = (ImageView) findViewById(R.id.BtnInfo);
        mBtnMap = (ImageView) findViewById(R.id.BtnMap);
        mBtnPortal = (ImageView) findViewById(R.id.BtnPortal);


        //Boton de Pago
        mBtnPago.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, Pago.class));
                    }
                }
        );

        //Boton de Noticias
        mBtnNews.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, News.class));
                    }
                }
        );

        //Boton de Portal
        mBtnPortal.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, Portal.class));
                    }
                }
        );

        //Boton de Informacion
        mBtnInfo.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, Info.class));
                    }
                }
        );

        //Boton de Mapa
        mBtnMap.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, MapsActivity.class));
                    }
                }
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
