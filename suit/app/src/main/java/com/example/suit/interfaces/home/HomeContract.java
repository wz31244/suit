package com.example.suit.interfaces.home;

import com.example.suit.interfaces.base.IBasePresenter;
import com.example.suit.interfaces.base.IBaseView;
import com.example.suit.model.apis.HomeBean;

public class HomeContract {

    public interface View extends IBaseView {
        void getHomeDataReturn(HomeBean result);
    }

    public interface Presenter extends IBasePresenter<View> {
        void getItemData();
    }
}
