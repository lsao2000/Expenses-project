package com.example.contrrolyourmoney;

import android.os.Bundle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class SettingFragment extends Fragment {
	private Scanner content;
	private View view;
	private String usernameText;
	private Float netMonthValue;
	private TextView netMonth;
	private TextView username;
    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_setting, container, false);
	username = view.findViewById(R.id.greeting);
	netMonth = view.findViewById(R.id.netMonth);
	File file = new File(getContext().getFilesDir(),"data.csv");
		try {
			content = new Scanner(file);
		} catch (FileNotFoundException e) {
			Toast.makeText(getContext(), "failed to get username", Toast.LENGTH_SHORT).show();
		}
		String firstLine = content.nextLine();
	netMonthValue = Float.parseFloat(firstLine.split(",")[3]);
	usernameText = firstLine.split(",")[1];
	username.setText(usernameText);
	netMonth.setText(netMonthValue + "");
	return view;
    }
}
