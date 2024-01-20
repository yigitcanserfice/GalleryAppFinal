package com.example.mygalleyappfinal.adaptors;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mygalleyappfinal.R;
import com.example.mygalleyappfinal.models.LabelModel;

import java.util.ArrayList;

public class LabelAdaptor extends RecyclerView.Adapter<LabelAdaptor.ItemHolder> {
    private ArrayList<LabelModel> labels;
    private Context context;

    public LabelAdaptor(Context context, ArrayList<LabelModel> labels ) {
        this.labels = labels;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LabelAdaptor.ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.label_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        position = holder.getAdapterPosition();
        holder.label.setText(labels.get(position).getLabel());
    }

    @Override
    public int getItemCount() {
        return labels.size();
    }


    public class ItemHolder extends RecyclerView.ViewHolder {

        TextView label;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            label = itemView.findViewById(R.id.txtLabel);
        }
    }
}
