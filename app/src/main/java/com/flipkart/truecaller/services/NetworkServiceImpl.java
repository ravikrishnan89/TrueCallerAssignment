package com.flipkart.truecaller.services;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ravi.krishnan on 05/02/17.
 */

public class NetworkServiceImpl implements NetworkService {
    @Override
    public String getResponse() throws Exception{
        String result = null;
        try {
            URL url = new URL(BASE_URL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();
            int responseCode = httpURLConnection.getResponseCode();
            InputStream is = httpURLConnection.getInputStream();
            if (responseCode >= 400) {
                throw new Exception("Error While fetching data");
            }
            InputStreamReader reader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = "";
            StringBuffer sb = new StringBuffer();

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }

            bufferedReader.close();

            result = sb.toString();
        }catch (MalformedURLException me){
            throw me;
        }
        return result;
    }

}
