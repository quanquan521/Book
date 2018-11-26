package com.hpw.mvpframe.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.hpw.mvpframe.CoreConstants;



public class SpUtil {
    static SharedPreferences prefs;
    private static final boolean DEFAULT_FIRST_ENTER = true;
    private static final String DEFAULT_USERID = "";


    public static void init(Context context) {
        prefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static int getThemeIndex(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getInt("ThemeIndex", 9);
    }

    public static void setThemeIndex(Context context, int index) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putInt("ThemeIndex", index).apply();
    }
    public static boolean getFirstEnter() {
        return prefs.getBoolean(CoreConstants.SP_AUTO_CACHE, DEFAULT_FIRST_ENTER);
    }

    public static void setFirstEnter(boolean state) {
        prefs.edit().putBoolean(CoreConstants.SP_AUTO_CACHE, state).apply();
    }
    public static String getUserID() {
        return prefs.getString(CoreConstants.SP_USERID, DEFAULT_USERID);
    }

    public static void setUserID(Context context,String userID) {
        prefs.edit().putString(CoreConstants.SP_USERID, userID).apply();
    }



}

