package com.example.suit.UI.home_fragments.newgoods;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.suit.R;
import com.example.suit.UI.home_fragments.base.BaseRecycleAdapter;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeNewGoodsRecycleAdapter extends BaseRecycleAdapter<HomeBean.DataBean.NewGoodsListBean> {


    public HomeNewGoodsRecycleAdapter(List<HomeBean.DataBean.NewGoodsListBean> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.layout_home_newgoods_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HomeBean.DataBean.NewGoodsListBean data) {
        ImageView iv_brand = (ImageView) holder.getViewById(R.id.iv_pic);
        TextView tv_title = (TextView) holder.getViewById(R.id.tv_name);
        TextView tv_price_info = (TextView) holder.getViewById(R.id.tv_retail_price);

        tv_title.setText(data.getName());
        tv_price_info.setText(data.getRetail_price() + "元起");
        Glide.with(mContext).load(data.getList_pic_url()).into(iv_brand);
    }

}
