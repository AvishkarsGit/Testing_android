package com.example.sqlapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase database = openOrCreateDatabase("testdb",MODE_PRIVATE,null);
//        database.execSQL("CREATE TABLE users(username VARCHAR, password VARCHAR);");
//        database.execSQL("INSERT INTO users VALUES('Avishkar','pass@123');");
        database.execSQL("INSERT INTO users VALUES(?,?);");
        
        Cursor result = database.rawQuery("SELECT * FROM users",null);
        result.moveToFirst();

        TextView textView = findViewById(R.id);
        String username = result.getString(0);
        String pass = result.getString(1);

        textView.setText("UserName :"+username+ " | Password :"+pass);


    }
}