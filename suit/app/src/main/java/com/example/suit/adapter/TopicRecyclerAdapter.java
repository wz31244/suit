package com.example.suit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.suit.R;
import com.example.suit.model.apis.TopicBean;

import java.util.List;

public class TopicRecyclerAdapter extends RecyclerView.Adapter<TopicRecyclerAdapter.ViewHolder> {
    private List<TopicBean.DataBeanX.DataBean> mData;
    private Context mContext;
    private LayoutInflater mInflater;
    private OnItemClickListener mListener;

    public TopicRecyclerAdapter(List<TopicBean.DataBeanX.DataBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public TopicRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_topic_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TopicRecyclerAdapter.ViewHolder holder, final int position) {
        TopicBean.DataBeanX.DataBean dataBean = mData.get(position);
        Glide.with(mContext).load(dataBean.getScene_pic_url()).into(holder.iv_topic);
        holder.tv_title.setText(dataBean.getTitle());
        holder.tv_subtitle.setText(dataBean.getSubtitle());
        holder.tv_price_info.setText(dataBean.getPrice_info()+"元");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(v, position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    //设置监听的执行者
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv_topic;
        public TextView tv_title;
        public TextView tv_subtitle;
        public TextView tv_price_info;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_topic = itemView.findViewById(R.id.iv_topic);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_subtitle = itemView.findViewById(R.id.tv_subtitle);
            tv_price_info = itemView.findViewById(R.id.tv_price_info);
        }
    }

}
