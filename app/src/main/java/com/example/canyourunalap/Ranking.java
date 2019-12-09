package com.example.canyourunalap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Ranking extends AppCompatActivity {

    private String name;

    private Integer laps;

    private Button again;

    private LinearLayout ranking;



    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking);
        again = findViewById(R.id.again);
        ranking = findViewById(R.id.ranking);
        again.setOnClickListener(v -> startActivity(new Intent(this, MainActivity.class)));
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, String> a : Storage.players.entrySet()){
            list.add(a.getKey());
        }
        if (list.size() == 1) {
            View chunk = getLayoutInflater().inflate(R.layout.chunk_ranking, ranking, false);
            TextView nameR = chunk.findViewById(R.id.nameR);
            TextView lapR = chunk.findViewById(R.id.lapR);
            Button remove = chunk.findViewById(R.id.remove);
            laps = list.get(0);
            name = Storage.players.get(laps);
            nameR.setText("Name: " + name);
            lapR.setText("Have run " + laps.toString() + " laps.");
            remove.setOnClickListener(v -> {
                ranking.removeView(chunk);
                Storage.remove(laps);
            });
            ranking.addView(chunk);
        } else {
            for (int n = 1; n < list.size(); n++) {
                for (int m = n; m >= 1; m--) {
                    if (list.get(m) > list.get(m - 1)) {
                        Integer swap = list.get(m);
                        list.set(m, list.get(m - 1));
                        list.set(m - 1, swap);
                    }
                }
            }
            for (Integer a : list) {
                View chunk = getLayoutInflater().inflate(R.layout.chunk_ranking, ranking, false);
                TextView nameR = chunk.findViewById(R.id.nameR);
                TextView lapR = chunk.findViewById(R.id.lapR);
                Button remove = chunk.findViewById(R.id.remove);
                laps = a;
                name = Storage.players.get(laps);
                nameR.setText("Name: " + name);
                lapR.setText("Have run " + laps.toString() + " laps.");
                remove.setOnClickListener(v -> {
                    ranking.removeView(chunk);
                    Storage.remove(laps);
                });
                ranking.addView(chunk);
            }
        }
    }

}
