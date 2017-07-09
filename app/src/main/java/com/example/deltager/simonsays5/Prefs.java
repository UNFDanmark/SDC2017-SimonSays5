package com.example.deltager.simonsays5;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by deltager on 09-07-17.
 */

public final class Prefs {

    public static int getInt(Context context, String key){
        return context.getSharedPreferences("com.example.deltager.simonsays5.prefs", Context.MODE_PRIVATE).getInt(key, 0);
    }

    public static void setInt(Context context, String key, int value){
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.commit();
    }

    private static SharedPreferences.Editor getEditor(Context context){
        return context.getSharedPreferences("com.example.deltager.simonsays5.prefs", Context.MODE_PRIVATE).edit();
    }

    //Presets funtions
    public static int getHighscore(Context context){
        return getInt(context, "Highscore");
    }

    public static void setHighscore(Context context, int score){
        setInt(context, "Highscore", score);
    }
}
