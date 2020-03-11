package com.example.suit.UI.home.topic;

import com.example.suit.UI.home.base.BaseRecycleAdapter;
import com.example.suit.UI.home.base.HomeBaseFragment;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeTopicFragment extends HomeBaseFragment<HomeBean.DataBean.TopicListBean> {


    public HomeTopicFragment(String title, List<HomeBean.DataBean.TopicListBean> mDatas, int columnCount) {
        super(title, mDatas, columnCount);
    }

    @Override
    protected BaseRecycleAdapter getRecyclerAdapter() {
        return new HomeTopicRecycleAdapter(mDatas, context);
    }
}
