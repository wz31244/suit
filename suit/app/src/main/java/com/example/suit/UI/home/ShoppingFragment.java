package com.example.suit.UI.home;

import android.content.Intent;

import com.example.suit.R;
import com.example.suit.UI.login.LoginActivity;
import com.example.suit.apps.MyApp;
import com.example.suit.base.BaseFragment;
import com.example.suit.interfaces.home.ShoppingContract;
import com.example.suit.model.apis.ShoppingBean;

public class ShoppingFragment extends BaseFragment<ShoppingContract.Presenter> implements ShoppingContract.View {

    @Override
    public int getLayout() {
        return R.layout.fragment_shopping;
    }

    @Override
    public ShoppingContract.Presenter createPresenter() {
        return null;
    }

    @Override
    public void initView() {
        if (MyApp.login == null) {//未登录
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void initData() { }

    @Override
    public void getShoppingReturn(ShoppingBean result) {

    }
}
