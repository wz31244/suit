package com.example.suit.model;

import android.util.Log;

import com.example.suit.common.Constant;
import com.example.suit.model.apis.MyServer;
import com.example.suit.utils.SpUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
                .addInterceptor(new LoggingInterceptor())
                .addInterceptor(new HeadInterceptor())
                //.addInterceptor(new NetworkInterceptor())
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

    public class  LoggingInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            long time = System.nanoTime();
            Request request = chain.request();
            Response response = chain.proceed(request);
            long now = System.nanoTime();
            Log.i("suit:request", String.format("request [%s] return in %d ms",response.request().url(), (now-time)/1000));
            return response;
        }
    }

    /*
        设置请求头
     */
    public class HeadInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request().newBuilder()
                    .addHeader("Client-Type", "ANDROID")
                    .addHeader("X-Nideshop-Token", SpUtils.sharedSpUtils().getString("token"))
                    .build();
            return chain.proceed(request);
        }
    }

    /*
        网络拦截器
        通过本地缓存减少访问次数
     */
    static class NetworkInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            //待完成

            return null;
        }
    }
}
