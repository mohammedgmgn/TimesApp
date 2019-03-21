package com.mahmoud.mohammed.timesapp.domain;


import com.mahmoud.mohammed.timesapp.data.TimesRepository;
import com.mahmoud.mohammed.timesapp.data.models.ArticlesResponse;


import io.reactivex.Observable;

public class TimesUseCase {
   private TimesRepository timesRepository;
   public TimesUseCase(TimesRepository timesRepository) {
        this.timesRepository = timesRepository;
    }
    public Observable<ArticlesResponse>getArticleTimes(){
       return timesRepository.getTimes();
    }
}

