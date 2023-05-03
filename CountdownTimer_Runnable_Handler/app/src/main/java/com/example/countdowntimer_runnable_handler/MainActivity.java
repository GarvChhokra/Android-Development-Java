package com.example.countdowntimer_runnable_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // using CountDown Timer
        new CountDownTimer(15000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                Log.d("stopWatch", "Timer start");
            }

            @Override
            public void onFinish() {
                Log.d("stopWatch","Your timer is completed");
            }
        }.start();
        // .start() we write to start our countdowntimer object which we have created


        // Task Schedule using Runner and Handler

        // it will continuosly run without stoppping it




//        Handler handler = new Handler();
//        Runnable run = new Runnable() {
//            @Override
//            public void run() {
//                num++;
//
//                // code to execute
//                Toast.makeText(MainActivity.this, "This is my toast"+num, Toast.LENGTH_SHORT).show();
//                handler.postDelayed(this,1000);
//            }
//        };
//
//        handler.post(run);

    }
}