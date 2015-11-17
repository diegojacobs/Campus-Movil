package com.example.usuario.uvgmovil;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



public class Calendario extends AppCompatActivity {

    private ListView mList;//, (, ), "   , (19-11-15, 12:30 pm - 1:30 pm), F-101
    private String[]Eventos={"Los eventos principales en la evolución del mundo",
            "Conmemoración del centenario del nacimiento del Dr. Heinrich Berlin",
            "Último día para completar zonas en el registro académico",
            "Último día de clases segundo ciclo",
            "Inicia inscripción ordinaria para el primer ciclo",
            "Exámenes Finales segundo ciclo",
            "Asignaciones de cursos para el primer ciclo",
            "Último día para entregar actas de evaluación final del segundo ciclo",
            "Último día para pagar la cuota de estudios, sin recargos",
            "Inscripción y realización de exámenes",
            "Inicio de actividades académicas",
            "Inicio de clases del primer ciclo"};
    ArrayAdapter<String> adapter;
    ProgressDialog mProgress;
    Intent evento;
    private Runnable MyRunnable= new Runnable()
    {
        @Override
        public void run()
        {
            //Change state here
            mProgress.hide();


        }
    };
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calendario);

        //mProgress.setMessage("Obteniendo eventos...");
        //mProgress.show();

        mList = (ListView) findViewById(R.id.LVCalendario);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, Eventos);
        mList.setAdapter(adapter);




        //Creamos el OnClick para nuestra Lista
        mList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position, long id) {
                TextView clickedViewedView = (TextView) view;
                switch ((String) clickedViewedView.getText()) {
                    case ("Los eventos principales en la evolución del mundo"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Los eventos principales en la evolución del mundo");
                        evento.putExtra("FECHA", "19-11-15");
                        evento.putExtra("HORA", "12:15 pm - 6:00 pm");
                        evento.putExtra("LUGAR", "H-201");
                        startActivity(evento);
                        break;

                    case ("Conmemoración del centenario del nacimiento del Dr. Heinrich Berlin"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Conmemoración del centenario del nacimiento del Dr. Heinrich Berlin");
                        evento.putExtra("FECHA", "19-11-15");
                        evento.putExtra("HORA", "12:15 pm - 1:30 pm");
                        evento.putExtra("LUGAR", "F-101");
                        startActivity(evento);
                        break;

                    case ("Último día para completar zonas en el registro académico"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Último día para completar zonas en el registro académico");
                        evento.putExtra("FECHA", "21-11-15");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;

                    case ("Último día de clases segundo ciclo"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Último día de clases segundo ciclo");
                        evento.putExtra("FECHA", "21-11-15");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;

                    case ("Inicia inscripción ordinaria para el primer ciclo"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Inicia inscripción ordinaria para el primer ciclo");
                        evento.putExtra("FECHA", "23-11-15 -> 12-12-15");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;

                    case ("Exámenes Finales segundo ciclo"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Exámenes Finales segundo ciclo");
                        evento.putExtra("FECHA", "23-11-15 -> 28-11-15");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;

                    case ("Asignaciones de cursos para el primer ciclo"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Asignaciones de cursos para el primer ciclo");
                        evento.putExtra("FECHA", "01-12-15 -> 13-12-15");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;


                    case ("Último día para entregar actas de evaluación final del segundo ciclo"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Último día para entregar actas de evaluación final del segundo ciclo");
                        evento.putExtra("FECHA", "05-12-15");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;


                    case ("Último día para pagar la cuota de estudios, sin recargos"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Último día para pagar la cuota de estudios, sin recargos");
                        evento.putExtra("FECHA", "17-12-15");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;


                    case ("Inscripción y realización de exámenes"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Inscripción y realización de exámenes");
                        evento.putExtra("FECHA", "04-01-16 -> 09-01-16");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;


                    case ("Inicio de actividades académicas"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Inicio de actividades académicas");
                        evento.putExtra("FECHA", "04-01-16");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;

                    case ("Inicio de clases del primer ciclo"):
                        evento = new Intent(Calendario.this, Evento.class);
                        evento.putExtra("DESCRIPCION","Inicio de clases del primer ciclo");
                        evento.putExtra("FECHA", "11-01-16");
                        evento.putExtra("HORA", "TODO EL DÍA");
                        evento.putExtra("LUGAR", "UVG");
                        startActivity(evento);
                        break;
                }
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

            Intent i = new Intent(Calendario.this, MainActivity.class); // nuevo intent para la actividad nueva, el .class es el nombre del java de la actividad
            startActivity(i);
            return true;
        }

        if (id==android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
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
}
