package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Diego Jacobs on 21/05/2015.
 */
//Clase de la pagina principal
public class Principal extends ActionBarActivity{

    ImageButton mBtnPago;
    ImageButton mBtnNews;
    ImageButton mBtnInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

        mBtnPago = (ImageButton) findViewById(R.id.BtnPago);
        mBtnNews = (ImageButton) findViewById(R.id.BtnNews);
        mBtnInfo = (ImageButton) findViewById(R.id.BtnInfo);


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

        //Boton de Informacion
        mBtnInfo.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        startActivity(new Intent(Principal.this, Carreras.class));
                    }
                }
        );
    }

}


