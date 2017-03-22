package com.flipkart.truecaller.presenter;

import android.util.Log;

import com.flipkart.truecaller.interactors.Interactor;
import com.flipkart.truecaller.views.BaseView;

/**
 * Created by ravi.krishnan on 06/02/17.
 */

public abstract class CommonPresenter implements Presenter{
    Interactor interactor;
    BaseView baseView;


    public CommonPresenter(Interactor interactor, BaseView baseView) {
        this.interactor = interactor;
        this.baseView = baseView;
    }

    @Override
    public void requestInfo() {
        baseView.showProgress();
    }

    @Override
    public void onResponse(String string) {
        baseView.dismissProgress();
        baseView.onResponse(string);
    }

    @Override
    public void onError() {
        baseView.dismissProgress();
        Log.e(EveryTenthCharacterPresenterImpl.class.getSimpleName(), "Error occured while fetching the data");
    }
}
