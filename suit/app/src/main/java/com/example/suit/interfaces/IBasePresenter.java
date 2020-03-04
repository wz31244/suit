package com.example.suit.interfaces;

/*
    P层基类接口
 */
public interface IBasePresenter <T extends IBaseView> {
    //关联方法
    void attachView(T view);
    //解除关联方法
    void detachView();
}
