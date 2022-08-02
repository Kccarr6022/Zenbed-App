package com.example.zenbednavdrawer.ui.patterns;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.zenbednavdrawer.R;
import com.example.zenbednavdrawer.databinding.FragmentPatternsBinding;

public class PatternsFragment extends Fragment {

    private PatternsViewModel PatternsViewModel;
    private FragmentPatternsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PatternsViewModel =
                new ViewModelProvider(this).get(com.example.zenbednavdrawer.ui.patterns.PatternsViewModel.class);

        binding = FragmentPatternsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = getActivity().findViewById(R.id.name);
        PatternsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}