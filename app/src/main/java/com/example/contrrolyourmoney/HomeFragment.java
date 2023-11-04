package com.example.contrrolyourmoney;

import android.os.Build;
import android.os.Bundle;
import java.io.File;
import java.io.FileOutputStream;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.LocalTime;

public class HomeFragment extends Fragment {

    private EditText price;
    private EditText productName;
    private Button addBtn;
    private View view;
    private LocalTime time;
    private LocalTime hour;
    private File file;
    private FileOutputStream writer;
    private LocalDate date ;
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
        Expenses.addExpense(getContext());    ;
	addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
		        hour = null;
                date = null;
                String productText = productName.getText().toString();
                float priceValue = Float.parseFloat(price.getText().toString());

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    time = LocalTime.now();
                    hour = LocalTime.of(time.getHour(), time.getMinute(),time.getSecond());
                }
	        	Expenses expense1 = new Expenses(priceValue, productText);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                   date = LocalDate.now();
                }
		try{
			file = new File(getContext().getFilesDir(),"data.csv");
			String line =priceValue+","+productText+","+date+","+hour+"\n";
			writer = new FileOutputStream(file, true);
			writer.write(line.getBytes());
			writer.close();
            Expenses.addExpense(getContext());
		}catch(Exception e){
			Toast.makeText(getContext(), "There is an error with add data", Toast.LENGTH_LONG);
			}
                Toast.makeText(getContext(), "the expense was added", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
