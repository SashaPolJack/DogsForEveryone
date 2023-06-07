package com.example.dogsforall.UI.LoginView.ProfileDog;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.Dogs.DogsViewModel;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firestore.v1.Document;
import com.squareup.picasso.Picasso;

import org.checkerframework.common.subtyping.qual.Bottom;

public class ProfileDog extends Fragment {

    private ProfileDogViewModel mViewModel;

    public static ProfileDog newInstance() {
        return new ProfileDog();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_dog, container, false);
        DogsViewModel dogsViewModel = new ViewModelProvider(requireActivity()).get(DogsViewModel.class);

        ProfileDogViewModel profileDogViewModel = new ViewModelProvider(requireActivity()).get(ProfileDogViewModel.class);

        DocumentSnapshot dog = profileDogViewModel.getDogsRepsitory().getDocumentSnapshotMutableLiveData().getValue();
        TextView name = view.findViewById(R.id.name_dog);
        TextView desc = view.findViewById(R.id.desc_dog);
        ImageView imageView = view.findViewById(R.id.imageView25);
        Button button_sub = view.findViewById(R.id.take_but3);

        name.setText(dog.getData().get("name").toString());
        desc.setText(dog.getData().get("description").toString());
        Picasso.get().load(dog.getData().get("Image").toString()).into(imageView);
        Button botton = view.findViewById(R.id.take_but);
        button_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_profileDog_to_pay);
            }
        });
        botton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_profileDog_to_take2);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileDogViewModel.class);
        // TODO: Use the ViewModel
    }

}