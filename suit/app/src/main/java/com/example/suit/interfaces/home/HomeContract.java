package com.example.suit.interfaces.home;

import com.example.suit.interfaces.IBasePresenter;
import com.example.suit.interfaces.IBaseView;
import com.example.suit.model.apis.HomeBean;

public class HomeContract {

    public interface View extends IBaseView {
        void getHomeDataReturn(HomeBean result);
    }

    public interface Presenter extends IBasePresenter<View> {
        void getItemData();
    }
}
