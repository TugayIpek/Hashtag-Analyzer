package com.example.analytag.ui.mylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.analytag.R;

import java.util.ArrayList;
import java.util.List;

public class MylistFragment extends Fragment {

    Button addButton_myL, saveButton;
    LinearLayout myContent;
    Animation fromsmall ;
    EditText titleTag, yourTag;
    TextView titleTextView;
    List titleTagList = new ArrayList();
    List yourTagList = new ArrayList();

    private MylistViewModel mylistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mylistViewModel =
                ViewModelProviders.of(this).get(MylistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mylist, container, false);
        addButton_myL =(Button) root.findViewById(R.id.addButton1_myList);
        saveButton = (Button) root.findViewById(R.id.buttonSave);
        myContent = (LinearLayout) root.findViewById(R.id.myContent);
        fromsmall = AnimationUtils.loadAnimation(getContext(), R.anim.fromsmall);
        myContent.setAlpha(0);
        titleTag = (EditText) root.findViewById(R.id.titleId);
        yourTag = (EditText) root.findViewById(R.id.yourTagId);

        titleTextView = (TextView) root.findViewById(R.id.titleFirstId);

        addButton_myL.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                myContent.setAlpha(1);
                myContent.startAnimation(fromsmall);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                yourTagList.add(yourTag.getText().toString());
                titleTagList.add(titleTag.getText().toString());
                titleTextView.setText((CharSequence) titleTagList.get(0));
                System.out.println(yourTagList.get(0));
                System.out.println(titleTagList.get(0));
                myContent.setAlpha(0);
            }
        });
        return root;
    }

    public List hashtagHistory(String hashtag){

        return null;
    }

    public List hashtagFavorite(String hashtag){

        return null;
    }

}