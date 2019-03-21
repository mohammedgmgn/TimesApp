package com.mahmoud.mohammed.timesapp.di.commonmodules;

import android.content.Context;

import com.mahmoud.mohammed.timesapp.BuildConfig;
import com.mahmoud.mohammed.timesapp.data.remote.TimesApi;
import com.mahmoud.mohammed.timesapp.ui.common.UiUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

        long cacheSize =(long) (5 * 1024 * 1024);
        Cache cache= new Cache(context.getCacheDir(), cacheSize);
        return new OkHttpClient.Builder().cache(cache)
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    if (UiUtil.hasNetwork(context)) {
                        request = request.newBuilder()
                                .header("Cache-Control",
                                        "public, max-age=" + 5)
                                .build();

                    } else {
                        request = request.newBuilder()
                                .header("Cache-Control",
                                        "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                    }
                    return chain.proceed(request);

                })
                .build();

    }


}
