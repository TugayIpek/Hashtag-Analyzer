package com.example.analytag.ui;
import android.os.StrictMode;
import android.util.Log;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APIServicePopular {

    public JsonNode APIPopular() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://api.ritekit.com/v1/search/trending?green=1&latin=1")
                .method("GET", null)
                .addHeader("client_id", "d6af9902e1a806598d2c9342d4b61dd0e7db0a5e374c")
                .addHeader("Cookie", "RITEKIT=g3tcbsscnuf377k7rhd1fmcsiu")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            //System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonNode rootNode = null;
        try {
            String myJson = response.body().string();

            ObjectMapper mapper = new ObjectMapper();

            rootNode = mapper.readTree(myJson);

            System.out.println(rootNode.get("tags").size());

                /*ArrayList<ArrayList<String>> datas = new ArrayList<>();
                ArrayList<String> stat = new ArrayList<String>();
                for(int i = 0; i < rootNode.size(); i++){

                    JsonNode statsNode = rootNode.get("stats").get(i);

                    String tag = statsNode.get("tag").toString();
                    String tweets = statsNode.get("tweets").toString();
                    String retweets = statsNode.get("retweets").toString();
                    String mentions = statsNode.get("mentions").toString();
                    String photos = statsNode.get("photos").toString();
                    String links = statsNode.get("links").toString();
                    String exposure = statsNode.get("exposure").toString();


                    stat.add(tag);
                    stat.add(tweets);
                    stat.add(retweets);
                    stat.add(mentions);
                    stat.add(photos);
                    stat.add(links);
                    stat.add(exposure);

                    datas.add(stat);
                }*/


        } catch (IOException e) {
            e.printStackTrace();
        }

        response.close();

        return rootNode;
    }

}
