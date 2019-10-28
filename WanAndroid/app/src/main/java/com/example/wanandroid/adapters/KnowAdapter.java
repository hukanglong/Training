package com.example.wanandroid.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wanandroid.R;
import com.example.wanandroid.beans.KnowBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class KnowAdapter extends RecyclerView.Adapter<KnowAdapter.MyHolder> {

    private Context mContext;
    private List<KnowBean.DataBean> mDataBeans;

    public KnowAdapter(Context context, List<KnowBean.DataBean> dataBeans) {
        mContext = context;
        mDataBeans = dataBeans;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_know, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, final int i) {
        myHolder.mTitleKnow.setText(mDataBeans.get(i).getName());
        StringBuilder builder = new StringBuilder();
        List<KnowBean.DataBean.ChildrenBean> children = mDataBeans.get(i).getChildren();
        for (int j = 0; j < children.size(); j++) {
            builder.append(children.get(j).getName());
            builder.append("     ");
        }
        String string = builder.toString();
        myHolder.mMsgKnow.setText(string);

        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyOnclic.onClick(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataBeans.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_know)
        TextView mTitleKnow;
        @BindView(R.id.msg_know)
        TextView mMsgKnow;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private MyOnclic MyOnclic;

    public void setMyOnclic(KnowAdapter.MyOnclic myOnclic) {
        MyOnclic = myOnclic;
    }

    public interface MyOnclic{
        void onClick(int position);
    }

}
