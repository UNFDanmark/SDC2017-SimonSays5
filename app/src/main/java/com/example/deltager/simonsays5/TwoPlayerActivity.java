package com.example.deltager.simonsays5;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by deltager on 06-07-17.
 */

public class TwoPlayerActivity extends Activity{

    private GameController gameController;
    private Player player1, player2;
    public simonSaysButton p1RødKnap;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2);

        gameController = new GameController(this);
        player1 = new Player(1, gameController);
        player2 = new Player(2, gameController);

        p1RødKnap = new simonSaysButton(0xFFFF5F51, 0xFFEA4335, findViewById(R.id.RedP1Btn));
    }

    private void P2TrykkedePåenFarve(char farve){
        player2.TrykkedePåEnFarve(farve);
    }

    public void P2TrykkedePåRød(View view){
        P2TrykkedePåenFarve('R');
    }

    public void P2TrykkedePåGrøn(View view){
        P2TrykkedePåenFarve('G');
    }

    public void P2TrykkedePåBlå(View view){
        P2TrykkedePåenFarve('B');
    }

    public void P2TrykkedePåGul(View view){
        P2TrykkedePåenFarve('Y');
    }

    private void P1TrykkedePåenFarve(char farve){
        player1.TrykkedePåEnFarve(farve);
    }

    public void P1TrykkedePåRød(View view){
        P1TrykkedePåenFarve('R');
    }

    public void P1TrykkedePåGrøn(View view){
        P1TrykkedePåenFarve('G');
    }

    public void P1TrykkedePåBlå(View view){
        P1TrykkedePåenFarve('B');
    }

    public void P1TrykkedePåGul(View view){
        P1TrykkedePåenFarve('Y');
    }


}
