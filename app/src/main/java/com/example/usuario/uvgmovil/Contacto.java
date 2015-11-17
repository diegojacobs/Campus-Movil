package com.example.usuario.uvgmovil;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Contacto extends AppCompatActivity {
    TextView mTxtVSG;
    TextView mTxtVFI;
    TextView mTxtVFE;
    TextView mTxtVFCS;
    TextView mTxtVFCH;
    TextView mTxtVtelSG;
    TextView mTxtVtelFI;
    TextView mTxtVtelFE;
    TextView mTxtVtelFCH;
    TextView mTxtVtelFCS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Telefono Secretaria General
        mTxtVtelSG = (TextView) findViewById(R.id.TVtelSG);

        mTxtVtelSG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:2368 8307"));
                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sIntent);
            }
        });


        //Correo Secretaria general
        mTxtVSG = (TextView) findViewById(R.id.TVmailSG);
        mTxtVSG.setText(Html.fromHtml("<a href=\"mailto:svsuruy@uvg.edu.gt\">svsuruy@uvg.edu.gt</a>"));
        mTxtVSG.setMovementMethod(LinkMovementMethod.getInstance());

        //Correo Facultad Ingenieria
        mTxtVFI = (TextView) findViewById(R.id.TVmailFI);
        mTxtVFI.setText(Html.fromHtml("<a href=\"mailto:ingenieria@uvg.edu.gt\">ingenieria@uvg.edu.gt</a>"));
        mTxtVFI.setMovementMethod(LinkMovementMethod.getInstance());

        //Telefono Facultad de Ingenieria
        mTxtVtelFI = (TextView) findViewById(R.id.TVtelFI);

        mTxtVtelFI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:2368 8328"));
                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sIntent);
            }
        });

        //Correo Facultad Educación
        mTxtVFE = (TextView) findViewById(R.id.TVmailFE);
        mTxtVFE.setText(Html.fromHtml("<a href=\"mailto:fac-educ@uvg.edu.gt\">fac-educ@uvg.edu.gt</a>"));
        mTxtVFE.setMovementMethod(LinkMovementMethod.getInstance());

        //Telefono Facultad de Educación
        mTxtVtelFE = (TextView) findViewById(R.id.TVtelFE);

        mTxtVtelFE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:2368 8304"));
                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sIntent);
            }
        });

        //Correo Facultad Ciencias Sociales
        mTxtVFCS = (TextView) findViewById(R.id.TVmailFCS);
        mTxtVFCS.setText(Html.fromHtml("<a href=\"mailto:facccss@uvg.edu.gt\">facccss@uvg.edu.gt</a>"));
        mTxtVFCS.setMovementMethod(LinkMovementMethod.getInstance());

        //Telefono Facultad de Ciencias Sociales
        mTxtVtelFCS = (TextView) findViewById(R.id.TVtelFCS);

        mTxtVtelFCS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:2369 5233"));
                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sIntent);
            }
        });

        //Correo Facultad Ciencias y Humanidades
        mTxtVFCH = (TextView) findViewById(R.id.TVmailFCH);
        mTxtVFCH.setText(Html.fromHtml("<a href=\"mailto:faccchh@uvg.edu.gt\">faccchh@uvg.edu.gt</a>"));
        mTxtVFCH.setMovementMethod(LinkMovementMethod.getInstance());

        //Telefono Facultad de Ciencias y Humanidades
        mTxtVtelFCH = (TextView) findViewById(R.id.TVtelFCH);

        mTxtVtelFCH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:2368 8331"));
                sIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(sIntent);
            }
        });
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

            Intent i = new Intent(Contacto.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
