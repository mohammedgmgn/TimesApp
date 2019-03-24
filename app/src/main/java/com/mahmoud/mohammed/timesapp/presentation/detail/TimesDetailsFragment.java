package com.mahmoud.mohammed.timesapp.presentation.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mahmoud.mohammed.timesapp.R;
import com.mahmoud.mohammed.timesapp.base.BaseFragment;
import com.mahmoud.mohammed.timesapp.data.models.Article;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TimesDetailsFragment extends BaseFragment {
    public static String ARTICALE_KEY = "ArticaleKey";
    @BindView(R.id.toolbartest)
    Toolbar toolbar;
    @BindView(R.id.date_status)
    TextView date;
    @BindView(R.id.cover)
    ImageView cover;
    private Article article;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        article = getArguments().getParcelable(ARTICALE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_times_details, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        toolbar.setTitle(article.getTitle());
        ((DetailActivity) getActivity()).setSupportActionBar(toolbar);
        ((DetailActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((DetailActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(view -> getActivity().onBackPressed());
        Picasso.with(getContext())
                .load(article.getMedia().get(0).getMediaMetadata().get(4).getUrl())
                .into(cover);
        date.setText(article.getPublishedDate());

    }

}
