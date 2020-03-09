package com.example.suit.UI.home_fragments;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.suit.R;
import com.example.suit.UI.channel.ChannelActivity;
import com.example.suit.UI.home_fragments.brand.HomeBrandFragment;
import com.example.suit.base.BaseFragment;
import com.example.suit.interfaces.home.HomeContract;
import com.example.suit.model.apis.HomeBean;
import com.example.suit.presenter.HomePresenter;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseFragment<HomeContract.Presenter> implements HomeContract.View {

    private Banner banner;

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
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
        List<HomeBean.DataBean.BannerBean> bannerList = result.getData().getBanner();
        List<HomeBean.DataBean.ChannelBean> channelList = result.getData().getChannel();
        List<HomeBean.DataBean.BrandListBean> brandList = result.getData().getBrandList();
        setBanner(bannerList);
        setChannel(channelList);

        //加载下方的系列列表
        Fragment brand = getBrand(brandList);
        FragmentManager manager = getActivity().getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container_brand, brand);
        transaction.commit();
    }

    private void setBanner( List<HomeBean.DataBean.BannerBean> bannerList) {
        List<String> images = new ArrayList<>();
        for (HomeBean.DataBean.BannerBean banner : bannerList) {
            images.add(banner.getImage_url());
        }

        //详细使用
        banner.setImages(images);
        banner.setImageLoader(new HomeFragment.GlideImageLoader());
        banner.isAutoPlay(true);
        banner.setDelayTime(1500);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void setChannel(List<HomeBean.DataBean.ChannelBean> channelList) {
        LinearLayout container_channel = mView.findViewById(R.id.container_channel);
        for (HomeBean.DataBean.ChannelBean bean : channelList) {
            Button button = new Button(getContext());
            button.setText(bean.getName());
            button.setId(100+channelList.indexOf(bean));
            button.setBackground(null);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ChannelActivity.class);
                    startActivity(intent);
                }
            });
            container_channel.addView(button);
        }
    }

    private Fragment getBrand(List<HomeBean.DataBean.BrandListBean> brandList) {
        HomeBrandFragment homeBrandFragment = new HomeBrandFragment(brandList);
        return homeBrandFragment;
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
