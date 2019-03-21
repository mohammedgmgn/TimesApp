package com.mahmoud.mohammed.timesapp.domain;


import com.mahmoud.mohammed.timesapp.data.TimesRepository;
import com.mahmoud.mohammed.timesapp.data.models.ArticlesResponse;

import io.reactivex.Observable;
import io.reactivex.Single;

public class TimesUseCase {
    private TimesRepository timesRepository;

    public TimesUseCase(TimesRepository timesRepository) {
        this.timesRepository = timesRepository;
    }

    public Single<ArticlesResponse> getArticleTimes() {
        return timesRepository.getTimes();
    }
}

