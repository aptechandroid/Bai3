package vn.uits.bai3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import vn.uits.bai3.Observer.ObserverImpl;
import vn.uits.bai3.Observer.RepositoryObserver;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/10/18.
 */

public class FistActivity extends AppCompatActivity implements RepositoryObserver {

    private static final int REQUEST_TAKE_PHOTO = 100;
    private static final int REQUEST_CROP_PHOTO = 101;
    private Uri mUri;

    private ImageView mImgThumbnail;
    private ObserverImpl mObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fist);
        mImgThumbnail = findViewById(R.id.mImgThumbnail);

        mObserver = ObserverImpl.getInstance();
        mObserver.registerObserver(this);
    }

    public void onViewPager(View view) {
        Intent viewpager = new Intent(this, ViewPagerActivity.class);
        startActivity(viewpager);
    }

    public void onFragment(View view) {
        Intent fragment = new Intent(this, MainActivity.class);
        startActivity(fragment);
    }

    public void onMediaPlayer(View view) {
        Intent media = new Intent(this, MediaPlayerActivity.class);
        startActivity(media);
    }

    public void onTakePhoto(View view) {
        Intent takePhoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePhoto, REQUEST_TAKE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TAKE_PHOTO) {
            mUri = data.getData();
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImgThumbnail.setImageBitmap(imageBitmap);
        } else if (requestCode == REQUEST_CROP_PHOTO) {
            mUri = data.getData();
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImgThumbnail.setImageBitmap(imageBitmap);
        }
    }

    private void onCropImage() {
        Intent copImage = new Intent("com.android.camera.action.CROP");
        copImage.setDataAndType(mUri, "image/*");
        copImage.putExtra("crop", true);

        copImage.putExtra("aspectX", 1);
        copImage.putExtra("aspectY", 1);

        copImage.putExtra("outputX", 300);
        copImage.putExtra("outputY", 300);

        copImage.putExtra("return-data", true);

        startActivityForResult(copImage, REQUEST_CROP_PHOTO);
    }

    @Override
    public void onUserDataChanged(String name, int age) {
        Log.d("xxx", "onUserDataChanged: " + name + "     " + age);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mObserver.removeObserver(this);
    }
}
