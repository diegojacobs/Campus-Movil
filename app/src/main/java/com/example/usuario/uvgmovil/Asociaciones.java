package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Asociaciones extends ActionBarActivity {
    ImageView mBtnAECCTI;
    ImageView mBtnAEIQ;
    ImageView mBtnAEIE;
    ImageView mBtnAMEC;
    ImageView mBtnAEUVG;
    ImageView mBtnAEFE;
    ImageView mBtnASODEN;
    ImageView mBtnAEICA;
    ImageView mBtnAEII;
    ImageView mBtnAEIM;
    ImageView mBtnAECCSSE;
    ImageView mBtnAEFI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.asociaciones);

        mBtnAECCTI = (ImageView) findViewById(R.id.BtnAECCTI);
        mBtnAEIQ = (ImageView) findViewById(R.id.BtnAEIQ);
        mBtnAEIE = (ImageView) findViewById(R.id.BtnAEIE);
        mBtnAMEC = (ImageView) findViewById(R.id.BtnAEMEC);
        mBtnAEUVG = (ImageView) findViewById(R.id.BtnAEUVG);
        mBtnAEFE = (ImageView) findViewById(R.id.BtnAEFE);
        mBtnASODEN = (ImageView) findViewById(R.id.BtnASODEN);
        mBtnAEICA = (ImageView) findViewById(R.id.BtnAEICA);
        mBtnAEII = (ImageView) findViewById(R.id.BtnAEII);
        mBtnAEIM = (ImageView) findViewById(R.id.BtnAEIM);
        mBtnAECCSSE = (ImageView) findViewById(R.id.BtnAECCSSE);
        mBtnAEFI = (ImageView) findViewById(R.id.BtnAEFI);
        //Boton de Compu
        mBtnAECCTI.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/aeccti.uvg?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AECCTI");
                        startActivity(intent);
                    }
                }
        );
        //Boton de Quimica
        mBtnAEIQ.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/aeiq.uvg?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEIQ");
                        startActivity(intent);
                    }
                }
        );
        //Boton de Electronica
        mBtnAEIE.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/aeie.uvg";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEIE");
                        startActivity(intent);
                    }
                }
        );

        //Boton de Mecanica
        mBtnAMEC.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/AMEC.UVG?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AMEC");
                        startActivity(intent);
                    }
                }
        );

        //Boton de UVG
        mBtnAEUVG.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/aeuvg/timeline";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEUVG");
                        startActivity(intent);
                    }
                }
        );

        //Boton de Educación
        mBtnAEFE.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/aefedu?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEFE");
                        startActivity(intent);
                    }
                }
        );

        //Boton de Nutrición
        mBtnASODEN.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/pages/Asoden-UVG/340096079342711?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "ASODEN");
                        startActivity(intent);
                    }
                }
        );

        //Boton de Alimentos
        mBtnAEICA.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/pages/AEICA/150576038430339?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEICA");
                        startActivity(intent);
                    }
                }
        );
        //Boton de Industrial
        mBtnAEII.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/pages/Asociaci%C3%B3n-de-Estudiantes-de-Ingenieria-Industrial-2015-UVG/549886978477702?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEII");
                        startActivity(intent);
                    }
                }
        );

        //Boton de Mecatronica
        mBtnAEIM.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/pages/Asociaci%C3%B3n-de-Estudiantes-de-Ing-Mecatr%C3%B3nica/866672916699347?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEIM");
                        startActivity(intent);
                    }
                }
        );

        //Boton de ciencias sociales
        mBtnAECCSSE.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/aeccsse.uvg.3?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AECCSSE");
                        startActivity(intent);
                    }
                }
        );
        //Boton de ingenieria
        mBtnAEFI.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        String url="https://www.facebook.com/pages/AEFI-UVG/818587044860797?fref=ts";
                        Intent intent = new Intent(Asociaciones.this, Facebook.class);
                        intent.putExtra("direccion", url);
                        intent.putExtra("tittle", "AEFI");
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_asociaciones, menu);
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
