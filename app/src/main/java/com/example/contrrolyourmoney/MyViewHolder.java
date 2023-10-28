package com.example.contrrolyourmoney;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.LocalTime;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView product, price, date;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        product = itemView.findViewById(R.id.nameProduct);
        price = itemView.findViewById(R.id.priceProduct);
        date = itemView.findViewById(R.id.dateProduct);
    }
}
