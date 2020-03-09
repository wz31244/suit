package com.example.suit.common;

import com.example.suit.interfaces.base.IBaseView;

import io.reactivex.subscribers.ResourceSubscriber;

/*
    集中的错误处理
 */
public abstract class ResponseSubscriber<T> extends ResourceSubscriber<T> {

    IBaseView view;

    public ResponseSubscriber (IBaseView view) {
        this.view = view;
    }

    @Override
    public void onNext(T t) {
        //如果错误码不是0，则执行本方法
        if (view != null) {
            //view.showTips("数据异常");
        }
    }

    @Override
    public void onError(Throwable t) {
        if (view != null) {
            view.showTips(t.getMessage());
        }
    }

    @Override
    public void onComplete() {

    }
}
