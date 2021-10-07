package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity8 extends AppCompatActivity {
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(btnListener);
    }
    private Button.OnClickListener btnListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.bt) {
                        finish();
                    }
                }
            };
}