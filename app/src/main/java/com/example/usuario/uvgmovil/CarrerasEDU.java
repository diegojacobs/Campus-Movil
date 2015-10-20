package com.example.usuario.uvgmovil;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
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
public class CarrerasEDU extends ActionBarActivity{

    private ListView mList;

    private final String[] Lista = {"Licenciatura en educación","Licenciatura en Matemática y física","Licenciatura en Psicopedagogia",
    "Licenciatura en Musica", "Licenciatura en Quimica y Biologia","Profesorado en Biologia y Quimica", "Profesorado en Educacion Especial",
    "Profesorado en Educacion Primaria", "Profesorado en Historia y CCSS","Profesorado en Ingles","Profesorado en Lengua y Literatura",
    "Profesorado en Matematica y Fisica","Profesorado en Musica","Profesorado en Problemas Aprendizaje"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrerasb);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mList = (ListView) findViewById(R.id.LVcarreras);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, Lista); //Creamos el adapter con el tipo de lista que queremos y la Lista
        mList.setAdapter(adapter);

        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
               switch ((String)clickedViewedView.getText()){

                   case ("Licenciatura en educación"):
                       CopyReadAssets("EDU_Licenciatura_en_Educacion.pdf");
                       break;

                   case ("Licenciatura en Matemática y física"):
                       CopyReadAssets("EDU_Licenciatura_en_Matematica_y_Fisica.pdf");
                       break;

                   case ("Licenciatura en Psicopedagogia"):
                       CopyReadAssets("EDU_Licenciatura_en_Psicopedagogia.pdf");
                       break;

                   case ("Licenciatura en Musica"):
                       Uri uri =Uri.parse("http://www.uvg.edu.gt/educacion/lmusica/index.html");
                       Intent intent=new Intent(Intent.ACTION_VIEW,uri);
                       startActivity(intent);
                       break;

                   case ("Licenciatura en Quimica y Biologia"):
                       CopyReadAssets("EDU_Licenciatura_en_Quimica_y_Biologia.pdf");
                       break;

                   case ("Profesorado en Biologia y Quimica"):
                       CopyReadAssets("EDU_Profesorado_en_Biologia_y_Quimica.pdf");
                       break;

                   case ("Profesorado en Educacion Especial"):
                       CopyReadAssets("EDU_Profesorado_en_Educacion_Especial.pdf");
                       break;

                   case ("Profesorado en Educacion Primaria"):
                       CopyReadAssets("EDU_Profesorado_en_Educacion_Primaria.pdf");
                       break;

                   case ("Profesorado en Historia y CCSS"):
                       CopyReadAssets("EDU_Profesorado_en_Historia_y_CCSS.pdf");
                       break;

                   case ("Profesorado en Ingles"):
                       CopyReadAssets("EDU_Profesorado_en_Ingles.pdf");
                       break;

                   case ("Profesorado en Lengua y Literatura"):
                       CopyReadAssets("EDU_Profesorado_en_Lengua_y_Literatura.pdf");
                       break;

                   case ("Profesorado en Matematica y Fisica"):
                       CopyReadAssets("EDU_Profesorado_en_Matematica_y_Fisica.pdf");
                       break;

                   case ("Profesorado en Musica"):
                       uri =Uri.parse("http://www.uvg.edu.gt/educacion/mmusica/index.html#");
                       intent=new Intent(Intent.ACTION_VIEW,uri);
                       startActivity(intent);

                       break;

                   case ("Profesorado en Problemas Aprendizaje"):

                       CopyReadAssets("EDU_Profesorado_en_Problemas_Aprendizaje.pdf");
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
