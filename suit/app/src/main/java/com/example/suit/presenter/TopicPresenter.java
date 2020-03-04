package com.example.suit.presenter;

import android.util.Log;

import com.example.suit.UI.home_fragments.TopicFragment;
import com.example.suit.base.BasePresenter;
import com.example.suit.common.ResponseSubscriber;
import com.example.suit.interfaces.home.TopicContract;
import com.example.suit.model.HttpManager;
import com.example.suit.model.apis.TopicBean;
import com.example.suit.utils.RxUtils;

public class TopicPresenter extends BasePresenter<TopicContract.View> implements TopicContract.Presenter {
    @Override
    public void getItemData(int page, int size) {
        addSubscribe(HttpManager.getInstance().getMyServer().getTopic(page, size)
                .compose(RxUtils.<TopicBean>rxScheduler())
                .subscribeWith(new ResponseSubscriber<TopicBean>(mView) {
                    @Override
                    public void onNext(TopicBean result) {
                        if (result.getErrno() == 0) {
                            mView.getTopicDataReturn(result);
                        } else {
                            super.onNext(result);
                        }
                    }
                }));
    }
}
