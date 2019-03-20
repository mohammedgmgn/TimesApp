package com.mahmoud.mohammed.timesapp.di;

import android.content.Context;

import com.mahmoud.mohammed.data.remote.TimesApi;
import com.mahmoud.mohammed.timesapp.BuildConfig;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {


    @Singleton
    @Provides
    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

    }

    @Provides
    @Singleton
    public TimesApi providesNetworkService(Retrofit retrofit) {
        return retrofit.create(TimesApi.class);
    }

    @Singleton
    @Provides
    OkHttpClient providesOkHttpClient(Context context) {

        return new OkHttpClient.Builder().build();
            /*    .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();

                        // Customize the request
                      *//*  Request request = original.newBuilder()
                                .header("Content-Type", "application/json")
                                .removeHeader("Pragma")
                                .header("Cache-Control",
                                        String.format("max-age=%d", BuildConfig.CACHETIME))
                                .build();
*//*
                        okhttp3.Response response = chain.proceed(request);
                        response.cacheResponse();
                        // Customize or return the response
                        return response;
                    }
                })
                .cache(cache)

                .build();*/

    }

}
