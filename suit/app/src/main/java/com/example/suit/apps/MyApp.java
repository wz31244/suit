package com.example.suit.apps;

import android.app.Application;

import com.example.suit.model.apis.LoginBean;

public class MyApp extends Application {
    public static MyApp myApp;
    public static LoginBean login;//登录信息

    @Override
    public void onCreate() {
        super.onCreate();
        myApp = this;
    }

    //登录成功，保存登录信息
    public void login(LoginBean loginBean) {
        login = loginBean;
    }

    //注销用户，将登陆信息置为null
    public void logout(LoginBean loginBean) {
        login = null;
    }
}
