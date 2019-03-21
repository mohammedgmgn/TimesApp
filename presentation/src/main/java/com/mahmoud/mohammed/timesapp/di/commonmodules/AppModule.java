package com.mahmoud.mohammed.timesapp.di.commonmodules;

import android.content.Context;

import com.mahmoud.mohammed.timesapp.TimesApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */


@Module
public class AppModule {

    @Provides
    Context provideContext(TimesApplication application) {
        return application.getApplicationContext();
    }

}
