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
        if(activePlayer == playerID){
            if(addColor){
                addColorToSequence(farve);
                ChangePlayer();
            }
            else{
                if(CheckCorrectSequenceColor(farve)){
                    IncrementColorIndex();
                    if(HasFinishedSequence()){
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
        //Test
        Log.i("Player", "Player " + activePlayer + " LOST!!");
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
    Chnages the active player from 1 -> 2 or 2 -> 1
     */
    private void ChangePlayer(){
        activePlayer = (activePlayer==1?2:1);
    }
}
