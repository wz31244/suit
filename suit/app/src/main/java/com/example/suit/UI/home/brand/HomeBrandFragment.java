package com.example.suit.UI.home.brand;

import android.content.Intent;
import android.view.View;

import com.example.suit.UI.home.activity.HomeContentActivity;
import com.example.suit.UI.home.base.BaseRecycleAdapter;
import com.example.suit.UI.home.base.HomeBaseFragment;
import com.example.suit.adapter.OnItemClickListener;
import com.example.suit.model.apis.HomeBean;

import java.util.List;

public class HomeBrandFragment extends HomeBaseFragment<HomeBean.DataBean.BrandListBean> implements OnItemClickListener {


    public HomeBrandFragment(String title, List<HomeBean.DataBean.BrandListBean> mDatas, int columnCount) {
        super(title, mDatas, columnCount);
    }

    @Override
    protected BaseRecycleAdapter getRecyclerAdapter() {
        HomeBrandRecycleAdapter adapter = new HomeBrandRecycleAdapter(mDatas, activity);
        adapter.setOnItemClickListener(this);
        return adapter;
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = new Intent(activity, HomeContentActivity.class);
        startActivity(intent);
    }
}
