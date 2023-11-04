package com.example.contrrolyourmoney;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;
import java.io.FileOutputStream;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.Toast;
public class Register extends AppCompatActivity {
    private String[] commisionType = {"USD", "MAD", "EUR"};
    private String usernameText;
    private Float netMonthText;
    private Scanner readFileContent;
    private FileOutputStream writer;
    private File reader;
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
        ArrayAdapter<String> newArrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, commisionType);
        commision.setAdapter(newArrayAdapter);
        commision.setSelection(0);
        finish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                usernameText = username.getText().toString();
                if(netMonth.getText().toString().isEmpty()) {
                    return;
                }
                if(usernameText.isEmpty()){
                    return;
                }
                netMonthText = Float.parseFloat(netMonth.getText().toString());
                try{
	 	   File file = new File(getApplicationContext().getFilesDir(), "data.csv");
   		   writer = new FileOutputStream(file, true);
		   writer.close();}
		   catch(Exception e){
                    Toast.makeText(Register.this, "There is an error with data file", Toast.LENGTH_LONG).show();
                }
                try{
                    reader = new File(getApplicationContext().getFilesDir(),"data.csv");
                    readFileContent = new Scanner(reader);
                    if(readFileContent.hasNext()){
                        String[] firstline = readFileContent.nextLine().split(",");
                    }else{
			File file = new File(getApplicationContext().getFilesDir(),"data.csv");
			writer = new FileOutputStream(file, true);
                        String line = "username,"+usernameText+",netMonth,"+netMonthText+"\n";
                        writer.write(line.getBytes());
                        writer.write(("Expense,Note,Date,Time\n").getBytes());
                        writer.close();
                    }
                }catch(Exception e){
                    Toast.makeText(Register.this, "there is an error with creating file", Toast.LENGTH_LONG).show();
                }

                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mainActivityIntent);
            }
        });

    }
}
