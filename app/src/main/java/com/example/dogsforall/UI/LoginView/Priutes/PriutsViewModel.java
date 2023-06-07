package com.example.dogsforall.UI.LoginView.Priutes;

import androidx.lifecycle.ViewModel;

import com.example.dogsforall.UI.LoginView.repository.DogsRepsitory;
import com.example.dogsforall.UI.LoginView.repository.PriutsRepository;

public class PriutsViewModel extends ViewModel {
    private PriutsRepository priutsRepository;

    public PriutsViewModel(){
        priutsRepository = new PriutsRepository();
    }

    public PriutsRepository getPriutsRepsitory() {
        return priutsRepository;
    }
}