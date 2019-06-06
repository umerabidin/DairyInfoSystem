package com.example.dairyinfosystem.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dairyinfosystem.activities.utils.Shared;

public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Shared shared;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shared = Shared.getInstance();
    }
}
