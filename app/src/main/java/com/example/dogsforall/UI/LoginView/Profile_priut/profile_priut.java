package com.example.dogsforall.UI.LoginView.Profile_priut;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogsforall.R;

public class profile_priut extends Fragment {

    private ProfilePriutViewModel mViewModel;

    public static profile_priut newInstance() {
        return new profile_priut();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_priut, container, false);

       RecyclerView recycle_list = view.findViewById(R.id.recycle_dog_home);
       RecycleAdapterDog recycleAdapterDog = new RecycleAdapterDog(getContext());

       recycle_list.setAdapter(recycleAdapterDog);
       recycle_list.setLayoutManager(new LinearLayoutManager(getContext()));


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfilePriutViewModel.class);
        // TODO: Use the ViewModel
    }

}