package com.example.analytag.ui.preset_hashtag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.analytag.R;

import java.util.List;

public class PresetFragment extends Fragment {

    private Button btn;
    private PresetViewModel presetViewModel;

    public List getHashtagCategories() {
        return hashtagCategories;
    }

    private List hashtagCategories;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_preset, container, false);

        btn = view.findViewById(R.id.first_category);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstCategory();
            }
        });

        return view;
    }

    public void openFirstCategory(){
        Intent intent = new Intent(getActivity(), FirstCategory.class);
        startActivity(intent);

    }

    public List hastagCategories(List hashtagCategories){

        return null;
    }
}