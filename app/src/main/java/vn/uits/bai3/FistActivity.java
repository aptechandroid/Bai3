package vn.uits.bai3;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/10/18.
 */

public class FistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist);
    }

    public void onViewPager(View view) {
        Intent viewpager = new Intent(this, ViewPagerActivity.class);
        startActivity(viewpager);
    }

    public void onFragment(View view) {
        Intent fragment = new Intent(this, MainActivity.class);
        startActivity(fragment);
    }
}
