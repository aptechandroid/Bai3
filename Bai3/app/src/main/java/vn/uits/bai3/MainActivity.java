package vn.uits.bai3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import vn.uits.bai3.fragment.OneFragment;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/8/18.
 */

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            return false;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationView = findViewById(R.id.navigation);
        mNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        replaceFragment(new OneFragment());
    }


    /**
     * add fragment
     *
     * @param fragment
     */
    private void addFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mFrameLayout, fragment)
                .disallowAddToBackStack()
                .commit();
    }

    /**
     * replace fragment
     *
     * @param fragment
     */
    private void replaceFragment(@NonNull Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mFrameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }
}
