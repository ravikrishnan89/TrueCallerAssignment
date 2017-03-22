package com.flipkart.truecaller.interactors;

import com.flipkart.truecaller.listeners.BaseListener;
import com.flipkart.truecaller.services.NetworkService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public class InteractorImpl implements Interactor {
    @Inject
    protected NetworkService networkService;
    @Inject
    InteractorImpl(){

    }

    public Observable<String> getTenthCharacterObservable() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                String responseString  = networkService.getResponse();
                return responseString.substring(9,10);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }


    public Observable<String> getEveryTenthCharacterStringObservable() {
        return Observable.fromCallable(new Callable<String>() {
            @Override
            public String call() throws Exception {
                StringBuilder stringBuilder = new StringBuilder();
                String responseString  = networkService.getResponse();
                char [] responseStringCharacters = responseString.toCharArray();
                int count = 1;
                for(char character: responseStringCharacters){
                    if(count%10==0) {
                        stringBuilder.append(character);
                    }
                    count++;
                }
                return stringBuilder.toString();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());

    }

    public Observable<Map<String, Integer>> getWordCountMapObservable() {
        return Observable.fromCallable(new Callable<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> call() throws Exception {
                HashMap<String,Integer> wordCounterMap = new HashMap<String, Integer>();
                String responseString  = networkService.getResponse();
                String [] strings = responseString.split("[\\s/\".,=-]+");
                for(String string: strings){
                    if(wordCounterMap.containsKey(string)){
                        wordCounterMap.put(string, wordCounterMap.get(string) +1);
                    }else{
                        wordCounterMap.put(string, 1);
                    }
                }
                return wordCounterMap;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public void getTenthCharacter(final BaseListener tenthCharacterListener) {
         getTenthCharacterObservable().subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                tenthCharacterListener.onError();
            }

            @Override
            public void onNext(String s) {
                tenthCharacterListener.onResponse(s);
            }
        });
    }

    @Override
    public void getEveryTenthCharacterString(final BaseListener baseListener) {
        getEveryTenthCharacterStringObservable().subscribe(new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                baseListener.onError();
            }

            @Override
            public void onNext(String s) {
                baseListener.onResponse(s);
            }
        });
    }

    @Override
    public void getWordCountMap(final BaseListener wordCounterListener) {
        getWordCountMapObservable().subscribe(new Observer<Map<String, Integer>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                wordCounterListener.onError();
            }

            @Override
            public void onNext(Map<String, Integer> stringIntegerMap) {
                Integer count = stringIntegerMap.get("Truecaller");
                if(count==null){
                    count =0;
                }
                wordCounterListener.onResponse(count + "");
            }
        });
    }
}
