package com.example.networking.untils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpHandler {
    public static final String TAG = HttpHandler.class.getSimpleName();

    public HttpHandler(){}

    //tương tác với url
    public String makeServiceCall(String reqUrl){
        StringBuilder builder =new StringBuilder();
        try{
            //connect with url
            URL url = new URL(reqUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            //read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line=reader.readLine())!=null){
                builder.append(line).append("\n");
            }
            reader.close();
            connection.disconnect();

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return builder.toString();
    }
}
