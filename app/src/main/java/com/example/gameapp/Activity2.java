package com.example.gameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView player1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new wRunner(this));

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.TAG);

        //TextView textView2 = findViewById(R.id.textView2);
        //textView2.setText(message);

        player1 = (TextView) findViewById(R.id.player1);
    }
}