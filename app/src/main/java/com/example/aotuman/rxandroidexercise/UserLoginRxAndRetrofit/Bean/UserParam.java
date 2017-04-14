package com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Bean;

import com.google.gson.Gson;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/3/30.
 */
public class UserParam {

    private String param1;
    private String param2;

    public UserParam(String param1, String param2) {
        this.param1 = param1;
        this.param2 = param2;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
