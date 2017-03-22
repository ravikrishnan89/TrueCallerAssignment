package com.flipkart.truecaller;

import android.app.Application;

import com.flipkart.truecaller.components.AppComponent;
import com.flipkart.truecaller.components.DaggerAppComponent;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public class TrueCallerApplication extends Application {
    public static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent= DaggerAppComponent.builder().build();
    }
}
