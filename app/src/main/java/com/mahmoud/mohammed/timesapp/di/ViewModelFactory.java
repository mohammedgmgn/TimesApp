package com.mahmoud.mohammed.timesapp.di;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;


import com.mahmoud.mohammed.timesapp.domain.TimesUseCase;
import com.mahmoud.mohammed.timesapp.presentation.TimesListViewModel;

import javax.inject.Inject;


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

     TimesUseCase timesUseCase;
     Application application;
    @Inject ViewModelFactory(Application application,
                            TimesUseCase timesUseCase) {
        this.timesUseCase = timesUseCase;
        this.application=application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TimesListViewModel(this.application,this.timesUseCase);
    }
}
