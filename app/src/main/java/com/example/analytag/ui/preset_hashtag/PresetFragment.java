package com.example.analytag.ui.preset_hashtag;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.analytag.R;

import java.util.ArrayList;
import java.util.List;

public class PresetFragment extends Fragment {


    private Button btn;
    private ArrayList<String> popularHashtags, countries, stocks, travel;
    ArrayAdapter<String> adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_preset, container, false);

        popularHashtags = new ArrayList<String>();

        popularHashtags.add("#turkey");
        popularHashtags.add("#erkensecim");
        popularHashtags.add("#dolar");
        popularHashtags.add("#euro");

        countries = new ArrayList<String>();

        countries.add("#istanbul");
        countries.add("#ankara");
        countries.add("#izmir");

        stocks = new ArrayList<String>();

        stocks.add("#thyao");
        stocks.add("#tupras");
        stocks.add("#ipeke");
        stocks.add("#aselsn");
        stocks.add("#ekgyo");
        stocks.add("#esen");
        stocks.add("#bimas");

        travel = new ArrayList<String>();

        travel.add("#travel");
        travel.add("#vacation");
        travel.add("#fun");
        travel.add("#travelwriter");



        //adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, popularHashtags);


        btn = view.findViewById(R.id.first_category);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFirstCategory();
            }
        });
        btn = view.findViewById(R.id.second_category);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSecondCategory();
            }
        });
        btn = view.findViewById(R.id.third_category);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openThirdCategory();
            }
        });
        btn = view.findViewById(R.id.fourth_category);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFourthCategory();
            }
        });

        return view;
    }

    public void openFirstCategory() {
        Intent intent = new Intent(getActivity().getApplicationContext(), FirstCategory.class);
        intent.putExtra("category", "Popular Hashtags");
        intent.putExtra("hashtagList", popularHashtags);
        startActivity(intent);

    }

    public void openSecondCategory() {
        Intent intent = new Intent(getActivity().getApplicationContext(), FirstCategory.class);
        intent.putExtra("category", "Countries");
        intent.putExtra("hashtagList", countries);
        startActivity(intent);

    }

    public void openThirdCategory() {
        Intent intent = new Intent(getActivity().getApplicationContext(), FirstCategory.class);
        intent.putExtra("category", "Stocks");
        intent.putExtra("hashtagList", stocks);
        startActivity(intent);

    }

    public void openFourthCategory() {
        Intent intent = new Intent(getActivity().getApplicationContext(), FirstCategory.class);
        intent.putExtra("category", "Travel");
        intent.putExtra("hashtagList", travel);
        startActivity(intent);

    }

}