package com.example.dairyinfosystem.adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dairyinfosystem.R;
import com.example.dairyinfosystem.activities.FarmManagersActivity;

public class HomeButtonsAdapter extends RecyclerView.Adapter<HomeButtonsAdapter.ViewHolder> {
    private String[] roles;
    private Activity activity;

    public HomeButtonsAdapter(Activity activity, String[] roles) {
        this.activity = activity;
        this.roles = roles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(activity)
                .inflate(R.layout.home_btns_items, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.liItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    Intent intent = new Intent(activity, FarmManagersActivity.class);
                    activity.startActivity(intent);
                }
            }
        });
        viewHolder.tvItem.setText(roles[i]);
    }

    @Override
    public int getItemCount() {
        return roles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout liItems;
        TextView tvItem;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            liItems = itemView.findViewById(R.id.liItems);
            tvItem = itemView.findViewById(R.id.tvitem);
        }
    }
}
