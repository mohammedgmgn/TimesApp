package com.mahmoud.mohammed.timesapp.data.remote;

import com.mahmoud.mohammed.timesapp.data.models.ArticlesResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TimesApi {
    @GET("v2/mostviewed/all-sections/7.json")
    Single<ArticlesResponse> getArticles(@Query("api-key") String apiKey);
}
