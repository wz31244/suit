package com.example.suit.presenter;

import com.example.suit.base.BasePresenter;
import com.example.suit.common.ResponseSubscriber;
import com.example.suit.interfaces.login.RegisterContract;
import com.example.suit.model.HttpManager;
import com.example.suit.model.apis.RegisterBean;
import com.example.suit.utils.RxUtils;

public class RegisterPresenter extends BasePresenter<RegisterContract.View> implements RegisterContract.Presenter {

    @Override
    public void getRegisterData(String userName, String password) {
        addSubscribe(HttpManager.getInstance().getMyServer().postRegister(userName, password)
                .compose(RxUtils.<RegisterBean>rxScheduler())
                .subscribeWith(new ResponseSubscriber<RegisterBean>(mView) {
                    @Override
                    public void onNext(RegisterBean result) {
                        if (result.getErrno() == 0) {
                            mView.getRegisterDataReturn(result);
                        } else {
                            mView.showTips(result.getErrmsg());
                            super.onNext(result);
                        }
                    }
                }));

    }
}
