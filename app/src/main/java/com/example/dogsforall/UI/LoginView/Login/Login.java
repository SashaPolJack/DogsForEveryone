package com.example.dogsforall.UI.LoginView.Login;

import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.AutoViewModal;
import com.example.dogsforall.UI.LoginView.Reg.RegViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Collections;

public class Login extends Fragment {

    private LoginViewModel mViewModel;
    private NavController navigation;
    private AutoViewModal autoViewModal;
    private TextInputLayout editEmail,editPass;
    private Button singInButton;
    FirebaseFirestore database;
    private RegViewModel regViewModel;

    public static Login newInstance() {
        return new Login();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigation = Navigation.findNavController(view);
        editEmail = view.findViewById(R.id.textInputLayout2);
        editPass = view.findViewById(R.id.textInputLayout3);
        regViewModel =  new ViewModelProvider(requireActivity()).get(RegViewModel.class);
        singInButton = view.findViewById(R.id.button);
        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getEditText().getText().toString();
                String pass = editPass.getEditText().getText().toString();

                if (!email.isEmpty() && !pass.isEmpty()){
                        autoViewModal.singIn(email,pass);
                        autoViewModal.getFirebaseUserMutableLiveData().observe(getViewLifecycleOwner(), new Observer<FirebaseUser>() {
                            @Override
                            public void onChanged(FirebaseUser firebaseUser) {
                                if (firebaseUser != null){

                                    database.collection("Users").whereEqualTo("email",email.toString()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            if (task.isSuccessful()) {
                                                for (DocumentSnapshot document : task.getResult()) {
                                                    System.out.println( document.getId() + " => " + document.getData());
                                                    regViewModel.getDataUserRepository().setCurrentUser(document);
                                                    System.out.println(regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue());
                                                }
                                            } else {
                                                Toast.makeText(getActivity(), "Error getting documents:", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    });
                                    navigation.navigate(R.id.action_login_to_dogs);
                                }
                            }
                        });


                }else {
                    Toast.makeText(getContext(), "Пожалуйста, введите данные", Toast.LENGTH_SHORT).show();
                }
            }
        });



           }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = FirebaseFirestore.getInstance();
        autoViewModal = new ViewModelProvider(requireActivity()).get(AutoViewModal.class);
        Handler handler = new Handler();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (autoViewModal.getCurrentUser() != null){



                    database.collection("Users").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful()){
                                for (DocumentSnapshot document : task.getResult()) {

                                    if (autoViewModal.getCurrentUser().getEmail().equals(document.getData().get("email").toString().toLowerCase())){
                                        System.out.println(document.getData());
                                        regViewModel.getDataUserRepository().setCurrentUser(document);
                                    }
                                }
                            }
                        }
                    });

                    navigation.navigate(R.id.action_login_to_dogs);
                }
            }
        },4000);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.fragment_login, container, false);
        Button reg_but = v.findViewById(R.id.button_reg);
        Button log_but = v.findViewById(R.id.button);
        CardView navigationView = getActivity().findViewById(R.id.card_nav);
        navigationView.setVisibility(View.GONE);



        reg_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.action_login_to_reg);
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

}