package com.example.suit.UI.home.base;

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

import com.example.suit.R;

import java.util.List;

import static android.view.View.OVER_SCROLL_NEVER;

public abstract class HomeBaseFragment<T> extends Fragment {

    protected Activity activity;
    protected Context context;
    protected ViewGroup mView;
    protected String title;
    protected List<T> mDatas;
    protected int columnCount;

    protected HomeBaseFragment(String title, List<T> mDatas, int columnCount) {
        this.title = title;
        this.mDatas = mDatas;
        this.columnCount = columnCount;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = (ViewGroup) inflater.inflate(R.layout.layout_home_base, container, false);
        mView.setBackgroundColor(Color.WHITE);
        activity = getActivity();
        context = getContext();
        //添加标题
        setTitleView();
        //添加表格布局
        setRecycleView();
        return mView;
    }

    private void setTitleView() {
        TextView titleView = new TextView(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 80);
        params.setMargins(0, 40, 0, 10);
        titleView.setGravity(Gravity.CENTER);
        titleView.setLayoutParams(params);
        titleView.setTextSize(16);
        titleView.setText(title);
        mView.addView(titleView);
    }

    private void setRecycleView() {
        RecyclerView recyclerView = new RecyclerView(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 20, 0, 10);
        GridLayoutManager manager = new GridLayoutManager(context, columnCount);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(getRecyclerAdapter());
        //取消滑动到顶部、底部的阴影
        recyclerView.setOverScrollMode(OVER_SCROLL_NEVER);
        recyclerView.setNestedScrollingEnabled(false);
        mView.addView(recyclerView);
    }

    //需要子类完成的抽象方法
    abstract protected BaseRecycleAdapter getRecyclerAdapter();

}
