package com.mahmoud.mohammed.timesapp.presentation.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahmoud.mohammed.timesapp.R;
import com.mahmoud.mohammed.timesapp.data.models.Article;

public class TimesDetailsFragment extends Fragment {
    public static String ARTICALE_KEY="ArticaleKey";
    Article article;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        article = getArguments().getParcelable(ARTICALE_KEY);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_times_details, container, false);
    }

}
