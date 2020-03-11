package com.example.suit.UI.home.hotgoods;

import com.example.suit.UI.home.base.BaseRecycleAdapter;
import com.example.suit.UI.home.base.HomeBaseFragment;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeHotGoodsFragment extends HomeBaseFragment<HomeBean.DataBean.HotGoodsListBean> {


    public HomeHotGoodsFragment(String title, List<HomeBean.DataBean.HotGoodsListBean> mDatas, int columnCount) {
        super(title, mDatas, columnCount);
    }

    @Override
    protected BaseRecycleAdapter getRecyclerAdapter() {
        return new HomeHotGoodsRecycleAdapter(mDatas, context);
    }
}
