package com.example.suit.common;

import com.example.suit.apps.MyApp;

import java.io.File;

/*
    常量
 */
public class Constant {
    public static final String PATH_DATA = MyApp.myApp.getCacheDir().getAbsolutePath() + File.separator + "data";
    public static final String PATH_CACHE = PATH_DATA + "/suit";

    public static final String BASE_SHOP_URL = "https://cdwan.cn/api/";
}
