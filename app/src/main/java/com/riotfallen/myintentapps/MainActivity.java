package com.riotfallen.myintentapps;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMove = findViewById(R.id.mainActivityButtonChange);
        Button buttonMoveData = findViewById(R.id.mainActivityButtonChangeWithData);
        Button buttonMoveObject = findViewById(R.id.mainActivityButtonChangeWithObject);
        Button buttonDialPhone = findViewById(R.id.mainActivityButtonChangeIntentImplicit);
        Button buttonRequestResult = findViewById(R.id.mainActivityButtonResult);

        buttonMove.setOnClickListener(this);
        buttonMoveData.setOnClickListener(this);
        buttonMoveObject.setOnClickListener(this);
        buttonDialPhone.setOnClickListener(this);
        buttonRequestResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.mainActivityButtonChange:
                intent = new Intent(MainActivity.this, MoveActivity.class);
                startActivity(intent);
                break;
            case R.id.mainActivityButtonChangeWithData:
                intent = new Intent(MainActivity.this, MoveDataActivity.class);
                intent.putExtra(MoveDataActivity.DATA_STRING_NAME, "DicodingAcademy Boy");
                intent.putExtra(MoveDataActivity.DATA_INT_AGE, 5);
                startActivity(intent);
                break;
            case R.id.mainActivityButtonChangeWithObject:
                intent = new Intent(MainActivity.this, MoveObjectActivity.class);
                Person person = new Person();
                person.setName("Dimas Maulana");
                person.setAge(23);
                person.setEmail("Dimas Maulana Dwi Saputra");
                person.setCity("Bandung");
                intent.putExtra(MoveObjectActivity.DATA_OBJECT_EXTRA, person);
                startActivity(intent);
                break;
            case R.id.mainActivityButtonChangeIntentImplicit:
                String phoneNumber = "081311351940";
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(intent);
                break;
            case R.id.mainActivityButtonResult:
                intent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == MoveForResultActivity.RESULT_CODE) {
                assert data != null;
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                Toast.makeText(MainActivity.this, "Kamu memilih: " + selectedValue, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
