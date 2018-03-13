package vn.uits.bai3.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import vn.uits.bai3.R;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/8/18.
 */

public class TwoFragment extends Fragment {

    private View mView;
    private VideoView mVideoView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_two, container, false);
        mVideoView = mView.findViewById(R.id.mVideoView);
        Uri uri = Uri.parse("http://abhiandroid-8fb4.kxcdn.com/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4");
        mVideoView.setVideoURI(uri);
        mVideoView.setMediaController(new MediaController(getActivity()));
        mVideoView.requestFocus();
        mVideoView.start();
        return mView;
    }
}
