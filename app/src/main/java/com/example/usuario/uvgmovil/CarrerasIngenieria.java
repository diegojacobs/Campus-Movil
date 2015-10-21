package com.example.usuario.uvgmovil;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
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
public class CarrerasIngenieria extends AppCompatActivity {

    private ListView mList;
    private final String[] Lista = {"Ciencias de la Administración","Ciencias de Alimentos","Ciencias de la computación",
            "Civil","Electrónica","Industrial","Mecánica","Mecánica Industrial","Mecatrónica","Química","Química industrial"};
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
                    case ("Ciencias de la Administración"):
                        //abre el asset dentro del pdf viewer del telefono
                        CopyReadAssets("Ciencias_de_la_Administracion.pdf");
                        break;

                    case ("Ciencias de Alimentos"):
                        CopyReadAssets("ING_Ciencias_de_los_Alimentos.pdf");
                        break;

                    case ("Ciencias de la computación"):
                        CopyReadAssets("ING_Computacion.pdf");
                        break;

                    case ("Civil"):
                        CopyReadAssets("ING_Ingenieria_Civil.pdf");
                        break;

                    case ("Electrónica"):
                        CopyReadAssets("ING_Ingenieria_Electronica.pdf");
                        break;

                    case ("Industrial"):
                        CopyReadAssets("ING_Ingenieria_Industrial.pdf");
                        break;

                    case ("Mecánica"):
                        CopyReadAssets("ING_Ingenieria_Mecanica.pdf");
                        break;

                    case ("Mecánica Industrial"):
                        CopyReadAssets("ING_Ingenieria_Mecanica-industrial.pdf");
                        break;

                    case ("Mecatrónica"):
                        CopyReadAssets("ING_Ingenieria_Mecatronica.pdf");
                        break;

                    case ("Química"):
                        CopyReadAssets("ING_Ingenieria_Quimica.pdf");
                        break;

                    case ("Química industrial"):
                        CopyReadAssets("ING_Ingenieria-Quimica-Industrial.pdf");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
