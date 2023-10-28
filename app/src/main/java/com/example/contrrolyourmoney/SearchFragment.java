package com.example.contrrolyourmoney;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.EditText;


public class SearchFragment extends Fragment {
    private View view, searchBtn;
    private EditText searchInput;
    private Spinner searchType;
    private String[] listSpipner = {"Day", "month"};
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
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, listSpipner);
        searchType.setAdapter(arrayAdapter);
//        searchBtn.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                typesearch = searchType.getSelectedItem().toString();
//
//            }
//        });
        return view;
    }
}