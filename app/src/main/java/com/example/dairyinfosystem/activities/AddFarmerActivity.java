package com.example.dairyinfosystem.activities;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dairyinfosystem.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddFarmerActivity extends BaseActivity {


    @BindView(R.id.edFirstName)
    EditText edFirstName;
    @BindView(R.id.edLastName)
    EditText edLastName;
    @BindView(R.id.edEmail)
    EditText edEmail;
    @BindView(R.id.edPassword)
    EditText edPassword;
    @BindView(R.id.cvAddFarmer)
    CardView cvAddFarmer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_farmer);
        ButterKnife.bind(this);
        cvAddFarmer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
