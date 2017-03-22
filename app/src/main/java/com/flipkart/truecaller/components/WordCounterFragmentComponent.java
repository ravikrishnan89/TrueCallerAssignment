package com.flipkart.truecaller.components;

import com.flipkart.truecaller.modules.WordCounterFragmentModule;
import com.flipkart.truecaller.scope.ActivityScope;
import com.flipkart.truecaller.views.WordCounterFragment;

import dagger.Subcomponent;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@ActivityScope
@Subcomponent(modules = {WordCounterFragmentModule.class})
public interface WordCounterFragmentComponent {
    void inject(WordCounterFragment wordCounterFragment);
}
