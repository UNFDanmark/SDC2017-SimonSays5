package com.example.deltager.simonsays5;

/**
 * Created by deltager on 06-07-17.
 */

public class SimonSaysSequence {
    private String seq;

    public SimonSaysSequence(String seq){
        this.seq = seq;
    }

    public SimonSaysSequence(){
        seq = "";
    }

    public char charAt(int index){
        return seq.charAt(index);
    }

    public void addChar(char tilda){
        seq += tilda;
    }
}
