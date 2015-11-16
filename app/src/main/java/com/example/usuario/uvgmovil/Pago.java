package com.example.usuario.uvgmovil;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.view.View.OnClickListener;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Pago extends AppCompatActivity {
    private ListView mList;
    private String[] Lista = {"Informacion de Pago","Consulta de Saldo"};
    ArrayAdapter<String> adapter;

    private Switch activar;
    private TextView switchStatus;
    private NotificationCompat.Builder notificacion;
    private NotificationManager mNotificationManager;
    private static final int PAGO_ID = 1;

    private UserConfigs conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pago);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mList = (ListView)findViewById(R.id.LVpago);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,Lista);
        mList.setAdapter(adapter);
        conf = new UserConfigs(this);

        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                if (clickedViewedView.getText() == "Informacion de Pago") {
                    startActivity(new Intent(Pago.this, InfoPago.class));
                }
                if (clickedViewedView.getText() == "Consulta de Saldo") {
                    //validamos que haya hecho login
                    UserConfigs conf = new UserConfigs(Pago.this);
                    if (!conf.getEmail().equals("correo")) {
                        startActivity(new Intent(Pago.this, ConsultaSaldo.class));

                    } else {
                        Intent i = new Intent(Pago.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
                        startActivity(i);
                    }
                }
            }
        });

        switchStatus = (TextView) findViewById(R.id.textView13);
        activar = (Switch) findViewById(R.id.switch1);
        notificacion = new NotificationCompat.Builder(Pago.this);
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Personalizacion de notificacion
        notificacion.setSmallIcon(R.drawable.icono); // Icono pequeño superior
        notificacion.setTicker("PAGO UVG"); // Mensaje cuando aparece
        notificacion.setWhen(System.currentTimeMillis()); // Hora que mostramos en la notificacion
        notificacion.setContentTitle("UVG");
        notificacion.setVibrate(new long[] {100, 250, 100, 500});
        notificacion.setContentText("Le recordamos que debe cancelar su colegiatura universitaria");

        // Asignar actividad que realiza cuando se presiona la notificacion
        Intent notIntent = new Intent(Pago.this, Pago.class);
        PendingIntent contIntent = PendingIntent.getActivity(Pago.this, 0, notIntent, 0);

        notificacion.setContentIntent(contIntent);

        //set the switch to last value saved
        activar.setChecked(conf.isNotificationsON());

        activar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    // send notification
                    mNotificationManager.notify(PAGO_ID,notificacion.build());
                    // status notificaciones
                    switchStatus.setText("Las notificaciones estan activadas");
                    // guardar estado
                    conf.setNotifications(true);
                }
                else
                {
                    // desable notification
                    mNotificationManager.cancel(PAGO_ID);
                    // status notificaciones
                    switchStatus.setText("Las notificaciones estan desactivadas");
                    // guardar estado
                    conf.setNotifications(false);
                }
            }
        });

        //check the current state before we display the screen
        if (activar.isChecked())
        {
            switchStatus.setText("Las notificaciones estan activadas");
        }
        else
        {
            switchStatus.setText("Las notificaciones estan desactivadas");
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

            Intent i = new Intent(Pago.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}

