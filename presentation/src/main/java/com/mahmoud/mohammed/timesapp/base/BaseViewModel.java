package com.mahmoud.mohammed.timesapp.base;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends AndroidViewModel {
    CompositeDisposable compositeDisposable=new CompositeDisposable();

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

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
