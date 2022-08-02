package com.example.zenbednavdrawer.ui.patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PatternsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PatternsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Zenbed Settings");
    }

    public LiveData<String> getText() {
        return mText;
    }
}