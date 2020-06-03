package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText idName;
    private EditText idPassword;
    private TextView noticeInfo;
    private Button eLogin;
    private int attempCounter = 3;
    private String adminName = "admin";
    private String adminPassword = "1234";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Log In");

        idName = findViewById(R.id.etID);
        idPassword = findViewById(R.id.etPassword);
        noticeInfo = findViewById(R.id.txtV);
        eLogin = findViewById(R.id.btnLogin);

        eLogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                String userName = idName.getText().toString();
                String userPassword = idPassword.getText().toString();

                if(userName.isEmpty() || userPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter ID and Password!", Toast.LENGTH_LONG).show();

                }
                else {

                          isValid = validate(userName, userPassword);
                          //When it is right password and ID
                          if (isValid)
                          {
                              startActivity(new Intent(MainActivity.this, MainMenu.class));
                          }
                          else {
                                    //decrease the attempt count
                                    attempCounter--;
                                    //show the notice that the something out of 3 attempts remained.
                                    noticeInfo.setText("Attempts Remaining: " + String.valueOf(attempCounter));

                            //when the attempt is 0, then login fail and show the another notification
                            if (attempCounter == 0)
                            {
                                eLogin.setEnabled(false);
                                Toast.makeText(MainActivity.this, "You used 3 attempts try it later!!", Toast.LENGTH_LONG).show();
                            }
                            else { Toast.makeText(MainActivity.this, "Wrong information, try again!", Toast.LENGTH_LONG).show(); }
                        }
                    }
            }
        });
    }

    private boolean validate(String userName, String userPassword)
    {
        if(userName.equals(adminName) && userPassword.equals(adminPassword))
        {
            return true;
        }
        else {return false;}
    }
}

