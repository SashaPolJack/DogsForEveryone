package com.example.dogsforall.UI.LoginView.repository;

import androidx.lifecycle.MutableLiveData;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class PriutsRepository {
    private MutableLiveData<List<DocumentSnapshot>> mutableLiveDataUser;

    public PriutsRepository(){
        mutableLiveDataUser = new MutableLiveData<>();
    }

    public void setPriut(List<DocumentSnapshot> priut){
        mutableLiveDataUser.setValue(priut);
    }


    public MutableLiveData<List<DocumentSnapshot>> getMutableLiveDataUser() {
        return mutableLiveDataUser;
    }

}
