package com.flipkart.truecaller.components;

import com.flipkart.truecaller.modules.TenthCharacterFragmentModule;
import com.flipkart.truecaller.scope.ActivityScope;
import com.flipkart.truecaller.views.TenthCharacterUpdateFragment;

import dagger.Subcomponent;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@ActivityScope
@Subcomponent(modules = {TenthCharacterFragmentModule.class})
public interface TenthCharacterFragmentComponent {
    void inject(TenthCharacterUpdateFragment tenthCharacterUpdateFragment);
}
