package com.example.suit.model.apis;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MyServer {
    @GET("index")
    Flowable<HomeBean> getHome();

    @GET("topic/list")
    Flowable<TopicBean> getTopic(@Query("page") int page, @Query("size") int size);

    @POST("auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> postLogin(@Field("nickname") String nickname, @Field("password") String password);

    @POST("auth/register")
    @FormUrlEncoded
    Flowable<RegisterBean> postRegister(@Field("nickname") String nickname, @Field("password") String password);


}
