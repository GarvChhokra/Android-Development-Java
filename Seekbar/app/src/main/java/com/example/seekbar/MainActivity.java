package com.example.seekbar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    // Audio manager
    AudioManager audioManager;

    MediaPlayer obj;

    public void play(View view){
        obj.start();
    }

    public void pausemusic(View view){
        obj.pause();
    }

    public void stop(View view){
        obj.stop();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        obj=MediaPlayer.create(this,R.raw.song);


        // Seek-bar ....


        // Audio to the Seek-bar
        // Audio Manager

        // creating max volume and min volume using Audio Manager and transferring to Seek-bar
        
        audioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVol=audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);
        int currVol=audioManager.getStreamVolume(audioManager.STREAM_MUSIC);


        // getting seekbar id attached
        SeekBar seekVol= findViewById(R.id.seekVol);
        seekVol.setMax(maxVol);
        seekVol.setProgress(currVol);

        // what change will happen if i will drag on it
        seekVol.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




        // Music Length to the seekbar

        SeekBar seekMusicLength=findViewById(R.id.seekMusicLength);
        seekMusicLength.setMax(obj.getDuration());                                      // here obj is the object for music and we are combining our music length to our seekbar


        // Timer called to set progress and set delay and period that there will be no delay and progress with 1 sec (100ms)
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekMusicLength.setProgress(obj.getCurrentPosition());
            }
        },0,100);


        seekMusicLength.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                obj.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });;


    }
}