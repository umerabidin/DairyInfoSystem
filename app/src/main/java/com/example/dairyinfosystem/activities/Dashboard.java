package com.example.dairyinfosystem.activities;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dairyinfosystem.R;
import com.example.dairyinfosystem.adapters.HomeButtonsAdapter;
import com.example.dairyinfosystem.utils.HomeButtons;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard extends BaseActivity {
    @BindView(R.id.listHomeBtns)
    RecyclerView recyclerView;
    HomeButtonsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);
        mAdapter = new HomeButtonsAdapter(this, HomeButtons.getInstance().getAdminRoles());
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {

    }
}
