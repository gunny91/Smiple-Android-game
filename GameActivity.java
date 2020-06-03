package com.example.project1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {




    private Button[][] buttons = new Button[3][3];
    private boolean p1Turn = true;
    private int numCount;
    private int p1Scores;
    private int p2Scores;
    private TextView text1;
    private TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        text1 = findViewById(R.id.txtPlayer1);
        text2 = findViewById(R.id.txtPlayer2);

        //For loop to get the value of position
        for (int i = 0; i <= 2; i++) {
            for (int ii = 0; ii <= 2; ii++) {
                String buttonID = "btn" + i + ii;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][ii] = findViewById(resID);
                buttons[i][ii].setOnClickListener(this);
            }
        }
        Button buttonReset = findViewById(R.id.btnReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }


    @Override
    public void onClick(View v) {

        if (!((Button) v).getText().toString().equals("")) { return; }
        if (!p1Turn) {
            ((Button) v).setText("O");
        } else {
            ((Button) v).setText("X");
        }

        numCount++;

        if (logicForGame())
        {
            if (!p1Turn) { winingP2(); }
            else { winingP1(); }
        }
         else if ( numCount==0)
        {
            draw();
        }
        else {
            p1Turn = !p1Turn;
        }

       if(p1Scores > 10 && p2Scores < p1Scores)
       {
           Toast.makeText(this, "Player 1 won the Game!!!!!!", Toast.LENGTH_SHORT).show();
           resetGame();
       }

    }


    private boolean logicForGame() {
        String[][] grid = new String[3][3];
        for (int i = 0; i <= 2; i++)
        {
            for (int ii = 0; ii <= 2; ii++) {grid[i][ii] = buttons[i][ii].getText().toString();}
        }
        for (int i = 0; i <= 2; i++)
        {
            if (grid[i][0].equals(grid[i][1]) && grid[i][0].equals(grid[i][2]) && !grid[i][0].equals("")) { return true; }
        }
        for (int i = 0; i <=2; i++)
        {
            if (grid[0][i].equals(grid[1][i]) && grid[0][i].equals(grid[2][i]) && !grid[0][i].equals("")) { return true; }
        }
        if (grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2]) && !grid[0][0].equals("")) {return true; }
        else if (grid[0][2].equals(grid[1][1]) && grid[0][2].equals(grid[2][0]) && !grid[0][2].equals("")) { return true; }
        return false;
    }
    private void winingP1() {
        p1Scores++;
        Toast.makeText(this, "Player 1 won!!!!!!", Toast.LENGTH_SHORT).show();
        text1.setText("Player 1: " + p1Scores);
        text2.setText("Player 2: " + p2Scores);
        resetGrid();
    }
    private void winingP2() {
        p2Scores++;
        Toast.makeText(this, "Player 2 won!!!!!!", Toast.LENGTH_SHORT).show();
        text1.setText("Player 1: " + p1Scores);
        text2.setText("Player 2: " + p2Scores);
        resetGrid();
    }
    private void draw() {
        Toast.makeText(this, "Draw the GAME!!!!!", Toast.LENGTH_SHORT).show();
        resetGrid();
    }

    private void resetGame() {
        p1Scores = 0;
        p2Scores = 0;
        text1.setText("Player 1: " + p1Scores);
        text2.setText("Player 2: " + p2Scores);
        resetGrid();
    }

    private void resetGrid() {
        for (int i = 0; i <= 2; i++) {
            for (int ii = 0; ii <= 2; ii++)
            {
                buttons[i][ii].setText("");
            }
        }
        numCount = 0;
        p1Turn = true;
    }

}






