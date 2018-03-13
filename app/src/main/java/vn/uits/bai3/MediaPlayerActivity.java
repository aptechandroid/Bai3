package vn.uits.bai3;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import java.io.IOException;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/13/18.
 */

public class MediaPlayerActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener {

    private MediaPlayer mMediaPlayer;
    private int mPositionSeekTo = 0;
    private SeekBar mSeekBar;
    private Runnable mRunnable;
    private Handler mHandler;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        mSeekBar = findViewById(R.id.mSeekBar);
        mHandler = new Handler();

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (mMediaPlayer != null && mMediaPlayer.isPlaying() && fromUser) {
                    mMediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    /**
     * audio player
     *
     * @param context
     * @param url
     * @throws IOException
     */
    private void audioPlayer(Context context, String url) throws IOException {

        killMediaPlayer();

        mMediaPlayer = new MediaPlayer();
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setDataSource(url);
        mMediaPlayer.setOnPreparedListener(this);
        mMediaPlayer.setWakeMode(context, PowerManager.PARTIAL_WAKE_LOCK);
    }

    /**
     * init seekBar
     */
    private void initializeSeekBar() {
        mSeekBar.setMax(mMediaPlayer.getDuration());

        mRunnable = new Runnable() {
            @Override
            public void run() {
                if (mMediaPlayer != null) {
                    int mCurrentPosition = mMediaPlayer.getCurrentPosition();
                    mSeekBar.setProgress(mCurrentPosition);
                }
                mHandler.postDelayed(mRunnable, 1000);
            }
        };

        mHandler.postDelayed(mRunnable, 1000);
    }

    /**
     * local
     */
    private void localPlayer(Context context) {
        killMediaPlayer();

        mMediaPlayer = MediaPlayer.create(context, R.raw.nguoilaoi);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();

        initializeSeekBar();
    }

    /**
     * assets
     */
    private void localAssetsMediaPlayer() {
    }

    private void killMediaPlayer() {
        if (mMediaPlayer != null)
            mMediaPlayer.release();
    }

    /**
     * click start media player
     *
     * @param view
     */
    public void onStartMediaPlayer(View view) {
        localPlayer(this);
    }

    /**
     * click restart media player
     *
     * @param view
     */
    public void onReStartMediaPlayer(View view) {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.seekTo(mPositionSeekTo);
            mMediaPlayer.start();
        }
    }

    /**
     * click pause media player
     *
     * @param view
     */
    public void onPauseMediaPlayer(View view) {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mPositionSeekTo = mMediaPlayer.getCurrentPosition();
            mMediaPlayer.pause();
        }
    }

    /**
     * click stop media player
     *
     * @param view
     */
    public void onStopMediaPlayer(View view) {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mPositionSeekTo = 0;
            mMediaPlayer.stop();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }
}
