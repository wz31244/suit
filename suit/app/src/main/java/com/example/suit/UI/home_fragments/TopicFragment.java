package com.example.suit.UI.home_fragments;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.suit.R;
import com.example.suit.adapter.TopicRecyclerAdapter;
import com.example.suit.adapter.XCRecyclerView;
import com.example.suit.base.BaseFragment;
import com.example.suit.interfaces.home.TopicContract;
import com.example.suit.model.apis.TopicBean;
import com.example.suit.presenter.TopicPresenter;

import java.util.ArrayList;
import java.util.List;

public class TopicFragment extends BaseFragment<TopicContract.Presenter> implements TopicContract.View, View.OnClickListener {


    private XCRecyclerView rv_list;
    private TopicRecyclerAdapter adapter;
    private List<TopicBean.DataBeanX.DataBean> mData;
    private Button btn_previous;
    private Button btn_next;
    private int pageCount = 0;
    private int totalCount = -1;
    private RelativeLayout container;
    private View bottomView;

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
        container = mView.findViewById(R.id.container);
        rv_list = new XCRecyclerView(getActivity());//添加头部底部视图的recyclerView
        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        rv_list.setBackgroundColor(Color.WHITE);
        rv_list.setLayoutParams(layoutParams);
        container.addView(rv_list);

        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv_list.setLayoutManager(layoutManager);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        rv_list.addItemDecoration(new DividerItemDecoration(getContext(), OrientationHelper.HORIZONTAL));

        //设置适配器
        mData = new ArrayList<>();
        adapter = new TopicRecyclerAdapter(mData, getContext());
        rv_list.setAdapter(adapter);

        //获得数据之后，设置底部视图
        bottomView = LayoutInflater.from(getActivity()).inflate(R.layout.layout_topic_bottomview, rv_list, false);
        rv_list.addFooterView(bottomView);
        //开始时，设置底部视图隐藏
        bottomView.setVisibility(View.INVISIBLE);
        btn_previous = bottomView.findViewById(R.id.btn_previous);
        btn_next = bottomView.findViewById(R.id.btn_next);
        //按钮监听
        btn_previous.setOnClickListener(this);
        btn_next.setOnClickListener(this);
    }

    @Override
    public void initData() {
        presenter.getItemData(pageCount, 20);
    }

    @Override
    public void getTopicDataReturn(TopicBean result) {
        Log.i("suit002", "-----topic界面接收到数据-----");
        if (result.getErrno() == 0) {
            totalCount = result.getData().getTotalPages();
            if (result.getData().getCount() > 0) {
                mData.addAll(result.getData().getData());
            }
        }

        //获得数据后，设置视图显示
        bottomView.setVisibility(View.VISIBLE);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (pageCount < totalCount) {
                    pageCount++;
                    initData();
                    btn_previous.setEnabled(true);
                } else {
                    btn_next.setEnabled(false);
                }
                break;
            case R.id.btn_previous:
                if (pageCount > 0) {
                    pageCount--;
                    initData();
                    btn_next.setEnabled(true);
                } else {
                    btn_previous.setEnabled(false);
                }
                break;
        }
    }
}
