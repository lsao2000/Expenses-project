package com.example.contrrolyourmoney;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.time.LocalDate;

public class HomeFragment extends Fragment {

    private EditText price;
    private EditText productName;
    private Button addBtn;
    private View view;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        price = view.findViewById(R.id.price);
        productName = view.findViewById(R.id.product);
        addBtn = view.findViewById(R.id.addExpense);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String productText = productName.getText().toString();
                float priceValue = Float.parseFloat(price.getText().toString());
                Expenses expense1 = new Expenses(priceValue, productText);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    expense1.setDate(LocalDate.now());
                }
                Expenses.addExpense(expense1);
                Toast.makeText(getContext(), "the expense was added", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}