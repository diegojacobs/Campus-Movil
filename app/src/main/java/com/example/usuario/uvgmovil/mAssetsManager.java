package com.example.usuario.uvgmovil;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Diego Jacobs on 31/08/2015.
 */
public class mAssetsManager extends ActionBarActivity{

    private String filename;
    private Intent intent;

    @Override
    public Intent getIntent() {
        return intent;
    }

    @Override
    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public mAssetsManager(String file)
    {
        this.filename = file;
    }

    public void CopyReadAssets()
    {
        AssetManager assetManager = getAssets();

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), filename);
        try
        {
            in = assetManager.open(filename);
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

        intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/" + filename),
                "application/pdf");
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
}
