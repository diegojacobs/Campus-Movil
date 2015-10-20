package com.example.usuario.uvgmovil;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Bienestar_Estudiantil extends ActionBarActivity {
    private ListView mList;
    private String[] Lista = {"Información","Agendar Cita","Referir Estudiante"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bienestar__estudiantil);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mList = (ListView)findViewById(R.id.LVbienestar);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                if (clickedViewedView.getText() == "Información") {
                    CopyReadAssets("UBE-folleto.pdf");
                }
                if (clickedViewedView.getText() == "Agendar Cita") {
                    String url="https://docs.google.com/a/uvg.edu.gt/forms/d/1JffdoMlAjPO6FP-ZvCGbAD7ztCAadhtxtyFOdyu5h9s/viewform";
                    Intent intent = new Intent(Bienestar_Estudiantil.this, Facebook.class);
                    intent.putExtra("direccion", url);
                    intent.putExtra("tittle", "Agendar Cita");
                    startActivity(intent);
                }
                if (clickedViewedView.getText() == "Referir Estudiante") {
                    String url="https://docs.google.com/a/uvg.edu.gt/forms/d/1HsHYgklTjxK912vRMLIq7DxP0m-aiu3nZ0Ll5MpxFGs/viewform";
                    Intent intent = new Intent(Bienestar_Estudiantil.this, Facebook.class);
                    intent.putExtra("direccion", url);
                    intent.putExtra("tittle", "Referir Estudiante");
                    startActivity(intent);
                }
            }
        });
    }

    public void CopyReadAssets(String filename)
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), filename);
        try
        {
            in = assetManager.open(filename);
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e)
        {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/" + filename),
                "application/pdf");

        startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bienestar__estudiantil, menu);
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
