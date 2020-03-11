package com.example.suit.UI.home.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.suit.model.apis.HomeBean;

public class HomeContentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("详情");
        HomeBean.DataBean.HotGoodsListBean data = (HomeBean.DataBean.HotGoodsListBean) getIntent().getSerializableExtra("data");
        Toast.makeText(this, data.getName(), Toast.LENGTH_SHORT).show();
    }
}
