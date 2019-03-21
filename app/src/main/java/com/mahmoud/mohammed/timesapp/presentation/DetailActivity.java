package com.mahmoud.mohammed.timesapp.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mahmoud.mohammed.timesapp.R;


public class DetailActivity extends AppCompatActivity {

    TimesDetailsFragment timesDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            timesDetailsFragment=new TimesDetailsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,
                            timesDetailsFragment)
                    .commit();

        }
    }

}
