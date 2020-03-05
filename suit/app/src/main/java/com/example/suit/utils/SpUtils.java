package com.example.suit.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.suit.apps.MyApp;

/*
    封装快速存储类
*/
public class SpUtils {
    private SharedPreferences sp;
    private static SpUtils instance;

    private SpUtils(){
        sp = MyApp.myApp.getSharedPreferences("suit", Context.MODE_PRIVATE);
    }

    public static SpUtils sharedSpUtils () {
        if (instance == null) {
            instance = new SpUtils();
        }
        return instance;
    }

    /**
     * 存值
     */
    public static void put(String key, Object value) {
        SharedPreferences.Editor editor = sharedSpUtils().sp.edit();
        if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        }
        editor.commit();
    }

    /**
     * 取值
     */
    public String getString(String key){
        return sp.getString(key,"");
    }
    public int getInt(String key){
        return sp.getInt(key,0);
    }
    public Boolean getBoolean(String key){
        return sp.getBoolean(key,false);
    }
    public float getFloat(String key){
        return sp.getFloat(key,0);
    }
    public Long getLong(String key){
        return sp.getLong(key,0);
    }
}
