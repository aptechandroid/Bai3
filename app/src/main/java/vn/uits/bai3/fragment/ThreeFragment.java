package vn.uits.bai3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.uits.bai3.R;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/10/18.
 */

public class ThreeFragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_three, container, false);
        return mView;
    }
}
