package com.example.bottomnavigation;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.sax.RootElement;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    BottomNavigationView bnview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.container);
        bnview = findViewById(R.id.bnview);
        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.navi_profile) {
                    loadFrag(new Myprofile(), true);


                } else if (id == R.id.navi_home) {
                    loadFrag(new Home(), false);


                } else if (id == R.id.navi_service) {
                    loadFrag(new Service(), false);

                } else if (id == R.id.navi_about) {
                    loadFrag(About.getInstance("Raj",19), false);

                } else {
                    loadFrag(new Contact(), false);
                }
                return true;
            }
        });
        bnview.setSelectedItemId(R.id.navi_profile);


    }

    public void loadFrag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag) {
            ft.add(R.id.container, fragment);
            fm.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.addToBackStack(null);
        } else {
            ft.replace(R.id.container, fragment);
            ft.addToBackStack(null);
        }

        ft.commit();

    }
}