package com.example.photoframesolution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView pic;
    Button pre, nxt;
    TextView text;
    int currentImage=1;
    // on clicking next button
    public void next(View view){
        String idX = "pic"+ currentImage;
        int x= this.getResources().getIdentifier(idX,"id", getPackageName());
        // to make x looks like R.id.pic_  we write a code in the above line
        pic=findViewById(x);
        pic.setAlpha(0f);

        if(currentImage<4){
            currentImage++;
        }
        else if(currentImage==4){
            currentImage=0;
        }
        else{};
        String idY = "pic"+ currentImage;
        int y= this.getResources().getIdentifier(idY,"id", getPackageName());
        pic=findViewById(y);         // to make y looks like R.id.pic_  we write a code in the above line
        pic.setAlpha(1f);
    }
    // on clicking previous button
    public void previous(View view){
        String idX = "pic"+ currentImage;
        int x= this.getResources().getIdentifier(idX,"id", getPackageName());
        pic=findViewById(x);
        pic.setAlpha(0f);
        if(currentImage>0){
            currentImage--;
        }
        else if(currentImage==0){
            currentImage=4;
        }
        else{ };
        String idY = "pic"+ currentImage;
        int y= this.getResources().getIdentifier(idY,"id", getPackageName());
        pic=findViewById(y);
        pic.setAlpha(1f);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}