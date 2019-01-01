package com.riotfallen.myintentapps;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MoveObjectActivity extends AppCompatActivity {

    public static String DATA_OBJECT_EXTRA = "dataObjectExtra";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_object);

        Person person = getIntent().getParcelableExtra(DATA_OBJECT_EXTRA);
        TextView textViewObject = findViewById(R.id.moveObjectActivityTextView);

        textViewObject.setText("Nama: " + person.getName() + "\nAge: " + person.getAge() + "\nEmail: "
                + person.getEmail() + "\nCity: " + person.getCity());
    }
}
