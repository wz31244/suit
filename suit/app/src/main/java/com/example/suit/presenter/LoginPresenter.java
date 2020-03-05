package com.example.suit.presenter;

import com.example.suit.base.BasePresenter;
import com.example.suit.common.ResponseSubscriber;
import com.example.suit.interfaces.login.LoginContract;
import com.example.suit.model.HttpManager;
import com.example.suit.model.apis.LoginBean;
import com.example.suit.utils.RxUtils;

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    @Override
    public void getLoginData(String userName, String password) {
        addSubscribe(HttpManager.getInstance().getMyServer().postLogin(userName, password)
                .compose(RxUtils.<LoginBean>rxScheduler())
                .subscribeWith(new ResponseSubscriber<LoginBean>(mView) {
                    @Override
                    public void onNext(LoginBean result) {
                        if (result.getErrno() == 0) {
                            mView.getLoginDataReturn(result);
                        } else {
                            mView.showTips(result.getErrmsg());
                            super.onNext(result);
                        }
                    }
                }));
    }
}
