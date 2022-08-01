package com.example.zenbednavdrawer.ui.draw;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DrawingViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DrawingViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}