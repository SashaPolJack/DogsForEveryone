package com.example.dogsforall;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.example.dogsforall.UI.LoginView.AutoViewModal;
import com.example.dogsforall.UI.LoginView.Dogs.Dogs;
import com.example.dogsforall.UI.LoginView.Dogs.DogsViewModel;
import com.example.dogsforall.UI.LoginView.Priutes.Priuts;
import com.example.dogsforall.UI.LoginView.Priutes.PriutsViewModel;
import com.example.dogsforall.UI.LoginView.Profile.Profile;
import com.example.dogsforall.UI.LoginView.Reg.RegViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActionBar toolbar;
    FirebaseFirestore firebaseFirestore;
    private NavController navigations;
    private List<DocumentSnapshot> arrayDogsf;
    private List<DocumentSnapshot> arrayPriuts;
    private FirebaseFirestore database;
    private DogsViewModel dogsViewModel;
    private PriutsViewModel priutsViewModel;
    private AutoViewModal autoViewModal;
    private RegViewModel regViewModel;

    private NavController navController;



    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dogsViewModel =new ViewModelProvider(this).get(DogsViewModel.class);
        priutsViewModel =new ViewModelProvider(this).get(PriutsViewModel.class);
        autoViewModal = new ViewModelProvider(this).get(AutoViewModal.class);
        database = FirebaseFirestore.getInstance();




        database.collection("Dogs").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    arrayDogsf = task.getResult().getDocuments();
                    dogsViewModel.getDogsRepsitory().setDogs(arrayDogsf);

                }
            }
        });
        database.collection("Priuts").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    arrayPriuts = task.getResult().getDocuments();
                    priutsViewModel.getPriutsRepsitory().setPriut(arrayPriuts);

                }
            }
        });




        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.nav_bottom_bar);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemselectedListener);

        navigation.setOnItemSelectedListener(item -> {
            if (Navigation.findNavController(this, R.id.fragmentContainerView3).getCurrentDestination()
                    == Navigation.findNavController(this, R.id.fragmentContainerView3).findDestination(R.id.dogs)){
                if (item.getItemId() == R.id.dogs_fr){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_dogs_self);
                }else if(item.getItemId() ==R.id.priut_fr){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_dogs_to_priuts);
                }else if (item.getItemId() ==R.id.profile){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_dogs_to_profile2);
                }

            }
            if (Navigation.findNavController(this, R.id.fragmentContainerView3).getCurrentDestination()
                    == Navigation.findNavController(this, R.id.fragmentContainerView3).findDestination(R.id.priuts)){
                if (item.getItemId() == R.id.dogs_fr){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_priuts_to_dogs);
                }else if(item.getItemId() ==R.id.priut_fr){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_priuts_self);
                }else if (item.getItemId() ==R.id.profile){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_priuts_to_profile2);
                }

            }
            if (Navigation.findNavController(this, R.id.fragmentContainerView3).getCurrentDestination()
                    == Navigation.findNavController(this, R.id.fragmentContainerView3).findDestination(R.id.profile2)){
                if (item.getItemId() == R.id.dogs_fr){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_profile2_to_dogs);
                }else if(item.getItemId() ==R.id.priut_fr){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_profile2_to_priuts);
                }else if (item.getItemId() ==R.id.profile){
                    Navigation.findNavController(this, R.id.fragmentContainerView3).
                            navigate(R.id.action_profile2_self);
                }

            }


            return true;
        });

    }

    @SuppressLint("NonConstantResourceId")
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemselectedListener
            = (item) ->{
        if(item.getItemId() == R.id.dogs_fr){

            loadFragment(new Dogs());
            return true;
        }else if(item.getItemId() == R.id.priut_fr){

            loadFragment(new Priuts());
            return true;
        }else if (item.getItemId() == R.id.profile){

            loadFragment(new Profile());
            return true;
        }
            return false;
    };
    private void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.fragmentContainerView3,fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}