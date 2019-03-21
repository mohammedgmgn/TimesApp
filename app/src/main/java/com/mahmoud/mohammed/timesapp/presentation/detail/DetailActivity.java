package com.mahmoud.mohammed.timesapp.presentation.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mahmoud.mohammed.timesapp.R;

import static com.mahmoud.mohammed.timesapp.presentation.detail.TimesDetailsFragment.ARTICALE_KEY;


public class DetailActivity extends AppCompatActivity {

    TimesDetailsFragment timesDetailsFragment;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        if (savedInstanceState == null) {
            bundle = new Bundle();
            bundle.putParcelable(ARTICALE_KEY, getIntent().getParcelableExtra(ARTICALE_KEY));
            timesDetailsFragment = new TimesDetailsFragment();
            timesDetailsFragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container,
                            timesDetailsFragment)
                    .commit();

        }
    }

}
