package com.example.wanandroid.mvp.view;

import com.example.wanandroid.base.BaseView;
import com.example.wanandroid.beans.OfficialBean;

public interface TwoView extends BaseView {

    void setData(OfficialBean bean);

    void setMsg(String msg);

}
