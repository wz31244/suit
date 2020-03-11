package com.example.suit.UI.home.topic;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.suit.R;
import com.example.suit.UI.home.base.BaseRecycleAdapter;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeTopicRecycleAdapter extends BaseRecycleAdapter<HomeBean.DataBean.TopicListBean> {


    public HomeTopicRecycleAdapter(List<HomeBean.DataBean.TopicListBean> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.layout_home_topic_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HomeBean.DataBean.TopicListBean data) {
        ImageView iv_pic = (ImageView) holder.getViewById(R.id.iv_pic);
        TextView tv_title = (TextView) holder.getViewById(R.id.tv_title);
        TextView tv_subtitle = (TextView) holder.getViewById(R.id.tv_subtitle);

        Glide.with(mContext).load(data.getScene_pic_url()).into(iv_pic);
        tv_title.setText(data.getTitle());
        tv_subtitle.setText(data.getSubtitle());
    }
}
