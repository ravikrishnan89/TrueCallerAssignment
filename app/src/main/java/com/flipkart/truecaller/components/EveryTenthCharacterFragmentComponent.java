package com.flipkart.truecaller.components;

import com.flipkart.truecaller.scope.ActivityScope;
import com.flipkart.truecaller.modules.EveryTenthCharacterFragmentModule;
import com.flipkart.truecaller.views.EveryTenthCharacterUpdateFragment;

import dagger.Subcomponent;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@ActivityScope
@Subcomponent(modules = {EveryTenthCharacterFragmentModule.class})
public interface EveryTenthCharacterFragmentComponent {
    void inject(EveryTenthCharacterUpdateFragment everyTenthCharacterUpdateFragment);
}
