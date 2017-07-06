package com.example.deltager.simonsays5;

/**
 * Created by deltager on 06-07-17.
 */

public class Player {

    private GameController gameController;
    private int playerID;

    public Player(int playerID, GameController gameController){
        this.playerID = playerID;
        this.gameController = gameController;
    }

    public void TrykkedePåEnFarve (char farve){
         gameController.spillerValgteFarve(playerID, farve);
    }


}
