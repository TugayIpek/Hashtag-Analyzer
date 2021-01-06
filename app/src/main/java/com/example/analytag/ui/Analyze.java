package com.example.analytag.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.TextView;

import com.example.analytag.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Analyze extends AppCompatActivity {

    TextView tv_tag, tv_tweets, tv_retweets, tv_mentions, tv_images, tv_links, tv_exposures;

    String tag;
    ArrayList<String> datas = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        Bundle intent = getIntent().getExtras();
        tag = intent.getString("tag");
        datas = intent.getStringArrayList("datas");

        tv_tag = findViewById(R.id.tv_tag);
        tv_tweets = findViewById(R.id.tv_tweets);
        tv_retweets = findViewById(R.id.tv_retweets);
        tv_mentions = findViewById(R.id.tv_mentions);
        tv_images = findViewById(R.id.tv_images);
        tv_links = findViewById(R.id.tv_links);
        tv_exposures = findViewById(R.id.tv_exposures);

        tv_tag.setText("#"+tag);
        tv_tweets.setText(datas.get(0));
        tv_retweets.setText(datas.get(1));
        tv_mentions.setText((Float.toString(Float.parseFloat(new DecimalFormat("##.##").format(Float.parseFloat(datas.get(2))*100))))+"%");
        tv_images.setText((Float.toString(Float.parseFloat(new DecimalFormat("##.##").format(Float.parseFloat(datas.get(3))*100))))+"%");
        tv_links.setText((Float.toString(Float.parseFloat(new DecimalFormat("##.##").format(Float.parseFloat(datas.get(4))*91))))+"%");
        tv_exposures.setText(datas.get(5));

    }
}