package com.example.suit.presenter;

import android.util.Log;

import com.example.suit.base.BasePresenter;
import com.example.suit.interfaces.home.HomeContract;
import com.example.suit.model.HttpManager;
import com.example.suit.model.apis.HomeBean;
import com.example.suit.utils.RxUtils;

import io.reactivex.subscribers.ResourceSubscriber;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void getItemData() {
        HttpManager.getInstance().getMyServer().getHome()
                .compose(RxUtils.<HomeBean>rxScheduler())
                .subscribeWith(new ResourceSubscriber<HomeBean>() {

                    @Override
                    public void onNext(HomeBean homeBean) {
                        Log.i("suit001", "----获得数据-----");
                        mView.getHomeDataReturn(homeBean);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.i("suit001", "----错误-----");
                        Log.i("suit001", t.getMessage());
                        t.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
