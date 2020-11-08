package com.example.analytag.ui.mylist;

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

public class MylistFragment extends Fragment {

    private MylistViewModel mylistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mylistViewModel =
                ViewModelProviders.of(this).get(MylistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mylist, container, false);

        return root;
    }

    public List hashtagHistory(String hashtag){

        return null;
    }

    public List hashtagFavorite(String hashtag){

        return null;
    }

}