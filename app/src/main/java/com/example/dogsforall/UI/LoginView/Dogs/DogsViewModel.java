package com.example.dogsforall.UI.LoginView.Dogs;

import androidx.lifecycle.ViewModel;

import com.example.dogsforall.UI.LoginView.repository.DataUserRepository;
import com.example.dogsforall.UI.LoginView.repository.DogsRepsitory;

public class DogsViewModel extends ViewModel {
    private DogsRepsitory dogsRepsitory;

    public DogsViewModel(){
        dogsRepsitory = new DogsRepsitory();
    }

    public DogsRepsitory getDogsRepsitory() {
        return dogsRepsitory;
    }
}