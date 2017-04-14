package com.example.aotuman.rxandroidexercise.CartMegerRxAndRetrofit;

import com.example.aotuman.rxandroidexercise.CartMegerRxAndRetrofit.Bean.NetBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/4/2.
 */
public interface ApiService {

    @GET("/get")
    Observable<NetBean> getCartList (@Query("shopName")String shopName);
}
