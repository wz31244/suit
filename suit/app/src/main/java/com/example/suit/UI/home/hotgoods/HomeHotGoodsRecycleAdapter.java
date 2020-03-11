package com.example.suit.UI.home.hotgoods;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.suit.R;
import com.example.suit.UI.home.base.BaseRecycleAdapter;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeHotGoodsRecycleAdapter extends BaseRecycleAdapter<HomeBean.DataBean.HotGoodsListBean> {


    public HomeHotGoodsRecycleAdapter(List<HomeBean.DataBean.HotGoodsListBean> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.layout_home_hotgoods_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HomeBean.DataBean.HotGoodsListBean data) {
        ImageView iv_brand = (ImageView) holder.getViewById(R.id.iv_pic);
        TextView tv_name = (TextView) holder.getViewById(R.id.tv_name);
        TextView tv_retail_price = (TextView) holder.getViewById(R.id.tv_retail_price);

        tv_name.setText(data.getName());
        tv_retail_price.setText(data.getRetail_price() + "元起");
        Glide.with(mContext).load(data.getList_pic_url()).into(iv_brand);
    }

}
