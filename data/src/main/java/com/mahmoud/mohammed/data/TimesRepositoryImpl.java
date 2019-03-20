package com.mahmoud.mohammed.data;

import com.mahmoud.mohammed.data.models.Article;
import com.mahmoud.mohammed.data.remote.TimesApi;

import java.util.List;

import io.reactivex.Observable;

public class TimesRepositoryImpl implements TimesRepository{
    TimesApi timesApi;
    public TimesRepositoryImpl() {
    }

    @Override
    public Observable<List<Article>> getTimes() {
        return null;
    }
}
