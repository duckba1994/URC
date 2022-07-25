package com.example.myapplication.ui.scanin;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.myapplication.R;

public class PopUpDatailProductFragment extends DialogFragment implements View.OnClickListener {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_INPUT, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog d = getDialog();
        if (d != null) {
            int width = ViewGroup.LayoutParams.WRAP_CONTENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;

            d.getWindow().setGravity(Gravity.CENTER | Gravity.BOTTOM);

            d.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.popup_detailproduct, container, false);

        // get a variable from MainActivity.java when calling this Dialog. The variable is in the form of key and value.
        Bundle mArgs = getArguments();

        String msg = mArgs.getString("key");
        String thisTitle = mArgs.getString("title");


        final TextView header = (TextView) root.findViewById(R.id.header_text);
        header.setText(thisTitle);

//        final TextView myMsg =  (TextView) root.findViewById(R.id.expText);
//        myMsg.setText(msg);
//        myMsg.setTextSize(20);

        Button btnOK = (Button) root.findViewById(R.id.btnExpOK);
        btnOK.setOnClickListener(PopUpDatailProductFragment.this);
        return root;
    }

    @Override
    public void onClick(View view) {
        dismiss();

    }
}