package com.example.suit.UI.home.brand;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.suit.R;
import com.example.suit.UI.home.base.BaseRecycleAdapter;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeBrandRecycleAdapter extends BaseRecycleAdapter<HomeBean.DataBean.BrandListBean> {


    public HomeBrandRecycleAdapter(List<HomeBean.DataBean.BrandListBean> mDatas, Context mContext) {
        super(mDatas, mContext);
    }

    @Override
    protected int getItemLayout() {
        return R.layout.layout_home_brand_item;
    }

    @Override
    protected void bindData(BaseViewHolder holder, HomeBean.DataBean.BrandListBean data) {
        ImageView iv_brand = (ImageView) holder.getViewById(R.id.iv_brand);
        TextView tv_title = (TextView) holder.getViewById(R.id.tv_title);
        TextView tv_price_info = (TextView) holder.getViewById(R.id.tv_price_info);

        tv_title.setText(data.getName());
        tv_price_info.setText(data.getFloor_price() + "元起");
        Glide.with(mContext).load(data.getNew_pic_url()).into(iv_brand);
    }

}
