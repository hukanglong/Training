package com.example.wanandroid.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wanandroid.R;
import com.example.wanandroid.beans.ListBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<String> mBanners;
    private ArrayList<ListBean.DataBean.DatasBean> mList;

    public HomeAdapter(Context context, ArrayList<String> banners, ArrayList<ListBean.DataBean.DatasBean> list) {
        mContext = context;
        mBanners = banners;
        mList = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i == 1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_banner, null);
            return new MyHolder1(view);
        } else {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_list, null);
            return new MyHolder2(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (getItemViewType(i) == 1){
            MyHolder1 myHolder1 = (MyHolder1) viewHolder;
            myHolder1.mBanner.setImages(mBanners);
            myHolder1.mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                    Glide.with(mContext).load(path).into(imageView);
                }
            });
            myHolder1.mBanner.start();
        }else {
            final int index = i-1;
            MyHolder2 myHolder2 = (MyHolder2) viewHolder;
            myHolder2.mTitleHome.setText(mList.get(index).getChapterName());
            myHolder2.mMsgHome.setText(mList.get(index).getTitle());
            myHolder2.mTexttimeHome.setText(mList.get(index).getNiceDate());

            myHolder2.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MyOnclick.onClick(index);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 1;
        } else {
            return 2;
        }
    }

    class MyHolder1 extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        Banner mBanner;

        public MyHolder1(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    class MyHolder2 extends RecyclerView.ViewHolder {
        @BindView(R.id.img_home)
        ImageView mImgHome;
        @BindView(R.id.title_home)
        TextView mTitleHome;
        @BindView(R.id.msg_home)
        TextView mMsgHome;
        @BindView(R.id.like_home)
        ImageView mLikeHome;
        @BindView(R.id.time_home)
        ImageView mTimeHome;
        @BindView(R.id.texttime_home)
        TextView mTexttimeHome;
        public MyHolder2(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public MyOnclick MyOnclick;

    public void setMyOnclick(HomeAdapter.MyOnclick myOnclick) {
        MyOnclick = myOnclick;
    }

    public interface MyOnclick{
        void onClick(int position);
    }

}
