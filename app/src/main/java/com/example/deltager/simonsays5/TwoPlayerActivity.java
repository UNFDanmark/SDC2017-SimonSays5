package com.example.deltager.simonsays5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.media.MediaPlayer;

/**
 * Created by deltager on 06-07-17.
 */

public class TwoPlayerActivity extends Activity {

    private GameController gameController;
    private Player player1, player2;

    //player 1; knapper
    public simonSaysButton p1RødKnap, p1BlåKnap, p1GrønKnap, p1GulKnap;

    //player 2; knapper
    public simonSaysButton p2RødKnap, p2BlåKnap, p2GrønKnap, p2GulKnap;

    private boolean P1BtnIsBlinking, P1BtnIsOn;
    private boolean P2BtnIsBlinking, P2BtnIsOn;

    private int blinkingInterval = 500;

    private int bgBlinkTime = 350, bgStartFarve;
    private boolean bgIsBlinking, bgIsColorOn;

    private MediaPlayer buttonPlayer;

    private MediaPlayer sound1;
    private MediaPlayer sound2;
    private MediaPlayer sound3;
    private MediaPlayer sound4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2);
        findViewById(R.id.restartGameBtn).setBackgroundColor(Color.TRANSPARENT);

        /*
        sound1 = MediaPlayer.create(this, R.raw.sound1);
        sound2 = MediaPlayer.create(this, R.raw.sound3);
        sound3 = MediaPlayer.create(this, R.raw.sound2);
        sound4 = MediaPlayer.create(this, R.raw.sound4);
        */

        // FIXME: Understående 3 objekter kræver hinanden i deres constructor. Dette er ikke godt. Refactor.
