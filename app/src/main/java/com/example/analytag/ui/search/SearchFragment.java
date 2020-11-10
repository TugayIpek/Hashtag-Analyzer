package com.example.analytag.ui.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.analytag.R;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    SearchView mySearchView;
    ListView myList;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    private List hashtagData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_search, container, false);

        mySearchView = (SearchView) root.findViewById(R.id.searchView);
        myList = (ListView) root.findViewById(R.id.myList);

        list = new ArrayList<String>();

        list.add("#esen");
        list.add("#esenbogaelektrik");
        list.add("#dolar");
        list.add("#euro");
        list.add("#ipeke");
        list.add("#bist30");
        list.add("#naten");
        list.add("#yılmaz");
        list.add("#tugay");
        list.add("#bist30");
        list.add("#naten");
        list.add("#yılmaz");
        list.add("#tugay");

        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        myList.setAdapter(adapter);

        mySearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return root;
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