package vn.uits.bai2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Copyright © 2017 BAP CO., LTD
 * Created by PHUQUY on 3/6/18.
 */

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button mBtnRegister;
    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;
    private EditText mEdtEmail;
    private EditText mEditPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // instance
        mBtnRegister = findViewById(R.id.mBtnRegister);
        mEdtEmail = findViewById(R.id.etEmail);
        mEditPassword = findViewById(R.id.etPass);

        mSharedPreference = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreference.edit();

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mEdtEmail.getText().toString().trim().equals("")
                        && !mEditPassword.getText().toString().trim().equals("")) {
                    // commit Share Preference
                    mEditor.putString("email", mEdtEmail.getText().toString());
                    mEditor.putString("password", mEditPassword.getText().toString());
                    mEditor.commit();

                    // clear Edittext
                    clear();

                    // gone view
                    mBtnRegister.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập giá trị ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * clear EditText
     */
    private void clear() {
        mEdtEmail.setText("");
        mEditPassword.setText("");
    }

    /**
     * login view button
     *
     * @param view
     */
    public void onLogin(View view) {
        if ((mEdtEmail.getText().toString().equals(mSharedPreference.getString("email", "")))
                && (mEditPassword.getText().toString().equals(mSharedPreference.getString("password", "")))) {
            Intent intent = new Intent(MainActivity.this, TowActivity.class);
            startActivity(intent);
        } else {
            showMessage(MainActivity.this,
                    mSharedPreference.getString("email", ""),
                    mSharedPreference.getString("password", ""));
        }
    }

    /**
     * show Messager
     *
     * @param context
     * @param email
     * @param password
     */
    private void showMessage(Context context, String email, String password) {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(context);
        }
        builder.setTitle("Thông tin của bạn là ")
                .setMessage("Email :  " + email + "\n" + "Password :  " + password)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
