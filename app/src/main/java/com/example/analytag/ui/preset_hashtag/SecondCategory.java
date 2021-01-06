package com.example.analytag.ui.preset_hashtag;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.analytag.R;
import com.example.analytag.ui.APIServiceAnalyze;
import com.example.analytag.ui.Analyze;

import java.util.ArrayList;

public class SecondCategory extends AppCompatActivity {
    ListView lv_list;
    TextView tv_category;
    String category;
    ArrayList<String> hashtagList;
    CategoryAdapter adapter;
    APIServiceAnalyze analyze = new APIServiceAnalyze();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_category);

        hashtagList = getIntent().getExtras().getStringArrayList("hashtagList");
        adapter = new CategoryAdapter(this,hashtagList);
        lv_list = findViewById(R.id.lv_list);
        lv_list.setAdapter(adapter);

        tv_category = findViewById(R.id.tv_category);
        category = getIntent().getExtras().getString("category");
        tv_category.setText(category);
        clickList();
    }

    private void clickList(){

        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String tag = hashtagList.get(i);

                ArrayList<String> datas = null;
                datas =analyze.APIAnalyze(tag);

                Intent intent = new Intent(getApplicationContext(), Analyze.class);
                intent.putExtra("tag",tag);
                intent.putExtra("datas", datas);
                startActivity(intent);

            }


        });
    }
}