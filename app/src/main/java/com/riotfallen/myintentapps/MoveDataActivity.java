package com.riotfallen.myintentapps;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveDataActivity extends AppCompatActivity {

    public static String DATA_INT_AGE  = "dataStringAge";
    public static String DATA_STRING_NAME = "dataStringName";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_data);

        TextView textViewData = findViewById(R.id.moveDataActivityTextView);

        String name = getIntent().getStringExtra(DATA_STRING_NAME);
        int age = getIntent().getIntExtra(DATA_INT_AGE, 0);

        textViewData.setText("Your name: " + name + "\nYour Age: " + age );
    }
}
