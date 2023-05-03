package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


//    TextView musicname = findViewById(R.id.musicname);

    // MusicPlayer
    MediaPlayer obj;

    //Play
    public void play(View view){
        obj.start();
    }

    //Pause
    public void pause(View view){
        obj.pause();
    }

    // Stop
    public void stop(View view){
        obj.stop();
    }

    // IMP: IMP: here if we click on the stop button our music will not run
    // in later videos we will learn this also to play again after clicking
    // on stop button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // we are saying when all the designs are ready then link our play,
        // pause and stop function with this music

        obj=MediaPlayer.create(this, R.raw.jinglebell);
    }
}