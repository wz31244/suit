package com.example.suit.interfaces.home;

import com.example.suit.interfaces.base.IBasePresenter;
import com.example.suit.interfaces.base.IBaseView;
import com.example.suit.model.apis.ShoppingBean;

public class ShoppingContract {
    public interface View extends IBaseView {
        void getShoppingReturn(ShoppingBean result);
    }

    public interface Presenter extends IBasePresenter<ShoppingContract.View> {
        void getShoppingData();
    }
}
