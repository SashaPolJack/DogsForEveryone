package com.example.dogsforall.UI.LoginView.repository;

import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;

import com.google.firebase.firestore.DocumentSnapshot;

import java.util.List;

public class NaviganionRepository {
    private MutableLiveData<NavController> mutableLiveDataUser;

    public NaviganionRepository(){
        mutableLiveDataUser = new MutableLiveData<>();
    }

    public void setNav(NavController Nav){
        mutableLiveDataUser.setValue(Nav);
    }


    public MutableLiveData<NavController> getMutableLiveDataUser() {
        return mutableLiveDataUser;
    }
}
