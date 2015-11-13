package com.example.usuario.uvgmovil;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Diego Jacobs on 28/10/2015.
 */
public class GetImages extends AsyncTask<String, Integer, Bitmap> {
    private ProgressDialog loading;
    private ImageView mImageV;
    private Context act;
    private String link;

    public GetImages(ImageView image, Context activity,String url)
    {
        mImageV = image;
        act = activity;
        this.link = url;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        loading = ProgressDialog.show(act, "Loading...", null, true, true);
    }

    @Override
    protected void onPostExecute(Bitmap b) {
        super.onPostExecute(b);
        loading.dismiss();
        mImageV.setImageBitmap(b);
    }

    @Override
    protected Bitmap doInBackground(String... params) {
        URL url = null;
        Bitmap image = null;
        try {
            url = new URL(link);
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(image);
        return image;
    }
}
