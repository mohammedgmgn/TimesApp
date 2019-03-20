package com.mahmoud.mohammed.timesapp.di;


import android.net.Network;

import com.mahmoud.mohammed.timesapp.TimesApplication;
import com.mahmoud.mohammed.timesapp.di.builders.ActivityBuilder;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        /* Use AndroidInjectionModule.class if you're not using support library */
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class, NetworkModule.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(TimesApplication application);
        AppComponent build();
    }
    void inject(TimesApplication app);
}
