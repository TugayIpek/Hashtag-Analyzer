package com.example.analytag.ui.preset_hashtag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.analytag.R;

import java.util.List;

public class PresetFragment extends Fragment {

    private PresetViewModel presetViewModel;

    public List getHashtagCategories() {
        return hashtagCategories;
    }

    private List hashtagCategories;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        presetViewModel =
                ViewModelProviders.of(this).get(PresetViewModel.class);

        View root = inflater.inflate(R.layout.fragment_preset, container, false);

        return root;
    }

    public List popularHashtag(){

        return null;
    }

    public List hastagCategories(List hashtagCategories){

        return null;
    }
}