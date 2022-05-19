package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RelativeLayout;

import com.example.testapp.adapter.MainFragmentsAdapter;
import com.example.testapp.fragments.CartPageFragment;
import com.example.testapp.fragments.ProfilePageFragment;
import com.example.testapp.fragments.ShopPageFragment;
import com.google.android.material.tabs.TabLayout;


public class ShopActivity extends AppCompatActivity {

    private TabLayout MainTabLayout;
    private ViewPager pager;
    private ViewPager ViewPager2;
    private static RelativeLayout relativeLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        MainTabLayout = findViewById(R.id.MainTabLayout);
        pager = findViewById(R.id.pager);

        MainTabLayout.setupWithViewPager(pager);

        MainFragmentsAdapter mainAdapter = new MainFragmentsAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mainAdapter.addFragment(new ShopPageFragment(), "SHOP");
        mainAdapter.addFragment(new CartPageFragment(), "CART");
        mainAdapter.addFragment(new ProfilePageFragment(), "PROFILE");

        pager.setAdapter(mainAdapter);
    }

}