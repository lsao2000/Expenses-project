package com.example.contrrolyourmoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public Context context;
    public String typeDate;


    public MyAdapter(Context context, String typeDate) {
        this.context = context;
        this.typeDate = typeDate;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_view, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try{
            holder.product.setText(Expenses.allExpense.get(position).getNote());
            holder.price.setText(String.valueOf(Expenses.allExpense.get(position).getTotalDayExpenses()));
            if(typeDate.equals("date")){
                holder.date.setText(String.valueOf(Expenses.allExpense.get(position).getDate()));
            }else{
                holder.date.setText(String.valueOf(Expenses.allExpense.get(position).getTime()));
            }
        }
        catch (Exception e){
            Toast.makeText(context.getApplicationContext(), "the item list is empty ",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getItemCount() {
        return Expenses.allExpense.size();
    }
}
