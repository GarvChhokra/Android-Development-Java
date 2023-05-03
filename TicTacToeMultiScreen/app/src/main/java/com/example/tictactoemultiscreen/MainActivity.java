package com.example.tictactoemultiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Playing game and tranferring to another activity
    public void playGame(View view){

        Intent obj= new Intent(this, PlayTicTacToe.class);

        startActivity(obj);

    }








    // Quitting game
    public void quitGame(View view){
        onDestroy();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}