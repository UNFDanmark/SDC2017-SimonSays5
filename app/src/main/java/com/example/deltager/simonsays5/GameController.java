package com.example.deltager.simonsays5;

import android.util.Log;

/**
 * Created by deltager on 06-07-17.
 */

public class GameController {

    private TwoPlayerActivity twoPlayerActivity;

    private SimonSaysSequence sequence;
    private int currentColorIndex;

    private int activePlayer = 1;
    private boolean addColor = true;

    public GameController (TwoPlayerActivity twoPlayerActivity){
        sequence = new SimonSaysSequence();
        this.twoPlayerActivity = twoPlayerActivity;
    }

    public void spillerValgteFarve (int playerID, char farve){
        lightButton(playerID, farve);
        if(activePlayer == playerID){
            if(addColor){
                addColorToSequence(farve);
                ChangePlayer();
                twoPlayerActivity.setMiddleText("player " + activePlayer + " START!");
            }
            else{
                if(CheckCorrectSequenceColor(farve)){
                    IncrementColorIndex();
                    if(HasFinishedSequence()){
                        twoPlayerActivity.setMiddleText("player " + activePlayer + " choose color!");
                        playerSuccede();
                    }
                } else {
                    PlayerLost();
                }
            }
        }
    }

    private void addColorToSequence(char color){
        sequence.addChar(color);
        addColor = false;
        lightButton(GetNextPlayerID(), color);
    }

    private void lightButton(int activePlayer, char V) {

        if (activePlayer == 1) {
            if (V == 'B') {
                twoPlayerActivity.p1BlåKnap.btnBlink();
            }
            else if (V == 'R') {
                twoPlayerActivity.p1RødKnap.btnBlink();
            }
            else if (V == 'G') {
                twoPlayerActivity.p1GrønKnap.btnBlink();
            }
            else if (V == 'Y') {
                twoPlayerActivity.p1GulKnap.btnBlink();
            }
        }
        else {
            if (V == 'B') {
                twoPlayerActivity.p2BlåKnap.btnBlink();
            }
            else if (V == 'R') {
                twoPlayerActivity.p2RødKnap.btnBlink();
            }
            else if (V == 'G') {
                twoPlayerActivity.p2GrønKnap.btnBlink();
            }
            else if (V == 'Y') {
                twoPlayerActivity.p2GulKnap.btnBlink();
            }
        }


    }

    private void IncrementColorIndex(){
        currentColorIndex++;
    }

    private boolean HasFinishedSequence(){
        return currentColorIndex >= sequence.getAmount();
    }

    private boolean CheckCorrectSequenceColor(char color){
        return sequence.charAt(currentColorIndex) == color;
    }

    /*
    The active player has lost
     */
    private void PlayerLost(){
        twoPlayerActivity.setMiddleText("player " + activePlayer + " lost");
        //Test
        Log.i("Player", "Player " + activePlayer + " LOST!!");
        twoPlayerActivity.playerLost(activePlayer);
    }

    /*
    Player has succesfully remembered the sequence
     */
    private void playerSuccede(){
        addColor = true;

        //Test
        Log.i("Player", "Player " + activePlayer + " SUCCEDE!!");
    }

    /*
    Changes the active player from 1 -> 2 or 2 -> 1
     */
    private void ChangePlayer(){
        currentColorIndex = 0;
        twoPlayerActivity.setMiddleText("Changed player to " + GetNextPlayerID());
        activePlayer = GetNextPlayerID();
    }

    private int GetNextPlayerID(){
        if(activePlayer == 1){
            return 2;
        }else if (activePlayer == 2){
            return 1;
        }
        return -1;
    }
}
