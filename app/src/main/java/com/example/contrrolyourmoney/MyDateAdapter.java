package com.example.contrrolyourmoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyDateAdapter extends RecyclerView.Adapter<MyDateAdapter.MyViewDateHolder> {
    private Context context;
    private ArrayList<Expenses> list = new ArrayList<Expenses>();
    MyDateAdapter(ArrayList<Expenses> list){
        this.list = list;

    }
    @NonNull
    @Override
    public MyViewDateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new MyViewDateHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewDateHolder holder, int position) {
        holder.product.setText(list.get(position).getNote());
        holder.price.setText(String.valueOf(list.get(position).getExpense()));
        holder.dateText.setText(String.valueOf(list.get(position).getTimeText()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewDateHolder extends RecyclerView.ViewHolder{
        private TextView product, price, dateText;
        public MyViewDateHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.priceProduct);
            product = itemView.findViewById(R.id.nameProduct);
            dateText = itemView.findViewById(R.id.dateProduct);
        }
    }
}
