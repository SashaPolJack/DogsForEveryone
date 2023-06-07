package com.example.dogsforall.UI.LoginView.Pay;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dogsforall.R;

public class Pay extends Fragment {

    private PayViewModel mViewModel;

    public static Pay newInstance() {
        return new Pay();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay, container, false);
        ViewPager2 viewPager2 = view.findViewById(R.id.viewPager2_pay);
        ViewpageAdapterPya viewpageAdapterPya = new ViewpageAdapterPya(getContext());
        viewPager2.setAdapter(viewpageAdapterPya);
        Button button_800 = view.findViewById(R.id.button4);
        Button button_1600 = view.findViewById(R.id.button2);
        Button button_2000 = view.findViewById(R.id.button9);
        Button button_10000 = view.findViewById(R.id.button8);
        CardView navigationView = getActivity().findViewById(R.id.card_nav);
        navigationView.setVisibility(View.VISIBLE);
        button_800.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_800.setBackgroundColor(Color.parseColor("#8AED660B"));
                button_1600.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_2000.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_10000.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });

        button_1600.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_800.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_1600.setBackgroundColor(Color.parseColor("#8AED660B"));
                button_2000.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_10000.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        button_2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_800.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_1600.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_2000.setBackgroundColor(Color.parseColor("#8AED660B"));
                button_10000.setBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
        button_10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button_800.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_1600.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_2000.setBackgroundColor(Color.parseColor("#FFFFFF"));
                button_10000.setBackgroundColor(Color.parseColor("#8AED660B"));
            }
        });
        return  view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PayViewModel.class);
        // TODO: Use the ViewModel
    }

}