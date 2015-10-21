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
public class LoadAllProducts extends AsyncTask<String, String, String>{
    // Progress Dialog
    private ProgressDialog pDialog;

    // Creating JSON Parser object
    JSONParser jParser = new JSONParser();

    ArrayList<HashMap<String, String>> empresaList;

    private Activity ACT;
    // url to get all products list
    //private static String url_all_empresas = "http://basededatosremotas.meximas.com/ramiroconnect/get_all_empresas.php";
    private String url_all_empresas = "http://uvgmobil.host22.com/uvgmobil/get_all_students.php";
    // JSON Node names
    private String TAG_SUCCESS = "success";
    private  String TAG_PRODUCTS = "estudiantes";
    private  String TAG_ID = "id";
    private  String TAG_NOMBRE = "nombre";
    private  String TAG_CORREO = "correo";
    // products JSONArray
    JSONArray products = null;

    ListView lista;

    //Constructor
    public LoadAllProducts(ArrayList empresaList, Activity ACT,ListView lista){
        this.empresaList=empresaList;
        this.ACT=ACT;
        this.lista = lista;
    }
    /**
     * Antes de empezar el background thread Show Progress Dialog
     * */

    /**
     * obteniendo todos los productos
     * */
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

                    // creating new HashMap
                    HashMap map = new HashMap();

                    // adding each child node to HashMap key => value
                    map.put(TAG_ID, id);
                    map.put(TAG_NOMBRE, name);
                    map.put(TAG_CORREO,cor);
                    empresaList.add(map);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * After completing background task Dismiss the progress dialog
     * **/
    protected void onPostExecute(String file_url) {
        // dismiss the dialog after getting all products
        // updating UI from Background Thread
        ACT.runOnUiThread(new Runnable() {
            public void run() {
                /**
                 * Updating parsed JSON data into ListView
                 * */
                ListAdapter adapter = new SimpleAdapter(
                        ACT,
                        empresaList,
                        R.layout.activity_portal,
                        new String[] {
                                TAG_ID,
                                TAG_NOMBRE,
                                TAG_CORREO,
                        },
                        new int[] {
                                R.id.single_post_tv_id,
                                R.id.single_post_tv_nombre,
                                R.id.single_post_tv_correo,
                        });
                // updating listview
                //setListAdapter(adapter);
                lista.setAdapter(adapter);
            }
        });
    }

}
