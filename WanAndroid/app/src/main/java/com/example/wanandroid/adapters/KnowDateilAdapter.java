package com.example.wanandroid.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.beans.KnowDateilBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowDateilAdapter extends RecyclerView.Adapter<KnowDateilAdapter.MyHolder> {

    private Context mContext;
    private ArrayList<KnowDateilBean.DataBean.DatasBean> mList;

    public KnowDateilAdapter(Context context, ArrayList<KnowDateilBean.DataBean.DatasBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_know_dateil, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.mTitleKnow.setText(mList.get(i).getSuperChapterName()+"/"+mList.get(i).getChapterName());
        myHolder.mMsgKnow.setText(mList.get(i).getTitle());
        myHolder.mTexttimeKnow.setText(mList.get(i).getNiceDate());

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
        @BindView(R.id.title_know)
        TextView mTitleKnow;
        @BindView(R.id.msg_know)
        TextView mMsgKnow;
        @BindView(R.id.like_know)
        ImageView mLikeKnow;
        @BindView(R.id.texttime_know)
        TextView mTexttimeKnow;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public MyOnclick MyOnclick;

    public void setMyOnclick(KnowDateilAdapter.MyOnclick myOnclick) {
        MyOnclick = myOnclick;
    }

    public interface MyOnclick{
        void onClick(int position);
    }

}
