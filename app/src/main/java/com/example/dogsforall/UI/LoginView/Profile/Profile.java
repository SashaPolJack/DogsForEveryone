package com.example.dogsforall.UI.LoginView.Profile;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.Reg.RegViewModel;
import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class Profile extends Fragment {

    private ProfileViewModel mViewModel;
    private RegViewModel regViewModel;

    public static Profile newInstance() {
        return new Profile();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        regViewModel = new ViewModelProvider(requireActivity()).get(RegViewModel.class);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        TextView name = view.findViewById(R.id.name_user);
        TextView descr = view.findViewById(R.id.textView12);
        TextView dol_count = view.findViewById(R.id.dol_count);
        CircularFillableLoaders circularFillableLoaders = view.findViewById(R.id.circularFillableLoaders);
        TextView walk = view.findViewById(R.id.textView13);
        TextView sub = view.findViewById(R.id.textView14);
        TextView take = view.findViewById(R.id.textView15);

        walk.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("countWalk").toString());
        sub.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("countSubcribe").toString());
        take.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("countTake").toString());
        name.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("name_str").toString());
        descr.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("descr").toString());
        dol_count.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("dollars").toString() + " руб.");
        System.out.println(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("dollars").getClass());
        int dols=Math.toIntExact((Long) regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("dollars"));

        circularFillableLoaders.setProgress((int) (90 -  (dols/ 90)) );

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}