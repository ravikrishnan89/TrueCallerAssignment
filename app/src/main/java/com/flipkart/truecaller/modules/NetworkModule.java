package com.flipkart.truecaller.modules;

import com.flipkart.truecaller.services.NetworkService;
import com.flipkart.truecaller.services.NetworkServiceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ravi.krishnan on 05/02/17.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    NetworkService getNetworkService(){
        return new NetworkServiceImpl();
    }
}
