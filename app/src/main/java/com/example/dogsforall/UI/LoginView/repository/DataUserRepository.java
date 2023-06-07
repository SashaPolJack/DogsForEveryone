package com.example.dogsforall.UI.LoginView.repository;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firestore.v1.Document;

public class DataUserRepository {

    private MutableLiveData<DocumentSnapshot> mutableLiveDataUser;

    public DataUserRepository(){
        mutableLiveDataUser = new MutableLiveData<>();

    }

    public void setCurrentUser(DocumentSnapshot user){
        mutableLiveDataUser.setValue(user);
    }


    public MutableLiveData<DocumentSnapshot> getMutableLiveDataUser() {
        return mutableLiveDataUser;
    }
}
