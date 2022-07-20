package com.example.myapplication.ui.scanin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentScanInBinding;

public class ScanInFragment extends Fragment {

    private FragmentScanInBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ScaninViewModel scaninViewModel =
                new ViewModelProvider(this).get(ScaninViewModel.class);

        binding = FragmentScanInBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




//        final TextView textView = binding.txtWelcome;
//        final TextView textView =

//        scaninViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
