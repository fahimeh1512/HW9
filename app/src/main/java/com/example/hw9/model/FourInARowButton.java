package com.example.hw9.model;


import android.graphics.Color;

public class FourInARowButton {
    private boolean mIsTouched = false;
    private boolean mIsBelowFull;
    private int mIIndex;
    private int mJIndex;
    private int mColor = Color.LTGRAY;

    public FourInARowButton(int i, int j) {
        mIIndex = i;
        mJIndex = j;
    }

    public boolean isTouched() {
        return mIsTouched;
    }

    public void setTouched(boolean touched) {
        mIsTouched = touched;
    }

    public boolean isBelowFull() {
        if (mIIndex == 4)
            return true;
        return mIsBelowFull;
    }

    public void setBelowFull(boolean belowFull) {
        if (mIIndex == 4)
            mIsBelowFull = true;
        else
        mIsBelowFull = belowFull;
    }

    public int getIIndex() {
        return mIIndex;
    }

    public void setIIndex(int IIndex) {
        mIIndex = IIndex;
    }

    public int getJIndex() {
        return mJIndex;
    }

    public void setJIndex(int JIndex) {
        mJIndex = JIndex;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }
}
