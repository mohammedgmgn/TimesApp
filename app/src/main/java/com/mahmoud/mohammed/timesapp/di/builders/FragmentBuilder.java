package com.mahmoud.mohammed.timesapp.di.builders;

import com.mahmoud.mohammed.timesapp.presentation.TimesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface FragmentBuilder {

    @ContributesAndroidInjector
    TimesFragment getTimesFragment();

}
