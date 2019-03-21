package com.mahmoud.mohammed.timesapp.base;

import android.content.Intent;
import android.support.v4.app.Fragment;

import com.mahmoud.mohammed.timesapp.data.models.Article;
import com.mahmoud.mohammed.timesapp.presentation.DetailActivity;

public class BaseFragment extends Fragment {
    protected void navigateToDetailsScreen(Article article) {
        startActivity(new Intent(getContext(), DetailActivity.class));
    }
}

