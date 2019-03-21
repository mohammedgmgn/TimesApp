package com.mahmoud.mohammed.timesapp.data.remote;

import com.mahmoud.mohammed.timesapp.BuildConfig;
import com.mahmoud.mohammed.timesapp.data.TimesRepository;
import com.mahmoud.mohammed.timesapp.data.models.ArticlesResponse;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class TimesDownloader implements TimesRepository {
    TimesApi timesApi;

    @Inject
    public TimesDownloader(TimesApi timesApi) {
        this.timesApi = timesApi;
    }

    @Override
    public Single<ArticlesResponse> getTimes() {
        return timesApi.getArticles(BuildConfig.API_KEY);
    }
}
