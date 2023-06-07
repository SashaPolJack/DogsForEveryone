package com.example.dogsforall.UI.LoginView.Priutes;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogsforall.R;


public class Priuts extends Fragment {

    private PriutsViewModel mViewModel;

    public static Priuts newInstance() {
        return new Priuts();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_priuts, container, false);
        PriutsViewModel priutsViewModel = new ViewModelProvider(requireActivity()).get(PriutsViewModel.class);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewPager2 viewPager2 = view.findViewById(R.id.viewpage2_pr);
        ViewPage2Adapter_priut viewPage2Adapter_priut = new ViewPage2Adapter_priut(getContext(),priutsViewModel.getPriutsRepsitory().getMutableLiveDataUser().getValue());
        viewPager2.setAdapter(viewPage2Adapter_priut);
        viewPager2.setOffscreenPageLimit(3);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PriutsViewModel.class);
        // TODO: Use the ViewModel
    }

}