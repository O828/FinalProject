package com.example.canyourunalap;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.fonts.Font;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.canyourunalap.MainActivity;
import com.example.canyourunalap.R;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private TextView label1;

    private TextView label2;

    private TextView label3;

    private TextView label4;

    private TextView label5;

    private TextView label6;

    private TextView label7;

    private TextView label8;

    private TextView label9;

    private TextView label10;

    private TextView label11;

    private TextView label12;

    private TextView label13;

    private TextView label14;

    private TextView label15;

    private TextView label16;

    private TextView label17;

    private TextView label18;

    private TextView youGet;

    private TextView point;

    private TextView[] labels;

    private Button roll;

    private Integer startPoint = 10;

    private Integer laps = 0;

    private TextView lap;

    private String name;






    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        MediaPlayer mMediaPlayer=MediaPlayer.create(GameActivity.this,R.raw.backgroundmusic);
        mMediaPlayer.start();
        name = getIntent().getStringExtra("name");
        label1 = findViewById(R.id.one);
        label2 = findViewById(R.id.two);
        label3 = findViewById(R.id.three);
        label4 = findViewById(R.id.four);
        label5 = findViewById(R.id.five);
        label6 = findViewById(R.id.six);
        label7 = findViewById(R.id.seven);
        label8 = findViewById(R.id.eight);
        label9 = findViewById(R.id.nine);
        label10 = findViewById(R.id.ten);
        label11 = findViewById(R.id.eleven);
        label12 = findViewById(R.id.twelve);
        label13 = findViewById(R.id.thirteen);
        label14 = findViewById(R.id.fourteen);
        label15 = findViewById(R.id.fifteen);
        label16 = findViewById(R.id.sixteen);
        label17 = findViewById(R.id.seventeen);
        label18 = findViewById(R.id.eighteen);
        youGet = findViewById(R.id.get);
        roll = findViewById(R.id.roll);
        point = findViewById(R.id.point);
        lap = findViewById(R.id.lap);

        roll.setOnClickListener(v -> rollClicked());

        label1.setBackgroundColor(Color.GRAY);
        label2.setBackgroundColor(Color.GRAY);
        label3.setBackgroundColor(Color.GRAY);
        label4.setBackgroundColor(Color.GRAY);
        label5.setBackgroundColor(Color.GRAY);
        label6.setBackgroundColor(Color.GRAY);
        label7.setBackgroundColor(Color.GRAY);
        label8.setBackgroundColor(Color.GRAY);
        label9.setBackgroundColor(Color.GRAY);
        label10.setBackgroundColor(Color.GRAY);
        label11.setBackgroundColor(Color.GRAY);
        label12.setBackgroundColor(Color.GRAY);
        label13.setBackgroundColor(Color.GRAY);
        label14.setBackgroundColor(Color.GRAY);
        label15.setBackgroundColor(Color.GRAY);
        label16.setBackgroundColor(Color.GRAY);
        label17.setBackgroundColor(Color.GRAY);
        label18.setBackgroundColor(Color.GRAY);

        label1.setTextColor(Color.GREEN);

         TextView[] Lala = {label1, label2, label3, label4, label5, label6,
                label7, label8, label9, label10, label11, label12, label13,
                label14, label15, label16, label17, label18};
         labels = Lala;
    }

    public void rollClicked() {
        if (startPoint <= 0) {
            youGet.setText(" Game End");
            roll.setText(" Show my ranking");
            Intent intent = new Intent(this, Ranking.class);
            Storage.add(name, laps);
            roll.setOnClickListener(v -> startActivity(intent));
        } else {
            Random r = new Random();
            Integer roll = 1 + r.nextInt(6);
            youGet.setText(" You get: " + roll.toString() + " steps");
            int greenText = 0;
            for (int n = 0; n < labels.length; n++) {
                if (labels[n].getTextColors().getDefaultColor() == Color.GREEN) {
                    greenText = n;
                }
            }
            Integer nextStep = (roll + greenText);
            if (nextStep > 17) {
                laps += 1;
                lap.setText(" You have run " + laps.toString() +" laps.");
                nextStep = nextStep % 17 - 1;
            }
            getPoint(nextStep);
            bulingbuling(greenText, nextStep);
        }
    }
    public void bulingbuling(int start, int end) {
        labels[start].setTextColor(Color.BLACK);
        labels[end].setTextColor(Color.GREEN);
    }
    public void getPoint(int position) {
        if (labels[position].getText().toString().equals("Start/End")) {
            return;
        }
        Integer points =  Integer.valueOf(labels[position].getText().toString().trim());
        startPoint += points;
        point.setText(" Your point left: " + startPoint.toString());
    }
}
