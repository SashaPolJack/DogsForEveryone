package com.example.dogsforall.UI.LoginView.Dogs;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.ProfileDog.ProfileDogViewModel;
import com.google.firebase.firestore.FirebaseFirestore;

public class Dogs extends Fragment {

    private DogsViewModel mViewModel;


    public static Dogs newInstance() {
        return new Dogs();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dogs, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ViewPager2 viewpage2 = view.findViewById(R.id.viewpage2);
        ProfileDogViewModel profileDogViewModel = new ViewModelProvider(requireActivity()).get(ProfileDogViewModel.class);

        mViewModel = new ViewModelProvider(requireActivity()).get(DogsViewModel.class);
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(getContext(),mViewModel.getDogsRepsitory().getMutableLiveDataUser().getValue(),profileDogViewModel);
        viewpage2.setAdapter(viewPager2Adapter);
        viewpage2.setOffscreenPageLimit(3);
        CardView navigationView = getActivity().findViewById(R.id.card_nav);
        navigationView.setVisibility(View.VISIBLE);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DogsViewModel.class);
        // TODO: Use the ViewModel
    }

}