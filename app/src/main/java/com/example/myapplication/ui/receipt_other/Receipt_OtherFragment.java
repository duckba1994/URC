package com.example.myapplication.ui.receipt_other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentReceiptOtherBinding;
import com.example.myapplication.ui.receipt_other.Receipt_OtherViewModel;

public class Receipt_OtherFragment extends Fragment {

    private FragmentReceiptOtherBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Receipt_OtherViewModel scaninViewModel =
                new ViewModelProvider(this).get(Receipt_OtherViewModel.class);

        binding = FragmentReceiptOtherBinding.inflate(inflater, container, false);
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