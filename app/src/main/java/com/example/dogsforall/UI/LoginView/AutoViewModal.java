package com.example.dogsforall.UI.LoginView;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.dogsforall.UI.LoginView.repository.AuotoRepository;
import com.google.firebase.auth.FirebaseUser;

public class AutoViewModal extends AndroidViewModel {
    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private FirebaseUser currentUser;
    private AuotoRepository repository;

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public FirebaseUser getCurrentUser() {
        return repository.getCurrentuser();
    }


    public AutoViewModal(@NonNull Application application) {
        super(application);

        repository = new AuotoRepository(application);
        currentUser = repository.getCurrentuser();
        firebaseUserMutableLiveData = repository.getFirebaseUserMutableLiveData();

    }

    public void singUp(String email, String pass){
        repository.singUp(email, pass);

    }
    public void singIn(String email,String pass){
        repository.singIn(email, pass);
    }
    public void singOut(){
        repository.singOut();
    }
}
