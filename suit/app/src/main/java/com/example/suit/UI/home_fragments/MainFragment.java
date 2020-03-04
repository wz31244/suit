package com.example.suit.UI.home_fragments;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.suit.MainActivity;
import com.example.suit.R;
import com.example.suit.base.BaseFragment;
import com.example.suit.interfaces.home.HomeContract;
import com.example.suit.model.apis.HomeBean;
import com.example.suit.presenter.HomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class MainFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {

    private Banner banner;

    @Override
    public int getLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public HomeContract.Presenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void initView() {
        banner = mView.findViewById(R.id.banner);
    }

    @Override
    public void initData() {
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
        banner.setImages(images);
        banner.setImageLoader(new MainFragment.GlideImageLoader());
        banner.isAutoPlay(true);
        banner.setDelayTime(1500);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("suit001",  getClass()+" destroy");
    }
}
