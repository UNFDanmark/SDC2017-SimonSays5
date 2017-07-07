package com.example.deltager.simonsays5;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by deltager on 07-07-17.
 */

public class OnePlayerActivity extends Activity {

    //private GameController gameController;
    //private Player player;

    //player; knapper
    public simonSaysButton p1RødKnap, p1BlåKnap, p1GrønKnap, p1GulKnap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        p1RødKnap = new simonSaysButton(0xFFFF5F51, 0xFFEA4335, findViewById(R.id.RedP1Btn));
        p1BlåKnap = new simonSaysButton(0xFF6694FF, 0xFF4285F4, findViewById(R.id.BlueP1Bnt));
        p1GrønKnap = new simonSaysButton(0xFF2EEB74, 0xFF47E571, findViewById(R.id.GreenP1Bnt));
        p1GulKnap = new simonSaysButton(0xFFFFCE4F, 0xFFFBBC05, findViewById(R.id.yellowP1Btn));
    }

    /*
    private void P1TrykkedePåenFarve(char farve){
        //player.TrykkedePåEnFarve(farve);
    }
    */

    public void P1TrykkedePåRød (View view){

    }

    public void P1TrykkedePåBlå (View view){

    }

    public void P1TrykkedePåGrøn (View view){

    }

    public void P1TrykkedePåGul (View view){

    }
}
