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
import com.example.dogsforall.UI.LoginView.AutoViewModal;
import com.example.dogsforall.UI.LoginView.ProfileDog.ProfileDogViewModel;
import com.example.dogsforall.UI.LoginView.Reg.RegViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

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
        AutoViewModal autoViewModal =new ViewModelProvider(requireActivity()).get(AutoViewModal.class);
        mViewModel = new ViewModelProvider(requireActivity()).get(DogsViewModel.class);
        ViewPager2Adapter viewPager2Adapter = new ViewPager2Adapter(getContext(),mViewModel.getDogsRepsitory().getMutableLiveDataUser().getValue(),profileDogViewModel);
        viewpage2.setAdapter(viewPager2Adapter);
        viewpage2.setOffscreenPageLimit(3);
        CardView navigationView = getActivity().findViewById(R.id.card_nav);
        navigationView.setVisibility(View.VISIBLE);
        RegViewModel regViewModel =new ViewModelProvider(requireActivity()).get(RegViewModel.class);
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        database.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot document : task.getResult()) {

                        if (autoViewModal.getCurrentUser().getEmail().equals(document.getData().get("email").toString().toLowerCase())){

                            regViewModel.getDataUserRepository().setCurrentUser(document);
                        }
                    }
                }
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(DogsViewModel.class);
        // TODO: Use the ViewModel
    }

}