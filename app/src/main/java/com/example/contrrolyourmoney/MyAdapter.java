package com.example.contrrolyourmoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    public Context context;
    public ArrayList<Expenses> list;
    public int path;

    public MyAdapter(Context context, ArrayList<Expenses> list, int path) {
        this.context = context;
        this.list = list;
        this.path = path;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(path, parent,false) ;
        return new MyViewHolder(view, path);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(path == R.layout.list_item_view){
            try{
                holder.product.setText("Total Expense day");
                holder.price.setText(String.valueOf(list.get(position).getTotalDayExpenses()));
                holder.date.setText(String.valueOf(list.get(position).getDate()));
            }
            catch (Exception e){
                Toast.makeText(context.getApplicationContext(), "the item list is empty ",Toast.LENGTH_LONG).show();
            }

        }else{
            if(list.size()>0){
                try{
                    holder.date.setText(String.valueOf(list.get(position).getDate()));
                    ArrayList<Expenses> newList = list.get(position).getAllDayExpenses();
                    MyDateAdapter adapter = new MyDateAdapter(newList);
                    holder.productItem.setLayoutManager(new LinearLayoutManager(holder.itemView.getContext()));
                    holder.productItem.setHasFixedSize(true);
                    holder.productItem.setAdapter(adapter);
                }catch (Exception e){
                    Toast.makeText(context.getApplicationContext(), "the item list is empty ",Toast.LENGTH_LONG).show();
                }
            }else Toast.makeText(context.getApplicationContext(), "No expense in this month ",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public int getItemCount() {
        return Expenses.allExpense.size();
    }
}
