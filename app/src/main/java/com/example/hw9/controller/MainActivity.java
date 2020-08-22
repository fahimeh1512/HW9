package com.example.hw9.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hw9.R;

public class MainActivity extends AppCompatActivity {
    private Button mTicTacToe;
    private Button mFourInARow;
    private FragmentManager mFragmentManager;
    private TicTacToeFragment mTicTacToeFragment;
    private FourInARowFragment mFourInARowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragmentManager = getSupportFragmentManager();
        Fragment fragment = mFragmentManager.findFragmentById(R.id.fragment_container);

        // Shows TicTacToe game by default.
        if (fragment == null) {
            mTicTacToeFragment = new TicTacToeFragment();
            mFragmentManager.beginTransaction().add(R.id.fragment_container, mTicTacToeFragment).commit();
        }

        findViews();
        setListeners();
    }

    private void findViews() {
        mTicTacToe = findViewById(R.id.tic_tac_toe);
        mFourInARow = findViewById(R.id.four_in_a_row);
    }

    private void setListeners() {
        mTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTicTacToeFragment = new TicTacToeFragment();
                mFragmentManager.beginTransaction().replace(R.id.fragment_container, mTicTacToeFragment).commit();
            }
        });

        mFourInARow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFourInARowFragment = new FourInARowFragment();
                mFragmentManager.beginTransaction().replace(R.id.fragment_container, mFourInARowFragment).commit();
            }
        });
    }

}