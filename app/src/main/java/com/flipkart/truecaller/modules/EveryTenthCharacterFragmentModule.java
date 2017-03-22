package com.flipkart.truecaller.modules;

import com.flipkart.truecaller.presenter.EveryTenthCharacterPresenterImpl;
import com.flipkart.truecaller.presenter.Presenter;
import com.flipkart.truecaller.views.BaseView;
import com.flipkart.truecaller.interactors.Interactor;
import com.flipkart.truecaller.interactors.InteractorImpl;
import com.flipkart.truecaller.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@Module
public class EveryTenthCharacterFragmentModule {

    final BaseView baseView;

    public EveryTenthCharacterFragmentModule(BaseView baseView) {
        this.baseView = baseView;
    }

    @ActivityScope
    @Provides
    Presenter getEveryTenthCharacterPresenter(EveryTenthCharacterPresenterImpl everyTenthCharacterPresenter){
        return everyTenthCharacterPresenter;
    }

    @ActivityScope
    @Provides
    BaseView getBaseView(){
        return baseView;
    }

    @ActivityScope
    @Provides
    Interactor getInteractor(InteractorImpl interactor){
        return interactor;
    }
}
