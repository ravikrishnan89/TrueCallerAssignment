package com.flipkart.truecaller.modules;

import com.flipkart.truecaller.interactors.Interactor;
import com.flipkart.truecaller.interactors.InteractorImpl;
import com.flipkart.truecaller.presenter.Presenter;
import com.flipkart.truecaller.presenter.WordCounterPresenterImpl;
import com.flipkart.truecaller.scope.ActivityScope;
import com.flipkart.truecaller.views.BaseView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@Module
public class WordCounterFragmentModule {

    final BaseView wordCounterView;

    public WordCounterFragmentModule(BaseView wordCounterView) {
        this.wordCounterView = wordCounterView;
    }

    @ActivityScope
    @Provides
    Presenter getWordCounterPresenter(WordCounterPresenterImpl wordCounterPresenter){
        return wordCounterPresenter;
    }

    @ActivityScope
    @Provides
    BaseView getWordCounterView(){
        return wordCounterView;
    }

    @ActivityScope
    @Provides
    Interactor getInteractor(InteractorImpl interactor){
        return interactor;
    }
}
