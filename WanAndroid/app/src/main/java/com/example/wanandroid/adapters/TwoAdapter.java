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
import com.example.wanandroid.beans.OfficialBean;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.MyHolder> {

    private Context mContext;
    private ArrayList<OfficialBean.DataBean.DatasBean> mList;

    public TwoAdapter(Context context, ArrayList<OfficialBean.DataBean.DatasBean> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_two, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {

        myHolder.mTitleTwo.setText("公众号/"+mList.get(i).getAuthor());
        myHolder.mMsgTwo.setText(mList.get(i).getTitle());
        myHolder.mTexttimeTwo.setText(mList.get(i).getNiceShareDate());

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

        @BindView(R.id.title_two)
        TextView mTitleTwo;
        @BindView(R.id.msg_two)
        TextView mMsgTwo;
        @BindView(R.id.like_two)
        ImageView mLikeTwo;
        @BindView(R.id.texttime_two)
        TextView mTexttimeTwo;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public MyOnclick MyOnclick;

    public void setMyOnclick(TwoAdapter.MyOnclick myOnclick) {
        MyOnclick = myOnclick;
    }

    public interface MyOnclick{
        void onClick(int position);
    }

}
