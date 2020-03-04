package com.example.suit.UI.home_fragments;

import android.util.Log;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suit.R;
import com.example.suit.adapter.TopicRecyclerAdapter;
import com.example.suit.base.BaseFragment;
import com.example.suit.interfaces.home.TopicContract;
import com.example.suit.model.apis.TopicBean;
import com.example.suit.presenter.TopicPresenter;

import java.util.ArrayList;
import java.util.List;

public class TopicFragment extends BaseFragment<TopicContract.Presenter> implements TopicContract.View {


    private RecyclerView rv_list;
    private TopicRecyclerAdapter adapter;
    private List<TopicBean.DataBeanX.DataBean> mData;

    @Override
    public int getLayout() {
        return R.layout.fragment_topic;
    }

    @Override
    public TopicContract.Presenter createPresenter() {
        return new TopicPresenter();
    }

    @Override
    public void initView() {
        rv_list = mView.findViewById(R.id.rv_list);
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_list.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_list.addItemDecoration(new DividerItemDecoration(getContext(), OrientationHelper.HORIZONTAL));
        rv_list.setItemAnimator( new DefaultItemAnimator());

        mData = new ArrayList<>();
        adapter = new TopicRecyclerAdapter(mData, getContext());
        rv_list.setAdapter(adapter);
    }

    @Override
    public void initData() {
        presenter.getItemData(0, 20);
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        Log.i("suit002", "-----topic界面接收到数据-----");
        if (result.getErrno() == 0) {
            if (result.getData().getCount() > 0) {
                mData.addAll(result.getData().getData());
            }
        }
        adapter.notifyDataSetChanged();
    }
}
