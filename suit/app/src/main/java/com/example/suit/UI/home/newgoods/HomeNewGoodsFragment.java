package com.example.suit.UI.home.newgoods;

import com.example.suit.UI.home.base.BaseRecycleAdapter;
import com.example.suit.UI.home.base.HomeBaseFragment;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeNewGoodsFragment extends HomeBaseFragment<HomeBean.DataBean.NewGoodsListBean> {


    public HomeNewGoodsFragment(String title, List<HomeBean.DataBean.NewGoodsListBean> mDatas, int columnCount) {
        super(title, mDatas, columnCount);
    }

    @Override
    protected BaseRecycleAdapter getRecyclerAdapter() {
        return new HomeNewGoodsRecycleAdapter(mDatas, activity);
    }
}
