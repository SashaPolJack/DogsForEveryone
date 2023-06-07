package com.example.dogsforall.UI.LoginView.ProfileDog;

import androidx.lifecycle.ViewModel;

import com.example.dogsforall.UI.LoginView.repository.DogsRepsitory;

public class ProfileDogViewModel extends ViewModel {
    private DogsRepsitory dogsRepsitory;

    public ProfileDogViewModel(){
        dogsRepsitory = new DogsRepsitory();
    }

    public DogsRepsitory getDogsRepsitory() {
        return dogsRepsitory;
    }
}