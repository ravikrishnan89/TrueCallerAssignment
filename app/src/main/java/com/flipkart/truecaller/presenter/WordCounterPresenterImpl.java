package com.flipkart.truecaller.presenter;

import com.flipkart.truecaller.interactors.Interactor;
import com.flipkart.truecaller.views.BaseView;

import javax.inject.Inject;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public class WordCounterPresenterImpl extends CommonPresenter {

    @Inject
    public WordCounterPresenterImpl(Interactor interactor, BaseView wordCounterView) {
       super(interactor,wordCounterView);
    }

    @Override
    public void requestInfo() {
        super.requestInfo();
        interactor.getWordCountMap(this);
    }

}
