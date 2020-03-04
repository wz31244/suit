package com.example.suit;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.example.suit.base.BaseActivity;
import com.example.suit.interfaces.home.HomeContract;
import com.example.suit.model.apis.HomeBean;
import com.example.suit.presenter.HomePresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<HomeContract.Presenter> implements HomeContract.View {

    private Banner mBanner;
    private List<String> mImages;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected HomeContract.Presenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initData() {
        presenter.getItemData();
    }

    @Override
    public void getHomeDataReturn(HomeBean result) {
        Log.i("suit001", "--------主界面接收到数据------");
        List<HomeBean.DataBean.BannerBean> banners = result.getData().getBanner();
        List<String> images = new ArrayList<>();
        for (HomeBean.DataBean.BannerBean banner : banners) {
            images.add(banner.getImage_url());
        }

        //详细使用
        mBanner = (Banner) findViewById(R.id.banner);
        mBanner.setImages(images);
        mBanner.setImageLoader(new GlideImageLoader());
        mBanner.isAutoPlay(true);
        mBanner.setDelayTime(1500);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }

    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

}



