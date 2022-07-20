package com.example.myapplication.ui.receipt_other;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Receipt_OtherViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public Receipt_OtherViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}