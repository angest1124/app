package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity4 extends AppCompatActivity {


    private TextView txt2;
    private Button btnBack2;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txt2 = findViewById(R.id.txt2);
        btnBack2 = findViewById(R.id.btnBack2);

        btnBack2.setOnClickListener(btnListener);

        readFile();
    }
    String line = "", wholedata = "", wholedata2 = "", wholedata3 = "", wholedata4 = "", wholedata5 = "";
    private void readFile() {
        File filename = new File("sdcard/datss.txt");
        File filename2 = new File("sdcard/datss2.txt");
        File filename3 = new File("sdcard/datss3.txt");
        File filename4 = new File("sdcard/datss4.txt");
        File filename5 = new File("sdcard/datss5.txt");
        try {
            FileInputStream fin = new FileInputStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            //String line = "", wholedata = "";
            int i = 1;
            FileInputStream fin2 = new FileInputStream(filename2);
            BufferedReader reader2 = new BufferedReader(new InputStreamReader(fin2));
            String line2 = "";

            FileInputStream fin3 = new FileInputStream(filename3);
            BufferedReader reader3 = new BufferedReader(new InputStreamReader(fin3));
            String line3 = "";

            FileInputStream fin4 = new FileInputStream(filename4);
            BufferedReader reader4 = new BufferedReader(new InputStreamReader(fin4));
            String line4 = "";

            FileInputStream fin5 = new FileInputStream(filename5);
            BufferedReader reader5= new BufferedReader(new InputStreamReader(fin5));
            String line5 = "";

           /* //int i = 1;
            while (( line3 = reader3.readLine() )!= null) {
                wholedata3 = "3." + line3 + "\n";


            }

            //int i = 1;
            while (( line2 = reader2.readLine() )!= null) {
                //+ "第" + String.valueOf(i) + "次:"

                wholedata2 ="2.訂房類型" + line2 +"\n";
                //i++;
            }*/

            //+ "第" + String.valueOf(i) + "次:"
            while ((( line = reader.readLine() )!= null) && (( line2 = reader2.readLine() )!= null) && (( line3 = reader3.readLine() )!= null) && (( line4 = reader4.readLine() )!= null) && (( line5 = reader5.readLine() )!= null)) {
                //wholedata3 = "3." + line3 + "\n";
                //wholedata2 ="2.訂房類型" + line2 +"\n";
                wholedata =  wholedata  +wholedata2+wholedata3+wholedata4+wholedata5+ "第" + String.valueOf(i) + "次:"+"\n"+"1.訂房日期:" +   line + "\n"+"2.訂房類型" + line2 +"\n"+"3." + line3 + "\n"+"4." + line4 +"\n"+ "5." +"預計抵達時間:"+line5 +"\n";
                i++;
            }





            //txt2.setText(  "所有訂房資料:"+"\n" +wholedata  +wholedata2);
            reader2.close();
            fin2.close();
            reader.close();
            fin.close();

            txt2.setText(  "所有訂房資料:"+"\n" +wholedata  );
            reader3.close();
            fin3.close();



        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Button.OnClickListener btnListener = new
            Button.OnClickListener() {


                /**
                 * Called when a view has been clicked.
                 *
                 * @param v The view that was clicked.
                 */
                @Override
                public void onClick(View v) {
                    if(v.getId() == R.id.btnBack2){
                        finish();
                    }
                }
            };
}