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

public class MainActivity6 extends AppCompatActivity {
    private Button ls,ls2,ls3,ls4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        ls = findViewById(R.id.ls);
        ls.setOnClickListener(btnListener);
        ls2 = findViewById(R.id.ls2);
        ls2.setOnClickListener(btnListener);
        ls3 = findViewById(R.id.ls3);
        ls3.setOnClickListener(btnListener);
        ls4 = findViewById(R.id.ls4);
        ls4.setOnClickListener(btnListener);

    }

    private Button.OnClickListener btnListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (v.getId() == R.id.ls) {
                        Intent intent = new Intent();
                         intent.setClass(MainActivity6.this, MainActivity7.class);
                        startActivity(intent);


                        /*new AlertDialog.Builder(MainActivity6.this)
                                .setTitle("房型介紹")
                                .setMessage("代號：A\n" +
                                        "房型：單人房\n" +
                                        "價格：699\n" +
                                        "客房設備：\n" +
                                        "盥洗用具,吹風機,冷氣,暖氣\n" +
                                        "\n"
                                        )
                                .setPositiveButton("離開", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setClass(MainActivity6.this, MainActivity2.class);
                                        startActivity(intent);

                                    }
                                })
                                .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();*/
                    }
                    else if (v.getId() == R.id.ls2) {Intent intent = new Intent();
                        intent.setClass(MainActivity6.this, MainActivity8.class);
                        startActivity(intent);
                       /* new AlertDialog.Builder(MainActivity6.this)
                                .setTitle("房型介紹")
                                .setMessage("代號：B\n" +
                                        "房型：雙人房\n" +
                                        "價格：1799\n" +
                                        "客房設備：\n" +
                                        "盥洗用具,吹風機,電視,冷氣,暖氣,無線網路,觀景窗"
                                )
                                .setPositiveButton("離開", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setClass(MainActivity6.this, MainActivity2.class);
                                        startActivity(intent);

                                    }
                                })
                                .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();*/
                    }
                    else if (v.getId() == R.id.ls3) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity6.this, MainActivity9.class);
                        startActivity(intent);
                        /*new AlertDialog.Builder(MainActivity6.this)
                                .setTitle("房型介紹")
                                .setMessage("代號：C\n" +
                                        "房型：四人房\n" +
                                        "價格：2659\n" +
                                        "客房設備：\n" +
                                        "盥洗用具、吹風機、電視、冷氣、暖氣、無線網路、\n" +
                                        "觀景窗、觀景陽台、浴缸、面山"
                                )
                                .setPositiveButton("離開", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setClass(MainActivity6.this, MainActivity2.class);
                                        startActivity(intent);

                                    }
                                })
                                .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();*/
                    }
                    else if (v.getId() == R.id.ls4) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity6.this, MainActivity10.class);
                        startActivity(intent);
                        /*new AlertDialog.Builder(MainActivity6.this)
                                .setTitle("房型介紹")
                                .setMessage("代號：D\n" +
                                        "房型：豪華家庭房(4~5人)\n" +
                                        "價格：5300\n" +
                                        "1.衛浴設備：分離式淋浴、吹風機、盥洗用品\n" +
                                        "2.娛樂： Wi-Fi、液晶電視、有線頻道\n" +
                                        "3.舒適設備： Morning call、空調、室內拖鞋\n" +
                                        "4.餐飲服務：冰箱、即溶咖啡、茶包、瓶裝水、快煮壺\n" +
                                        "5.衣物與洗衣設備：開放式衣櫃、衣架\n" +
                                        "6.安全特色：晶片式安全感應門鎖\n" +
                                        "7.每房最多入住4人\n"
                                )
                                .setPositiveButton("離開", new DialogInterface.OnClickListener() {

                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Intent intent = new Intent();
                                        intent.setClass(MainActivity6.this, MainActivity2.class);
                                        startActivity(intent);

                                    }
                                })
                                .setNegativeButton("返回", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                })
                                .show();*/
                    }

                }
            } ;
}
