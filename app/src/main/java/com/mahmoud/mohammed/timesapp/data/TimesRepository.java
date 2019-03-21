package com.mahmoud.mohammed.timesapp.data;


import com.mahmoud.mohammed.timesapp.data.models.ArticlesResponse;

import io.reactivex.Observable;


public interface TimesRepository {
    Observable<ArticlesResponse> getTimes();
}
