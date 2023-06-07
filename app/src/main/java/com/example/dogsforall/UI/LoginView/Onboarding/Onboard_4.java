package com.example.dogsforall.UI.LoginView.Onboarding;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dogsforall.MainActivity;
import com.example.dogsforall.Onboarding;
import com.example.dogsforall.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Onboard_4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Onboard_4 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Onboard_4() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Onboard_4.
     */
    // TODO: Rename and change types and number of parameters
    public static Onboard_4 newInstance(String param1, String param2) {
        Onboard_4 fragment = new Onboard_4();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance() {
        Onboard_4 fragment = new Onboard_4();
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
        View view = inflater.inflate(R.layout.fragment_onboard_4, container, false);
        Button start = view.findViewById(R.id.button3);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), MainActivity.class);
                startActivity(myIntent);
            }
        });

        return view;
    }
}