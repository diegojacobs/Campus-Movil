package com.example.usuario.uvgmovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
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
    ImageView mBtnBB;
    ImageView mBtnPhone;

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
        mBtnBB = (ImageView) findViewById(R.id.BtnBB);
        mBtnPhone = (ImageView) findViewById(R.id.BtnContact);

        //Boton de Pago
        mBtnPago.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, Pago.class));
                    }
                }
        );

        //Boton de Blackboard
        mBtnBB.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://uvg.blackboard.com";
                            Intent intent = new Intent(Principal.this, mWebBrowser.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "BlackBoard");
                        startActivity(intent);
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

        //Boton de Contacto
        mBtnPhone.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, Contacto.class));
                    }
                }
        );

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Proximamente...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    //Boton de Portal
    public void OnClickButton(View v) {
        if ((v.getId() == R.id.BtnPortal)) {
            //validamos que haya hecho login
            UserConfigs conf = new UserConfigs(this);
            if (!conf.getEmail().equals("correo")) {
                startActivity(new Intent(Principal.this, Portal.class));

            } else {
                Intent i = new Intent(Principal.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
                startActivity(i);
                finish();
            }
        }
    }
/*
    @Override
    public boolean onKeyUp( int keyCode, KeyEvent event )
    {
        if( keyCode == KeyEvent.KEYCODE_BACK )
        {
            System.exit(0);
            return true;
        }
        return super.onKeyUp( keyCode, event );
    }
*/
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

            Intent i = new Intent(Principal.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
