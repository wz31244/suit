package com.example.suit.model;

import com.example.suit.common.Constant;
import com.example.suit.model.apis.MyServer;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    private static volatile HttpManager instance;
    //网络接口类
    private MyServer myServer;

    public static HttpManager getInstance() {
        if (instance == null) {
            synchronized (HttpManager.class) {
                if (instance == null) {
                    instance = new HttpManager();
                }
            }
        }
        return instance;
    }

    public Retrofit getRetroFit(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient())
                .build();
        return retrofit;
    }

    private OkHttpClient okHttpClient() {
        File file = new File(Constant.PATH_CACHE);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(new Cache(file, 100*1024*1024)) //最大100m
                .build();
        return  okHttpClient;
    }

    public MyServer getMyServer() {
        if (myServer == null) {
            synchronized (MyServer.class) {
                if (myServer == null) {
                    myServer = getRetroFit(Constant.BASE_SHOP_URL).create(MyServer.class);
                }
            }
        }
        return myServer;
    }

}
