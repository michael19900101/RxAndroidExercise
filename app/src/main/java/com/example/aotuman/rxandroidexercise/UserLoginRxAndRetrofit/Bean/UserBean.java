package com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Bean;

import com.google.gson.Gson;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/3/30.
 */
public class UserBean {

    private String username;
    private String passwrod;

    public UserBean(String passwrod, String username) {
        this.passwrod = passwrod;
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
