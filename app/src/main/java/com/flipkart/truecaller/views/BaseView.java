package com.flipkart.truecaller.views;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public interface BaseView {
    public void showProgress();
    public void dismissProgress();
    public void onResponse(String tenthCharacter);
}
