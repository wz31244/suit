package com.example.suit.UI.home_fragments.newgoods;

import com.example.suit.R;
import com.example.suit.UI.home_fragments.base.HomeBaseFragment;
import com.example.suit.UI.home_fragments.base.BaseRecycleAdapter;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeNewGoodsFragment extends HomeBaseFragment<HomeBean.DataBean.NewGoodsListBean> {


    public HomeNewGoodsFragment(List<HomeBean.DataBean.NewGoodsListBean> mDatas, String title) {
        super(mDatas, title);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_home_newgoods;
    }


    @Override
    protected BaseRecycleAdapter getAdapter() {
        HomeNewGoodsRecycleAdapter adapter = new HomeNewGoodsRecycleAdapter(mDatas, activity);
        return adapter;
    }
}
