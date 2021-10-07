package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.renderscript.ScriptGroup;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private EditText edtId, edtPw;
    private Button btnOK, btnLogin;
    private String[] login2;
    private File filename;
    private File filename2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnOK = findViewById(R.id.btnOK);
        btnLogin = findViewById(R.id.btnLogin);

        btnOK.setOnClickListener(btnListener);
        btnLogin.setOnClickListener(btnListener);

        //requestStoragePermission();

    }

    /*private void requestStoragePermission() {
        if (Build.VERSION.SDK_INT >= 23) {
            int hasPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                return;
            }
        }
        readFile();
    }



    private void readFile() {
        filename = new File("sdcard/login2.txt");
        try {
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            String line = "",wholedate = "";
            int i = 0;

            while ((line = reader.readLine()) != null) {
                wholedate = wholedate + line + "\n";
                i++;
            }
            login2 = wholedate.split("\n");
            reader.close();
            fin.close();
        } catch (Exception e) {
            
            Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                   if(requestCode == 1){
                              if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                                  readFile();
                              }
                              else{
                                  Toast.makeText(this , "未取得授權!",Toast.LENGTH_SHORT).show();
                                  finish();
                              }
                          }

                   else {
                       super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                   }
         }
*/
    private final Button.OnClickListener btnListener = new
            Button.OnClickListener() {


                @Override
                public void onClick(View v) {
                    //switch (v.getId()) {
                        //case R.id.btnLogin:
                            if (v.getId() == R.id.btnOK) {
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, MainActivity2.class);
                                startActivity(intent);

                            }
                            if (v.getId() == R.id.btnLogin) {
                                finish();
                            //Boolean flag = false;
                            /*for (int i = 0; i < login2.length; i += 2) {
                                if (edtId.getText().toString().equals(login2[i])) {
                                    flag = true;
                                }
                            }*/
                            /*if (edtId.getText().toString().equals("") ||
                                    edtPw.getText().toString().equals("")) {
                                Toast.makeText(getApplicationContext(), "需輸入帳號及密碼", Toast.LENGTH_SHORT).show();
                                break;
                            } else if (flag == false) {
                                Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "帳號已註冊", Toast.LENGTH_SHORT).show();
                                edtId.setText("");
                                edtPw.setText("");
                                break;
                            }
                            filename = new File(Environment.getExternalStorageDirectory(), "login2.txt");
                            FileOutputStream fout = null;
                            BufferedOutputStream buffout = null;
                            try {
                                fout = new FileOutputStream(filename, true);
                                buffout = new BufferedOutputStream(fout);

                                buffout.write(edtId.getText().toString().getBytes());
                                buffout.write("\n".getBytes());
                                buffout.write(edtPw.getText().toString().getBytes());
                                buffout.write("\n".getBytes());
                                buffout.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            edtId.setText("");
                            edtPw.setText("");
                            readFile();          //(要讀檔才會寫入)
                            break;

                        case R.id.btnOK:
                            if (edtId.getText().toString().equals("") ||
                                    edtPw.getText().toString().equals("")) {
                                Toast.makeText(getApplicationContext(), "需輸入帳號及密碼", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            flag = false;
                            for (int i = 0; i < login2.length; i += 2) {
                                if (edtId.getText().toString().equals(login2[i])) {
                                    flag = true;
                                    if (edtPw.getText().toString().equals(login2[i + 1])) {
                                        new AlertDialog.Builder(MainActivity.this)
                                                .setTitle("登入")
                                                .setMessage("登入成功!\n歡迎使用本程式!")
                                                .setPositiveButton("確定", new DialogInterface.OnClickListener() {


                                                    @Override
                                                    public void onClick(DialogInterface dialog, int which) {
                                                        Intent intent = new Intent();
                                                        intent.setClass(MainActivity.this, MainActivity2.class);
                                                        startActivity(intent);

                                                    }
                                                })
                                                .show();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "密碼不正確!", Toast.LENGTH_SHORT).show();
                                        edtPw.setText("");
                                        break;
                                    }
                                }
                            }
                            if (!flag) {
                                Toast.makeText(getApplicationContext(), "帳號不正確!", Toast.LENGTH_SHORT).show();
                                edtId.setText("");
                                edtPw.setText("");
                            }
                            break;*/
                    }
                }
            };
}