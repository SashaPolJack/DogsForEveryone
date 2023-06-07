package com.example.dogsforall.UI.LoginView.Onboarding;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogsforall.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Onboard_1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Onboard_1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Onboard_1() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Onboard_1 newInstance() {
        Onboard_1 fragment = new Onboard_1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboard_1, container, false);
    }
}