package com.example.wanandroid.mvp.model;

import com.example.wanandroid.base.BaseModel;
import com.example.wanandroid.beans.ProBean;
import com.example.wanandroid.beans.ProDateilBean;
import com.example.wanandroid.util.ApiService;
import com.example.wanandroid.util.ResultCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProDateilModel extends BaseModel {

    public void getPro(int id,int cid,final ResultCallBack<ProDateilBean> callBack){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<ProDateilBean> pro = apiService.getProDateil(id,cid);
        pro.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ProDateilBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ProDateilBean proBean) {
                        callBack.onSuccess(proBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
