package com.example.canyourunalap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.start);
        EditText nameL = findViewById(R.id.name);
        start.setOnClickListener(v -> {
            if (!(nameL.getText().toString().equals(""))) {
                String name = nameL.getText().toString();
                Intent intent = new Intent(this, GameActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);
            }
        });
    }
}
