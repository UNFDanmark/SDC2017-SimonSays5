package com.example.deltager.simonsays5;



import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.deltager.simonsays5.R.layout.player2;
import android.media.MediaPlayer;
import android.widget.Button;


public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //beginGameMP = MediaPlayer.create(this, R.raw.begin_game);
    }

    public void player2b (View view) {
        Intent intent = new Intent(this, TwoPlayerActivity.class);
        intent.putExtra("player1Timer", 0);
        intent.putExtra("player2Timer", 0);
        startActivity(intent);

    }

    public void player2bTimer (View view) {
        Intent intent = new Intent(this, TimeSettings.class);
        startActivity(intent);
    }

    private void startTwoPlayer(int player1Timer, int player2Timer){
        Intent intent = new Intent(this, TwoPlayerActivity.class);
        intent.putExtra("player1Timer", player1Timer);
        intent.putExtra("player2Timer", player2Timer);
        startActivity(intent);
    }
}
