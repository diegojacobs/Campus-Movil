package com.example.usuario.uvgmovil;

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

/**
 * Created by Diego Jacobs on 21/05/2015.
 */
public class Pago extends ActionBarActivity {

    private ListView mList;
    private String[] Lista = {"Informacion de Pago","Consulta de Saldo","Realizar Pago"};
    ArrayAdapter<String> adapter;

    private Switch activar;
    private TextView switchStatus;
    private NotificationCompat.Builder notificacion;
    private NotificationManager mNotificationManager;
    private static final int PAGO_ID = 1;

    private UserConfigs conf;

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pago);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

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
}
