package com.example.myapplication.ui.movement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.databinding.FragmentMovementBinding;

import com.example.myapplication.ui.movement.MovementViewModel;

public class MovementFragment extends Fragment {

    private FragmentMovementBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MovementViewModel scaninViewModel =
                new ViewModelProvider(this).get(MovementViewModel.class);

        binding = FragmentMovementBinding.inflate(inflater, container, false);
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