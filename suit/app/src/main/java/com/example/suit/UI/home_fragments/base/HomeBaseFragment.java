package com.example.suit.UI.home_fragments.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/*
    本抽象类为首页共用的碎片类
    T为数据类
    A为适配器类
 */
public abstract class HomeBaseFragment<T> extends Fragment {
    public Context context;
    public Activity activity;
    public ViewGroup mView;
    public List<T> mDatas;
    public RecyclerView rv;
    private String title;

    public HomeBaseFragment(List<T> mDatas, String title) {
        this.mDatas = mDatas;
        this.title = title;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        view.setBackgroundColor(Color.WHITE);
        this.activity = getActivity();
        this.context = getContext();
        mView = (ViewGroup) view;
        setTitleView();
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

    //加载标题栏
    private void setTitleView() {
        TextView titleView = new TextView(activity);
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 60);
        layoutParams.setMargins(0, 10, 0, 0);
        titleView.setLayoutParams(layoutParams);
        titleView.setGravity(Gravity.CENTER);
        titleView.setTextSize(16);
        titleView.setText(title);
        mView.addView(titleView);
    }

    //加载视图
    private void setRecycleView() {
        rv = new RecyclerView(activity);//添加头部底部视图的recyclerView
        LinearLayout.LayoutParams layoutParams =
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        rv.setLayoutParams(layoutParams);
        rv.setBackgroundColor(Color.WHITE);
        rv.setNestedScrollingEnabled(false);//禁止滑动和复用
        mView.addView(rv);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 2);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(getAdapter());
    }
}
