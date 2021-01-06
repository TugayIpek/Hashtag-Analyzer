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

public class APIServiceAnalyze {

        public ArrayList<String> APIAnalyze(String hashtag) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            ArrayList<String> datas = new ArrayList<String>();

            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url("https://api.ritekit.com/v1/stats/multiple-hashtags?tags="+ hashtag +"&client_id=d6af9902e1a806598d2c9342d4b61dd0e7db0a5e374c")
                    .method("GET", null)
                    .addHeader("client_id", "d6af9902e1a806598d2c9342d4b61dd0e7db0a5e374c")
                    .addHeader("Cookie", "RITEKIT=g3tcbsscnuf377k7rhd1fmcsiu")
                    .build();

            Response response = null;
            try {
                response = client.newCall(request).execute();
                System.out.println(response);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                String myJson = response.body().string();

                ObjectMapper mapper = new ObjectMapper();

                JsonNode rootNode = mapper.readTree(myJson);
                JsonNode statsNode = rootNode.get("stats").get(0);

                String tweets = statsNode.get("tweets").toString();
                String retweets = statsNode.get("retweets").toString();
                String mentions = statsNode.get("mentions").toString();
                String images = statsNode.get("images").toString();
                String links = statsNode.get("links").toString();
                String exposure = statsNode.get("exposure").toString();

                datas.add(tweets);
                datas.add(retweets);
                datas.add(mentions);
                datas.add(images);
                datas.add(links);
                datas.add(exposure);


                Log.i("a1b2c3", tweets + " - " + retweets + " - " + mentions);

            } catch (IOException e) {
                e.printStackTrace();
            }

            response.close();

            return datas;
        }

}
