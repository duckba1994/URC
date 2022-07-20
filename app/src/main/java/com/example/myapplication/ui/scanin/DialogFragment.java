package com.example.myapplication.ui.scanin;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Dialog;
import androidx.annotation.Nullable;

public class DialogFragment extends android.app.DialogFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.DialogFragment, container, false);
        View view1 ;
//        mActionCancel = view.findViewById(R.id.action_cancel);
//        mActionOk = view.findViewById(R.id.action_ok);
//        mInput = view.findViewById(R.id.input);

//        mActionCancel.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override public void onClick(View v)
//                    {
//                        Log.d(TAG, "onClick: closing dialog");
//                        getDialog().dismiss();
//                    }
//                });

//        mActionOk.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override public void onClick(View v)
//                    {
//                        Log.d(TAG, "onClick: capturing input");
//                        String input
//                                = mInput.getText().toString();
//                        mOnInputListener.sendInput(input);
//                        getDialog().dismiss();
//                    }
//                });

        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
