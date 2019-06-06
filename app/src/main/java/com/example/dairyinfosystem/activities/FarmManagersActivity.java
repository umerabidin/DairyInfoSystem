package com.example.dairyinfosystem.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.dairyinfosystem.R;
import com.example.dairyinfosystem.adapters.HomeButtonsAdapter;
import com.example.dairyinfosystem.utils.HomeButtons;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FarmManagersActivity extends BaseActivity {
    @BindView(R.id.tvFarmers)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farm_managers);
        ButterKnife.bind(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.hideOverflowMenu();
        setTitle("Add Farmer");
        FarmManagerAdapter mAdapter = new FarmManagerAdapter(this);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.farm_menu_items, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            shared.callIntent(this, AddFarmerActivity.class, null);
        }
        return super.onOptionsItemSelected(item);
    }

    class FarmManagerAdapter extends RecyclerView.Adapter<FarmManagerAdapter.ViewHolder> {
        Activity activity;
        public FarmManagerAdapter(Activity activity) {
            this.activity=activity;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View itemView = LayoutInflater.from(activity)
                    .inflate(R.layout.farm_manager_item, viewGroup, false);
            return new ViewHolder(itemView);        }

        @Override
        public void onBindViewHolder(@NonNull FarmManagerAdapter.ViewHolder viewHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 5;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            ViewHolder(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}
