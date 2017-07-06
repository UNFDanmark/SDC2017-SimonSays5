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

    public void farveSkift(final View view, int color, int tid) {
        //findViewById(R.id.buttonP1)

        int startColor = view.getSolidColor();
        view.setBackgroundColor(color);

        CountDownTimer timer = new CountDownTimer(tid, tid) {
            public void onFinish() {
                view.setBackgroundColor(startColor);
            }
        }.start();

    }
}
