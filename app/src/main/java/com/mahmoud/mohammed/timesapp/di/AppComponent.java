package com.mahmoud.mohammed.timesapp.di;


import android.app.Application;

import com.mahmoud.mohammed.timesapp.TimesApplication;
import com.mahmoud.mohammed.timesapp.di.builders.ActivityBuilder;
import com.mahmoud.mohammed.timesapp.di.commonmodules.AppModule;
import com.mahmoud.mohammed.timesapp.di.commonmodules.NetworkModule;
import com.mahmoud.mohammed.timesapp.di.commonmodules.PicassoModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule.class,
        AppModule.class,
        PicassoModule.class,
        ActivityBuilder.class, NetworkModule.class})
public interface AppComponent {
    void inject(TimesApplication app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}
