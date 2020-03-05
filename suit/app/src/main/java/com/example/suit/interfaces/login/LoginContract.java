package com.example.suit.interfaces.login;

import com.example.suit.interfaces.IBasePresenter;
import com.example.suit.interfaces.IBaseView;
import com.example.suit.model.apis.LoginBean;

public class LoginContract {
    public interface View extends IBaseView {
        void getLoginDataReturn(LoginBean result);
    }

    public interface Presenter extends IBasePresenter<LoginContract.View> {
        void getLoginData(String userName, String password);
    }
}
