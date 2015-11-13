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
    private String url_all_saldos = "http://uvgmobil.host22.com/uvgmobil/get_all_saldos.php";
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

    // Tabla saldos
    private String TAG_SALDOS = "saldos";
    private String TAG_C_SALDO_VENCIDO = "concepto_saldo_vencido";
    private String TAG_SALDO_VENCIDO = "saldo_vencido";
    private String TAG_C_SALDO_P_VENCER = "concepto_saldo_por_vencer";
    private String TAG_SALDO_P_VENCER = "saldo_por_vencer";
    private String TAG_SALDO_P_CARGAR = "saldo_por_cargar";


    // products JSONArray
    private JSONArray products = null;

    // saldos JSONArray
    private JSONArray saldos = null;

    private ArrayList carnets = new ArrayList();
    private ArrayList names = new ArrayList();
    private ArrayList emails = new ArrayList();
    private ArrayList passwords = new ArrayList();
    private ArrayList facultades = new ArrayList();
    private ArrayList carreras = new ArrayList();
    private ArrayList parqueos = new ArrayList();
    private ArrayList mapasC = new ArrayList();
    private ArrayList horarios = new ArrayList();;

    // ArrayList Saldos
    private ArrayList carnets_saldos = new ArrayList();
    private ArrayList c_saldo_vencido = new ArrayList();
    private ArrayList saldo_vencido = new ArrayList();
    private ArrayList c_saldo_p_vencer = new ArrayList();
    private ArrayList saldo_p_vencer = new ArrayList();
    private ArrayList saldo_p_cargar = new ArrayList();


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

    // Saldos
    public ArrayList getCarnets_saldos() {
        return carnets_saldos;
    }

    public void setCarnets_saldos(ArrayList carnets_saldos) {
        this.carnets_saldos = carnets_saldos;
    }

    public ArrayList getC_saldo_vencido() {
        return c_saldo_vencido;
    }

    public void setC_saldo_vencido(ArrayList c_saldo_vencido) {
        this.c_saldo_vencido = c_saldo_vencido;
    }

    public ArrayList getSaldo_vencido() {
        return saldo_vencido;
    }

    public void setSaldo_vencido(ArrayList saldo_vencido) {
        this.saldo_vencido = saldo_vencido;
    }

    public ArrayList getC_saldo_p_vencer() {
        return c_saldo_p_vencer;
    }

    public void setC_saldo_p_vencer(ArrayList c_saldo_p_vencer) {
        this.c_saldo_p_vencer = c_saldo_p_vencer;
    }

    public ArrayList getSaldo_p_vencer() {
        return saldo_p_vencer;
    }

    public void setSaldo_p_vencer(ArrayList saldo_p_vencer) {
        this.saldo_p_vencer = saldo_p_vencer;
    }

    public ArrayList getSaldo_p_cargar() {
        return saldo_p_cargar;
    }

    public void setSaldo_p_cargar(ArrayList saldo_p_cargar) {
        this.saldo_p_cargar = saldo_p_cargar;
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

        // Saldos
        // Building Parameters
        params = new ArrayList();

        // getting JSON string from URL
        json = jParser.makeHttpRequest(url_all_saldos, "GET", params);

        // Check your log cat for JSON reponse
        Log.d("All Saldos: ", json.toString());

        try {
            // Checking for SUCCESS TAG
            int success = json.getInt(TAG_SUCCESS);

            if (success == 1) {
                // Saldos found
                // Getting Array of Products
                saldos = json.getJSONArray(TAG_SALDOS);

                // looping through All Saldos
                for (int i = 0; i < saldos.length(); i++) {

                    JSONObject c = saldos.getJSONObject(i);

                    // Storing each json item in variable
                    String s_carnet = c.getString(TAG_CARNET);
                    String s_c_saldo_vencido = c.getString(TAG_C_SALDO_VENCIDO);
                    String s_saldo_vencido = c.getString(TAG_SALDO_VENCIDO);
                    String s_c_saldo_p_vencer = c.getString(TAG_C_SALDO_P_VENCER);
                    String s_saldo_p_vencer = c.getString(TAG_SALDO_P_VENCER);
                    String s_saldo_p_cargar = c.getString(TAG_SALDO_P_CARGAR);

                    carnets_saldos.add(s_carnet);
                    c_saldo_vencido.add(s_c_saldo_vencido);
                    saldo_vencido.add(s_saldo_vencido);
                    c_saldo_p_vencer.add(s_c_saldo_p_vencer);
                    saldo_p_vencer.add(s_saldo_p_vencer);
                    saldo_p_cargar.add(s_saldo_p_cargar);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "finish";
    }

}
