package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU=101;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setTitle("Main Menu");

        Button button = findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GameActivity.class);
                intent.putExtra("name", "Game");
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });


//        Button button2 = findViewById(R.id.btn2);
//        button2.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
//                intent.putExtra("name", "Photo");
//                startActivityForResult(intent, REQUEST_CODE_MENU);
//            }
//        });


        Button button3 = findViewById(R.id.btn3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), VideoActivity.class);
                intent.putExtra("name", "Return to Login");
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });




    }
}
