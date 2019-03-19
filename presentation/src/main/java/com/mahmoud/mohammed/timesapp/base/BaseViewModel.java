package com.mahmoud.mohammed.timesapp.base;


import android.arch.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {
    CompositeDisposable compositeDisposable=new CompositeDisposable();
    protected void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    private void clearDisposables() {
        compositeDisposable.clear();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        clearDisposables();
    }


}
