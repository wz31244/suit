package com.example.suit.UI.home_fragments.brand;

import com.example.suit.R;
import com.example.suit.UI.home_fragments.base.HomeBaseFragment;
import com.example.suit.base.BaseRecycleAdapter;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeBrandFragment extends HomeBaseFragment<HomeBean.DataBean.BrandListBean> {


    public HomeBrandFragment(List<HomeBean.DataBean.BrandListBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_home_brand;
    }


    @Override
    protected BaseRecycleAdapter getAdapter() {
        HomeBrandRecycleAdapter adapter = new HomeBrandRecycleAdapter(mDatas, activity);
        return adapter;
    }
}
