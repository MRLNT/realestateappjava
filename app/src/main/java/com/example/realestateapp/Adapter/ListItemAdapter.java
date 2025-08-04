package com.example.realestateapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.realestateapp.Domain.PropertyDomain;
import com.example.realestateapp.databinding.ViewholderItemBinding;

import java.util.ArrayList;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.Viewholder> {
    ArrayList<PropertyDomain> items;
    Context context;
    ViewholderItemBinding binding;

    public ListItemAdapter(ArrayList<PropertyDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ListItemAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ViewholderItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        context = parent.getContext();
        return new Viewholder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemAdapter.Viewholder holder, int position) {
        binding.titleTxt.setText(items.get(position).getTitle());
        binding.priceTxt.setText("$"+items.get(position).getPrice());
        binding.sizeTxt.setText(items.get(position).getSize()+"m2");
        if (items.get(position).isGarage()){
            binding.garageTxt.setText("Car Garage");
        } else{
            binding.garageTxt.setText("non-Car Garage");
        }

        binding.addressTxt.setText(items.get(position).getAddress());
        binding.bedTxt.setText(items.get(position).getBed()+" Bed");
        binding.bathTxt.setText(items.get(position).getBath()+" Bath");

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPickPath(), "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(context).load(drawableResourceId).into(binding.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        public Viewholder(ViewholderItemBinding binding) {
            super(binding.getRoot());
        }
    }
}
