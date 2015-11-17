package com.example.usuario.uvgmovil;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class mWebBrowser extends AppCompatActivity {
    private WebView mWBfb;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mweb_browser);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();

        //Editamos el Action Bar
        getSupportActionBar().setTitle(bundle.getString("tittle"));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mWBfb = (WebView) findViewById(R.id.WVfb);
        mWBfb.setWebViewClient(new MyBrowser());
        mWBfb.getSettings().setJavaScriptEnabled(true);
        mWBfb.getSettings().supportZoom();
        mWBfb.getSettings().setBuiltInZoomControls(true);
        mWBfb.getSettings().setLoadWithOverviewMode(true);
        mWBfb.getSettings().setUseWideViewPort(true);
        mWBfb.loadUrl(bundle.getString("direccion"));
    }

    private class MyBrowser extends WebViewClient {
        public boolean cargarUrlCliente(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(mWBfb.canGoBack()) {
            mWBfb.goBack();
        } else {
            super.onBackPressed();
        }
    }

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

            Intent i = new Intent(mWebBrowser.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
