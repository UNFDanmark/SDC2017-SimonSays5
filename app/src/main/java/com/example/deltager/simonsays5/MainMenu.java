package com.example.deltager.simonsays5;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static com.example.deltager.simonsays5.R.layout.player2;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.TextView;


public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((TextView)findViewById(R.id.highscoreTxt)).setText("Highscore: " + Prefs.getHighscore(this));
    }

    private void updatehighscoreText(){

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
