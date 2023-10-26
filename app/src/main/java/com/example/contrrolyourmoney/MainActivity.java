package com.example.contrrolyourmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.view.WindowManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private View homeIcon, searchIcon, listIcon, settingIcon;
    private TextView homeText, searchText, listText, settingText;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        homeIcon = findViewById(R.id.home);
        searchIcon = findViewById(R.id.search);
        listIcon = findViewById(R.id.list);
        settingIcon = findViewById(R.id.setting);
        homeText = findViewById(R.id.homeText);
        searchText = findViewById(R.id.searchText);
        listText = findViewById(R.id.listText);
        settingText = findViewById(R.id.settingText);
        homeText.setTextColor(Color.parseColor("#FFFFFFFF"));
        homeIcon.setBackgroundResource(R.drawable.home_activated);
        homeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeIcon.setBackgroundResource(R.drawable.home_activated);
                homeText.setTextColor(Color.parseColor("#FFFFFFFF"));
                listIcon.setBackgroundResource(R.drawable.list);
                listText.setTextColor(Color.parseColor("#80FFFFFF"));
                searchText.setTextColor(Color.parseColor("#80FFFFFF"));
                searchIcon.setBackgroundResource(R.drawable.search);
                settingIcon.setBackgroundResource(R.drawable.settings);
                settingText.setTextColor(Color.parseColor("#80FFFFFF"));
            }
        });
        searchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeIcon.setBackgroundResource(R.drawable.home);
                homeText.setTextColor(Color.parseColor("#80FFFFFF"));
                listIcon.setBackgroundResource(R.drawable.list);
                listText.setTextColor(Color.parseColor("#80FFFFFF"));
                searchText.setTextColor(Color.parseColor("#FFFFFFFF"));
                searchIcon.setBackgroundResource(R.drawable.search_activated);
                settingIcon.setBackgroundResource(R.drawable.settings);
                settingText.setTextColor(Color.parseColor("#80FFFFFF"));
            }
        });
        settingIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeIcon.setBackgroundResource(R.drawable.home);
                homeText.setTextColor(Color.parseColor("#80FFFFFF"));
                listIcon.setBackgroundResource(R.drawable.list);
                listText.setTextColor(Color.parseColor("#80FFFFFF"));
                searchText.setTextColor(Color.parseColor("#80FFFFFF"));
                searchIcon.setBackgroundResource(R.drawable.search);
                settingIcon.setBackgroundResource(R.drawable.settings_activated);
                settingText.setTextColor(Color.parseColor("#FFFFFFFF"));
            }
        });
        listIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeIcon.setBackgroundResource(R.drawable.home);
                homeText.setTextColor(Color.parseColor("#80FFFFFF"));
                listIcon.setBackgroundResource(R.drawable.list_activated);
                listText.setTextColor(Color.parseColor("#FFFFFFFF"));
                searchText.setTextColor(Color.parseColor("#80FFFFFF"));
                searchIcon.setBackgroundResource(R.drawable.search);
                settingIcon.setBackgroundResource(R.drawable.settings);
                settingText.setTextColor(Color.parseColor("#80FFFFFF"));
            }
        });
    }
}