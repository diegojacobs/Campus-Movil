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

}

