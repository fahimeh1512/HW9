package com.example.hw9.model;

public class TicTacToeButton {
    private boolean mIsTouched = false;
    private String mCharacter = "";

    public boolean isTouched() {
        return mIsTouched;
    }

    public void setTouched(boolean touched) {
        mIsTouched = touched;
    }

    public String getCharacter() {
        return mCharacter;
    }

    public void setCharacter(String character) {
        mCharacter = character;
    }
}
