package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity10 extends AppCompatActivity {
    private Button bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);bt3 = findViewById(R.id.bt3);
        bt3.setOnClickListener(btnListener);
    }private Button.OnClickListener btnListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.bt3) {
                        finish();
                    }
                }
            };
}