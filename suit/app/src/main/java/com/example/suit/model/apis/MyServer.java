package com.example.suit.model.apis;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface MyServer {
    @GET("index")
    Flowable<HomeBean> getHome();
}
