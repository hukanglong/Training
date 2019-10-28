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
import com.example.wanandroid.beans.ProDateilBean;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProAdapter extends RecyclerView.Adapter<ProAdapter.MyHolder> {

    private Context mContext;
    private List<ProDateilBean.DataBean.DatasBean> mList;

    public ProAdapter(Context context, List<ProDateilBean.DataBean.DatasBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_pro, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {

        Glide.with(mContext).load(mList.get(i).getEnvelopePic()).into(myHolder.mImgsPro);
        myHolder.mTitlePro.setText(mList.get(i).getTitle());
        myHolder.mMsgPro.setText(mList.get(i).getDesc());
        myHolder.mTexttimePro.setText(mList.get(i).getNiceShareDate());
        myHolder.mAuthroPro.setText(mList.get(i).getAuthor());

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOnclick.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgs_pro)
        ImageView mImgsPro;
        @BindView(R.id.title_pro)
        TextView mTitlePro;
        @BindView(R.id.msg_pro)
        TextView mMsgPro;
        @BindView(R.id.texttime_pro)
        TextView mTexttimePro;
        @BindView(R.id.authro_pro)
        TextView mAuthroPro;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public MyOnclick MyOnclick;

    public void setMyOnclick(MyOnclick myOnclick) {
        MyOnclick = myOnclick;
    }

    public interface MyOnclick{
        void onClick(int position);
    }

}
