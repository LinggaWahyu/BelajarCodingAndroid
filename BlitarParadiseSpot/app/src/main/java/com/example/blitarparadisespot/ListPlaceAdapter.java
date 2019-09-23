package com.example.blitarparadisespot;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPlaceAdapter extends RecyclerView.Adapter<ListPlaceAdapter.ListViewHolder> {
    Context context;
    private ArrayList<Place> listPlace;

    public ListPlaceAdapter(Context context, ArrayList<Place> listPlace) {
        this.context = context;
        this.listPlace = listPlace;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_place, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Place place = listPlace.get(position);
        holder.place = place;
        Glide.with(holder.itemView.getContext())
                .load(place.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);

        holder.tvName.setText(place.getName());
        holder.tvAddres.setText(place.getAddres());
    }

    @Override
    public int getItemCount() {
        return listPlace.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imgPhoto;
        TextView tvName, tvAddres;
        RelativeLayout relativeLayout;
        Place place;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvAddres = itemView.findViewById(R.id.tv_item_addres);
            tvName.setOnClickListener(this);
            tvAddres.setOnClickListener(this);
            imgPhoto.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.img_item_photo || view.getId() == R.id.tv_item_name || view.getId() == R.id.tv_item_addres) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra("key", place);
                context.startActivity(intent);
            }
        }
    }
}
