package com.mahmoud.mohammed.timesapp.di.builders;


import com.mahmoud.mohammed.timesapp.di.TimesActivityModule;
import com.mahmoud.mohammed.timesapp.di.scopes.PerActivity;
import com.mahmoud.mohammed.timesapp.presentation.DetailActivity;
import com.mahmoud.mohammed.timesapp.presentation.TimesActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(modules = {TimesActivityModule.class,FragmentBuilder.class})
    TimesActivity getTimesActivity();




}



