package com.example.mygalleyappfinal.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mygalleyappfinal.R;
import com.example.mygalleyappfinal.models.GalleryCardModel;

import java.util.ArrayList;

public class GalleryCardAdaptor extends RecyclerView.Adapter<GalleryCardAdaptor.ItemHolder> {

    private ArrayList<GalleryCardModel> cards;
    private Context context;

    public GalleryCardAdaptor(Context context, ArrayList<GalleryCardModel> cards) {
        this.cards = cards;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_card, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        position = holder.getAdapterPosition();
        //Resim eklenecek
        Glide.with(context).load(cards.get(position).getImg_url()).into(holder.cardImage);
        holder.username.setText(cards.get(position).getUser_name());
        holder.label.setText(cards.get(position).getLabel());
        holder.description.setText(cards.get(position).getDescription());

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView username, label, description;
        ImageView cardImage;
        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.cardUsername);
            label = itemView.findViewById(R.id.cardLabel);
            description = itemView.findViewById(R.id.cardDescription);
            cardImage = itemView.findViewById(R.id.cardImg);

        }
    }
}
