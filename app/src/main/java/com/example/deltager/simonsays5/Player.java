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
        playerTimer = 0;
    }

    public  Player(int playerID, int playerTimer){
        this.playerID = playerID;
        this.playerTimer = playerTimer;
    }

    public int getPlayerID() {
        return playerID;
    }
}
