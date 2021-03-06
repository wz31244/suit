package com.example.suit.interfaces.login;

import com.example.suit.interfaces.base.IBasePresenter;
import com.example.suit.interfaces.base.IBaseView;
import com.example.suit.model.apis.RegisterBean;

public class RegisterContract {
    public interface View extends IBaseView {
        void getRegisterDataReturn(RegisterBean result);
    }

    public interface Presenter extends IBasePresenter<RegisterContract.View> {
        void getRegisterData(String userName, String password);
    }
}
