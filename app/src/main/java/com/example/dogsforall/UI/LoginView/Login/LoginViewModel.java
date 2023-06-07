package com.example.dogsforall.UI.LoginView.Login;

import androidx.lifecycle.ViewModel;

import com.example.dogsforall.UI.LoginView.repository.DogsRepsitory;
import com.example.dogsforall.UI.LoginView.repository.NaviganionRepository;

public class LoginViewModel extends ViewModel {
    private NaviganionRepository naviganionRepository;

    public LoginViewModel(){
        naviganionRepository = new NaviganionRepository();
    }

    public NaviganionRepository getNAvRepsitory() {
        return naviganionRepository;
    }
}