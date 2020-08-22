package com.example.hw9.controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.hw9.model.TicTacToeButton;
import com.google.android.material.snackbar.Snackbar;

import com.example.hw9.R;

import java.io.Serializable;

public class TicTacToeFragment extends Fragment implements Serializable {
    private Button[][] mButtons = new Button[3][3];
    private TicTacToeButton[][] mTButtons = new TicTacToeButton[3][3];
    private boolean mUserFlag;

    private static final String BUNDLE_KEY_BUTTONS_STATE = "buttons_state";
    private static final String BUNDLE_KEY_USER_FLAG = "user_flag";

    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                mTButtons[i][j] = new TicTacToeButton();
    }

    public TicTacToeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe, container, false);

        findViews(view);
        setListeners(view);

        if (savedInstanceState != null) {
            mUserFlag = savedInstanceState.getBoolean(BUNDLE_KEY_USER_FLAG);
            mTButtons = (TicTacToeButton[][]) savedInstanceState.getSerializable(BUNDLE_KEY_BUTTONS_STATE);
            setButtonsState();
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(BUNDLE_KEY_BUTTONS_STATE, (Serializable)mTButtons);
        outState.putBoolean(BUNDLE_KEY_USER_FLAG, mUserFlag);
    }

    private void findViews(View view) {
        mButtons[0][0] = view.findViewById(R.id.button);
        mButtons[0][1] = view.findViewById(R.id.button2);
        mButtons[0][2] = view.findViewById(R.id.button3);
        mButtons[1][0] = view.findViewById(R.id.button4);
        mButtons[1][1] = view.findViewById(R.id.button5);
        mButtons[1][2] = view.findViewById(R.id.button6);
        mButtons[2][0] = view.findViewById(R.id.button7);
        mButtons[2][1] = view.findViewById(R.id.button8);
        mButtons[2][2] = view.findViewById(R.id.button9);
    }

    private void setListeners(final View view) {
        mButtons[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(0, 0);
                checkStates(view, 0, 0);
            }
        });

        mButtons[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(0, 1);
                checkStates(view, 0, 1);
            }
        });

        mButtons[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(0, 2);
                checkStates(view, 0, 2);
            }
        });

        mButtons[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(1, 0);
                checkStates(view, 1, 0);
            }
        });

        mButtons[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(1, 1);
                checkStates(view, 1, 1);
            }
        });

        mButtons[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(1, 2);
                checkStates(view, 1, 2);
            }
        });

        mButtons[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(2, 0);
                checkStates(view, 2, 0);
            }
        });

        mButtons[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(2, 1);
                checkStates(view, 2, 1);
            }
        });

        mButtons[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeContent(2, 2);
                checkStates(view, 2, 2);
            }
        });
    }

    private void changeContent(int i, int j) {
        // If button not been touched, sets character 'x' or 'o' on it, depends on user flag.
        if (!mTButtons[i][j].isTouched()) {
            if (!mUserFlag) {
                mTButtons[i][j].setCharacter("X");
                mButtons[i][j].setText("X");
            }
            else {
                mTButtons[i][j].setCharacter("O");
                mButtons[i][j].setText("O");
            }

            // Sets mIsTouched flag of the button true.
            mTButtons[i][j].setTouched(true);
            // Changes user's flag after each successful touch
            mUserFlag = !mUserFlag;
        }
        // If button is touched, it just shows a toast.
        else
            Toast.makeText(getActivity(), "You can't select this", Toast.LENGTH_SHORT).show();

    }

    // Compares button's content in index of i,j with appropriate buttons.
    private void checkStates(View view, int i, int j) {
        String string1 = (String) mButtons[i][j].getText();
        String string2 = "", string3 = "";

        // Compares button with side buttons in other rows.
        switch (i) {
            case 0:
                string2 = (String) mButtons[i + 1][j].getText();
                string3 = (String) mButtons[i + 2][j].getText();

                break;
            case 1:
                string2 = (String) mButtons[i - 1][j].getText();
                string3 = (String) mButtons[i + 1][j].getText();
                break;
            case 2:
                string2 = (String) mButtons[i - 1][j].getText();
                string3 = (String) mButtons[i - 2][j].getText();
                break;
        }

        // If three buttons have same content, shows the winner and resets the game.
        if (compareStrings(view, string1, string2, string3)) return;

        // Compares button with side buttons in other columns.
        switch (j) {
            case 0:
                string2 = (String) mButtons[i][j + 1].getText();
                string3 = (String) mButtons[i][j + 2].getText();
                break;
            case 1:
                string2 = (String) mButtons[i][j - 1].getText();
                string3 = (String) mButtons[i][j + 1].getText();
                break;
            case 2:
                string2 = (String) mButtons[i][j - 1].getText();
                string3 = (String) mButtons[i][j - 2].getText();
                break;
        }

        if (compareStrings(view, string1, string2, string3)) return;

        // Compares button with buttons in position of multiply.
        switch (i) {
            case 0:
                switch (j) {
                    case 0:
                        string2 = (String) mButtons[i + 1][j + 1].getText();
                        string3 = (String) mButtons[i + 2][j + 2].getText();
                        break;
                    case 2:
                        string2 = (String) mButtons[i + 1][j - 1].getText();
                        string3 = (String) mButtons[i + 2][j - 2].getText();
                        break;
                }
                break;
            case 1:
                switch (j) {
                    case 1:
                        string2 = (String) mButtons[i - 1][j - 1].getText();
                        string3 = (String) mButtons[i + 1][j + 1].getText();
                        if (compareStrings(view, string1, string2, string3)) return;
                        string2 = (String) mButtons[i - 1][j + 1].getText();
                        string3 = (String) mButtons[i + 1][j - 1].getText();
                        break;
                }
                break;
            case 2:
                switch (j) {
                    case 0:
                        string2 = (String) mButtons[i - 1][j + 1].getText();
                        string3 = (String) mButtons[i - 2][j + 2].getText();
                        break;
                    case 2:
                        string2 = (String) mButtons[i - 1][j - 1].getText();
                        string3 = (String) mButtons[i - 2][j - 2].getText();
                        break;
                }
                break;
        }

        compareStrings(view, string1, string2, string3);
    }

    private boolean compareStrings(View view, String string1, String string2, String string3) {
        if (string1.contentEquals(string2)
                && string1.contentEquals(string3)) {
            showSnackbar(view);
            resetButtons();
            return true;
        }
        return false;
    }

    private void showSnackbar(View view) {
        String winner = "";
        // Flag changes after each click in changeContent method.
        if (mUserFlag)
            winner = "Winner is X";
        else winner = "Winner is O";

        Snackbar.make(view, winner, Snackbar.LENGTH_LONG).show();
    }

    // Copies buttons content from objects to array.
    private void setButtonsState() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j <3 ; j++)
                mButtons[i][j].setText(mTButtons[i][j].getCharacter());
    }

    // Resets all attributes to restart.
    private void resetButtons() {
        mUserFlag = false;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                mButtons[i][j].setText("");
                mTButtons[i][j].setTouched(false);
                mTButtons[i][j].setCharacter("");
            }
    }
}