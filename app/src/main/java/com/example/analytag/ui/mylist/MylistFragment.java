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

    Button addButton_myL, saveButton, editButton;
    LinearLayout myContent;

    Animation fromsmall ;

    EditText titleTag, yourTag, yourTag2, yourTag3;

    TextView titleTextView, tagTextView, tagTextView2, tagTextView3, tagFirst, tagSecond, tagThird;


    List titleTagList = new ArrayList();
    List yourTagList ;// = new ArrayList();

    public MylistFragment() {
        this.yourTagList = new ArrayList();
        System.out.println(yourTagList);
    }



    private MylistViewModel mylistViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mylistViewModel =
                ViewModelProviders.of(this).get(MylistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_mylist, container, false);


        addButton_myL =(Button) root.findViewById(R.id.addButton1_myList);

        addButton_myL = (Button) root.findViewById(R.id.addButton1_myList);

        saveButton = (Button) root.findViewById(R.id.buttonSave);
        editButton = (Button) root.findViewById(R.id.editButton_myList);
        editButton.setAlpha(0);

        myContent = (LinearLayout) root.findViewById(R.id.myContent);

        fromsmall = AnimationUtils.loadAnimation(getContext(), R.anim.fromsmall);
        myContent.setAlpha(0);

        titleTag = (EditText) root.findViewById(R.id.titleId);
        yourTag = (EditText) root.findViewById(R.id.yourTagId);
        yourTag2 = (EditText) root.findViewById(R.id.yourTagId2);
        yourTag3 = (EditText) root.findViewById(R.id.yourTagId3);

        tagFirst = (TextView) root.findViewById(R.id.tagFirstId);
        tagSecond = (TextView) root.findViewById(R.id.tagSecondId);
        tagThird = (TextView) root.findViewById(R.id.tagThirdId);
        tagFirst.setAlpha(0);
        tagSecond.setAlpha(0);
        tagThird.setAlpha(0);

        titleTextView = (TextView) root.findViewById(R.id.titleFirstId);
        tagTextView = (TextView) root.findViewById(R.id.tagFirstId);
        tagTextView2 = (TextView) root.findViewById(R.id.tagSecondId);
        tagTextView3 = (TextView) root.findViewById(R.id.tagThirdId);


        addButton_myL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myContent.setAlpha(1);
                myContent.startAnimation(fromsmall);
            }
        });






        saveButton.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                titleTagList.add(titleTag.getText().toString());
                yourTagList.add(yourTag.getText().toString());
                yourTagList.add(yourTag2.getText().toString());
                yourTagList.add(yourTag3.getText().toString());


                myContent.setAlpha(0);

                titleTextView.setText((CharSequence) titleTagList.get(0));


                tagTextView.setText((CharSequence) yourTagList.get(0));
                if(tagTextView.getText().equals("") != true)
                    tagFirst.setAlpha(1);
                tagTextView2.setText((CharSequence) yourTagList.get(1));
                if(tagTextView2.getText().equals("") != true)
                    tagSecond.setAlpha(1);
                tagTextView3.setText((CharSequence) yourTagList.get(2));
                if(tagTextView3.getText().equals("") != true)
                    tagThird.setAlpha(1);

                editButton.setAlpha(1);


            }
        });
        System.out.println(yourTagList);

        return root;
    }

    public List hashtagHistory(String hashtag) {

        return null;
    }

    public List hashtagFavorite(String hashtag) {

        return null;
    }

}