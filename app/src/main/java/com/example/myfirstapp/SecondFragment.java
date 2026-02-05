package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapp.databinding.FragmentSecondBinding;
import java.util.Random;
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get the count argument
        int count = 0;
        if (getArguments() != null) {
            count = getArguments().getInt("myArg", 0);
        }

        // Set the header text
        String countText = getString(R.string.random_heading, count);
        binding.textviewHeader.setText(countText);

        // Generate random number
        Random random = new Random();
        int randomNumber = 0;
        if (count > 0) {
            randomNumber = random.nextInt(count + 1);
        }

        // Display random number
        binding.textviewRandom.setText(String.valueOf(randomNumber));

        // Previous button listener
        binding.buttonSecond.setOnClickListener(v2 ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}