package com.example.dogsforall.UI.LoginView.Onboarding;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPageAdapter extends FragmentPagerAdapter {

    public ViewPageAdapter(@NonNull FragmentActivity fm) {
        super(fm.getSupportFragmentManager());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return Onboard_1.newInstance();
        }else if (position == 1){
            return Onboard_2.newInstance();
        }else if (position == 2){
            return Onboard_3.newInstance();
        }else if (position == 3){
            return Onboard_4.newInstance();
        }
        return Onboard_1.newInstance();
    }

    @Override
    public int getCount() {
        return 4;
    }
}
