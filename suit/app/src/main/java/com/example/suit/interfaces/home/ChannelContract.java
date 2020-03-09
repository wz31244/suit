package com.example.suit.interfaces.home;

import com.example.suit.interfaces.base.IBasePresenter;
import com.example.suit.interfaces.base.IBaseView;
import com.example.suit.model.apis.ChannelBean;

public class ChannelContract {

    public interface View extends IBaseView {
        void getChannelDataReturn(ChannelBean result);
    }

    public interface Presenter extends IBasePresenter<View> {
        void getChannelData();
    }
}