//
//        player1 = new Player(1, gameController);
//        player2 = new Player(2, gameController);
//        gameController = new GameController(this);

        p1RødKnap = new simonSaysButton(0xFFF45942, 0xFFea4335, findViewById(R.id.redP1Btn));
        p1BlåKnap = new simonSaysButton(0xFF42A3F4, 0xFF4285F4, findViewById(R.id.blueP1Bnt));
        p1GrønKnap = new simonSaysButton(0xFF17BB4A, 0xFF34A853, findViewById(R.id.greenP1Bnt));
        p1GulKnap = new simonSaysButton(0xFFFFD430, 0xFFFBBC05, findViewById(R.id.yellowP1Btn));

        p2RødKnap = new simonSaysButton(0xFFF45942, 0xFFea4335, findViewById(R.id.redP2Btn));
        p2BlåKnap = new simonSaysButton(0xFF42A3F4, 0xFF4285F4, findViewById(R.id.blueP2Btn));
        p2GrønKnap = new simonSaysButton(0xFF17BB4A, 0xFF34A853, findViewById(R.id.greenP2Btn));
        p2GulKnap = new simonSaysButton(0xFFFFD430, 0xFFFBBC05, findViewById(R.id.yellowP2Btn));

        bgStartFarve = getWindow().getDecorView().getSolidColor();

        gameController = new GameController(this,
                new Player(1, getIntent().getIntExtra("player1Timer", 0)),
                new Player(2, getIntent().getIntExtra("player2Timer", 0)));

        findViewById(R.id.restartGameBtn).setSoundEffectsEnabled(false);
    }

    private void playSound(int sound){
        if(buttonPlayer != null){
            buttonPlayer.release();
        }

        buttonPlayer = MediaPlayer.create(this, sound);
        buttonPlayer.start();
    }

    public void checkUpdateHighscore(int score){
        if(score > Prefs.getHighscore(this)){
            Prefs.setHighscore(this, score);
        }
    }

    public void P1BtnStartBlinking() {
        P1BtnIsBlinking = true;

        new CountDownTimer(blinkingInterval, blinkingInterval) {
            public void onTick(long millisUntilFinished) {
                if (P1BtnIsOn == true) {
                    p1RødKnap.changeToOff();
                    p1BlåKnap.changeToOff();
                    p1GrønKnap.changeToOff();
                    p1GulKnap.changeToOff();
                    P1BtnIsOn = false;
                } else if (P1BtnIsOn == false) {
                    p1RødKnap.changeToOn();
                    p1BlåKnap.changeToOn();
                    p1GrønKnap.changeToOn();
                    p1GulKnap.changeToOn();
                    P1BtnIsOn = true;
                }
            }

            public void onFinish(){
                if(P1BtnIsBlinking ==true){
                    start();
                }
            }
        }.start();
    }

    public void P1BtnStopBlinking() {
        p1RødKnap.changeToOff();
        p1BlåKnap.changeToOff();
        p1GrønKnap.changeToOff();
        p1GulKnap.changeToOff();

        P1BtnIsBlinking = false;
    }

    public void P2BtnStartBlinking() {
        P2BtnIsBlinking = true;

        new CountDownTimer(blinkingInterval, blinkingInterval) {
            public void onTick(long millisUntilFinished) {
                if (P2BtnIsOn == true) {
                    p2RødKnap.changeToOff();
                    p2BlåKnap.changeToOff();
                    p2GrønKnap.changeToOff();
                    p2GulKnap.changeToOff();
                    P2BtnIsOn = false;
                } else if (P2BtnIsOn == false) {
                    p2RødKnap.changeToOn();
                    p2BlåKnap.changeToOn();
                    p2GrønKnap.changeToOn();
                    p2GulKnap.changeToOn();
                    P2BtnIsOn = true;
                }

            }

            public void onFinish() {
                if (P2BtnIsBlinking == true) {
                    start();
                }
            }
        }.start();

    }

    public void blinkBothPlayers(final char farve){
        switch (farve){
            case('R'):
                p1RødKnap.changeToOn();
                p2RødKnap.changeToOn();
                break;
            case('G'):
                p1GrønKnap.changeToOn();
                p2GrønKnap.changeToOn();
                break;
            case('B'):
                p1BlåKnap.changeToOn();
                p2BlåKnap.changeToOn();
                break;
            case('Y'):
                p1GulKnap.changeToOn();
                p2GulKnap.changeToOn();
                break;
        }

        new CountDownTimer(blinkingInterval, blinkingInterval){
            public void onTick (long millisUntilFinished){

            }

            public void onFinish(){
                switch (farve){
                    case('R'):
                        p1RødKnap.changeToOff();
                        p2RødKnap.changeToOff();
                        break;
                    case('G'):
                        p1GrønKnap.changeToOff();
                        p2GrønKnap.changeToOff();
                        break;
                    case('B'):
                        p1BlåKnap.changeToOff();
                        p2BlåKnap.changeToOff();
                        break;
                    case('Y'):
                        p1GulKnap.changeToOff();
                        p2GulKnap.changeToOff();
                        break;
                }
            }
        }.start();
    }

    public void startAllBntBlink(){
        //Vi kan ikke gøre dette fordi den venter på hinanden:
        //P1BtnStartBlinking();
        //P2BtnStartBlinking();

        P1BtnIsBlinking = true;
        P2BtnIsBlinking = true;

        new CountDownTimer(blinkingInterval, blinkingInterval){
            public void onTick (long millisUntilFinished){
                if(P2BtnIsOn == true && P1BtnIsOn == true){
                    p1RødKnap.changeToOff();
                    p1BlåKnap.changeToOff();
                    p1GrønKnap.changeToOff();
                    p1GulKnap.changeToOff();
                    p2RødKnap.changeToOff();
                    p2BlåKnap.changeToOff();
                    p2GrønKnap.changeToOff();
                    p2GulKnap.changeToOff();

                    P1BtnIsOn = false;
                    P2BtnIsOn = false;
                }
                else if(P2BtnIsOn == false && P1BtnIsOn == false){
                    p1RødKnap.changeToOn();
                    p1BlåKnap.changeToOn();
                    p1GrønKnap.changeToOn();
                    p1GulKnap.changeToOn();
                    p2RødKnap.changeToOn();
                    p2BlåKnap.changeToOn();
                    p2GrønKnap.changeToOn();
                    p2GulKnap.changeToOn();

                    P1BtnIsOn = true;
                    P2BtnIsOn = true;
                }

            }
            public void onFinish(){
                if(P1BtnIsBlinking == true && P2BtnIsBlinking ==true){
                    start();
                }
            }
        }.start();
    }

    public void stopAllBntBlink(){
        //Vi kan ikke gøre dette fordi den venter på hinanden:
        //P1BtnStopBlinking();
        //P2BtnStopBlinking();

        P1BtnIsBlinking = false;
        P2BtnIsBlinking = false;
    }

    public void StartBackgroundBlinking(){
        bgIsBlinking = true;

        //Sæt kanppen til at være en valgt farve
        findViewById(R.id.restartGameBtn).setBackgroundColor(0x8FC3FFF1);
        bgIsColorOn = true; //Så colorOn så den bliver skiftet til transparent så den ikke har dobbelt tid

        new CountDownTimer(bgBlinkTime, bgBlinkTime){
            public void onTick(long millisUntilFinished){
                if(bgIsColorOn == false){
                    findViewById(R.id.restartGameBtn).setBackgroundColor(0x8FC3FFF1);
                    bgIsColorOn = true;
                } else if(bgIsColorOn == true){
                    findViewById(R.id.restartGameBtn).setBackgroundColor(Color.TRANSPARENT);
                    bgIsColorOn = false;
                }
            }

            public void onFinish() {
                if (bgIsBlinking == true) {
                    start();
                }
            }
        }.start();
    }

    public void StopBackgroundBlinking() {
        bgIsBlinking = false;
    }

    public void P2BtnStopBlinking() {
        p2RødKnap.changeToOff();
        p2BlåKnap.changeToOff();
        p2GrønKnap.changeToOff();
        p2GulKnap.changeToOff();

        P2BtnIsBlinking = false;
    }

    public void playerLost (int activePlayer){
        StartBackgroundBlinking();
    }

    private void P2TrykkedePåenFarve(char farve) {
        gameController.spillerValgteFarve(2, farve);
    }

    public void P2TrykkedePåRød(View view) {
        P2TrykkedePåenFarve('R');
    }

    public void P2TrykkedePåGrøn(View view) {
        P2TrykkedePåenFarve('G');
    }

    public void P2TrykkedePåBlå(View view) {
        P2TrykkedePåenFarve('B');
    }

    public void P2TrykkedePåGul(View view) {
        P2TrykkedePåenFarve('Y');
    }

    private void P1TrykkedePåenFarve(char farve) {
        gameController.spillerValgteFarve(1, farve);
    }

    public void P1TrykkedePåRød(View view) {
        P1TrykkedePåenFarve('R');
    }

    public void P1TrykkedePåGrøn(View view) {
        P1TrykkedePåenFarve('G');
    }

    public void P1TrykkedePåBlå(View view) {
        P1TrykkedePåenFarve('B');
    }

    public void P1TrykkedePåGul(View view) {
        P1TrykkedePåenFarve('Y');
    }

    public void setMiddleText(String nyText){
        ((TextView)findViewById(R.id.middelText)).setText(nyText);
    }

    public void GameRestart(View view){
        if(gameController.getIsGameOver()){
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }

    public void setTimerText(String timerText, int player) {
        if (player == 1) {
            ((TextView) findViewById(R.id.player1Timer)).setText(timerText);
        } else {
            ((TextView) findViewById(R.id.player2Timer)).setText(timerText);
        }
    }

    public void setPlayerText(int playerID, String text){
        if(playerID == 1){
            ((TextView)findViewById(R.id.p1TopText)).setText(text);
        } else if(playerID == 2) {
            ((TextView)findViewById(R.id.p2TopText)).setText(text);
        }
    }

    public void playerColorButtonSound(char farve){
        switch (farve) {
            case ('R'):
                playSound(R.raw.sound1);
                break;
            case ('G'):
                playSound(R.raw.sound2);
                break;
            case ('B'):
                playSound(R.raw.sound3);
                break;
            case ('Y'):
                playSound(R.raw.sound4);
                break;
        }
    }
}