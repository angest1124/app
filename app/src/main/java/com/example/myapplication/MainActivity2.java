package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity2 extends AppCompatActivity {

    private Button btnGame,btnDate,btnll,END;
    private File filename = new File(Environment.getExternalStorageDirectory(), "datss.txt");
    private File filename2 = new File(Environment.getExternalStorageDirectory(), "datss2.txt");
    private File filename3 = new File(Environment.getExternalStorageDirectory(), "datss3.txt");
    private File filename4 = new File(Environment.getExternalStorageDirectory(), "datss4.txt");
    private File filename5 = new File(Environment.getExternalStorageDirectory(), "datss5.txt");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        END = findViewById(R.id.END);
        btnGame = findViewById(R.id.btnGame);
        btnDate = findViewById(R.id.btnDate);
        btnll = findViewById(R.id.btnll);

        btnGame.setOnClickListener(btnListener);
        btnDate.setOnClickListener(btnListener);
        btnll.setOnClickListener(btnListener);
        END.setOnClickListener(btnListener);
    }
    private Button.OnClickListener btnListener = new
            Button.OnClickListener(){


                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.btnGame) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity2.this, MainActivity3.class);
                        startActivity(intent);
                    } else if (v.getId() == R.id.btnDate) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity2.this, MainActivity4.class);
                        startActivity(intent);
                    } else if (v.getId() == R.id.btnll) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity2.this, MainActivity6.class);
                        startActivity(intent);
                    }

                    else if (v.getId() == R.id.END) {
                        new AlertDialog.Builder(MainActivity2.this)
                                .setTitle("刪除資料")
                                .setMessage("確定要刪除所有資料嗎？")
                                .setPositiveButton("是", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        //Intent intent = new Intent();
                                       // intent.setClass(MainActivity2.this, MainActivity.class);
                                       // startActivity(intent);

                                        deleteDatabase("friends.db");
                                        filename = new File(Environment.getExternalStorageDirectory(), "datss.txt");
                                        filename2 = new File(Environment.getExternalStorageDirectory(), "datss2.txt");
                                        filename3 = new File(Environment.getExternalStorageDirectory(), "datss3.txt");
                                        filename4 = new File(Environment.getExternalStorageDirectory(), "datss4.txt");
                                        filename5 = new File(Environment.getExternalStorageDirectory(), "datss5.txt");
                                        filename.delete();
                                        filename2.delete();
                                        filename3.delete();
                                        filename4.delete();
                                        filename5.delete();
                                    }
                                })
                                .setNegativeButton("否", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();
                    }
                }
            };
}
