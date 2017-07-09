package com.example.deltager.simonsays5;

import android.os.CountDownTimer;
import android.util.Log;

import java.util.Random;

/**
 * Created by deltager on 06-07-17.
 */

public class GameController {

    private TwoPlayerActivity twoPlayerActivity;
    private Player player1;
    private Player player2;

    private SimonSaysSequence sequence;
    private int currentColorIndex;

    private int activePlayer;
    private boolean addColor = true;
    private boolean isGameOver;

    //Gamemode where the computer chooses the color and the two players have to be to fastest
    private Random prng;

    private boolean useTimer;

    public GameController (final TwoPlayerActivity twoPlayerActivity, Player player1, Player player2){
        this.twoPlayerActivity = twoPlayerActivity;
        this.player1 = player1;
        this.player2 = player2;

        useTimer = player1.playerTimer > 0 && player2.playerTimer > 0;
        activePlayer = 0;

        sequence = new SimonSaysSequence();
        prng = new Random(100);

        if(this.useTimer) {
            twoPlayerActivity.setTimerText(player1.playerTimer + "", 1);
            twoPlayerActivity.setTimerText(player2.playerTimer + "", 2);
            gameTimer();
        }

        startGame();
    }

    private void gameTimer(){
        CountDownTimer timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long l) {
                if (activePlayer == 1) {
                    player1.playerTimer--;
                    twoPlayerActivity.setTimerText(player1.playerTimer + "", 1);
                    if (player1.playerTimer == 0) {
//                        Log.i("player 1 lost", "LOST THE GAME!");
                        PlayerLost();
                    }
                }
                if (activePlayer == 2) {
                    player2.playerTimer--;
                    twoPlayerActivity.setTimerText(player2.playerTimer + "", 2);
                    if (player2.playerTimer == 0) {
//                        Log.i("player 2 lost", "LOST THE GAME!");
                        PlayerLost();
                    }
                }
            }


            @Override
            public void onFinish() {
                start();
            }
        };
        timer.start();
    }

    private void startGame(){
        twoPlayerActivity.startAllBntBlink();
        twoPlayerActivity.setMiddleText("Press a color to start!!");
    }

    public void spillerValgteFarve (int playerID, char farve) {
        //Hvis spillet lige er startet skal vi stoppe alle de blinkende knapper og
        //sætte den aktive spiller til den første der trykkede
        if(sequence.getAmount() == 0){
            activePlayer = playerID;
            twoPlayerActivity.stopAllBntBlink();
        }

        //Logik for hvis spillet er i gang
        if(isGameOver == false) {
            lightButton(playerID, farve);
            if (activePlayer == playerID) {
                if (addColor) {
                    addColorToSequence(farve);
                    ChangePlayer();
                } else {
                    if (CheckCorrectSequenceColor(farve)) {
                        IncrementColorIndex();
                        if (HasFinishedSequence()) {
                            //twoPlayerActivity.setMiddleText("player " + activePlayer + " choose color!");
                            playerSuccede();
                        }
                    } else {
                        PlayerLost();
                    }
                }
            }
        }
    }

    private  void addRandomColorToSequence(){
        int colorToAdd = prng.nextInt(3);
        char farveToAdd = '-';
        switch (colorToAdd){
            case(0):
                farveToAdd = 'R';
                break;
            case(1):
                farveToAdd = 'G';
                break;
            case(2):
                farveToAdd = 'B';
                break;
            case(3):
                farveToAdd = 'Y';
                break;
        }
        sequence.addChar(farveToAdd);
        twoPlayerActivity.blinkBothPlayers(farveToAdd);
    }

    private void addColorToSequence(char color){
        sequence.addChar(color);
        addColor = false;
        BtnStopBlinkActivePlayer();
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
        //twoPlayerActivity.setMiddleText("player " + activePlayer + " lost");
        //Test
        Log.i("Player", "Player " + activePlayer + " LOST!!");
        twoPlayerActivity.playerLost(activePlayer);
        twoPlayerActivity.setMiddleText("You remembered " + sequence.getAmount() + " color" + ((sequence.getAmount() > 1)?"s":"") + "\nPress to restart");
        twoPlayerActivity.stopAllBntBlink(); //For en sikkerheds skyld stop alle knapper der blinker hvis nogle gør
        twoPlayerActivity.setPlayerText(activePlayer, "YOU LOST!!");
        twoPlayerActivity.setPlayerText(GetNextPlayerID(), "YOU WON!!");

        twoPlayerActivity.checkUpdateHighscore(sequence.getAmount());

        isGameOver = true;

        activePlayer = 0;
    }

    /*
    Player has succesfully remembered the sequence
     */
    private void playerSuccede(){
        addColor = true;
        twoPlayerActivity.setMiddleText("Add color to sequence");
        BtnStartBlinkActivePlayer();
        //Test
        Log.i("Player", "Player " + activePlayer + " SUCCEDE!!");
    }

    /*
    Changes the active player from 1 -> 2 or 2 -> 1
     */
    private void ChangePlayer(){
        currentColorIndex = 0;
        //getWindow().getDecorView().setBackgroundColor(0xFFC3FFF7);
        //twoPlayerActivity.setMiddleText("Changed player to " + GetNextPlayerID());
        activePlayer = GetNextPlayerID();

        twoPlayerActivity.setMiddleText("Next player\nRemember sequence");
    }

    /*
    Returns the new Player if active player is 1 -> 2 else 2 -> 1
     */
    private int GetNextPlayerID(){
        if(activePlayer == 1){
            return 2;
        }else if (activePlayer == 2){
            return 1;
        }
        return -1;
    }

    private void BtnStartBlinkActivePlayer(){
        if(activePlayer == 1){
            twoPlayerActivity.P1BtnStartBlinking();
        } else if (activePlayer == 2){
            twoPlayerActivity.P2BtnStartBlinking();
        }
    }

    private void BtnStopBlinkActivePlayer() {
        if (activePlayer == 1) {
            twoPlayerActivity.P1BtnStopBlinking();
        } else if (activePlayer == 2) {
            twoPlayerActivity.P2BtnStopBlinking();
        }
    }

    public void restartGame(){
        sequence.clear();
        isGameOver = false;
        currentColorIndex = 0;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }
}

