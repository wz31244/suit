package com.example.suit.base;

import com.example.suit.interfaces.IBasePresenter;
import com.example.suit.interfaces.IBaseView;

import java.lang.ref.WeakReference;

/*
    P层基类
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter <V> {

    protected V mView;//当前关联的View层的类
    WeakReference<V> weakRef;//采用弱引用方式关联View

    @Override
    public void attachView(V view) {
        weakRef = new WeakReference<V>(view);
        mView = weakRef.get();
    }

    @Override
    public void detachView() {
        mView = null;
    }
}
