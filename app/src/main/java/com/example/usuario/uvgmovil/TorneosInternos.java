package com.example.usuario.uvgmovil;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Diego Jacobs on 27/07/2015.
 */
public class TorneosInternos extends ActionBarActivity {
    private ListView mList;
    private String[] Lista = {"Futbol 4 Estudiantes","Baloncesto Mixto","Futbol 4 Colaboladores","Voleibol Mixto","Reglamento"};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.torneosinternos);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        mList = (ListView)findViewById(R.id.LVtorneos);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                if (clickedViewedView.getText() == "Futbol 4 Estudiantes") {
                    startActivity(new Intent(TorneosInternos.this, Fut4_est.class));
                }
                if (clickedViewedView.getText() == "Baloncesto Mixto") {
                    startActivity(new Intent(TorneosInternos.this, Baloncesto.class));
                }
                if (clickedViewedView.getText() == "Futbol 4 Colaboladores") {
                    startActivity(new Intent(TorneosInternos.this, Fut4_col.class));
                }
                if (clickedViewedView.getText() == "Voleibol Mixto") {
                    startActivity(new Intent(TorneosInternos.this, Volley.class));
                }
                if (clickedViewedView.getText() == "Reglamento") {
                    CopyReadAssets("Reglamento-General-2015.pdf");
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
                Uri.parse("file://" + getFilesDir() + "/"+filename),
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


}

