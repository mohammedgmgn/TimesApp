package com.mahmoud.mohammed.timesapp.base;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.mahmoud.mohammed.timesapp.data.models.Article;
import com.mahmoud.mohammed.timesapp.presentation.detail.DetailActivity;

import static com.mahmoud.mohammed.timesapp.presentation.detail.TimesDetailsFragment.ARTICALE_KEY;

public class BaseFragment extends Fragment {
    protected void navigateToDetailsScreen(Article article) {
        Intent intent=new Intent(getContext(), DetailActivity.class);
        intent.putExtra(ARTICALE_KEY,article);
        startActivity(intent);
    }
}

