package com.aotuman.mcnews.module.news.model;

import com.aotuman.mcnews.bean.NeteastNewsSummary;
import com.aotuman.mcnews.callback.RequestCallback;
import com.aotuman.mcnews.http.manager.RetrofitManager;
import com.aotuman.mcnews.http.service.Api;
import com.aotuman.mcnews.http.service.HostType;
import com.socks.library.KLog;

import org.reactivestreams.Subscription;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;


/**
 * ClassName: INewsListInteractorImpl<p>
 * Author: oubowu<p>
 * Fuction: 新闻列表Model层接口实现<p>
 * CreateDate: 2016/2/17 21:02<p>
 * UpdateUser: <p>
 * UpdateDate: <p>
 */
public class INewsListInteractorImpl implements INewsListInteractor<List<NeteastNewsSummary>> {

    @Override
    public Subscription requestNewsList(final RequestCallback<List<NeteastNewsSummary>> callback, String type, final String id, int startPage) {
        KLog.e("新闻列表：" + type + ";" + id);
        return RetrofitManager.getInstance(HostType.NETEASE_NEWS_VIDEO)
                .getNewsListObservable(type, id, startPage)
                .flatMap(new Function<Map<String, List<NeteastNewsSummary>>, ObservableSource<NeteastNewsSummary>>() {
                    @Override
                    public ObservableSource<NeteastNewsSummary> apply(@NonNull Map<String, List<NeteastNewsSummary>> map) throws Exception {
                        if (id.equals(Api.HOUSE_ID)) {
                            // 房产实际上针对地区的它的id与返回key不同
                            return Observable.fromIterable(map.get("北京"));
                        }
                        return Observable.fromIterable(map.get(id));
                    }
                })
//                .toSortedList(new Func2<NeteastNewsSummary, NeteastNewsSummary, Integer>() {
//                    // 按时间先后排序
//                    @Override
//                    public Integer call(NeteastNewsSummary neteastNewsSummary, NeteastNewsSummary neteastNewsSummary2) {
//                        return neteastNewsSummary2.ptime.compareTo(neteastNewsSummary.ptime);
//                    }
//                })
                .toSortedList(new BiFunction<NeteastNewsSummary, NeteastNewsSummary, Integer>() {
                    @Override
                    public Integer apply(@NonNull NeteastNewsSummary neteastNewsSummary, @NonNull NeteastNewsSummary neteastNewsSummary2) throws Exception {
                        return neteastNewsSummary2.ptime.compareTo(neteastNewsSummary.ptime);
                    }
                })
                .subscribe(new BaseSubscriber<>(callback));
    }
}
