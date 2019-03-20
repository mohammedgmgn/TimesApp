package com.mahmoud.mohammed.timesapp.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mahmoud.mohammed.timesapp.data.models.Response;
import com.mahmoud.mohammed.timesapp.R;
import com.mahmoud.mohammed.timesapp.base.BaseFragment;
import com.mahmoud.mohammed.timesapp.di.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;


public class TimesFragment extends BaseFragment {

     TimesListViewModel viewModel;
    @Inject
    ViewModelFactory viewModelFactory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(getActivity(), viewModelFactory).get(TimesListViewModel.class);
        viewModel.loadTimes();
        viewModel.response().observe(this, this::processResponse);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_times, container, false);
    }

    private void processResponse(Response response) {
        switch (response.status) {
            case LOADING:
                //    renderLoadingState();
                break;

            case SUCCESS:
                //     renderDataState(response.data);
                break;

            case ERROR:
                //      renderErrorState(response.error);
                break;
        }
    }

}
