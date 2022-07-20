package com.example.myapplication.ui.scanin;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScaninViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ScaninViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Scan In fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}