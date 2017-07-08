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

    //MediaPlayer beginGameMP;
    public void player2b (View view) {
        //beginGameMP.start();
        Intent intent = new Intent(this, TwoPlayerActivity.class);
        startActivity(intent);
    }
}
