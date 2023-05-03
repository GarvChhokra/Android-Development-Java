package com.example.embeddingvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VideoView obj = findViewById(R.id.video1);
        obj.setVideoPath("android.resource://" + getPackageName()+"/"+ R.raw.video);
        obj.start();

        VideoView obj2 = findViewById(R.id.video2);
        obj2.setVideoPath("android.resource://" + getPackageName()+"/"+ R.raw.testingmobileversion);
        obj2.start();

        // media controller for video1
        MediaController ob = new MediaController(this);
        obj.setMediaController(ob);
        ob.setAnchorView(obj);      // to stop video buttons

        // media controller for video2
        MediaController ob2 = new MediaController(this);
        obj2.setMediaController(ob);
        ob.setAnchorView(obj2);
    }
}