package com.example.suit.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.suit.interfaces.IBasePresenter;
import com.example.suit.interfaces.IBaseView;

public abstract class BaseActivity<P extends IBasePresenter> extends AppCompatActivity implements IBaseView {

    protected  P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(getLayout());
        presenter = createPresenter();
        if (presenter != null) {
            presenter.attachView(this);
        }
        initView();
        initData();
    }

    //获取布局
    protected abstract int getLayout();
    //初始化P层
    protected abstract P createPresenter();
    //初始化视图
    protected abstract void initView();
    //初始化数据（界面初始化之后）
    protected abstract void initData();

    @Override
    public void showTips(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
