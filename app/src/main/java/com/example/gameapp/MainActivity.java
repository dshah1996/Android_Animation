package com.example.gameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    Button exitbtn;
    public static final String TAG = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MediaPlayer soundPlayer = MediaPlayer.create(this, R.raw.sound);
        //soundPlayer.setVolume(1,1);
        exitbtn = (Button)findViewById(R.id.button2);
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openActivity2();
                soundPlayer.start();

            }
        });
    }
        public void openActivity2(){
            Intent intent = new Intent(this, Activity2.class);
            EditText player1 = findViewById(R.id.player1);
            String players = " Welcome" +player1.getText().toString();
            intent.putExtra(TAG,players);
            startActivity(intent);
        }



}