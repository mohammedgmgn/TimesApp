package com.mahmoud.mohammed.timesapp;


import com.mahmoud.mohammed.timesapp.data.models.ArticlesResponse;
import com.mahmoud.mohammed.timesapp.data.remote.TimesApi;

import org.junit.Before;
import org.junit.Test;

import io.reactivex.observers.TestObserver;
import retrofit2.Retrofit;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ArticlesUnitTest {

    public TimesApi api;
    public TestObserver testObserver = new TestObserver<TimesApi>();
    public Retrofit retrofit;

    public TestUtils testUtils;

    @Before
   public void before() {
        testUtils = new TestUtils();
        retrofit = testUtils.buildRetrofit();
        api = retrofit.create(TimesApi.class);
    }
    @Test
    public void testExpectedResponseWithActual() {

        api.getArticles(TestConstants.API_KEY).subscribe(testObserver);
        testObserver.assertValue(t -> {
            ArticlesResponse response = testUtils.getArticles();
            ArticlesResponse testedResponse = (ArticlesResponse) t;
            return testedResponse.getCopyright().equals(response.getCopyright());
        });
    }



}