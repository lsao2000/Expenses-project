package com.example.contrrolyourmoney;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.LocalTime;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView product, price, date;
    public RecyclerView productItem;
    public MyViewHolder(@NonNull View itemView, int type) {
        super(itemView);
        if(type == R.layout.list_item_view){
            product = itemView.findViewById(R.id.nameProduct);
            price = itemView.findViewById(R.id.priceProduct);
            date = itemView.findViewById(R.id.dateProduct);
        }else{
            date = itemView.findViewById(R.id.date_product);
            productItem = itemView.findViewById(R.id.productItem);
        }
    }
}
