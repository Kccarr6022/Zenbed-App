package com.example.zenbednavdrawer.ui.home;

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
import com.example.zenbednavdrawer.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private HomeViewModel HomeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        LayoutInflater lf = getActivity().getLayoutInflater();
        //View view =  lf.inflate(R.layout.fragment_home, container, false); //pass the correct layout name for the fragment




        final TextView textView = getActivity().findViewById(R.id.title_name);
        HomeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText("test");
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