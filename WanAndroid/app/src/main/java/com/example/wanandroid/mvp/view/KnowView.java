package com.example.wanandroid.mvp.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.beans.KnowBean;

public interface KnowView extends BaseView {

    void setKnowData(KnowBean bean);

    void setMsg(String msg);
}
