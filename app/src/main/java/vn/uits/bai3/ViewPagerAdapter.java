package vn.uits.bai3;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import vn.uits.bai3.fragment.OneFragment;
import vn.uits.bai3.fragment.ThreeFragment;
import vn.uits.bai3.fragment.TwoFragment;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/10/18.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OneFragment();
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "One";
                break;
            case 1:
                title = "Two";
                break;
            case 2:
                title = "Three";
                break;
        }
        return title;
    }
}
