package com.mahmoud.mohammed.timesapp.ui;

import android.app.Application;

import com.mahmoud.mohammed.domain.TimesUseCase;
import com.mahmoud.mohammed.timesapp.base.BaseViewModel;

import javax.inject.Inject;

import io.reactivex.Scheduler;

public class TimesViewModel extends BaseViewModel {
    private TimesUseCase timesUseCase;
    private Scheduler subscribeOnScheduler;
    private Scheduler observeOnScheduler;
    private Application application;


    @Inject
    public TimesViewModel(Application application, TimesUseCase timesUseCase, Scheduler
            subscribeOnScheduler, Scheduler observeOnScheduler) {
        super(application);
        this.timesUseCase = timesUseCase;
        this.application = application;
        this.observeOnScheduler = observeOnScheduler;
        this.subscribeOnScheduler = subscribeOnScheduler;

    }
}
