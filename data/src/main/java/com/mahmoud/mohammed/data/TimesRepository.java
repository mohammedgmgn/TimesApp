package com.mahmoud.mohammed.data;

import com.mahmoud.mohammed.data.models.Article;

import java.util.List;

import io.reactivex.Observable;

public interface TimesRepository {
   Observable<List<Article>> getTimes ();

}
