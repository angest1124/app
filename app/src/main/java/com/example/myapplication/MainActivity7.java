package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity7 extends AppCompatActivity {
    private Button bt22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        bt22 = findViewById(R.id.bt22);
        bt22.setOnClickListener(btnListener);
    }

    private Button.OnClickListener btnListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.bt22) {
                        finish();
                    }
                }
            };
}