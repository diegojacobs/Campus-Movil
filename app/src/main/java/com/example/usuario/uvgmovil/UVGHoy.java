package com.example.usuario.uvgmovil;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Diego Jacobs on 29/07/2015.
 */
public class UVGHoy extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uvghoy);
        String url="http://hoy.uvg.edu.gt/index.php/Central:Portada";
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.getSettings().setJavaScriptEnabled(true);
        view.loadUrl(url);

    }
}