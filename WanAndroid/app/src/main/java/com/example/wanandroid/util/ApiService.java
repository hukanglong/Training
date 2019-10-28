package com.example.wanandroid.util;

import com.example.wanandroid.beans.AuthorBean;
import com.example.wanandroid.beans.BannerBean;
import com.example.wanandroid.beans.KnowBean;
import com.example.wanandroid.beans.KnowDateilBean;
import com.example.wanandroid.beans.ListBean;
import com.example.wanandroid.beans.OfficialBean;
import com.example.wanandroid.beans.ProBean;
import com.example.wanandroid.beans.ProDateilBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    //https://www.wanandroid.com/banner/json
    //https://www.wanandroid.com/article/list/0/json
    //https://www.wanandroid.com/tree/json
    //https://www.wanandroid.com/navi/json
    //https://www.wanandroid.com/project/tree/json
    //https://www.wanandroid.com/project/list/1/json?cid=294
    //https://www.wanandroid.com/article/list/0/json?cid=169
    public String url = "https://www.wanandroid.com/";


    @GET("banner/json")
    Observable<BannerBean> getData();

    @GET("article/list/{id}/json")
    Observable<ListBean> getList(@Path("id") int id);

    @GET("tree/json")
    Observable<KnowBean> getKnowData();

    @GET("navi/json")
    Observable<AuthorBean> getAuthorData();

    @GET("article/list/{id}/json?")
    Observable<OfficialBean> getTwoData(@Path("id") int id, @Query("author") String name);

    @GET("project/tree/json")
    Observable<ProBean> getPro();

    @GET("project/list/{id}/json?")
    Observable<ProDateilBean> getProDateil(@Path("id") int id, @Query("cid") int cid);

    @GET("article/list/{id}/json?")
    Observable<KnowDateilBean> getKnowDateil(@Path("id") int id, @Query("cid") int cid);
}
