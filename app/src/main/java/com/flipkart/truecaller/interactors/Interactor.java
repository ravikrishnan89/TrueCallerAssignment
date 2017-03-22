package com.flipkart.truecaller.interactors;


import com.flipkart.truecaller.listeners.BaseListener;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public interface Interactor {
    public void getTenthCharacter(BaseListener tenthCharacterListener);
    public void getEveryTenthCharacterString(BaseListener baseListener);
    public void getWordCountMap(BaseListener wordCounterListener);
}
