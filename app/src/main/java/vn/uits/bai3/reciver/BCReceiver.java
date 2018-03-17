package vn.uits.bai3.reciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/17/18.
 */

public class BCReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver Intent", Toast.LENGTH_SHORT).show();
    }
}
