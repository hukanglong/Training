package com.example.wanandroid.util;

public interface ResultCallBack<T> {

    void onSuccess(T bean);
    void onFail(String msg);

}
