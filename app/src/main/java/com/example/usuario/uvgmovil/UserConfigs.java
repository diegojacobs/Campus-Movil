package com.example.usuario.uvgmovil;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DanielAlejandro on 8/09/2015.
 */
public class UserConfigs {

    private final String SHARED_PREFS_FILE = "UserPrefs";
    private final String KEY_NOTIFICATIONS = "Notifications";
    private final String EMAIL = "correo";
    private final String CARNET  = "0";
    private final String FACULTAD = "fac";
    private final String CARRERA = "car";
    private final String PARQUEO = "par";
    private final String NAME = "name";
    private final String PASSWORD = "pass";

    private Context mContext;

    public UserConfigs(Context mContext) {
        this.mContext = mContext;
    }

    private SharedPreferences getSettings()
    {
        return mContext.getSharedPreferences(SHARED_PREFS_FILE, 0);
    }

    public boolean isNotificationsON()
    {
        return getSettings().getBoolean(KEY_NOTIFICATIONS, true);
    }

    public void setNotifications(boolean val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putBoolean(KEY_NOTIFICATIONS, val);
        editor.commit();
    }

    public void setEmail(String val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(EMAIL, val);
        editor.commit();
    }

    public String getEmail()
    {
        return getSettings().getString(EMAIL,"correo");
    }

    public void setCarnet(String val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(CARNET, val);
        editor.commit();
    }

    public String getCarnet()
    {
        return getSettings().getString(CARNET,"0");
    }

    public void setCarrera(String val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(CARRERA, val);
        editor.commit();
    }

    public String getCarrera()
    {
        return getSettings().getString(CARRERA,"car");
    }

    public void setFacultad(String val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(FACULTAD, val);
        editor.commit();
    }

    public String getFacultad()
    {
        return getSettings().getString(FACULTAD,"fac");
    }

    public void setName(String val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(NAME, val);
        editor.commit();
    }

    public String getName()
    {
        return getSettings().getString(NAME,"name");
    }


    public void setPassword(String val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(PASSWORD, val);
        editor.commit();
    }

    public String getPassword()
    {
        return getSettings().getString(PASSWORD,"pass");
    }


    public void setParqueo(String val)
    {
        SharedPreferences.Editor editor = getSettings().edit();
        editor.putString(PARQUEO, val);
        editor.commit();
    }

    public String getParqueo()
    {
        return getSettings().getString(PARQUEO,"par");
    }
}

