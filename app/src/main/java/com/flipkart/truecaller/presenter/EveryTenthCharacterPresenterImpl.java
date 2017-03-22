package com.flipkart.truecaller.presenter;

import com.flipkart.truecaller.interactors.Interactor;
import com.flipkart.truecaller.views.BaseView;

import javax.inject.Inject;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public class EveryTenthCharacterPresenterImpl extends CommonPresenter {

    @Inject
    public EveryTenthCharacterPresenterImpl(Interactor interactor, BaseView baseView) {
        super(interactor, baseView);
    }

    @Override
    public void requestInfo() {
        super.requestInfo();
        interactor.getEveryTenthCharacterString(this);
    }
}
