package com.example.hw9.controller;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hw9.R;
import com.example.hw9.model.FourInARowButton;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;

public class FourInARowFragment extends Fragment implements Serializable {
    private Button[][] mButtons = new Button[5][5];
    private FourInARowButton[][] mFButtons = new FourInARowButton[5][5];
    private boolean mUserFlag;

    private static final String BUNDLE_KEY_F_BUTTONS = "four_in_a_row_button_values";
    private static final String BUNDLE_KEY_USER_FLAG = "user_flag";

    {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                mFButtons[i][j] = new FourInARowButton(i, j);
    }

    public FourInARowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_four_in_a_row, container, false);

        findViews(view);
        setListeners(view);

        if (savedInstanceState != null) {
            mFButtons = (FourInARowButton[][]) savedInstanceState.getSerializable(BUNDLE_KEY_F_BUTTONS);
            mUserFlag = savedInstanceState.getBoolean(BUNDLE_KEY_USER_FLAG);

            saveButtonsStates();
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(BUNDLE_KEY_F_BUTTONS, (Serializable)mFButtons);
        outState.putBoolean(BUNDLE_KEY_USER_FLAG, mUserFlag);
    }

    private void findViews(View view) {
        mButtons[0][0] = view.findViewById(R.id.button10);
        mButtons[0][1] = view.findViewById(R.id.button11);
        mButtons[0][2] = view.findViewById(R.id.button12);
        mButtons[0][3] = view.findViewById(R.id.button13);
        mButtons[0][4] = view.findViewById(R.id.button14);
        mButtons[1][0] = view.findViewById(R.id.button15);
        mButtons[1][1] = view.findViewById(R.id.button16);
        mButtons[1][2] = view.findViewById(R.id.button17);
        mButtons[1][3] = view.findViewById(R.id.button18);
        mButtons[1][4] = view.findViewById(R.id.button19);
        mButtons[2][0] = view.findViewById(R.id.button20);
        mButtons[2][1] = view.findViewById(R.id.button21);
        mButtons[2][2] = view.findViewById(R.id.button22);
        mButtons[2][3] = view.findViewById(R.id.button23);
        mButtons[2][4] = view.findViewById(R.id.button24);
        mButtons[3][0] = view.findViewById(R.id.button25);
        mButtons[3][1] = view.findViewById(R.id.button26);
        mButtons[3][2] = view.findViewById(R.id.button27);
        mButtons[3][3] = view.findViewById(R.id.button28);
        mButtons[3][4] = view.findViewById(R.id.button29);
        mButtons[4][0] = view.findViewById(R.id.button30);
        mButtons[4][1] = view.findViewById(R.id.button31);
        mButtons[4][2] = view.findViewById(R.id.button32);
        mButtons[4][3] = view.findViewById(R.id.button33);
        mButtons[4][4] = view.findViewById(R.id.button34);
    }

    private void setListeners(final View view) {
        mButtons[0][0].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(0,0);
                checkStates(view, 0, 0);
            }
        });

        mButtons[0][1].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(0,1);
                checkStates(view, 0, 1);
            }
        });

        mButtons[0][2].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(0,2);
                checkStates(view, 0, 2);
            }
        });

        mButtons[0][3].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(0,3);
                checkStates(view, 0, 3);
            }
        });

        mButtons[0][4].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(0,4);
                checkStates(view, 0, 4);
            }
        });

        mButtons[1][0].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(1,0);
                checkStates(view,1, 0);
            }
        });

        mButtons[1][1].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(1,1);
                checkStates(view, 1, 1);
            }
        });

        mButtons[1][2].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(1,2);
                checkStates(view, 1, 2);
            }
        });

        mButtons[1][3].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) { 
                changeStates(1,3);
                checkStates(view, 1, 3);
            }
        });

        mButtons[1][4].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(1,4);
                checkStates(view, 1, 4);
            }
        });

        mButtons[2][0].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(2,0);
                checkStates(view, 2, 0);
            }
        });

        mButtons[2][1].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(2,1);
                checkStates(view, 2, 1);
            }
        });

        mButtons[2][2].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(2,2);
                checkStates(view, 2, 2);
            }
        });

        mButtons[2][3].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(2,3);
                checkStates(view, 2, 3);
            }
        });

        mButtons[2][4].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(2,4);
                checkStates(view, 2, 4);
            }
        });

        mButtons[3][0].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(3,0);
                checkStates(view, 3, 0);
            }
        });

        mButtons[3][1].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(3,1);
                checkStates(view, 3, 1);
            }
        });

        mButtons[3][2].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(3,2);
                checkStates(view, 3, 2);
            }
        });

        mButtons[3][3].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(3,3);
                checkStates(view, 3, 3);
            }
        });

        mButtons[3][4].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(3,4);
                checkStates(view, 3, 4);
            }
        });

        mButtons[4][0].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(4,0);
                checkStates(view, 4, 0);
            }
        });

        mButtons[4][1].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(4,1);
                checkStates(view, 4, 1);
            }
        });

        mButtons[4][2].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(4,2);
                checkStates(view, 4, 2);
            }
        });

        mButtons[4][3].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(4,3);
                checkStates(view, 4, 3);
            }
        });


        mButtons[4][4].setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                changeStates(4, 4);
                checkStates(view, 4, 4);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void changeStates(int i, int j) {
        // If the button is empty of color and the below button is full, states can be changed.
        if (!mFButtons[i][j].isTouched() && mFButtons[i][j].isBelowFull()) {
            // Changes the color in array and objects of mFButtons.
            if (mUserFlag) {
                mButtons[i][j].setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                mFButtons[i][j].setColor(Color.RED);
            }
            else {
                mButtons[i][j].setBackgroundTintList(ColorStateList.valueOf(Color.BLUE));
                mFButtons[i][j].setColor(Color.BLUE);
            }
            // Changes the user flag and mIsTouched field.
            mUserFlag = !mUserFlag;
            mFButtons[i][j].setTouched(true);
            // Sets mIsBelowFull field of above buttons true.
            if (i != 0)
                mFButtons[i - 1][j].setBelowFull(true);
        }
        else
            Toast.makeText(getActivity(), "You can't select this", Toast.LENGTH_SHORT).show();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void checkStates(View view, int i, int j) {

        // Compares color of button with three other buttons in the same column and other rows.
        for (int k = i - 3; k <= i + 3; k++) {
            if (k >= 0 && k + 3 <= 4) {
                if (( mFButtons[k][j].getColor() == Color.BLUE
                    && mFButtons[k + 1][j].getColor() == Color.BLUE
                    && mFButtons[k + 2][j].getColor() == Color.BLUE
                    && mFButtons[k + 3][j].getColor() == Color.BLUE)
                    ||
                    (mFButtons[k][j].getColor() == Color.RED
                    && mFButtons[k + 1][j].getColor() == Color.RED
                    && mFButtons[k + 2][j].getColor() == Color.RED
                    && mFButtons[k + 3][j].getColor() == Color.RED)) {
                        showSnackbar(view);
                        reset();
                        return;
                }
            }

        }

        // Compares color of button with three other buttons in the same row and other columns.
        for (int k = j - 3; k <= j + 3; k++) {
            if (k >= 0 && k + 3 <= 4) {
                if ((mFButtons[i][k].getColor() == Color.BLUE
                    && mFButtons[i][k + 1].getColor() == Color.BLUE
                    && mFButtons[i][k + 2].getColor() == Color.BLUE
                    && mFButtons[i][k + 3].getColor() == Color.BLUE)
                    ||
                    (mFButtons[i][k].getColor() == Color.RED
                    && mFButtons[i][k + 1].getColor() == Color.RED
                    && mFButtons[i][k + 2].getColor() == Color.RED
                    && mFButtons[i][k + 3].getColor() == Color.RED)) {
                        showSnackbar(view);
                        reset();
                        return;
                }
            }

        }

        // Compares color of button with three other buttons in position of multiply and in ascending order.
        for (int k = i - 3; k <= i + 3; k++)
            for (int l = j - 3; l <= j + 3; l++)
                if (k >= 0 && k + 3 <= 4 && l >= 0 && l + 3 <= 4) {
                    if ((mFButtons[k][l].getColor() == Color.BLUE
                        && mFButtons[k + 1][l + 1].getColor() == Color.BLUE
                        && mFButtons[k + 2][l + 2].getColor() == Color.BLUE
                        && mFButtons[k + 3][l + 3].getColor() == Color.BLUE)
                        ||
                        (mFButtons[k][l].getColor() == Color.RED
                        && mFButtons[k + 1][l + 1].getColor() == Color.RED
                        && mFButtons[k + 2][l + 2].getColor() == Color.RED
                        && mFButtons[k + 3][l + 3].getColor() == Color.RED)) {
                            showSnackbar(view);
                            reset();
                            return;
                    }
            }

        // Compares color of button with three other buttons in position of multiply and in descending order.
        for (int k = i + 3; k >= i - 3; k--)
            for (int l = j - 3; l <= j + 3; l++)
                if (k - 3 >= 0 && k <= 4 && l >= 0 && l + 3 <= 4) {
                    if ((mFButtons[k][l].getColor() == Color.BLUE
                        && mFButtons[k - 1][l + 1].getColor() == Color.BLUE
                        && mFButtons[k - 2][l + 2].getColor() == Color.BLUE
                        && mFButtons[k - 3][l + 3].getColor() == Color.BLUE)
                        || (mFButtons[k][l].getColor() == Color.RED
                        && mFButtons[k - 1][l + 1].getColor() == Color.RED
                        && mFButtons[k - 2][l + 2].getColor() == Color.RED
                        && mFButtons[k - 3][l + 3].getColor() == Color.RED)) {
                            showSnackbar(view);
                            reset();
                            return;
                    }
                }
    }

    private void showSnackbar(View view) {
        String winner = "";
        // Flag changes after each click in changeContent method.
        if (mUserFlag)
            winner = "Winner is Blue";
        else winner = "Winner is Red";

        Snackbar.make(view, winner, Snackbar.LENGTH_LONG).show();
    }

    // Resets all attributes for restart.
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void reset() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++) {
                mUserFlag = false;
                mButtons[i][j].setBackgroundTintList(ColorStateList.valueOf(Color.LTGRAY));
                mFButtons[i][j].setTouched(false);
                mFButtons[i][j].setBelowFull(false);
                mFButtons[i][j].setColor(0);
            }
    }

    // Copies color of buttons from objects to array.
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void saveButtonsStates() {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                mButtons[i][j].setBackgroundTintList(ColorStateList.valueOf(mFButtons[i][j].getColor()));
    }
}