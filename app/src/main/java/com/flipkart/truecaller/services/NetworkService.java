package com.flipkart.truecaller.services;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public interface NetworkService {
    String BASE_URL = "https://support.truecaller.com/hc/en-us";
    public String getResponse() throws Exception;
}
