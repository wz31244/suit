package com.example.suit.presenter;

import com.example.suit.base.BasePresenter;
import com.example.suit.common.ResponseSubscriber;
import com.example.suit.interfaces.home.HomeContract;
import com.example.suit.model.HttpManager;
import com.example.suit.model.apis.HomeBean;
import com.example.suit.utils.RxUtils;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    @Override
    public void getItemData() {
        //网络请求，只处理正常获得数据的请求
        //错误请求交给ResponseSubscriber类处理
        addSubscribe(HttpManager.getInstance().getMyServer().getHome()
                .compose(RxUtils.<HomeBean>rxScheduler())
                .subscribeWith(new ResponseSubscriber<HomeBean>(mView) {
                    @Override
                    public void onNext(HomeBean result) {
                        if (result.getErrno() == 0) {
                            mView.getHomeDataReturn(result);
                        } else {
                            mView.showTips(result.getErrmsg());
                            super.onNext(result);
                        }
                    }
                }));
    }


}
