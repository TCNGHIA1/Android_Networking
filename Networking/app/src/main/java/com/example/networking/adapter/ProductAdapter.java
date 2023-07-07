package com.example.networking.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.networking.R;
import com.example.networking.models.Product;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    Context context;
    ArrayList<Product> arrayList;

    public ProductAdapter(Context context, ArrayList<Product> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public static class ViewHolder{
        TextView tv_name,tv_category,tv_price;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewHolder holder;
        if(convertView ==null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_base_view_product,null);
            holder.tv_name = convertView.findViewById(R.id.tv_name);
            holder.tv_category = convertView.findViewById(R.id.tv_category);
            holder.tv_price = convertView.findViewById(R.id.tv_price);
            convertView.setTag(holder);
        }else{
            holder =(ViewHolder) convertView.getTag();
        }
        Product product = arrayList.get(position);
        holder.tv_name.setText(product.getName());
        holder.tv_category.setText(product.getCategory());
        holder.tv_price.setText(product.getPrice());
        return convertView;
    }
}
