package com.mahmoud.mohammed.timesapp.di;

import com.mahmoud.mohammed.timesapp.data.TimesRepository;
import com.mahmoud.mohammed.timesapp.data.remote.TimesApi;
import com.mahmoud.mohammed.timesapp.data.remote.TimesDownloader;
import com.mahmoud.mohammed.timesapp.di.scopes.PerActivity;
import com.mahmoud.mohammed.timesapp.domain.TimesUseCase;
import com.mahmoud.mohammed.timesapp.presentation.articles.TimesFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class TimesActivityModule {
    @Provides
    @PerActivity
    TimesFragment provideDeliveriesListFragment() {
        return new TimesFragment();
    }

    @Provides
    @PerActivity
    TimesRepository provideTimesListFragment(TimesApi timesApi) {
        return new TimesDownloader(timesApi);
    }


    @Provides
    TimesUseCase providesTimesListUseCases(TimesRepository repository) {
        return new TimesUseCase(repository);
    }
}
