package com.example.deltager.simonsays5;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by deltager on 06-07-17.
 */

public class TwoPlayerActivity extends Activity{

    private GameController gameController;
    private Player player1, player2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2);

        gameController = new GameController(this);
        player1 = new Player(1, gameController);
        player2 = new Player(2, gameController);
    }

    private void P2TrykkedePåenFarve(char farve){
        player2.TrykkedePåEnFarve(farve);
    }

    private  void P2TrykkedePåRød(View view){
        P2TrykkedePåenFarve('R');
    }

    private  void P2TrykkedePåGrøn(View view){
        P2TrykkedePåenFarve('G');
    }

    private  void P2TrykkedePåBlå(View view){
        P2TrykkedePåenFarve('B');
    }

    private  void P2TrykkedePåGul(View view){
        P2TrykkedePåenFarve('Y');
    }

    private void P1TrykkedePåenFarve(char farve){
        player1.TrykkedePåEnFarve(farve);
    }

    private  void P1TrykkedePåRød(View view){
        P1TrykkedePåenFarve('R');
    }

    private  void P1TrykkedePåGrøn(View view){
        P1TrykkedePåenFarve('G');
    }

    private  void P1TrykkedePåBlå(View view){
        P1TrykkedePåenFarve('B');
    }

    private  void P1TrykkedePåGul(View view){
        P1TrykkedePåenFarve('Y');
    }
}
