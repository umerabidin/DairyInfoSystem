package com.example.dairyinfosystem.activities;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.dairyinfosystem.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shared.callIntentWithFinish(SplashActivity.this, LoginActivity.class, null);
            }
        }, 2000);
    }

    @Override
    public void onClick(View v) {

    }
}
