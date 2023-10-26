package com.example.contrrolyourmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ArrayAdapter;

public class Register extends AppCompatActivity {
    private String[] commisionType = {"USD", "MAD", "EUR"};
    private String usernameText;
    private Float netMonthText;
    private EditText username, netMonth;
    private Spinner commision;
    private Button finish;
    private String commisionText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = findViewById(R.id.username);
        netMonth = findViewById(R.id.netMonth);
        commision = findViewById(R.id.commisionList);
        finish = findViewById(R.id.finishBtn);
        ArrayAdapter newArrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, commisionType);
        commision.setAdapter(newArrayAdapter);
        commision.setSelection(0);
        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                usernameText = username.getText().toString();
                netMonthText = Float.parseFloat(netMonth.getText().toString());
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

    }


}