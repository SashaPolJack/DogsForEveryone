package com.example.dogsforall.UI.LoginView.Profile;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.AutoViewModal;
import com.example.dogsforall.UI.LoginView.Reg.RegViewModel;
import com.mikhaellopez.circularfillableloaders.CircularFillableLoaders;

public class Profile extends Fragment {

    private ProfileViewModel mViewModel;
    private RegViewModel regViewModel;
    private AutoViewModal autoViewModal;

    public static Profile newInstance() {
        return new Profile();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        regViewModel = new ViewModelProvider(requireActivity()).get(RegViewModel.class);
        autoViewModal = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(AutoViewModal.class);


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
        ImageView button_out = view.findViewById(R.id.imageView22);
        if (regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().getData().get("dogs") != null){
            String dogs_pr = regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().getData().get("dogs").toString();



            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = view.findViewById(R.id.rec_dogs_prof);

            AdapterDogs adapterDogs = new AdapterDogs(getContext(),dogs_pr);
            recyclerView.setAdapter(adapterDogs);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }


        walk.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("countWalk").toString());
        sub.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("countSubcribe").toString());
        take.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("countTake").toString());
        name.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("name_str").toString());
        descr.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("descr").toString());
        dol_count.setText(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("dollars").toString() + " руб.");
        System.out.println(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("dollars").getClass());
        int dols=Math.toIntExact((Long) regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue().get("dollars"));

        circularFillableLoaders.setProgress((int) (90 -  (dols/ 90)) );
        button_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoViewModal.singOut();
                Navigation.findNavController(v).navigate(R.id.action_profile2_to_login);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
        // TODO: Use the ViewModel
    }

}