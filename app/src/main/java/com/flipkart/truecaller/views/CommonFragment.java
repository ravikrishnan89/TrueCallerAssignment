package com.flipkart.truecaller.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.flipkart.truecaller.R;
import com.flipkart.truecaller.listeners.RequestInfoListener;
import com.flipkart.truecaller.presenter.Presenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ravi.krishnan on 06/02/17.
 */

public abstract class CommonFragment extends Fragment implements BaseView, RequestInfoListener {


    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.progress)
    ProgressBar progressBar;
    @Inject
    Presenter presenter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        ((MainActivity)getActivity()).registerListener(this);
    }

    @Override
    public void onResponse(String string) {
        textView.setText(string);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).unregisterListener(this);
    }

    @Override
    public void requestInfo() {
        presenter.requestInfo();
    }
}
