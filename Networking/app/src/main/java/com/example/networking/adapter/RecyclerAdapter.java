package com.example.networking.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networking.R;
import com.example.networking.models.Contact;
import com.example.networking.models.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private final List<Product> arrayList;

    public RecyclerAdapter(List<Product> array){
        this.arrayList = array;
    }


    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view_product,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(arrayList.get(position).getName());
        holder.tv_category.setText(arrayList.get(position).getCategory());
        holder.tv_price.setText(String.valueOf(arrayList.get(position).getPrice()));

        Picasso.get().load(arrayList.get(position).getImageURL()).resize(300,300).into(holder.image_view);
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name,tv_category,tv_price;
        ImageView image_view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_category = itemView.findViewById(R.id.tv_category);
            tv_price = itemView.findViewById(R.id.tv_price);
            image_view = itemView.findViewById(R.id.image_view);

        }
    }
}
