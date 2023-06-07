package com.example.dogsforall;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.dogsforall.UI.LoginView.Onboarding.Onboard_1;
import com.example.dogsforall.UI.LoginView.Onboarding.Onboard_2;
import com.example.dogsforall.UI.LoginView.Onboarding.Onboard_3;
import com.example.dogsforall.UI.LoginView.Onboarding.Onboard_4;
import com.example.dogsforall.UI.LoginView.Onboarding.ViewPageAdapter;
import com.zhpan.indicator.IndicatorView;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

public class Onboarding extends AppCompatActivity {
    private static final int NUM_PAGES = 4;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager2 viewPager;
    private IndicatorView indicatorView;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private FragmentStateAdapter pagerAdapter;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboardig_activity);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.v_page);

        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setOffscreenPageLimit(2);
        viewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);


        viewPager.setClipToPadding(false);
        viewPager.setClipChildren(false);

//        indicatorView = findViewById(R.id.indicator_view);
//        indicatorView.setSliderColor(Color.parseColor("#D9D9D9"),Color.parseColor("#AAAAAA"))
//                .setSliderHeight(R.dimen.height)
//                .setSliderWidth(R.dimen.width)
//                .setSlideMode(IndicatorSlideMode.WORM)
//                .setIndicatorStyle(IndicatorStyle.CIRCLE)
//                .setupWithViewPager(viewPager);


    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    /**
     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {
            System.out.println(position);
            if (position == 0){
                return new Onboard_1();
            }else if (position == 1){
                return new Onboard_2();
            }else if (position == 2){
                return new Onboard_3();
            }else if (position == 3){
                return new Onboard_4();
            }
            return new Onboard_1();
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }



}
