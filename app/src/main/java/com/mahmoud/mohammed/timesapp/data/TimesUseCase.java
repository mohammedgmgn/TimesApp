package com.mahmoud.mohammed.timesapp.data;


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

