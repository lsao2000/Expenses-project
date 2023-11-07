package com.example.contrrolyourmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.content.Intent;
import android.widget.Button;
import android.view.View;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class About extends AppCompatActivity {
    private Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_about);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    File file = new File(getApplicationContext().getFilesDir(), "data.csv");
                    Scanner content = new Scanner(file);
                    if (content.hasNext()) {
                        Intent mainActivity = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(mainActivity);
                    }
                } catch (Exception e) {
                    Intent registerActivity = new Intent(getApplicationContext(), Register.class);
                    startActivity(registerActivity);
                }
            }
            });
    }
}
