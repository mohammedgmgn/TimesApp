package com.mahmoud.mohammed.timesapp.data;


import com.mahmoud.mohammed.timesapp.data.models.ArticlesResponse;

import io.reactivex.Observable;
import io.reactivex.Single;


public interface TimesRepository {
    Single<ArticlesResponse> getTimes();
}
