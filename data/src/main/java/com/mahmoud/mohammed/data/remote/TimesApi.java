package com.mahmoud.mohammed.data.remote;

import com.mahmoud.mohammed.data.models.ArticlesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TimesApi {
    @GET("v2/mostviewed/all-sections/7.json")
    Observable<ArticlesResponse> getArticles(@Query("api-key") String apiKey);
}
