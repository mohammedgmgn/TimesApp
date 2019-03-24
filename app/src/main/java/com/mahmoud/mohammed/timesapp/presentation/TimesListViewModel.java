package com.mahmoud.mohammed.timesapp.presentation;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.mahmoud.mohammed.timesapp.base.BaseViewModel;
import com.mahmoud.mohammed.timesapp.data.models.Response;
import com.mahmoud.mohammed.timesapp.domain.TimesUseCase;
import com.mahmoud.mohammed.timesapp.presentation.common.EspressoIdlingResource;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TimesListViewModel extends BaseViewModel {
    private final MutableLiveData<Response> response = new MutableLiveData<>();
    TimesUseCase timesUseCase;

    public TimesListViewModel(Application application, TimesUseCase timesUseCase) {
        super(application);
        this.timesUseCase = timesUseCase;

    }

    public MutableLiveData<Response> response() {
        return response;
    }

    public void loadTimes() {
        EspressoIdlingResource.increment();

        addDisposable(
                timesUseCase.getArticleTimes()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(__ -> response.setValue(Response.loading()))
                        .subscribe(
                                articlesResponse -> response.setValue(Response.success(articlesResponse)),
                                throwable -> {
                                    EspressoIdlingResource.decrement();
                                    response.setValue(Response.error(throwable));
                                }


                        )

        );
    }
}
