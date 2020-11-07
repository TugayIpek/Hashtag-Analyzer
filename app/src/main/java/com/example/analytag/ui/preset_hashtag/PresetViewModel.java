package com.example.analytag.ui.preset_hashtag;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PresetViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PresetViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is preset fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}