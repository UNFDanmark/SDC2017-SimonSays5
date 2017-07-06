package com.example.deltager.simonsays5;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.example.deltager.simonsays5.R.layout.player2;


public class MainMenu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void player2b (View view) {

        Intent intent = new Intent(this, TwoPlayerActivity.class);
        startActivity(intent);
    }
}
