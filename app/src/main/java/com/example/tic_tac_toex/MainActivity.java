package com.example.tic_tac_toex;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    // ximage = 0, oimage = 1 , empty = 7
    int activePlayer = 0;

    int[] gameState = {7,7,7,7,7,7,7,7,7};

    int[][] winningPositions = {{0,3,6},{1,4,7},{2,5,8},{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6}};

    boolean gameActive = true;


    public void gameTouch(View v){

        ImageView chip = (ImageView) v;
        int tappedChip = Integer.parseInt(chip.getTag().toString());

        if(gameState[tappedChip] == 7 && gameActive) {
            gameState[tappedChip] = activePlayer;

            chip.setTranslationY(-1500);

            if (activePlayer == 0) {
                chip.setImageResource(R.drawable.ximage);
                activePlayer = 1;
            } else {

                chip.setImageResource(R.drawable.oimage);
                activePlayer = 0; }
            chip.animate().translationYBy(1500).rotation(720).setDuration(1000);

            for (int[] oneWinningPosition : winningPositions) {

                if (gameState[oneWinningPosition[0]] == gameState[oneWinningPosition[1]] && gameState[oneWinningPosition[1]] == gameState[oneWinningPosition[2]] && gameState[oneWinningPosition[0]] != 7) {

                    gameActive = false;

                    if (activePlayer == 0) {
                        Toast.makeText(getApplicationContext(), "O has Won", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "X has Won", Toast.LENGTH_LONG).show();

                    }
                    Button restartButton = (Button) findViewById(R.id.restartButton);
                    restartButton.setVisibility(View.VISIBLE);
                }
            }
        } ›
    }


    public void restartButtonX(View v){

        Button restartButton = (Button) findViewById(R.id.restartButton);
        restartButton.setVisibility(View.INVISIBLE);





        ( ( ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ( ( ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        activePlayer = 0;
        gameActive = true;



        for(int i = 0;i<9;i++){
    
           gameState[i] = 7;

        }





    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}