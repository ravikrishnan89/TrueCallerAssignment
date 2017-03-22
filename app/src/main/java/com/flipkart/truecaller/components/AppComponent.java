package com.flipkart.truecaller.components;

import com.flipkart.truecaller.modules.EveryTenthCharacterFragmentModule;
import com.flipkart.truecaller.modules.NetworkModule;
import com.flipkart.truecaller.modules.TenthCharacterFragmentModule;
import com.flipkart.truecaller.modules.WordCounterFragmentModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@Singleton
@Component (modules = {NetworkModule.class})
public interface AppComponent {
    EveryTenthCharacterFragmentComponent plus(EveryTenthCharacterFragmentModule everyTenthCharacterFragmentModule);
    TenthCharacterFragmentComponent plus(TenthCharacterFragmentModule tenthCharacterFragmentModule);
    WordCounterFragmentComponent plus(WordCounterFragmentModule wordCounterFragmentModule);
}
