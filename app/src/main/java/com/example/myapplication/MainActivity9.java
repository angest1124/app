package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity9 extends AppCompatActivity {
    private Button bt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        bt2 = findViewById(R.id.bt2);
        bt2.setOnClickListener(btnListener);
    }private Button.OnClickListener btnListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.bt2) {
                        finish();
                    }
                }
            };
}