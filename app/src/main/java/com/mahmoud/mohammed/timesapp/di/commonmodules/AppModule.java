package com.mahmoud.mohammed.timesapp.di.commonmodules;

import android.app.Application;
import android.content.Context;


import dagger.Module;
import dagger.Provides;

/**
 * This is where you will inject application-wide dependencies.
 */


@Module
public class AppModule {

    @Provides
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }

}
