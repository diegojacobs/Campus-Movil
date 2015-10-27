package com.example.usuario.uvgmovil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by William on 19/10/2015.
 */
public class LoadAllUsers extends AsyncTask<String, String, String>{
    // Creating JSON Parser object
    private JSONParser jParser = new JSONParser();

    private String url_all_empresas = "http://uvgmobil.host22.com/uvgmobil/get_all_students.php";
    //private String url_all_empresas = "http://uvgmobil.host22.com/uvgmobil/get_student_by_email.php";

    // JSON Node names
    private String TAG_SUCCESS = "success";
    private  String TAG_PRODUCTS = "estudiantes";
    private  String TAG_ID = "id";
    private  String TAG_CARNET = "carnet";
    private  String TAG_NOMBRE = "nombre";
    private  String TAG_CORREO = "correo";
    private  String TAG_PASSWORD = "contraseña";
    private  String TAG_FACULTAD = "facultad";
    private  String TAG_CARRERA = "carrera";
    private  String TAG_PARQUEO = "parqueo";
    private  String TAG_MAPAC = "mapacurricular";
    private  String TAG_HORARIO = "horario";

    // products JSONArray
    private JSONArray products = null;

    private ArrayList carnets = new ArrayList();
    private ArrayList names = new ArrayList();
    private ArrayList emails = new ArrayList();
    private ArrayList passwords = new ArrayList();
    private ArrayList facultades = new ArrayList();
    private ArrayList carreras = new ArrayList();
    private ArrayList parqueos = new ArrayList();
    private ArrayList mapasC = new ArrayList();
    private ArrayList horarios = new ArrayList();;

    //Constructor
    public LoadAllUsers(){

    }

    public ArrayList getEmails() {
        return emails;
    }

    public void setEmails(ArrayList emails) {
        this.emails = emails;
    }

    public ArrayList getNames() {
        return names;
    }

    public void setNames(ArrayList names) {
        this.names = names;
    }

    public ArrayList getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList horarios) {
        this.horarios = horarios;
    }

    public ArrayList getMapasC() {
        return mapasC;
    }

    public void setMapasC(ArrayList mapasC) {
        this.mapasC = mapasC;
    }

    public ArrayList getParqueos() {
        return parqueos;
    }

    public void setParqueos(ArrayList parqueos) {
        this.parqueos = parqueos;
    }

    public ArrayList getFacultades() {
        return facultades;
    }

    public void setFacultades(ArrayList facultad) {
        this.facultades = facultad;
    }

    public ArrayList getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList passwords) {
        this.passwords = passwords;
    }

    public ArrayList getCarnets() {
        return carnets;
    }

    public void setCarnets(ArrayList carnets) {
        this.carnets = carnets;
    }

    public ArrayList getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList carreras) {
        this.carreras = carreras;
    }

    protected String doInBackground(String... args) {
        // Building Parameters
        List params = new ArrayList();

        // getting JSON string from URL
        JSONObject json = jParser.makeHttpRequest(url_all_empresas, "GET", params);

        // Check your log cat for JSON reponse
        Log.d("All Products: ", json.toString());

        try {
            // Checking for SUCCESS TAG
            int success = json.getInt(TAG_SUCCESS);

            if (success == 1) {
                // products found
                // Getting Array of Products
                products = json.getJSONArray(TAG_PRODUCTS);

                // looping through All Products
                //Log.i("ramiro", "produtos.length" + products.length());
                for (int i = 0; i < products.length(); i++) {
                    JSONObject c = products.getJSONObject(i);

                    // Storing each json item in variable
                    String id = c.getString(TAG_ID);
                    String name = c.getString(TAG_NOMBRE);
                    String cor = c.getString(TAG_CORREO);
                    String pass = c.getString(TAG_PASSWORD);
                    String facu = c.getString(TAG_FACULTAD);
                    String parqueo = c.getString(TAG_PARQUEO);
                    String carrera = c.getString(TAG_CARRERA);
                    String carnet = c.getString(TAG_CARNET);


                    carnets.add(carnet);
                    names.add(name);
                    emails.add(cor);
                    passwords.add(pass);
                    facultades.add(facu);
                    parqueos.add(parqueo);
                    carreras.add(carrera);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
