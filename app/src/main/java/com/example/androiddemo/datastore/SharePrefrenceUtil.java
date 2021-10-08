package com.example.androiddemo.datastore;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SharePrefrenceUtil {

    //布尔类型
    public static void writeBoolean(Context context, String fileName, String k, boolean v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }

    public static boolean readBoolean(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, false);
    }

    //int类型
    public static void writeInt(Context context, String fileName, String k, int v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt(k, v);
        editor.commit();
    }

    public static int readInt(Context context, String fileName, String k) {
        int r = 0;
        try {
            SharedPreferences preference = context.getSharedPreferences(fileName,
                    Context.MODE_PRIVATE);
            r = preference.getInt(k, 0);
        } catch (Exception e) {
           Log.d("wby", "pppexc::" + e);
        }
        return r;
    }

    public static boolean readBooleanwithDef(Context context, String fileName,
                                             String k, boolean defBool) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getBoolean(k, defBool);
    }

    public static void writeString(Context context, String fileName, String k, String v) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(k, v);
        editor.commit();
    }

    public static String readString(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        return preference.getString(k, "");
    }

    public static void remove(Context context, String fileName, String k) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.remove(k);
        editor.commit();
    }

    public static void clean(Context context, String fileName) {
        SharedPreferences preference = context.getSharedPreferences(fileName,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.clear();
        editor.commit();
    }

}
