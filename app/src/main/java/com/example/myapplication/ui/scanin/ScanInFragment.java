package com.example.myapplication.ui.scanin;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import static androidx.core.content.ContextCompat.getSystemService;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentScanInBinding;

public class ScanInFragment extends Fragment implements View.OnClickListener {

    private FragmentScanInBinding binding;
    private View view;
    private  View view_popup;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        ScaninViewModel scaninViewModel =
                new ViewModelProvider(this).get(ScaninViewModel.class);

        view = inflater.inflate(R.layout.fragment_scan_in, container, false);

        TextView txt_view = (TextView) view.findViewById(R.id.txt_rfid112);
        scaninViewModel.getText().observe(getViewLifecycleOwner(), txt_view::setText);
        init();
        return view;
    }

    private void init() {
        Button btn = (Button) view.findViewById(R.id.btn_search_rfid);
        btn.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id) {

            case R.id.btn_search_rfid:

//                DialogFragment dialog
//                        = new DialogFragment();
//                dialog.show(getFragmentManager(),
//                        "MyCustomDialog");

//                final Dialog fbDialogue = new Dialog(this.getContext(), android.R.style.Theme_Black_NoTitleBar);
//
//                fbDialogue.getWindow().setBackgroundDrawable(new ColorDrawable(Color.argb(100, 0, 0, 0)));
//                fbDialogue.setContentView(R.layout.popup_window);
//
//                fbDialogue.setCancelable(true);
//                fbDialogue.show();
                break;
        }
    }
}
