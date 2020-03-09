package com.example.suit.base;

import com.example.suit.interfaces.base.IBasePresenter;
import com.example.suit.interfaces.base.IBaseView;

import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/*
    P层基类
 */
public abstract class BasePresenter<V extends IBaseView> implements IBasePresenter <V> {

    protected V mView;//当前关联的View层的类
    WeakReference<V> weakRef;//采用弱引用方式关联View

    //被压式处理内存
    CompositeDisposable compositeDisposable;

    @Override
    public void attachView(V view) {
        weakRef = new WeakReference<V>(view);
        mView = weakRef.get();
    }

    @Override
    public void detachView() {
        mView = null;
        if (compositeDisposable != null) {
            compositeDisposable.clear();//如果当前presenter解绑时，还有网络请求，则将队列清空
        }
    }

    /*
        添加请求数据对象到背压式管理的类
     */
    protected void addSubscribe(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }
}
