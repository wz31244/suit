package com.example.suit.interfaces.home;

import com.example.suit.interfaces.base.IBasePresenter;
import com.example.suit.interfaces.base.IBaseView;
import com.example.suit.model.apis.TopicBean;

public class TopicContract {

    public interface View extends IBaseView {
        void getTopicDataReturn(TopicBean result);
    }

    public interface Presenter extends IBasePresenter<View> {
        void getItemData(int page, int size);
    }
}