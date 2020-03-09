package com.example.suit.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.suit.interfaces.base.IBasePresenter;
import com.example.suit.interfaces.base.IBaseView;


public abstract class BaseFragment<P extends IBasePresenter> extends Fragment implements IBaseView {
    public Context context;
    public Activity activity;
    public P presenter;
    public View mView;

    //Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getContext();
        activity = getActivity();
        mView = LayoutInflater.from(context).inflate(getLayout(), container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = createPresenter();
        //unbinder = ButterKnife.bind(context, view);
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    abstract public int getLayout();
    abstract public P createPresenter();
    abstract public void initView();
    abstract public void initData();

    @Override
    public void showTips(String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

}
