package com.flipkart.truecaller.modules;

import com.flipkart.truecaller.interactors.Interactor;
import com.flipkart.truecaller.interactors.InteractorImpl;
import com.flipkart.truecaller.presenter.Presenter;
import com.flipkart.truecaller.presenter.TenthCharacterPresenterImpl;
import com.flipkart.truecaller.scope.ActivityScope;
import com.flipkart.truecaller.views.BaseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@Module
public class TenthCharacterFragmentModule {

    final BaseView tenthCharacterView;

    public TenthCharacterFragmentModule(BaseView tenthCharacterView) {
        this.tenthCharacterView = tenthCharacterView;
    }

    @ActivityScope
    @Provides
    Presenter getTenthCharacterPresenter(TenthCharacterPresenterImpl tenthCharacterPresenter){
        return tenthCharacterPresenter;
    }

    @ActivityScope
    @Provides
    BaseView getTenthCharacterView(){
        return tenthCharacterView;
    }

    @ActivityScope
    @Provides
    Interactor getInteractor(InteractorImpl interactor){
        return interactor;
    }
}
