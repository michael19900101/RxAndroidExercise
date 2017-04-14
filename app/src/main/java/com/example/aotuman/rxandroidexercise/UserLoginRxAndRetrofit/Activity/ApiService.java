package com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Activity;

import com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Bean.NetBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/3/30.
 */
public interface ApiService {
    @FormUrlEncoded
    @POST("/post")
    Observable<NetBean> getUserInfo(@Field("username")String username, @Field("password")String password);
}
