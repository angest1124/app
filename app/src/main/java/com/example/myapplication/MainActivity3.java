package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity3<friendDb> extends AppCompatActivity {
    private static final String DB_FILE = "friends.db",
            DB_TABLE = "friends";
    private FriendActivity mFriendDbOpenHelper;

    private TextView txt1, txt2, txt3, txt4, txt5, txtList,ll,name1;
    private Button btnAdd, btnQuery, btnList, delete1;
    private String[] login2;
    private File filename = new File(Environment.getExternalStorageDirectory(), "datss.txt");    //將資料寫入檔案
    private File filename2 = new File(Environment.getExternalStorageDirectory(), "datss2.txt");
    private File filename3 = new File(Environment.getExternalStorageDirectory(), "datss3.txt");
    private File filename4 = new File(Environment.getExternalStorageDirectory(), "datss4.txt");
    private File filename5 = new File(Environment.getExternalStorageDirectory(), "datss5.txt");
    private EditText time1, ked,tyu,name2;
    private CheckBox CB31, CB32, CB41, CB42, CB51, CB52, CB53;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mFriendDbOpenHelper = new FriendActivity(getApplicationContext(), DB_FILE,
                null, 1);
        SQLiteDatabase friendDb = mFriendDbOpenHelper.getWritableDatabase();
        Cursor cursor = friendDb.rawQuery("select DISTINCT tbl_name from sqlite_master where " +
                "tbl_name = '" + DB_TABLE + "'", null);
        if (cursor != null) {
            if (cursor.getCount() == 0)
                friendDb.execSQL("CREATE TABLE " + DB_TABLE + " (" +
                        "_id INTEGER PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "phone TEXT," +
                        "sex TEXT," +
                        "address TEXT);");
            cursor.close();

        }

        friendDb.close();

        CB31 = (CheckBox)findViewById(R.id.CB31);
        CB32 = (CheckBox)findViewById(R.id.CB32);
        CB41 = (CheckBox)findViewById(R.id.CB41);
        CB42 = (CheckBox)findViewById(R.id.CB42);
        CB51 = (CheckBox)findViewById(R.id.CB51);
        CB52 = (CheckBox)findViewById(R.id.CB52);
        CB53 = (CheckBox)findViewById(R.id.CB53);

        txtList = findViewById(R.id.txtList);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5 = findViewById(R.id.txt5);
        btnAdd = findViewById(R.id.btnAdd);
        btnQuery = findViewById(R.id.btnQuery);
        btnList = findViewById(R.id.btnList);
        time1 = findViewById(R.id.time1);
        ked = findViewById(R.id.ked);
        tyu = findViewById(R.id.tyu);
        name2 = findViewById(R.id.name2);

        btnAdd.setOnClickListener(btnAddListener);
        btnQuery.setOnClickListener(btnQueryListener);
        btnList.setOnClickListener(btnListListener);
        CB31.setOnCheckedChangeListener(checkBoxOnCheckedChange);
        CB32.setOnCheckedChangeListener(checkBoxOnCheckedChange1);
        CB41.setOnCheckedChangeListener(checkBoxOnCheckedChange2);
        CB42.setOnCheckedChangeListener(checkBoxOnCheckedChange3);
        CB51.setOnCheckedChangeListener(checkBoxOnCheckedChange4);
        CB52.setOnCheckedChangeListener(checkBoxOnCheckedChange5);
        CB53.setOnCheckedChangeListener(checkBoxOnCheckedChange6);
        //delete1 = findViewById(R.id.delete1);
        //delete1.setOnClickListener(btndelete1Listener);




        /*btnBack1.setOnClickListener(btnListener1);*/

        requestStoragePermission();
    }
    //String s=String.valueOf(time1);
    //String t=String.valueOf(ked);
    //String time2=String.valueOf(time1);
    //String ked2=String.valueOf(ked);
    String CB1,CB2,CB3,CB4,CB5,CB6,CB7;
    private CheckBox.OnCheckedChangeListener checkBoxOnCheckedChange =
            new CheckBox.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CB32.setChecked(false);
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        CB1 = "需要早餐";
                        //CB2 = "不需要早餐";


                    } else {
                        //                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        //                        //CB1="";
                        CB1 = "不需要早餐";
                    }

                }
            };
    private CheckBox.OnCheckedChangeListener checkBoxOnCheckedChange1 =
            new CheckBox.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CB31.setChecked(false);
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        CB1 = "不需要早餐";




                    } else {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        //CB2 = "";
                        CB1 = "需要早餐";
                    }

                }

            };
    private CheckBox.OnCheckedChangeListener checkBoxOnCheckedChange2 =
            new CheckBox.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CB42.setChecked(false);
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        CB3 = "需要加床";

                       /* */

                    } else {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        //CB3 = "";
                        CB3 = "不需要加床";
                    }

                }

            };
    private CheckBox.OnCheckedChangeListener checkBoxOnCheckedChange3 =
            new CheckBox.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CB41.setChecked(false);
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        CB3 = "不需要加床";



                    } else {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        //CB4 = "";
                        CB3 = "需要加床";
                    }

                }
            };
    private CheckBox.OnCheckedChangeListener checkBoxOnCheckedChange4 =
            new CheckBox.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CB52.setChecked(false);
                    CB53.setChecked(false);
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        CB4 = "下午3點~5點";



                    } else {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        //CB4 = "";
                        //CB4 = "需要加床";
                    }
                }
            };
    private CheckBox.OnCheckedChangeListener checkBoxOnCheckedChange5 =
            new CheckBox.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CB51.setChecked(false);
                    CB53.setChecked(false);
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        CB4 = "下午5點~7點";



                    } else {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        //CB4 = "";
                        //CB4 = "需要加床";
                    }
                }
            };
    private CheckBox.OnCheckedChangeListener checkBoxOnCheckedChange6 =
            new CheckBox.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    CB52.setChecked(false);
                    CB51.setChecked(false);
                    if (isChecked)//等於 buttonView.isChecked()
                    {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被選取", Toast.LENGTH_LONG).show();
                        CB4 = "晚上7點過後";



                    } else {
                        Toast.makeText(getApplicationContext(), buttonView.getText() + " 被取消", Toast.LENGTH_LONG).show();
                        //CB4 = "";
                        //CB4 = "需要加床";
                    }
                }
            };

                private Button.OnClickListener btnAddListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase friendDb = mFriendDbOpenHelper.getWritableDatabase();

                    ContentValues newRow = new ContentValues();
                    newRow.put("name", name2.getText().toString());
                    newRow.put("phone", tyu.getText().toString());
                    newRow.put("sex", time1.getText().toString());
                    newRow.put("address", ked.getText().toString());


                    friendDb.insert(DB_TABLE, null, newRow);
                    friendDb.close();

                    String str2 = name2.getText().toString();
                    String str = time1.getText().toString();
                    String str1 = ked.getText().toString();
                    String str3 = tyu.getText().toString();
                    //i=Integer.valueOf(str).intValue();
                    String s=str;
                    String t=str1;
                    String r=str2;
                    String y=str3;
                    filename = new File("sdcard/datss.txt");
                    filename2 = new File("sdcard/datss2.txt");
                    FileOutputStream fout = null;FileOutputStream fout2 = null;
                    BufferedOutputStream  buffout = null; //////自動生成random.txt
                    BufferedOutputStream  buffout2 = null;
                    try {
                        fout = new FileOutputStream(filename, true);

                        buffout = new BufferedOutputStream(fout);

                        buffout.write(s.getBytes());
                        buffout.write("\n".getBytes());
                        buffout.close();


                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        fout2 = new FileOutputStream(filename2, true);
                        buffout2 = new BufferedOutputStream(fout2);
                        buffout2.write(t.getBytes());
                        buffout2.write("\n".getBytes());
                        buffout2.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    filename3 = new File("sdcard/datss3.txt");
                    FileOutputStream fout3 = null;
                    BufferedOutputStream  buffout3 = null;
                    try {
                        fout3 = new FileOutputStream(filename3, true);

                        buffout3 = new BufferedOutputStream(fout3);

                        buffout3.write(CB1.getBytes());
                        buffout3.write("\n".getBytes());
                        buffout3.close();


                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    filename4 = new File("sdcard/datss4.txt");
                    FileOutputStream fout4 = null;
                    BufferedOutputStream  buffout4 = null;
                    try {
                        fout4 = new FileOutputStream(filename4, true);

                        buffout4 = new BufferedOutputStream(fout4);

                        buffout4.write(CB3.getBytes());
                        buffout4.write("\n".getBytes());
                        buffout4.close();


                    }catch (Exception e) {
                        e.printStackTrace();
                    }

                    filename5 = new File("sdcard/datss5.txt");
                    FileOutputStream fout5 = null;
                    BufferedOutputStream  buffout5 = null;
                    try {
                        fout5 = new FileOutputStream(filename5, true);

                        buffout5 = new BufferedOutputStream(fout5);

                        buffout5.write(CB4.getBytes());
                        buffout5.write("\n".getBytes());
                        buffout5.close();


                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };

    /*private Button.OnClickListener btndelete1Listener = new
            Button.OnClickListener() {


                @Override
                public void onClick(View v) {
                    deleteDatabase("friends.db");
                }
            };*/
    private Button.OnClickListener btnQueryListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase friendDb = mFriendDbOpenHelper.getWritableDatabase();

                    Cursor c = null;

                    if (!name2.getText().toString().equals("")) {
                        c = friendDb.query(true, DB_TABLE, new String[]{"name","phone", "sex",
                                        "address"}, "name=" + "\"" +
                                        name2.getText().toString()
                                        + "\"", null, null, null, null,
                                null);
                    }
                    else if (!tyu.getText().toString().equals("")) {
                        c = friendDb.query(true, DB_TABLE, new String[]{"name", "phone","sex",
                                        "address"}, "phone=" + "\"" +
                                        tyu.getText().toString()
                                        + "\"", null, null, null, null,
                                null);
                    }
                    else if (!time1.getText().toString().equals("")) {
                        c = friendDb.query(true, DB_TABLE, new String[]{"name", "phone","sex",
                                        "address"}, "sex=" + "\"" +
                                        time1.getText().toString()
                                        + "\"", null, null,  null, null,
                                null);
                    }
                    else if (!ked.getText().toString().equals("")) {
                        c = friendDb.query(true, DB_TABLE, new String[]{"name","phone", "sex",
                                        "address"}, "address=" + "\"" +
                                        ked.getText().toString()
                                        + "\"", null, null, null, null,
                                null);
                    }


                    if (c == null) {
                        return;
                    }

                    if (c.getCount() == 0) {
                        txtList.setText("");
                        Toast.makeText(MainActivity3.this, "沒有這一筆資料",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        c.moveToFirst();
                        txtList.setText("姓名:" + c.getString(0) + "電話:" + c.getString(1)+"訂房日期:"+c.getString(2) + "訂房總類:" + c.getString(3));
                        while (c.moveToNext())
                            txtList.append("\n" +"姓名:" + c.getString(0)+  "電話:" + c.getString(1)+"訂房日期:"+c.getString(2) + "訂房總類:" + c.getString(3));
                    }

                    friendDb.close();

                }
            };
    private Button.OnClickListener btnListListener = new
            Button.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase friendDb = mFriendDbOpenHelper.getWritableDatabase();

                    Cursor c = friendDb.query(true, DB_TABLE, new String[]{"name","phone", "sex",
                                    "address"}, null, null, null,
                            null, null, null);

                    if (c == null)
                        return;

                    if (c.getCount() == 0) {
                        txtList.setText("");
                        Toast.makeText(MainActivity3.this, "沒有資料",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        c.moveToFirst();
                        txtList.setText("姓名:" + c.getString(0)+ "電話:" + c.getString(1)+"訂房日期:"+c.getString(2) + "訂房總類" + c.getString(3)
                        );

                        while (c.moveToNext())
                            txtList.append("\n" +"姓名:" + c.getString(0)+ "電話:" + c.getString(1)+"訂房日期:" + c.getString(2) + "訂房總類" + c.getString(3)
                            );
                    }

                    friendDb.close();

                }
            };



                private void requestStoragePermission() {
                    if (Build.VERSION.SDK_INT >= 23) {
                        int hasPermission = checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE);
                        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                            return;
                        }
                    }
                    readFile();
                }

                /**
                 * Callback for the result from requesting permissions. This method
                 * is invoked for every call on {@link #requestPermissions(String[], int)}.
                 * <p>
                 * <strong>Note:</strong> It is possible that the permissions request interaction
                 * with the user is interrupted. In this case you will receive empty permissions
                 * and results arrays which should be treated as a cancellation.
                 * </p>
                 *
                 * @param requestCode  The request code passed in {@link #requestPermissions(String[], int)}.
                 * @param permissions  The requested permissions. Never null.
                 * @param grantResults The grant results for the corresponding permissions
                 *                     which is either {@link PackageManager#PERMISSION_GRANTED}
                 *                     or {@link PackageManager#PERMISSION_DENIED}. Never null.
                 * @see #requestPermissions(String[], int)
                 */
                @Override
                public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                    if (requestCode == 1) {
                        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                            readFile();
                        } else {
                            Toast.makeText(this, "未取得授權!", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } else {
                        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                    }
                }


                int time = 0;
                int num, i;
                private Button.OnClickListener btnListener2 =
                        new Button.OnClickListener() {

                            @Override
                            public void onClick(View v) {

                            }
                        };
                int j, y;
                private Button.OnClickListener btnListener1 =
                        new Button.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                            /**
                             * Called when a view has been clicked.
                             *
                             * @param v The view that was clicked.
                             */




                        };

                private void readFile() {
                    filename = new File("sdcard/datss.txt");
                    filename2 = new File("sdcard/datss2.txt");
                    try {
                        FileInputStream fin = new FileInputStream(filename);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
                        String line = "",line2 = "", wholedate = "", wholedate2 = "";
                        while ((line = reader.readLine()) != null) {
                            wholedate = wholedate+  line + "\n";
                        }
                        login2 = wholedate.split("\n");
                        reader.close();
                        fin.close();
                    } catch (Exception e) {
                        //Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }

                    try {
                        FileInputStream fin2 = new FileInputStream(filename2);
                        BufferedReader reader2 = new BufferedReader(new InputStreamReader(fin2));
                        String line2 = "", wholedate2 = "";
                        while ((line2 = reader2.readLine()) != null) {

                            wholedate2 = wholedate2+line2 + "\n";

                        }
                        login2 = wholedate2.split("\n");

                        reader2.close();
                        fin2.close();
                    }catch (Exception e) {
                        //Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    try {
                        FileInputStream fin3 = new FileInputStream(filename3);
                        BufferedReader reader3 = new BufferedReader(new InputStreamReader(fin3));
                        String line3 = "", wholedate3 = "";
                        while ((line3 = reader3.readLine()) != null) {

                            wholedate3 = wholedate3+line3 + "\n";

                        }
                        login2 = wholedate3.split("\n");

                        reader3.close();
                        fin3.close();
                    }catch (Exception e) {
                        //Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    try {
                        FileInputStream fin4 = new FileInputStream(filename4);
                        BufferedReader reader4 = new BufferedReader(new InputStreamReader(fin4));
                        String line4 = "", wholedate4 = "";
                        while ((line4 = reader4.readLine()) != null) {

                            wholedate4 = wholedate4+line4 + "\n";

                        }
                        login2 = wholedate4.split("\n");

                        reader4.close();
                        fin4.close();
                    }catch (Exception e) {
                        //Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                    try {
                        FileInputStream fin5 = new FileInputStream(filename5);
                        BufferedReader reader5 = new BufferedReader(new InputStreamReader(fin5));
                        String line5 = "", wholedate5 = "";
                        while ((line5= reader5.readLine()) != null) {

                            wholedate5 = wholedate5+line5 + "\n";

                        }
                        login2 = wholedate5.split("\n");

                        reader5.close();
                        fin5.close();
                    }catch (Exception e) {
                        //Toast.makeText(getApplicationContext(), "error!", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                    }
                }

                ;

}


