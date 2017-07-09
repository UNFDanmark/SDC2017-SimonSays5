package com.example.deltager.simonsays5;

import android.util.Log;

/**
 * Created by deltager on 06-07-17.
 */

public class Player {

//    private GameController gameController;
    private int playerID;
    public int playerTimer;

    // Dette er den nye måde
    public Player(int playerID){
        this.playerID = playerID;
        playerTimer = 60;
    }

    public int getPlayerID() {
        return playerID;
    }


    // Dette var den gamle måde
//    public Player(int playerID, GameController gameController){
//        this.playerID = playerID;
//        playerTimer = 60;
//        this.gameController = gameController;
//    }
//
//
//    public void TrykkedePåEnFarve (char farve){
//        Log.i("Player", "Stadigvæk " + farve);
//        gameController.spillerValgteFarve(playerID, farve);
//    }


}
