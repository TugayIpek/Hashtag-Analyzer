package com.example.analytag.ui.mylist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MylistViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MylistViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is mylist fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}