package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VideoActivity extends AppCompatActivity {
    private Button videoPlay;
    public static final int REQUEST_CODE_MENU=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        setTitle("Video List");

        Button button = findViewById(R.id.btn4);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), playVideo.class);
                intent.putExtra("name", "Game");
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

    }


}
