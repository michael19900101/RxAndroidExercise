package com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aotuman.rxandroidexercise.R;

import com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Bean.NetBean;
import com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Bean.UserBean;
import com.example.aotuman.rxandroidexercise.UserLoginRxAndRetrofit.Bean.UserParam;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxLoginActivity extends AppCompatActivity {

    ApiService apiService;
    TextView tv_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_login);
        tv_text = (TextView) findViewById(R.id.tv_text);

        //构建Retrofit
        apiService = new Retrofit.Builder()
                .baseUrl("https://httpbin.org/")
                //rx与Gson混用
                .addConverterFactory(GsonConverterFactory.create())
                //rx与retrofit混用
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);

        //构建RxJava
        UserParam param = new UserParam("hensen", "123456");
        //发送param参数
        Observable.just(param)
                .flatMap(new Function<UserParam, ObservableSource<NetBean>>() {
                    @Override
                    public ObservableSource<NetBean> apply(@NonNull UserParam userParam) throws Exception {
                        //第一步：发送网络请求，获取NetBean
                        return apiService.getUserInfo(userParam.getParam1(), userParam.getParam2());
                    }
                })
                .flatMap(new Function<NetBean, ObservableSource<UserBean>>() {
                    @Override
                    public ObservableSource<UserBean> apply(@NonNull NetBean netBean) throws Exception {
                        UserBean user = new UserBean(netBean.getForm().getUsername(), netBean.getForm().getPassword());
                        //第二步：转换netBean数据为我们需要的UserBean类型
                        return Observable.just(user);
                    }
                })
                //将被观察者放在子线程，将观察者放在主线程
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserBean>() {
                    @Override
                    public void accept(@NonNull UserBean userBean) throws Exception {
                        //第三步：接收第二步发送过来的数据，进行UI更新
                        tv_text.setText("用户名：" + userBean.getUsername() + "--密码：" + userBean.getPasswrod());
                    }
                });
    }

    public void MapUser(){
        Observable.just(1).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "第"+integer+"号同学";
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                Toast.makeText(RxLoginActivity.this,s,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
