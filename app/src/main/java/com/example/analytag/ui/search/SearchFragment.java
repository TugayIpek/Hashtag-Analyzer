package com.example.analytag.ui.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.analytag.R;
import com.example.analytag.ui.APIServiceAnalyze;
import com.example.analytag.ui.Analyze;
import com.example.analytag.ui.preset_hashtag.FirstCategory;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    EditText myEditText;
    Button analyze_button;
    String tag;
    APIServiceAnalyze analyze = new APIServiceAnalyze();

    private List hashtagData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        myEditText = (EditText) root.findViewById(R.id.myEditText);
        analyze_button = (Button) root.findViewById(R.id.analyze_button);
        click();

        return root;
    }

    private void click(){
        analyze_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tag = myEditText.getText().toString();

                ArrayList<String> datas = null;
                datas =analyze.APIAnalyze(tag);

                Intent intent = new Intent(getActivity().getApplicationContext(), Analyze.class);
                intent.putExtra("tag", tag);
                intent.putExtra("datas", datas);
                startActivity(intent);

            }
        });
    }

    public List searchHashtag(String hashtag){

        return  null;
    }

    public List analyzerHashtag(List hashtagData){

        return null;
    }

    public List relatedHashtag(String hashtag){

        return null;
    }


    public List getHashtagData() {
        return hashtagData;
    }
}