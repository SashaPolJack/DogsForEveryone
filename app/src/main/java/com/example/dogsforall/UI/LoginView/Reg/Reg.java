package com.example.dogsforall.UI.LoginView.Reg;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dogsforall.MainActivity;
import com.example.dogsforall.Onboarding;
import com.example.dogsforall.R;
import com.example.dogsforall.UI.LoginView.AutoViewModal;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

public class Reg extends Fragment {

    private RegViewModel mViewModel;
    private NavController navigation;
    private AutoViewModal autoViewModal;
    private TextInputLayout editEmail,editPass,comPass;
    private TextInputLayout name;
    private Button singUpButton;
    private RegViewModel regViewModel;
    FirebaseFirestore database;
    private FirebaseFirestore mDatabase;

    public static Reg newInstance() {
        return new Reg();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        autoViewModal = new ViewModelProvider(this, (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())).get(AutoViewModal.class);
        database= FirebaseFirestore.getInstance();
        regViewModel =new ViewModelProvider(requireActivity()).get(RegViewModel.class);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navigation = Navigation.findNavController(view);


        editEmail = view.findViewById(R.id.textInputLayout);
        editPass = view.findViewById(R.id.textInputLayout4);
        name = view.findViewById(R.id.textInputLayout2);
        comPass = view.findViewById(R.id.textInputLayout3);
        singUpButton = view.findViewById(R.id.button_reg);
        singUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editEmail.getEditText().getText().toString();
                String pass = editPass.getEditText().getText().toString();
                String potpass = comPass.getEditText().getText().toString();
                String name_str = name.getEditText().getText().toString();
                User_new user = new User_new(name_str,email,pass);
                if (!email.isEmpty() && !pass.isEmpty() && !potpass.isEmpty() && !name_str.isEmpty()){
                    if (pass.equals(potpass)){
                        autoViewModal.singUp(email,pass);
                        autoViewModal.getFirebaseUserMutableLiveData().observe(getViewLifecycleOwner(), new Observer<FirebaseUser>() {
                            @Override
                            public void onChanged(FirebaseUser firebaseUser) {
                                if (firebaseUser != null){
                                    user.setId(autoViewModal.getCurrentUser().getUid());

                                    database.collection("Users").add(user);
                                    database.collection("Users").whereEqualTo("id",autoViewModal.getCurrentUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                            if (task.isSuccessful()) {
                                                for (DocumentSnapshot document : task.getResult()) {
                                                    System.out.println( document.getId() + " => " + document.getData());
                                                    regViewModel.getDataUserRepository().setCurrentUser(document);
                                                }
                                            } else {
                                                Toast.makeText(getActivity(), "Error getting documents:", Toast.LENGTH_SHORT).show();

                                            }
                                        }
                                    });
                                    //System.out.println( regViewModel.getDataUserRepository().getMutableLiveDataUser().getValue());
                                   // mDatabase.child("users").child(autoViewModal.getCurrentUser().getUid()).setValue(name_str);
                                    navigation.navigate(R.id.action_reg_to_dogs);
                                }
                            }
                        });
                    }else {

                        Toast.makeText(getContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(getContext(), "Пожалуйста, введите данные", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reg, container, false);

        Button reg_button = v.findViewById(R.id.button_reg);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent myIntent = new Intent(getActivity(), Onboarding.class);
//                startActivity(myIntent);

                Navigation.findNavController(v).navigate(R.id.action_reg_to_dogs);
            }
        });

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RegViewModel.class);
        // TODO: Use the ViewModel
    }

}