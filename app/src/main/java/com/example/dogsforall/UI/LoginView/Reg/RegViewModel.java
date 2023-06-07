package com.example.dogsforall.UI.LoginView.Reg;

import androidx.lifecycle.ViewModel;

import com.example.dogsforall.UI.LoginView.repository.DataUserRepository;

public class RegViewModel extends ViewModel {
    private DataUserRepository dataUserRepository;

    public RegViewModel(){
        dataUserRepository = new DataUserRepository();
    }

    public DataUserRepository getDataUserRepository() {
        return dataUserRepository;
    }

}