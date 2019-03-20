package com.mahmoud.mohammed.timesapp.di;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;


import com.mahmoud.mohammed.domain.TimesUseCase;
import com.mahmoud.mohammed.timesapp.ui.TimesListViewModel;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Scheduler;


public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private TimesUseCase timesUseCase;
    @Named("io")
    private  Scheduler subscribeOnScheduler;
    @Named("mainThread")
    private  Scheduler observeOnScheduler;
    private Application application;
    @Inject
    public ViewModelFactory(Application application,
                            Scheduler subscribeOnScheduler,
                            Scheduler observeOnScheduler,
                            TimesUseCase articlesUseCase) {
        this.timesUseCase = articlesUseCase;
        this.application=application;
        this.observeOnScheduler=observeOnScheduler;
        this.subscribeOnScheduler=subscribeOnScheduler;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TimesListViewModel(application,timesUseCase,subscribeOnScheduler,observeOnScheduler);
    }
}
