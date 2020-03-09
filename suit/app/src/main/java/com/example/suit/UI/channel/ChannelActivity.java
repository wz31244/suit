package com.example.suit.UI.channel;

import com.example.suit.R;
import com.example.suit.base.BaseActivity;
import com.example.suit.interfaces.home.ChannelContract;
import com.example.suit.model.apis.ChannelBean;

public class ChannelActivity extends BaseActivity<ChannelContract.Presenter> implements ChannelContract.View {
    @Override
    protected int getLayout() {
        return R.layout.activity_channel;
    }

    @Override
    protected ChannelContract.Presenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void getChannelDataReturn(ChannelBean result) {

    }
}
