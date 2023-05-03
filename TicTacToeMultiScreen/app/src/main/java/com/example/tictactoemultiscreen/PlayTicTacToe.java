package com.example.tictactoemultiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayTicTacToe extends AppCompatActivity {
    // 0-O
    //1-X
    int activePlayer=1;
    int gameState[] ={2,2,2,2,2,2,2,2,2};
    // State meanings
    // 2 - null
    // 0 - O
    // 1 - X
    int count=0,total=0;
    int winningPositions[][]={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img = (ImageView) view;  // storing in which block we have clicked
        int tappedImage = Integer.parseInt(img.getTag().toString());  // getting our tags like 0,1,2,etc we stored to each image and storing to tappedimage here img is sending us what used have clicked and passing the clicked tag and storing it
        if(gameState[tappedImage]==2){
            gameState[tappedImage]=activePlayer;
            img.setTranslationY(-1000f);    // Dosent know what it is doing
            if(activePlayer==0){

                img.setImageResource(R.drawable.o);
                activePlayer=1;
                TextView status=findViewById(R.id.status);
                status.setText("X Turn - Tap to Play!!");
                total++;
            }
            else{
                img.setImageResource(R.drawable.x);
                activePlayer=0;
                TextView status=findViewById(R.id.status);
                total++;

                count++;
                if(count<=4){
                    status.setText("O Turn - Tap to Play!!");
                }

            }
            if(total>8){
                TextView status=findViewById(R.id.status);
                status.setText("");
            }
            img.animate().translationYBy(1000f).setDuration(300); //Dosent know what it is doing
        }
        // Checking if any player has won
        for(int winposition[] : winningPositions){ // meaning of this for winposition[] in my array winningPositions
            if(gameState[winposition[0]]== gameState[winposition[1]] && gameState[winposition[1]]== gameState[winposition[2]] && gameState[winposition[1]]!=2){   // doesnt understand

                // Somebody has won - Finding out who has won

                String winnerStr;
                if(gameState[winposition[0]]==1){
                    winnerStr="X has won";

                }
                else{
                    winnerStr="O has won";


                }

                // Announcing the winner
                TextView status=findViewById(R.id.status);
                status.setText(winnerStr);

                // stopping the next chance if we got the winner
                for(int i=0;i<winningPositions.length;i++)
                    if(winposition == winningPositions[i]){
                        for(int j=0;j<gameState.length;j++){
                            gameState[j]=3;
                        }
                    }
//
            }
        }


    }



    public void resetGame(View view) {
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
            ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
            TextView status=findViewById(R.id.status);
            status.setText("X Turn - Tap to Play!!");
            activePlayer=1;
            total=0;
            count=0;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_tic_tac_toe);
    }
}