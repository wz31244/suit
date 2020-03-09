package com.example.suit.UI.home_fragments.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.suit.adapter.XCRecyclerView;
import com.example.suit.base.BaseRecycleAdapter;

import java.util.List;

/*
    本抽象类为首页共用的碎片类
    T为数据类
    A为适配器类
 */
public abstract class HomeBaseFragment<T> extends Fragment {
    public Context context;
    public Activity activity;
    public XCRecyclerView rv;
    public ViewGroup mView;
    public List<T> mDatas;

    public HomeBaseFragment(List<T> mDatas) {
        this.mDatas = mDatas;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        this.activity = getActivity();
        this.context = getContext();
        mView = (ViewGroup) view;
        setRecycleView();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    //设置视图容器
    abstract protected int getLayoutId();
    //设置数据
    abstract protected BaseRecycleAdapter getAdapter();

    //加载视图
    protected void setRecycleView() {
        rv = new XCRecyclerView(activity);//添加头部底部视图的recyclerView
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rv.setBackgroundColor(Color.WHITE);
        rv.setLayoutParams(layoutParams);
        rv.setNestedScrollingEnabled(false);//禁止滑动和复用

        mView.addView(rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(getAdapter());
    }
}
