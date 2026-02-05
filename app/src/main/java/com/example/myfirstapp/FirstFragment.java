package com.example.myfirstapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myfirstapp.databinding.FragmentFirstBinding;
import android.widget.Toast;


public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.toastButton.setOnClickListener(v -> {
            Toast myToast = Toast.makeText(getActivity(),
                    "Hello Toast!",
                    Toast.LENGTH_SHORT);
            myToast.show();
        });

        binding.countButton.setOnClickListener(v -> {
            String countString = binding.textviewFirst.getText().toString();
            int count = Integer.parseInt(countString);
            count++;
            binding.textviewFirst.setText(String.valueOf(count));
        });

        binding.randomButton.setOnClickListener(v -> {
            int currentCount = Integer.parseInt(binding.textviewFirst.getText().toString());

            Bundle bundle = new Bundle();
            bundle.putInt("myArg", currentCount);

            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}