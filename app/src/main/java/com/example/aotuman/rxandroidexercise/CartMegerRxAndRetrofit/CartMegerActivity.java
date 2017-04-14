package com.example.aotuman.rxandroidexercise.CartMegerRxAndRetrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aotuman.rxandroidexercise.R;

import com.example.aotuman.rxandroidexercise.CartMegerRxAndRetrofit.Bean.NetBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CartMegerActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button;
    private ApiService apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_meger);
        apiService = new Retrofit.Builder()
                .baseUrl("http://httpbin.org/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Observable.merge(getDataForLocal(), getDataForNet()).subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {}
            @Override
            public void onNext(List<String> strings) {
                for (String str : strings){
                    System.out.println(str);
                }
            }
            @Override
            public void onError(Throwable e) {}
            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
    private Observable<List<String>> getDataForLocal() {
        List<String> list = new ArrayList<>();
        list.add("购物车物品一");
        list.add("购物车物品二");
        return Observable.just(list);
    }
    private Observable<List<String>> getDataForNet() {
        return Observable.just("购物车物品三").flatMap(new Function<String, ObservableSource<NetBean>>() {
            @Override
            public ObservableSource<NetBean> apply(@NonNull String s) throws Exception {
                return apiService.getCartList(s);
            }
        }).flatMap(new Function<NetBean, ObservableSource<List<String>>>() {
            @Override
            public ObservableSource<List<String>> apply(@NonNull NetBean netBean) throws Exception {
                String shop = netBean.get_$Args257().getShopName();
                List<String> list = new ArrayList<>();
                list.add(shop);
                return Observable.just(list);
            }
        }).subscribeOn(Schedulers.io());
    }
}
