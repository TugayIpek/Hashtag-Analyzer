package com.example.analytag.ui.preset_hashtag;

import android.os.Bundle;

import com.example.analytag.ui.CategoryAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.analytag.R;

import java.util.ArrayList;

public class FirstCategory extends AppCompatActivity {
    ListView lv_list;
    TextView tv_category;
    String category;
    ArrayList<String> hashtagList;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_category);


        hashtagList = getIntent().getExtras().getStringArrayList("hashtagList");
        adapter = new CategoryAdapter(this,hashtagList);
        lv_list = findViewById(R.id.lv_list);
        lv_list.setAdapter(adapter);

        tv_category = findViewById(R.id.tv_category);
        category = getIntent().getExtras().getString("category");
        tv_category.setText(category);


    }
}