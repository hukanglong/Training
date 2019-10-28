package com.example.wanandroid.ui.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.adapters.VpTitlesAdapter;
import com.example.wanandroid.base.BaseFragment;
import com.example.wanandroid.beans.KnowBean;
import com.example.wanandroid.ui.fragments.KnowDateilFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowDateilActivity extends AppCompatActivity {

    @BindView(R.id.title_know)
    TextView mTitleKnow;
    @BindView(R.id.tab_know)
    TabLayout mTabKnow;
    @BindView(R.id.vp_know)
    ViewPager mVpKnow;
    private ArrayList<String> mTabs;
    private String mName;
    private ArrayList<BaseFragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_dateil);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
    }

    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getMsg(KnowBean.DataBean dataBean){
        mName = dataBean.getName();
        mTabs = new ArrayList<>();
        for (int i = 0; i < dataBean.getChildren().size(); i++) {
            mTabs.add(dataBean.getChildren().get(i).getName());
        }
        mFragments = new ArrayList<>();
        for (int i = 0; i < mTabs.size(); i++) {
            mFragments.add(KnowDateilFragment.newInstance(dataBean.getChildren().get(i).getId()));
        }
    }

    private void initView() {
        mTitleKnow.setText(mName);


        VpTitlesAdapter vpTitlesAdapter = new VpTitlesAdapter(getSupportFragmentManager(), this, mFragments, mTabs);
        mVpKnow.setAdapter(vpTitlesAdapter);
        mTabKnow.setupWithViewPager(mVpKnow);
    }
}
