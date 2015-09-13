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
 * Created by Roberto Chiroy on 09/09/2015.
 */
public class CarrerasCCSS extends ActionBarActivity{

    private ListView mList;

    private final String[] Lista = {"Arquelogía","Antropología y sociología","Historia","Psicología"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrerasb);

        mList = (ListView) findViewById(R.id.LVcarreras);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
               switch ((String)clickedViewedView.getText()){

                   case ("Arquelogía"):
                       CopyReadAssets("Licenciatura_en_Arqueologia.pdf");
                       break;

                   case ("Antropología y sociología"):
                       CopyReadAssets("Licenciatura_en_Antropo_y_Socio.pdf");
                       break;

                   case ("Historia"):
                       CopyReadAssets("Lic_en_Historia.pdf");
                       break;

                   case ("Psicología"):
                       CopyReadAssets("Lic_en_Psicologia.pdf");
                       break;

               }


           }
        });
    }

    private void CopyReadAssets(String name) {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), name);
        try
        {
            in = assetManager.open(name);
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
                Uri.parse("file://" + getFilesDir() +"/"+ name),
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
