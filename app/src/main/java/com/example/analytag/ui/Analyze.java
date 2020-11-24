package com.example.analytag.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.analytag.R;

public class Analyze extends AppCompatActivity {

    TextView tv_tag, tv_commentnum, tv_likesnum, tv_postsnum;

    String tag;
    int i;
    int [][] values = {{20,1200,71},{15,1400,41},{20,650,21},{15,600,33},{222,523,49},{111,290,49},{29,554,88}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analyze);

        Bundle intent = getIntent().getExtras();
        tag = intent.getString("hashtagList.get(i)");
        i = intent.getInt("i");

        tv_tag = findViewById(R.id.tv_tag);
        tv_commentnum = findViewById(R.id.tv_commentnum);
        tv_likesnum = findViewById(R.id.tv_likesnum);
        tv_postsnum = findViewById(R.id.tv_postsnum);

        tv_tag.setText(tag);
        tv_commentnum.setText((Integer.toString( values[i][0])));
        tv_likesnum.setText((Integer.toString( values[i][1])));
        tv_postsnum.setText((Integer.toString( values[i][2])));

    }
}