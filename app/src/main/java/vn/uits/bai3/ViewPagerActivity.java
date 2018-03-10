package vn.uits.bai3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import vn.uits.bai3.fragment.OneFragment;
import vn.uits.bai3.fragment.ThreeFragment;
import vn.uits.bai3.fragment.TwoFragment;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/8/18.
 */

public class ViewPagerActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private List<Fragment> mList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mTabLayout = findViewById(R.id.mTabLayout);
        mViewPager = findViewById(R.id.mViewPager);

        mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), mList);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(3);
        mTabLayout.setupWithViewPager(mViewPager);
        dataFragment();
    }

    /**
     * data 
     */
    private void dataFragment() {
        mList.clear();
        mList.add(new OneFragment());
        mList.add(new TwoFragment());
        mList.add(new ThreeFragment());
        mAdapter.notifyDataSetChanged();
    }
}
