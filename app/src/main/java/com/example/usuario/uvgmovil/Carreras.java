package com.example.usuario.uvgmovil;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Diego Jacobs on 05/08/2015.
 */
public class Carreras extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carreras);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String url="http://www.uvg.edu.gt";
        WebView viewCarreras=(WebView) this.findViewById(R.id.navegadorCarreras);
        viewCarreras.setWebViewClient(new MyBrowser());
        viewCarreras.getSettings().setJavaScriptEnabled(true);
        viewCarreras.loadUrl(url);
    }
    private class MyBrowser extends WebViewClient{
        public boolean cargarUrlCliente(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }



}
