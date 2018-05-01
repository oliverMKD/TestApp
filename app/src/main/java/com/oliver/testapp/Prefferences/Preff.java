package com.oliver.testapp.Prefferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Preff {
    private static SharedPreferences getPreferences(Context c){
        return c.getApplicationContext().getSharedPreferences("ssaveInt", Activity.MODE_PRIVATE);
    }

    public static void  setInt (int i , Context c){
        getPreferences(c).edit().putInt("save",i).apply();
    }

    public static int  getInt (Context c){
        return getPreferences(c).getInt("save",0);
    }

    public static void removeInt(Context c) {
        getPreferences(c).edit().remove("save").apply();
    }
}
