package com.example.contrrolyourmoney;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import java.time.LocalDate;
import java.util.ArrayList;


public class SearchFragment extends Fragment {
    private View view, searchBtn;
    private EditText searchInput;
    private Spinner searchType;
    private RecyclerView recyclerView;
    private String[] listSpipner = {"Day", "Month"};
    private String month, day, typesearch;
    public SearchFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_search, container, false);
        searchBtn = view.findViewById(R.id.searchBtn);
        searchInput = view.findViewById(R.id.searchInput);
        searchType = view.findViewById(R.id.searchType);
        recyclerView = view.findViewById(R.id.recycleView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listSpipner);
        searchType.setAdapter(arrayAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MyAdapter(getActivity(), Expenses.allExpense,R.layout.list_date));
        searchBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                typesearch = searchType.getSelectedItem().toString();
                String inputValue = searchInput.getText().toString();
                LocalDate date = null;
                if(typesearch.equals("Day")){
                    try{
                        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                            date = LocalDate.parse(inputValue);
                        }
                        Expenses searchValue = Expenses.searchdate(date);
                        recyclerView.setAdapter(new MyAdapter(getActivity(), searchValue.getAllExpense(),R.layout.list_date));
                    }catch (Exception e){
                        Toast.makeText(getContext(), "The search type is day : "+inputValue, Toast.LENGTH_LONG).show();
                        searchInput.setError("must be date format Ex: 2023-01-15 ");
                    }
                }else{
                    try{
                        final ArrayList<Expenses> searchdate = Expenses.searchdate(Integer.parseInt(inputValue));
                        recyclerView.setAdapter(new MyAdapter(getActivity(), searchdate,R.layout.list_date));

                    }catch (Exception e){
                        Toast.makeText(getContext(), "The search type is month : "+inputValue, Toast.LENGTH_LONG).show();
                        searchInput.setError("This must be integer not a string or date format");
                    }
                }
            }
        });
        return view;
    }
}